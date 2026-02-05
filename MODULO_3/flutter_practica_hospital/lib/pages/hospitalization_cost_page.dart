import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class HospitalizationCostPage extends StatefulWidget {
  const HospitalizationCostPage({super.key});

  @override
  State<HospitalizationCostPage> createState() => _HospitalizationCostPageState();
}

class _HospitalizationCostPageState extends State<HospitalizationCostPage> {
  String roomType = 'General';
  String insuranceType = 'Sin seguro';
  String daysText = '';
  String dailyCostText = '';
  String resultText = '';

  void calculate() {
    final days = int.tryParse(daysText) ?? 0;
    final dailyCost = double.tryParse(dailyCostText.replaceAll(',', '.')) ?? 0.0;

    if (days <= 0) {
      setState(() => resultText = 'Ingrese una cantidad de días válida');
      return;
    }
    if (dailyCost <= 0) {
      setState(() => resultText = 'Ingrese un costo diario válido');
      return;
    }

    double roomFactor;
    switch (roomType) {
      case 'General':
        roomFactor = 1.0;
        break;
      case 'Semi-privada':
        roomFactor = 1.4;
        break;
      case 'Privada':
        roomFactor = 2.0;
        break;
      default:
        roomFactor = 1.0;
    }

    double insuranceFactor;
    double insuranceDiscountPercent;
    switch (insuranceType) {
      case 'Público':
        insuranceFactor = 0.7; // reduce 30%
        insuranceDiscountPercent = 30;
        break;
      case 'Privado':
        insuranceFactor = 0.5; // reduce 50%
        insuranceDiscountPercent = 50;
        break;
      default:
        insuranceFactor = 1.0; // sin descuento
        insuranceDiscountPercent = 0;
    }

    final subtotal = days * dailyCost * roomFactor;
    final finalTotal = subtotal * insuranceFactor;
    final discountAmount = subtotal - finalTotal;

    setState(() {
      resultText =
          'Tipo de habitación: $roomType\n'
          'Factor habitación: x${roomFactor.toStringAsFixed(2)}\n'
          'Seguro: $insuranceType\n'
          'Descuento seguro: ${insuranceDiscountPercent.toStringAsFixed(0)} %\n'
          'Días: $days\n'
          'Costo diario base: \$${dailyCost.toStringAsFixed(2)}\n'
          'Subtotal (sin seguro): \$${subtotal.toStringAsFixed(2)}\n'
          'Monto descuento: \$${discountAmount.toStringAsFixed(2)}\n'
          'Costo total: \$${finalTotal.toStringAsFixed(2)}';
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Costo de hospitalización'),
        leading: IconButton(
          icon: const Icon(Icons.arrow_back),
          onPressed: () => context.go('/'),
        ),
      ),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(16),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            const Text(
              'Cálculo de costo de hospitalización',
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 16),

            const Text('Select 1: Tipo de habitación'),
            const SizedBox(height: 8),
            DropdownButton<String>(
              value: roomType,
              isExpanded: true,
              items: const [
                DropdownMenuItem(value: 'General', child: Text('General')),
                DropdownMenuItem(value: 'Semi-privada', child: Text('Semi-Privada')),
                DropdownMenuItem(value: 'Privada', child: Text('Privada')),
              ],
              onChanged: (v) {
                if (v == null) return;
                setState(() => roomFactorSetter(v));
              },
            ),

            const SizedBox(height: 12),
            const Text('Select 2: Seguro médico'),
            const SizedBox(height: 8),
            DropdownButton<String>(
              value: insuranceType,
              isExpanded: true,
              items: const [
                DropdownMenuItem(value: 'Público', child: Text('Público')),
                DropdownMenuItem(value: 'Privado', child: Text('Privado')),
                DropdownMenuItem(value: 'Sin seguro', child: Text('Sin seguro')),
              ],
              onChanged: (v) {
                if (v == null) return;
                setState(() => insuranceType = v);
              },
            ),

            const SizedBox(height: 12),
            const Text('Input 1: Días de hospitalización'),
            const SizedBox(height: 8),
            TextField(
              decoration: const InputDecoration(
                labelText: 'Días de hospitalización',
                border: OutlineInputBorder(),
              ),
              keyboardType: TextInputType.number,
              onChanged: (v) => daysText = v,
            ),

            const SizedBox(height: 12),
            const Text('Input 2: Costo diario base'),
            const SizedBox(height: 8),
            TextField(
              decoration: const InputDecoration(
                labelText: 'Costo diario base (\$)',
                border: OutlineInputBorder(),
              ),
              keyboardType: const TextInputType.numberWithOptions(decimal: true),
              onChanged: (v) => dailyCostText = v,
            ),

            const SizedBox(height: 16),
            ElevatedButton(onPressed: calculate, child: const Text('Calcular')),
            const SizedBox(height: 16),
            Text(resultText),
          ],
        ),
      ),
    );
  }

  // helper to keep assignment explicit for the select 1
  void roomFactorSetter(String value) {
    roomType = value;
  }
}

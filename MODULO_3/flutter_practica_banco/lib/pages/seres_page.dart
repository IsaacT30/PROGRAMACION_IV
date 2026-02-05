import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class SeresPage extends StatefulWidget {
  const SeresPage({super.key});

  @override
  State<SeresPage> createState() => _SeresPageState();
}

class _SeresPageState extends State<SeresPage> {
  String licenseStatus = 'No';
  String resultText = '';

  String ageText = '';

  void calculateLicenseStatus() {
    final age = int.tryParse(ageText) ?? -1;

    setState(() {
      if (age < 0) {
        resultText = 'Ingrese una edad válida';
      } else if (age < 18) {
        resultText = 'Es menor de edad y no tiene licencia.';
      } else {
        if (licenseStatus == 'Sí') {
          resultText = 'Es mayor de edad y tiene licencia para realizar transacciones.';
        } else {
          resultText = 'Es mayor de edad y debe tener licencia para realizar transacciones.';
        }
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Comisión de cajero'),
        leading: IconButton(
          icon: const Icon(Icons.arrow_back),
          onPressed: () => context.go('/'),
        ),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            const Text(
              'Estado de licencia',
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 16),

            TextField(
              decoration: const InputDecoration(
                labelText: 'Edad',
                border: OutlineInputBorder(),
              ),
              keyboardType: TextInputType.number,
              onChanged: (value) {
                ageText = value;
              },
            ),

            const SizedBox(height: 16),

            DropdownButton<String>(
              value: licenseStatus,
              isExpanded: true,
              items: const [
                DropdownMenuItem(
                  value: 'Sí',
                  child: Text('Sí, tengo licencia'),
                ),
                DropdownMenuItem(
                  value: 'No',
                  child: Text('No tengo licencia'),
                ),
              ],
              onChanged: (value) {
                if (value == null) return;
                setState(() {
                  licenseStatus = value;
                });
              },
            ),

            const SizedBox(height: 16),
            ElevatedButton(
              onPressed: calculateLicenseStatus,
              child: const Text('Calcular'),
            ),

            const SizedBox(height: 16),
            Text(resultText),
          ],
        ),
      ),
    );
  }
}

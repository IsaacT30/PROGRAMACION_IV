import 'package:flutter/material.dart';

class MenuCalculatorPage extends StatefulWidget {
  const MenuCalculatorPage({Key? key}) : super(key: key);

  @override
  State<MenuCalculatorPage> createState() => _MenuCalculatorPageState();
}

class _MenuCalculatorPageState extends State<MenuCalculatorPage> {  
  final TextEditingController _platesQtyController = TextEditingController(text: '1');
  final TextEditingController _drinksQtyController = TextEditingController(text: '1');
  final TextEditingController _sidesQtyController = TextEditingController(text: '1');

  String _selectedPlate = 'Pollo';
  String _selectedDrink = 'Gaseosa';
  String _selectedSide = 'Papas';

  String _errorMessage = '';

  final Map<String, double> _platePrices = {
    'Pollo': 6.0,
    'Carne': 7.0,
    'Vegetariano': 5.0,
  };

  final Map<String, double> _drinkPrices = {
    'Gaseosa': 2.0,
    'Jugo': 3.0,
    'Agua': 1.0,
  };

  final Map<String, double> _sidePrices = {
    'Papas': 2.0,
    'Ensalada': 2.5,
    'Pan': 1.5,
  };

  double? _platesSubtotal;
  double? _drinksSubtotal;
  double? _sidesSubtotal;
  double? _total;

  void _calculate() {
    setState(() {
      _errorMessage = '';
      _platesSubtotal = null;
      _drinksSubtotal = null;
      _sidesSubtotal = null;
      _total = null;

      final int? platesQty = int.tryParse(_platesQtyController.text);
      final int? drinksQty = int.tryParse(_drinksQtyController.text);
      final int? sidesQty = int.tryParse(_sidesQtyController.text);

      if (platesQty == null || drinksQty == null || sidesQty == null) {
        _errorMessage = 'Ingrese cantidades válidas para todas las categorías';
        return;
      }

      if (platesQty <= 0 || drinksQty <= 0 || sidesQty <= 0) {
        _errorMessage = 'Ingrese cantidades mayores a 0 en todas las categorías';
        return;
      }

      final double platePrice = _platePrices[_selectedPlate]!;
      final double drinkPrice = _drinkPrices[_selectedDrink]!;
      final double sidePrice = _sidePrices[_selectedSide]!;

      _platesSubtotal = platePrice * platesQty;
      _drinksSubtotal = drinkPrice * drinksQty;
      _sidesSubtotal = sidePrice * sidesQty;

      _total = _platesSubtotal! + _drinksSubtotal! + _sidesSubtotal!;
    });
  }

  @override
  void dispose() {
    _platesQtyController.dispose();
    _drinksQtyController.dispose();
    _sidesQtyController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Calculadora de Combos')),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(16),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            const Text('Plato principal', style: TextStyle(fontWeight: FontWeight.bold)),
            const SizedBox(height: 8),
            Row(
              children: [
                Expanded(
                  child: DropdownButton<String>(
                    value: _selectedPlate,
                    isExpanded: true,
                    onChanged: (v) {
                      if (v == null) return;
                      setState(() => _selectedPlate = v);
                    },
                    items: _platePrices.keys.map((k) => DropdownMenuItem(value: k, child: Text('$k (\$${_platePrices[k]!.toStringAsFixed(2)})'))).toList(),
                  ),
                ),
                const SizedBox(width: 12),
                SizedBox(
                  width: 100,
                  child: TextField(
                    controller: _platesQtyController,
                    keyboardType: TextInputType.number,
                    decoration: const InputDecoration(labelText: 'Cantidad'),
                  ),
                ),
              ],
            ),

            const SizedBox(height: 16),
            const Text('Bebida', style: TextStyle(fontWeight: FontWeight.bold)),
            const SizedBox(height: 8),
            Row(
              children: [
                Expanded(
                  child: DropdownButton<String>(
                    value: _selectedDrink,
                    isExpanded: true,
                    onChanged: (v) {
                      if (v == null) return;
                      setState(() => _selectedDrink = v);
                    },
                    items: _drinkPrices.keys.map((k) => DropdownMenuItem(value: k, child: Text('$k (\$${_drinkPrices[k]!.toStringAsFixed(2)})'))).toList(),
                  ),
                ),
                const SizedBox(width: 12),
                SizedBox(
                  width: 100,
                  child: TextField(
                    controller: _drinksQtyController,
                    keyboardType: TextInputType.number,
                    decoration: const InputDecoration(labelText: 'Cantidad'),
                  ),
                ),
              ],
            ),

            const SizedBox(height: 16),
            const Text('Acompañamiento', style: TextStyle(fontWeight: FontWeight.bold)),
            const SizedBox(height: 8),
            Row(
              children: [
                Expanded(
                  child: DropdownButton<String>(
                    value: _selectedSide,
                    isExpanded: true,
                    onChanged: (v) {
                      if (v == null) return;
                      setState(() => _selectedSide = v);
                    },
                    items: _sidePrices.keys.map((k) => DropdownMenuItem(value: k, child: Text('$k (\$${_sidePrices[k]!.toStringAsFixed(2)})'))).toList(),
                  ),
                ),
                const SizedBox(width: 12),
                SizedBox(
                  width: 100,
                  child: TextField(
                    controller: _sidesQtyController,
                    keyboardType: TextInputType.number,
                    decoration: const InputDecoration(labelText: 'Cantidad'),
                  ),
                ),
              ],
            ),

            const SizedBox(height: 20),
            ElevatedButton(onPressed: _calculate, child: const Text('Calcular total')),
            const SizedBox(height: 20),

            if (_errorMessage.isNotEmpty) Text(_errorMessage, style: const TextStyle(color: Colors.red)),

            if (_platesSubtotal != null) ...[
              _buildResultRow('Subtotal platos:', '\$${_platesSubtotal!.toStringAsFixed(2)}'),
              _buildResultRow('Subtotal bebidas:', '\$${_drinksSubtotal!.toStringAsFixed(2)}'),
              _buildResultRow('Subtotal acompañamientos:', '\$${_sidesSubtotal!.toStringAsFixed(2)}'),
              const Divider(),
              _buildResultRow('Total general:', '\$${_total!.toStringAsFixed(2)}'),
            ],
          ],
        ),
      ),
    );
  }

  Widget _buildResultRow(String label, String value) {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 6),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          Text(label, style: const TextStyle(fontWeight: FontWeight.w600)),
          Text(value),
        ],
      ),
    );
  }
}

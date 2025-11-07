import 'package:flutter/material.dart';

void main() {
  runApp(
    MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: const Text('Hola Flutter desde 4to Semestre')),
        body: const Center(
          child: Text(
            '¡Hola Mundo from 4to semestre! 😊',
            style: TextStyle(fontSize: 30),
          ),
        ),
      ),
    ),
  );
}
void main() {
  final HistoriaClinica isaac = HistoriaClinica(peso: 70.0, perdidaPeso: 2.5);
  print("Peso inicial + pérdida: ${isaac.suma()} kg");
  print("Peso inicial - pérdida: ${isaac.resta()} kg");
  print("Peso multiplicado por 2: ${isaac.multiplicacion()} kg");
  print("Peso dividido por 2: ${isaac.division()} kg");
}

class HistoriaClinica {
  double peso = 0.0;
  double perdidaPeso = 0.0;

  HistoriaClinica({required this.peso, required this.perdidaPeso});

  double suma() {
    return this.peso + this.perdidaPeso;
  }

  double resta() {
    return this.peso - this.perdidaPeso;
  }

  double multiplicacion() {
    return this.peso * 2;
  }

  double division() {
    return this.peso / 2;
  }
}

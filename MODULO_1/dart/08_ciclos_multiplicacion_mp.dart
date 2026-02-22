void main() {
  int numPacientes = 4;
  int citasPorPaciente = 3;
  double sumaEdades = 0;

  List<int> edades = [28, 35, 40, 22];

  for (int i = 0; i < numPacientes; i++) {
    sumaEdades += edades[i];
  }
  print("La suma de las edades de los $numPacientes pacientes es $sumaEdades");

  for (int i = 1; i <= citasPorPaciente; i++) {
    print("Cita $i de cada paciente programada");
  }
}

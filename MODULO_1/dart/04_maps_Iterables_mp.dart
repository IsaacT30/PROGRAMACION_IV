void main() {
  print("Maps Iterables en Historias Clínicas");

  final edadesPacientes = [28, 35, 40, 28, 35, 50, 50, 60, 60, 22, 30, 28];

  print("Lista de edades original: $edadesPacientes");
  print("Cantidad de pacientes: ${edadesPacientes.length}");
  print("Edad del paciente en índice 4: ${edadesPacientes[4]}");
  print("Edad del primer paciente: ${edadesPacientes.first}");

  final edadesReversas = edadesPacientes.reversed;

  print("Edades en reversa (Iterable): $edadesReversas");
  print("Como lista: ${edadesReversas.toList()}");
  print("Como set (únicas edades): ${edadesReversas.toSet()}");
}

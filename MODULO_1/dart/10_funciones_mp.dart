void main() {
  print(greetEveryone());
  print(sumarEdades(28, 35));
  print(sumarEdadesOpcional(40, 22));
  print(sumarEdadesOpcional(30));
  print(saludarPaciente(name: "Torres", message: "Bienvenido"));
  print(saludarPaciente(name: "Ana Torres"));
}

String greetEveryone() => 'Bienvenidos a Historias Clínicas';

int sumarEdades(int edad1, int edad2) => edad1 + edad2;

int sumarEdadesOpcional(int edad1, [int edad2 = 0]) {
  return edad1 + edad2;
}

String saludarPaciente({required String name, String message = "Hola"}) {
  return '$message $name';
}

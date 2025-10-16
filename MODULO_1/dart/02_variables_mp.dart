void main() {
  print("Tipos de variables en Historias Clínicas");
  
  final String paciente = "Isaac Torres";
  print(paciente);
  
  String medico = 'Alejandro Torres';
  medico = "Juan Torres";
  print(medico);

  const String diagnostico = "Gripe común";
  print("Diagnóstico: $diagnostico");
  
  bool asegurado = true;
  asegurado = false;
  print("¿Tiene seguro?: $asegurado");
  
  int edad = 28;
  print("Edad del paciente: $edad");
  
  List<String> sintomas = ["Fiebre", "Dolor de cabeza"];
  print("Síntomas: $sintomas");
  
  final medicamentos = <String>["Paracetamol", "Agua y reposo"];
  print("Tratamiento: $medicamentos");

  print('''
  Paciente: $paciente
  Médico: $medico
  Diagnóstico: $diagnostico
  Asegurado: $asegurado
  Edad: $edad
  Síntomas: $sintomas
  Medicamentos: $medicamentos
  ''');
}

void main() {
  final Paciente isaac = Paciente(name: 'Isaac Torres', diagnostico: 'Gripe común');
  print(isaac);
  print(isaac.name);
  print(isaac.diagnostico);

  final Paciente ana = Paciente(name: 'Ana Torres'); // sin diagnóstico
  print(ana);
  print(ana.name);
  print(ana.diagnostico);
}

class Paciente {
  String name = "";
  String diagnostico = "";
  
  Paciente({required this.name, this.diagnostico = "sin diagnóstico"});
  
  @override
  String toString() {
    return "$name - $diagnostico";
  }
}

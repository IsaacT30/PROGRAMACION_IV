void main() {
  print("Mapas en Historias Clínicas");

  final Map<String, dynamic> historiaClinica = {
    'nombre': 'Isaac Torres',
    'edad': 28,
    'asegurado': true,
    'diagnosticos': <String>['Gripe común', 'Dolor muscular'],
    'archivos': {
      1: 'src/isaac_examen1.jpg',
      2: 'src/isaac_examen2.jpg',
    }
  };

  print(historiaClinica);
  print(historiaClinica['nombre']);
  print(historiaClinica['archivos']);
  print(historiaClinica['asegurado']);
}

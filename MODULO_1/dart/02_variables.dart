void main() {
  print("Tipos de variables en dart");
  
  final String pokemon = "Ditto";
  
  print(pokemon);
  
  String myName = 'Fransisco';
  myName="Higuera";
  print(myName);

  const String elemento = "Fuego";
  print("elemento: $elemento");
  
  bool active = false;
  active = false;
  
  print("Es activo: $active");
  int hp= 100;
  print("Cabellos de fuerza: $hp");
  List < String > abilites = ["impostor", "correciion"];
  print("habilidades $abilites");
  
  final sprites = < String >  ["src.image.jpg", "image2"];
  print("Imagenes $sprites");

  print('''
  $pokemon
  $myName
  $elemento
  $active
  $hp
  $abilites
  $sprites
  ''');
  
}


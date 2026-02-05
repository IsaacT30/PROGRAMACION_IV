void main() {
  int edadIsaac = 28;

  if (edadIsaac > 18) {
    print('Isaac Torres es adulto');
  }
  if (edadIsaac < 18) {
    print('Isaac Torres es menor de edad');
  }
  if (edadIsaac == 18) {
    print('Isaac Torres tiene 18 años');
  }

  if (edadIsaac > 18) {
    print('Isaac Torres es mayor de edad');
  } else {
    print('Isaac Torres es menor o igual a 18 años');
  }

  if (edadIsaac == 18) {
    print('Isaac Torres tiene 18 años');
  } else {
    print('Isaac Torres no tiene 18 años');
  }

  int edadAlejandro = 16;

  if (edadAlejandro > 18) {
    print("Alejandro Torres es adulto");
  } else if (edadAlejandro < 18) {
    print("Alejandro Torres es menor de edad");
  } else {
    print("Alejandro Torres tiene 18 años");
  }

  int edadAna = 22;

  String descripcionEdadAna = edadAna >= 18 ? 'Ana Torres es adulta' : 'Ana Torres es menor';
  print(descripcionEdadAna);
}

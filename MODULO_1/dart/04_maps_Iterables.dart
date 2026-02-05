void main() {
  print("Maps Iterables");

  final numbers = [1, 2, 3, 3, 5, 5, 5, 7, 7, 8, 9, 18];


  print("Lista original: $numbers");
  print("Tamaño: ${numbers.length}");
  print("Índice 4: ${numbers[4]}");
  print("Primer elemento: ${numbers.first}");

  final reversedNumbers = numbers.reversed;

  print("Reverso de números (Iterable): $reversedNumbers");
  print("List: ${reversedNumbers.toList()}");
  print("Set: ${reversedNumbers.toSet()}");
}
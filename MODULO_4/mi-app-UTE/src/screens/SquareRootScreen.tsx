import { useState } from "react";
import {
  KeyboardAvoidingView,
  Platform,
  Pressable,
  StyleSheet,
  Text,
  TextInput,
  View,
} from "react-native";

export function SquareRootScreen() {
  const [a, setA] = useState("");
  const [b, setB] = useState("");
  const [c, setC] = useState("");
  const [result, setResult] = useState<string>("");

  const bg = "#0d1117";
  const card = "#161b22";
  const border = "#30363d";
  const text = "#c9d1d9";
  const primary = "#58a6ff";
  const success = "#3fb950";

  function calculate() {
    const numA = parseFloat(a);
    const numB = parseFloat(b);
    const numC = parseFloat(c);

    if (isNaN(numA) || isNaN(numB) || isNaN(numC)) {
      setResult("Por favor ingresa valores numéricos válidos");
      return;
    }

    // Fórmula: √((a + b + c) / 3)
    const sum = numA + numB + numC;
    const average = sum / 3;
    const squareRoot = Math.sqrt(average);

    setResult(`√((${numA} + ${numB} + ${numC}) / 3) = √(${sum} / 3) = √${average.toFixed(2)} = ${squareRoot.toFixed(4)}`);
  }

  function clear() {
    setA("");
    setB("");
    setC("");
    setResult("");
  }

  return (
    <KeyboardAvoidingView
      style={{ flex: 1, backgroundColor: bg }}
      behavior={Platform.OS === "ios" ? "padding" : undefined}
    >
      <View style={styles.container}>
        <Text style={[styles.title, { color: primary }]}>Raíz Cuadrada</Text>
        <Text style={[styles.subtitle, { color: text }]}>
          Fórmula: √((a + b + c) / 3)
        </Text>

        <View style={[styles.card, { backgroundColor: card, borderColor: border }]}>
          <Text style={[styles.label, { color: text }]}>Valor A</Text>
          <TextInput
            value={a}
            onChangeText={setA}
            placeholder="Ingresa el primer valor"
            placeholderTextColor="#8b949e"
            keyboardType="numeric"
            style={[
              styles.input,
              { backgroundColor: card, borderColor: border, color: text },
            ]}
          />

          <Text style={[styles.label, { color: text, marginTop: 10 }]}>Valor B</Text>
          <TextInput
            value={b}
            onChangeText={setB}
            placeholder="Ingresa el segundo valor"
            placeholderTextColor="#8b949e"
            keyboardType="numeric"
            style={[
              styles.input,
              { backgroundColor: card, borderColor: border, color: text },
            ]}
          />

          <Text style={[styles.label, { color: text, marginTop: 10 }]}>Valor C</Text>
          <TextInput
            value={c}
            onChangeText={setC}
            placeholder="Ingresa el tercer valor"
            placeholderTextColor="#8b949e"
            keyboardType="numeric"
            style={[
              styles.input,
              { backgroundColor: card, borderColor: border, color: text },
            ]}
          />

          <Pressable
            style={[styles.btn, { borderColor: primary }]}
            onPress={calculate}
          >
            <Text style={[styles.btnText, { color: primary }]}>Calcular</Text>
          </Pressable>

          <Pressable style={[styles.btnGhost, { borderColor: border }]} onPress={clear}>
            <Text style={[styles.btnText, { color: text }]}>Limpiar</Text>
          </Pressable>

          {result ? (
            <View style={[styles.resultBox, { backgroundColor: "#1f2937", borderColor: success }]}>
              <Text style={[styles.resultLabel, { color: success }]}>Resultado:</Text>
              <Text style={[styles.resultText, { color: text }]}>{result}</Text>
            </View>
          ) : null}
        </View>
      </View>
    </KeyboardAvoidingView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 16,
    justifyContent: "center",
  },
  title: {
    fontWeight: "900",
    fontSize: 22,
    marginBottom: 4,
  },
  subtitle: {
    fontSize: 14,
    marginBottom: 10,
    opacity: 0.8,
  },
  card: {
    borderWidth: 1,
    borderRadius: 12,
    padding: 14,
  },
  label: {
    fontWeight: "800",
    opacity: 0.9,
    marginBottom: 6,
  },
  input: {
    borderWidth: 1,
    borderRadius: 10,
    paddingVertical: 10,
    paddingHorizontal: 12,
  },
  btn: {
    marginTop: 14,
    backgroundColor: "#21262d",
    borderWidth: 1,
    borderRadius: 10,
    paddingVertical: 10,
    paddingHorizontal: 14,
    alignItems: "center",
  },
  btnGhost: {
    marginTop: 10,
    backgroundColor: "transparent",
    borderWidth: 1,
    borderRadius: 10,
    paddingVertical: 10,
    paddingHorizontal: 14,
    alignItems: "center",
  },
  btnText: {
    fontWeight: "900",
  },
  resultBox: {
    marginTop: 16,
    borderWidth: 1,
    borderRadius: 10,
    padding: 12,
  },
  resultLabel: {
    fontWeight: "900",
    fontSize: 16,
    marginBottom: 6,
  },
  resultText: {
    fontSize: 14,
    lineHeight: 20,
  },
});

import React from "react";
import {StyleSheet,Switch,Text,TextInput,TouchableOpacity,View,} from "react-native";
export default function MathPaymentScreen() {
  const [montoBase, setMontoBase] = React.useState("1000");
  const [mesesAtraso, setMesesAtraso] = React.useState("0");
  const [clienteFrecuente, setClienteFrecuente] = React.useState(false);
  const [metodoPago, setMetodoPago] = React.useState<
    "efectivo" | "tarjeta" | "transferencia"
  >("efectivo");

  const monto = Number(montoBase || 0);
  const meses = Number(mesesAtraso || 0);

  const resultado = React.useMemo(() => {
    const recargo = monto * 0.02 * meses;

    const descuento = clienteFrecuente ? monto * 0.1 : 0;

    let ajusteMetodo = 0;
    if (metodoPago === "tarjeta") {
      ajusteMetodo = monto * 0.03;
    } else if (metodoPago === "transferencia") {
      ajusteMetodo = monto * -0.02;
    }

    const subtotal = monto;
    const total = subtotal + recargo + ajusteMetodo - descuento;

    return { subtotal, recargo, descuento, ajusteMetodo, total };
  }, [monto, meses, clienteFrecuente, metodoPago]);

  const money = (n: number) => n.toFixed(2);

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Math 3 — Total con Recargos y Descuentos</Text>
      <Text style={styles.subtitle}>
        total = monto + recargo + ajuste - descuento
      </Text>

      <View style={styles.card}>
        <Text style={styles.label}>Monto base ($)</Text>
        <TextInput
          value={montoBase}
          onChangeText={setMontoBase}
          keyboardType="numeric"
          style={styles.input}
        />

        <Text style={styles.label}>Meses de atraso</Text>
        <TextInput
          value={mesesAtraso}
          onChangeText={setMesesAtraso}
          keyboardType="numeric"
          style={styles.input}
        />

        <View style={styles.switchRow}>
          <Text style={styles.label}>Cliente frecuente</Text>
          <Switch
            value={clienteFrecuente}
            onValueChange={setClienteFrecuente}
            trackColor={{ false: "#ccc", true: "#4CAF50" }}
            thumbColor={clienteFrecuente ? "#2E7D32" : "#f4f3f4"}
          />
        </View>

        <Text style={styles.label}>Método de pago</Text>
        <View style={styles.buttonGroup}>
          <TouchableOpacity
            style={[
              styles.button,
              metodoPago === "efectivo" && styles.buttonActive,
            ]}
            onPress={() => setMetodoPago("efectivo")}
          >
            <Text
              style={[
                styles.buttonText,
                metodoPago === "efectivo" && styles.buttonTextActive,
              ]}
            >
              Efectivo (0%)
            </Text>
          </TouchableOpacity>

          <TouchableOpacity
            style={[
              styles.button,
              metodoPago === "tarjeta" && styles.buttonActive,
            ]}
            onPress={() => setMetodoPago("tarjeta")}
          >
            <Text
              style={[
                styles.buttonText,
                metodoPago === "tarjeta" && styles.buttonTextActive,
              ]}
            >
              Tarjeta (+3%)
            </Text>
          </TouchableOpacity>

          <TouchableOpacity
            style={[
              styles.button,
              metodoPago === "transferencia" && styles.buttonActive,
            ]}
            onPress={() => setMetodoPago("transferencia")}
          >
            <Text
              style={[
                styles.buttonText,
                metodoPago === "transferencia" && styles.buttonTextActive,
              ]}
            >
              Transferencia (-2%)
            </Text>
          </TouchableOpacity>
        </View>
      </View>

      <View style={styles.card}>
        <Text style={styles.rline}>Subtotal: ${money(resultado.subtotal)}</Text>
        <Text style={styles.rline}>
          Recargo (mora): +${money(resultado.recargo)}
        </Text>
        <Text style={styles.rline}>
          Descuento: -${money(resultado.descuento)}
        </Text>
        <Text style={styles.rline}>
          Ajuste método: {resultado.ajusteMetodo >= 0 ? "+" : ""}$
          {money(resultado.ajusteMetodo)}
        </Text>
        <Text style={styles.total}>TOTAL: ${money(resultado.total)}</Text>
        <Text style={styles.muted}>
          Los valores se actualizan en tiempo real.
        </Text>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, padding: 16, backgroundColor: "#f6f7fb" },
  title: { fontSize: 22, fontWeight: "900" },
  subtitle: { marginTop: 4, color: "#555", fontWeight: "700" },
  card: {
    backgroundColor: "white",
    padding: 14,
    borderRadius: 14,
    borderWidth: 1,
    borderColor: "rgba(0,0,0,.10)",
    marginTop: 12,
  },
  label: { marginTop: 8, color: "#666", fontWeight: "800" },
  input: {
    marginTop: 6,
    backgroundColor: "#fff",
    paddingHorizontal: 12,
    paddingVertical: 10,
    borderRadius: 12,
    borderWidth: 1,
    borderColor: "rgba(0,0,0,.10)",
  },
  switchRow: {
    flexDirection: "row",
    justifyContent: "space-between",
    alignItems: "center",
    marginTop: 12,
    marginBottom: 4,
  },
  buttonGroup: {
    marginTop: 8,
    gap: 8,
  },
  button: {
    paddingVertical: 12,
    paddingHorizontal: 16,
    borderRadius: 12,
    borderWidth: 2,
    borderColor: "rgba(0,0,0,.10)",
    backgroundColor: "#fff",
    alignItems: "center",
  },
  buttonActive: {
    borderColor: "#1976d2",
    backgroundColor: "#E3F2FD",
  },
  buttonText: {
    fontSize: 14,
    fontWeight: "700",
    color: "#666",
  },
  buttonTextActive: {
    color: "#1976d2",
  },
  rline: { fontWeight: "800", marginTop: 6 },
  total: { fontWeight: "900", marginTop: 10, fontSize: 18, color: "#1976d2" },
  muted: { marginTop: 8, color: "#999", fontSize: 12, fontStyle: "italic" },
});

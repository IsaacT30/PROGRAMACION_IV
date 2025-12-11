import React from "react";
import { View, Text, Button, StyleSheet } from "react-native";

export default function HomeScreen({ navigation }: any) {
  return (
    <View style={styles.container}>
      <Text style={styles.title}>🏠 Home Screen</Text>
      <Button title="Ir a Detalles" onPress={() => navigation.navigate("Details")} />
      <Button title="Ir a Configuración" onPress={() => navigation.navigate("Settings")} />
      <Button title="Ver Pacientes" onPress={() => navigation.navigate("Patients")} />
      <Button title="Historias clínicas" onPress={() => navigation.navigate("HistorialList")} />
      <Button title="Abrir cámara" onPress={() => navigation.navigate("Camera")} />
      <Button title="Archivos" onPress={() => navigation.navigate("Files")} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
    backgroundColor: "#0d1117",
  },
  title: {
    fontSize: 24,
    color: "#58a6ff",
    marginBottom: 20,
  },
});
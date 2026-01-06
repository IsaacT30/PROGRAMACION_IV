import { StatusBar } from "expo-status-bar";
import { StyleSheet, Text, View } from "react-native";

import { Parte05Lab } from "./src/screens/Parte05Lab";
import { Parte06Lab } from "./src/screens/Parte06Lab";
import { Parte07Lab } from "./src/screens/Parte07Lab";
import { Parte08Lab } from "./src/screens/Parte08Lab";

export default function App() {
  return (
    <>
      <Parte08Lab />
      <StatusBar style="light" />
    </>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#0d1117",
    alignItems: "center",
    justifyContent: "center",
    padding: 16,
  },
  texto: {
    flex: 1,
    color: "#ffffff",
    backgroundColor: "#0d1117",
    alignItems: "center",
    justifyContent: "center",
    fontSize: 18,
  },
});
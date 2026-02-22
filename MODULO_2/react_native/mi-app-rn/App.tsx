import React from "react";
import { View, Text, Button } from "react-native";
import Saludo from "./src/components/Saludo";
import SaludoProps from "./src/components/SaludoProps";
import Contador from "./src/components/Contador";
import Caja from "./src/components/Caja";
import Perfil from "./src/components/Perfil";

export default function App() {
  return (
    <View style={{ flex: 1, justifyContent: "center", alignItems: "center", backgroundColor: "#0d1117" }}>
      <Saludo />
      <Contador />
      <SaludoProps nombre="Isaac Torres" />
      <Caja />
      <Perfil />
    </View>
  );
}
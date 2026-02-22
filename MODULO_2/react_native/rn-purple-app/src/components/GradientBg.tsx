import React from "react";
import { LinearGradient } from "expo-linear-gradient";
import { View, StyleSheet } from "react-native"; // Asegúrate de importar `StyleSheet` correctamente
import { gradientPurple } from "../theme/gradients"; // Importa correctamente el gradiente
import WaveSvg from "./WaveSvg";

export default function GradientBg({ children }: { children: React.ReactNode }) {
  return (
    <View style={{ flex: 1, backgroundColor: "#0b0620" }}>
      <LinearGradient
        colors={gradientPurple.colors} // Usando los colores de gradientPurple
        start={gradientPurple.start} // Usando las coordenadas de inicio
        end={gradientPurple.end}     // Usando las coordenadas de fin
        style={StyleSheet.absoluteFillObject} // Usa StyleSheet para manejar el estilo
      />
      <WaveSvg opacity={0.35} />
      {children}
    </View>
  );
}
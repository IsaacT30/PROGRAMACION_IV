
import React, { useEffect, useState } from "react";
import { View, Text, Pressable, ActivityIndicator, Platform } from "react-native";
import * as Location from "expo-location";
import MapView, { Marker, PROVIDER_GOOGLE } from "react-native-maps";

type Coord = { latitude: number; longitude: number };

export default function LocationScreen() {
  const [coord, setCoord] = useState<Coord | null>(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    (async () => {
      setLoading(true);
      setError(null);
      const { status } = await Location.requestForegroundPermissionsAsync();
      if (status !== "granted") {
        setError("Permiso de ubicación denegado");
        setLoading(false);
        return;
      }
      try {
        const pos = await Location.getCurrentPositionAsync({ accuracy: Location.Accuracy.Balanced });
        setCoord({ latitude: pos.coords.latitude, longitude: pos.coords.longitude });
      } catch (e: any) {
        setError(e.message ?? "No se pudo obtener ubicación");
      } finally {
        setLoading(false);
      }
    })();
  }, []);

  if (loading) {
    return (
      <View style={{ flex: 1, backgroundColor: "#0d1117", alignItems: "center", justifyContent: "center" }}>
        <ActivityIndicator color="#58a6ff" size="large" />
        <Text style={{ color: "#c9d1d9", marginTop: 8 }}>Obteniendo ubicación...</Text>
      </View>
    );
  }

  if (error || !coord) {
    return (
      <View style={{ flex: 1, backgroundColor: "#0d1117", alignItems: "center", justifyContent: "center", padding: 16 }}>
        <Text style={{ color: "#f85149", marginBottom: 10 }}>{error ?? "Sin coordenadas"}</Text>
        <Pressable onPress={() => Platform.OS === "android" ? Location.enableNetworkProviderAsync() : null} style={{ borderColor: "#58a6ff", borderWidth: 1, padding: 10, borderRadius: 8 }}>
          <Text style={{ color: "#58a6ff" }}>Intentar habilitar proveedor</Text>
        </Pressable>
      </View>
    );
  }

  return (
    <View style={{ flex: 1, backgroundColor: "#0d1117" }}>
      <MapView
        provider={PROVIDER_GOOGLE}
        style={{ flex: 1 }}
        initialRegion={{
          ...coord,
          latitudeDelta: 0.01,
          longitudeDelta: 0.01,
        }}
      >
        <Marker coordinate={coord} title="Tu ubicación" />
      </MapView>
      <View style={{ position: "absolute", top: 16, left: 16, backgroundColor: "#161b22cc", padding: 10, borderRadius: 8 }}>
        <Text style={{ color: "#c9d1d9" }}>Lat: {coord.latitude.toFixed(6)}</Text>
        <Text style={{ color: "#c9d1d9" }}>Lng: {coord.longitude.toFixed(6)}</Text>
      </View>
    </View>
  );
}
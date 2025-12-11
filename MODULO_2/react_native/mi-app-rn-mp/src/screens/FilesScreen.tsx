import React, { useState } from "react";
import { View, Text, Image, ScrollView, Pressable } from "react-native";
import * as ImagePicker from "expo-image-picker";
const DocumentPicker = require("expo-document-picker") as any;

export default function FilesScreen() {
  const [images, setImages] = useState<string[]>([]);
  const [doc, setDoc] = useState<{ name: string; uri: string } | null>(null);

  const pickFromGallery = async () => {
    const { status } = await ImagePicker.requestMediaLibraryPermissionsAsync();
    if (status !== "granted") { alert("Permiso de galería denegado"); return; }

    const res = await ImagePicker.launchImageLibraryAsync({
      allowsMultipleSelection: true,
      quality: 0.8,
      mediaTypes: ImagePicker.MediaTypeOptions.Images,
    });
    if (!res.canceled) {
      const uris = res.assets?.map((a) => a.uri) ?? [];
      setImages(uris);
    }
  };

  const pickDocument = async () => {
    const res = await DocumentPicker.getDocumentAsync({ multiple: false, copyToCacheDirectory: true });
    if (res.type === "success") {
      setDoc({ name: res.name, uri: res.uri });
    }
  };

  return (
    <ScrollView style={{ flex: 1, backgroundColor: "#0d1117" }} contentContainerStyle={{ padding: 16 }}>
      <Text style={{ color: "#58a6ff", fontSize: 20, marginBottom: 12 }}>Galería</Text>
      <Pressable onPress={pickFromGallery} style={{ borderColor: "#58a6ff", borderWidth: 1, padding: 10, borderRadius: 8, marginBottom: 12 }}>
        <Text style={{ color: "#58a6ff" }}>Seleccionar imágenes</Text>
      </Pressable>

      {images.length === 0 ? (
        <Text style={{ color: "#8b949e" }}>No hay imágenes seleccionadas.</Text>
      ) : (
        <View style={{ flexDirection: "row", flexWrap: "wrap", gap: 8 }}>
          {images.map((uri) => (
            <Image key={uri} source={{ uri }} style={{ width: 110, height: 110, borderRadius: 10 }} />
          ))}
        </View>
      )}

      <View style={{ height: 24 }} />

      <Text style={{ color: "#58a6ff", fontSize: 20, marginBottom: 12 }}>Documento</Text>
      <Pressable onPress={pickDocument} style={{ borderColor: "#58a6ff", borderWidth: 1, padding: 10, borderRadius: 8, marginBottom: 12 }}>
        <Text style={{ color: "#58a6ff" }}>Seleccionar documento</Text>
      </Pressable>

      {doc ? (
        <View style={{ borderWidth: 1, borderColor: "#30363d", padding: 10, borderRadius: 8 }}>
          <Text style={{ color: "#c9d1d9" }}>Nombre: {doc.name}</Text>
          <Text style={{ color: "#8b949e" }} numberOfLines={2}>URI: {doc.uri}</Text>
        </View>
      ) : (
        <Text style={{ color: "#8b949e" }}>No hay documento seleccionado.</Text>
      )}
    </ScrollView>
  );
}
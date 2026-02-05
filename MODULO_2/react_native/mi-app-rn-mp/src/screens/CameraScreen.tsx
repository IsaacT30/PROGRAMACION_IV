import React, { useEffect, useRef, useState } from "react";
import { View, Text, Image, Pressable } from "react-native";
const _expoCamera = require("expo-camera") as any;
const CameraView = _expoCamera.CameraView ?? _expoCamera.Camera;
const useCameraPermissions = _expoCamera.useCameraPermissions ?? _expoCamera.usePermissions;
import * as MediaLibrary from "expo-media-library";

export default function CameraScreen() {
  const [permission, requestPermission] = useCameraPermissions();
  const [mlStatus, requestML] = MediaLibrary.usePermissions();
  const cameraRef = useRef<any>(null);
  const [photoUri, setPhotoUri] = useState<string | null>(null);
  const [flash, setFlash] = useState<"off" | "on">("off");

  useEffect(() => {
    if (!mlStatus?.granted) requestML();
  }, [mlStatus, requestML]);

  if (!permission) return <View />;
  if (!permission.granted) {
    return (
      <View style={{ flex: 1, backgroundColor: "#0d1117", alignItems: "center", justifyContent: "center", padding: 16 }}>
        <Text style={{ color: "#c9d1d9", textAlign: "center", marginBottom: 12 }}>
          Necesitamos permiso de la cámara para tomar fotos.
        </Text>
        <Pressable onPress={requestPermission} style={{ borderColor: "#58a6ff", borderWidth: 1, padding: 10, borderRadius: 8 }}>
          <Text style={{ color: "#58a6ff" }}>Conceder permiso</Text>
        </Pressable>
      </View>
    );
  }

  return (
    <View style={{ flex: 1, backgroundColor: "#0d1117" }}>
      {photoUri ? (
        <View style={{ flex: 1, padding: 16 }}>
          <Image source={{ uri: photoUri }} style={{ flex: 1, borderRadius: 12 }} resizeMode="cover" />
          <View style={{ flexDirection: "row", justifyContent: "space-between", marginTop: 12 }}>
            <Pressable
              onPress={() => setPhotoUri(null)}
              style={{ borderWidth: 1, borderColor: "#58a6ff", borderRadius: 10, paddingHorizontal: 12, paddingVertical: 8 }}
            >
              <Text style={{ color: "#58a6ff" }}>Volver</Text>
            </Pressable>
            <Pressable
              onPress={async () => {
                if (!photoUri) return;
                try {
                  await MediaLibrary.saveToLibraryAsync(photoUri);
                  alert("Guardada en galería");
                } catch (e) {
                  alert("No se pudo guardar");
                }
              }}
              style={{ borderWidth: 1, borderColor: "#3fb950", borderRadius: 10, paddingHorizontal: 12, paddingVertical: 8 }}
            >
              <Text style={{ color: "#3fb950" }}>Guardar</Text>
            </Pressable>
          </View>
        </View>
      ) : (
        <CameraView
          ref={cameraRef}
          style={{ flex: 1 }}
          facing="back"
          enableZoomGesture
          flash={flash}
        >
          <View style={{ position: "absolute", bottom: 40, alignSelf: "center", flexDirection: "row", gap: 16 }}>
            <Pressable
              onPress={() => setFlash((f) => (f === "off" ? "on" : "off"))}
              style={{ borderWidth: 1, borderColor: "#58a6ff", padding: 10, borderRadius: 30 }}
            >
              <Text style={{ color: "#58a6ff" }}>Flash: {flash}</Text>
            </Pressable>
            <Pressable
              onPress={async () => {
                try {
                  // @ts-ignore - expo-camera expone takePictureAsync en ref.current
                  const photo = await cameraRef.current?.takePictureAsync({ quality: 0.8 });
                  if (photo?.uri) setPhotoUri(photo.uri);
                } catch {
                  alert("No se pudo capturar");
                }
              }}
              style={{ borderWidth: 2, borderColor: "#58a6ff", padding: 20, borderRadius: 40 }}
            >
              <Text style={{ color: "#58a6ff", fontWeight: "bold" }}>●</Text>
            </Pressable>
          </View>
        </CameraView>
      )}
    </View>
  );
}
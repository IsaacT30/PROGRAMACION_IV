import React from "react";
import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import MediaPickerScreen from "../screens/MediaPickerScreen";
import VideoPlayerScreen from "../screens/VideoPlayerScreen";
import YouTubeScreen from "../screens/YouTubeScreen";
import colors from "../theme/colors";

export type RootStackParamList = {
  HistoriasClinicas: undefined;
  VideoPlayer: undefined;
  YouTube: undefined;
};

const Stack = createNativeStackNavigator<RootStackParamList>();

export default function AppNavigator() {
  return (
    <NavigationContainer>
      <Stack.Navigator
        screenOptions={{
          headerStyle: { backgroundColor: colors.card },
          headerTintColor: colors.primary,
          contentStyle: { backgroundColor: colors.bg },
        }}
      >
  <Stack.Screen name="HistoriasClinicas" component={MediaPickerScreen} options={{ title: "Historias Clínicas" }} />
        <Stack.Screen name="VideoPlayer" component={VideoPlayerScreen} options={{ title: "Video remoto" }} />
        <Stack.Screen name="YouTube" component={YouTubeScreen} options={{ title: "YouTube" }} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}
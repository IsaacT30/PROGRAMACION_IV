import React from "react";
import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import HomeScreen from "../screens/HomeScreen";
import UsersListScreen from "../screens/UsersListScreen";
import DetailsScreen from "../screens/DetailsScreen";
import SettingsScreen from "../screens/SettingsScreen";
import UserDetailScreen from "../screens/UserDetailScreen";
import TaskListScreen from "../features/tasks/screens/TaskListScreen";
import TaskDetailScreen from "../features/tasks/screens/TaskDetailScreen";
import CameraScreen from "../screens/CameraScreen";
import FilesScreen from "../screens/FilesScreen";
import colors from "../theme/colors";
import type { RootStackParamList } from "./types";

const Stack = createNativeStackNavigator<RootStackParamList>();

export default function AppNavigator() {
  return (
    <NavigationContainer>
      <Stack.Navigator
        initialRouteName="Home"
        screenOptions={{
          headerStyle: { backgroundColor: "#161b22" },
          headerTintColor: colors.primary,
          contentStyle: { backgroundColor: "#0d1117" },
        }}
      >
        <Stack.Screen name="Home" component={HomeScreen} options={{ title: "Inicio" }} />
        <Stack.Screen name="Details" component={DetailsScreen} options={{ title: "Detalles" }} />
        <Stack.Screen name="Settings" component={SettingsScreen} options={{ title: "Configuración" }} />
        <Stack.Screen name="Patients" component={UsersListScreen} options={{ title: "Pacientes" }} />
        <Stack.Screen name="PatientDetail" component={UserDetailScreen} options={{ title: "Detalle" }} />
        <Stack.Screen name="HistorialList" component={TaskListScreen} options={{ title: "Historias clínicas" }} />
        <Stack.Screen name="HistorialDetail" component={TaskDetailScreen} options={{ title: "Detalle historia" }} />
        <Stack.Screen name="Camera" component={CameraScreen} options={{ title: "Cámara" }} />
        <Stack.Screen name="Files" component={FilesScreen} options={{ title: "Archivos" }} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}
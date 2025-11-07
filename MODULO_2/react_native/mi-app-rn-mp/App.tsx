import React from "react";
import AppNavigator from "./src/navigation/AppNavigator";
import { PatientsProvider } from "./src/context/UsersContext";

export default function App() {
  return (
    <PatientsProvider>
      <AppNavigator />
    </PatientsProvider>
  );
}
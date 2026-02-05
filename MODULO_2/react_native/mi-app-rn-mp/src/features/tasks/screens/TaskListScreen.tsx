import React, { useState } from "react";
import { View } from "react-native";
import MainLayout from "../../../loyouts/MainLayout";
import TaskItem from "../components/TaskItem";
import AppButton from "../../../components/AppButton";
import colors from "../../../theme/colors";

export default function TaskListScreen({ navigation }: any) {
  const [tasks] = useState([
    { id: "1", title: "Historia de Juan Pérez", done: true },
    { id: "2", title: "Historia de María López", done: false },
    { id: "3", title: "Historia de Carlos Ruiz", done: false },
  ]);

  return (
    <MainLayout scroll contentStyle={{ backgroundColor: colors.background }}>
      <View style={{ marginBottom: 12 }}>
        {tasks.map((t) => (
          <TaskItem key={t.id} title={t.title} done={t.done} />
        ))}
      </View>

      <AppButton
        label="Ver historia clínica de la 2da entrada"
        onPress={() => navigation.navigate("HistorialDetail", { id: "2" })}
      />
    </MainLayout>
  );
}
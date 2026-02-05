import { ScrollView, StyleSheet, Text, View } from "react-native";

export default function TabTwoScreen() {
  return (
    <ScrollView style={styles.container}>
      <View style={styles.content}>
        <Text style={styles.title}>Explore</Text>
        <Text style={styles.text}>
          This app includes example code to help you get started.
        </Text>
        <Text style={styles.subtitle}>File-based routing</Text>
        <Text style={styles.text}>
          This app has two screens: app/(tabs)/index.tsx and
          app/(tabs)/explore.tsx
        </Text>
        <Text style={styles.text}>
          The layout file in app/(tabs)/_layout.tsx sets up the tab navigator.
        </Text>
      </View>
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#f6f7fb",
  },
  content: {
    padding: 20,
  },
  title: {
    fontSize: 28,
    fontWeight: "900",
    marginBottom: 16,
  },
  subtitle: {
    fontSize: 20,
    fontWeight: "700",
    marginTop: 20,
    marginBottom: 8,
  },
  text: {
    fontSize: 16,
    color: "#555",
    marginBottom: 12,
    lineHeight: 24,
  },
});

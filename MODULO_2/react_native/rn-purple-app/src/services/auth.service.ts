import api from "./api";
import { authStore } from "../store/auth";

// API pública: https://reqres.in
const BASE = "https://localhost:8000/api/auth";

export async function login(email: string, password: string) {
  const { data } = await api.post(`${BASE}/login`, { username:email, email, password });
  authStore.set({ token: data.token, email });
  return data;
}

export async function register(email: string, password: string) {
  const { data } = await api.post(`${BASE}/register`, { email, password });
  authStore.set({ token: data.token ?? null, email });
  return data;
}

export function logout() {
  authStore.clear();
}
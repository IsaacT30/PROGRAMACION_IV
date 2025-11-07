import React, { createContext, useContext, useMemo } from "react";
import { useFetch } from "../hooks/useFetch";
import type { User } from "../types/api";

type PatientsState = {
  patients: User[] | null;
  loading: boolean;
  error: string | null;
  reload: () => void;
};

const PatientsContext = createContext<PatientsState | undefined>(undefined);

export function PatientsProvider({ children }: { children: React.ReactNode }) {
  const { data, loading, error, retry } = useFetch<User[]>("https://jsonplaceholder.typicode.com/users");
  const value = useMemo(() => ({ patients: data, loading, error, reload: retry }), [data, loading, error, retry]);

  return <PatientsContext.Provider value={value}>{children}</PatientsContext.Provider>;
}

export function usePatients() {
  const ctx = useContext(PatientsContext);
  if (!ctx) throw new Error("usePatients debe usarse dentro de PatientsProvider");
  return ctx;
}
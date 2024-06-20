import React from "react";
import { ThemeProvider } from "@mui/material/styles";
import { CssBaseline } from "@mui/material";

import { HashRouter, Route, Routes, Navigate } from "react-router-dom";

import DamlLedger from "@daml/react";

import {theme} from "./Theme"

import { useUserState } from "./context/UserContext";


export const TApp : React.FC = () => {
  
  const user = useUserState();

  return (
    <ThemeProvider theme={theme}>
        <CssBaseline />
        <DamlLedger party={user.party} token={user.token}>
          <HashRouter>
            <Routes>
              <Route path="/" element={<Navigate to="/app" />} />
              <Route path="/login" element={<Portal />} />
              <Route path="/login/*" element={<Login />} />
              <Route path="/app/*" element={<Private><TRoot /></Private>} />
              <Route path="/app/*" element={<Private><HRoot /></Private>} />
              <Route element={<ErrorComponent />} />
            </Routes>
          </HashRouter>
        </DamlLedger>
    </ThemeProvider>
  );
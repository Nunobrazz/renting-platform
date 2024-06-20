import React from "react";

import { ThemeProvider } from "@mui/material/styles";
import { CssBaseline } from "@mui/material";

import { HashRouter, Route, Routes, Navigate } from "react-router-dom";
import ErrorComponent from "./pages/Error";

import DamlLedger from "@daml/react";
import {theme} from "./Theme"

import { useUserState } from "./context/UserContext";
import { TApp } from "./pages/Tenant/TApp";
import { HApp } from "./pages/Host/HApp";

import { Login } from "./pages/Error/Login";
import { Portal } from "./pages/login/Portal";

export const Main : React.FC = () => {
  
  const user = useUserState();

  return (
    <ThemeProvider theme={theme}>
        <CssBaseline />
        <DamlLedger party={user.party} token={user.token}>
          <HashRouter>
            <Routes> // Redirect to the correct pages depending on the login Tenant or Host
              <Route path="/" element={<Navigate to="/app" />} />
              <Route path="/login" element={<Portal />} />
              <Route path="/login/*" element={<Login />} />
              <Route path="/tHome/*" element={<Private><TApp/></Private>} />
              <Route path="/hHome/*" element={<Private><HApp/></Private>} />
              <Route element={<ErrorComponent />} />
            </Routes>
          </HashRouter>
        </DamlLedger>
    </ThemeProvider>
  );

  function Private({ children } : any) {
    return user.isAuthenticated ? children : <Navigate to="/login" />;
  }
}
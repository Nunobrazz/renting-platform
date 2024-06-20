// Copyright (c) 2022 Digital Asset (Switzerland) GmbH and/or its affiliates. All rights reserved.
// SPDX-License-Identifier: Apache-2.0

import React from "react";
import LoginScreen from "./LoginScreen";
import MainScreenTenant from "./MainScreenTenant";
import MainScreenHost from "./MainScreenHost";
import { createLedgerContext } from "@daml/react";
import DamlHub, {
  damlHubLogout,
  isRunningOnHub,
  usePublicParty,
  usePublicToken,
} from "@daml/hub-react";
import Credentials from "../Credentials";
import { authConfig } from "../config";

// Context for the party of the user.
export const userContext = createLedgerContext();

// Context for the public party used to query user aliases.
// On Daml hub, this is a separate context. Locally, we have a single
// token that has actAs claims for the user’s party and readAs claims for
// the public party so we reuse the user context.
export const publicContext = isRunningOnHub()
  ? createLedgerContext()
  : userContext;

/**
 * React component for the entry point into the application.
 */
// APP_BEGIN
const App: React.FC = () => {
  // State to hold the user's credentials
  const [credentials, setCredentials] = React.useState<
    Credentials | undefined
  >();

  // State to hold the user's view (Tenant or Host)
  const [view, setView] = React.useState<
    boolean | undefined
  >();


  // If the user is logged in, render the main screen
  if (credentials) {
    // React component for the public party ledger
    const PublicPartyLedger: React.FC = ({ children }) => {
      // Get the public token and public party
      const publicToken = usePublicToken();
      const publicParty = usePublicParty();

      // If the public token and public party are available, render the component with the token and party
      if (publicToken && publicParty) {
        return (
          <publicContext.DamlLedger
            token={publicToken.token}
            party={publicParty}
          >
            {children}
          </publicContext.DamlLedger>
        );
      } else {
        // If the public token or public party is not available, render a loading message
        return <h1>Loading ...</h1>;
      }
    };

    // Wrapper component to handle running on Daml Hub or locally
    const Wrap: React.FC = ({ children }) =>
      isRunningOnHub() ? (
        // If running on Daml Hub, render the children wrapped in a DamlHub component with the user's token
        <DamlHub token={credentials.token}>
          <PublicPartyLedger>{children}</PublicPartyLedger>
        </DamlHub>
      ) : (
        // If running locally, render the children in a div
        <div>{children}</div>
      );

    if (view){
        // Render the main screen with the user's credentials and a logout function
        return (
          <Wrap>
            <userContext.DamlLedger
              token={credentials.token}
              party={credentials.party}
              user={credentials.user}
            >
              <Tenant
                getPublicParty={credentials.getPublicParty}
                onLogout={() => {

                  if (authConfig.provider === "daml-hub") {
                    damlHubLogout();
                  }
                  setCredentials(undefined);
                }}
              />
            </userContext.DamlLedger>
          </Wrap>
        );  
    } 
    else {
      return (
        <Wrap>
          <userContext.DamlLedger
            token={credentials.token}
            party={credentials.party}
            user={credentials.user}
          >
            <MainScreenHost
              getPublicParty={credentials.getPublicParty}
              onLogout={() => {

                if (authConfig.provider === "daml-hub") {
                  damlHubLogout();
                }
                setCredentials(undefined);
              }}
            />
          </userContext.DamlLedger>
        </Wrap>
      );  
    }
    

  } else {
    // If the user is not logged in, render the login screen with a login function
    return <LoginScreen onLogin={setCredentials} />;
  }
};
// APP_END

export default App;

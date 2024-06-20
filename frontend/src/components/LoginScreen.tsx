// Copyright (c) 2022 Digital Asset (Switzerland) GmbH and/or its affiliates. All rights reserved.
// SPDX-License-Identifier: Apache-2.0

import React, { useCallback, useState } from "react";
import { Button, Form, Grid, Header, Image, Segment } from "semantic-ui-react";
import Credentials, { PublicParty } from "../Credentials";
import Ledger from "@daml/ledger";
import {
  DamlHubLogin as DamlHubLoginBtn,
  usePublicParty,
} from "@daml/hub-react";
import { authConfig, Insecure } from "../config";

type Props = {
  onLogin: (credentials: Credentials) => void;
};

/**
 * React component for the login screen of the `App`.
 * @param onLogin Function to call when the user logs in.
 */
const LoginScreen: React.FC<Props> = ({ onLogin }) => {
  // Callback function to log in the user.
  const login = useCallback(
    async (credentials: Credentials) => {
      onLogin(credentials);
    },
    [onLogin],
  );

  /**
   * Wraps the given component in a grid layout.
   * @param component The component to wrap.
   * @returns The wrapped component.
   */
  const wrap: (c: JSX.Element) => JSX.Element = component => (
    <Grid textAlign="center" style={{ height: "100vh" }} verticalAlign="middle">
      <Grid.Column style={{ maxWidth: 450 }}>
        {/* Header */}
        <Header
          as="h1"
          textAlign="center"
          size="huge"
          style={{ color: "#223668" }}>
          <Header.Content>
            <Image
              as="a"
              href="https://www.digitalasset.com/developers"
              target="_blank"
              src="/unlockit.png"
              alt="Unlockit Logo"
              spaced
              size="small"
              verticalAlign="bottom"
            />
          </Header.Content>
          <div style={{ marginTop: '10px', color: '#6A5ACD' }}>Login</div>

        </Header>
        <Form size="large" className="test-select-login-screen">
          <Segment>{component}</Segment>
        </Form>
      </Grid.Column>
    </Grid>
  );

  /**
   * React component for insecure login.
   * @param auth The insecure auth configuration.
   */
  const InsecureLogin: React.FC<{ auth: Insecure }> = ({ auth }) => {
    const [username, setUsername] = React.useState("");

    /**
     * Handles the login event.
     * @param event The login event.
     */
    const handleLogin = async (event: React.FormEvent) => {
      event.preventDefault();
      const token = auth.makeToken(username);
      const ledger = new Ledger({ token: token });
      const primaryParty: string = await auth.userManagement
        .primaryParty(username, ledger)
        .catch(error => {
          const errorMsg =
            error instanceof Error ? error.toString() : JSON.stringify(error);
          alert(`Failed to login as '${username}':\n${errorMsg}`);
          throw error;
        });

      /**
       * Returns the public party for the user.
       * @returns The public party.
       */
      const useGetPublicParty = (): PublicParty => {
        const [publicParty, setPublicParty] = useState<string | undefined>(
          undefined,
        );
        const setup = () => {
          const fn = async () => {
            const publicParty = await auth.userManagement
              .publicParty(username, ledger)
              .catch(error => {
                const errorMsg =
                  error instanceof Error
                    ? error.toString()
                    : JSON.stringify(error);
                alert(
                  `Failed to find primary party for user '${username}':\n${errorMsg}`,
                );
                throw error;
              });
            // todo stop yolowing error handling
            setPublicParty(publicParty);
          };
          fn();
        };
        return { usePublicParty: () => publicParty, setup: setup };
      };
      await login({
        user: { userId: username, primaryParty: primaryParty },
        party: primaryParty,
        token: auth.makeToken(username),
        getPublicParty: useGetPublicParty,
      });
    };

    return wrap(
      <>
        {/* FORM_BEGIN */}
        {/* Username input field */}
        <Form.Input
          fluid
          placeholder="Username"
          value={username}
          className="test-select-username-field"
          onChange={(e, { value }) => setUsername(value?.toString() ?? "")}
        />
       <Button
          primary
          fluid
          className="test-select-login-button"
          style={{ backgroundColor: '#6A5ACD', color: 'white', marginBottom: '20px' }}
          onClick={handleLogin}
        >
          Tenant
        </Button>
        <Button
          primary
          fluid
          className="test-select-login-button"
          style={{ backgroundColor: '#6A5ACD', color: 'white', marginBottom: '20px' }}
          onClick={handleLogin}
        >
          Host
        </Button>
      </>,
    );
  };

  /**
   * React component for Daml Hub login.
   */
  const DamlHubLogin: React.FC = () =>
    wrap(
      <DamlHubLoginBtn
        onLogin={creds => {
          if (creds) {
            login({
              party: creds.party,
              user: { userId: creds.partyName, primaryParty: creds.party },
              token: creds.token,
              getPublicParty: () => ({
                usePublicParty: () => usePublicParty(),
                setup: () => {},
              }),
            });
          }
        }}
        options={{
          method: {
            button: {
              render: () => <Button primary fluid />,
            },
          },
        }}
      />,
    );

  // Render the appropriate login component based on the auth provider.
  return authConfig.provider === "none" ? (
    <InsecureLogin auth={authConfig} />
  ) : authConfig.provider === "daml-hub" ? (
    <DamlHubLogin />
  ) : (
    <div>Invalid configuration.</div>
  );
};

export default LoginScreen;

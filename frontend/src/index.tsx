// Copyright (c) 2022 Digital Asset (Switzerland) GmbH and/or its affiliates. All rights reserved.
// SPDX-License-Identifier: Apache-2.0

import React from "react";
import ReactDOM from "react-dom";
import "semantic-ui-css/semantic.min.css";
import "./index.css";
import { UserProvider } from "./context/UserContext";
import { Main } from "./Main";


//ReactDOM.render(<App />, document.getElementById("root"));

ReactDOM.render((

        <UserProvider>
            <Main />
        </UserProvider>

), document.getElementById("root"));

import React from "react";
import { NavigateFunction } from "react-router-dom";
import { useParties } from "./PartiesContext";




const UserStateContext = React.createContext<UserState>({ isAuthenticated: false, name: "", party: "", token: "" });
const UserDispatchContext = React.createContext<React.Dispatch<any>>({} as React.Dispatch<any>);

type UserState = { // Tenant or host?
  isAuthenticated : boolean
  name : string
  party : string
  token : string
}

const userReducer = (state : UserState, action : any) => {
  switch (action.type) {
    case "LOGIN_SUCCESS":
      return { ...state, isAuthenticated: true, name: action.name, party: action.party, token: action.token };
    case "LOGIN_FAILURE":
      return { ...state, isAuthenticated: false };
    case "SIGN_OUT_SUCCESS":
      return { ...state, isAuthenticated: false };
    default: {
      throw new Error(`Unhandled action type: ${action.type}`);
    }
  }
}

/**
 * UserProvider component is a context provider that wraps its children components
 * and maintains the user state and dispatch methods in the context.
 *
 * @param {Object} props - The props object containing the children components.
 * @param {ReactNode} props.children - The children components to be wrapped.
 * @returns {JSX.Element} - The wrapped children components with the user state and dispatch methods in the context.
 */
const UserProvider : React.FC = ({ children }) => {
  // Get the user name from local storage or set it to an empty string if not found.
  const name = localStorage.getItem("daml.name") || "";
  // Get party and token from the parties context.
  const { getParty, getToken } = useParties();
  // Get the party for the user name.
  const party = getParty(name);
  // Get the token for the user party.
  const token = getToken(party);

  // Initialize the user state with the initial values.
  var [state, dispatch] = React.useReducer(userReducer, {
    // Check if the token exists, if it does set isAuthenticated to true, otherwise set it to false.
    isAuthenticated: !!token,
    // Set the name to the user name or an empty string if it is not defined.
    name: name || "",
    // Set the party to the user party or an empty string if it is not defined.
    party: party || "",
    // Set the token to the user token or an empty string if it is not defined.
    token: token || ""
  });

  // Return the wrapped children components with the user state and dispatch methods in the context.
  return (
    // Provider component that provides the user state in the context.
    <UserStateContext.Provider value={state}>
      // Provider component that provides the user dispatch method in the context.
      <UserDispatchContext.Provider value={dispatch}>
        {children}
      </UserDispatchContext.Provider>
    </UserStateContext.Provider>
  );
}

/**
 * Hook to get the user state from the UserStateContext.
 *
 * @returns {UserState} The user state.
 * @throws {Error} If this hook is not used within a UserProvider.
 */
const useUserState = () => {
  // Get the user state from the UserStateContext.
  var context = React.useContext<UserState>(UserStateContext);
  
  // If the context is undefined, throw an error. This means that this hook
  // is not used within a UserProvider.
  if (context === undefined) {
    throw new Error("useUserState must be used within a UserProvider");
  }
  
  // Return the user state.
  return context;
}

const useUserDispatch = () => {
  var context = React.useContext<React.Dispatch<any>>(UserDispatchContext);
  if (context === undefined) {
    throw new Error("useUserDispatch must be used within a UserProvider");
  }
  return context;
}

// ###########################################################

/**
 * Function to handle user login.
 *
 * @param {React.Dispatch<any>} dispatch - The dispatch function from the UserProvider.
 * @param {string} name - The name of the user.
 * @param {string} party - The party of the user.
 * @param {string} token - The token of the user.
 * @param {NavigateFunction} navigate - The navigate function from react-router-dom.
 * @param {React.Dispatch<React.SetStateAction<boolean>>} setError - The state setter function for error.
 */
const loginUser = async (
    dispatch : React.Dispatch<any>,
    name : string,
    party : string,
    token : string,
    navigate : NavigateFunction,
    setError : React.Dispatch<React.SetStateAction<boolean>>) => {
  // Reset the error state.
  setError(false);

  // If the name is provided, login the user.
  if (!!name) {

    // Store the user name in local storage.
    localStorage.setItem("daml.name", name);

    // Dispatch the login success action with the user details.
    dispatch({ type: "LOGIN_SUCCESS", name, party, token });
    // Reset the error state.
    setError(false);
    // Navigate to the app page.
    navigate("/app");
  } else {
    // If the name is not provided, dispatch the login failure action.
    dispatch({ type: "LOGIN_FAILURE" });
    // Set the error state to true.
    setError(true);
  }
}

const signOut = (dispatch : React.Dispatch<any>) => {
  // event.preventDefault();
  localStorage.removeItem("daml.name");

  dispatch({ type: "SIGN_OUT_SUCCESS" });
}

export { UserProvider, useUserState, useUserDispatch, loginUser, signOut };
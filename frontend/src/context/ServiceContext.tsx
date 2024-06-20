import React from "react";
import { CreateEvent } from "@daml/ledger";
import { useStreamQueries } from "@daml/react";

import { Service as ProposalService } from "@daml.js/rentingPlatform/lib/Platform/Proposal/Service"

import { Service as LAService } from "@daml.js/rentingPlatform/lib/Platform/LeaseAgreement/Service"






export type ServicesState = {
  loading         : boolean
  proposal        : readonly CreateEvent<ProposalService, ProposalService.Key>[]
  la              : readonly CreateEvent<LAService, LAService.Key>[]
};

const empty = {
  loading: true,
  proposal: [],
  la: [],
}

const ServicesContext = React.createContext<ServicesState>(empty);


export const ServicesProvider : React.FC = ({ children }) => {

  const { loading: l1,  contracts:  proposal}         = useStreamQueries(ProposalService);
  const { loading: l2,  contracts: la }               = useStreamQueries(LAService);
  const loading = l1 || l2;

  const value = {
    loading,
    proposal,
    la,
  };

  return (
    <ServicesContext.Provider value={value}>
        {children}
    </ServicesContext.Provider>
  );
}

export const useServices = () => {
  return React.useContext(ServicesContext);
}
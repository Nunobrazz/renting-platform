// Generated from Test/Roles.daml
/* eslint-disable @typescript-eslint/camelcase */
/* eslint-disable @typescript-eslint/no-namespace */
/* eslint-disable @typescript-eslint/no-use-before-define */
import * as jtv from '@mojotech/json-type-validation';
import * as damlTypes from '@daml/types';
/* eslint-disable-next-line @typescript-eslint/no-unused-vars */
import * as damlLedger from '@daml/ledger';

import * as Platform_Role_Operator from '../../Platform/Role/Operator/module';
import * as Time_Clock from '../../Time/Clock/module';
import * as Time_Lifecycle_Evolve from '../../Time/Lifecycle/Evolve/module';

export declare type Contracts = {
  operatorRoleCid: damlTypes.ContractId<Platform_Role_Operator.Role>;
  clockCid: damlTypes.ContractId<Time_Clock.DateClock>;
  evolveCid: damlTypes.ContractId<Time_Lifecycle_Evolve.Evolve>;
};

export declare const Contracts:
  damlTypes.Serializable<Contracts> & {
  }
;


export declare type Parties = {
  alice: damlTypes.Party;
  bob: damlTypes.Party;
  operator: damlTypes.Party;
  admin: damlTypes.Party;
  timeProvider: damlTypes.Party;
  arbitrator1: damlTypes.Party;
  arbitrator2: damlTypes.Party;
  public: damlTypes.Party;
};

export declare const Parties:
  damlTypes.Serializable<Parties> & {
  }
;


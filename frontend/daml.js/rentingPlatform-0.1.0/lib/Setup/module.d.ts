// Generated from Setup.daml
/* eslint-disable @typescript-eslint/camelcase */
/* eslint-disable @typescript-eslint/no-namespace */
/* eslint-disable @typescript-eslint/no-use-before-define */
import * as jtv from '@mojotech/json-type-validation';
import * as damlTypes from '@daml/types';
/* eslint-disable-next-line @typescript-eslint/no-unused-vars */
import * as damlLedger from '@daml/ledger';

import * as pkg5ab022880cf8c70dd9d87506ab9af65458db6d157a2ea2b4c4e407841d446101 from '@daml.js/5ab022880cf8c70dd9d87506ab9af65458db6d157a2ea2b4c4e407841d446101';

export declare type TestUser = {
  alias: string;
  public: damlTypes.Party;
  participantName: damlTypes.Optional<pkg5ab022880cf8c70dd9d87506ab9af65458db6d157a2ea2b4c4e407841d446101.Daml.Script.ParticipantName>;
};

export declare const TestUser:
  damlTypes.Serializable<TestUser> & {
  }
;


export declare type Parties = {
  alice: damlTypes.Party;
  bob: damlTypes.Party;
  charlie: damlTypes.Party;
  public: damlTypes.Party;
};

export declare const Parties:
  damlTypes.Serializable<Parties> & {
  }
;


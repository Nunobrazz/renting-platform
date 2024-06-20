// Generated from Platform/Interface/Types.daml
/* eslint-disable @typescript-eslint/camelcase */
/* eslint-disable @typescript-eslint/no-namespace */
/* eslint-disable @typescript-eslint/no-use-before-define */
import * as jtv from '@mojotech/json-type-validation';
import * as damlTypes from '@daml/types';
/* eslint-disable-next-line @typescript-eslint/no-unused-vars */
import * as damlLedger from '@daml/ledger';

export declare type MIkey = {
  reporter: damlTypes.Party;
  house: House;
  id: Id;
};

export declare const MIkey:
  damlTypes.Serializable<MIkey> & {
  }
;


export declare type LAkey = {
  tenant: damlTypes.Party;
  house: House;
};

export declare const LAkey:
  damlTypes.Serializable<LAkey> & {
  }
;


export declare type AssessmentDetails = {
  reporterResp: damlTypes.Int;
  counterpartResp: damlTypes.Int;
  cost: damlTypes.Optional<damlTypes.Int>;
  assessmentDate: damlTypes.Date;
  reparationDate: damlTypes.Optional<damlTypes.Date>;
};

export declare const AssessmentDetails:
  damlTypes.Serializable<AssessmentDetails> & {
  }
;


export declare type Breakdown = {
  startingDate: damlTypes.Date;
  description: string;
};

export declare const Breakdown:
  damlTypes.Serializable<Breakdown> & {
  }
;


export declare type LeaseTerms = {
  rent: damlTypes.Int;
  beginingDate: damlTypes.Date;
  paymentDates: damlTypes.Date[];
  nArbitrators: damlTypes.Int;
};

export declare const LeaseTerms:
  damlTypes.Serializable<LeaseTerms> & {
  }
;


export declare type House = {
  host: damlTypes.Party;
  address: string;
  details: string;
  rent: damlTypes.Int;
};

export declare const House:
  damlTypes.Serializable<House> & {
  }
;


export declare type Id = {
  unpack: string;
};

export declare const Id:
  damlTypes.Serializable<Id> & {
  }
;


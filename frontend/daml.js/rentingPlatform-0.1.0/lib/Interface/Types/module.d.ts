// Generated from Interface/Types.daml
/* eslint-disable @typescript-eslint/camelcase */
/* eslint-disable @typescript-eslint/no-namespace */
/* eslint-disable @typescript-eslint/no-use-before-define */
import * as jtv from '@mojotech/json-type-validation';
import * as damlTypes from '@daml/types';
/* eslint-disable-next-line @typescript-eslint/no-unused-vars */
import * as damlLedger from '@daml/ledger';

export declare type Claim = {
  claimDate: damlTypes.Date;
  amount: damlTypes.Int;
};

export declare const Claim:
  damlTypes.Serializable<Claim> & {
  }
;


export declare type MIkey = {
  reporter: damlTypes.Party;
  house: House;
  breakdown: Breakdown;
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
  responsability: Responsability;
  cost: damlTypes.Optional<damlTypes.Int>;
  assessmentDate: damlTypes.Date;
  reparationDate: damlTypes.Optional<damlTypes.Date>;
};

export declare const AssessmentDetails:
  damlTypes.Serializable<AssessmentDetails> & {
  }
;


export declare type Responsability = {
  reporterResp: damlTypes.Int;
  counterpartResp: damlTypes.Int;
};

export declare const Responsability:
  damlTypes.Serializable<Responsability> & {
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
  agreedRent: damlTypes.Int;
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
  listedRent: damlTypes.Int;
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


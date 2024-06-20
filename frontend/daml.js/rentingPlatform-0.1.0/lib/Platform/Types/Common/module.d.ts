// Generated from Platform/Types/Common.daml
/* eslint-disable @typescript-eslint/camelcase */
/* eslint-disable @typescript-eslint/no-namespace */
/* eslint-disable @typescript-eslint/no-use-before-define */
import * as jtv from '@mojotech/json-type-validation';
import * as damlTypes from '@daml/types';
/* eslint-disable-next-line @typescript-eslint/no-unused-vars */
import * as damlLedger from '@daml/ledger';

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


// Generated from Platform/Types/MI.daml
/* eslint-disable @typescript-eslint/camelcase */
/* eslint-disable @typescript-eslint/no-namespace */
/* eslint-disable @typescript-eslint/no-use-before-define */
import * as jtv from '@mojotech/json-type-validation';
import * as damlTypes from '@daml/types';
/* eslint-disable-next-line @typescript-eslint/no-unused-vars */
import * as damlLedger from '@daml/ledger';

import * as Platform_Types_Common from '../../../Platform/Types/Common/module';

export declare type MIdetails = {
  nArbitrators: damlTypes.Int;
  house: Platform_Types_Common.House;
  startingDate: damlTypes.Date;
  description: string;
};

export declare const MIdetails:
  damlTypes.Serializable<MIdetails> & {
  }
;


export declare type AssessmentDetails = {
  responsability: Responsability;
  cost: damlTypes.Int;
  assessmentDate: damlTypes.Date;
  reparationDate: damlTypes.Date;
};

export declare const AssessmentDetails:
  damlTypes.Serializable<AssessmentDetails> & {
  }
;


export declare type Responsability = {
  tenantResp: damlTypes.Int;
  hostResp: damlTypes.Int;
};

export declare const Responsability:
  damlTypes.Serializable<Responsability> & {
  }
;


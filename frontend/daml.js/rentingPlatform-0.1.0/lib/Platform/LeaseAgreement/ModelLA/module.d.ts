// Generated from Platform/LeaseAgreement/ModelLA.daml
/* eslint-disable @typescript-eslint/camelcase */
/* eslint-disable @typescript-eslint/no-namespace */
/* eslint-disable @typescript-eslint/no-use-before-define */
import * as jtv from '@mojotech/json-type-validation';
import * as damlTypes from '@daml/types';
/* eslint-disable-next-line @typescript-eslint/no-unused-vars */
import * as damlLedger from '@daml/ledger';

import * as pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662 from '@daml.js/d14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662';

import * as Platform_Types_Common from '../../../Platform/Types/Common/module';
import * as Platform_Types_LA from '../../../Platform/Types/LA/module';

export declare type ProcessPayment = {
  date: damlTypes.Date;
};

export declare const ProcessPayment:
  damlTypes.Serializable<ProcessPayment> & {
  }
;


export declare type LeaseAgreement = {
  operator: damlTypes.Party;
  lifecycler: damlTypes.Party;
  tenant: damlTypes.Party;
  house: Platform_Types_Common.House;
  leaseTerms: Platform_Types_Common.LeaseTerms;
  paymentsToProcess: damlTypes.Date[];
};

export declare interface LeaseAgreementInterface {
  Archive: damlTypes.Choice<LeaseAgreement, pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive, {}, LeaseAgreement.Key> & damlTypes.ChoiceFrom<damlTypes.Template<LeaseAgreement, LeaseAgreement.Key>>;
  ProcessPayment: damlTypes.Choice<LeaseAgreement, ProcessPayment, damlTypes.ContractId<LeaseAgreement>, LeaseAgreement.Key> & damlTypes.ChoiceFrom<damlTypes.Template<LeaseAgreement, LeaseAgreement.Key>>;
}
export declare const LeaseAgreement:
  damlTypes.Template<LeaseAgreement, LeaseAgreement.Key, 'f18eb482c25f64cd721de470f30dbf6a8247ca127e6e772be98e809b5cbf23a3:Platform.LeaseAgreement.ModelLA:LeaseAgreement'> &
  damlTypes.ToInterface<LeaseAgreement, never> &
  LeaseAgreementInterface;

export declare namespace LeaseAgreement {
  export type Key = Platform_Types_LA.LAkey
  export type CreateEvent = damlLedger.CreateEvent<LeaseAgreement, LeaseAgreement.Key, typeof LeaseAgreement.templateId>
  export type ArchiveEvent = damlLedger.ArchiveEvent<LeaseAgreement, typeof LeaseAgreement.templateId>
  export type Event = damlLedger.Event<LeaseAgreement, LeaseAgreement.Key, typeof LeaseAgreement.templateId>
  export type QueryResult = damlLedger.QueryResult<LeaseAgreement, LeaseAgreement.Key, typeof LeaseAgreement.templateId>
}



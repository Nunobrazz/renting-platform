// Generated from Platform/Proposal/Model.daml
/* eslint-disable @typescript-eslint/camelcase */
/* eslint-disable @typescript-eslint/no-namespace */
/* eslint-disable @typescript-eslint/no-use-before-define */
import * as jtv from '@mojotech/json-type-validation';
import * as damlTypes from '@daml/types';
/* eslint-disable-next-line @typescript-eslint/no-unused-vars */
import * as damlLedger from '@daml/ledger';

import * as pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662 from '@daml.js/d14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662';

import * as Platform_LeaseAgreement_Service from '../../../Platform/LeaseAgreement/Service/module';
import * as Platform_Types_Common from '../../../Platform/Types/Common/module';

export declare type RequestLeaseAgreement = {
  signer: damlTypes.Party;
  operator: damlTypes.Party;
};

export declare const RequestLeaseAgreement:
  damlTypes.Serializable<RequestLeaseAgreement> & {
  }
;


export declare type Sign = {
  signer: damlTypes.Party;
};

export declare const Sign:
  damlTypes.Serializable<Sign> & {
  }
;


export declare type Proposal = {
  proposer: damlTypes.Party;
  house: Platform_Types_Common.House;
  leaseTerms: Platform_Types_Common.LeaseTerms;
  alreadySigned: damlTypes.Party[];
};

export declare interface ProposalInterface {
  Sign: damlTypes.Choice<Proposal, Sign, damlTypes.ContractId<Proposal>, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Proposal, undefined>>;
  RequestLeaseAgreement: damlTypes.Choice<Proposal, RequestLeaseAgreement, damlTypes.ContractId<Platform_LeaseAgreement_Service.Request>, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Proposal, undefined>>;
  Archive: damlTypes.Choice<Proposal, pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive, {}, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Proposal, undefined>>;
}
export declare const Proposal:
  damlTypes.Template<Proposal, undefined, 'f18eb482c25f64cd721de470f30dbf6a8247ca127e6e772be98e809b5cbf23a3:Platform.Proposal.Model:Proposal'> &
  damlTypes.ToInterface<Proposal, never> &
  ProposalInterface;

export declare namespace Proposal {
  export type CreateEvent = damlLedger.CreateEvent<Proposal, undefined, typeof Proposal.templateId>
  export type ArchiveEvent = damlLedger.ArchiveEvent<Proposal, typeof Proposal.templateId>
  export type Event = damlLedger.Event<Proposal, undefined, typeof Proposal.templateId>
  export type QueryResult = damlLedger.QueryResult<Proposal, undefined, typeof Proposal.templateId>
}



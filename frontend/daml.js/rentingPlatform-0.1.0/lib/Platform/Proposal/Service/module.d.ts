// Generated from Platform/Proposal/Service.daml
/* eslint-disable @typescript-eslint/camelcase */
/* eslint-disable @typescript-eslint/no-namespace */
/* eslint-disable @typescript-eslint/no-use-before-define */
import * as jtv from '@mojotech/json-type-validation';
import * as damlTypes from '@daml/types';
/* eslint-disable-next-line @typescript-eslint/no-unused-vars */
import * as damlLedger from '@daml/ledger';

import * as pkg40f452260bef3f29dede136108fc08a88d5a5250310281067087da6f0baddff7 from '@daml.js/40f452260bef3f29dede136108fc08a88d5a5250310281067087da6f0baddff7';
import * as pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662 from '@daml.js/d14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662';

import * as Platform_LeaseAgreement_Service from '../../../Platform/LeaseAgreement/Service/module';
import * as Platform_Proposal_Model from '../../../Platform/Proposal/Model/module';
import * as Platform_Types_Common from '../../../Platform/Types/Common/module';

export declare type Approve = {
};

export declare const Approve:
  damlTypes.Serializable<Approve> & {
  }
;


export declare type Reject = {
};

export declare const Reject:
  damlTypes.Serializable<Reject> & {
  }
;


export declare type Withdraw = {
};

export declare const Withdraw:
  damlTypes.Serializable<Withdraw> & {
  }
;


export declare type Request = {
  operator: damlTypes.Party;
  proposer: damlTypes.Party;
  house: Platform_Types_Common.House;
};

export declare interface RequestInterface {
  Withdraw: damlTypes.Choice<Request, Withdraw, {}, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Request, undefined>>;
  Reject: damlTypes.Choice<Request, Reject, {}, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Request, undefined>>;
  Archive: damlTypes.Choice<Request, pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive, {}, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Request, undefined>>;
  Approve: damlTypes.Choice<Request, Approve, damlTypes.ContractId<Service>, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Request, undefined>>;
}
export declare const Request:
  damlTypes.Template<Request, undefined, 'f18eb482c25f64cd721de470f30dbf6a8247ca127e6e772be98e809b5cbf23a3:Platform.Proposal.Service:Request'> &
  damlTypes.ToInterface<Request, never> &
  RequestInterface;

export declare namespace Request {
  export type CreateEvent = damlLedger.CreateEvent<Request, undefined, typeof Request.templateId>
  export type ArchiveEvent = damlLedger.ArchiveEvent<Request, typeof Request.templateId>
  export type Event = damlLedger.Event<Request, undefined, typeof Request.templateId>
  export type QueryResult = damlLedger.QueryResult<Request, undefined, typeof Request.templateId>
}



export declare type RequestLeaseAgreement = {
  signer: damlTypes.Party;
  proposalCid: damlTypes.ContractId<Platform_Proposal_Model.Proposal>;
};

export declare const RequestLeaseAgreement:
  damlTypes.Serializable<RequestLeaseAgreement> & {
  }
;


export declare type SignProposal = {
  signer: damlTypes.Party;
  proposalCid: damlTypes.ContractId<Platform_Proposal_Model.Proposal>;
};

export declare const SignProposal:
  damlTypes.Serializable<SignProposal> & {
  }
;


export declare type AcceptProposal = {
  proposalCid: damlTypes.ContractId<Platform_Proposal_Model.Proposal>;
};

export declare const AcceptProposal:
  damlTypes.Serializable<AcceptProposal> & {
  }
;


export declare type DeleteProposal = {
  proposalCid: damlTypes.ContractId<Platform_Proposal_Model.Proposal>;
};

export declare const DeleteProposal:
  damlTypes.Serializable<DeleteProposal> & {
  }
;


export declare type RejectProposal = {
  proposalCid: damlTypes.ContractId<Platform_Proposal_Model.Proposal>;
};

export declare const RejectProposal:
  damlTypes.Serializable<RejectProposal> & {
  }
;


export declare type CreateProposal = {
  proposer: damlTypes.Party;
  house: Platform_Types_Common.House;
  leaseTerms: Platform_Types_Common.LeaseTerms;
};

export declare const CreateProposal:
  damlTypes.Serializable<CreateProposal> & {
  }
;


export declare type Service = {
  operator: damlTypes.Party;
  proposer: damlTypes.Party;
  host: damlTypes.Party;
};

export declare interface ServiceInterface {
  CreateProposal: damlTypes.Choice<Service, CreateProposal, damlTypes.ContractId<Platform_Proposal_Model.Proposal>, Service.Key> & damlTypes.ChoiceFrom<damlTypes.Template<Service, Service.Key>>;
  RejectProposal: damlTypes.Choice<Service, RejectProposal, {}, Service.Key> & damlTypes.ChoiceFrom<damlTypes.Template<Service, Service.Key>>;
  DeleteProposal: damlTypes.Choice<Service, DeleteProposal, {}, Service.Key> & damlTypes.ChoiceFrom<damlTypes.Template<Service, Service.Key>>;
  AcceptProposal: damlTypes.Choice<Service, AcceptProposal, damlTypes.ContractId<Platform_Proposal_Model.Proposal>, Service.Key> & damlTypes.ChoiceFrom<damlTypes.Template<Service, Service.Key>>;
  SignProposal: damlTypes.Choice<Service, SignProposal, damlTypes.ContractId<Platform_Proposal_Model.Proposal>, Service.Key> & damlTypes.ChoiceFrom<damlTypes.Template<Service, Service.Key>>;
  RequestLeaseAgreement: damlTypes.Choice<Service, RequestLeaseAgreement, damlTypes.ContractId<Platform_LeaseAgreement_Service.Request>, Service.Key> & damlTypes.ChoiceFrom<damlTypes.Template<Service, Service.Key>>;
  Archive: damlTypes.Choice<Service, pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive, {}, Service.Key> & damlTypes.ChoiceFrom<damlTypes.Template<Service, Service.Key>>;
}
export declare const Service:
  damlTypes.Template<Service, Service.Key, 'f18eb482c25f64cd721de470f30dbf6a8247ca127e6e772be98e809b5cbf23a3:Platform.Proposal.Service:Service'> &
  damlTypes.ToInterface<Service, never> &
  ServiceInterface;

export declare namespace Service {
  export type Key = pkg40f452260bef3f29dede136108fc08a88d5a5250310281067087da6f0baddff7.DA.Types.Tuple2<damlTypes.Party, damlTypes.Party>
  export type CreateEvent = damlLedger.CreateEvent<Service, Service.Key, typeof Service.templateId>
  export type ArchiveEvent = damlLedger.ArchiveEvent<Service, typeof Service.templateId>
  export type Event = damlLedger.Event<Service, Service.Key, typeof Service.templateId>
  export type QueryResult = damlLedger.QueryResult<Service, Service.Key, typeof Service.templateId>
}



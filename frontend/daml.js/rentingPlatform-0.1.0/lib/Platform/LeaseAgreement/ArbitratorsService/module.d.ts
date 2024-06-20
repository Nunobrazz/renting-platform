// Generated from Platform/LeaseAgreement/ArbitratorsService.daml
/* eslint-disable @typescript-eslint/camelcase */
/* eslint-disable @typescript-eslint/no-namespace */
/* eslint-disable @typescript-eslint/no-use-before-define */
import * as jtv from '@mojotech/json-type-validation';
import * as damlTypes from '@daml/types';
/* eslint-disable-next-line @typescript-eslint/no-unused-vars */
import * as damlLedger from '@daml/ledger';

import * as pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662 from '@daml.js/d14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662';

import * as Interface_Types from '../../../Interface/Types/module';
import * as Platform_LeaseAgreement_ModelMI from '../../../Platform/LeaseAgreement/ModelMI/module';

export declare type Reject = {
};

export declare const Reject:
  damlTypes.Serializable<Reject> & {
  }
;


export declare type Approve = {
};

export declare const Approve:
  damlTypes.Serializable<Approve> & {
  }
;


export declare type Request = {
  arbitrator: damlTypes.Party;
  operator: damlTypes.Party;
};

export declare interface RequestInterface {
  Approve: damlTypes.Choice<Request, Approve, damlTypes.ContractId<Service>, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Request, undefined>>;
  Archive: damlTypes.Choice<Request, pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive, {}, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Request, undefined>>;
  Reject: damlTypes.Choice<Request, Reject, {}, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Request, undefined>>;
}
export declare const Request:
  damlTypes.Template<Request, undefined, 'bc781e57a3a4a4dfc87aa22b0be0e06d0b5fe4b9226e8df7f607a70d25c5fec4:Platform.LeaseAgreement.ArbitratorsService:Request'> &
  damlTypes.ToInterface<Request, never> &
  RequestInterface;

export declare namespace Request {
  export type CreateEvent = damlLedger.CreateEvent<Request, undefined, typeof Request.templateId>
  export type ArchiveEvent = damlLedger.ArchiveEvent<Request, typeof Request.templateId>
  export type Event = damlLedger.Event<Request, undefined, typeof Request.templateId>
  export type QueryResult = damlLedger.QueryResult<Request, undefined, typeof Request.templateId>
}



export declare type Decline = {
};

export declare const Decline:
  damlTypes.Serializable<Decline> & {
  }
;


export declare type Accept = {
};

export declare const Accept:
  damlTypes.Serializable<Accept> & {
  }
;


export declare type Offer = {
  operator: damlTypes.Party;
  arbitrator: damlTypes.Party;
};

export declare interface OfferInterface {
  Accept: damlTypes.Choice<Offer, Accept, damlTypes.ContractId<Service>, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Offer, undefined>>;
  Decline: damlTypes.Choice<Offer, Decline, {}, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Offer, undefined>>;
  Archive: damlTypes.Choice<Offer, pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive, {}, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Offer, undefined>>;
}
export declare const Offer:
  damlTypes.Template<Offer, undefined, 'bc781e57a3a4a4dfc87aa22b0be0e06d0b5fe4b9226e8df7f607a70d25c5fec4:Platform.LeaseAgreement.ArbitratorsService:Offer'> &
  damlTypes.ToInterface<Offer, never> &
  OfferInterface;

export declare namespace Offer {
  export type CreateEvent = damlLedger.CreateEvent<Offer, undefined, typeof Offer.templateId>
  export type ArchiveEvent = damlLedger.ArchiveEvent<Offer, typeof Offer.templateId>
  export type Event = damlLedger.Event<Offer, undefined, typeof Offer.templateId>
  export type QueryResult = damlLedger.QueryResult<Offer, undefined, typeof Offer.templateId>
}



export declare type FinalizeVotation = {
  votationCid: damlTypes.ContractId<Platform_LeaseAgreement_ModelMI.Votation>;
};

export declare const FinalizeVotation:
  damlTypes.Serializable<FinalizeVotation> & {
  }
;


export declare type SubmitVote = {
  vote: Interface_Types.Responsability;
  votationCid: damlTypes.ContractId<Platform_LeaseAgreement_ModelMI.Votation>;
};

export declare const SubmitVote:
  damlTypes.Serializable<SubmitVote> & {
  }
;


export declare type CreateVotation = {
  description: string;
  miCid: damlTypes.ContractId<Platform_LeaseAgreement_ModelMI.MI>;
  assessment: Interface_Types.AssessmentDetails;
};

export declare const CreateVotation:
  damlTypes.Serializable<CreateVotation> & {
  }
;


export declare type AcceptMI = {
  inviteArbitratorsCid: damlTypes.ContractId<Platform_LeaseAgreement_ModelMI.InviteArbitrators>;
};

export declare const AcceptMI:
  damlTypes.Serializable<AcceptMI> & {
  }
;


export declare type Service = {
  operator: damlTypes.Party;
  arbitrator: damlTypes.Party;
};

export declare interface ServiceInterface {
  AcceptMI: damlTypes.Choice<Service, AcceptMI, damlTypes.ContractId<Platform_LeaseAgreement_ModelMI.InviteArbitrators>, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Service, undefined>>;
  CreateVotation: damlTypes.Choice<Service, CreateVotation, damlTypes.ContractId<Platform_LeaseAgreement_ModelMI.Votation>, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Service, undefined>>;
  SubmitVote: damlTypes.Choice<Service, SubmitVote, damlTypes.ContractId<Platform_LeaseAgreement_ModelMI.Votation>, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Service, undefined>>;
  FinalizeVotation: damlTypes.Choice<Service, FinalizeVotation, damlTypes.ContractId<Platform_LeaseAgreement_ModelMI.MI>, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Service, undefined>>;
  Archive: damlTypes.Choice<Service, pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive, {}, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Service, undefined>>;
}
export declare const Service:
  damlTypes.Template<Service, undefined, 'bc781e57a3a4a4dfc87aa22b0be0e06d0b5fe4b9226e8df7f607a70d25c5fec4:Platform.LeaseAgreement.ArbitratorsService:Service'> &
  damlTypes.ToInterface<Service, never> &
  ServiceInterface;

export declare namespace Service {
  export type CreateEvent = damlLedger.CreateEvent<Service, undefined, typeof Service.templateId>
  export type ArchiveEvent = damlLedger.ArchiveEvent<Service, typeof Service.templateId>
  export type Event = damlLedger.Event<Service, undefined, typeof Service.templateId>
  export type QueryResult = damlLedger.QueryResult<Service, undefined, typeof Service.templateId>
}



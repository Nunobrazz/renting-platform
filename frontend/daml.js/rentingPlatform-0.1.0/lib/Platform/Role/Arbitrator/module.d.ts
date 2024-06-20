// Generated from Platform/Role/Arbitrator.daml
/* eslint-disable @typescript-eslint/camelcase */
/* eslint-disable @typescript-eslint/no-namespace */
/* eslint-disable @typescript-eslint/no-use-before-define */
import * as jtv from '@mojotech/json-type-validation';
import * as damlTypes from '@daml/types';
/* eslint-disable-next-line @typescript-eslint/no-unused-vars */
import * as damlLedger from '@daml/ledger';

import * as pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657 from '@daml.js/97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657';
import * as pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662 from '@daml.js/d14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662';

import * as Platform_Interface_Types from '../../../Platform/Interface/Types/module';
import * as Platform_LeaseAgreement_ModelMI from '../../../Platform/LeaseAgreement/ModelMI/module';

export declare type Reject = {
};

export declare const Reject:
  damlTypes.Serializable<Reject> & {
  }
;


export declare type Approve = {
  roleCid: damlTypes.ContractId<Arbitrators>;
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
  Approve: damlTypes.Choice<Request, Approve, damlTypes.ContractId<Arbitrators>, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Request, undefined>>;
  Archive: damlTypes.Choice<Request, pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive, {}, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Request, undefined>>;
  Reject: damlTypes.Choice<Request, Reject, {}, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Request, undefined>>;
}
export declare const Request:
  damlTypes.Template<Request, undefined, 'da53d310d1daf7739100e96d59bcf2f5b4ec44d2a1b3f47b9a0c35b489c6ab49:Platform.Role.Arbitrator:Request'> &
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
  roleCid: damlTypes.ContractId<Arbitrators>;
};

export declare interface OfferInterface {
  Accept: damlTypes.Choice<Offer, Accept, damlTypes.ContractId<Arbitrators>, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Offer, undefined>>;
  Decline: damlTypes.Choice<Offer, Decline, {}, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Offer, undefined>>;
  Archive: damlTypes.Choice<Offer, pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive, {}, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Offer, undefined>>;
}
export declare const Offer:
  damlTypes.Template<Offer, undefined, 'da53d310d1daf7739100e96d59bcf2f5b4ec44d2a1b3f47b9a0c35b489c6ab49:Platform.Role.Arbitrator:Offer'> &
  damlTypes.ToInterface<Offer, never> &
  OfferInterface;

export declare namespace Offer {
  export type CreateEvent = damlLedger.CreateEvent<Offer, undefined, typeof Offer.templateId>
  export type ArchiveEvent = damlLedger.ArchiveEvent<Offer, typeof Offer.templateId>
  export type Event = damlLedger.Event<Offer, undefined, typeof Offer.templateId>
  export type QueryResult = damlLedger.QueryResult<Offer, undefined, typeof Offer.templateId>
}



export declare type FinalizeVotation = {
  finalizer: damlTypes.Party;
  votationCid: damlTypes.ContractId<Platform_LeaseAgreement_ModelMI.Votation>;
};

export declare const FinalizeVotation:
  damlTypes.Serializable<FinalizeVotation> & {
  }
;


export declare type SubmitVote = {
  voter: damlTypes.Party;
  vote: Platform_Interface_Types.AssessmentDetails;
  votationCid: damlTypes.ContractId<Platform_LeaseAgreement_ModelMI.Votation>;
};

export declare const SubmitVote:
  damlTypes.Serializable<SubmitVote> & {
  }
;


export declare type CreateVotation = {
  creator: damlTypes.Party;
  description: string;
  miKey: Platform_Interface_Types.MIkey;
  vote: Platform_Interface_Types.AssessmentDetails;
};

export declare const CreateVotation:
  damlTypes.Serializable<CreateVotation> & {
  }
;


export declare type AssignArbitrators = {
  inviteArbitratorsCid: damlTypes.ContractId<Platform_LeaseAgreement_ModelMI.InviteArbitrators>;
};

export declare const AssignArbitrators:
  damlTypes.Serializable<AssignArbitrators> & {
  }
;


export declare type AcceptMI = {
  inviteArbitratorsCid: damlTypes.ContractId<Platform_LeaseAgreement_ModelMI.InviteArbitrators>;
  arbitrator: damlTypes.Party;
};

export declare const AcceptMI:
  damlTypes.Serializable<AcceptMI> & {
  }
;


export declare type InviteArbitrators = {
  miKey: Platform_Interface_Types.MIkey;
};

export declare const InviteArbitrators:
  damlTypes.Serializable<InviteArbitrators> & {
  }
;


export declare type AddArbitrator = {
  arbitrator: damlTypes.Party;
};

export declare const AddArbitrator:
  damlTypes.Serializable<AddArbitrator> & {
  }
;


export declare type Arbitrators = {
  operator: damlTypes.Party;
  arbitrators: pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657.DA.Set.Types.Set<damlTypes.Party>;
};

export declare interface ArbitratorsInterface {
  AddArbitrator: damlTypes.Choice<Arbitrators, AddArbitrator, damlTypes.ContractId<Arbitrators>, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Arbitrators, undefined>>;
  InviteArbitrators: damlTypes.Choice<Arbitrators, InviteArbitrators, damlTypes.ContractId<Platform_LeaseAgreement_ModelMI.InviteArbitrators>, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Arbitrators, undefined>>;
  AcceptMI: damlTypes.Choice<Arbitrators, AcceptMI, damlTypes.ContractId<Platform_LeaseAgreement_ModelMI.InviteArbitrators>, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Arbitrators, undefined>>;
  AssignArbitrators: damlTypes.Choice<Arbitrators, AssignArbitrators, damlTypes.ContractId<Platform_LeaseAgreement_ModelMI.MI>, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Arbitrators, undefined>>;
  CreateVotation: damlTypes.Choice<Arbitrators, CreateVotation, damlTypes.ContractId<Platform_LeaseAgreement_ModelMI.Votation>, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Arbitrators, undefined>>;
  SubmitVote: damlTypes.Choice<Arbitrators, SubmitVote, damlTypes.ContractId<Platform_LeaseAgreement_ModelMI.Votation>, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Arbitrators, undefined>>;
  FinalizeVotation: damlTypes.Choice<Arbitrators, FinalizeVotation, damlTypes.ContractId<Platform_LeaseAgreement_ModelMI.MI>, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Arbitrators, undefined>>;
  Archive: damlTypes.Choice<Arbitrators, pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive, {}, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Arbitrators, undefined>>;
}
export declare const Arbitrators:
  damlTypes.Template<Arbitrators, undefined, 'da53d310d1daf7739100e96d59bcf2f5b4ec44d2a1b3f47b9a0c35b489c6ab49:Platform.Role.Arbitrator:Arbitrators'> &
  damlTypes.ToInterface<Arbitrators, never> &
  ArbitratorsInterface;

export declare namespace Arbitrators {
  export type CreateEvent = damlLedger.CreateEvent<Arbitrators, undefined, typeof Arbitrators.templateId>
  export type ArchiveEvent = damlLedger.ArchiveEvent<Arbitrators, typeof Arbitrators.templateId>
  export type Event = damlLedger.Event<Arbitrators, undefined, typeof Arbitrators.templateId>
  export type QueryResult = damlLedger.QueryResult<Arbitrators, undefined, typeof Arbitrators.templateId>
}



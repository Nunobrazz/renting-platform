// Generated from Platform/LeaseAgreement/Service.daml
/* eslint-disable @typescript-eslint/camelcase */
/* eslint-disable @typescript-eslint/no-namespace */
/* eslint-disable @typescript-eslint/no-use-before-define */
import * as jtv from '@mojotech/json-type-validation';
import * as damlTypes from '@daml/types';
/* eslint-disable-next-line @typescript-eslint/no-unused-vars */
import * as damlLedger from '@daml/ledger';

import * as pkg40f452260bef3f29dede136108fc08a88d5a5250310281067087da6f0baddff7 from '@daml.js/40f452260bef3f29dede136108fc08a88d5a5250310281067087da6f0baddff7';
import * as pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657 from '@daml.js/97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657';
import * as pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662 from '@daml.js/d14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662';

import * as Platform_LeaseAgreement_ModelMI from '../../../Platform/LeaseAgreement/ModelMI/module';
import * as Platform_Types_Common from '../../../Platform/Types/Common/module';
import * as Platform_Types_LA from '../../../Platform/Types/LA/module';
import * as Platform_Types_MI from '../../../Platform/Types/MI/module';

export declare type Approve = {
  lifecycler: damlTypes.Party;
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
  leaseTerms: Platform_Types_Common.LeaseTerms;
};

export declare interface RequestInterface {
  Withdraw: damlTypes.Choice<Request, Withdraw, {}, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Request, undefined>>;
  Reject: damlTypes.Choice<Request, Reject, {}, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Request, undefined>>;
  Archive: damlTypes.Choice<Request, pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive, {}, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Request, undefined>>;
  Approve: damlTypes.Choice<Request, Approve, damlTypes.ContractId<Service>, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Request, undefined>>;
}
export declare const Request:
  damlTypes.Template<Request, undefined, 'f18eb482c25f64cd721de470f30dbf6a8247ca127e6e772be98e809b5cbf23a3:Platform.LeaseAgreement.Service:Request'> &
  damlTypes.ToInterface<Request, never> &
  RequestInterface;

export declare namespace Request {
  export type CreateEvent = damlLedger.CreateEvent<Request, undefined, typeof Request.templateId>
  export type ArchiveEvent = damlLedger.ArchiveEvent<Request, typeof Request.templateId>
  export type Event = damlLedger.Event<Request, undefined, typeof Request.templateId>
  export type QueryResult = damlLedger.QueryResult<Request, undefined, typeof Request.templateId>
}



export declare type FinalizeInvitation = {
  inviter: damlTypes.Party;
  invitationCid: damlTypes.ContractId<Platform_LeaseAgreement_ModelMI.InviteArbitrators>;
};

export declare const FinalizeInvitation:
  damlTypes.Serializable<FinalizeInvitation> & {
  }
;


export declare type InvokeArbitrators = {
  inviter: damlTypes.Party;
  invited: pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657.DA.Set.Types.Set<damlTypes.Party>;
  miReportCid: damlTypes.ContractId<Platform_LeaseAgreement_ModelMI.MIReport>;
};

export declare const InvokeArbitrators:
  damlTypes.Serializable<InvokeArbitrators> & {
  }
;


export declare type AcceptAssessment = {
  signer: damlTypes.Party;
  assessmentCid: damlTypes.ContractId<Platform_LeaseAgreement_ModelMI.Assessment>;
};

export declare const AcceptAssessment:
  damlTypes.Serializable<AcceptAssessment> & {
  }
;


export declare type SubmitAssessment = {
  creator: damlTypes.Party;
  signer: damlTypes.Party;
  assessment: Platform_Types_MI.AssessmentDetails;
  miReportCid: damlTypes.ContractId<Platform_LeaseAgreement_ModelMI.MIReport>;
};

export declare const SubmitAssessment:
  damlTypes.Serializable<SubmitAssessment> & {
  }
;


export declare type CreateMI = {
  reporter: damlTypes.Party;
  house: Platform_Types_Common.House;
  description: string;
  startingDate: damlTypes.Date;
};

export declare const CreateMI:
  damlTypes.Serializable<CreateMI> & {
  }
;


export declare type Service = {
  operator: damlTypes.Party;
  host: damlTypes.Party;
  tenant: damlTypes.Party;
  laKey: Platform_Types_LA.LAkey;
};

export declare interface ServiceInterface {
  CreateMI: damlTypes.Choice<Service, CreateMI, damlTypes.ContractId<Platform_LeaseAgreement_ModelMI.MIReport>, Service.Key> & damlTypes.ChoiceFrom<damlTypes.Template<Service, Service.Key>>;
  SubmitAssessment: damlTypes.Choice<Service, SubmitAssessment, damlTypes.ContractId<Platform_LeaseAgreement_ModelMI.Assessment>, Service.Key> & damlTypes.ChoiceFrom<damlTypes.Template<Service, Service.Key>>;
  AcceptAssessment: damlTypes.Choice<Service, AcceptAssessment, damlTypes.ContractId<Platform_LeaseAgreement_ModelMI.MIresultFriendly>, Service.Key> & damlTypes.ChoiceFrom<damlTypes.Template<Service, Service.Key>>;
  InvokeArbitrators: damlTypes.Choice<Service, InvokeArbitrators, damlTypes.ContractId<Platform_LeaseAgreement_ModelMI.InviteArbitrators>, Service.Key> & damlTypes.ChoiceFrom<damlTypes.Template<Service, Service.Key>>;
  FinalizeInvitation: damlTypes.Choice<Service, FinalizeInvitation, damlTypes.ContractId<Platform_LeaseAgreement_ModelMI.MIReport>, Service.Key> & damlTypes.ChoiceFrom<damlTypes.Template<Service, Service.Key>>;
  Archive: damlTypes.Choice<Service, pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive, {}, Service.Key> & damlTypes.ChoiceFrom<damlTypes.Template<Service, Service.Key>>;
}
export declare const Service:
  damlTypes.Template<Service, Service.Key, 'f18eb482c25f64cd721de470f30dbf6a8247ca127e6e772be98e809b5cbf23a3:Platform.LeaseAgreement.Service:Service'> &
  damlTypes.ToInterface<Service, never> &
  ServiceInterface;

export declare namespace Service {
  export type Key = pkg40f452260bef3f29dede136108fc08a88d5a5250310281067087da6f0baddff7.DA.Types.Tuple2<damlTypes.Party, damlTypes.Party>
  export type CreateEvent = damlLedger.CreateEvent<Service, Service.Key, typeof Service.templateId>
  export type ArchiveEvent = damlLedger.ArchiveEvent<Service, typeof Service.templateId>
  export type Event = damlLedger.Event<Service, Service.Key, typeof Service.templateId>
  export type QueryResult = damlLedger.QueryResult<Service, Service.Key, typeof Service.templateId>
}



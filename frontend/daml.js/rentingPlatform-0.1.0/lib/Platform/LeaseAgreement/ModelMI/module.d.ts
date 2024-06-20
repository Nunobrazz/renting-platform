// Generated from Platform/LeaseAgreement/ModelMI.daml
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

import * as Platform_Types_MI from '../../../Platform/Types/MI/module';

export declare type MIresultFriendly = {
  assessmentCreator: damlTypes.Party;
  assessmentSigner: damlTypes.Party;
  miDetails: Platform_Types_MI.MIdetails;
  assessment: Platform_Types_MI.AssessmentDetails;
};

export declare interface MIresultFriendlyInterface {
  Archive: damlTypes.Choice<MIresultFriendly, pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive, {}, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<MIresultFriendly, undefined>>;
}
export declare const MIresultFriendly:
  damlTypes.Template<MIresultFriendly, undefined, 'f18eb482c25f64cd721de470f30dbf6a8247ca127e6e772be98e809b5cbf23a3:Platform.LeaseAgreement.ModelMI:MIresultFriendly'> &
  damlTypes.ToInterface<MIresultFriendly, never> &
  MIresultFriendlyInterface;

export declare namespace MIresultFriendly {
  export type CreateEvent = damlLedger.CreateEvent<MIresultFriendly, undefined, typeof MIresultFriendly.templateId>
  export type ArchiveEvent = damlLedger.ArchiveEvent<MIresultFriendly, typeof MIresultFriendly.templateId>
  export type Event = damlLedger.Event<MIresultFriendly, undefined, typeof MIresultFriendly.templateId>
  export type QueryResult = damlLedger.QueryResult<MIresultFriendly, undefined, typeof MIresultFriendly.templateId>
}



export declare type MIresultArbitrators = {
  tenant: damlTypes.Party;
  host: damlTypes.Party;
  miDetails: Platform_Types_MI.MIdetails;
  arbitrators: pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657.DA.Set.Types.Set<damlTypes.Party>;
  visitor: damlTypes.Party;
  visitDetails: string;
  assessment: Platform_Types_MI.AssessmentDetails;
};

export declare interface MIresultArbitratorsInterface {
  Archive: damlTypes.Choice<MIresultArbitrators, pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive, {}, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<MIresultArbitrators, undefined>>;
}
export declare const MIresultArbitrators:
  damlTypes.Template<MIresultArbitrators, undefined, 'f18eb482c25f64cd721de470f30dbf6a8247ca127e6e772be98e809b5cbf23a3:Platform.LeaseAgreement.ModelMI:MIresultArbitrators'> &
  damlTypes.ToInterface<MIresultArbitrators, never> &
  MIresultArbitratorsInterface;

export declare namespace MIresultArbitrators {
  export type CreateEvent = damlLedger.CreateEvent<MIresultArbitrators, undefined, typeof MIresultArbitrators.templateId>
  export type ArchiveEvent = damlLedger.ArchiveEvent<MIresultArbitrators, typeof MIresultArbitrators.templateId>
  export type Event = damlLedger.Event<MIresultArbitrators, undefined, typeof MIresultArbitrators.templateId>
  export type QueryResult = damlLedger.QueryResult<MIresultArbitrators, undefined, typeof MIresultArbitrators.templateId>
}



export declare type SignAssessment = {
  signer: damlTypes.Party;
};

export declare const SignAssessment:
  damlTypes.Serializable<SignAssessment> & {
  }
;


export declare type Assessment = {
  creator: damlTypes.Party;
  signer: damlTypes.Party;
  assessment: Platform_Types_MI.AssessmentDetails;
  miDetails: Platform_Types_MI.MIdetails;
};

export declare interface AssessmentInterface {
  Archive: damlTypes.Choice<Assessment, pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive, {}, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Assessment, undefined>>;
  SignAssessment: damlTypes.Choice<Assessment, SignAssessment, damlTypes.ContractId<MIresultFriendly>, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Assessment, undefined>>;
}
export declare const Assessment:
  damlTypes.Template<Assessment, undefined, 'f18eb482c25f64cd721de470f30dbf6a8247ca127e6e772be98e809b5cbf23a3:Platform.LeaseAgreement.ModelMI:Assessment'> &
  damlTypes.ToInterface<Assessment, never> &
  AssessmentInterface;

export declare namespace Assessment {
  export type CreateEvent = damlLedger.CreateEvent<Assessment, undefined, typeof Assessment.templateId>
  export type ArchiveEvent = damlLedger.ArchiveEvent<Assessment, typeof Assessment.templateId>
  export type Event = damlLedger.Event<Assessment, undefined, typeof Assessment.templateId>
  export type QueryResult = damlLedger.QueryResult<Assessment, undefined, typeof Assessment.templateId>
}



export declare type FinalizeVotation = {
  finalizer: damlTypes.Party;
};

export declare const FinalizeVotation:
  damlTypes.Serializable<FinalizeVotation> & {
  }
;


export declare type Vote = {
  voter: damlTypes.Party;
  vote: Platform_Types_MI.Responsability;
};

export declare const Vote:
  damlTypes.Serializable<Vote> & {
  }
;


export declare type Votation = {
  tenant: damlTypes.Party;
  host: damlTypes.Party;
  miDetails: Platform_Types_MI.MIdetails;
  visitor: damlTypes.Party;
  visitDetails: string;
  voters: pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657.DA.Set.Types.Set<damlTypes.Party>;
  miReportCid: damlTypes.ContractId<MIReport>;
  alreadyVoted: pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657.DA.Set.Types.Set<damlTypes.Party>;
  result: Platform_Types_MI.AssessmentDetails;
};

export declare interface VotationInterface {
  Archive: damlTypes.Choice<Votation, pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive, {}, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Votation, undefined>>;
  Vote: damlTypes.Choice<Votation, Vote, damlTypes.ContractId<Votation>, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Votation, undefined>>;
  FinalizeVotation: damlTypes.Choice<Votation, FinalizeVotation, damlTypes.ContractId<MIresultArbitrators>, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Votation, undefined>>;
}
export declare const Votation:
  damlTypes.Template<Votation, undefined, 'f18eb482c25f64cd721de470f30dbf6a8247ca127e6e772be98e809b5cbf23a3:Platform.LeaseAgreement.ModelMI:Votation'> &
  damlTypes.ToInterface<Votation, never> &
  VotationInterface;

export declare namespace Votation {
  export type CreateEvent = damlLedger.CreateEvent<Votation, undefined, typeof Votation.templateId>
  export type ArchiveEvent = damlLedger.ArchiveEvent<Votation, typeof Votation.templateId>
  export type Event = damlLedger.Event<Votation, undefined, typeof Votation.templateId>
  export type QueryResult = damlLedger.QueryResult<Votation, undefined, typeof Votation.templateId>
}



export declare type ConfirmAttribution = {
  inviter: damlTypes.Party;
};

export declare const ConfirmAttribution:
  damlTypes.Serializable<ConfirmAttribution> & {
  }
;


export declare type Accept = {
  arbitrator: damlTypes.Party;
};

export declare const Accept:
  damlTypes.Serializable<Accept> & {
  }
;


export declare type InviteArbitrators = {
  inviter: damlTypes.Party;
  invited: pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657.DA.Set.Types.Set<damlTypes.Party>;
  confirmed: pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657.DA.Set.Types.Set<damlTypes.Party>;
  miDetails: Platform_Types_MI.MIdetails;
  miReportCid: damlTypes.ContractId<MIReport>;
};

export declare interface InviteArbitratorsInterface {
  Archive: damlTypes.Choice<InviteArbitrators, pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive, {}, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<InviteArbitrators, undefined>>;
  Accept: damlTypes.Choice<InviteArbitrators, Accept, damlTypes.ContractId<InviteArbitrators>, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<InviteArbitrators, undefined>>;
  ConfirmAttribution: damlTypes.Choice<InviteArbitrators, ConfirmAttribution, damlTypes.ContractId<MIReport>, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<InviteArbitrators, undefined>>;
}
export declare const InviteArbitrators:
  damlTypes.Template<InviteArbitrators, undefined, 'f18eb482c25f64cd721de470f30dbf6a8247ca127e6e772be98e809b5cbf23a3:Platform.LeaseAgreement.ModelMI:InviteArbitrators'> &
  damlTypes.ToInterface<InviteArbitrators, never> &
  InviteArbitratorsInterface;

export declare namespace InviteArbitrators {
  export type CreateEvent = damlLedger.CreateEvent<InviteArbitrators, undefined, typeof InviteArbitrators.templateId>
  export type ArchiveEvent = damlLedger.ArchiveEvent<InviteArbitrators, typeof InviteArbitrators.templateId>
  export type Event = damlLedger.Event<InviteArbitrators, undefined, typeof InviteArbitrators.templateId>
  export type QueryResult = damlLedger.QueryResult<InviteArbitrators, undefined, typeof InviteArbitrators.templateId>
}



export declare type CreateVotation = {
  visitor: damlTypes.Party;
  visitDetails: string;
  assessment: Platform_Types_MI.AssessmentDetails;
};

export declare const CreateVotation:
  damlTypes.Serializable<CreateVotation> & {
  }
;


export declare type SetArbitrators = {
  inviter: damlTypes.Party;
  arbitrators: pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657.DA.Set.Types.Set<damlTypes.Party>;
};

export declare const SetArbitrators:
  damlTypes.Serializable<SetArbitrators> & {
  }
;


export declare type MIReport = {
  tenant: damlTypes.Party;
  host: damlTypes.Party;
  miDetails: Platform_Types_MI.MIdetails;
  arbitrators: pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657.DA.Set.Types.Set<damlTypes.Party>;
};

export declare interface MIReportInterface {
  Archive: damlTypes.Choice<MIReport, pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive, {}, MIReport.Key> & damlTypes.ChoiceFrom<damlTypes.Template<MIReport, MIReport.Key>>;
  SetArbitrators: damlTypes.Choice<MIReport, SetArbitrators, damlTypes.ContractId<MIReport>, MIReport.Key> & damlTypes.ChoiceFrom<damlTypes.Template<MIReport, MIReport.Key>>;
  CreateVotation: damlTypes.Choice<MIReport, CreateVotation, damlTypes.ContractId<Votation>, MIReport.Key> & damlTypes.ChoiceFrom<damlTypes.Template<MIReport, MIReport.Key>>;
}
export declare const MIReport:
  damlTypes.Template<MIReport, MIReport.Key, 'f18eb482c25f64cd721de470f30dbf6a8247ca127e6e772be98e809b5cbf23a3:Platform.LeaseAgreement.ModelMI:MIReport'> &
  damlTypes.ToInterface<MIReport, never> &
  MIReportInterface;

export declare namespace MIReport {
  export type Key = pkg40f452260bef3f29dede136108fc08a88d5a5250310281067087da6f0baddff7.DA.Types.Tuple3<damlTypes.Party, damlTypes.Party, Platform_Types_MI.MIdetails>
  export type CreateEvent = damlLedger.CreateEvent<MIReport, MIReport.Key, typeof MIReport.templateId>
  export type ArchiveEvent = damlLedger.ArchiveEvent<MIReport, typeof MIReport.templateId>
  export type Event = damlLedger.Event<MIReport, MIReport.Key, typeof MIReport.templateId>
  export type QueryResult = damlLedger.QueryResult<MIReport, MIReport.Key, typeof MIReport.templateId>
}



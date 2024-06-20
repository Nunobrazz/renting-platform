// Generated from Platform/Role/Operator.daml
/* eslint-disable @typescript-eslint/camelcase */
/* eslint-disable @typescript-eslint/no-namespace */
/* eslint-disable @typescript-eslint/no-use-before-define */
import * as jtv from '@mojotech/json-type-validation';
import * as damlTypes from '@daml/types';
/* eslint-disable-next-line @typescript-eslint/no-unused-vars */
import * as damlLedger from '@daml/ledger';

import * as pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662 from '@daml.js/d14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662';

import * as Platform_LeaseAgreement_Service from '../../../Platform/LeaseAgreement/Service/module';
import * as Platform_Proposal_Service from '../../../Platform/Proposal/Service/module';

export declare type ApproveLeaseAgreementService = {
  laServiceReqCid: damlTypes.ContractId<Platform_LeaseAgreement_Service.Request>;
  lifecycler: damlTypes.Party;
};

export declare const ApproveLeaseAgreementService:
  damlTypes.Serializable<ApproveLeaseAgreementService> & {
  }
;


export declare type ApproveProposalServiceRequest = {
  proposalReqCid: damlTypes.ContractId<Platform_Proposal_Service.Request>;
};

export declare const ApproveProposalServiceRequest:
  damlTypes.Serializable<ApproveProposalServiceRequest> & {
  }
;


export declare type Role = {
  operator: damlTypes.Party;
};

export declare interface RoleInterface {
  ApproveProposalServiceRequest: damlTypes.Choice<Role, ApproveProposalServiceRequest, damlTypes.ContractId<Platform_Proposal_Service.Service>, Role.Key> & damlTypes.ChoiceFrom<damlTypes.Template<Role, Role.Key>>;
  Archive: damlTypes.Choice<Role, pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive, {}, Role.Key> & damlTypes.ChoiceFrom<damlTypes.Template<Role, Role.Key>>;
  ApproveLeaseAgreementService: damlTypes.Choice<Role, ApproveLeaseAgreementService, damlTypes.ContractId<Platform_LeaseAgreement_Service.Service>, Role.Key> & damlTypes.ChoiceFrom<damlTypes.Template<Role, Role.Key>>;
}
export declare const Role:
  damlTypes.Template<Role, Role.Key, 'f18eb482c25f64cd721de470f30dbf6a8247ca127e6e772be98e809b5cbf23a3:Platform.Role.Operator:Role'> &
  damlTypes.ToInterface<Role, never> &
  RoleInterface;

export declare namespace Role {
  export type Key = damlTypes.Party
  export type CreateEvent = damlLedger.CreateEvent<Role, Role.Key, typeof Role.templateId>
  export type ArchiveEvent = damlLedger.ArchiveEvent<Role, typeof Role.templateId>
  export type Event = damlLedger.Event<Role, Role.Key, typeof Role.templateId>
  export type QueryResult = damlLedger.QueryResult<Role, Role.Key, typeof Role.templateId>
}



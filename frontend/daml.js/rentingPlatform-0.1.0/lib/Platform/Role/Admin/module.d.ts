// Generated from Platform/Role/Admin.daml
/* eslint-disable @typescript-eslint/camelcase */
/* eslint-disable @typescript-eslint/no-namespace */
/* eslint-disable @typescript-eslint/no-use-before-define */
import * as jtv from '@mojotech/json-type-validation';
import * as damlTypes from '@daml/types';
/* eslint-disable-next-line @typescript-eslint/no-unused-vars */
import * as damlLedger from '@daml/ledger';

import * as pkg40f452260bef3f29dede136108fc08a88d5a5250310281067087da6f0baddff7 from '@daml.js/40f452260bef3f29dede136108fc08a88d5a5250310281067087da6f0baddff7';
import * as pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662 from '@daml.js/d14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662';

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
  admin: damlTypes.Party;
  operator: damlTypes.Party;
};

export declare interface RequestInterface {
  Approve: damlTypes.Choice<Request, Approve, damlTypes.ContractId<Role>, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Request, undefined>>;
  Archive: damlTypes.Choice<Request, pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive, {}, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Request, undefined>>;
  Reject: damlTypes.Choice<Request, Reject, {}, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Request, undefined>>;
}
export declare const Request:
  damlTypes.Template<Request, undefined, 'bc781e57a3a4a4dfc87aa22b0be0e06d0b5fe4b9226e8df7f607a70d25c5fec4:Platform.Role.Admin:Request'> &
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
  admin: damlTypes.Party;
};

export declare interface OfferInterface {
  Accept: damlTypes.Choice<Offer, Accept, damlTypes.ContractId<Role>, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Offer, undefined>>;
  Decline: damlTypes.Choice<Offer, Decline, {}, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Offer, undefined>>;
  Archive: damlTypes.Choice<Offer, pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive, {}, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Offer, undefined>>;
}
export declare const Offer:
  damlTypes.Template<Offer, undefined, 'bc781e57a3a4a4dfc87aa22b0be0e06d0b5fe4b9226e8df7f607a70d25c5fec4:Platform.Role.Admin:Offer'> &
  damlTypes.ToInterface<Offer, never> &
  OfferInterface;

export declare namespace Offer {
  export type CreateEvent = damlLedger.CreateEvent<Offer, undefined, typeof Offer.templateId>
  export type ArchiveEvent = damlLedger.ArchiveEvent<Offer, typeof Offer.templateId>
  export type Event = damlLedger.Event<Offer, undefined, typeof Offer.templateId>
  export type QueryResult = damlLedger.QueryResult<Offer, undefined, typeof Offer.templateId>
}



export declare type Role = {
  admin: damlTypes.Party;
  operator: damlTypes.Party;
};

export declare interface RoleInterface {
  Archive: damlTypes.Choice<Role, pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive, {}, Role.Key> & damlTypes.ChoiceFrom<damlTypes.Template<Role, Role.Key>>;
}
export declare const Role:
  damlTypes.Template<Role, Role.Key, 'bc781e57a3a4a4dfc87aa22b0be0e06d0b5fe4b9226e8df7f607a70d25c5fec4:Platform.Role.Admin:Role'> &
  damlTypes.ToInterface<Role, never> &
  RoleInterface;

export declare namespace Role {
  export type Key = pkg40f452260bef3f29dede136108fc08a88d5a5250310281067087da6f0baddff7.DA.Types.Tuple2<damlTypes.Party, damlTypes.Party>
  export type CreateEvent = damlLedger.CreateEvent<Role, Role.Key, typeof Role.templateId>
  export type ArchiveEvent = damlLedger.ArchiveEvent<Role, typeof Role.templateId>
  export type Event = damlLedger.Event<Role, Role.Key, typeof Role.templateId>
  export type QueryResult = damlLedger.QueryResult<Role, Role.Key, typeof Role.templateId>
}



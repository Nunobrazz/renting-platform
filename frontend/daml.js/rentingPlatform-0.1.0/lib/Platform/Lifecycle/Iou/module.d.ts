// Generated from Platform/Lifecycle/Iou.daml
/* eslint-disable @typescript-eslint/camelcase */
/* eslint-disable @typescript-eslint/no-namespace */
/* eslint-disable @typescript-eslint/no-use-before-define */
import * as jtv from '@mojotech/json-type-validation';
import * as damlTypes from '@daml/types';
/* eslint-disable-next-line @typescript-eslint/no-unused-vars */
import * as damlLedger from '@daml/ledger';

import * as pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662 from '@daml.js/d14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662';

export declare type Iou = {
  creator: damlTypes.Party;
  debtor: damlTypes.Party;
  owner: damlTypes.Party;
  amount: damlTypes.Int;
};

export declare interface IouInterface {
  Archive: damlTypes.Choice<Iou, pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive, {}, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Iou, undefined>>;
}
export declare const Iou:
  damlTypes.Template<Iou, undefined, '686bd5d09f27512a24df24b750340cc9b1d484210591ec480915da92fe71121e:Platform.Lifecycle.Iou:Iou'> &
  damlTypes.ToInterface<Iou, never> &
  IouInterface;

export declare namespace Iou {
  export type CreateEvent = damlLedger.CreateEvent<Iou, undefined, typeof Iou.templateId>
  export type ArchiveEvent = damlLedger.ArchiveEvent<Iou, typeof Iou.templateId>
  export type Event = damlLedger.Event<Iou, undefined, typeof Iou.templateId>
  export type QueryResult = damlLedger.QueryResult<Iou, undefined, typeof Iou.templateId>
}



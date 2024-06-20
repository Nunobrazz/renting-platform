// Generated from Time/Lifecycle/Iou.daml
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
  paymentDate: damlTypes.Date;
  creationDate: damlTypes.Date;
};

export declare interface IouInterface {
  Archive: damlTypes.Choice<Iou, pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive, {}, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Iou, undefined>>;
}
export declare const Iou:
  damlTypes.Template<Iou, undefined, 'f18eb482c25f64cd721de470f30dbf6a8247ca127e6e772be98e809b5cbf23a3:Time.Lifecycle.Iou:Iou'> &
  damlTypes.ToInterface<Iou, never> &
  IouInterface;

export declare namespace Iou {
  export type CreateEvent = damlLedger.CreateEvent<Iou, undefined, typeof Iou.templateId>
  export type ArchiveEvent = damlLedger.ArchiveEvent<Iou, typeof Iou.templateId>
  export type Event = damlLedger.Event<Iou, undefined, typeof Iou.templateId>
  export type QueryResult = damlLedger.QueryResult<Iou, undefined, typeof Iou.templateId>
}



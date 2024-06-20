// Generated from Time/Clock.daml
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

export declare type Advance = {
  days: damlTypes.Int;
};

export declare const Advance:
  damlTypes.Serializable<Advance> & {
  }
;


export declare type DateClock = {
  provider: damlTypes.Party;
  clockDate: damlTypes.Date;
  description: string;
  observers: pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657.DA.Set.Types.Set<damlTypes.Party>;
};

export declare interface DateClockInterface {
  Advance: damlTypes.Choice<DateClock, Advance, damlTypes.ContractId<DateClock>, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<DateClock, undefined>>;
  Archive: damlTypes.Choice<DateClock, pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive, {}, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<DateClock, undefined>>;
}
export declare const DateClock:
  damlTypes.Template<DateClock, undefined, 'f18eb482c25f64cd721de470f30dbf6a8247ca127e6e772be98e809b5cbf23a3:Time.Clock:DateClock'> &
  damlTypes.ToInterface<DateClock, never> &
  DateClockInterface;

export declare namespace DateClock {
  export type CreateEvent = damlLedger.CreateEvent<DateClock, undefined, typeof DateClock.templateId>
  export type ArchiveEvent = damlLedger.ArchiveEvent<DateClock, typeof DateClock.templateId>
  export type Event = damlLedger.Event<DateClock, undefined, typeof DateClock.templateId>
  export type QueryResult = damlLedger.QueryResult<DateClock, undefined, typeof DateClock.templateId>
}



export declare type DateClockUpdateEvent = {
  provider: damlTypes.Party;
  eventDate: damlTypes.Date;
  observers: pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657.DA.Set.Types.Set<damlTypes.Party>;
};

export declare interface DateClockUpdateEventInterface {
  Archive: damlTypes.Choice<DateClockUpdateEvent, pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive, {}, DateClockUpdateEvent.Key> & damlTypes.ChoiceFrom<damlTypes.Template<DateClockUpdateEvent, DateClockUpdateEvent.Key>>;
}
export declare const DateClockUpdateEvent:
  damlTypes.Template<DateClockUpdateEvent, DateClockUpdateEvent.Key, 'f18eb482c25f64cd721de470f30dbf6a8247ca127e6e772be98e809b5cbf23a3:Time.Clock:DateClockUpdateEvent'> &
  damlTypes.ToInterface<DateClockUpdateEvent, never> &
  DateClockUpdateEventInterface;

export declare namespace DateClockUpdateEvent {
  export type Key = pkg40f452260bef3f29dede136108fc08a88d5a5250310281067087da6f0baddff7.DA.Types.Tuple2<damlTypes.Party, damlTypes.Date>
  export type CreateEvent = damlLedger.CreateEvent<DateClockUpdateEvent, DateClockUpdateEvent.Key, typeof DateClockUpdateEvent.templateId>
  export type ArchiveEvent = damlLedger.ArchiveEvent<DateClockUpdateEvent, typeof DateClockUpdateEvent.templateId>
  export type Event = damlLedger.Event<DateClockUpdateEvent, DateClockUpdateEvent.Key, typeof DateClockUpdateEvent.templateId>
  export type QueryResult = damlLedger.QueryResult<DateClockUpdateEvent, DateClockUpdateEvent.Key, typeof DateClockUpdateEvent.templateId>
}



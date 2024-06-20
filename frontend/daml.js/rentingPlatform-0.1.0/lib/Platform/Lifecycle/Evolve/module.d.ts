// Generated from Platform/Lifecycle/Evolve.daml
/* eslint-disable @typescript-eslint/camelcase */
/* eslint-disable @typescript-eslint/no-namespace */
/* eslint-disable @typescript-eslint/no-use-before-define */
import * as jtv from '@mojotech/json-type-validation';
import * as damlTypes from '@daml/types';
/* eslint-disable-next-line @typescript-eslint/no-unused-vars */
import * as damlLedger from '@daml/ledger';

import * as pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657 from '@daml.js/97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657';
import * as pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662 from '@daml.js/d14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662';

import * as Interface_Types from '../../../Interface/Types/module';
import * as Time_Clock from '../../../Time/Clock/module';

export declare type ProcessEvent = {
  eventCid: damlTypes.ContractId<Time_Clock.DateClockUpdateEvent>;
};

export declare const ProcessEvent:
  damlTypes.Serializable<ProcessEvent> & {
  }
;


export declare type AddLA = {
  laKey: Interface_Types.LAkey;
};

export declare const AddLA:
  damlTypes.Serializable<AddLA> & {
  }
;


export declare type Evolve = {
  operator: damlTypes.Party;
  lifecycler: damlTypes.Party;
  laKeys: pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657.DA.Set.Types.Set<Interface_Types.LAkey>;
};

export declare interface EvolveInterface {
  AddLA: damlTypes.Choice<Evolve, AddLA, damlTypes.ContractId<Evolve>, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Evolve, undefined>>;
  Archive: damlTypes.Choice<Evolve, pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive, {}, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Evolve, undefined>>;
  ProcessEvent: damlTypes.Choice<Evolve, ProcessEvent, {}, undefined> & damlTypes.ChoiceFrom<damlTypes.Template<Evolve, undefined>>;
}
export declare const Evolve:
  damlTypes.Template<Evolve, undefined, '686bd5d09f27512a24df24b750340cc9b1d484210591ec480915da92fe71121e:Platform.Lifecycle.Evolve:Evolve'> &
  damlTypes.ToInterface<Evolve, never> &
  EvolveInterface;

export declare namespace Evolve {
  export type CreateEvent = damlLedger.CreateEvent<Evolve, undefined, typeof Evolve.templateId>
  export type ArchiveEvent = damlLedger.ArchiveEvent<Evolve, typeof Evolve.templateId>
  export type Event = damlLedger.Event<Evolve, undefined, typeof Evolve.templateId>
  export type QueryResult = damlLedger.QueryResult<Evolve, undefined, typeof Evolve.templateId>
}



// Generated from Platform/Types/LA.daml
/* eslint-disable @typescript-eslint/camelcase */
/* eslint-disable @typescript-eslint/no-namespace */
/* eslint-disable @typescript-eslint/no-use-before-define */
import * as jtv from '@mojotech/json-type-validation';
import * as damlTypes from '@daml/types';
/* eslint-disable-next-line @typescript-eslint/no-unused-vars */
import * as damlLedger from '@daml/ledger';

import * as Platform_Types_Common from '../../../Platform/Types/Common/module';

export declare type LAkey = {
  tenant: damlTypes.Party;
  house: Platform_Types_Common.House;
};

export declare const LAkey:
  damlTypes.Serializable<LAkey> & {
  }
;


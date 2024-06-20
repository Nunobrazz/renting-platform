// Generated from Interface/Signature.daml
/* eslint-disable @typescript-eslint/camelcase */
/* eslint-disable @typescript-eslint/no-namespace */
/* eslint-disable @typescript-eslint/no-use-before-define */
import * as jtv from '@mojotech/json-type-validation';
import * as damlTypes from '@daml/types';
/* eslint-disable-next-line @typescript-eslint/no-unused-vars */
import * as damlLedger from '@daml/ledger';

import * as pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662 from '@daml.js/d14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662';

export declare type ISignature = damlTypes.Interface<'bc781e57a3a4a4dfc87aa22b0be0e06d0b5fe4b9226e8df7f607a70d25c5fec4:Interface.Signature:ISignature'> & SignatureView;
export declare interface ISignatureInterface {
  Sign: damlTypes.Choice<ISignature, Sign, damlTypes.ContractId<ISignature>, undefined> & damlTypes.ChoiceFrom<damlTypes.InterfaceCompanion<ISignature, undefined>>;
  Archive: damlTypes.Choice<ISignature, pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive, {}, undefined> & damlTypes.ChoiceFrom<damlTypes.InterfaceCompanion<ISignature, undefined>>;
}
export declare const ISignature:
  damlTypes.InterfaceCompanion<ISignature, undefined, 'bc781e57a3a4a4dfc87aa22b0be0e06d0b5fe4b9226e8df7f607a70d25c5fec4:Interface.Signature:ISignature'> &
  damlTypes.FromTemplate<ISignature, unknown> &
  ISignatureInterface;


export declare type Sign = {
  signer: damlTypes.Party;
};

export declare const Sign:
  damlTypes.Serializable<Sign> & {
  }
;


export declare type SignatureView = {
  partiesToSign: damlTypes.Party[];
  alreadySigned: damlTypes.Party[];
};

export declare const SignatureView:
  damlTypes.Serializable<SignatureView> & {
  }
;


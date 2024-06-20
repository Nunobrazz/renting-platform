"use strict";
/* eslint-disable-next-line no-unused-vars */
function __export(m) {
/* eslint-disable-next-line no-prototype-builtins */
    for (var p in m) if (!exports.hasOwnProperty(p)) exports[p] = m[p];
}
Object.defineProperty(exports, "__esModule", { value: true });
/* eslint-disable-next-line no-unused-vars */
var jtv = require('@mojotech/json-type-validation');
/* eslint-disable-next-line no-unused-vars */
var damlTypes = require('@daml/types');
/* eslint-disable-next-line no-unused-vars */
var damlLedger = require('@daml/ledger');

var pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662 = require('@daml.js/d14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662');

exports.ISignature = damlTypes.assembleInterface(
  'bc781e57a3a4a4dfc87aa22b0be0e06d0b5fe4b9226e8df7f607a70d25c5fec4:Interface.Signature:ISignature',
  function () { return exports.SignatureView; },
  {
    Sign: {
      template: function () { return exports.ISignature; },
      choiceName: 'Sign',
      argumentDecoder: damlTypes.lazyMemo(function () { return exports.Sign.decoder; }),
      argumentEncode: function (__typed__) { return exports.Sign.encode(__typed__); },
      resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(exports.ISignature).decoder; }),
      resultEncode: function (__typed__) { return damlTypes.ContractId(exports.ISignature).encode(__typed__); },
    },
    Archive: {
      template: function () { return exports.ISignature; },
      choiceName: 'Archive',
      argumentDecoder: damlTypes.lazyMemo(function () { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.decoder; }),
      argumentEncode: function (__typed__) { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.encode(__typed__); },
      resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.Unit.decoder; }),
      resultEncode: function (__typed__) { return damlTypes.Unit.encode(__typed__); },
    },
  });



exports.Sign = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({signer: damlTypes.Party.decoder, }); }),
  encode: function (__typed__) {
  return {
    signer: damlTypes.Party.encode(__typed__.signer),
  };
}
,
};



exports.SignatureView = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({partiesToSign: damlTypes.List(damlTypes.Party).decoder, alreadySigned: damlTypes.List(damlTypes.Party).decoder, }); }),
  encode: function (__typed__) {
  return {
    partiesToSign: damlTypes.List(damlTypes.Party).encode(__typed__.partiesToSign),
    alreadySigned: damlTypes.List(damlTypes.Party).encode(__typed__.alreadySigned),
  };
}
,
};


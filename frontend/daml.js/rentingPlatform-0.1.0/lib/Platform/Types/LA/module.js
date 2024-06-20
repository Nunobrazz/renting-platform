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

var Platform_Types_Common = require('../../../Platform/Types/Common/module');


exports.LAkey = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({tenant: damlTypes.Party.decoder, house: Platform_Types_Common.House.decoder, }); }),
  encode: function (__typed__) {
  return {
    tenant: damlTypes.Party.encode(__typed__.tenant),
    house: Platform_Types_Common.House.encode(__typed__.house),
  };
}
,
};


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


exports.MIdetails = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({nArbitrators: damlTypes.Int.decoder, house: Platform_Types_Common.House.decoder, startingDate: damlTypes.Date.decoder, description: damlTypes.Text.decoder, }); }),
  encode: function (__typed__) {
  return {
    nArbitrators: damlTypes.Int.encode(__typed__.nArbitrators),
    house: Platform_Types_Common.House.encode(__typed__.house),
    startingDate: damlTypes.Date.encode(__typed__.startingDate),
    description: damlTypes.Text.encode(__typed__.description),
  };
}
,
};



exports.AssessmentDetails = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({responsability: exports.Responsability.decoder, cost: damlTypes.Int.decoder, assessmentDate: damlTypes.Date.decoder, reparationDate: damlTypes.Date.decoder, }); }),
  encode: function (__typed__) {
  return {
    responsability: exports.Responsability.encode(__typed__.responsability),
    cost: damlTypes.Int.encode(__typed__.cost),
    assessmentDate: damlTypes.Date.encode(__typed__.assessmentDate),
    reparationDate: damlTypes.Date.encode(__typed__.reparationDate),
  };
}
,
};



exports.Responsability = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({tenantResp: damlTypes.Int.decoder, hostResp: damlTypes.Int.decoder, }); }),
  encode: function (__typed__) {
  return {
    tenantResp: damlTypes.Int.encode(__typed__.tenantResp),
    hostResp: damlTypes.Int.encode(__typed__.hostResp),
  };
}
,
};


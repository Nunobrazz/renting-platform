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

var Platform_Types_Common = require('../../../Platform/Types/Common/module');
var Platform_Types_LA = require('../../../Platform/Types/LA/module');


exports.ProcessPayment = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({date: damlTypes.Date.decoder, }); }),
  encode: function (__typed__) {
  return {
    date: damlTypes.Date.encode(__typed__.date),
  };
}
,
};



exports.LeaseAgreement = damlTypes.assembleTemplate(
{
  templateId: 'f18eb482c25f64cd721de470f30dbf6a8247ca127e6e772be98e809b5cbf23a3:Platform.LeaseAgreement.ModelLA:LeaseAgreement',
  keyDecoder: damlTypes.lazyMemo(function () { return damlTypes.lazyMemo(function () { return Platform_Types_LA.LAkey.decoder; }); }),
  keyEncode: function (__typed__) { return Platform_Types_LA.LAkey.encode(__typed__); },
  decoder: damlTypes.lazyMemo(function () { return jtv.object({operator: damlTypes.Party.decoder, lifecycler: damlTypes.Party.decoder, tenant: damlTypes.Party.decoder, house: Platform_Types_Common.House.decoder, leaseTerms: Platform_Types_Common.LeaseTerms.decoder, paymentsToProcess: damlTypes.List(damlTypes.Date).decoder, }); }),
  encode: function (__typed__) {
  return {
    operator: damlTypes.Party.encode(__typed__.operator),
    lifecycler: damlTypes.Party.encode(__typed__.lifecycler),
    tenant: damlTypes.Party.encode(__typed__.tenant),
    house: Platform_Types_Common.House.encode(__typed__.house),
    leaseTerms: Platform_Types_Common.LeaseTerms.encode(__typed__.leaseTerms),
    paymentsToProcess: damlTypes.List(damlTypes.Date).encode(__typed__.paymentsToProcess),
  };
}
,
  Archive: {
    template: function () { return exports.LeaseAgreement; },
    choiceName: 'Archive',
    argumentDecoder: damlTypes.lazyMemo(function () { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.decoder; }),
    argumentEncode: function (__typed__) { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.Unit.decoder; }),
    resultEncode: function (__typed__) { return damlTypes.Unit.encode(__typed__); },
  },
  ProcessPayment: {
    template: function () { return exports.LeaseAgreement; },
    choiceName: 'ProcessPayment',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.ProcessPayment.decoder; }),
    argumentEncode: function (__typed__) { return exports.ProcessPayment.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(exports.LeaseAgreement).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(exports.LeaseAgreement).encode(__typed__); },
  },
}

);


damlTypes.registerTemplate(exports.LeaseAgreement);


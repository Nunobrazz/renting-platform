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

var Platform_LeaseAgreement_Service = require('../../../Platform/LeaseAgreement/Service/module');
var Platform_Types_Common = require('../../../Platform/Types/Common/module');


exports.RequestLeaseAgreement = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({signer: damlTypes.Party.decoder, operator: damlTypes.Party.decoder, }); }),
  encode: function (__typed__) {
  return {
    signer: damlTypes.Party.encode(__typed__.signer),
    operator: damlTypes.Party.encode(__typed__.operator),
  };
}
,
};



exports.Sign = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({signer: damlTypes.Party.decoder, }); }),
  encode: function (__typed__) {
  return {
    signer: damlTypes.Party.encode(__typed__.signer),
  };
}
,
};



exports.Proposal = damlTypes.assembleTemplate(
{
  templateId: 'f18eb482c25f64cd721de470f30dbf6a8247ca127e6e772be98e809b5cbf23a3:Platform.Proposal.Model:Proposal',
  keyDecoder: damlTypes.lazyMemo(function () { return jtv.constant(undefined); }),
  keyEncode: function () { throw 'EncodeError'; },
  decoder: damlTypes.lazyMemo(function () { return jtv.object({proposer: damlTypes.Party.decoder, house: Platform_Types_Common.House.decoder, leaseTerms: Platform_Types_Common.LeaseTerms.decoder, alreadySigned: damlTypes.List(damlTypes.Party).decoder, }); }),
  encode: function (__typed__) {
  return {
    proposer: damlTypes.Party.encode(__typed__.proposer),
    house: Platform_Types_Common.House.encode(__typed__.house),
    leaseTerms: Platform_Types_Common.LeaseTerms.encode(__typed__.leaseTerms),
    alreadySigned: damlTypes.List(damlTypes.Party).encode(__typed__.alreadySigned),
  };
}
,
  Sign: {
    template: function () { return exports.Proposal; },
    choiceName: 'Sign',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.Sign.decoder; }),
    argumentEncode: function (__typed__) { return exports.Sign.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(exports.Proposal).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(exports.Proposal).encode(__typed__); },
  },
  RequestLeaseAgreement: {
    template: function () { return exports.Proposal; },
    choiceName: 'RequestLeaseAgreement',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.RequestLeaseAgreement.decoder; }),
    argumentEncode: function (__typed__) { return exports.RequestLeaseAgreement.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(Platform_LeaseAgreement_Service.Request).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(Platform_LeaseAgreement_Service.Request).encode(__typed__); },
  },
  Archive: {
    template: function () { return exports.Proposal; },
    choiceName: 'Archive',
    argumentDecoder: damlTypes.lazyMemo(function () { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.decoder; }),
    argumentEncode: function (__typed__) { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.Unit.decoder; }),
    resultEncode: function (__typed__) { return damlTypes.Unit.encode(__typed__); },
  },
}

);


damlTypes.registerTemplate(exports.Proposal);


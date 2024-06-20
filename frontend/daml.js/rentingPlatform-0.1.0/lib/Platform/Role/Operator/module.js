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
var Platform_Proposal_Service = require('../../../Platform/Proposal/Service/module');


exports.ApproveLeaseAgreementService = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({laServiceReqCid: damlTypes.ContractId(Platform_LeaseAgreement_Service.Request).decoder, lifecycler: damlTypes.Party.decoder, }); }),
  encode: function (__typed__) {
  return {
    laServiceReqCid: damlTypes.ContractId(Platform_LeaseAgreement_Service.Request).encode(__typed__.laServiceReqCid),
    lifecycler: damlTypes.Party.encode(__typed__.lifecycler),
  };
}
,
};



exports.ApproveProposalServiceRequest = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({proposalReqCid: damlTypes.ContractId(Platform_Proposal_Service.Request).decoder, }); }),
  encode: function (__typed__) {
  return {
    proposalReqCid: damlTypes.ContractId(Platform_Proposal_Service.Request).encode(__typed__.proposalReqCid),
  };
}
,
};



exports.Role = damlTypes.assembleTemplate(
{
  templateId: 'f18eb482c25f64cd721de470f30dbf6a8247ca127e6e772be98e809b5cbf23a3:Platform.Role.Operator:Role',
  keyDecoder: damlTypes.lazyMemo(function () { return damlTypes.lazyMemo(function () { return damlTypes.Party.decoder; }); }),
  keyEncode: function (__typed__) { return damlTypes.Party.encode(__typed__); },
  decoder: damlTypes.lazyMemo(function () { return jtv.object({operator: damlTypes.Party.decoder, }); }),
  encode: function (__typed__) {
  return {
    operator: damlTypes.Party.encode(__typed__.operator),
  };
}
,
  ApproveProposalServiceRequest: {
    template: function () { return exports.Role; },
    choiceName: 'ApproveProposalServiceRequest',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.ApproveProposalServiceRequest.decoder; }),
    argumentEncode: function (__typed__) { return exports.ApproveProposalServiceRequest.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(Platform_Proposal_Service.Service).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(Platform_Proposal_Service.Service).encode(__typed__); },
  },
  Archive: {
    template: function () { return exports.Role; },
    choiceName: 'Archive',
    argumentDecoder: damlTypes.lazyMemo(function () { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.decoder; }),
    argumentEncode: function (__typed__) { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.Unit.decoder; }),
    resultEncode: function (__typed__) { return damlTypes.Unit.encode(__typed__); },
  },
  ApproveLeaseAgreementService: {
    template: function () { return exports.Role; },
    choiceName: 'ApproveLeaseAgreementService',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.ApproveLeaseAgreementService.decoder; }),
    argumentEncode: function (__typed__) { return exports.ApproveLeaseAgreementService.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(Platform_LeaseAgreement_Service.Service).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(Platform_LeaseAgreement_Service.Service).encode(__typed__); },
  },
}

);


damlTypes.registerTemplate(exports.Role);


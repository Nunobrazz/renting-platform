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

var pkg40f452260bef3f29dede136108fc08a88d5a5250310281067087da6f0baddff7 = require('@daml.js/40f452260bef3f29dede136108fc08a88d5a5250310281067087da6f0baddff7');
var pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662 = require('@daml.js/d14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662');

var Platform_LeaseAgreement_Service = require('../../../Platform/LeaseAgreement/Service/module');
var Platform_Proposal_Model = require('../../../Platform/Proposal/Model/module');
var Platform_Types_Common = require('../../../Platform/Types/Common/module');


exports.Approve = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({}); }),
  encode: function (__typed__) {
  return {
  };
}
,
};



exports.Reject = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({}); }),
  encode: function (__typed__) {
  return {
  };
}
,
};



exports.Withdraw = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({}); }),
  encode: function (__typed__) {
  return {
  };
}
,
};



exports.Request = damlTypes.assembleTemplate(
{
  templateId: 'f18eb482c25f64cd721de470f30dbf6a8247ca127e6e772be98e809b5cbf23a3:Platform.Proposal.Service:Request',
  keyDecoder: damlTypes.lazyMemo(function () { return jtv.constant(undefined); }),
  keyEncode: function () { throw 'EncodeError'; },
  decoder: damlTypes.lazyMemo(function () { return jtv.object({operator: damlTypes.Party.decoder, proposer: damlTypes.Party.decoder, house: Platform_Types_Common.House.decoder, }); }),
  encode: function (__typed__) {
  return {
    operator: damlTypes.Party.encode(__typed__.operator),
    proposer: damlTypes.Party.encode(__typed__.proposer),
    house: Platform_Types_Common.House.encode(__typed__.house),
  };
}
,
  Withdraw: {
    template: function () { return exports.Request; },
    choiceName: 'Withdraw',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.Withdraw.decoder; }),
    argumentEncode: function (__typed__) { return exports.Withdraw.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.Unit.decoder; }),
    resultEncode: function (__typed__) { return damlTypes.Unit.encode(__typed__); },
  },
  Reject: {
    template: function () { return exports.Request; },
    choiceName: 'Reject',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.Reject.decoder; }),
    argumentEncode: function (__typed__) { return exports.Reject.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.Unit.decoder; }),
    resultEncode: function (__typed__) { return damlTypes.Unit.encode(__typed__); },
  },
  Archive: {
    template: function () { return exports.Request; },
    choiceName: 'Archive',
    argumentDecoder: damlTypes.lazyMemo(function () { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.decoder; }),
    argumentEncode: function (__typed__) { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.Unit.decoder; }),
    resultEncode: function (__typed__) { return damlTypes.Unit.encode(__typed__); },
  },
  Approve: {
    template: function () { return exports.Request; },
    choiceName: 'Approve',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.Approve.decoder; }),
    argumentEncode: function (__typed__) { return exports.Approve.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(exports.Service).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(exports.Service).encode(__typed__); },
  },
}

);


damlTypes.registerTemplate(exports.Request);



exports.RequestLeaseAgreement = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({signer: damlTypes.Party.decoder, proposalCid: damlTypes.ContractId(Platform_Proposal_Model.Proposal).decoder, }); }),
  encode: function (__typed__) {
  return {
    signer: damlTypes.Party.encode(__typed__.signer),
    proposalCid: damlTypes.ContractId(Platform_Proposal_Model.Proposal).encode(__typed__.proposalCid),
  };
}
,
};



exports.SignProposal = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({signer: damlTypes.Party.decoder, proposalCid: damlTypes.ContractId(Platform_Proposal_Model.Proposal).decoder, }); }),
  encode: function (__typed__) {
  return {
    signer: damlTypes.Party.encode(__typed__.signer),
    proposalCid: damlTypes.ContractId(Platform_Proposal_Model.Proposal).encode(__typed__.proposalCid),
  };
}
,
};



exports.AcceptProposal = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({proposalCid: damlTypes.ContractId(Platform_Proposal_Model.Proposal).decoder, }); }),
  encode: function (__typed__) {
  return {
    proposalCid: damlTypes.ContractId(Platform_Proposal_Model.Proposal).encode(__typed__.proposalCid),
  };
}
,
};



exports.DeleteProposal = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({proposalCid: damlTypes.ContractId(Platform_Proposal_Model.Proposal).decoder, }); }),
  encode: function (__typed__) {
  return {
    proposalCid: damlTypes.ContractId(Platform_Proposal_Model.Proposal).encode(__typed__.proposalCid),
  };
}
,
};



exports.RejectProposal = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({proposalCid: damlTypes.ContractId(Platform_Proposal_Model.Proposal).decoder, }); }),
  encode: function (__typed__) {
  return {
    proposalCid: damlTypes.ContractId(Platform_Proposal_Model.Proposal).encode(__typed__.proposalCid),
  };
}
,
};



exports.CreateProposal = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({proposer: damlTypes.Party.decoder, house: Platform_Types_Common.House.decoder, leaseTerms: Platform_Types_Common.LeaseTerms.decoder, }); }),
  encode: function (__typed__) {
  return {
    proposer: damlTypes.Party.encode(__typed__.proposer),
    house: Platform_Types_Common.House.encode(__typed__.house),
    leaseTerms: Platform_Types_Common.LeaseTerms.encode(__typed__.leaseTerms),
  };
}
,
};



exports.Service = damlTypes.assembleTemplate(
{
  templateId: 'f18eb482c25f64cd721de470f30dbf6a8247ca127e6e772be98e809b5cbf23a3:Platform.Proposal.Service:Service',
  keyDecoder: damlTypes.lazyMemo(function () { return damlTypes.lazyMemo(function () { return pkg40f452260bef3f29dede136108fc08a88d5a5250310281067087da6f0baddff7.DA.Types.Tuple2(damlTypes.Party, damlTypes.Party).decoder; }); }),
  keyEncode: function (__typed__) { return pkg40f452260bef3f29dede136108fc08a88d5a5250310281067087da6f0baddff7.DA.Types.Tuple2(damlTypes.Party, damlTypes.Party).encode(__typed__); },
  decoder: damlTypes.lazyMemo(function () { return jtv.object({operator: damlTypes.Party.decoder, proposer: damlTypes.Party.decoder, host: damlTypes.Party.decoder, }); }),
  encode: function (__typed__) {
  return {
    operator: damlTypes.Party.encode(__typed__.operator),
    proposer: damlTypes.Party.encode(__typed__.proposer),
    host: damlTypes.Party.encode(__typed__.host),
  };
}
,
  CreateProposal: {
    template: function () { return exports.Service; },
    choiceName: 'CreateProposal',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.CreateProposal.decoder; }),
    argumentEncode: function (__typed__) { return exports.CreateProposal.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(Platform_Proposal_Model.Proposal).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(Platform_Proposal_Model.Proposal).encode(__typed__); },
  },
  RejectProposal: {
    template: function () { return exports.Service; },
    choiceName: 'RejectProposal',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.RejectProposal.decoder; }),
    argumentEncode: function (__typed__) { return exports.RejectProposal.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.Unit.decoder; }),
    resultEncode: function (__typed__) { return damlTypes.Unit.encode(__typed__); },
  },
  DeleteProposal: {
    template: function () { return exports.Service; },
    choiceName: 'DeleteProposal',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.DeleteProposal.decoder; }),
    argumentEncode: function (__typed__) { return exports.DeleteProposal.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.Unit.decoder; }),
    resultEncode: function (__typed__) { return damlTypes.Unit.encode(__typed__); },
  },
  AcceptProposal: {
    template: function () { return exports.Service; },
    choiceName: 'AcceptProposal',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.AcceptProposal.decoder; }),
    argumentEncode: function (__typed__) { return exports.AcceptProposal.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(Platform_Proposal_Model.Proposal).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(Platform_Proposal_Model.Proposal).encode(__typed__); },
  },
  SignProposal: {
    template: function () { return exports.Service; },
    choiceName: 'SignProposal',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.SignProposal.decoder; }),
    argumentEncode: function (__typed__) { return exports.SignProposal.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(Platform_Proposal_Model.Proposal).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(Platform_Proposal_Model.Proposal).encode(__typed__); },
  },
  RequestLeaseAgreement: {
    template: function () { return exports.Service; },
    choiceName: 'RequestLeaseAgreement',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.RequestLeaseAgreement.decoder; }),
    argumentEncode: function (__typed__) { return exports.RequestLeaseAgreement.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(Platform_LeaseAgreement_Service.Request).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(Platform_LeaseAgreement_Service.Request).encode(__typed__); },
  },
  Archive: {
    template: function () { return exports.Service; },
    choiceName: 'Archive',
    argumentDecoder: damlTypes.lazyMemo(function () { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.decoder; }),
    argumentEncode: function (__typed__) { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.Unit.decoder; }),
    resultEncode: function (__typed__) { return damlTypes.Unit.encode(__typed__); },
  },
}

);


damlTypes.registerTemplate(exports.Service);


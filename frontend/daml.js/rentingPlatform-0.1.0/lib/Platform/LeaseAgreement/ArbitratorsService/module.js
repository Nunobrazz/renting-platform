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

var Interface_Types = require('../../../Interface/Types/module');
var Platform_LeaseAgreement_ModelMI = require('../../../Platform/LeaseAgreement/ModelMI/module');


exports.Reject = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({}); }),
  encode: function (__typed__) {
  return {
  };
}
,
};



exports.Approve = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({}); }),
  encode: function (__typed__) {
  return {
  };
}
,
};



exports.Request = damlTypes.assembleTemplate(
{
  templateId: 'bc781e57a3a4a4dfc87aa22b0be0e06d0b5fe4b9226e8df7f607a70d25c5fec4:Platform.LeaseAgreement.ArbitratorsService:Request',
  keyDecoder: damlTypes.lazyMemo(function () { return jtv.constant(undefined); }),
  keyEncode: function () { throw 'EncodeError'; },
  decoder: damlTypes.lazyMemo(function () { return jtv.object({arbitrator: damlTypes.Party.decoder, operator: damlTypes.Party.decoder, }); }),
  encode: function (__typed__) {
  return {
    arbitrator: damlTypes.Party.encode(__typed__.arbitrator),
    operator: damlTypes.Party.encode(__typed__.operator),
  };
}
,
  Approve: {
    template: function () { return exports.Request; },
    choiceName: 'Approve',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.Approve.decoder; }),
    argumentEncode: function (__typed__) { return exports.Approve.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(exports.Service).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(exports.Service).encode(__typed__); },
  },
  Archive: {
    template: function () { return exports.Request; },
    choiceName: 'Archive',
    argumentDecoder: damlTypes.lazyMemo(function () { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.decoder; }),
    argumentEncode: function (__typed__) { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.encode(__typed__); },
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
}

);


damlTypes.registerTemplate(exports.Request);



exports.Decline = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({}); }),
  encode: function (__typed__) {
  return {
  };
}
,
};



exports.Accept = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({}); }),
  encode: function (__typed__) {
  return {
  };
}
,
};



exports.Offer = damlTypes.assembleTemplate(
{
  templateId: 'bc781e57a3a4a4dfc87aa22b0be0e06d0b5fe4b9226e8df7f607a70d25c5fec4:Platform.LeaseAgreement.ArbitratorsService:Offer',
  keyDecoder: damlTypes.lazyMemo(function () { return jtv.constant(undefined); }),
  keyEncode: function () { throw 'EncodeError'; },
  decoder: damlTypes.lazyMemo(function () { return jtv.object({operator: damlTypes.Party.decoder, arbitrator: damlTypes.Party.decoder, }); }),
  encode: function (__typed__) {
  return {
    operator: damlTypes.Party.encode(__typed__.operator),
    arbitrator: damlTypes.Party.encode(__typed__.arbitrator),
  };
}
,
  Accept: {
    template: function () { return exports.Offer; },
    choiceName: 'Accept',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.Accept.decoder; }),
    argumentEncode: function (__typed__) { return exports.Accept.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(exports.Service).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(exports.Service).encode(__typed__); },
  },
  Decline: {
    template: function () { return exports.Offer; },
    choiceName: 'Decline',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.Decline.decoder; }),
    argumentEncode: function (__typed__) { return exports.Decline.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.Unit.decoder; }),
    resultEncode: function (__typed__) { return damlTypes.Unit.encode(__typed__); },
  },
  Archive: {
    template: function () { return exports.Offer; },
    choiceName: 'Archive',
    argumentDecoder: damlTypes.lazyMemo(function () { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.decoder; }),
    argumentEncode: function (__typed__) { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.Unit.decoder; }),
    resultEncode: function (__typed__) { return damlTypes.Unit.encode(__typed__); },
  },
}

);


damlTypes.registerTemplate(exports.Offer);



exports.FinalizeVotation = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({votationCid: damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.Votation).decoder, }); }),
  encode: function (__typed__) {
  return {
    votationCid: damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.Votation).encode(__typed__.votationCid),
  };
}
,
};



exports.SubmitVote = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({vote: Interface_Types.Responsability.decoder, votationCid: damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.Votation).decoder, }); }),
  encode: function (__typed__) {
  return {
    vote: Interface_Types.Responsability.encode(__typed__.vote),
    votationCid: damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.Votation).encode(__typed__.votationCid),
  };
}
,
};



exports.CreateVotation = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({description: damlTypes.Text.decoder, miCid: damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.MI).decoder, assessment: Interface_Types.AssessmentDetails.decoder, }); }),
  encode: function (__typed__) {
  return {
    description: damlTypes.Text.encode(__typed__.description),
    miCid: damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.MI).encode(__typed__.miCid),
    assessment: Interface_Types.AssessmentDetails.encode(__typed__.assessment),
  };
}
,
};



exports.AcceptMI = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({inviteArbitratorsCid: damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.InviteArbitrators).decoder, }); }),
  encode: function (__typed__) {
  return {
    inviteArbitratorsCid: damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.InviteArbitrators).encode(__typed__.inviteArbitratorsCid),
  };
}
,
};



exports.Service = damlTypes.assembleTemplate(
{
  templateId: 'bc781e57a3a4a4dfc87aa22b0be0e06d0b5fe4b9226e8df7f607a70d25c5fec4:Platform.LeaseAgreement.ArbitratorsService:Service',
  keyDecoder: damlTypes.lazyMemo(function () { return jtv.constant(undefined); }),
  keyEncode: function () { throw 'EncodeError'; },
  decoder: damlTypes.lazyMemo(function () { return jtv.object({operator: damlTypes.Party.decoder, arbitrator: damlTypes.Party.decoder, }); }),
  encode: function (__typed__) {
  return {
    operator: damlTypes.Party.encode(__typed__.operator),
    arbitrator: damlTypes.Party.encode(__typed__.arbitrator),
  };
}
,
  AcceptMI: {
    template: function () { return exports.Service; },
    choiceName: 'AcceptMI',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.AcceptMI.decoder; }),
    argumentEncode: function (__typed__) { return exports.AcceptMI.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.InviteArbitrators).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.InviteArbitrators).encode(__typed__); },
  },
  CreateVotation: {
    template: function () { return exports.Service; },
    choiceName: 'CreateVotation',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.CreateVotation.decoder; }),
    argumentEncode: function (__typed__) { return exports.CreateVotation.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.Votation).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.Votation).encode(__typed__); },
  },
  SubmitVote: {
    template: function () { return exports.Service; },
    choiceName: 'SubmitVote',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.SubmitVote.decoder; }),
    argumentEncode: function (__typed__) { return exports.SubmitVote.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.Votation).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.Votation).encode(__typed__); },
  },
  FinalizeVotation: {
    template: function () { return exports.Service; },
    choiceName: 'FinalizeVotation',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.FinalizeVotation.decoder; }),
    argumentEncode: function (__typed__) { return exports.FinalizeVotation.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.MI).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.MI).encode(__typed__); },
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


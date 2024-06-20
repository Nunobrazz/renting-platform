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

var pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657 = require('@daml.js/97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657');
var pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662 = require('@daml.js/d14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662');

var Platform_Interface_Types = require('../../../Platform/Interface/Types/module');
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
  decoder: damlTypes.lazyMemo(function () { return jtv.object({roleCid: damlTypes.ContractId(exports.Arbitrators).decoder, }); }),
  encode: function (__typed__) {
  return {
    roleCid: damlTypes.ContractId(exports.Arbitrators).encode(__typed__.roleCid),
  };
}
,
};



exports.Request = damlTypes.assembleTemplate(
{
  templateId: 'da53d310d1daf7739100e96d59bcf2f5b4ec44d2a1b3f47b9a0c35b489c6ab49:Platform.Role.Arbitrator:Request',
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
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(exports.Arbitrators).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(exports.Arbitrators).encode(__typed__); },
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
  templateId: 'da53d310d1daf7739100e96d59bcf2f5b4ec44d2a1b3f47b9a0c35b489c6ab49:Platform.Role.Arbitrator:Offer',
  keyDecoder: damlTypes.lazyMemo(function () { return jtv.constant(undefined); }),
  keyEncode: function () { throw 'EncodeError'; },
  decoder: damlTypes.lazyMemo(function () { return jtv.object({operator: damlTypes.Party.decoder, arbitrator: damlTypes.Party.decoder, roleCid: damlTypes.ContractId(exports.Arbitrators).decoder, }); }),
  encode: function (__typed__) {
  return {
    operator: damlTypes.Party.encode(__typed__.operator),
    arbitrator: damlTypes.Party.encode(__typed__.arbitrator),
    roleCid: damlTypes.ContractId(exports.Arbitrators).encode(__typed__.roleCid),
  };
}
,
  Accept: {
    template: function () { return exports.Offer; },
    choiceName: 'Accept',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.Accept.decoder; }),
    argumentEncode: function (__typed__) { return exports.Accept.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(exports.Arbitrators).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(exports.Arbitrators).encode(__typed__); },
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
  decoder: damlTypes.lazyMemo(function () { return jtv.object({finalizer: damlTypes.Party.decoder, votationCid: damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.Votation).decoder, }); }),
  encode: function (__typed__) {
  return {
    finalizer: damlTypes.Party.encode(__typed__.finalizer),
    votationCid: damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.Votation).encode(__typed__.votationCid),
  };
}
,
};



exports.SubmitVote = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({voter: damlTypes.Party.decoder, vote: Platform_Interface_Types.AssessmentDetails.decoder, votationCid: damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.Votation).decoder, }); }),
  encode: function (__typed__) {
  return {
    voter: damlTypes.Party.encode(__typed__.voter),
    vote: Platform_Interface_Types.AssessmentDetails.encode(__typed__.vote),
    votationCid: damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.Votation).encode(__typed__.votationCid),
  };
}
,
};



exports.CreateVotation = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({creator: damlTypes.Party.decoder, description: damlTypes.Text.decoder, miKey: Platform_Interface_Types.MIkey.decoder, vote: Platform_Interface_Types.AssessmentDetails.decoder, }); }),
  encode: function (__typed__) {
  return {
    creator: damlTypes.Party.encode(__typed__.creator),
    description: damlTypes.Text.encode(__typed__.description),
    miKey: Platform_Interface_Types.MIkey.encode(__typed__.miKey),
    vote: Platform_Interface_Types.AssessmentDetails.encode(__typed__.vote),
  };
}
,
};



exports.AssignArbitrators = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({inviteArbitratorsCid: damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.InviteArbitrators).decoder, }); }),
  encode: function (__typed__) {
  return {
    inviteArbitratorsCid: damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.InviteArbitrators).encode(__typed__.inviteArbitratorsCid),
  };
}
,
};



exports.AcceptMI = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({inviteArbitratorsCid: damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.InviteArbitrators).decoder, arbitrator: damlTypes.Party.decoder, }); }),
  encode: function (__typed__) {
  return {
    inviteArbitratorsCid: damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.InviteArbitrators).encode(__typed__.inviteArbitratorsCid),
    arbitrator: damlTypes.Party.encode(__typed__.arbitrator),
  };
}
,
};



exports.InviteArbitrators = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({miKey: Platform_Interface_Types.MIkey.decoder, }); }),
  encode: function (__typed__) {
  return {
    miKey: Platform_Interface_Types.MIkey.encode(__typed__.miKey),
  };
}
,
};



exports.AddArbitrator = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({arbitrator: damlTypes.Party.decoder, }); }),
  encode: function (__typed__) {
  return {
    arbitrator: damlTypes.Party.encode(__typed__.arbitrator),
  };
}
,
};



exports.Arbitrators = damlTypes.assembleTemplate(
{
  templateId: 'da53d310d1daf7739100e96d59bcf2f5b4ec44d2a1b3f47b9a0c35b489c6ab49:Platform.Role.Arbitrator:Arbitrators',
  keyDecoder: damlTypes.lazyMemo(function () { return jtv.constant(undefined); }),
  keyEncode: function () { throw 'EncodeError'; },
  decoder: damlTypes.lazyMemo(function () { return jtv.object({operator: damlTypes.Party.decoder, arbitrators: pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657.DA.Set.Types.Set(damlTypes.Party).decoder, }); }),
  encode: function (__typed__) {
  return {
    operator: damlTypes.Party.encode(__typed__.operator),
    arbitrators: pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657.DA.Set.Types.Set(damlTypes.Party).encode(__typed__.arbitrators),
  };
}
,
  AddArbitrator: {
    template: function () { return exports.Arbitrators; },
    choiceName: 'AddArbitrator',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.AddArbitrator.decoder; }),
    argumentEncode: function (__typed__) { return exports.AddArbitrator.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(exports.Arbitrators).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(exports.Arbitrators).encode(__typed__); },
  },
  InviteArbitrators: {
    template: function () { return exports.Arbitrators; },
    choiceName: 'InviteArbitrators',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.InviteArbitrators.decoder; }),
    argumentEncode: function (__typed__) { return exports.InviteArbitrators.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.InviteArbitrators).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.InviteArbitrators).encode(__typed__); },
  },
  AcceptMI: {
    template: function () { return exports.Arbitrators; },
    choiceName: 'AcceptMI',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.AcceptMI.decoder; }),
    argumentEncode: function (__typed__) { return exports.AcceptMI.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.InviteArbitrators).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.InviteArbitrators).encode(__typed__); },
  },
  AssignArbitrators: {
    template: function () { return exports.Arbitrators; },
    choiceName: 'AssignArbitrators',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.AssignArbitrators.decoder; }),
    argumentEncode: function (__typed__) { return exports.AssignArbitrators.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.MI).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.MI).encode(__typed__); },
  },
  CreateVotation: {
    template: function () { return exports.Arbitrators; },
    choiceName: 'CreateVotation',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.CreateVotation.decoder; }),
    argumentEncode: function (__typed__) { return exports.CreateVotation.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.Votation).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.Votation).encode(__typed__); },
  },
  SubmitVote: {
    template: function () { return exports.Arbitrators; },
    choiceName: 'SubmitVote',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.SubmitVote.decoder; }),
    argumentEncode: function (__typed__) { return exports.SubmitVote.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.Votation).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.Votation).encode(__typed__); },
  },
  FinalizeVotation: {
    template: function () { return exports.Arbitrators; },
    choiceName: 'FinalizeVotation',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.FinalizeVotation.decoder; }),
    argumentEncode: function (__typed__) { return exports.FinalizeVotation.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.MI).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.MI).encode(__typed__); },
  },
  Archive: {
    template: function () { return exports.Arbitrators; },
    choiceName: 'Archive',
    argumentDecoder: damlTypes.lazyMemo(function () { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.decoder; }),
    argumentEncode: function (__typed__) { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.Unit.decoder; }),
    resultEncode: function (__typed__) { return damlTypes.Unit.encode(__typed__); },
  },
}

);


damlTypes.registerTemplate(exports.Arbitrators);


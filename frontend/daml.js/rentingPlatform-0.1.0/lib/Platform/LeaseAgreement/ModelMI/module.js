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
var pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657 = require('@daml.js/97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657');
var pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662 = require('@daml.js/d14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662');

var Platform_Types_MI = require('../../../Platform/Types/MI/module');


exports.MIresultFriendly = damlTypes.assembleTemplate(
{
  templateId: 'f18eb482c25f64cd721de470f30dbf6a8247ca127e6e772be98e809b5cbf23a3:Platform.LeaseAgreement.ModelMI:MIresultFriendly',
  keyDecoder: damlTypes.lazyMemo(function () { return jtv.constant(undefined); }),
  keyEncode: function () { throw 'EncodeError'; },
  decoder: damlTypes.lazyMemo(function () { return jtv.object({assessmentCreator: damlTypes.Party.decoder, assessmentSigner: damlTypes.Party.decoder, miDetails: Platform_Types_MI.MIdetails.decoder, assessment: Platform_Types_MI.AssessmentDetails.decoder, }); }),
  encode: function (__typed__) {
  return {
    assessmentCreator: damlTypes.Party.encode(__typed__.assessmentCreator),
    assessmentSigner: damlTypes.Party.encode(__typed__.assessmentSigner),
    miDetails: Platform_Types_MI.MIdetails.encode(__typed__.miDetails),
    assessment: Platform_Types_MI.AssessmentDetails.encode(__typed__.assessment),
  };
}
,
  Archive: {
    template: function () { return exports.MIresultFriendly; },
    choiceName: 'Archive',
    argumentDecoder: damlTypes.lazyMemo(function () { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.decoder; }),
    argumentEncode: function (__typed__) { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.Unit.decoder; }),
    resultEncode: function (__typed__) { return damlTypes.Unit.encode(__typed__); },
  },
}

);


damlTypes.registerTemplate(exports.MIresultFriendly);



exports.MIresultArbitrators = damlTypes.assembleTemplate(
{
  templateId: 'f18eb482c25f64cd721de470f30dbf6a8247ca127e6e772be98e809b5cbf23a3:Platform.LeaseAgreement.ModelMI:MIresultArbitrators',
  keyDecoder: damlTypes.lazyMemo(function () { return jtv.constant(undefined); }),
  keyEncode: function () { throw 'EncodeError'; },
  decoder: damlTypes.lazyMemo(function () { return jtv.object({tenant: damlTypes.Party.decoder, host: damlTypes.Party.decoder, miDetails: Platform_Types_MI.MIdetails.decoder, arbitrators: pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657.DA.Set.Types.Set(damlTypes.Party).decoder, visitor: damlTypes.Party.decoder, visitDetails: damlTypes.Text.decoder, assessment: Platform_Types_MI.AssessmentDetails.decoder, }); }),
  encode: function (__typed__) {
  return {
    tenant: damlTypes.Party.encode(__typed__.tenant),
    host: damlTypes.Party.encode(__typed__.host),
    miDetails: Platform_Types_MI.MIdetails.encode(__typed__.miDetails),
    arbitrators: pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657.DA.Set.Types.Set(damlTypes.Party).encode(__typed__.arbitrators),
    visitor: damlTypes.Party.encode(__typed__.visitor),
    visitDetails: damlTypes.Text.encode(__typed__.visitDetails),
    assessment: Platform_Types_MI.AssessmentDetails.encode(__typed__.assessment),
  };
}
,
  Archive: {
    template: function () { return exports.MIresultArbitrators; },
    choiceName: 'Archive',
    argumentDecoder: damlTypes.lazyMemo(function () { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.decoder; }),
    argumentEncode: function (__typed__) { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.Unit.decoder; }),
    resultEncode: function (__typed__) { return damlTypes.Unit.encode(__typed__); },
  },
}

);


damlTypes.registerTemplate(exports.MIresultArbitrators);



exports.SignAssessment = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({signer: damlTypes.Party.decoder, }); }),
  encode: function (__typed__) {
  return {
    signer: damlTypes.Party.encode(__typed__.signer),
  };
}
,
};



exports.Assessment = damlTypes.assembleTemplate(
{
  templateId: 'f18eb482c25f64cd721de470f30dbf6a8247ca127e6e772be98e809b5cbf23a3:Platform.LeaseAgreement.ModelMI:Assessment',
  keyDecoder: damlTypes.lazyMemo(function () { return jtv.constant(undefined); }),
  keyEncode: function () { throw 'EncodeError'; },
  decoder: damlTypes.lazyMemo(function () { return jtv.object({creator: damlTypes.Party.decoder, signer: damlTypes.Party.decoder, assessment: Platform_Types_MI.AssessmentDetails.decoder, miDetails: Platform_Types_MI.MIdetails.decoder, }); }),
  encode: function (__typed__) {
  return {
    creator: damlTypes.Party.encode(__typed__.creator),
    signer: damlTypes.Party.encode(__typed__.signer),
    assessment: Platform_Types_MI.AssessmentDetails.encode(__typed__.assessment),
    miDetails: Platform_Types_MI.MIdetails.encode(__typed__.miDetails),
  };
}
,
  Archive: {
    template: function () { return exports.Assessment; },
    choiceName: 'Archive',
    argumentDecoder: damlTypes.lazyMemo(function () { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.decoder; }),
    argumentEncode: function (__typed__) { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.Unit.decoder; }),
    resultEncode: function (__typed__) { return damlTypes.Unit.encode(__typed__); },
  },
  SignAssessment: {
    template: function () { return exports.Assessment; },
    choiceName: 'SignAssessment',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.SignAssessment.decoder; }),
    argumentEncode: function (__typed__) { return exports.SignAssessment.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(exports.MIresultFriendly).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(exports.MIresultFriendly).encode(__typed__); },
  },
}

);


damlTypes.registerTemplate(exports.Assessment);



exports.FinalizeVotation = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({finalizer: damlTypes.Party.decoder, }); }),
  encode: function (__typed__) {
  return {
    finalizer: damlTypes.Party.encode(__typed__.finalizer),
  };
}
,
};



exports.Vote = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({voter: damlTypes.Party.decoder, vote: Platform_Types_MI.Responsability.decoder, }); }),
  encode: function (__typed__) {
  return {
    voter: damlTypes.Party.encode(__typed__.voter),
    vote: Platform_Types_MI.Responsability.encode(__typed__.vote),
  };
}
,
};



exports.Votation = damlTypes.assembleTemplate(
{
  templateId: 'f18eb482c25f64cd721de470f30dbf6a8247ca127e6e772be98e809b5cbf23a3:Platform.LeaseAgreement.ModelMI:Votation',
  keyDecoder: damlTypes.lazyMemo(function () { return jtv.constant(undefined); }),
  keyEncode: function () { throw 'EncodeError'; },
  decoder: damlTypes.lazyMemo(function () { return jtv.object({tenant: damlTypes.Party.decoder, host: damlTypes.Party.decoder, miDetails: Platform_Types_MI.MIdetails.decoder, visitor: damlTypes.Party.decoder, visitDetails: damlTypes.Text.decoder, voters: pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657.DA.Set.Types.Set(damlTypes.Party).decoder, miReportCid: damlTypes.ContractId(exports.MIReport).decoder, alreadyVoted: pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657.DA.Set.Types.Set(damlTypes.Party).decoder, result: Platform_Types_MI.AssessmentDetails.decoder, }); }),
  encode: function (__typed__) {
  return {
    tenant: damlTypes.Party.encode(__typed__.tenant),
    host: damlTypes.Party.encode(__typed__.host),
    miDetails: Platform_Types_MI.MIdetails.encode(__typed__.miDetails),
    visitor: damlTypes.Party.encode(__typed__.visitor),
    visitDetails: damlTypes.Text.encode(__typed__.visitDetails),
    voters: pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657.DA.Set.Types.Set(damlTypes.Party).encode(__typed__.voters),
    miReportCid: damlTypes.ContractId(exports.MIReport).encode(__typed__.miReportCid),
    alreadyVoted: pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657.DA.Set.Types.Set(damlTypes.Party).encode(__typed__.alreadyVoted),
    result: Platform_Types_MI.AssessmentDetails.encode(__typed__.result),
  };
}
,
  Archive: {
    template: function () { return exports.Votation; },
    choiceName: 'Archive',
    argumentDecoder: damlTypes.lazyMemo(function () { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.decoder; }),
    argumentEncode: function (__typed__) { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.Unit.decoder; }),
    resultEncode: function (__typed__) { return damlTypes.Unit.encode(__typed__); },
  },
  Vote: {
    template: function () { return exports.Votation; },
    choiceName: 'Vote',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.Vote.decoder; }),
    argumentEncode: function (__typed__) { return exports.Vote.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(exports.Votation).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(exports.Votation).encode(__typed__); },
  },
  FinalizeVotation: {
    template: function () { return exports.Votation; },
    choiceName: 'FinalizeVotation',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.FinalizeVotation.decoder; }),
    argumentEncode: function (__typed__) { return exports.FinalizeVotation.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(exports.MIresultArbitrators).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(exports.MIresultArbitrators).encode(__typed__); },
  },
}

);


damlTypes.registerTemplate(exports.Votation);



exports.ConfirmAttribution = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({inviter: damlTypes.Party.decoder, }); }),
  encode: function (__typed__) {
  return {
    inviter: damlTypes.Party.encode(__typed__.inviter),
  };
}
,
};



exports.Accept = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({arbitrator: damlTypes.Party.decoder, }); }),
  encode: function (__typed__) {
  return {
    arbitrator: damlTypes.Party.encode(__typed__.arbitrator),
  };
}
,
};



exports.InviteArbitrators = damlTypes.assembleTemplate(
{
  templateId: 'f18eb482c25f64cd721de470f30dbf6a8247ca127e6e772be98e809b5cbf23a3:Platform.LeaseAgreement.ModelMI:InviteArbitrators',
  keyDecoder: damlTypes.lazyMemo(function () { return jtv.constant(undefined); }),
  keyEncode: function () { throw 'EncodeError'; },
  decoder: damlTypes.lazyMemo(function () { return jtv.object({inviter: damlTypes.Party.decoder, invited: pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657.DA.Set.Types.Set(damlTypes.Party).decoder, confirmed: pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657.DA.Set.Types.Set(damlTypes.Party).decoder, miDetails: Platform_Types_MI.MIdetails.decoder, miReportCid: damlTypes.ContractId(exports.MIReport).decoder, }); }),
  encode: function (__typed__) {
  return {
    inviter: damlTypes.Party.encode(__typed__.inviter),
    invited: pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657.DA.Set.Types.Set(damlTypes.Party).encode(__typed__.invited),
    confirmed: pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657.DA.Set.Types.Set(damlTypes.Party).encode(__typed__.confirmed),
    miDetails: Platform_Types_MI.MIdetails.encode(__typed__.miDetails),
    miReportCid: damlTypes.ContractId(exports.MIReport).encode(__typed__.miReportCid),
  };
}
,
  Archive: {
    template: function () { return exports.InviteArbitrators; },
    choiceName: 'Archive',
    argumentDecoder: damlTypes.lazyMemo(function () { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.decoder; }),
    argumentEncode: function (__typed__) { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.Unit.decoder; }),
    resultEncode: function (__typed__) { return damlTypes.Unit.encode(__typed__); },
  },
  Accept: {
    template: function () { return exports.InviteArbitrators; },
    choiceName: 'Accept',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.Accept.decoder; }),
    argumentEncode: function (__typed__) { return exports.Accept.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(exports.InviteArbitrators).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(exports.InviteArbitrators).encode(__typed__); },
  },
  ConfirmAttribution: {
    template: function () { return exports.InviteArbitrators; },
    choiceName: 'ConfirmAttribution',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.ConfirmAttribution.decoder; }),
    argumentEncode: function (__typed__) { return exports.ConfirmAttribution.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(exports.MIReport).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(exports.MIReport).encode(__typed__); },
  },
}

);


damlTypes.registerTemplate(exports.InviteArbitrators);



exports.CreateVotation = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({visitor: damlTypes.Party.decoder, visitDetails: damlTypes.Text.decoder, assessment: Platform_Types_MI.AssessmentDetails.decoder, }); }),
  encode: function (__typed__) {
  return {
    visitor: damlTypes.Party.encode(__typed__.visitor),
    visitDetails: damlTypes.Text.encode(__typed__.visitDetails),
    assessment: Platform_Types_MI.AssessmentDetails.encode(__typed__.assessment),
  };
}
,
};



exports.SetArbitrators = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({inviter: damlTypes.Party.decoder, arbitrators: pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657.DA.Set.Types.Set(damlTypes.Party).decoder, }); }),
  encode: function (__typed__) {
  return {
    inviter: damlTypes.Party.encode(__typed__.inviter),
    arbitrators: pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657.DA.Set.Types.Set(damlTypes.Party).encode(__typed__.arbitrators),
  };
}
,
};



exports.MIReport = damlTypes.assembleTemplate(
{
  templateId: 'f18eb482c25f64cd721de470f30dbf6a8247ca127e6e772be98e809b5cbf23a3:Platform.LeaseAgreement.ModelMI:MIReport',
  keyDecoder: damlTypes.lazyMemo(function () { return damlTypes.lazyMemo(function () { return pkg40f452260bef3f29dede136108fc08a88d5a5250310281067087da6f0baddff7.DA.Types.Tuple3(damlTypes.Party, damlTypes.Party, Platform_Types_MI.MIdetails).decoder; }); }),
  keyEncode: function (__typed__) { return pkg40f452260bef3f29dede136108fc08a88d5a5250310281067087da6f0baddff7.DA.Types.Tuple3(damlTypes.Party, damlTypes.Party, Platform_Types_MI.MIdetails).encode(__typed__); },
  decoder: damlTypes.lazyMemo(function () { return jtv.object({tenant: damlTypes.Party.decoder, host: damlTypes.Party.decoder, miDetails: Platform_Types_MI.MIdetails.decoder, arbitrators: pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657.DA.Set.Types.Set(damlTypes.Party).decoder, }); }),
  encode: function (__typed__) {
  return {
    tenant: damlTypes.Party.encode(__typed__.tenant),
    host: damlTypes.Party.encode(__typed__.host),
    miDetails: Platform_Types_MI.MIdetails.encode(__typed__.miDetails),
    arbitrators: pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657.DA.Set.Types.Set(damlTypes.Party).encode(__typed__.arbitrators),
  };
}
,
  Archive: {
    template: function () { return exports.MIReport; },
    choiceName: 'Archive',
    argumentDecoder: damlTypes.lazyMemo(function () { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.decoder; }),
    argumentEncode: function (__typed__) { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.Unit.decoder; }),
    resultEncode: function (__typed__) { return damlTypes.Unit.encode(__typed__); },
  },
  SetArbitrators: {
    template: function () { return exports.MIReport; },
    choiceName: 'SetArbitrators',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.SetArbitrators.decoder; }),
    argumentEncode: function (__typed__) { return exports.SetArbitrators.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(exports.MIReport).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(exports.MIReport).encode(__typed__); },
  },
  CreateVotation: {
    template: function () { return exports.MIReport; },
    choiceName: 'CreateVotation',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.CreateVotation.decoder; }),
    argumentEncode: function (__typed__) { return exports.CreateVotation.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(exports.Votation).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(exports.Votation).encode(__typed__); },
  },
}

);


damlTypes.registerTemplate(exports.MIReport);


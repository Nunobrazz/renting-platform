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

var Platform_LeaseAgreement_ModelMI = require('../../../Platform/LeaseAgreement/ModelMI/module');
var Platform_Types_Common = require('../../../Platform/Types/Common/module');
var Platform_Types_LA = require('../../../Platform/Types/LA/module');
var Platform_Types_MI = require('../../../Platform/Types/MI/module');


exports.Approve = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({lifecycler: damlTypes.Party.decoder, }); }),
  encode: function (__typed__) {
  return {
    lifecycler: damlTypes.Party.encode(__typed__.lifecycler),
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
  templateId: 'f18eb482c25f64cd721de470f30dbf6a8247ca127e6e772be98e809b5cbf23a3:Platform.LeaseAgreement.Service:Request',
  keyDecoder: damlTypes.lazyMemo(function () { return jtv.constant(undefined); }),
  keyEncode: function () { throw 'EncodeError'; },
  decoder: damlTypes.lazyMemo(function () { return jtv.object({operator: damlTypes.Party.decoder, proposer: damlTypes.Party.decoder, house: Platform_Types_Common.House.decoder, leaseTerms: Platform_Types_Common.LeaseTerms.decoder, }); }),
  encode: function (__typed__) {
  return {
    operator: damlTypes.Party.encode(__typed__.operator),
    proposer: damlTypes.Party.encode(__typed__.proposer),
    house: Platform_Types_Common.House.encode(__typed__.house),
    leaseTerms: Platform_Types_Common.LeaseTerms.encode(__typed__.leaseTerms),
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



exports.FinalizeInvitation = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({inviter: damlTypes.Party.decoder, invitationCid: damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.InviteArbitrators).decoder, }); }),
  encode: function (__typed__) {
  return {
    inviter: damlTypes.Party.encode(__typed__.inviter),
    invitationCid: damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.InviteArbitrators).encode(__typed__.invitationCid),
  };
}
,
};



exports.InvokeArbitrators = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({inviter: damlTypes.Party.decoder, invited: pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657.DA.Set.Types.Set(damlTypes.Party).decoder, miReportCid: damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.MIReport).decoder, }); }),
  encode: function (__typed__) {
  return {
    inviter: damlTypes.Party.encode(__typed__.inviter),
    invited: pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657.DA.Set.Types.Set(damlTypes.Party).encode(__typed__.invited),
    miReportCid: damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.MIReport).encode(__typed__.miReportCid),
  };
}
,
};



exports.AcceptAssessment = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({signer: damlTypes.Party.decoder, assessmentCid: damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.Assessment).decoder, }); }),
  encode: function (__typed__) {
  return {
    signer: damlTypes.Party.encode(__typed__.signer),
    assessmentCid: damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.Assessment).encode(__typed__.assessmentCid),
  };
}
,
};



exports.SubmitAssessment = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({creator: damlTypes.Party.decoder, signer: damlTypes.Party.decoder, assessment: Platform_Types_MI.AssessmentDetails.decoder, miReportCid: damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.MIReport).decoder, }); }),
  encode: function (__typed__) {
  return {
    creator: damlTypes.Party.encode(__typed__.creator),
    signer: damlTypes.Party.encode(__typed__.signer),
    assessment: Platform_Types_MI.AssessmentDetails.encode(__typed__.assessment),
    miReportCid: damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.MIReport).encode(__typed__.miReportCid),
  };
}
,
};



exports.CreateMI = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({reporter: damlTypes.Party.decoder, house: Platform_Types_Common.House.decoder, description: damlTypes.Text.decoder, startingDate: damlTypes.Date.decoder, }); }),
  encode: function (__typed__) {
  return {
    reporter: damlTypes.Party.encode(__typed__.reporter),
    house: Platform_Types_Common.House.encode(__typed__.house),
    description: damlTypes.Text.encode(__typed__.description),
    startingDate: damlTypes.Date.encode(__typed__.startingDate),
  };
}
,
};



exports.Service = damlTypes.assembleTemplate(
{
  templateId: 'f18eb482c25f64cd721de470f30dbf6a8247ca127e6e772be98e809b5cbf23a3:Platform.LeaseAgreement.Service:Service',
  keyDecoder: damlTypes.lazyMemo(function () { return damlTypes.lazyMemo(function () { return pkg40f452260bef3f29dede136108fc08a88d5a5250310281067087da6f0baddff7.DA.Types.Tuple2(damlTypes.Party, damlTypes.Party).decoder; }); }),
  keyEncode: function (__typed__) { return pkg40f452260bef3f29dede136108fc08a88d5a5250310281067087da6f0baddff7.DA.Types.Tuple2(damlTypes.Party, damlTypes.Party).encode(__typed__); },
  decoder: damlTypes.lazyMemo(function () { return jtv.object({operator: damlTypes.Party.decoder, host: damlTypes.Party.decoder, tenant: damlTypes.Party.decoder, laKey: Platform_Types_LA.LAkey.decoder, }); }),
  encode: function (__typed__) {
  return {
    operator: damlTypes.Party.encode(__typed__.operator),
    host: damlTypes.Party.encode(__typed__.host),
    tenant: damlTypes.Party.encode(__typed__.tenant),
    laKey: Platform_Types_LA.LAkey.encode(__typed__.laKey),
  };
}
,
  CreateMI: {
    template: function () { return exports.Service; },
    choiceName: 'CreateMI',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.CreateMI.decoder; }),
    argumentEncode: function (__typed__) { return exports.CreateMI.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.MIReport).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.MIReport).encode(__typed__); },
  },
  SubmitAssessment: {
    template: function () { return exports.Service; },
    choiceName: 'SubmitAssessment',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.SubmitAssessment.decoder; }),
    argumentEncode: function (__typed__) { return exports.SubmitAssessment.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.Assessment).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.Assessment).encode(__typed__); },
  },
  AcceptAssessment: {
    template: function () { return exports.Service; },
    choiceName: 'AcceptAssessment',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.AcceptAssessment.decoder; }),
    argumentEncode: function (__typed__) { return exports.AcceptAssessment.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.MIresultFriendly).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.MIresultFriendly).encode(__typed__); },
  },
  InvokeArbitrators: {
    template: function () { return exports.Service; },
    choiceName: 'InvokeArbitrators',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.InvokeArbitrators.decoder; }),
    argumentEncode: function (__typed__) { return exports.InvokeArbitrators.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.InviteArbitrators).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.InviteArbitrators).encode(__typed__); },
  },
  FinalizeInvitation: {
    template: function () { return exports.Service; },
    choiceName: 'FinalizeInvitation',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.FinalizeInvitation.decoder; }),
    argumentEncode: function (__typed__) { return exports.FinalizeInvitation.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.MIReport).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(Platform_LeaseAgreement_ModelMI.MIReport).encode(__typed__); },
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


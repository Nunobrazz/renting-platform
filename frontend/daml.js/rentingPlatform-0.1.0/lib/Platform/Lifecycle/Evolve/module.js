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

var Interface_Types = require('../../../Interface/Types/module');
var Time_Clock = require('../../../Time/Clock/module');


exports.ProcessEvent = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({eventCid: damlTypes.ContractId(Time_Clock.DateClockUpdateEvent).decoder, }); }),
  encode: function (__typed__) {
  return {
    eventCid: damlTypes.ContractId(Time_Clock.DateClockUpdateEvent).encode(__typed__.eventCid),
  };
}
,
};



exports.AddLA = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({laKey: Interface_Types.LAkey.decoder, }); }),
  encode: function (__typed__) {
  return {
    laKey: Interface_Types.LAkey.encode(__typed__.laKey),
  };
}
,
};



exports.Evolve = damlTypes.assembleTemplate(
{
  templateId: '686bd5d09f27512a24df24b750340cc9b1d484210591ec480915da92fe71121e:Platform.Lifecycle.Evolve:Evolve',
  keyDecoder: damlTypes.lazyMemo(function () { return jtv.constant(undefined); }),
  keyEncode: function () { throw 'EncodeError'; },
  decoder: damlTypes.lazyMemo(function () { return jtv.object({operator: damlTypes.Party.decoder, lifecycler: damlTypes.Party.decoder, laKeys: pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657.DA.Set.Types.Set(Interface_Types.LAkey).decoder, }); }),
  encode: function (__typed__) {
  return {
    operator: damlTypes.Party.encode(__typed__.operator),
    lifecycler: damlTypes.Party.encode(__typed__.lifecycler),
    laKeys: pkg97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657.DA.Set.Types.Set(Interface_Types.LAkey).encode(__typed__.laKeys),
  };
}
,
  AddLA: {
    template: function () { return exports.Evolve; },
    choiceName: 'AddLA',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.AddLA.decoder; }),
    argumentEncode: function (__typed__) { return exports.AddLA.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(exports.Evolve).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(exports.Evolve).encode(__typed__); },
  },
  Archive: {
    template: function () { return exports.Evolve; },
    choiceName: 'Archive',
    argumentDecoder: damlTypes.lazyMemo(function () { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.decoder; }),
    argumentEncode: function (__typed__) { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.Unit.decoder; }),
    resultEncode: function (__typed__) { return damlTypes.Unit.encode(__typed__); },
  },
  ProcessEvent: {
    template: function () { return exports.Evolve; },
    choiceName: 'ProcessEvent',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.ProcessEvent.decoder; }),
    argumentEncode: function (__typed__) { return exports.ProcessEvent.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.Unit.decoder; }),
    resultEncode: function (__typed__) { return damlTypes.Unit.encode(__typed__); },
  },
}

);


damlTypes.registerTemplate(exports.Evolve);


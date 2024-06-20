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


exports.Change = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({newAlias: damlTypes.Text.decoder, }); }),
  encode: function (__typed__) {
  return {
    newAlias: damlTypes.Text.encode(__typed__.newAlias),
  };
}
,
};



exports.Alias = damlTypes.assembleTemplate(
{
  templateId: 'f18eb482c25f64cd721de470f30dbf6a8247ca127e6e772be98e809b5cbf23a3:User:Alias',
  keyDecoder: damlTypes.lazyMemo(function () { return damlTypes.lazyMemo(function () { return pkg40f452260bef3f29dede136108fc08a88d5a5250310281067087da6f0baddff7.DA.Types.Tuple2(damlTypes.Party, damlTypes.Party).decoder; }); }),
  keyEncode: function (__typed__) { return pkg40f452260bef3f29dede136108fc08a88d5a5250310281067087da6f0baddff7.DA.Types.Tuple2(damlTypes.Party, damlTypes.Party).encode(__typed__); },
  decoder: damlTypes.lazyMemo(function () { return jtv.object({username: damlTypes.Party.decoder, alias: damlTypes.Text.decoder, public: damlTypes.Party.decoder, }); }),
  encode: function (__typed__) {
  return {
    username: damlTypes.Party.encode(__typed__.username),
    alias: damlTypes.Text.encode(__typed__.alias),
    public: damlTypes.Party.encode(__typed__.public),
  };
}
,
  Archive: {
    template: function () { return exports.Alias; },
    choiceName: 'Archive',
    argumentDecoder: damlTypes.lazyMemo(function () { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.decoder; }),
    argumentEncode: function (__typed__) { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.Unit.decoder; }),
    resultEncode: function (__typed__) { return damlTypes.Unit.encode(__typed__); },
  },
  Change: {
    template: function () { return exports.Alias; },
    choiceName: 'Change',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.Change.decoder; }),
    argumentEncode: function (__typed__) { return exports.Change.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(exports.Alias).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(exports.Alias).encode(__typed__); },
  },
}

);


damlTypes.registerTemplate(exports.Alias);



exports.Message = damlTypes.assembleTemplate(
{
  templateId: 'f18eb482c25f64cd721de470f30dbf6a8247ca127e6e772be98e809b5cbf23a3:User:Message',
  keyDecoder: damlTypes.lazyMemo(function () { return jtv.constant(undefined); }),
  keyEncode: function () { throw 'EncodeError'; },
  decoder: damlTypes.lazyMemo(function () { return jtv.object({text: damlTypes.Text.decoder, receiver: damlTypes.Party.decoder, sender: damlTypes.Party.decoder, }); }),
  encode: function (__typed__) {
  return {
    text: damlTypes.Text.encode(__typed__.text),
    receiver: damlTypes.Party.encode(__typed__.receiver),
    sender: damlTypes.Party.encode(__typed__.sender),
  };
}
,
  Archive: {
    template: function () { return exports.Message; },
    choiceName: 'Archive',
    argumentDecoder: damlTypes.lazyMemo(function () { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.decoder; }),
    argumentEncode: function (__typed__) { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.Unit.decoder; }),
    resultEncode: function (__typed__) { return damlTypes.Unit.encode(__typed__); },
  },
}

);


damlTypes.registerTemplate(exports.Message);



exports.SendMessage = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({text: damlTypes.Text.decoder, sender: damlTypes.Party.decoder, }); }),
  encode: function (__typed__) {
  return {
    text: damlTypes.Text.encode(__typed__.text),
    sender: damlTypes.Party.encode(__typed__.sender),
  };
}
,
};



exports.Follow = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({userToFollow: damlTypes.Party.decoder, }); }),
  encode: function (__typed__) {
  return {
    userToFollow: damlTypes.Party.encode(__typed__.userToFollow),
  };
}
,
};



exports.User = damlTypes.assembleTemplate(
{
  templateId: 'f18eb482c25f64cd721de470f30dbf6a8247ca127e6e772be98e809b5cbf23a3:User:User',
  keyDecoder: damlTypes.lazyMemo(function () { return damlTypes.lazyMemo(function () { return damlTypes.Party.decoder; }); }),
  keyEncode: function (__typed__) { return damlTypes.Party.encode(__typed__); },
  decoder: damlTypes.lazyMemo(function () { return jtv.object({username: damlTypes.Party.decoder, following: damlTypes.List(damlTypes.Party).decoder, }); }),
  encode: function (__typed__) {
  return {
    username: damlTypes.Party.encode(__typed__.username),
    following: damlTypes.List(damlTypes.Party).encode(__typed__.following),
  };
}
,
  Follow: {
    template: function () { return exports.User; },
    choiceName: 'Follow',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.Follow.decoder; }),
    argumentEncode: function (__typed__) { return exports.Follow.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(exports.User).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(exports.User).encode(__typed__); },
  },
  SendMessage: {
    template: function () { return exports.User; },
    choiceName: 'SendMessage',
    argumentDecoder: damlTypes.lazyMemo(function () { return exports.SendMessage.decoder; }),
    argumentEncode: function (__typed__) { return exports.SendMessage.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.ContractId(exports.Message).decoder; }),
    resultEncode: function (__typed__) { return damlTypes.ContractId(exports.Message).encode(__typed__); },
  },
  Archive: {
    template: function () { return exports.User; },
    choiceName: 'Archive',
    argumentDecoder: damlTypes.lazyMemo(function () { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.decoder; }),
    argumentEncode: function (__typed__) { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.Unit.decoder; }),
    resultEncode: function (__typed__) { return damlTypes.Unit.encode(__typed__); },
  },
}

);


damlTypes.registerTemplate(exports.User);

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


exports.Iou = damlTypes.assembleTemplate(
{
  templateId: 'f18eb482c25f64cd721de470f30dbf6a8247ca127e6e772be98e809b5cbf23a3:Time.Lifecycle.Iou:Iou',
  keyDecoder: damlTypes.lazyMemo(function () { return jtv.constant(undefined); }),
  keyEncode: function () { throw 'EncodeError'; },
  decoder: damlTypes.lazyMemo(function () { return jtv.object({creator: damlTypes.Party.decoder, debtor: damlTypes.Party.decoder, owner: damlTypes.Party.decoder, amount: damlTypes.Int.decoder, paymentDate: damlTypes.Date.decoder, creationDate: damlTypes.Date.decoder, }); }),
  encode: function (__typed__) {
  return {
    creator: damlTypes.Party.encode(__typed__.creator),
    debtor: damlTypes.Party.encode(__typed__.debtor),
    owner: damlTypes.Party.encode(__typed__.owner),
    amount: damlTypes.Int.encode(__typed__.amount),
    paymentDate: damlTypes.Date.encode(__typed__.paymentDate),
    creationDate: damlTypes.Date.encode(__typed__.creationDate),
  };
}
,
  Archive: {
    template: function () { return exports.Iou; },
    choiceName: 'Archive',
    argumentDecoder: damlTypes.lazyMemo(function () { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.decoder; }),
    argumentEncode: function (__typed__) { return pkgd14e08374fc7197d6a0de468c968ae8ba3aadbf9315476fd39071831f5923662.DA.Internal.Template.Archive.encode(__typed__); },
    resultDecoder: damlTypes.lazyMemo(function () { return damlTypes.Unit.decoder; }),
    resultEncode: function (__typed__) { return damlTypes.Unit.encode(__typed__); },
  },
}

);


damlTypes.registerTemplate(exports.Iou);


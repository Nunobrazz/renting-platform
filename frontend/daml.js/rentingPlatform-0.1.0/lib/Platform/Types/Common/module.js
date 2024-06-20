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


exports.LeaseTerms = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({agreedRent: damlTypes.Int.decoder, beginingDate: damlTypes.Date.decoder, paymentDates: damlTypes.List(damlTypes.Date).decoder, nArbitrators: damlTypes.Int.decoder, }); }),
  encode: function (__typed__) {
  return {
    agreedRent: damlTypes.Int.encode(__typed__.agreedRent),
    beginingDate: damlTypes.Date.encode(__typed__.beginingDate),
    paymentDates: damlTypes.List(damlTypes.Date).encode(__typed__.paymentDates),
    nArbitrators: damlTypes.Int.encode(__typed__.nArbitrators),
  };
}
,
};



exports.House = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({host: damlTypes.Party.decoder, address: damlTypes.Text.decoder, details: damlTypes.Text.decoder, listedRent: damlTypes.Int.decoder, }); }),
  encode: function (__typed__) {
  return {
    host: damlTypes.Party.encode(__typed__.host),
    address: damlTypes.Text.encode(__typed__.address),
    details: damlTypes.Text.encode(__typed__.details),
    listedRent: damlTypes.Int.encode(__typed__.listedRent),
  };
}
,
};


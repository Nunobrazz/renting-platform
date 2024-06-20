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


exports.Claim = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({claimDate: damlTypes.Date.decoder, amount: damlTypes.Int.decoder, }); }),
  encode: function (__typed__) {
  return {
    claimDate: damlTypes.Date.encode(__typed__.claimDate),
    amount: damlTypes.Int.encode(__typed__.amount),
  };
}
,
};



exports.MIkey = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({reporter: damlTypes.Party.decoder, house: exports.House.decoder, breakdown: exports.Breakdown.decoder, }); }),
  encode: function (__typed__) {
  return {
    reporter: damlTypes.Party.encode(__typed__.reporter),
    house: exports.House.encode(__typed__.house),
    breakdown: exports.Breakdown.encode(__typed__.breakdown),
  };
}
,
};



exports.LAkey = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({tenant: damlTypes.Party.decoder, house: exports.House.decoder, }); }),
  encode: function (__typed__) {
  return {
    tenant: damlTypes.Party.encode(__typed__.tenant),
    house: exports.House.encode(__typed__.house),
  };
}
,
};



exports.AssessmentDetails = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({responsability: exports.Responsability.decoder, cost: damlTypes.Optional(damlTypes.Int).decoder, assessmentDate: damlTypes.Date.decoder, reparationDate: damlTypes.Optional(damlTypes.Date).decoder, }); }),
  encode: function (__typed__) {
  return {
    responsability: exports.Responsability.encode(__typed__.responsability),
    cost: damlTypes.Optional(damlTypes.Int).encode(__typed__.cost),
    assessmentDate: damlTypes.Date.encode(__typed__.assessmentDate),
    reparationDate: damlTypes.Optional(damlTypes.Date).encode(__typed__.reparationDate),
  };
}
,
};



exports.Responsability = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({reporterResp: damlTypes.Int.decoder, counterpartResp: damlTypes.Int.decoder, }); }),
  encode: function (__typed__) {
  return {
    reporterResp: damlTypes.Int.encode(__typed__.reporterResp),
    counterpartResp: damlTypes.Int.encode(__typed__.counterpartResp),
  };
}
,
};



exports.Breakdown = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({startingDate: damlTypes.Date.decoder, description: damlTypes.Text.decoder, }); }),
  encode: function (__typed__) {
  return {
    startingDate: damlTypes.Date.encode(__typed__.startingDate),
    description: damlTypes.Text.encode(__typed__.description),
  };
}
,
};



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



exports.Id = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({unpack: damlTypes.Text.decoder, }); }),
  encode: function (__typed__) {
  return {
    unpack: damlTypes.Text.encode(__typed__.unpack),
  };
}
,
};


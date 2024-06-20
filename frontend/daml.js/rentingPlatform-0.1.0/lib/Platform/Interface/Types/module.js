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


exports.MIkey = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({reporter: damlTypes.Party.decoder, house: exports.House.decoder, id: exports.Id.decoder, }); }),
  encode: function (__typed__) {
  return {
    reporter: damlTypes.Party.encode(__typed__.reporter),
    house: exports.House.encode(__typed__.house),
    id: exports.Id.encode(__typed__.id),
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
  decoder: damlTypes.lazyMemo(function () { return jtv.object({reporterResp: damlTypes.Int.decoder, counterpartResp: damlTypes.Int.decoder, cost: damlTypes.Optional(damlTypes.Int).decoder, assessmentDate: damlTypes.Date.decoder, reparationDate: damlTypes.Optional(damlTypes.Date).decoder, }); }),
  encode: function (__typed__) {
  return {
    reporterResp: damlTypes.Int.encode(__typed__.reporterResp),
    counterpartResp: damlTypes.Int.encode(__typed__.counterpartResp),
    cost: damlTypes.Optional(damlTypes.Int).encode(__typed__.cost),
    assessmentDate: damlTypes.Date.encode(__typed__.assessmentDate),
    reparationDate: damlTypes.Optional(damlTypes.Date).encode(__typed__.reparationDate),
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
  decoder: damlTypes.lazyMemo(function () { return jtv.object({rent: damlTypes.Int.decoder, beginingDate: damlTypes.Date.decoder, paymentDates: damlTypes.List(damlTypes.Date).decoder, nArbitrators: damlTypes.Int.decoder, }); }),
  encode: function (__typed__) {
  return {
    rent: damlTypes.Int.encode(__typed__.rent),
    beginingDate: damlTypes.Date.encode(__typed__.beginingDate),
    paymentDates: damlTypes.List(damlTypes.Date).encode(__typed__.paymentDates),
    nArbitrators: damlTypes.Int.encode(__typed__.nArbitrators),
  };
}
,
};



exports.House = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({host: damlTypes.Party.decoder, address: damlTypes.Text.decoder, details: damlTypes.Text.decoder, rent: damlTypes.Int.decoder, }); }),
  encode: function (__typed__) {
  return {
    host: damlTypes.Party.encode(__typed__.host),
    address: damlTypes.Text.encode(__typed__.address),
    details: damlTypes.Text.encode(__typed__.details),
    rent: damlTypes.Int.encode(__typed__.rent),
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


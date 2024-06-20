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

var Platform_LeaseAgreement_Service = require('../../Platform/LeaseAgreement/Service/module');
var Platform_Role_Operator = require('../../Platform/Role/Operator/module');
var Time_Clock = require('../../Time/Clock/module');
var Time_Lifecycle_Evolve = require('../../Time/Lifecycle/Evolve/module');


exports.Contracts = {
  decoder: damlTypes.lazyMemo(function () { return jtv.object({operatorRoleCid: damlTypes.ContractId(Platform_Role_Operator.Role).decoder, laServiceCid: damlTypes.ContractId(Platform_LeaseAgreement_Service.Service).decoder, clockCid: damlTypes.ContractId(Time_Clock.DateClock).decoder, evolveCid: damlTypes.ContractId(Time_Lifecycle_Evolve.Evolve).decoder, }); }),
  encode: function (__typed__) {
  return {
    operatorRoleCid: damlTypes.ContractId(Platform_Role_Operator.Role).encode(__typed__.operatorRoleCid),
    laServiceCid: damlTypes.ContractId(Platform_LeaseAgreement_Service.Service).encode(__typed__.laServiceCid),
    clockCid: damlTypes.ContractId(Time_Clock.DateClock).encode(__typed__.clockCid),
    evolveCid: damlTypes.ContractId(Time_Lifecycle_Evolve.Evolve).encode(__typed__.evolveCid),
  };
}
,
};


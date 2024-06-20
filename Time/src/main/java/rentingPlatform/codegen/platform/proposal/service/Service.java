package rentingPlatform.codegen.platform.proposal.service;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.ContractFilter;
import com.daml.ledger.javaapi.data.CreateAndExerciseCommand;
import com.daml.ledger.javaapi.data.CreateCommand;
import com.daml.ledger.javaapi.data.CreatedEvent;
import com.daml.ledger.javaapi.data.DamlRecord;
import com.daml.ledger.javaapi.data.ExerciseByKeyCommand;
import com.daml.ledger.javaapi.data.ExerciseCommand;
import com.daml.ledger.javaapi.data.Identifier;
import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Template;
import com.daml.ledger.javaapi.data.Unit;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.codegen.Choice;
import com.daml.ledger.javaapi.data.codegen.ContractCompanion;
import com.daml.ledger.javaapi.data.codegen.ContractTypeCompanion;
import com.daml.ledger.javaapi.data.codegen.ContractWithKey;
import com.daml.ledger.javaapi.data.codegen.Created;
import com.daml.ledger.javaapi.data.codegen.Exercised;
import com.daml.ledger.javaapi.data.codegen.PrimitiveValueDecoders;
import com.daml.ledger.javaapi.data.codegen.Update;
import com.daml.ledger.javaapi.data.codegen.ValueDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfReader;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import rentingPlatform.codegen.da.types.Tuple2;
import rentingPlatform.codegen.platform.leaseagreement.service.Request;
import rentingPlatform.codegen.platform.proposal.model.Proposal;
import rentingPlatform.codegen.platform.types.common.House;
import rentingPlatform.codegen.platform.types.common.LeaseTerms;

public final class Service extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("c911fdfc3964813e1caa91849f67e4b0ec3b6260c2d032ebcdf01d6c820d721b", "Platform.Proposal.Service", "Service");

  public static final Choice<Service, RejectProposal, Unit> CHOICE_RejectProposal = 
      Choice.create("RejectProposal", value$ -> value$.toValue(), value$ ->
        RejectProposal.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromUnit
        .decode(value$));

  public static final Choice<Service, AcceptProposal, Proposal.ContractId> CHOICE_AcceptProposal = 
      Choice.create("AcceptProposal", value$ -> value$.toValue(), value$ ->
        AcceptProposal.valueDecoder().decode(value$), value$ ->
        new Proposal.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Service, DeleteProposal, Unit> CHOICE_DeleteProposal = 
      Choice.create("DeleteProposal", value$ -> value$.toValue(), value$ ->
        DeleteProposal.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromUnit
        .decode(value$));

  public static final Choice<Service, RequestLeaseAgreement, Request.ContractId> CHOICE_RequestLeaseAgreement = 
      Choice.create("RequestLeaseAgreement", value$ -> value$.toValue(), value$ ->
        RequestLeaseAgreement.valueDecoder().decode(value$), value$ ->
        new Request.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Service, SignProposal, Proposal.ContractId> CHOICE_SignProposal = 
      Choice.create("SignProposal", value$ -> value$.toValue(), value$ ->
        SignProposal.valueDecoder().decode(value$), value$ ->
        new Proposal.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Service, rentingPlatform.codegen.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        rentingPlatform.codegen.da.internal.template.Archive.valueDecoder().decode(value$),
        value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, CreateProposal, Proposal.ContractId> CHOICE_CreateProposal = 
      Choice.create("CreateProposal", value$ -> value$.toValue(), value$ ->
        CreateProposal.valueDecoder().decode(value$), value$ ->
        new Proposal.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final ContractCompanion.WithKey<Contract, ContractId, Service, Tuple2<String, String>> COMPANION = 
      new ContractCompanion.WithKey<>("rentingPlatform.codegen.platform.proposal.service.Service",
        TEMPLATE_ID, ContractId::new, v -> Service.templateValueDecoder().decode(v),
        Service::fromJson, Contract::new, List.of(CHOICE_AcceptProposal, CHOICE_RejectProposal,
        CHOICE_CreateProposal, CHOICE_SignProposal, CHOICE_DeleteProposal, CHOICE_Archive,
        CHOICE_RequestLeaseAgreement), e -> Tuple2.<java.lang.String,
        java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty,
        PrimitiveValueDecoders.fromParty).decode(e));

  public final String operator;

  public final String proposer;

  public final String host;

  public Service(String operator, String proposer, String host) {
    this.operator = operator;
    this.proposer = proposer;
    this.host = host;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(Service.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseRejectProposal} instead
   */
  @Deprecated
  public static Update<Exercised<Unit>> exerciseByKeyRejectProposal(Tuple2<String, String> key,
      RejectProposal arg) {
    return byKey(key).exerciseRejectProposal(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseRejectProposal(proposalCid)} instead
   */
  @Deprecated
  public static Update<Exercised<Unit>> exerciseByKeyRejectProposal(Tuple2<String, String> key,
      Proposal.ContractId proposalCid) {
    return byKey(key).exerciseRejectProposal(proposalCid);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseAcceptProposal} instead
   */
  @Deprecated
  public static Update<Exercised<Proposal.ContractId>> exerciseByKeyAcceptProposal(
      Tuple2<String, String> key, AcceptProposal arg) {
    return byKey(key).exerciseAcceptProposal(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseAcceptProposal(proposalCid)} instead
   */
  @Deprecated
  public static Update<Exercised<Proposal.ContractId>> exerciseByKeyAcceptProposal(
      Tuple2<String, String> key, Proposal.ContractId proposalCid) {
    return byKey(key).exerciseAcceptProposal(proposalCid);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseDeleteProposal} instead
   */
  @Deprecated
  public static Update<Exercised<Unit>> exerciseByKeyDeleteProposal(Tuple2<String, String> key,
      DeleteProposal arg) {
    return byKey(key).exerciseDeleteProposal(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseDeleteProposal(proposalCid)} instead
   */
  @Deprecated
  public static Update<Exercised<Unit>> exerciseByKeyDeleteProposal(Tuple2<String, String> key,
      Proposal.ContractId proposalCid) {
    return byKey(key).exerciseDeleteProposal(proposalCid);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseRequestLeaseAgreement} instead
   */
  @Deprecated
  public static Update<Exercised<Request.ContractId>> exerciseByKeyRequestLeaseAgreement(
      Tuple2<String, String> key, RequestLeaseAgreement arg) {
    return byKey(key).exerciseRequestLeaseAgreement(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseRequestLeaseAgreement(signer,
      proposalCid)} instead
   */
  @Deprecated
  public static Update<Exercised<Request.ContractId>> exerciseByKeyRequestLeaseAgreement(
      Tuple2<String, String> key, String signer, Proposal.ContractId proposalCid) {
    return byKey(key).exerciseRequestLeaseAgreement(signer, proposalCid);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseSignProposal} instead
   */
  @Deprecated
  public static Update<Exercised<Proposal.ContractId>> exerciseByKeySignProposal(
      Tuple2<String, String> key, SignProposal arg) {
    return byKey(key).exerciseSignProposal(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseSignProposal(signer,
      proposalCid)} instead
   */
  @Deprecated
  public static Update<Exercised<Proposal.ContractId>> exerciseByKeySignProposal(
      Tuple2<String, String> key, String signer, Proposal.ContractId proposalCid) {
    return byKey(key).exerciseSignProposal(signer, proposalCid);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseArchive} instead
   */
  @Deprecated
  public static Update<Exercised<Unit>> exerciseByKeyArchive(Tuple2<String, String> key,
      rentingPlatform.codegen.da.internal.template.Archive arg) {
    return byKey(key).exerciseArchive(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseArchive()} instead
   */
  @Deprecated
  public static Update<Exercised<Unit>> exerciseByKeyArchive(Tuple2<String, String> key) {
    return byKey(key).exerciseArchive();
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseCreateProposal} instead
   */
  @Deprecated
  public static Update<Exercised<Proposal.ContractId>> exerciseByKeyCreateProposal(
      Tuple2<String, String> key, CreateProposal arg) {
    return byKey(key).exerciseCreateProposal(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseCreateProposal(proposer, house,
      leaseTerms)} instead
   */
  @Deprecated
  public static Update<Exercised<Proposal.ContractId>> exerciseByKeyCreateProposal(
      Tuple2<String, String> key, String proposer, House house, LeaseTerms leaseTerms) {
    return byKey(key).exerciseCreateProposal(proposer, house, leaseTerms);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseRejectProposal} instead
   */
  @Deprecated
  public Update<Exercised<Unit>> createAndExerciseRejectProposal(RejectProposal arg) {
    return createAnd().exerciseRejectProposal(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseRejectProposal} instead
   */
  @Deprecated
  public Update<Exercised<Unit>> createAndExerciseRejectProposal(Proposal.ContractId proposalCid) {
    return createAndExerciseRejectProposal(new RejectProposal(proposalCid));
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseAcceptProposal} instead
   */
  @Deprecated
  public Update<Exercised<Proposal.ContractId>> createAndExerciseAcceptProposal(
      AcceptProposal arg) {
    return createAnd().exerciseAcceptProposal(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseAcceptProposal} instead
   */
  @Deprecated
  public Update<Exercised<Proposal.ContractId>> createAndExerciseAcceptProposal(
      Proposal.ContractId proposalCid) {
    return createAndExerciseAcceptProposal(new AcceptProposal(proposalCid));
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseDeleteProposal} instead
   */
  @Deprecated
  public Update<Exercised<Unit>> createAndExerciseDeleteProposal(DeleteProposal arg) {
    return createAnd().exerciseDeleteProposal(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseDeleteProposal} instead
   */
  @Deprecated
  public Update<Exercised<Unit>> createAndExerciseDeleteProposal(Proposal.ContractId proposalCid) {
    return createAndExerciseDeleteProposal(new DeleteProposal(proposalCid));
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseRequestLeaseAgreement} instead
   */
  @Deprecated
  public Update<Exercised<Request.ContractId>> createAndExerciseRequestLeaseAgreement(
      RequestLeaseAgreement arg) {
    return createAnd().exerciseRequestLeaseAgreement(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseRequestLeaseAgreement} instead
   */
  @Deprecated
  public Update<Exercised<Request.ContractId>> createAndExerciseRequestLeaseAgreement(String signer,
      Proposal.ContractId proposalCid) {
    return createAndExerciseRequestLeaseAgreement(new RequestLeaseAgreement(signer, proposalCid));
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseSignProposal} instead
   */
  @Deprecated
  public Update<Exercised<Proposal.ContractId>> createAndExerciseSignProposal(SignProposal arg) {
    return createAnd().exerciseSignProposal(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseSignProposal} instead
   */
  @Deprecated
  public Update<Exercised<Proposal.ContractId>> createAndExerciseSignProposal(String signer,
      Proposal.ContractId proposalCid) {
    return createAndExerciseSignProposal(new SignProposal(signer, proposalCid));
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseArchive} instead
   */
  @Deprecated
  public Update<Exercised<Unit>> createAndExerciseArchive(
      rentingPlatform.codegen.da.internal.template.Archive arg) {
    return createAnd().exerciseArchive(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseArchive} instead
   */
  @Deprecated
  public Update<Exercised<Unit>> createAndExerciseArchive() {
    return createAndExerciseArchive(new rentingPlatform.codegen.da.internal.template.Archive());
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseCreateProposal} instead
   */
  @Deprecated
  public Update<Exercised<Proposal.ContractId>> createAndExerciseCreateProposal(
      CreateProposal arg) {
    return createAnd().exerciseCreateProposal(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseCreateProposal} instead
   */
  @Deprecated
  public Update<Exercised<Proposal.ContractId>> createAndExerciseCreateProposal(String proposer,
      House house, LeaseTerms leaseTerms) {
    return createAndExerciseCreateProposal(new CreateProposal(proposer, house, leaseTerms));
  }

  public static Update<Created<ContractId>> create(String operator, String proposer, String host) {
    return new Service(operator, proposer, host).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithKey<Contract, ContractId, Service, Tuple2<String, String>> getCompanion(
      ) {
    return COMPANION;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Service fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Service> valueDecoder() throws IllegalArgumentException {
    return ContractCompanion.valueDecoder(COMPANION);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(3);
    fields.add(new DamlRecord.Field("operator", new Party(this.operator)));
    fields.add(new DamlRecord.Field("proposer", new Party(this.proposer)));
    fields.add(new DamlRecord.Field("host", new Party(this.host)));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<Service> templateValueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(3,0, recordValue$);
      String operator = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String proposer = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      String host = PrimitiveValueDecoders.fromParty.decode(fields$.get(2).getValue());
      return new Service(operator, proposer, host);
    } ;
  }

  public static JsonLfDecoder<Service> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("operator", "proposer", "host"), name -> {
          switch (name) {
            case "operator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "proposer": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "host": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            default: return null;
          }
        }
        , (Object[] args) -> new Service(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2])));
  }

  public static Service fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("operator", apply(JsonLfEncoders::party, operator)),
        JsonLfEncoders.Field.of("proposer", apply(JsonLfEncoders::party, proposer)),
        JsonLfEncoders.Field.of("host", apply(JsonLfEncoders::party, host)));
  }

  public static ContractFilter<Contract> contractFilter() {
    return ContractFilter.of(COMPANION);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Service)) {
      return false;
    }
    Service other = (Service) object;
    return Objects.equals(this.operator, other.operator) &&
        Objects.equals(this.proposer, other.proposer) && Objects.equals(this.host, other.host);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.operator, this.proposer, this.host);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.proposal.service.Service(%s, %s, %s)",
        this.operator, this.proposer, this.host);
  }

  /**
   * Set up an {@link ExerciseByKeyCommand}; invoke an {@code exercise} method on the result of
      this to finish creating the command, or convert to an interface first with {@code toInterface}
      to invoke an interface {@code exercise} method.
   */
  public static ByKey byKey(Tuple2<String, String> key) {
    return new ByKey(key.toValue(v$0 -> new Party(v$0), v$1 -> new Party(v$1)));
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<Service> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Service, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public static ContractId fromContractId(
        com.daml.ledger.javaapi.data.codegen.ContractId<Service> contractId) {
      return COMPANION.toContractId(contractId);
    }
  }

  public static class Contract extends ContractWithKey<ContractId, Service, Tuple2<String, String>> {
    public Contract(ContractId id, Service data, Optional<String> agreementText,
        Optional<Tuple2<String, String>> key, Set<String> signatories, Set<String> observers) {
      super(id, data, agreementText, key, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, Service> getCompanion() {
      return COMPANION;
    }

    public static Contract fromIdAndRecord(String contractId, DamlRecord record$,
        Optional<String> agreementText, Optional<Tuple2<String, String>> key,
        Set<String> signatories, Set<String> observers) {
      return COMPANION.fromIdAndRecord(contractId, record$, agreementText, key, signatories,
          observers);
    }

    public static Contract fromCreatedEvent(CreatedEvent event) {
      return COMPANION.fromCreatedEvent(event);
    }
  }

  public interface Exercises<Cmd> extends com.daml.ledger.javaapi.data.codegen.Exercises.Archive<Cmd> {
    default Update<Exercised<Unit>> exerciseRejectProposal(RejectProposal arg) {
      return makeExerciseCmd(CHOICE_RejectProposal, arg);
    }

    default Update<Exercised<Unit>> exerciseRejectProposal(Proposal.ContractId proposalCid) {
      return exerciseRejectProposal(new RejectProposal(proposalCid));
    }

    default Update<Exercised<Proposal.ContractId>> exerciseAcceptProposal(AcceptProposal arg) {
      return makeExerciseCmd(CHOICE_AcceptProposal, arg);
    }

    default Update<Exercised<Proposal.ContractId>> exerciseAcceptProposal(
        Proposal.ContractId proposalCid) {
      return exerciseAcceptProposal(new AcceptProposal(proposalCid));
    }

    default Update<Exercised<Unit>> exerciseDeleteProposal(DeleteProposal arg) {
      return makeExerciseCmd(CHOICE_DeleteProposal, arg);
    }

    default Update<Exercised<Unit>> exerciseDeleteProposal(Proposal.ContractId proposalCid) {
      return exerciseDeleteProposal(new DeleteProposal(proposalCid));
    }

    default Update<Exercised<Request.ContractId>> exerciseRequestLeaseAgreement(
        RequestLeaseAgreement arg) {
      return makeExerciseCmd(CHOICE_RequestLeaseAgreement, arg);
    }

    default Update<Exercised<Request.ContractId>> exerciseRequestLeaseAgreement(String signer,
        Proposal.ContractId proposalCid) {
      return exerciseRequestLeaseAgreement(new RequestLeaseAgreement(signer, proposalCid));
    }

    default Update<Exercised<Proposal.ContractId>> exerciseSignProposal(SignProposal arg) {
      return makeExerciseCmd(CHOICE_SignProposal, arg);
    }

    default Update<Exercised<Proposal.ContractId>> exerciseSignProposal(String signer,
        Proposal.ContractId proposalCid) {
      return exerciseSignProposal(new SignProposal(signer, proposalCid));
    }

    default Update<Exercised<Unit>> exerciseArchive(
        rentingPlatform.codegen.da.internal.template.Archive arg) {
      return makeExerciseCmd(CHOICE_Archive, arg);
    }

    default Update<Exercised<Unit>> exerciseArchive() {
      return exerciseArchive(new rentingPlatform.codegen.da.internal.template.Archive());
    }

    default Update<Exercised<Proposal.ContractId>> exerciseCreateProposal(CreateProposal arg) {
      return makeExerciseCmd(CHOICE_CreateProposal, arg);
    }

    default Update<Exercised<Proposal.ContractId>> exerciseCreateProposal(String proposer,
        House house, LeaseTerms leaseTerms) {
      return exerciseCreateProposal(new CreateProposal(proposer, house, leaseTerms));
    }
  }

  public static final class CreateAnd extends com.daml.ledger.javaapi.data.codegen.CreateAnd implements Exercises<CreateAndExerciseCommand> {
    CreateAnd(Template createArguments) {
      super(createArguments);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Service, ?> getCompanion(
        ) {
      return COMPANION;
    }
  }

  public static final class ByKey extends com.daml.ledger.javaapi.data.codegen.ByKey implements Exercises<ExerciseByKeyCommand> {
    ByKey(Value key) {
      super(key);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Service, ?> getCompanion(
        ) {
      return COMPANION;
    }
  }
}

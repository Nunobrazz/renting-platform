package rentingPlatform.codegen.platform.leaseagreement.arbitratorsservice;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.ContractFilter;
import com.daml.ledger.javaapi.data.CreateAndExerciseCommand;
import com.daml.ledger.javaapi.data.CreateCommand;
import com.daml.ledger.javaapi.data.CreatedEvent;
import com.daml.ledger.javaapi.data.DamlRecord;
import com.daml.ledger.javaapi.data.ExerciseCommand;
import com.daml.ledger.javaapi.data.Identifier;
import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Template;
import com.daml.ledger.javaapi.data.Unit;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.codegen.Choice;
import com.daml.ledger.javaapi.data.codegen.ContractCompanion;
import com.daml.ledger.javaapi.data.codegen.ContractTypeCompanion;
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
import rentingPlatform.codegen.platform.leaseagreement.modelmi.InviteArbitrators;
import rentingPlatform.codegen.platform.leaseagreement.modelmi.MI;
import rentingPlatform.codegen.platform.leaseagreement.modelmi.Votation;
import rentingPlatform.codegen.platform.types.mi.AssessmentDetails;
import rentingPlatform.codegen.platform.types.mi.Responsability;

public final class Service extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("b80ed0eb60b6c3d918d4f24fbb5689a03c7ad2642b523a689de07104f792b41f", "Platform.LeaseAgreement.ArbitratorsService", "Service");

  public static final Choice<Service, AcceptMI, InviteArbitrators.ContractId> CHOICE_AcceptMI = 
      Choice.create("AcceptMI", value$ -> value$.toValue(), value$ -> AcceptMI.valueDecoder()
        .decode(value$), value$ ->
        new InviteArbitrators.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Service, SubmitVote, Votation.ContractId> CHOICE_SubmitVote = 
      Choice.create("SubmitVote", value$ -> value$.toValue(), value$ -> SubmitVote.valueDecoder()
        .decode(value$), value$ ->
        new Votation.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Service, rentingPlatform.codegen.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        rentingPlatform.codegen.da.internal.template.Archive.valueDecoder().decode(value$),
        value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, CreateVotation, Votation.ContractId> CHOICE_CreateVotation = 
      Choice.create("CreateVotation", value$ -> value$.toValue(), value$ ->
        CreateVotation.valueDecoder().decode(value$), value$ ->
        new Votation.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Service, FinalizeVotation, MI.ContractId> CHOICE_FinalizeVotation = 
      Choice.create("FinalizeVotation", value$ -> value$.toValue(), value$ ->
        FinalizeVotation.valueDecoder().decode(value$), value$ ->
        new MI.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final ContractCompanion.WithoutKey<Contract, ContractId, Service> COMPANION = 
      new ContractCompanion.WithoutKey<>(
        "rentingPlatform.codegen.platform.leaseagreement.arbitratorsservice.Service", TEMPLATE_ID,
        ContractId::new, v -> Service.templateValueDecoder().decode(v), Service::fromJson,
        Contract::new, List.of(CHOICE_SubmitVote, CHOICE_CreateVotation, CHOICE_FinalizeVotation,
        CHOICE_Archive, CHOICE_AcceptMI));

  public final String operator;

  public final String arbitrator;

  public Service(String operator, String arbitrator) {
    this.operator = operator;
    this.arbitrator = arbitrator;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(Service.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseAcceptMI} instead
   */
  @Deprecated
  public Update<Exercised<InviteArbitrators.ContractId>> createAndExerciseAcceptMI(AcceptMI arg) {
    return createAnd().exerciseAcceptMI(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseAcceptMI} instead
   */
  @Deprecated
  public Update<Exercised<InviteArbitrators.ContractId>> createAndExerciseAcceptMI(
      InviteArbitrators.ContractId inviteArbitratorsCid) {
    return createAndExerciseAcceptMI(new AcceptMI(inviteArbitratorsCid));
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseSubmitVote} instead
   */
  @Deprecated
  public Update<Exercised<Votation.ContractId>> createAndExerciseSubmitVote(SubmitVote arg) {
    return createAnd().exerciseSubmitVote(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseSubmitVote} instead
   */
  @Deprecated
  public Update<Exercised<Votation.ContractId>> createAndExerciseSubmitVote(Responsability vote,
      Votation.ContractId votationCid) {
    return createAndExerciseSubmitVote(new SubmitVote(vote, votationCid));
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
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseCreateVotation} instead
   */
  @Deprecated
  public Update<Exercised<Votation.ContractId>> createAndExerciseCreateVotation(
      CreateVotation arg) {
    return createAnd().exerciseCreateVotation(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseCreateVotation} instead
   */
  @Deprecated
  public Update<Exercised<Votation.ContractId>> createAndExerciseCreateVotation(String description,
      MI.ContractId miCid, AssessmentDetails assessment) {
    return createAndExerciseCreateVotation(new CreateVotation(description, miCid, assessment));
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseFinalizeVotation} instead
   */
  @Deprecated
  public Update<Exercised<MI.ContractId>> createAndExerciseFinalizeVotation(FinalizeVotation arg) {
    return createAnd().exerciseFinalizeVotation(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseFinalizeVotation} instead
   */
  @Deprecated
  public Update<Exercised<MI.ContractId>> createAndExerciseFinalizeVotation(
      Votation.ContractId votationCid) {
    return createAndExerciseFinalizeVotation(new FinalizeVotation(votationCid));
  }

  public static Update<Created<ContractId>> create(String operator, String arbitrator) {
    return new Service(operator, arbitrator).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithoutKey<Contract, ContractId, Service> getCompanion() {
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
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(2);
    fields.add(new DamlRecord.Field("operator", new Party(this.operator)));
    fields.add(new DamlRecord.Field("arbitrator", new Party(this.arbitrator)));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<Service> templateValueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0, recordValue$);
      String operator = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String arbitrator = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      return new Service(operator, arbitrator);
    } ;
  }

  public static JsonLfDecoder<Service> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("operator", "arbitrator"), name -> {
          switch (name) {
            case "operator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "arbitrator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            default: return null;
          }
        }
        , (Object[] args) -> new Service(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static Service fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("operator", apply(JsonLfEncoders::party, operator)),
        JsonLfEncoders.Field.of("arbitrator", apply(JsonLfEncoders::party, arbitrator)));
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
        Objects.equals(this.arbitrator, other.arbitrator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.operator, this.arbitrator);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.leaseagreement.arbitratorsservice.Service(%s, %s)",
        this.operator, this.arbitrator);
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

  public static class Contract extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, Service> {
    public Contract(ContractId id, Service data, Optional<String> agreementText,
        Set<String> signatories, Set<String> observers) {
      super(id, data, agreementText, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, Service> getCompanion() {
      return COMPANION;
    }

    public static Contract fromIdAndRecord(String contractId, DamlRecord record$,
        Optional<String> agreementText, Set<String> signatories, Set<String> observers) {
      return COMPANION.fromIdAndRecord(contractId, record$, agreementText, signatories, observers);
    }

    public static Contract fromCreatedEvent(CreatedEvent event) {
      return COMPANION.fromCreatedEvent(event);
    }
  }

  public interface Exercises<Cmd> extends com.daml.ledger.javaapi.data.codegen.Exercises.Archive<Cmd> {
    default Update<Exercised<InviteArbitrators.ContractId>> exerciseAcceptMI(AcceptMI arg) {
      return makeExerciseCmd(CHOICE_AcceptMI, arg);
    }

    default Update<Exercised<InviteArbitrators.ContractId>> exerciseAcceptMI(
        InviteArbitrators.ContractId inviteArbitratorsCid) {
      return exerciseAcceptMI(new AcceptMI(inviteArbitratorsCid));
    }

    default Update<Exercised<Votation.ContractId>> exerciseSubmitVote(SubmitVote arg) {
      return makeExerciseCmd(CHOICE_SubmitVote, arg);
    }

    default Update<Exercised<Votation.ContractId>> exerciseSubmitVote(Responsability vote,
        Votation.ContractId votationCid) {
      return exerciseSubmitVote(new SubmitVote(vote, votationCid));
    }

    default Update<Exercised<Unit>> exerciseArchive(
        rentingPlatform.codegen.da.internal.template.Archive arg) {
      return makeExerciseCmd(CHOICE_Archive, arg);
    }

    default Update<Exercised<Unit>> exerciseArchive() {
      return exerciseArchive(new rentingPlatform.codegen.da.internal.template.Archive());
    }

    default Update<Exercised<Votation.ContractId>> exerciseCreateVotation(CreateVotation arg) {
      return makeExerciseCmd(CHOICE_CreateVotation, arg);
    }

    default Update<Exercised<Votation.ContractId>> exerciseCreateVotation(String description,
        MI.ContractId miCid, AssessmentDetails assessment) {
      return exerciseCreateVotation(new CreateVotation(description, miCid, assessment));
    }

    default Update<Exercised<MI.ContractId>> exerciseFinalizeVotation(FinalizeVotation arg) {
      return makeExerciseCmd(CHOICE_FinalizeVotation, arg);
    }

    default Update<Exercised<MI.ContractId>> exerciseFinalizeVotation(
        Votation.ContractId votationCid) {
      return exerciseFinalizeVotation(new FinalizeVotation(votationCid));
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
}

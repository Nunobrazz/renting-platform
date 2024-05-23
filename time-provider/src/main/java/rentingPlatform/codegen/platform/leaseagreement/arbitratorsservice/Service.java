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
import rentingPlatform.codegen.da.set.types.Set;
import rentingPlatform.codegen.interface$.types.AssessmentDetails;
import rentingPlatform.codegen.interface$.types.MIkey;
import rentingPlatform.codegen.interface$.types.Responsability;
import rentingPlatform.codegen.platform.leaseagreement.modelmi.MI;
import rentingPlatform.codegen.platform.leaseagreement.modelmi.Votation;

public final class Service extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("0cf664e7a7bad84bfc31440cc4ea2b4c71a9a628dbeb0437bb65cac5ef779e5e", "Platform.LeaseAgreement.ArbitratorsService", "Service");

  public static final Choice<Service, AssignArbitrators, MI.ContractId> CHOICE_AssignArbitrators = 
      Choice.create("AssignArbitrators", value$ -> value$.toValue(), value$ ->
        AssignArbitrators.valueDecoder().decode(value$), value$ ->
        new MI.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Service, AcceptMI, rentingPlatform.codegen.platform.leaseagreement.modelmi.InviteArbitrators.ContractId> CHOICE_AcceptMI = 
      Choice.create("AcceptMI", value$ -> value$.toValue(), value$ -> AcceptMI.valueDecoder()
        .decode(value$), value$ ->
        new rentingPlatform.codegen.platform.leaseagreement.modelmi.InviteArbitrators.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Service, rentingPlatform.codegen.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        rentingPlatform.codegen.da.internal.template.Archive.valueDecoder().decode(value$),
        value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, CreateVotation, Votation.ContractId> CHOICE_CreateVotation = 
      Choice.create("CreateVotation", value$ -> value$.toValue(), value$ ->
        CreateVotation.valueDecoder().decode(value$), value$ ->
        new Votation.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Service, InviteArbitrators, rentingPlatform.codegen.platform.leaseagreement.modelmi.InviteArbitrators.ContractId> CHOICE_InviteArbitrators = 
      Choice.create("InviteArbitrators", value$ -> value$.toValue(), value$ ->
        InviteArbitrators.valueDecoder().decode(value$), value$ ->
        new rentingPlatform.codegen.platform.leaseagreement.modelmi.InviteArbitrators.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Service, SubmitVote, Votation.ContractId> CHOICE_SubmitVote = 
      Choice.create("SubmitVote", value$ -> value$.toValue(), value$ -> SubmitVote.valueDecoder()
        .decode(value$), value$ ->
        new Votation.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Service, FinalizeVotation, MI.ContractId> CHOICE_FinalizeVotation = 
      Choice.create("FinalizeVotation", value$ -> value$.toValue(), value$ ->
        FinalizeVotation.valueDecoder().decode(value$), value$ ->
        new MI.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Service, AddArbitratorToService, ContractId> CHOICE_AddArbitratorToService = 
      Choice.create("AddArbitratorToService", value$ -> value$.toValue(), value$ ->
        AddArbitratorToService.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final ContractCompanion.WithoutKey<Contract, ContractId, Service> COMPANION = 
      new ContractCompanion.WithoutKey<>(
        "rentingPlatform.codegen.platform.leaseagreement.arbitratorsservice.Service", TEMPLATE_ID,
        ContractId::new, v -> Service.templateValueDecoder().decode(v), Service::fromJson,
        Contract::new, List.of(CHOICE_SubmitVote, CHOICE_CreateVotation, CHOICE_InviteArbitrators,
        CHOICE_FinalizeVotation, CHOICE_Archive, CHOICE_AcceptMI, CHOICE_AssignArbitrators,
        CHOICE_AddArbitratorToService));

  public final String operator;

  public final Set<String> arbitrators;

  public Service(String operator, Set<String> arbitrators) {
    this.operator = operator;
    this.arbitrators = arbitrators;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(Service.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseAssignArbitrators} instead
   */
  @Deprecated
  public Update<Exercised<MI.ContractId>> createAndExerciseAssignArbitrators(
      AssignArbitrators arg) {
    return createAnd().exerciseAssignArbitrators(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseAssignArbitrators} instead
   */
  @Deprecated
  public Update<Exercised<MI.ContractId>> createAndExerciseAssignArbitrators(
      rentingPlatform.codegen.platform.leaseagreement.modelmi.InviteArbitrators.ContractId inviteArbitratorsCid) {
    return createAndExerciseAssignArbitrators(new AssignArbitrators(inviteArbitratorsCid));
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseAcceptMI} instead
   */
  @Deprecated
  public Update<Exercised<rentingPlatform.codegen.platform.leaseagreement.modelmi.InviteArbitrators.ContractId>> createAndExerciseAcceptMI(
      AcceptMI arg) {
    return createAnd().exerciseAcceptMI(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseAcceptMI} instead
   */
  @Deprecated
  public Update<Exercised<rentingPlatform.codegen.platform.leaseagreement.modelmi.InviteArbitrators.ContractId>> createAndExerciseAcceptMI(
      rentingPlatform.codegen.platform.leaseagreement.modelmi.InviteArbitrators.ContractId inviteArbitratorsCid,
      String arbitrator) {
    return createAndExerciseAcceptMI(new AcceptMI(inviteArbitratorsCid, arbitrator));
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
  public Update<Exercised<Votation.ContractId>> createAndExerciseCreateVotation(String creator,
      String description, MIkey miKey, AssessmentDetails assessment) {
    return createAndExerciseCreateVotation(new CreateVotation(creator, description, miKey,
        assessment));
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseInviteArbitrators} instead
   */
  @Deprecated
  public Update<Exercised<rentingPlatform.codegen.platform.leaseagreement.modelmi.InviteArbitrators.ContractId>> createAndExerciseInviteArbitrators(
      InviteArbitrators arg) {
    return createAnd().exerciseInviteArbitrators(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseInviteArbitrators} instead
   */
  @Deprecated
  public Update<Exercised<rentingPlatform.codegen.platform.leaseagreement.modelmi.InviteArbitrators.ContractId>> createAndExerciseInviteArbitrators(
      MIkey miKey) {
    return createAndExerciseInviteArbitrators(new InviteArbitrators(miKey));
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
  public Update<Exercised<Votation.ContractId>> createAndExerciseSubmitVote(String voter,
      Responsability vote, Votation.ContractId votationCid) {
    return createAndExerciseSubmitVote(new SubmitVote(voter, vote, votationCid));
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
  public Update<Exercised<MI.ContractId>> createAndExerciseFinalizeVotation(String finalizer,
      Votation.ContractId votationCid) {
    return createAndExerciseFinalizeVotation(new FinalizeVotation(finalizer, votationCid));
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseAddArbitratorToService} instead
   */
  @Deprecated
  public Update<Exercised<ContractId>> createAndExerciseAddArbitratorToService(
      AddArbitratorToService arg) {
    return createAnd().exerciseAddArbitratorToService(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseAddArbitratorToService} instead
   */
  @Deprecated
  public Update<Exercised<ContractId>> createAndExerciseAddArbitratorToService(String arbitrator) {
    return createAndExerciseAddArbitratorToService(new AddArbitratorToService(arbitrator));
  }

  public static Update<Created<ContractId>> create(String operator, Set<String> arbitrators) {
    return new Service(operator, arbitrators).create();
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
    fields.add(new DamlRecord.Field("arbitrators", this.arbitrators.toValue(v$0 -> new Party(v$0))));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<Service> templateValueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0, recordValue$);
      String operator = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      Set<String> arbitrators = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(1).getValue());
      return new Service(operator, arbitrators);
    } ;
  }

  public static JsonLfDecoder<Service> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("operator", "arbitrators"), name -> {
          switch (name) {
            case "operator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "arbitrators": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, rentingPlatform.codegen.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
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
        JsonLfEncoders.Field.of("arbitrators", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), arbitrators)));
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
        Objects.equals(this.arbitrators, other.arbitrators);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.operator, this.arbitrators);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.leaseagreement.arbitratorsservice.Service(%s, %s)",
        this.operator, this.arbitrators);
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
        java.util.Set<String> signatories, java.util.Set<String> observers) {
      super(id, data, agreementText, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, Service> getCompanion() {
      return COMPANION;
    }

    public static Contract fromIdAndRecord(String contractId, DamlRecord record$,
        Optional<String> agreementText, java.util.Set<String> signatories,
        java.util.Set<String> observers) {
      return COMPANION.fromIdAndRecord(contractId, record$, agreementText, signatories, observers);
    }

    public static Contract fromCreatedEvent(CreatedEvent event) {
      return COMPANION.fromCreatedEvent(event);
    }
  }

  public interface Exercises<Cmd> extends com.daml.ledger.javaapi.data.codegen.Exercises.Archive<Cmd> {
    default Update<Exercised<MI.ContractId>> exerciseAssignArbitrators(AssignArbitrators arg) {
      return makeExerciseCmd(CHOICE_AssignArbitrators, arg);
    }

    default Update<Exercised<MI.ContractId>> exerciseAssignArbitrators(
        rentingPlatform.codegen.platform.leaseagreement.modelmi.InviteArbitrators.ContractId inviteArbitratorsCid) {
      return exerciseAssignArbitrators(new AssignArbitrators(inviteArbitratorsCid));
    }

    default Update<Exercised<rentingPlatform.codegen.platform.leaseagreement.modelmi.InviteArbitrators.ContractId>> exerciseAcceptMI(
        AcceptMI arg) {
      return makeExerciseCmd(CHOICE_AcceptMI, arg);
    }

    default Update<Exercised<rentingPlatform.codegen.platform.leaseagreement.modelmi.InviteArbitrators.ContractId>> exerciseAcceptMI(
        rentingPlatform.codegen.platform.leaseagreement.modelmi.InviteArbitrators.ContractId inviteArbitratorsCid,
        String arbitrator) {
      return exerciseAcceptMI(new AcceptMI(inviteArbitratorsCid, arbitrator));
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

    default Update<Exercised<Votation.ContractId>> exerciseCreateVotation(String creator,
        String description, MIkey miKey, AssessmentDetails assessment) {
      return exerciseCreateVotation(new CreateVotation(creator, description, miKey, assessment));
    }

    default Update<Exercised<rentingPlatform.codegen.platform.leaseagreement.modelmi.InviteArbitrators.ContractId>> exerciseInviteArbitrators(
        InviteArbitrators arg) {
      return makeExerciseCmd(CHOICE_InviteArbitrators, arg);
    }

    default Update<Exercised<rentingPlatform.codegen.platform.leaseagreement.modelmi.InviteArbitrators.ContractId>> exerciseInviteArbitrators(
        MIkey miKey) {
      return exerciseInviteArbitrators(new InviteArbitrators(miKey));
    }

    default Update<Exercised<Votation.ContractId>> exerciseSubmitVote(SubmitVote arg) {
      return makeExerciseCmd(CHOICE_SubmitVote, arg);
    }

    default Update<Exercised<Votation.ContractId>> exerciseSubmitVote(String voter,
        Responsability vote, Votation.ContractId votationCid) {
      return exerciseSubmitVote(new SubmitVote(voter, vote, votationCid));
    }

    default Update<Exercised<MI.ContractId>> exerciseFinalizeVotation(FinalizeVotation arg) {
      return makeExerciseCmd(CHOICE_FinalizeVotation, arg);
    }

    default Update<Exercised<MI.ContractId>> exerciseFinalizeVotation(String finalizer,
        Votation.ContractId votationCid) {
      return exerciseFinalizeVotation(new FinalizeVotation(finalizer, votationCid));
    }

    default Update<Exercised<ContractId>> exerciseAddArbitratorToService(
        AddArbitratorToService arg) {
      return makeExerciseCmd(CHOICE_AddArbitratorToService, arg);
    }

    default Update<Exercised<ContractId>> exerciseAddArbitratorToService(String arbitrator) {
      return exerciseAddArbitratorToService(new AddArbitratorToService(arbitrator));
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

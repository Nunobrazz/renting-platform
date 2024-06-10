package rentingPlatform.codegen.platform.leaseagreement.modelmi;

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
import rentingPlatform.codegen.da.set.types.Set;
import rentingPlatform.codegen.da.types.Tuple3;
import rentingPlatform.codegen.platform.types.mi.AssessmentDetails;
import rentingPlatform.codegen.platform.types.mi.MIdetails;

public final class MIReport extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("b1c69ded5e6f9b3209adda4613b08585e35d988f49cc818e5af8942f840887f7", "Platform.LeaseAgreement.ModelMI", "MIReport");

  public static final Choice<MIReport, rentingPlatform.codegen.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        rentingPlatform.codegen.da.internal.template.Archive.valueDecoder().decode(value$),
        value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<MIReport, SetArbitrators, ContractId> CHOICE_SetArbitrators = 
      Choice.create("SetArbitrators", value$ -> value$.toValue(), value$ ->
        SetArbitrators.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<MIReport, CreateVotation, Votation.ContractId> CHOICE_CreateVotation = 
      Choice.create("CreateVotation", value$ -> value$.toValue(), value$ ->
        CreateVotation.valueDecoder().decode(value$), value$ ->
        new Votation.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final ContractCompanion.WithKey<Contract, ContractId, MIReport, Tuple3<String, String, MIdetails>> COMPANION = 
      new ContractCompanion.WithKey<>(
        "rentingPlatform.codegen.platform.leaseagreement.modelmi.MIReport", TEMPLATE_ID,
        ContractId::new, v -> MIReport.templateValueDecoder().decode(v), MIReport::fromJson,
        Contract::new, List.of(CHOICE_Archive, CHOICE_SetArbitrators, CHOICE_CreateVotation),
        e -> Tuple3.<java.lang.String, java.lang.String,
        rentingPlatform.codegen.platform.types.mi.MIdetails>valueDecoder(PrimitiveValueDecoders.fromParty,
        PrimitiveValueDecoders.fromParty, MIdetails.valueDecoder()).decode(e));

  public final String tenant;

  public final String host;

  public final MIdetails miDetails;

  public final Set<String> arbitrators;

  public MIReport(String tenant, String host, MIdetails miDetails, Set<String> arbitrators) {
    this.tenant = tenant;
    this.host = host;
    this.miDetails = miDetails;
    this.arbitrators = arbitrators;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(MIReport.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseArchive} instead
   */
  @Deprecated
  public static Update<Exercised<Unit>> exerciseByKeyArchive(Tuple3<String, String, MIdetails> key,
      rentingPlatform.codegen.da.internal.template.Archive arg) {
    return byKey(key).exerciseArchive(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseArchive()} instead
   */
  @Deprecated
  public static Update<Exercised<Unit>> exerciseByKeyArchive(
      Tuple3<String, String, MIdetails> key) {
    return byKey(key).exerciseArchive();
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseSetArbitrators} instead
   */
  @Deprecated
  public static Update<Exercised<ContractId>> exerciseByKeySetArbitrators(
      Tuple3<String, String, MIdetails> key, SetArbitrators arg) {
    return byKey(key).exerciseSetArbitrators(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseSetArbitrators(inviter,
      arbitrators)} instead
   */
  @Deprecated
  public static Update<Exercised<ContractId>> exerciseByKeySetArbitrators(
      Tuple3<String, String, MIdetails> key, String inviter, Set<String> arbitrators) {
    return byKey(key).exerciseSetArbitrators(inviter, arbitrators);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseCreateVotation} instead
   */
  @Deprecated
  public static Update<Exercised<Votation.ContractId>> exerciseByKeyCreateVotation(
      Tuple3<String, String, MIdetails> key, CreateVotation arg) {
    return byKey(key).exerciseCreateVotation(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseCreateVotation(visitor,
      visitDetails, assessment)} instead
   */
  @Deprecated
  public static Update<Exercised<Votation.ContractId>> exerciseByKeyCreateVotation(
      Tuple3<String, String, MIdetails> key, String visitor, String visitDetails,
      AssessmentDetails assessment) {
    return byKey(key).exerciseCreateVotation(visitor, visitDetails, assessment);
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
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseSetArbitrators} instead
   */
  @Deprecated
  public Update<Exercised<ContractId>> createAndExerciseSetArbitrators(SetArbitrators arg) {
    return createAnd().exerciseSetArbitrators(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseSetArbitrators} instead
   */
  @Deprecated
  public Update<Exercised<ContractId>> createAndExerciseSetArbitrators(String inviter,
      Set<String> arbitrators) {
    return createAndExerciseSetArbitrators(new SetArbitrators(inviter, arbitrators));
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
  public Update<Exercised<Votation.ContractId>> createAndExerciseCreateVotation(String visitor,
      String visitDetails, AssessmentDetails assessment) {
    return createAndExerciseCreateVotation(new CreateVotation(visitor, visitDetails, assessment));
  }

  public static Update<Created<ContractId>> create(String tenant, String host, MIdetails miDetails,
      Set<String> arbitrators) {
    return new MIReport(tenant, host, miDetails, arbitrators).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithKey<Contract, ContractId, MIReport, Tuple3<String, String, MIdetails>> getCompanion(
      ) {
    return COMPANION;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static MIReport fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<MIReport> valueDecoder() throws IllegalArgumentException {
    return ContractCompanion.valueDecoder(COMPANION);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(4);
    fields.add(new DamlRecord.Field("tenant", new Party(this.tenant)));
    fields.add(new DamlRecord.Field("host", new Party(this.host)));
    fields.add(new DamlRecord.Field("miDetails", this.miDetails.toValue()));
    fields.add(new DamlRecord.Field("arbitrators", this.arbitrators.toValue(v$0 -> new Party(v$0))));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<MIReport> templateValueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(4,0, recordValue$);
      String tenant = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String host = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      MIdetails miDetails = MIdetails.valueDecoder().decode(fields$.get(2).getValue());
      Set<String> arbitrators = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(3).getValue());
      return new MIReport(tenant, host, miDetails, arbitrators);
    } ;
  }

  public static JsonLfDecoder<MIReport> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("tenant", "host", "miDetails", "arbitrators"), name -> {
          switch (name) {
            case "tenant": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "host": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "miDetails": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, rentingPlatform.codegen.platform.types.mi.MIdetails.jsonDecoder());
            case "arbitrators": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, rentingPlatform.codegen.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            default: return null;
          }
        }
        , (Object[] args) -> new MIReport(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3])));
  }

  public static MIReport fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("tenant", apply(JsonLfEncoders::party, tenant)),
        JsonLfEncoders.Field.of("host", apply(JsonLfEncoders::party, host)),
        JsonLfEncoders.Field.of("miDetails", apply(MIdetails::jsonEncoder, miDetails)),
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
    if (!(object instanceof MIReport)) {
      return false;
    }
    MIReport other = (MIReport) object;
    return Objects.equals(this.tenant, other.tenant) && Objects.equals(this.host, other.host) &&
        Objects.equals(this.miDetails, other.miDetails) &&
        Objects.equals(this.arbitrators, other.arbitrators);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.tenant, this.host, this.miDetails, this.arbitrators);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.leaseagreement.modelmi.MIReport(%s, %s, %s, %s)",
        this.tenant, this.host, this.miDetails, this.arbitrators);
  }

  /**
   * Set up an {@link ExerciseByKeyCommand}; invoke an {@code exercise} method on the result of
      this to finish creating the command, or convert to an interface first with {@code toInterface}
      to invoke an interface {@code exercise} method.
   */
  public static ByKey byKey(Tuple3<String, String, MIdetails> key) {
    return new ByKey(key.toValue(v$0 -> new Party(v$0), v$1 -> new Party(v$1),
        v$2 -> v$2.toValue()));
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<MIReport> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, MIReport, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public static ContractId fromContractId(
        com.daml.ledger.javaapi.data.codegen.ContractId<MIReport> contractId) {
      return COMPANION.toContractId(contractId);
    }
  }

  public static class Contract extends ContractWithKey<ContractId, MIReport, Tuple3<String, String, MIdetails>> {
    public Contract(ContractId id, MIReport data, Optional<String> agreementText,
        Optional<Tuple3<String, String, MIdetails>> key, java.util.Set<String> signatories,
        java.util.Set<String> observers) {
      super(id, data, agreementText, key, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, MIReport> getCompanion() {
      return COMPANION;
    }

    public static Contract fromIdAndRecord(String contractId, DamlRecord record$,
        Optional<String> agreementText, Optional<Tuple3<String, String, MIdetails>> key,
        java.util.Set<String> signatories, java.util.Set<String> observers) {
      return COMPANION.fromIdAndRecord(contractId, record$, agreementText, key, signatories,
          observers);
    }

    public static Contract fromCreatedEvent(CreatedEvent event) {
      return COMPANION.fromCreatedEvent(event);
    }
  }

  public interface Exercises<Cmd> extends com.daml.ledger.javaapi.data.codegen.Exercises.Archive<Cmd> {
    default Update<Exercised<Unit>> exerciseArchive(
        rentingPlatform.codegen.da.internal.template.Archive arg) {
      return makeExerciseCmd(CHOICE_Archive, arg);
    }

    default Update<Exercised<Unit>> exerciseArchive() {
      return exerciseArchive(new rentingPlatform.codegen.da.internal.template.Archive());
    }

    default Update<Exercised<ContractId>> exerciseSetArbitrators(SetArbitrators arg) {
      return makeExerciseCmd(CHOICE_SetArbitrators, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetArbitrators(String inviter,
        Set<String> arbitrators) {
      return exerciseSetArbitrators(new SetArbitrators(inviter, arbitrators));
    }

    default Update<Exercised<Votation.ContractId>> exerciseCreateVotation(CreateVotation arg) {
      return makeExerciseCmd(CHOICE_CreateVotation, arg);
    }

    default Update<Exercised<Votation.ContractId>> exerciseCreateVotation(String visitor,
        String visitDetails, AssessmentDetails assessment) {
      return exerciseCreateVotation(new CreateVotation(visitor, visitDetails, assessment));
    }
  }

  public static final class CreateAnd extends com.daml.ledger.javaapi.data.codegen.CreateAnd implements Exercises<CreateAndExerciseCommand> {
    CreateAnd(Template createArguments) {
      super(createArguments);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, MIReport, ?> getCompanion(
        ) {
      return COMPANION;
    }
  }

  public static final class ByKey extends com.daml.ledger.javaapi.data.codegen.ByKey implements Exercises<ExerciseByKeyCommand> {
    ByKey(Value key) {
      super(key);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, MIReport, ?> getCompanion(
        ) {
      return COMPANION;
    }
  }
}

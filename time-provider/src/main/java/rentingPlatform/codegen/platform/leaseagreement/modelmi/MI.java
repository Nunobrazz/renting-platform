package rentingPlatform.codegen.platform.leaseagreement.modelmi;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.ContractFilter;
import com.daml.ledger.javaapi.data.CreateAndExerciseCommand;
import com.daml.ledger.javaapi.data.CreateCommand;
import com.daml.ledger.javaapi.data.CreatedEvent;
import com.daml.ledger.javaapi.data.DamlOptional;
import com.daml.ledger.javaapi.data.DamlRecord;
import com.daml.ledger.javaapi.data.ExerciseByKeyCommand;
import com.daml.ledger.javaapi.data.ExerciseCommand;
import com.daml.ledger.javaapi.data.Identifier;
import com.daml.ledger.javaapi.data.Int64;
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
import java.lang.Long;
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
import rentingPlatform.codegen.interface$.types.Breakdown;
import rentingPlatform.codegen.interface$.types.House;
import rentingPlatform.codegen.interface$.types.MIkey;

public final class MI extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("bb7737a3fae0dab3c7cecc1b5d7d0840ffd1957d4501f41845dbecbd2bcf97c3", "Platform.LeaseAgreement.ModelMI", "MI");

  public static final Choice<MI, SetArbitrators, ContractId> CHOICE_SetArbitrators = 
      Choice.create("SetArbitrators", value$ -> value$.toValue(), value$ ->
        SetArbitrators.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<MI, SetAssessment, ContractId> CHOICE_SetAssessment = 
      Choice.create("SetAssessment", value$ -> value$.toValue(), value$ ->
        SetAssessment.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<MI, rentingPlatform.codegen.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        rentingPlatform.codegen.da.internal.template.Archive.valueDecoder().decode(value$),
        value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final ContractCompanion.WithKey<Contract, ContractId, MI, MIkey> COMPANION = 
      new ContractCompanion.WithKey<>("rentingPlatform.codegen.platform.leaseagreement.modelmi.MI",
        TEMPLATE_ID, ContractId::new, v -> MI.templateValueDecoder().decode(v), MI::fromJson,
        Contract::new, List.of(CHOICE_SetArbitrators, CHOICE_SetAssessment, CHOICE_Archive),
        e -> MIkey.valueDecoder().decode(e));

  public final String operator;

  public final String reporter;

  public final String counterpart;

  public final Set<String> arbitrators;

  public final Long nArbitrators;

  public final House house;

  public final Breakdown breakdown;

  public final Optional<AssessmentDetails> assessment;

  public MI(String operator, String reporter, String counterpart, Set<String> arbitrators,
      Long nArbitrators, House house, Breakdown breakdown, Optional<AssessmentDetails> assessment) {
    this.operator = operator;
    this.reporter = reporter;
    this.counterpart = counterpart;
    this.arbitrators = arbitrators;
    this.nArbitrators = nArbitrators;
    this.house = house;
    this.breakdown = breakdown;
    this.assessment = assessment;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(MI.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseSetArbitrators} instead
   */
  @Deprecated
  public static Update<Exercised<ContractId>> exerciseByKeySetArbitrators(MIkey key,
      SetArbitrators arg) {
    return byKey(key).exerciseSetArbitrators(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseSetArbitrators(arbitrators)} instead
   */
  @Deprecated
  public static Update<Exercised<ContractId>> exerciseByKeySetArbitrators(MIkey key,
      Set<String> arbitrators) {
    return byKey(key).exerciseSetArbitrators(arbitrators);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseSetAssessment} instead
   */
  @Deprecated
  public static Update<Exercised<ContractId>> exerciseByKeySetAssessment(MIkey key,
      SetAssessment arg) {
    return byKey(key).exerciseSetAssessment(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseSetAssessment(arbitrator,
      assessment)} instead
   */
  @Deprecated
  public static Update<Exercised<ContractId>> exerciseByKeySetAssessment(MIkey key,
      String arbitrator, AssessmentDetails assessment) {
    return byKey(key).exerciseSetAssessment(arbitrator, assessment);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseArchive} instead
   */
  @Deprecated
  public static Update<Exercised<Unit>> exerciseByKeyArchive(MIkey key,
      rentingPlatform.codegen.da.internal.template.Archive arg) {
    return byKey(key).exerciseArchive(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseArchive()} instead
   */
  @Deprecated
  public static Update<Exercised<Unit>> exerciseByKeyArchive(MIkey key) {
    return byKey(key).exerciseArchive();
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
  public Update<Exercised<ContractId>> createAndExerciseSetArbitrators(Set<String> arbitrators) {
    return createAndExerciseSetArbitrators(new SetArbitrators(arbitrators));
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseSetAssessment} instead
   */
  @Deprecated
  public Update<Exercised<ContractId>> createAndExerciseSetAssessment(SetAssessment arg) {
    return createAnd().exerciseSetAssessment(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseSetAssessment} instead
   */
  @Deprecated
  public Update<Exercised<ContractId>> createAndExerciseSetAssessment(String arbitrator,
      AssessmentDetails assessment) {
    return createAndExerciseSetAssessment(new SetAssessment(arbitrator, assessment));
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

  public static Update<Created<ContractId>> create(String operator, String reporter,
      String counterpart, Set<String> arbitrators, Long nArbitrators, House house,
      Breakdown breakdown, Optional<AssessmentDetails> assessment) {
    return new MI(operator, reporter, counterpart, arbitrators, nArbitrators, house, breakdown,
        assessment).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithKey<Contract, ContractId, MI, MIkey> getCompanion() {
    return COMPANION;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static MI fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<MI> valueDecoder() throws IllegalArgumentException {
    return ContractCompanion.valueDecoder(COMPANION);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(8);
    fields.add(new DamlRecord.Field("operator", new Party(this.operator)));
    fields.add(new DamlRecord.Field("reporter", new Party(this.reporter)));
    fields.add(new DamlRecord.Field("counterpart", new Party(this.counterpart)));
    fields.add(new DamlRecord.Field("arbitrators", this.arbitrators.toValue(v$0 -> new Party(v$0))));
    fields.add(new DamlRecord.Field("nArbitrators", new Int64(this.nArbitrators)));
    fields.add(new DamlRecord.Field("house", this.house.toValue()));
    fields.add(new DamlRecord.Field("breakdown", this.breakdown.toValue()));
    fields.add(new DamlRecord.Field("assessment", DamlOptional.of(this.assessment.map(v$0 -> v$0.toValue()))));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<MI> templateValueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(8,1, recordValue$);
      String operator = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String reporter = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      String counterpart = PrimitiveValueDecoders.fromParty.decode(fields$.get(2).getValue());
      Set<String> arbitrators = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(3).getValue());
      Long nArbitrators = PrimitiveValueDecoders.fromInt64.decode(fields$.get(4).getValue());
      House house = House.valueDecoder().decode(fields$.get(5).getValue());
      Breakdown breakdown = Breakdown.valueDecoder().decode(fields$.get(6).getValue());
      Optional<AssessmentDetails> assessment = PrimitiveValueDecoders.fromOptional(
            AssessmentDetails.valueDecoder()).decode(fields$.get(7).getValue());
      return new MI(operator, reporter, counterpart, arbitrators, nArbitrators, house, breakdown,
          assessment);
    } ;
  }

  public static JsonLfDecoder<MI> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("operator", "reporter", "counterpart", "arbitrators", "nArbitrators", "house", "breakdown", "assessment"), name -> {
          switch (name) {
            case "operator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "reporter": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "counterpart": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "arbitrators": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, rentingPlatform.codegen.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "nArbitrators": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "house": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, rentingPlatform.codegen.interface$.types.House.jsonDecoder());
            case "breakdown": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(6, rentingPlatform.codegen.interface$.types.Breakdown.jsonDecoder());
            case "assessment": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(7, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.optional(rentingPlatform.codegen.interface$.types.AssessmentDetails.jsonDecoder()));
            default: return null;
          }
        }
        , (Object[] args) -> new MI(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5]), JsonLfDecoders.cast(args[6]), JsonLfDecoders.cast(args[7])));
  }

  public static MI fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("operator", apply(JsonLfEncoders::party, operator)),
        JsonLfEncoders.Field.of("reporter", apply(JsonLfEncoders::party, reporter)),
        JsonLfEncoders.Field.of("counterpart", apply(JsonLfEncoders::party, counterpart)),
        JsonLfEncoders.Field.of("arbitrators", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), arbitrators)),
        JsonLfEncoders.Field.of("nArbitrators", apply(JsonLfEncoders::int64, nArbitrators)),
        JsonLfEncoders.Field.of("house", apply(House::jsonEncoder, house)),
        JsonLfEncoders.Field.of("breakdown", apply(Breakdown::jsonEncoder, breakdown)),
        JsonLfEncoders.Field.of("assessment", apply(JsonLfEncoders.optional(AssessmentDetails::jsonEncoder), assessment)));
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
    if (!(object instanceof MI)) {
      return false;
    }
    MI other = (MI) object;
    return Objects.equals(this.operator, other.operator) &&
        Objects.equals(this.reporter, other.reporter) &&
        Objects.equals(this.counterpart, other.counterpart) &&
        Objects.equals(this.arbitrators, other.arbitrators) &&
        Objects.equals(this.nArbitrators, other.nArbitrators) &&
        Objects.equals(this.house, other.house) &&
        Objects.equals(this.breakdown, other.breakdown) &&
        Objects.equals(this.assessment, other.assessment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.operator, this.reporter, this.counterpart, this.arbitrators,
        this.nArbitrators, this.house, this.breakdown, this.assessment);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.leaseagreement.modelmi.MI(%s, %s, %s, %s, %s, %s, %s, %s)",
        this.operator, this.reporter, this.counterpart, this.arbitrators, this.nArbitrators,
        this.house, this.breakdown, this.assessment);
  }

  /**
   * Set up an {@link ExerciseByKeyCommand}; invoke an {@code exercise} method on the result of
      this to finish creating the command, or convert to an interface first with {@code toInterface}
      to invoke an interface {@code exercise} method.
   */
  public static ByKey byKey(MIkey key) {
    return new ByKey(key.toValue());
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<MI> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, MI, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public static ContractId fromContractId(
        com.daml.ledger.javaapi.data.codegen.ContractId<MI> contractId) {
      return COMPANION.toContractId(contractId);
    }
  }

  public static class Contract extends ContractWithKey<ContractId, MI, MIkey> {
    public Contract(ContractId id, MI data, Optional<String> agreementText, Optional<MIkey> key,
        java.util.Set<String> signatories, java.util.Set<String> observers) {
      super(id, data, agreementText, key, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, MI> getCompanion() {
      return COMPANION;
    }

    public static Contract fromIdAndRecord(String contractId, DamlRecord record$,
        Optional<String> agreementText, Optional<MIkey> key, java.util.Set<String> signatories,
        java.util.Set<String> observers) {
      return COMPANION.fromIdAndRecord(contractId, record$, agreementText, key, signatories,
          observers);
    }

    public static Contract fromCreatedEvent(CreatedEvent event) {
      return COMPANION.fromCreatedEvent(event);
    }
  }

  public interface Exercises<Cmd> extends com.daml.ledger.javaapi.data.codegen.Exercises.Archive<Cmd> {
    default Update<Exercised<ContractId>> exerciseSetArbitrators(SetArbitrators arg) {
      return makeExerciseCmd(CHOICE_SetArbitrators, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetArbitrators(Set<String> arbitrators) {
      return exerciseSetArbitrators(new SetArbitrators(arbitrators));
    }

    default Update<Exercised<ContractId>> exerciseSetAssessment(SetAssessment arg) {
      return makeExerciseCmd(CHOICE_SetAssessment, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetAssessment(String arbitrator,
        AssessmentDetails assessment) {
      return exerciseSetAssessment(new SetAssessment(arbitrator, assessment));
    }

    default Update<Exercised<Unit>> exerciseArchive(
        rentingPlatform.codegen.da.internal.template.Archive arg) {
      return makeExerciseCmd(CHOICE_Archive, arg);
    }

    default Update<Exercised<Unit>> exerciseArchive() {
      return exerciseArchive(new rentingPlatform.codegen.da.internal.template.Archive());
    }
  }

  public static final class CreateAnd extends com.daml.ledger.javaapi.data.codegen.CreateAnd implements Exercises<CreateAndExerciseCommand> {
    CreateAnd(Template createArguments) {
      super(createArguments);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, MI, ?> getCompanion(
        ) {
      return COMPANION;
    }
  }

  public static final class ByKey extends com.daml.ledger.javaapi.data.codegen.ByKey implements Exercises<ExerciseByKeyCommand> {
    ByKey(Value key) {
      super(key);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, MI, ?> getCompanion(
        ) {
      return COMPANION;
    }
  }
}

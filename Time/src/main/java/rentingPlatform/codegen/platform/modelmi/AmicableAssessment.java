package rentingPlatform.codegen.platform.modelmi;

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
import rentingPlatform.codegen.platform.types.mi.AssessmentDetails;
import rentingPlatform.codegen.platform.types.mi.MIdetails;

public final class AmicableAssessment extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("bef0965dc38d518ab3f749ea7cce7cf9cd13acb7b593b5f936707edcb2f1eff5", "Platform.ModelMI", "AmicableAssessment");

  public static final Choice<AmicableAssessment, SignAssessment, MIresultAmicable.ContractId> CHOICE_SignAssessment = 
      Choice.create("SignAssessment", value$ -> value$.toValue(), value$ ->
        SignAssessment.valueDecoder().decode(value$), value$ ->
        new MIresultAmicable.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<AmicableAssessment, Reject, Unit> CHOICE_Reject = 
      Choice.create("Reject", value$ -> value$.toValue(), value$ -> Reject.valueDecoder()
        .decode(value$), value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<AmicableAssessment, rentingPlatform.codegen.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        rentingPlatform.codegen.da.internal.template.Archive.valueDecoder().decode(value$),
        value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final ContractCompanion.WithoutKey<Contract, ContractId, AmicableAssessment> COMPANION = 
      new ContractCompanion.WithoutKey<>(
        "rentingPlatform.codegen.platform.modelmi.AmicableAssessment", TEMPLATE_ID, ContractId::new,
        v -> AmicableAssessment.templateValueDecoder().decode(v), AmicableAssessment::fromJson,
        Contract::new, List.of(CHOICE_SignAssessment, CHOICE_Reject, CHOICE_Archive));

  public final String creator;

  public final String counterpart;

  public final AssessmentDetails assessment;

  public final MIdetails miDetails;

  public AmicableAssessment(String creator, String counterpart, AssessmentDetails assessment,
      MIdetails miDetails) {
    this.creator = creator;
    this.counterpart = counterpart;
    this.assessment = assessment;
    this.miDetails = miDetails;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(AmicableAssessment.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseSignAssessment} instead
   */
  @Deprecated
  public Update<Exercised<MIresultAmicable.ContractId>> createAndExerciseSignAssessment(
      SignAssessment arg) {
    return createAnd().exerciseSignAssessment(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseSignAssessment} instead
   */
  @Deprecated
  public Update<Exercised<MIresultAmicable.ContractId>> createAndExerciseSignAssessment() {
    return createAndExerciseSignAssessment(new SignAssessment());
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseReject} instead
   */
  @Deprecated
  public Update<Exercised<Unit>> createAndExerciseReject(Reject arg) {
    return createAnd().exerciseReject(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseReject} instead
   */
  @Deprecated
  public Update<Exercised<Unit>> createAndExerciseReject() {
    return createAndExerciseReject(new Reject());
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

  public static Update<Created<ContractId>> create(String creator, String counterpart,
      AssessmentDetails assessment, MIdetails miDetails) {
    return new AmicableAssessment(creator, counterpart, assessment, miDetails).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithoutKey<Contract, ContractId, AmicableAssessment> getCompanion() {
    return COMPANION;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static AmicableAssessment fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<AmicableAssessment> valueDecoder() throws IllegalArgumentException {
    return ContractCompanion.valueDecoder(COMPANION);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(4);
    fields.add(new DamlRecord.Field("creator", new Party(this.creator)));
    fields.add(new DamlRecord.Field("counterpart", new Party(this.counterpart)));
    fields.add(new DamlRecord.Field("assessment", this.assessment.toValue()));
    fields.add(new DamlRecord.Field("miDetails", this.miDetails.toValue()));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<AmicableAssessment> templateValueDecoder() throws
      IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(4,0, recordValue$);
      String creator = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String counterpart = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      AssessmentDetails assessment = AssessmentDetails.valueDecoder()
          .decode(fields$.get(2).getValue());
      MIdetails miDetails = MIdetails.valueDecoder().decode(fields$.get(3).getValue());
      return new AmicableAssessment(creator, counterpart, assessment, miDetails);
    } ;
  }

  public static JsonLfDecoder<AmicableAssessment> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("creator", "counterpart", "assessment", "miDetails"), name -> {
          switch (name) {
            case "creator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "counterpart": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "assessment": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, rentingPlatform.codegen.platform.types.mi.AssessmentDetails.jsonDecoder());
            case "miDetails": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, rentingPlatform.codegen.platform.types.mi.MIdetails.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new AmicableAssessment(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3])));
  }

  public static AmicableAssessment fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("creator", apply(JsonLfEncoders::party, creator)),
        JsonLfEncoders.Field.of("counterpart", apply(JsonLfEncoders::party, counterpart)),
        JsonLfEncoders.Field.of("assessment", apply(AssessmentDetails::jsonEncoder, assessment)),
        JsonLfEncoders.Field.of("miDetails", apply(MIdetails::jsonEncoder, miDetails)));
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
    if (!(object instanceof AmicableAssessment)) {
      return false;
    }
    AmicableAssessment other = (AmicableAssessment) object;
    return Objects.equals(this.creator, other.creator) &&
        Objects.equals(this.counterpart, other.counterpart) &&
        Objects.equals(this.assessment, other.assessment) &&
        Objects.equals(this.miDetails, other.miDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.creator, this.counterpart, this.assessment, this.miDetails);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.modelmi.AmicableAssessment(%s, %s, %s, %s)",
        this.creator, this.counterpart, this.assessment, this.miDetails);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<AmicableAssessment> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, AmicableAssessment, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public static ContractId fromContractId(
        com.daml.ledger.javaapi.data.codegen.ContractId<AmicableAssessment> contractId) {
      return COMPANION.toContractId(contractId);
    }
  }

  public static class Contract extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, AmicableAssessment> {
    public Contract(ContractId id, AmicableAssessment data, Optional<String> agreementText,
        Set<String> signatories, Set<String> observers) {
      super(id, data, agreementText, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, AmicableAssessment> getCompanion() {
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
    default Update<Exercised<MIresultAmicable.ContractId>> exerciseSignAssessment(
        SignAssessment arg) {
      return makeExerciseCmd(CHOICE_SignAssessment, arg);
    }

    default Update<Exercised<MIresultAmicable.ContractId>> exerciseSignAssessment() {
      return exerciseSignAssessment(new SignAssessment());
    }

    default Update<Exercised<Unit>> exerciseReject(Reject arg) {
      return makeExerciseCmd(CHOICE_Reject, arg);
    }

    default Update<Exercised<Unit>> exerciseReject() {
      return exerciseReject(new Reject());
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
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, AmicableAssessment, ?> getCompanion(
        ) {
      return COMPANION;
    }
  }
}

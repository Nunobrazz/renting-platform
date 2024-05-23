package rentingPlatform.codegen.platform.leaseagreement.modelmi;

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

public final class Assessment extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("0cf664e7a7bad84bfc31440cc4ea2b4c71a9a628dbeb0437bb65cac5ef779e5e", "Platform.LeaseAgreement.ModelMI", "Assessment");

  public static final Choice<Assessment, Sign, ContractId> CHOICE_Sign = 
      Choice.create("Sign", value$ -> value$.toValue(), value$ -> Sign.valueDecoder()
        .decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Assessment, FinalizeAssessment, MI.ContractId> CHOICE_FinalizeAssessment = 
      Choice.create("FinalizeAssessment", value$ -> value$.toValue(), value$ ->
        FinalizeAssessment.valueDecoder().decode(value$), value$ ->
        new MI.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Assessment, rentingPlatform.codegen.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        rentingPlatform.codegen.da.internal.template.Archive.valueDecoder().decode(value$),
        value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final ContractCompanion.WithoutKey<Contract, ContractId, Assessment> COMPANION = 
      new ContractCompanion.WithoutKey<>(
        "rentingPlatform.codegen.platform.leaseagreement.modelmi.Assessment", TEMPLATE_ID,
        ContractId::new, v -> Assessment.templateValueDecoder().decode(v), Assessment::fromJson,
        Contract::new, List.of(CHOICE_Sign, CHOICE_FinalizeAssessment, CHOICE_Archive));

  public final Set<String> approvers;

  public final AssessmentDetails assessmentDetails;

  public final MIkey miKey;

  public final Set<String> alreadySigned;

  public Assessment(Set<String> approvers, AssessmentDetails assessmentDetails, MIkey miKey,
      Set<String> alreadySigned) {
    this.approvers = approvers;
    this.assessmentDetails = assessmentDetails;
    this.miKey = miKey;
    this.alreadySigned = alreadySigned;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(Assessment.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseSign} instead
   */
  @Deprecated
  public Update<Exercised<ContractId>> createAndExerciseSign(Sign arg) {
    return createAnd().exerciseSign(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseSign} instead
   */
  @Deprecated
  public Update<Exercised<ContractId>> createAndExerciseSign(String signer) {
    return createAndExerciseSign(new Sign(signer));
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseFinalizeAssessment} instead
   */
  @Deprecated
  public Update<Exercised<MI.ContractId>> createAndExerciseFinalizeAssessment(
      FinalizeAssessment arg) {
    return createAnd().exerciseFinalizeAssessment(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseFinalizeAssessment} instead
   */
  @Deprecated
  public Update<Exercised<MI.ContractId>> createAndExerciseFinalizeAssessment(String finalizer) {
    return createAndExerciseFinalizeAssessment(new FinalizeAssessment(finalizer));
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

  public static Update<Created<ContractId>> create(Set<String> approvers,
      AssessmentDetails assessmentDetails, MIkey miKey, Set<String> alreadySigned) {
    return new Assessment(approvers, assessmentDetails, miKey, alreadySigned).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithoutKey<Contract, ContractId, Assessment> getCompanion() {
    return COMPANION;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Assessment fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Assessment> valueDecoder() throws IllegalArgumentException {
    return ContractCompanion.valueDecoder(COMPANION);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(4);
    fields.add(new DamlRecord.Field("approvers", this.approvers.toValue(v$0 -> new Party(v$0))));
    fields.add(new DamlRecord.Field("assessmentDetails", this.assessmentDetails.toValue()));
    fields.add(new DamlRecord.Field("miKey", this.miKey.toValue()));
    fields.add(new DamlRecord.Field("alreadySigned", this.alreadySigned.toValue(v$0 -> new Party(v$0))));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<Assessment> templateValueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(4,0, recordValue$);
      Set<String> approvers = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(0).getValue());
      AssessmentDetails assessmentDetails = AssessmentDetails.valueDecoder()
          .decode(fields$.get(1).getValue());
      MIkey miKey = MIkey.valueDecoder().decode(fields$.get(2).getValue());
      Set<String> alreadySigned =
          Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(3).getValue());
      return new Assessment(approvers, assessmentDetails, miKey, alreadySigned);
    } ;
  }

  public static JsonLfDecoder<Assessment> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("approvers", "assessmentDetails", "miKey", "alreadySigned"), name -> {
          switch (name) {
            case "approvers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, rentingPlatform.codegen.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "assessmentDetails": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, rentingPlatform.codegen.interface$.types.AssessmentDetails.jsonDecoder());
            case "miKey": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, rentingPlatform.codegen.interface$.types.MIkey.jsonDecoder());
            case "alreadySigned": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, rentingPlatform.codegen.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            default: return null;
          }
        }
        , (Object[] args) -> new Assessment(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3])));
  }

  public static Assessment fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("approvers", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), approvers)),
        JsonLfEncoders.Field.of("assessmentDetails", apply(AssessmentDetails::jsonEncoder, assessmentDetails)),
        JsonLfEncoders.Field.of("miKey", apply(MIkey::jsonEncoder, miKey)),
        JsonLfEncoders.Field.of("alreadySigned", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), alreadySigned)));
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
    if (!(object instanceof Assessment)) {
      return false;
    }
    Assessment other = (Assessment) object;
    return Objects.equals(this.approvers, other.approvers) &&
        Objects.equals(this.assessmentDetails, other.assessmentDetails) &&
        Objects.equals(this.miKey, other.miKey) &&
        Objects.equals(this.alreadySigned, other.alreadySigned);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.approvers, this.assessmentDetails, this.miKey, this.alreadySigned);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.leaseagreement.modelmi.Assessment(%s, %s, %s, %s)",
        this.approvers, this.assessmentDetails, this.miKey, this.alreadySigned);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<Assessment> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Assessment, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public static ContractId fromContractId(
        com.daml.ledger.javaapi.data.codegen.ContractId<Assessment> contractId) {
      return COMPANION.toContractId(contractId);
    }
  }

  public static class Contract extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, Assessment> {
    public Contract(ContractId id, Assessment data, Optional<String> agreementText,
        java.util.Set<String> signatories, java.util.Set<String> observers) {
      super(id, data, agreementText, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, Assessment> getCompanion() {
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
    default Update<Exercised<ContractId>> exerciseSign(Sign arg) {
      return makeExerciseCmd(CHOICE_Sign, arg);
    }

    default Update<Exercised<ContractId>> exerciseSign(String signer) {
      return exerciseSign(new Sign(signer));
    }

    default Update<Exercised<MI.ContractId>> exerciseFinalizeAssessment(FinalizeAssessment arg) {
      return makeExerciseCmd(CHOICE_FinalizeAssessment, arg);
    }

    default Update<Exercised<MI.ContractId>> exerciseFinalizeAssessment(String finalizer) {
      return exerciseFinalizeAssessment(new FinalizeAssessment(finalizer));
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
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Assessment, ?> getCompanion(
        ) {
      return COMPANION;
    }
  }
}

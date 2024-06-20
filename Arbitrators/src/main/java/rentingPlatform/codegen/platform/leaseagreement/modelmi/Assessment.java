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
import java.util.Set;
import rentingPlatform.codegen.platform.types.mi.AssessmentDetails;
import rentingPlatform.codegen.platform.types.mi.MIdetails;

public final class Assessment extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("08537584ed7a5356973a2deba7db786c7576354638ad57dfcafbaad6c1c125a5", "Platform.LeaseAgreement.ModelMI", "Assessment");

  public static final Choice<Assessment, rentingPlatform.codegen.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        rentingPlatform.codegen.da.internal.template.Archive.valueDecoder().decode(value$),
        value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Assessment, SignAssessment, MIresultFriendly.ContractId> CHOICE_SignAssessment = 
      Choice.create("SignAssessment", value$ -> value$.toValue(), value$ ->
        SignAssessment.valueDecoder().decode(value$), value$ ->
        new MIresultFriendly.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final ContractCompanion.WithoutKey<Contract, ContractId, Assessment> COMPANION = 
      new ContractCompanion.WithoutKey<>(
        "rentingPlatform.codegen.platform.leaseagreement.modelmi.Assessment", TEMPLATE_ID,
        ContractId::new, v -> Assessment.templateValueDecoder().decode(v), Assessment::fromJson,
        Contract::new, List.of(CHOICE_Archive, CHOICE_SignAssessment));

  public final String creator;

  public final String signer;

  public final AssessmentDetails assessment;

  public final MIdetails miDetails;

  public final MIReport.ContractId miReportCid;

  public Assessment(String creator, String signer, AssessmentDetails assessment,
      MIdetails miDetails, MIReport.ContractId miReportCid) {
    this.creator = creator;
    this.signer = signer;
    this.assessment = assessment;
    this.miDetails = miDetails;
    this.miReportCid = miReportCid;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(Assessment.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
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
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseSignAssessment} instead
   */
  @Deprecated
  public Update<Exercised<MIresultFriendly.ContractId>> createAndExerciseSignAssessment(
      SignAssessment arg) {
    return createAnd().exerciseSignAssessment(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseSignAssessment} instead
   */
  @Deprecated
  public Update<Exercised<MIresultFriendly.ContractId>> createAndExerciseSignAssessment(
      String signer) {
    return createAndExerciseSignAssessment(new SignAssessment(signer));
  }

  public static Update<Created<ContractId>> create(String creator, String signer,
      AssessmentDetails assessment, MIdetails miDetails, MIReport.ContractId miReportCid) {
    return new Assessment(creator, signer, assessment, miDetails, miReportCid).create();
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
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(5);
    fields.add(new DamlRecord.Field("creator", new Party(this.creator)));
    fields.add(new DamlRecord.Field("signer", new Party(this.signer)));
    fields.add(new DamlRecord.Field("assessment", this.assessment.toValue()));
    fields.add(new DamlRecord.Field("miDetails", this.miDetails.toValue()));
    fields.add(new DamlRecord.Field("miReportCid", this.miReportCid.toValue()));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<Assessment> templateValueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(5,0, recordValue$);
      String creator = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String signer = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      AssessmentDetails assessment = AssessmentDetails.valueDecoder()
          .decode(fields$.get(2).getValue());
      MIdetails miDetails = MIdetails.valueDecoder().decode(fields$.get(3).getValue());
      MIReport.ContractId miReportCid =
          new MIReport.ContractId(fields$.get(4).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected miReportCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new Assessment(creator, signer, assessment, miDetails, miReportCid);
    } ;
  }

  public static JsonLfDecoder<Assessment> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("creator", "signer", "assessment", "miDetails", "miReportCid"), name -> {
          switch (name) {
            case "creator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "signer": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "assessment": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, rentingPlatform.codegen.platform.types.mi.AssessmentDetails.jsonDecoder());
            case "miDetails": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, rentingPlatform.codegen.platform.types.mi.MIdetails.jsonDecoder());
            case "miReportCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(rentingPlatform.codegen.platform.leaseagreement.modelmi.MIReport.ContractId::new));
            default: return null;
          }
        }
        , (Object[] args) -> new Assessment(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4])));
  }

  public static Assessment fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("creator", apply(JsonLfEncoders::party, creator)),
        JsonLfEncoders.Field.of("signer", apply(JsonLfEncoders::party, signer)),
        JsonLfEncoders.Field.of("assessment", apply(AssessmentDetails::jsonEncoder, assessment)),
        JsonLfEncoders.Field.of("miDetails", apply(MIdetails::jsonEncoder, miDetails)),
        JsonLfEncoders.Field.of("miReportCid", apply(JsonLfEncoders::contractId, miReportCid)));
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
    return Objects.equals(this.creator, other.creator) &&
        Objects.equals(this.signer, other.signer) &&
        Objects.equals(this.assessment, other.assessment) &&
        Objects.equals(this.miDetails, other.miDetails) &&
        Objects.equals(this.miReportCid, other.miReportCid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.creator, this.signer, this.assessment, this.miDetails,
        this.miReportCid);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.leaseagreement.modelmi.Assessment(%s, %s, %s, %s, %s)",
        this.creator, this.signer, this.assessment, this.miDetails, this.miReportCid);
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
        Set<String> signatories, Set<String> observers) {
      super(id, data, agreementText, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, Assessment> getCompanion() {
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
    default Update<Exercised<Unit>> exerciseArchive(
        rentingPlatform.codegen.da.internal.template.Archive arg) {
      return makeExerciseCmd(CHOICE_Archive, arg);
    }

    default Update<Exercised<Unit>> exerciseArchive() {
      return exerciseArchive(new rentingPlatform.codegen.da.internal.template.Archive());
    }

    default Update<Exercised<MIresultFriendly.ContractId>> exerciseSignAssessment(
        SignAssessment arg) {
      return makeExerciseCmd(CHOICE_SignAssessment, arg);
    }

    default Update<Exercised<MIresultFriendly.ContractId>> exerciseSignAssessment(String signer) {
      return exerciseSignAssessment(new SignAssessment(signer));
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

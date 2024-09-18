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
import com.daml.ledger.javaapi.data.Text;
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
import rentingPlatform.codegen.platform.types.mi.AssessmentDetails;
import rentingPlatform.codegen.platform.types.mi.MIdetails;

public final class MIresultArbitration extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("bef0965dc38d518ab3f749ea7cce7cf9cd13acb7b593b5f936707edcb2f1eff5", "Platform.ModelMI", "MIresultArbitration");

  public static final Choice<MIresultArbitration, rentingPlatform.codegen.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        rentingPlatform.codegen.da.internal.template.Archive.valueDecoder().decode(value$),
        value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final ContractCompanion.WithoutKey<Contract, ContractId, MIresultArbitration> COMPANION = 
      new ContractCompanion.WithoutKey<>(
        "rentingPlatform.codegen.platform.modelmi.MIresultArbitration", TEMPLATE_ID,
        ContractId::new, v -> MIresultArbitration.templateValueDecoder().decode(v),
        MIresultArbitration::fromJson, Contract::new, List.of(CHOICE_Archive));

  public final String tenant;

  public final String host;

  public final MIdetails miDetails;

  public final Set<String> arbitrators;

  public final String visitor;

  public final String visitDetails;

  public final AssessmentDetails assessment;

  public MIresultArbitration(String tenant, String host, MIdetails miDetails,
      Set<String> arbitrators, String visitor, String visitDetails, AssessmentDetails assessment) {
    this.tenant = tenant;
    this.host = host;
    this.miDetails = miDetails;
    this.arbitrators = arbitrators;
    this.visitor = visitor;
    this.visitDetails = visitDetails;
    this.assessment = assessment;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(MIresultArbitration.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
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

  public static Update<Created<ContractId>> create(String tenant, String host, MIdetails miDetails,
      Set<String> arbitrators, String visitor, String visitDetails, AssessmentDetails assessment) {
    return new MIresultArbitration(tenant, host, miDetails, arbitrators, visitor, visitDetails,
        assessment).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithoutKey<Contract, ContractId, MIresultArbitration> getCompanion() {
    return COMPANION;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static MIresultArbitration fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<MIresultArbitration> valueDecoder() throws IllegalArgumentException {
    return ContractCompanion.valueDecoder(COMPANION);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(7);
    fields.add(new DamlRecord.Field("tenant", new Party(this.tenant)));
    fields.add(new DamlRecord.Field("host", new Party(this.host)));
    fields.add(new DamlRecord.Field("miDetails", this.miDetails.toValue()));
    fields.add(new DamlRecord.Field("arbitrators", this.arbitrators.toValue(v$0 -> new Party(v$0))));
    fields.add(new DamlRecord.Field("visitor", new Party(this.visitor)));
    fields.add(new DamlRecord.Field("visitDetails", new Text(this.visitDetails)));
    fields.add(new DamlRecord.Field("assessment", this.assessment.toValue()));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<MIresultArbitration> templateValueDecoder() throws
      IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(7,0, recordValue$);
      String tenant = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String host = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      MIdetails miDetails = MIdetails.valueDecoder().decode(fields$.get(2).getValue());
      Set<String> arbitrators = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(3).getValue());
      String visitor = PrimitiveValueDecoders.fromParty.decode(fields$.get(4).getValue());
      String visitDetails = PrimitiveValueDecoders.fromText.decode(fields$.get(5).getValue());
      AssessmentDetails assessment = AssessmentDetails.valueDecoder()
          .decode(fields$.get(6).getValue());
      return new MIresultArbitration(tenant, host, miDetails, arbitrators, visitor, visitDetails,
          assessment);
    } ;
  }

  public static JsonLfDecoder<MIresultArbitration> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("tenant", "host", "miDetails", "arbitrators", "visitor", "visitDetails", "assessment"), name -> {
          switch (name) {
            case "tenant": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "host": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "miDetails": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, rentingPlatform.codegen.platform.types.mi.MIdetails.jsonDecoder());
            case "arbitrators": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, rentingPlatform.codegen.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "visitor": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "visitDetails": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "assessment": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(6, rentingPlatform.codegen.platform.types.mi.AssessmentDetails.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new MIresultArbitration(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5]), JsonLfDecoders.cast(args[6])));
  }

  public static MIresultArbitration fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("tenant", apply(JsonLfEncoders::party, tenant)),
        JsonLfEncoders.Field.of("host", apply(JsonLfEncoders::party, host)),
        JsonLfEncoders.Field.of("miDetails", apply(MIdetails::jsonEncoder, miDetails)),
        JsonLfEncoders.Field.of("arbitrators", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), arbitrators)),
        JsonLfEncoders.Field.of("visitor", apply(JsonLfEncoders::party, visitor)),
        JsonLfEncoders.Field.of("visitDetails", apply(JsonLfEncoders::text, visitDetails)),
        JsonLfEncoders.Field.of("assessment", apply(AssessmentDetails::jsonEncoder, assessment)));
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
    if (!(object instanceof MIresultArbitration)) {
      return false;
    }
    MIresultArbitration other = (MIresultArbitration) object;
    return Objects.equals(this.tenant, other.tenant) && Objects.equals(this.host, other.host) &&
        Objects.equals(this.miDetails, other.miDetails) &&
        Objects.equals(this.arbitrators, other.arbitrators) &&
        Objects.equals(this.visitor, other.visitor) &&
        Objects.equals(this.visitDetails, other.visitDetails) &&
        Objects.equals(this.assessment, other.assessment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.tenant, this.host, this.miDetails, this.arbitrators, this.visitor,
        this.visitDetails, this.assessment);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.modelmi.MIresultArbitration(%s, %s, %s, %s, %s, %s, %s)",
        this.tenant, this.host, this.miDetails, this.arbitrators, this.visitor, this.visitDetails,
        this.assessment);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<MIresultArbitration> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, MIresultArbitration, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public static ContractId fromContractId(
        com.daml.ledger.javaapi.data.codegen.ContractId<MIresultArbitration> contractId) {
      return COMPANION.toContractId(contractId);
    }
  }

  public static class Contract extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, MIresultArbitration> {
    public Contract(ContractId id, MIresultArbitration data, Optional<String> agreementText,
        java.util.Set<String> signatories, java.util.Set<String> observers) {
      super(id, data, agreementText, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, MIresultArbitration> getCompanion() {
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
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, MIresultArbitration, ?> getCompanion(
        ) {
      return COMPANION;
    }
  }
}

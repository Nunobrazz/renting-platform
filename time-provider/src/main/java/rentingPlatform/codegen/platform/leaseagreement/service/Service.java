package rentingPlatform.codegen.platform.leaseagreement.service;

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
import rentingPlatform.codegen.interface$.types.AssessmentDetails;
import rentingPlatform.codegen.interface$.types.Breakdown;
import rentingPlatform.codegen.interface$.types.LAkey;
import rentingPlatform.codegen.interface$.types.MIkey;
import rentingPlatform.codegen.platform.leaseagreement.modelmi.Assessment;
import rentingPlatform.codegen.platform.leaseagreement.modelmi.MI;

public final class Service extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("0cf664e7a7bad84bfc31440cc4ea2b4c71a9a628dbeb0437bb65cac5ef779e5e", "Platform.LeaseAgreement.Service", "Service");

  public static final Choice<Service, CreateMI, MI.ContractId> CHOICE_CreateMI = 
      Choice.create("CreateMI", value$ -> value$.toValue(), value$ -> CreateMI.valueDecoder()
        .decode(value$), value$ ->
        new MI.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Service, SubmitAssessment, Assessment.ContractId> CHOICE_SubmitAssessment = 
      Choice.create("SubmitAssessment", value$ -> value$.toValue(), value$ ->
        SubmitAssessment.valueDecoder().decode(value$), value$ ->
        new Assessment.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Service, SignAssessment, Assessment.ContractId> CHOICE_SignAssessment = 
      Choice.create("SignAssessment", value$ -> value$.toValue(), value$ ->
        SignAssessment.valueDecoder().decode(value$), value$ ->
        new Assessment.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Service, rentingPlatform.codegen.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        rentingPlatform.codegen.da.internal.template.Archive.valueDecoder().decode(value$),
        value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final ContractCompanion.WithKey<Contract, ContractId, Service, Tuple2<String, String>> COMPANION = 
      new ContractCompanion.WithKey<>(
        "rentingPlatform.codegen.platform.leaseagreement.service.Service", TEMPLATE_ID,
        ContractId::new, v -> Service.templateValueDecoder().decode(v), Service::fromJson,
        Contract::new, List.of(CHOICE_CreateMI, CHOICE_SubmitAssessment, CHOICE_SignAssessment,
        CHOICE_Archive), e -> Tuple2.<java.lang.String,
        java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty,
        PrimitiveValueDecoders.fromParty).decode(e));

  public final String operator;

  public final String host;

  public final String tenant;

  public final LAkey laKey;

  public Service(String operator, String host, String tenant, LAkey laKey) {
    this.operator = operator;
    this.host = host;
    this.tenant = tenant;
    this.laKey = laKey;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(Service.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseCreateMI} instead
   */
  @Deprecated
  public static Update<Exercised<MI.ContractId>> exerciseByKeyCreateMI(Tuple2<String, String> key,
      CreateMI arg) {
    return byKey(key).exerciseCreateMI(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseCreateMI(reporter,
      breakdown)} instead
   */
  @Deprecated
  public static Update<Exercised<MI.ContractId>> exerciseByKeyCreateMI(Tuple2<String, String> key,
      String reporter, Breakdown breakdown) {
    return byKey(key).exerciseCreateMI(reporter, breakdown);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseSubmitAssessment} instead
   */
  @Deprecated
  public static Update<Exercised<Assessment.ContractId>> exerciseByKeySubmitAssessment(
      Tuple2<String, String> key, SubmitAssessment arg) {
    return byKey(key).exerciseSubmitAssessment(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseSubmitAssessment(submitter,
      assessmentDetails, miKey)} instead
   */
  @Deprecated
  public static Update<Exercised<Assessment.ContractId>> exerciseByKeySubmitAssessment(
      Tuple2<String, String> key, String submitter, AssessmentDetails assessmentDetails,
      MIkey miKey) {
    return byKey(key).exerciseSubmitAssessment(submitter, assessmentDetails, miKey);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseSignAssessment} instead
   */
  @Deprecated
  public static Update<Exercised<Assessment.ContractId>> exerciseByKeySignAssessment(
      Tuple2<String, String> key, SignAssessment arg) {
    return byKey(key).exerciseSignAssessment(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseSignAssessment(signer,
      assessmentCid)} instead
   */
  @Deprecated
  public static Update<Exercised<Assessment.ContractId>> exerciseByKeySignAssessment(
      Tuple2<String, String> key, String signer, Assessment.ContractId assessmentCid) {
    return byKey(key).exerciseSignAssessment(signer, assessmentCid);
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
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseCreateMI} instead
   */
  @Deprecated
  public Update<Exercised<MI.ContractId>> createAndExerciseCreateMI(CreateMI arg) {
    return createAnd().exerciseCreateMI(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseCreateMI} instead
   */
  @Deprecated
  public Update<Exercised<MI.ContractId>> createAndExerciseCreateMI(String reporter,
      Breakdown breakdown) {
    return createAndExerciseCreateMI(new CreateMI(reporter, breakdown));
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseSubmitAssessment} instead
   */
  @Deprecated
  public Update<Exercised<Assessment.ContractId>> createAndExerciseSubmitAssessment(
      SubmitAssessment arg) {
    return createAnd().exerciseSubmitAssessment(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseSubmitAssessment} instead
   */
  @Deprecated
  public Update<Exercised<Assessment.ContractId>> createAndExerciseSubmitAssessment(
      String submitter, AssessmentDetails assessmentDetails, MIkey miKey) {
    return createAndExerciseSubmitAssessment(new SubmitAssessment(submitter, assessmentDetails,
        miKey));
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseSignAssessment} instead
   */
  @Deprecated
  public Update<Exercised<Assessment.ContractId>> createAndExerciseSignAssessment(
      SignAssessment arg) {
    return createAnd().exerciseSignAssessment(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseSignAssessment} instead
   */
  @Deprecated
  public Update<Exercised<Assessment.ContractId>> createAndExerciseSignAssessment(String signer,
      Assessment.ContractId assessmentCid) {
    return createAndExerciseSignAssessment(new SignAssessment(signer, assessmentCid));
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

  public static Update<Created<ContractId>> create(String operator, String host, String tenant,
      LAkey laKey) {
    return new Service(operator, host, tenant, laKey).create();
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
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(4);
    fields.add(new DamlRecord.Field("operator", new Party(this.operator)));
    fields.add(new DamlRecord.Field("host", new Party(this.host)));
    fields.add(new DamlRecord.Field("tenant", new Party(this.tenant)));
    fields.add(new DamlRecord.Field("laKey", this.laKey.toValue()));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<Service> templateValueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(4,0, recordValue$);
      String operator = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String host = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      String tenant = PrimitiveValueDecoders.fromParty.decode(fields$.get(2).getValue());
      LAkey laKey = LAkey.valueDecoder().decode(fields$.get(3).getValue());
      return new Service(operator, host, tenant, laKey);
    } ;
  }

  public static JsonLfDecoder<Service> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("operator", "host", "tenant", "laKey"), name -> {
          switch (name) {
            case "operator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "host": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "tenant": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "laKey": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, rentingPlatform.codegen.interface$.types.LAkey.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new Service(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3])));
  }

  public static Service fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("operator", apply(JsonLfEncoders::party, operator)),
        JsonLfEncoders.Field.of("host", apply(JsonLfEncoders::party, host)),
        JsonLfEncoders.Field.of("tenant", apply(JsonLfEncoders::party, tenant)),
        JsonLfEncoders.Field.of("laKey", apply(LAkey::jsonEncoder, laKey)));
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
    return Objects.equals(this.operator, other.operator) && Objects.equals(this.host, other.host) &&
        Objects.equals(this.tenant, other.tenant) && Objects.equals(this.laKey, other.laKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.operator, this.host, this.tenant, this.laKey);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.leaseagreement.service.Service(%s, %s, %s, %s)",
        this.operator, this.host, this.tenant, this.laKey);
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
    default Update<Exercised<MI.ContractId>> exerciseCreateMI(CreateMI arg) {
      return makeExerciseCmd(CHOICE_CreateMI, arg);
    }

    default Update<Exercised<MI.ContractId>> exerciseCreateMI(String reporter,
        Breakdown breakdown) {
      return exerciseCreateMI(new CreateMI(reporter, breakdown));
    }

    default Update<Exercised<Assessment.ContractId>> exerciseSubmitAssessment(
        SubmitAssessment arg) {
      return makeExerciseCmd(CHOICE_SubmitAssessment, arg);
    }

    default Update<Exercised<Assessment.ContractId>> exerciseSubmitAssessment(String submitter,
        AssessmentDetails assessmentDetails, MIkey miKey) {
      return exerciseSubmitAssessment(new SubmitAssessment(submitter, assessmentDetails, miKey));
    }

    default Update<Exercised<Assessment.ContractId>> exerciseSignAssessment(SignAssessment arg) {
      return makeExerciseCmd(CHOICE_SignAssessment, arg);
    }

    default Update<Exercised<Assessment.ContractId>> exerciseSignAssessment(String signer,
        Assessment.ContractId assessmentCid) {
      return exerciseSignAssessment(new SignAssessment(signer, assessmentCid));
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

package rentingPlatform.codegen.platform.proposal;

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
import rentingPlatform.codegen.platform.modella.LeaseAgreement;
import rentingPlatform.codegen.platform.types.common.House;
import rentingPlatform.codegen.platform.types.common.LeaseTerms;

public final class LACreationRequest extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("bef0965dc38d518ab3f749ea7cce7cf9cd13acb7b593b5f936707edcb2f1eff5", "Platform.Proposal", "LACreationRequest");

  public static final Choice<LACreationRequest, Reject, Unit> CHOICE_Reject = 
      Choice.create("Reject", value$ -> value$.toValue(), value$ -> Reject.valueDecoder()
        .decode(value$), value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<LACreationRequest, rentingPlatform.codegen.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        rentingPlatform.codegen.da.internal.template.Archive.valueDecoder().decode(value$),
        value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<LACreationRequest, Approve, LeaseAgreement.ContractId> CHOICE_Approve = 
      Choice.create("Approve", value$ -> value$.toValue(), value$ -> Approve.valueDecoder()
        .decode(value$), value$ ->
        new LeaseAgreement.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final ContractCompanion.WithoutKey<Contract, ContractId, LACreationRequest> COMPANION = 
      new ContractCompanion.WithoutKey<>(
        "rentingPlatform.codegen.platform.proposal.LACreationRequest", TEMPLATE_ID, ContractId::new,
        v -> LACreationRequest.templateValueDecoder().decode(v), LACreationRequest::fromJson,
        Contract::new, List.of(CHOICE_Reject, CHOICE_Archive, CHOICE_Approve));

  public final String operator;

  public final String tenant;

  public final House house;

  public final LeaseTerms leaseTerms;

  public LACreationRequest(String operator, String tenant, House house, LeaseTerms leaseTerms) {
    this.operator = operator;
    this.tenant = tenant;
    this.house = house;
    this.leaseTerms = leaseTerms;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(LACreationRequest.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
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

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseApprove} instead
   */
  @Deprecated
  public Update<Exercised<LeaseAgreement.ContractId>> createAndExerciseApprove(Approve arg) {
    return createAnd().exerciseApprove(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseApprove} instead
   */
  @Deprecated
  public Update<Exercised<LeaseAgreement.ContractId>> createAndExerciseApprove(String evolveId) {
    return createAndExerciseApprove(new Approve(evolveId));
  }

  public static Update<Created<ContractId>> create(String operator, String tenant, House house,
      LeaseTerms leaseTerms) {
    return new LACreationRequest(operator, tenant, house, leaseTerms).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithoutKey<Contract, ContractId, LACreationRequest> getCompanion() {
    return COMPANION;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static LACreationRequest fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<LACreationRequest> valueDecoder() throws IllegalArgumentException {
    return ContractCompanion.valueDecoder(COMPANION);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(4);
    fields.add(new DamlRecord.Field("operator", new Party(this.operator)));
    fields.add(new DamlRecord.Field("tenant", new Party(this.tenant)));
    fields.add(new DamlRecord.Field("house", this.house.toValue()));
    fields.add(new DamlRecord.Field("leaseTerms", this.leaseTerms.toValue()));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<LACreationRequest> templateValueDecoder() throws
      IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(4,0, recordValue$);
      String operator = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String tenant = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      House house = House.valueDecoder().decode(fields$.get(2).getValue());
      LeaseTerms leaseTerms = LeaseTerms.valueDecoder().decode(fields$.get(3).getValue());
      return new LACreationRequest(operator, tenant, house, leaseTerms);
    } ;
  }

  public static JsonLfDecoder<LACreationRequest> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("operator", "tenant", "house", "leaseTerms"), name -> {
          switch (name) {
            case "operator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "tenant": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "house": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, rentingPlatform.codegen.platform.types.common.House.jsonDecoder());
            case "leaseTerms": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, rentingPlatform.codegen.platform.types.common.LeaseTerms.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new LACreationRequest(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3])));
  }

  public static LACreationRequest fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("operator", apply(JsonLfEncoders::party, operator)),
        JsonLfEncoders.Field.of("tenant", apply(JsonLfEncoders::party, tenant)),
        JsonLfEncoders.Field.of("house", apply(House::jsonEncoder, house)),
        JsonLfEncoders.Field.of("leaseTerms", apply(LeaseTerms::jsonEncoder, leaseTerms)));
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
    if (!(object instanceof LACreationRequest)) {
      return false;
    }
    LACreationRequest other = (LACreationRequest) object;
    return Objects.equals(this.operator, other.operator) &&
        Objects.equals(this.tenant, other.tenant) && Objects.equals(this.house, other.house) &&
        Objects.equals(this.leaseTerms, other.leaseTerms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.operator, this.tenant, this.house, this.leaseTerms);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.proposal.LACreationRequest(%s, %s, %s, %s)",
        this.operator, this.tenant, this.house, this.leaseTerms);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<LACreationRequest> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, LACreationRequest, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public static ContractId fromContractId(
        com.daml.ledger.javaapi.data.codegen.ContractId<LACreationRequest> contractId) {
      return COMPANION.toContractId(contractId);
    }
  }

  public static class Contract extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, LACreationRequest> {
    public Contract(ContractId id, LACreationRequest data, Optional<String> agreementText,
        Set<String> signatories, Set<String> observers) {
      super(id, data, agreementText, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, LACreationRequest> getCompanion() {
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

    default Update<Exercised<LeaseAgreement.ContractId>> exerciseApprove(Approve arg) {
      return makeExerciseCmd(CHOICE_Approve, arg);
    }

    default Update<Exercised<LeaseAgreement.ContractId>> exerciseApprove(String evolveId) {
      return exerciseApprove(new Approve(evolveId));
    }
  }

  public static final class CreateAnd extends com.daml.ledger.javaapi.data.codegen.CreateAnd implements Exercises<CreateAndExerciseCommand> {
    CreateAnd(Template createArguments) {
      super(createArguments);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, LACreationRequest, ?> getCompanion(
        ) {
      return COMPANION;
    }
  }
}

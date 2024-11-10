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
import rentingPlatform.codegen.da.set.types.Set;

public final class AvailableArbitrators extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("6ca065ed990f710397d5bb273336a4eef438fdaf5c0d5e62b6e4e42cb9aa2b70", "Platform.ModelMI", "AvailableArbitrators");

  public static final Choice<AvailableArbitrators, AddObserver, ContractId> CHOICE_AddObserver = 
      Choice.create("AddObserver", value$ -> value$.toValue(), value$ -> AddObserver.valueDecoder()
        .decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<AvailableArbitrators, rentingPlatform.codegen.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        rentingPlatform.codegen.da.internal.template.Archive.valueDecoder().decode(value$),
        value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<AvailableArbitrators, AddArbitrator, ContractId> CHOICE_AddArbitrator = 
      Choice.create("AddArbitrator", value$ -> value$.toValue(), value$ ->
        AddArbitrator.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final ContractCompanion.WithoutKey<Contract, ContractId, AvailableArbitrators> COMPANION = 
      new ContractCompanion.WithoutKey<>(
        "rentingPlatform.codegen.platform.modelmi.AvailableArbitrators", TEMPLATE_ID,
        ContractId::new, v -> AvailableArbitrators.templateValueDecoder().decode(v),
        AvailableArbitrators::fromJson, Contract::new, List.of(CHOICE_AddObserver, CHOICE_Archive,
        CHOICE_AddArbitrator));

  public final String operator;

  public final Set<String> arbitrators;

  public final Set<String> observers;

  public AvailableArbitrators(String operator, Set<String> arbitrators, Set<String> observers) {
    this.operator = operator;
    this.arbitrators = arbitrators;
    this.observers = observers;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(AvailableArbitrators.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseAddObserver} instead
   */
  @Deprecated
  public Update<Exercised<ContractId>> createAndExerciseAddObserver(AddObserver arg) {
    return createAnd().exerciseAddObserver(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseAddObserver} instead
   */
  @Deprecated
  public Update<Exercised<ContractId>> createAndExerciseAddObserver(
      AvailableArbitratorsRequest.ContractId requestCid, String public$) {
    return createAndExerciseAddObserver(new AddObserver(requestCid, public$));
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
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseAddArbitrator} instead
   */
  @Deprecated
  public Update<Exercised<ContractId>> createAndExerciseAddArbitrator(AddArbitrator arg) {
    return createAnd().exerciseAddArbitrator(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseAddArbitrator} instead
   */
  @Deprecated
  public Update<Exercised<ContractId>> createAndExerciseAddArbitrator(String arbitrator) {
    return createAndExerciseAddArbitrator(new AddArbitrator(arbitrator));
  }

  public static Update<Created<ContractId>> create(String operator, Set<String> arbitrators,
      Set<String> observers) {
    return new AvailableArbitrators(operator, arbitrators, observers).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithoutKey<Contract, ContractId, AvailableArbitrators> getCompanion(
      ) {
    return COMPANION;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static AvailableArbitrators fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<AvailableArbitrators> valueDecoder() throws IllegalArgumentException {
    return ContractCompanion.valueDecoder(COMPANION);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(3);
    fields.add(new DamlRecord.Field("operator", new Party(this.operator)));
    fields.add(new DamlRecord.Field("arbitrators", this.arbitrators.toValue(v$0 -> new Party(v$0))));
    fields.add(new DamlRecord.Field("observers", this.observers.toValue(v$0 -> new Party(v$0))));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<AvailableArbitrators> templateValueDecoder() throws
      IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(3,0, recordValue$);
      String operator = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      Set<String> arbitrators = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(1).getValue());
      Set<String> observers = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(2).getValue());
      return new AvailableArbitrators(operator, arbitrators, observers);
    } ;
  }

  public static JsonLfDecoder<AvailableArbitrators> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("operator", "arbitrators", "observers"), name -> {
          switch (name) {
            case "operator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "arbitrators": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, rentingPlatform.codegen.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "observers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, rentingPlatform.codegen.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            default: return null;
          }
        }
        , (Object[] args) -> new AvailableArbitrators(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2])));
  }

  public static AvailableArbitrators fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("operator", apply(JsonLfEncoders::party, operator)),
        JsonLfEncoders.Field.of("arbitrators", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), arbitrators)),
        JsonLfEncoders.Field.of("observers", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), observers)));
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
    if (!(object instanceof AvailableArbitrators)) {
      return false;
    }
    AvailableArbitrators other = (AvailableArbitrators) object;
    return Objects.equals(this.operator, other.operator) &&
        Objects.equals(this.arbitrators, other.arbitrators) &&
        Objects.equals(this.observers, other.observers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.operator, this.arbitrators, this.observers);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.modelmi.AvailableArbitrators(%s, %s, %s)",
        this.operator, this.arbitrators, this.observers);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<AvailableArbitrators> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, AvailableArbitrators, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public static ContractId fromContractId(
        com.daml.ledger.javaapi.data.codegen.ContractId<AvailableArbitrators> contractId) {
      return COMPANION.toContractId(contractId);
    }
  }

  public static class Contract extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, AvailableArbitrators> {
    public Contract(ContractId id, AvailableArbitrators data, Optional<String> agreementText,
        java.util.Set<String> signatories, java.util.Set<String> observers) {
      super(id, data, agreementText, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, AvailableArbitrators> getCompanion() {
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
    default Update<Exercised<ContractId>> exerciseAddObserver(AddObserver arg) {
      return makeExerciseCmd(CHOICE_AddObserver, arg);
    }

    default Update<Exercised<ContractId>> exerciseAddObserver(
        AvailableArbitratorsRequest.ContractId requestCid, String public$) {
      return exerciseAddObserver(new AddObserver(requestCid, public$));
    }

    default Update<Exercised<Unit>> exerciseArchive(
        rentingPlatform.codegen.da.internal.template.Archive arg) {
      return makeExerciseCmd(CHOICE_Archive, arg);
    }

    default Update<Exercised<Unit>> exerciseArchive() {
      return exerciseArchive(new rentingPlatform.codegen.da.internal.template.Archive());
    }

    default Update<Exercised<ContractId>> exerciseAddArbitrator(AddArbitrator arg) {
      return makeExerciseCmd(CHOICE_AddArbitrator, arg);
    }

    default Update<Exercised<ContractId>> exerciseAddArbitrator(String arbitrator) {
      return exerciseAddArbitrator(new AddArbitrator(arbitrator));
    }
  }

  public static final class CreateAnd extends com.daml.ledger.javaapi.data.codegen.CreateAnd implements Exercises<CreateAndExerciseCommand> {
    CreateAnd(Template createArguments) {
      super(createArguments);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, AvailableArbitrators, ?> getCompanion(
        ) {
      return COMPANION;
    }
  }
}

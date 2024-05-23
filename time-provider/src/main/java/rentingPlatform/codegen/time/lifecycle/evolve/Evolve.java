package rentingPlatform.codegen.time.lifecycle.evolve;

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
import rentingPlatform.codegen.interface$.types.LAkey;
import rentingPlatform.codegen.time.clock.DateClockUpdateEvent;

public final class Evolve extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("0cf664e7a7bad84bfc31440cc4ea2b4c71a9a628dbeb0437bb65cac5ef779e5e", "Time.Lifecycle.Evolve", "Evolve");

  public static final Choice<Evolve, AddLA, ContractId> CHOICE_AddLA = 
      Choice.create("AddLA", value$ -> value$.toValue(), value$ -> AddLA.valueDecoder()
        .decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Evolve, rentingPlatform.codegen.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        rentingPlatform.codegen.da.internal.template.Archive.valueDecoder().decode(value$),
        value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Evolve, ProcessEvent, Unit> CHOICE_ProcessEvent = 
      Choice.create("ProcessEvent", value$ -> value$.toValue(), value$ ->
        ProcessEvent.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromUnit
        .decode(value$));

  public static final ContractCompanion.WithoutKey<Contract, ContractId, Evolve> COMPANION = 
      new ContractCompanion.WithoutKey<>("rentingPlatform.codegen.time.lifecycle.evolve.Evolve",
        TEMPLATE_ID, ContractId::new, v -> Evolve.templateValueDecoder().decode(v),
        Evolve::fromJson, Contract::new, List.of(CHOICE_AddLA, CHOICE_Archive,
        CHOICE_ProcessEvent));

  public final String operator;

  public final String lifecycler;

  public final Set<LAkey> laKeys;

  public Evolve(String operator, String lifecycler, Set<LAkey> laKeys) {
    this.operator = operator;
    this.lifecycler = lifecycler;
    this.laKeys = laKeys;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(Evolve.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseAddLA} instead
   */
  @Deprecated
  public Update<Exercised<ContractId>> createAndExerciseAddLA(AddLA arg) {
    return createAnd().exerciseAddLA(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseAddLA} instead
   */
  @Deprecated
  public Update<Exercised<ContractId>> createAndExerciseAddLA(LAkey laKey) {
    return createAndExerciseAddLA(new AddLA(laKey));
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
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseProcessEvent} instead
   */
  @Deprecated
  public Update<Exercised<Unit>> createAndExerciseProcessEvent(ProcessEvent arg) {
    return createAnd().exerciseProcessEvent(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseProcessEvent} instead
   */
  @Deprecated
  public Update<Exercised<Unit>> createAndExerciseProcessEvent(
      DateClockUpdateEvent.ContractId eventCid) {
    return createAndExerciseProcessEvent(new ProcessEvent(eventCid));
  }

  public static Update<Created<ContractId>> create(String operator, String lifecycler,
      Set<LAkey> laKeys) {
    return new Evolve(operator, lifecycler, laKeys).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithoutKey<Contract, ContractId, Evolve> getCompanion() {
    return COMPANION;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Evolve fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Evolve> valueDecoder() throws IllegalArgumentException {
    return ContractCompanion.valueDecoder(COMPANION);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(3);
    fields.add(new DamlRecord.Field("operator", new Party(this.operator)));
    fields.add(new DamlRecord.Field("lifecycler", new Party(this.lifecycler)));
    fields.add(new DamlRecord.Field("laKeys", this.laKeys.toValue(v$0 -> v$0.toValue())));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<Evolve> templateValueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(3,0, recordValue$);
      String operator = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String lifecycler = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      Set<LAkey> laKeys =
          Set.<rentingPlatform.codegen.interface$.types.LAkey>valueDecoder(LAkey.valueDecoder())
          .decode(fields$.get(2).getValue());
      return new Evolve(operator, lifecycler, laKeys);
    } ;
  }

  public static JsonLfDecoder<Evolve> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("operator", "lifecycler", "laKeys"), name -> {
          switch (name) {
            case "operator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "lifecycler": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "laKeys": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, rentingPlatform.codegen.da.set.types.Set.jsonDecoder(rentingPlatform.codegen.interface$.types.LAkey.jsonDecoder()));
            default: return null;
          }
        }
        , (Object[] args) -> new Evolve(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2])));
  }

  public static Evolve fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("operator", apply(JsonLfEncoders::party, operator)),
        JsonLfEncoders.Field.of("lifecycler", apply(JsonLfEncoders::party, lifecycler)),
        JsonLfEncoders.Field.of("laKeys", apply(_x0 -> _x0.jsonEncoder(LAkey::jsonEncoder), laKeys)));
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
    if (!(object instanceof Evolve)) {
      return false;
    }
    Evolve other = (Evolve) object;
    return Objects.equals(this.operator, other.operator) &&
        Objects.equals(this.lifecycler, other.lifecycler) &&
        Objects.equals(this.laKeys, other.laKeys);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.operator, this.lifecycler, this.laKeys);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.time.lifecycle.evolve.Evolve(%s, %s, %s)",
        this.operator, this.lifecycler, this.laKeys);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<Evolve> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Evolve, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public static ContractId fromContractId(
        com.daml.ledger.javaapi.data.codegen.ContractId<Evolve> contractId) {
      return COMPANION.toContractId(contractId);
    }
  }

  public static class Contract extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, Evolve> {
    public Contract(ContractId id, Evolve data, Optional<String> agreementText,
        java.util.Set<String> signatories, java.util.Set<String> observers) {
      super(id, data, agreementText, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, Evolve> getCompanion() {
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
    default Update<Exercised<ContractId>> exerciseAddLA(AddLA arg) {
      return makeExerciseCmd(CHOICE_AddLA, arg);
    }

    default Update<Exercised<ContractId>> exerciseAddLA(LAkey laKey) {
      return exerciseAddLA(new AddLA(laKey));
    }

    default Update<Exercised<Unit>> exerciseArchive(
        rentingPlatform.codegen.da.internal.template.Archive arg) {
      return makeExerciseCmd(CHOICE_Archive, arg);
    }

    default Update<Exercised<Unit>> exerciseArchive() {
      return exerciseArchive(new rentingPlatform.codegen.da.internal.template.Archive());
    }

    default Update<Exercised<Unit>> exerciseProcessEvent(ProcessEvent arg) {
      return makeExerciseCmd(CHOICE_ProcessEvent, arg);
    }

    default Update<Exercised<Unit>> exerciseProcessEvent(DateClockUpdateEvent.ContractId eventCid) {
      return exerciseProcessEvent(new ProcessEvent(eventCid));
    }
  }

  public static final class CreateAnd extends com.daml.ledger.javaapi.data.codegen.CreateAnd implements Exercises<CreateAndExerciseCommand> {
    CreateAnd(Template createArguments) {
      super(createArguments);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Evolve, ?> getCompanion(
        ) {
      return COMPANION;
    }
  }
}

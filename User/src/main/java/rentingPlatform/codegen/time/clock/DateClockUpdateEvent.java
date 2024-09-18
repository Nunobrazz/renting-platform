package rentingPlatform.codegen.time.clock;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.ContractFilter;
import com.daml.ledger.javaapi.data.CreateAndExerciseCommand;
import com.daml.ledger.javaapi.data.CreateCommand;
import com.daml.ledger.javaapi.data.CreatedEvent;
import com.daml.ledger.javaapi.data.DamlRecord;
import com.daml.ledger.javaapi.data.Date;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import rentingPlatform.codegen.da.set.types.Set;
import rentingPlatform.codegen.da.types.Tuple2;

public final class DateClockUpdateEvent extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("bef0965dc38d518ab3f749ea7cce7cf9cd13acb7b593b5f936707edcb2f1eff5", "Time.Clock", "DateClockUpdateEvent");

  public static final Choice<DateClockUpdateEvent, rentingPlatform.codegen.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        rentingPlatform.codegen.da.internal.template.Archive.valueDecoder().decode(value$),
        value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final ContractCompanion.WithKey<Contract, ContractId, DateClockUpdateEvent, Tuple2<String, LocalDate>> COMPANION = 
      new ContractCompanion.WithKey<>("rentingPlatform.codegen.time.clock.DateClockUpdateEvent",
        TEMPLATE_ID, ContractId::new, v -> DateClockUpdateEvent.templateValueDecoder().decode(v),
        DateClockUpdateEvent::fromJson, Contract::new, List.of(CHOICE_Archive),
        e -> Tuple2.<java.lang.String,
        java.time.LocalDate>valueDecoder(PrimitiveValueDecoders.fromParty,
        PrimitiveValueDecoders.fromDate).decode(e));

  public final String creator;

  public final LocalDate eventDate;

  public final Set<String> observers;

  public final String operator;

  public final Set<String> providers;

  public DateClockUpdateEvent(String creator, LocalDate eventDate, Set<String> observers,
      String operator, Set<String> providers) {
    this.creator = creator;
    this.eventDate = eventDate;
    this.observers = observers;
    this.operator = operator;
    this.providers = providers;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(DateClockUpdateEvent.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseArchive} instead
   */
  @Deprecated
  public static Update<Exercised<Unit>> exerciseByKeyArchive(Tuple2<String, LocalDate> key,
      rentingPlatform.codegen.da.internal.template.Archive arg) {
    return byKey(key).exerciseArchive(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseArchive()} instead
   */
  @Deprecated
  public static Update<Exercised<Unit>> exerciseByKeyArchive(Tuple2<String, LocalDate> key) {
    return byKey(key).exerciseArchive();
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

  public static Update<Created<ContractId>> create(String creator, LocalDate eventDate,
      Set<String> observers, String operator, Set<String> providers) {
    return new DateClockUpdateEvent(creator, eventDate, observers, operator, providers).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithKey<Contract, ContractId, DateClockUpdateEvent, Tuple2<String, LocalDate>> getCompanion(
      ) {
    return COMPANION;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static DateClockUpdateEvent fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<DateClockUpdateEvent> valueDecoder() throws IllegalArgumentException {
    return ContractCompanion.valueDecoder(COMPANION);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(5);
    fields.add(new DamlRecord.Field("creator", new Party(this.creator)));
    fields.add(new DamlRecord.Field("eventDate", new Date((int) this.eventDate.toEpochDay())));
    fields.add(new DamlRecord.Field("observers", this.observers.toValue(v$0 -> new Party(v$0))));
    fields.add(new DamlRecord.Field("operator", new Party(this.operator)));
    fields.add(new DamlRecord.Field("providers", this.providers.toValue(v$0 -> new Party(v$0))));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<DateClockUpdateEvent> templateValueDecoder() throws
      IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(5,0, recordValue$);
      String creator = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      LocalDate eventDate = PrimitiveValueDecoders.fromDate.decode(fields$.get(1).getValue());
      Set<String> observers = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(2).getValue());
      String operator = PrimitiveValueDecoders.fromParty.decode(fields$.get(3).getValue());
      Set<String> providers = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(4).getValue());
      return new DateClockUpdateEvent(creator, eventDate, observers, operator, providers);
    } ;
  }

  public static JsonLfDecoder<DateClockUpdateEvent> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("creator", "eventDate", "observers", "operator", "providers"), name -> {
          switch (name) {
            case "creator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "eventDate": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.date);
            case "observers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, rentingPlatform.codegen.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "operator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "providers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, rentingPlatform.codegen.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            default: return null;
          }
        }
        , (Object[] args) -> new DateClockUpdateEvent(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4])));
  }

  public static DateClockUpdateEvent fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("creator", apply(JsonLfEncoders::party, creator)),
        JsonLfEncoders.Field.of("eventDate", apply(JsonLfEncoders::date, eventDate)),
        JsonLfEncoders.Field.of("observers", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), observers)),
        JsonLfEncoders.Field.of("operator", apply(JsonLfEncoders::party, operator)),
        JsonLfEncoders.Field.of("providers", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), providers)));
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
    if (!(object instanceof DateClockUpdateEvent)) {
      return false;
    }
    DateClockUpdateEvent other = (DateClockUpdateEvent) object;
    return Objects.equals(this.creator, other.creator) &&
        Objects.equals(this.eventDate, other.eventDate) &&
        Objects.equals(this.observers, other.observers) &&
        Objects.equals(this.operator, other.operator) &&
        Objects.equals(this.providers, other.providers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.creator, this.eventDate, this.observers, this.operator,
        this.providers);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.time.clock.DateClockUpdateEvent(%s, %s, %s, %s, %s)",
        this.creator, this.eventDate, this.observers, this.operator, this.providers);
  }

  /**
   * Set up an {@link ExerciseByKeyCommand}; invoke an {@code exercise} method on the result of
      this to finish creating the command, or convert to an interface first with {@code toInterface}
      to invoke an interface {@code exercise} method.
   */
  public static ByKey byKey(Tuple2<String, LocalDate> key) {
    return new ByKey(key.toValue(v$0 -> new Party(v$0), v$1 -> new Date((int) v$1.toEpochDay())));
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<DateClockUpdateEvent> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, DateClockUpdateEvent, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public static ContractId fromContractId(
        com.daml.ledger.javaapi.data.codegen.ContractId<DateClockUpdateEvent> contractId) {
      return COMPANION.toContractId(contractId);
    }
  }

  public static class Contract extends ContractWithKey<ContractId, DateClockUpdateEvent, Tuple2<String, LocalDate>> {
    public Contract(ContractId id, DateClockUpdateEvent data, Optional<String> agreementText,
        Optional<Tuple2<String, LocalDate>> key, java.util.Set<String> signatories,
        java.util.Set<String> observers) {
      super(id, data, agreementText, key, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, DateClockUpdateEvent> getCompanion() {
      return COMPANION;
    }

    public static Contract fromIdAndRecord(String contractId, DamlRecord record$,
        Optional<String> agreementText, Optional<Tuple2<String, LocalDate>> key,
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
  }

  public static final class CreateAnd extends com.daml.ledger.javaapi.data.codegen.CreateAnd implements Exercises<CreateAndExerciseCommand> {
    CreateAnd(Template createArguments) {
      super(createArguments);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, DateClockUpdateEvent, ?> getCompanion(
        ) {
      return COMPANION;
    }
  }

  public static final class ByKey extends com.daml.ledger.javaapi.data.codegen.ByKey implements Exercises<ExerciseByKeyCommand> {
    ByKey(Value key) {
      super(key);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, DateClockUpdateEvent, ?> getCompanion(
        ) {
      return COMPANION;
    }
  }
}

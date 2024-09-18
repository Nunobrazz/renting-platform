package rentingPlatform.codegen.time.clock;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.ContractFilter;
import com.daml.ledger.javaapi.data.CreateAndExerciseCommand;
import com.daml.ledger.javaapi.data.CreateCommand;
import com.daml.ledger.javaapi.data.CreatedEvent;
import com.daml.ledger.javaapi.data.DamlRecord;
import com.daml.ledger.javaapi.data.Date;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import rentingPlatform.codegen.da.set.types.Set;

public final class DateClock extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("bef0965dc38d518ab3f749ea7cce7cf9cd13acb7b593b5f936707edcb2f1eff5", "Time.Clock", "DateClock");

  public static final Choice<DateClock, Advance, DateClockUpdateEvent.ContractId> CHOICE_Advance = 
      Choice.create("Advance", value$ -> value$.toValue(), value$ -> Advance.valueDecoder()
        .decode(value$), value$ ->
        new DateClockUpdateEvent.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<DateClock, Accept, ContractId> CHOICE_Accept = 
      Choice.create("Accept", value$ -> value$.toValue(), value$ -> Accept.valueDecoder()
        .decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<DateClock, rentingPlatform.codegen.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        rentingPlatform.codegen.da.internal.template.Archive.valueDecoder().decode(value$),
        value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final ContractCompanion.WithoutKey<Contract, ContractId, DateClock> COMPANION = 
      new ContractCompanion.WithoutKey<>("rentingPlatform.codegen.time.clock.DateClock",
        TEMPLATE_ID, ContractId::new, v -> DateClock.templateValueDecoder().decode(v),
        DateClock::fromJson, Contract::new, List.of(CHOICE_Advance, CHOICE_Accept, CHOICE_Archive));

  public final String operator;

  public final Set<String> providers;

  public final LocalDate clockDate;

  public final String creator;

  public final Set<String> waitingAccept;

  public DateClock(String operator, Set<String> providers, LocalDate clockDate, String creator,
      Set<String> waitingAccept) {
    this.operator = operator;
    this.providers = providers;
    this.clockDate = clockDate;
    this.creator = creator;
    this.waitingAccept = waitingAccept;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(DateClock.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseAdvance} instead
   */
  @Deprecated
  public Update<Exercised<DateClockUpdateEvent.ContractId>> createAndExerciseAdvance(Advance arg) {
    return createAnd().exerciseAdvance(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseAdvance} instead
   */
  @Deprecated
  public Update<Exercised<DateClockUpdateEvent.ContractId>> createAndExerciseAdvance(
      String advancer) {
    return createAndExerciseAdvance(new Advance(advancer));
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseAccept} instead
   */
  @Deprecated
  public Update<Exercised<ContractId>> createAndExerciseAccept(Accept arg) {
    return createAnd().exerciseAccept(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseAccept} instead
   */
  @Deprecated
  public Update<Exercised<ContractId>> createAndExerciseAccept(String provider) {
    return createAndExerciseAccept(new Accept(provider));
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

  public static Update<Created<ContractId>> create(String operator, Set<String> providers,
      LocalDate clockDate, String creator, Set<String> waitingAccept) {
    return new DateClock(operator, providers, clockDate, creator, waitingAccept).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithoutKey<Contract, ContractId, DateClock> getCompanion() {
    return COMPANION;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static DateClock fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<DateClock> valueDecoder() throws IllegalArgumentException {
    return ContractCompanion.valueDecoder(COMPANION);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(5);
    fields.add(new DamlRecord.Field("operator", new Party(this.operator)));
    fields.add(new DamlRecord.Field("providers", this.providers.toValue(v$0 -> new Party(v$0))));
    fields.add(new DamlRecord.Field("clockDate", new Date((int) this.clockDate.toEpochDay())));
    fields.add(new DamlRecord.Field("creator", new Party(this.creator)));
    fields.add(new DamlRecord.Field("waitingAccept", this.waitingAccept.toValue(v$0 -> new Party(v$0))));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<DateClock> templateValueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(5,0, recordValue$);
      String operator = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      Set<String> providers = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(1).getValue());
      LocalDate clockDate = PrimitiveValueDecoders.fromDate.decode(fields$.get(2).getValue());
      String creator = PrimitiveValueDecoders.fromParty.decode(fields$.get(3).getValue());
      Set<String> waitingAccept =
          Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(4).getValue());
      return new DateClock(operator, providers, clockDate, creator, waitingAccept);
    } ;
  }

  public static JsonLfDecoder<DateClock> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("operator", "providers", "clockDate", "creator", "waitingAccept"), name -> {
          switch (name) {
            case "operator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "providers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, rentingPlatform.codegen.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "clockDate": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.date);
            case "creator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "waitingAccept": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, rentingPlatform.codegen.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            default: return null;
          }
        }
        , (Object[] args) -> new DateClock(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4])));
  }

  public static DateClock fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("operator", apply(JsonLfEncoders::party, operator)),
        JsonLfEncoders.Field.of("providers", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), providers)),
        JsonLfEncoders.Field.of("clockDate", apply(JsonLfEncoders::date, clockDate)),
        JsonLfEncoders.Field.of("creator", apply(JsonLfEncoders::party, creator)),
        JsonLfEncoders.Field.of("waitingAccept", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), waitingAccept)));
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
    if (!(object instanceof DateClock)) {
      return false;
    }
    DateClock other = (DateClock) object;
    return Objects.equals(this.operator, other.operator) &&
        Objects.equals(this.providers, other.providers) &&
        Objects.equals(this.clockDate, other.clockDate) &&
        Objects.equals(this.creator, other.creator) &&
        Objects.equals(this.waitingAccept, other.waitingAccept);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.operator, this.providers, this.clockDate, this.creator,
        this.waitingAccept);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.time.clock.DateClock(%s, %s, %s, %s, %s)",
        this.operator, this.providers, this.clockDate, this.creator, this.waitingAccept);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<DateClock> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, DateClock, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public static ContractId fromContractId(
        com.daml.ledger.javaapi.data.codegen.ContractId<DateClock> contractId) {
      return COMPANION.toContractId(contractId);
    }
  }

  public static class Contract extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, DateClock> {
    public Contract(ContractId id, DateClock data, Optional<String> agreementText,
        java.util.Set<String> signatories, java.util.Set<String> observers) {
      super(id, data, agreementText, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, DateClock> getCompanion() {
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
    default Update<Exercised<DateClockUpdateEvent.ContractId>> exerciseAdvance(Advance arg) {
      return makeExerciseCmd(CHOICE_Advance, arg);
    }

    default Update<Exercised<DateClockUpdateEvent.ContractId>> exerciseAdvance(String advancer) {
      return exerciseAdvance(new Advance(advancer));
    }

    default Update<Exercised<ContractId>> exerciseAccept(Accept arg) {
      return makeExerciseCmd(CHOICE_Accept, arg);
    }

    default Update<Exercised<ContractId>> exerciseAccept(String provider) {
      return exerciseAccept(new Accept(provider));
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
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, DateClock, ?> getCompanion(
        ) {
      return COMPANION;
    }
  }
}

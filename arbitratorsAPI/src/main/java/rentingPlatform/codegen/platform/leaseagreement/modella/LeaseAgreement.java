package rentingPlatform.codegen.platform.leaseagreement.modella;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.ContractFilter;
import com.daml.ledger.javaapi.data.CreateAndExerciseCommand;
import com.daml.ledger.javaapi.data.CreateCommand;
import com.daml.ledger.javaapi.data.CreatedEvent;
import com.daml.ledger.javaapi.data.DamlCollectors;
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
import java.util.Set;
import rentingPlatform.codegen.platform.types.common.House;
import rentingPlatform.codegen.platform.types.common.LeaseTerms;
import rentingPlatform.codegen.platform.types.la.LAkey;

public final class LeaseAgreement extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("b1c69ded5e6f9b3209adda4613b08585e35d988f49cc818e5af8942f840887f7", "Platform.LeaseAgreement.ModelLA", "LeaseAgreement");

  public static final Choice<LeaseAgreement, rentingPlatform.codegen.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        rentingPlatform.codegen.da.internal.template.Archive.valueDecoder().decode(value$),
        value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<LeaseAgreement, ProcessPayment, ContractId> CHOICE_ProcessPayment = 
      Choice.create("ProcessPayment", value$ -> value$.toValue(), value$ ->
        ProcessPayment.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final ContractCompanion.WithKey<Contract, ContractId, LeaseAgreement, LAkey> COMPANION = 
      new ContractCompanion.WithKey<>(
        "rentingPlatform.codegen.platform.leaseagreement.modella.LeaseAgreement", TEMPLATE_ID,
        ContractId::new, v -> LeaseAgreement.templateValueDecoder().decode(v),
        LeaseAgreement::fromJson, Contract::new, List.of(CHOICE_Archive, CHOICE_ProcessPayment),
        e -> LAkey.valueDecoder().decode(e));

  public final String operator;

  public final String lifecycler;

  public final String tenant;

  public final House house;

  public final LeaseTerms leaseTerms;

  public final List<LocalDate> paymentsToProcess;

  public LeaseAgreement(String operator, String lifecycler, String tenant, House house,
      LeaseTerms leaseTerms, List<LocalDate> paymentsToProcess) {
    this.operator = operator;
    this.lifecycler = lifecycler;
    this.tenant = tenant;
    this.house = house;
    this.leaseTerms = leaseTerms;
    this.paymentsToProcess = paymentsToProcess;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(LeaseAgreement.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseArchive} instead
   */
  @Deprecated
  public static Update<Exercised<Unit>> exerciseByKeyArchive(LAkey key,
      rentingPlatform.codegen.da.internal.template.Archive arg) {
    return byKey(key).exerciseArchive(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseArchive()} instead
   */
  @Deprecated
  public static Update<Exercised<Unit>> exerciseByKeyArchive(LAkey key) {
    return byKey(key).exerciseArchive();
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseProcessPayment} instead
   */
  @Deprecated
  public static Update<Exercised<ContractId>> exerciseByKeyProcessPayment(LAkey key,
      ProcessPayment arg) {
    return byKey(key).exerciseProcessPayment(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseProcessPayment(date)} instead
   */
  @Deprecated
  public static Update<Exercised<ContractId>> exerciseByKeyProcessPayment(LAkey key,
      LocalDate date) {
    return byKey(key).exerciseProcessPayment(date);
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
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseProcessPayment} instead
   */
  @Deprecated
  public Update<Exercised<ContractId>> createAndExerciseProcessPayment(ProcessPayment arg) {
    return createAnd().exerciseProcessPayment(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseProcessPayment} instead
   */
  @Deprecated
  public Update<Exercised<ContractId>> createAndExerciseProcessPayment(LocalDate date) {
    return createAndExerciseProcessPayment(new ProcessPayment(date));
  }

  public static Update<Created<ContractId>> create(String operator, String lifecycler,
      String tenant, House house, LeaseTerms leaseTerms, List<LocalDate> paymentsToProcess) {
    return new LeaseAgreement(operator, lifecycler, tenant, house, leaseTerms,
        paymentsToProcess).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithKey<Contract, ContractId, LeaseAgreement, LAkey> getCompanion() {
    return COMPANION;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static LeaseAgreement fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<LeaseAgreement> valueDecoder() throws IllegalArgumentException {
    return ContractCompanion.valueDecoder(COMPANION);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(6);
    fields.add(new DamlRecord.Field("operator", new Party(this.operator)));
    fields.add(new DamlRecord.Field("lifecycler", new Party(this.lifecycler)));
    fields.add(new DamlRecord.Field("tenant", new Party(this.tenant)));
    fields.add(new DamlRecord.Field("house", this.house.toValue()));
    fields.add(new DamlRecord.Field("leaseTerms", this.leaseTerms.toValue()));
    fields.add(new DamlRecord.Field("paymentsToProcess", this.paymentsToProcess.stream().collect(DamlCollectors.toDamlList(v$0 -> new Date((int) v$0.toEpochDay())))));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<LeaseAgreement> templateValueDecoder() throws
      IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(6,0, recordValue$);
      String operator = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String lifecycler = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      String tenant = PrimitiveValueDecoders.fromParty.decode(fields$.get(2).getValue());
      House house = House.valueDecoder().decode(fields$.get(3).getValue());
      LeaseTerms leaseTerms = LeaseTerms.valueDecoder().decode(fields$.get(4).getValue());
      List<LocalDate> paymentsToProcess = PrimitiveValueDecoders.fromList(
            PrimitiveValueDecoders.fromDate).decode(fields$.get(5).getValue());
      return new LeaseAgreement(operator, lifecycler, tenant, house, leaseTerms, paymentsToProcess);
    } ;
  }

  public static JsonLfDecoder<LeaseAgreement> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("operator", "lifecycler", "tenant", "house", "leaseTerms", "paymentsToProcess"), name -> {
          switch (name) {
            case "operator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "lifecycler": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "tenant": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "house": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, rentingPlatform.codegen.platform.types.common.House.jsonDecoder());
            case "leaseTerms": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, rentingPlatform.codegen.platform.types.common.LeaseTerms.jsonDecoder());
            case "paymentsToProcess": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.date));
            default: return null;
          }
        }
        , (Object[] args) -> new LeaseAgreement(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5])));
  }

  public static LeaseAgreement fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("operator", apply(JsonLfEncoders::party, operator)),
        JsonLfEncoders.Field.of("lifecycler", apply(JsonLfEncoders::party, lifecycler)),
        JsonLfEncoders.Field.of("tenant", apply(JsonLfEncoders::party, tenant)),
        JsonLfEncoders.Field.of("house", apply(House::jsonEncoder, house)),
        JsonLfEncoders.Field.of("leaseTerms", apply(LeaseTerms::jsonEncoder, leaseTerms)),
        JsonLfEncoders.Field.of("paymentsToProcess", apply(JsonLfEncoders.list(JsonLfEncoders::date), paymentsToProcess)));
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
    if (!(object instanceof LeaseAgreement)) {
      return false;
    }
    LeaseAgreement other = (LeaseAgreement) object;
    return Objects.equals(this.operator, other.operator) &&
        Objects.equals(this.lifecycler, other.lifecycler) &&
        Objects.equals(this.tenant, other.tenant) && Objects.equals(this.house, other.house) &&
        Objects.equals(this.leaseTerms, other.leaseTerms) &&
        Objects.equals(this.paymentsToProcess, other.paymentsToProcess);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.operator, this.lifecycler, this.tenant, this.house, this.leaseTerms,
        this.paymentsToProcess);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.leaseagreement.modella.LeaseAgreement(%s, %s, %s, %s, %s, %s)",
        this.operator, this.lifecycler, this.tenant, this.house, this.leaseTerms,
        this.paymentsToProcess);
  }

  /**
   * Set up an {@link ExerciseByKeyCommand}; invoke an {@code exercise} method on the result of
      this to finish creating the command, or convert to an interface first with {@code toInterface}
      to invoke an interface {@code exercise} method.
   */
  public static ByKey byKey(LAkey key) {
    return new ByKey(key.toValue());
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<LeaseAgreement> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, LeaseAgreement, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public static ContractId fromContractId(
        com.daml.ledger.javaapi.data.codegen.ContractId<LeaseAgreement> contractId) {
      return COMPANION.toContractId(contractId);
    }
  }

  public static class Contract extends ContractWithKey<ContractId, LeaseAgreement, LAkey> {
    public Contract(ContractId id, LeaseAgreement data, Optional<String> agreementText,
        Optional<LAkey> key, Set<String> signatories, Set<String> observers) {
      super(id, data, agreementText, key, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, LeaseAgreement> getCompanion() {
      return COMPANION;
    }

    public static Contract fromIdAndRecord(String contractId, DamlRecord record$,
        Optional<String> agreementText, Optional<LAkey> key, Set<String> signatories,
        Set<String> observers) {
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

    default Update<Exercised<ContractId>> exerciseProcessPayment(ProcessPayment arg) {
      return makeExerciseCmd(CHOICE_ProcessPayment, arg);
    }

    default Update<Exercised<ContractId>> exerciseProcessPayment(LocalDate date) {
      return exerciseProcessPayment(new ProcessPayment(date));
    }
  }

  public static final class CreateAnd extends com.daml.ledger.javaapi.data.codegen.CreateAnd implements Exercises<CreateAndExerciseCommand> {
    CreateAnd(Template createArguments) {
      super(createArguments);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, LeaseAgreement, ?> getCompanion(
        ) {
      return COMPANION;
    }
  }

  public static final class ByKey extends com.daml.ledger.javaapi.data.codegen.ByKey implements Exercises<ExerciseByKeyCommand> {
    ByKey(Value key) {
      super(key);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, LeaseAgreement, ?> getCompanion(
        ) {
      return COMPANION;
    }
  }
}

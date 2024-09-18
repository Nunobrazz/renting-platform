package rentingPlatform.codegen.platform.modelmi;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Bool;
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
import java.lang.Boolean;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Long;
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
import rentingPlatform.codegen.da.types.Tuple3;
import rentingPlatform.codegen.platform.types.la.LAkey;
import rentingPlatform.codegen.platform.types.mi.MIdetails;
import rentingPlatform.codegen.platform.types.mi.Responsability;

public final class MIReport extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("bef0965dc38d518ab3f749ea7cce7cf9cd13acb7b593b5f936707edcb2f1eff5", "Platform.ModelMI", "MIReport");

  public static final Choice<MIReport, SetArbitrators, ContractId> CHOICE_SetArbitrators = 
      Choice.create("SetArbitrators", value$ -> value$.toValue(), value$ ->
        SetArbitrators.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<MIReport, CreatePoll, Poll.ContractId> CHOICE_CreatePoll = 
      Choice.create("CreatePoll", value$ -> value$.toValue(), value$ -> CreatePoll.valueDecoder()
        .decode(value$), value$ ->
        new Poll.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<MIReport, rentingPlatform.codegen.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        rentingPlatform.codegen.da.internal.template.Archive.valueDecoder().decode(value$),
        value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final ContractCompanion.WithKey<Contract, ContractId, MIReport, Tuple3<String, String, MIdetails>> COMPANION = 
      new ContractCompanion.WithKey<>("rentingPlatform.codegen.platform.modelmi.MIReport",
        TEMPLATE_ID, ContractId::new, v -> MIReport.templateValueDecoder().decode(v),
        MIReport::fromJson, Contract::new, List.of(CHOICE_SetArbitrators, CHOICE_CreatePoll,
        CHOICE_Archive), e -> Tuple3.<java.lang.String, java.lang.String,
        rentingPlatform.codegen.platform.types.mi.MIdetails>valueDecoder(PrimitiveValueDecoders.fromParty,
        PrimitiveValueDecoders.fromParty, MIdetails.valueDecoder()).decode(e));

  public final String tenant;

  public final String host;

  public final LAkey laKey;

  public final MIdetails miDetails;

  public final Set<String> arbitrators;

  public final Boolean activeInvitation;

  public MIReport(String tenant, String host, LAkey laKey, MIdetails miDetails,
      Set<String> arbitrators, Boolean activeInvitation) {
    this.tenant = tenant;
    this.host = host;
    this.laKey = laKey;
    this.miDetails = miDetails;
    this.arbitrators = arbitrators;
    this.activeInvitation = activeInvitation;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(MIReport.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseSetArbitrators} instead
   */
  @Deprecated
  public static Update<Exercised<ContractId>> exerciseByKeySetArbitrators(
      Tuple3<String, String, MIdetails> key, SetArbitrators arg) {
    return byKey(key).exerciseSetArbitrators(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseSetArbitrators(inviter,
      inviteArbitratorsCid)} instead
   */
  @Deprecated
  public static Update<Exercised<ContractId>> exerciseByKeySetArbitrators(
      Tuple3<String, String, MIdetails> key, String inviter,
      InviteArbitrators.ContractId inviteArbitratorsCid) {
    return byKey(key).exerciseSetArbitrators(inviter, inviteArbitratorsCid);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseCreatePoll} instead
   */
  @Deprecated
  public static Update<Exercised<Poll.ContractId>> exerciseByKeyCreatePoll(
      Tuple3<String, String, MIdetails> key, CreatePoll arg) {
    return byKey(key).exerciseCreatePoll(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseCreatePoll(visitor, visitDetails,
      vote, cost, assessmentDate, reparationDate)} instead
   */
  @Deprecated
  public static Update<Exercised<Poll.ContractId>> exerciseByKeyCreatePoll(
      Tuple3<String, String, MIdetails> key, String visitor, String visitDetails,
      Responsability vote, Long cost, LocalDate assessmentDate, LocalDate reparationDate) {
    return byKey(key).exerciseCreatePoll(visitor, visitDetails, vote, cost, assessmentDate,
        reparationDate);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseArchive} instead
   */
  @Deprecated
  public static Update<Exercised<Unit>> exerciseByKeyArchive(Tuple3<String, String, MIdetails> key,
      rentingPlatform.codegen.da.internal.template.Archive arg) {
    return byKey(key).exerciseArchive(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseArchive()} instead
   */
  @Deprecated
  public static Update<Exercised<Unit>> exerciseByKeyArchive(
      Tuple3<String, String, MIdetails> key) {
    return byKey(key).exerciseArchive();
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseSetArbitrators} instead
   */
  @Deprecated
  public Update<Exercised<ContractId>> createAndExerciseSetArbitrators(SetArbitrators arg) {
    return createAnd().exerciseSetArbitrators(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseSetArbitrators} instead
   */
  @Deprecated
  public Update<Exercised<ContractId>> createAndExerciseSetArbitrators(String inviter,
      InviteArbitrators.ContractId inviteArbitratorsCid) {
    return createAndExerciseSetArbitrators(new SetArbitrators(inviter, inviteArbitratorsCid));
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseCreatePoll} instead
   */
  @Deprecated
  public Update<Exercised<Poll.ContractId>> createAndExerciseCreatePoll(CreatePoll arg) {
    return createAnd().exerciseCreatePoll(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseCreatePoll} instead
   */
  @Deprecated
  public Update<Exercised<Poll.ContractId>> createAndExerciseCreatePoll(String visitor,
      String visitDetails, Responsability vote, Long cost, LocalDate assessmentDate,
      LocalDate reparationDate) {
    return createAndExerciseCreatePoll(new CreatePoll(visitor, visitDetails, vote, cost,
        assessmentDate, reparationDate));
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

  public static Update<Created<ContractId>> create(String tenant, String host, LAkey laKey,
      MIdetails miDetails, Set<String> arbitrators, Boolean activeInvitation) {
    return new MIReport(tenant, host, laKey, miDetails, arbitrators, activeInvitation).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithKey<Contract, ContractId, MIReport, Tuple3<String, String, MIdetails>> getCompanion(
      ) {
    return COMPANION;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static MIReport fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<MIReport> valueDecoder() throws IllegalArgumentException {
    return ContractCompanion.valueDecoder(COMPANION);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(6);
    fields.add(new DamlRecord.Field("tenant", new Party(this.tenant)));
    fields.add(new DamlRecord.Field("host", new Party(this.host)));
    fields.add(new DamlRecord.Field("laKey", this.laKey.toValue()));
    fields.add(new DamlRecord.Field("miDetails", this.miDetails.toValue()));
    fields.add(new DamlRecord.Field("arbitrators", this.arbitrators.toValue(v$0 -> new Party(v$0))));
    fields.add(new DamlRecord.Field("activeInvitation", Bool.of(this.activeInvitation)));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<MIReport> templateValueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(6,0, recordValue$);
      String tenant = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String host = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      LAkey laKey = LAkey.valueDecoder().decode(fields$.get(2).getValue());
      MIdetails miDetails = MIdetails.valueDecoder().decode(fields$.get(3).getValue());
      Set<String> arbitrators = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(4).getValue());
      Boolean activeInvitation = PrimitiveValueDecoders.fromBool.decode(fields$.get(5).getValue());
      return new MIReport(tenant, host, laKey, miDetails, arbitrators, activeInvitation);
    } ;
  }

  public static JsonLfDecoder<MIReport> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("tenant", "host", "laKey", "miDetails", "arbitrators", "activeInvitation"), name -> {
          switch (name) {
            case "tenant": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "host": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "laKey": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, rentingPlatform.codegen.platform.types.la.LAkey.jsonDecoder());
            case "miDetails": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, rentingPlatform.codegen.platform.types.mi.MIdetails.jsonDecoder());
            case "arbitrators": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, rentingPlatform.codegen.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "activeInvitation": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.bool);
            default: return null;
          }
        }
        , (Object[] args) -> new MIReport(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5])));
  }

  public static MIReport fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("tenant", apply(JsonLfEncoders::party, tenant)),
        JsonLfEncoders.Field.of("host", apply(JsonLfEncoders::party, host)),
        JsonLfEncoders.Field.of("laKey", apply(LAkey::jsonEncoder, laKey)),
        JsonLfEncoders.Field.of("miDetails", apply(MIdetails::jsonEncoder, miDetails)),
        JsonLfEncoders.Field.of("arbitrators", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), arbitrators)),
        JsonLfEncoders.Field.of("activeInvitation", apply(JsonLfEncoders::bool, activeInvitation)));
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
    if (!(object instanceof MIReport)) {
      return false;
    }
    MIReport other = (MIReport) object;
    return Objects.equals(this.tenant, other.tenant) && Objects.equals(this.host, other.host) &&
        Objects.equals(this.laKey, other.laKey) &&
        Objects.equals(this.miDetails, other.miDetails) &&
        Objects.equals(this.arbitrators, other.arbitrators) &&
        Objects.equals(this.activeInvitation, other.activeInvitation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.tenant, this.host, this.laKey, this.miDetails, this.arbitrators,
        this.activeInvitation);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.modelmi.MIReport(%s, %s, %s, %s, %s, %s)",
        this.tenant, this.host, this.laKey, this.miDetails, this.arbitrators,
        this.activeInvitation);
  }

  /**
   * Set up an {@link ExerciseByKeyCommand}; invoke an {@code exercise} method on the result of
      this to finish creating the command, or convert to an interface first with {@code toInterface}
      to invoke an interface {@code exercise} method.
   */
  public static ByKey byKey(Tuple3<String, String, MIdetails> key) {
    return new ByKey(key.toValue(v$0 -> new Party(v$0), v$1 -> new Party(v$1),
        v$2 -> v$2.toValue()));
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<MIReport> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, MIReport, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public static ContractId fromContractId(
        com.daml.ledger.javaapi.data.codegen.ContractId<MIReport> contractId) {
      return COMPANION.toContractId(contractId);
    }
  }

  public static class Contract extends ContractWithKey<ContractId, MIReport, Tuple3<String, String, MIdetails>> {
    public Contract(ContractId id, MIReport data, Optional<String> agreementText,
        Optional<Tuple3<String, String, MIdetails>> key, java.util.Set<String> signatories,
        java.util.Set<String> observers) {
      super(id, data, agreementText, key, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, MIReport> getCompanion() {
      return COMPANION;
    }

    public static Contract fromIdAndRecord(String contractId, DamlRecord record$,
        Optional<String> agreementText, Optional<Tuple3<String, String, MIdetails>> key,
        java.util.Set<String> signatories, java.util.Set<String> observers) {
      return COMPANION.fromIdAndRecord(contractId, record$, agreementText, key, signatories,
          observers);
    }

    public static Contract fromCreatedEvent(CreatedEvent event) {
      return COMPANION.fromCreatedEvent(event);
    }
  }

  public interface Exercises<Cmd> extends com.daml.ledger.javaapi.data.codegen.Exercises.Archive<Cmd> {
    default Update<Exercised<ContractId>> exerciseSetArbitrators(SetArbitrators arg) {
      return makeExerciseCmd(CHOICE_SetArbitrators, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetArbitrators(String inviter,
        InviteArbitrators.ContractId inviteArbitratorsCid) {
      return exerciseSetArbitrators(new SetArbitrators(inviter, inviteArbitratorsCid));
    }

    default Update<Exercised<Poll.ContractId>> exerciseCreatePoll(CreatePoll arg) {
      return makeExerciseCmd(CHOICE_CreatePoll, arg);
    }

    default Update<Exercised<Poll.ContractId>> exerciseCreatePoll(String visitor,
        String visitDetails, Responsability vote, Long cost, LocalDate assessmentDate,
        LocalDate reparationDate) {
      return exerciseCreatePoll(new CreatePoll(visitor, visitDetails, vote, cost, assessmentDate,
          reparationDate));
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
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, MIReport, ?> getCompanion(
        ) {
      return COMPANION;
    }
  }

  public static final class ByKey extends com.daml.ledger.javaapi.data.codegen.ByKey implements Exercises<ExerciseByKeyCommand> {
    ByKey(Value key) {
      super(key);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, MIReport, ?> getCompanion(
        ) {
      return COMPANION;
    }
  }
}

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
import rentingPlatform.codegen.platform.types.mi.MIdetails;

public final class InviteArbitrators extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("6ca065ed990f710397d5bb273336a4eef438fdaf5c0d5e62b6e4e42cb9aa2b70", "Platform.ModelMI", "InviteArbitrators");

  public static final Choice<InviteArbitrators, Accept, ContractId> CHOICE_Accept = 
      Choice.create("Accept", value$ -> value$.toValue(), value$ -> Accept.valueDecoder()
        .decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<InviteArbitrators, Finish, Unit> CHOICE_Finish = 
      Choice.create("Finish", value$ -> value$.toValue(), value$ -> Finish.valueDecoder()
        .decode(value$), value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<InviteArbitrators, ConfirmAttribution, MIReport.ContractId> CHOICE_ConfirmAttribution = 
      Choice.create("ConfirmAttribution", value$ -> value$.toValue(), value$ ->
        ConfirmAttribution.valueDecoder().decode(value$), value$ ->
        new MIReport.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<InviteArbitrators, rentingPlatform.codegen.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        rentingPlatform.codegen.da.internal.template.Archive.valueDecoder().decode(value$),
        value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final ContractCompanion.WithoutKey<Contract, ContractId, InviteArbitrators> COMPANION = 
      new ContractCompanion.WithoutKey<>(
        "rentingPlatform.codegen.platform.modelmi.InviteArbitrators", TEMPLATE_ID, ContractId::new,
        v -> InviteArbitrators.templateValueDecoder().decode(v), InviteArbitrators::fromJson,
        Contract::new, List.of(CHOICE_Accept, CHOICE_Finish, CHOICE_ConfirmAttribution,
        CHOICE_Archive));

  public final String tenant;

  public final String host;

  public final Set<String> invited;

  public final Set<String> confirmed;

  public final MIdetails miDetails;

  public final MIReport.ContractId miReportCid;

  public InviteArbitrators(String tenant, String host, Set<String> invited, Set<String> confirmed,
      MIdetails miDetails, MIReport.ContractId miReportCid) {
    this.tenant = tenant;
    this.host = host;
    this.invited = invited;
    this.confirmed = confirmed;
    this.miDetails = miDetails;
    this.miReportCid = miReportCid;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(InviteArbitrators.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
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
  public Update<Exercised<ContractId>> createAndExerciseAccept(String arbitrator) {
    return createAndExerciseAccept(new Accept(arbitrator));
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseFinish} instead
   */
  @Deprecated
  public Update<Exercised<Unit>> createAndExerciseFinish(Finish arg) {
    return createAnd().exerciseFinish(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseFinish} instead
   */
  @Deprecated
  public Update<Exercised<Unit>> createAndExerciseFinish() {
    return createAndExerciseFinish(new Finish());
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseConfirmAttribution} instead
   */
  @Deprecated
  public Update<Exercised<MIReport.ContractId>> createAndExerciseConfirmAttribution(
      ConfirmAttribution arg) {
    return createAnd().exerciseConfirmAttribution(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseConfirmAttribution} instead
   */
  @Deprecated
  public Update<Exercised<MIReport.ContractId>> createAndExerciseConfirmAttribution(
      String inviter) {
    return createAndExerciseConfirmAttribution(new ConfirmAttribution(inviter));
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

  public static Update<Created<ContractId>> create(String tenant, String host, Set<String> invited,
      Set<String> confirmed, MIdetails miDetails, MIReport.ContractId miReportCid) {
    return new InviteArbitrators(tenant, host, invited, confirmed, miDetails, miReportCid).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithoutKey<Contract, ContractId, InviteArbitrators> getCompanion() {
    return COMPANION;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static InviteArbitrators fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<InviteArbitrators> valueDecoder() throws IllegalArgumentException {
    return ContractCompanion.valueDecoder(COMPANION);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(6);
    fields.add(new DamlRecord.Field("tenant", new Party(this.tenant)));
    fields.add(new DamlRecord.Field("host", new Party(this.host)));
    fields.add(new DamlRecord.Field("invited", this.invited.toValue(v$0 -> new Party(v$0))));
    fields.add(new DamlRecord.Field("confirmed", this.confirmed.toValue(v$0 -> new Party(v$0))));
    fields.add(new DamlRecord.Field("miDetails", this.miDetails.toValue()));
    fields.add(new DamlRecord.Field("miReportCid", this.miReportCid.toValue()));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<InviteArbitrators> templateValueDecoder() throws
      IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(6,0, recordValue$);
      String tenant = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String host = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      Set<String> invited = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(2).getValue());
      Set<String> confirmed = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(3).getValue());
      MIdetails miDetails = MIdetails.valueDecoder().decode(fields$.get(4).getValue());
      MIReport.ContractId miReportCid =
          new MIReport.ContractId(fields$.get(5).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected miReportCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new InviteArbitrators(tenant, host, invited, confirmed, miDetails, miReportCid);
    } ;
  }

  public static JsonLfDecoder<InviteArbitrators> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("tenant", "host", "invited", "confirmed", "miDetails", "miReportCid"), name -> {
          switch (name) {
            case "tenant": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "host": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "invited": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, rentingPlatform.codegen.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "confirmed": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, rentingPlatform.codegen.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "miDetails": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, rentingPlatform.codegen.platform.types.mi.MIdetails.jsonDecoder());
            case "miReportCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(rentingPlatform.codegen.platform.modelmi.MIReport.ContractId::new));
            default: return null;
          }
        }
        , (Object[] args) -> new InviteArbitrators(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5])));
  }

  public static InviteArbitrators fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("tenant", apply(JsonLfEncoders::party, tenant)),
        JsonLfEncoders.Field.of("host", apply(JsonLfEncoders::party, host)),
        JsonLfEncoders.Field.of("invited", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), invited)),
        JsonLfEncoders.Field.of("confirmed", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), confirmed)),
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
    if (!(object instanceof InviteArbitrators)) {
      return false;
    }
    InviteArbitrators other = (InviteArbitrators) object;
    return Objects.equals(this.tenant, other.tenant) && Objects.equals(this.host, other.host) &&
        Objects.equals(this.invited, other.invited) &&
        Objects.equals(this.confirmed, other.confirmed) &&
        Objects.equals(this.miDetails, other.miDetails) &&
        Objects.equals(this.miReportCid, other.miReportCid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.tenant, this.host, this.invited, this.confirmed, this.miDetails,
        this.miReportCid);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.modelmi.InviteArbitrators(%s, %s, %s, %s, %s, %s)",
        this.tenant, this.host, this.invited, this.confirmed, this.miDetails, this.miReportCid);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<InviteArbitrators> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, InviteArbitrators, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public static ContractId fromContractId(
        com.daml.ledger.javaapi.data.codegen.ContractId<InviteArbitrators> contractId) {
      return COMPANION.toContractId(contractId);
    }
  }

  public static class Contract extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, InviteArbitrators> {
    public Contract(ContractId id, InviteArbitrators data, Optional<String> agreementText,
        java.util.Set<String> signatories, java.util.Set<String> observers) {
      super(id, data, agreementText, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, InviteArbitrators> getCompanion() {
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
    default Update<Exercised<ContractId>> exerciseAccept(Accept arg) {
      return makeExerciseCmd(CHOICE_Accept, arg);
    }

    default Update<Exercised<ContractId>> exerciseAccept(String arbitrator) {
      return exerciseAccept(new Accept(arbitrator));
    }

    default Update<Exercised<Unit>> exerciseFinish(Finish arg) {
      return makeExerciseCmd(CHOICE_Finish, arg);
    }

    default Update<Exercised<Unit>> exerciseFinish() {
      return exerciseFinish(new Finish());
    }

    default Update<Exercised<MIReport.ContractId>> exerciseConfirmAttribution(
        ConfirmAttribution arg) {
      return makeExerciseCmd(CHOICE_ConfirmAttribution, arg);
    }

    default Update<Exercised<MIReport.ContractId>> exerciseConfirmAttribution(String inviter) {
      return exerciseConfirmAttribution(new ConfirmAttribution(inviter));
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
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, InviteArbitrators, ?> getCompanion(
        ) {
      return COMPANION;
    }
  }
}

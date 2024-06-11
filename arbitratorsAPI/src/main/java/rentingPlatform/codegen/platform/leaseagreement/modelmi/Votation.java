package rentingPlatform.codegen.platform.leaseagreement.modelmi;

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
import rentingPlatform.codegen.platform.types.mi.Responsability;

public final class Votation extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("4675aeb82c69164a49c2076e977f81eed1ed248ab4cb6bca91f769e1194714b0", "Platform.LeaseAgreement.ModelMI", "Votation");

  public static final Choice<Votation, rentingPlatform.codegen.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        rentingPlatform.codegen.da.internal.template.Archive.valueDecoder().decode(value$),
        value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Votation, Vote, ContractId> CHOICE_Vote = 
      Choice.create("Vote", value$ -> value$.toValue(), value$ -> Vote.valueDecoder()
        .decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Votation, FinalizeVotation, MIresultArbitrators.ContractId> CHOICE_FinalizeVotation = 
      Choice.create("FinalizeVotation", value$ -> value$.toValue(), value$ ->
        FinalizeVotation.valueDecoder().decode(value$), value$ ->
        new MIresultArbitrators.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final ContractCompanion.WithoutKey<Contract, ContractId, Votation> COMPANION = 
      new ContractCompanion.WithoutKey<>(
        "rentingPlatform.codegen.platform.leaseagreement.modelmi.Votation", TEMPLATE_ID,
        ContractId::new, v -> Votation.templateValueDecoder().decode(v), Votation::fromJson,
        Contract::new, List.of(CHOICE_Archive, CHOICE_Vote, CHOICE_FinalizeVotation));

  public final String tenant;

  public final String host;

  public final MIdetails miDetails;

  public final String visitor;

  public final String visitDetails;

  public final Set<String> voters;

  public final MIReport.ContractId miReportCid;

  public final Set<String> alreadyVoted;

  public final AssessmentDetails result;

  public Votation(String tenant, String host, MIdetails miDetails, String visitor,
      String visitDetails, Set<String> voters, MIReport.ContractId miReportCid,
      Set<String> alreadyVoted, AssessmentDetails result) {
    this.tenant = tenant;
    this.host = host;
    this.miDetails = miDetails;
    this.visitor = visitor;
    this.visitDetails = visitDetails;
    this.voters = voters;
    this.miReportCid = miReportCid;
    this.alreadyVoted = alreadyVoted;
    this.result = result;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(Votation.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
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
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseVote} instead
   */
  @Deprecated
  public Update<Exercised<ContractId>> createAndExerciseVote(Vote arg) {
    return createAnd().exerciseVote(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseVote} instead
   */
  @Deprecated
  public Update<Exercised<ContractId>> createAndExerciseVote(String voter, Responsability vote) {
    return createAndExerciseVote(new Vote(voter, vote));
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseFinalizeVotation} instead
   */
  @Deprecated
  public Update<Exercised<MIresultArbitrators.ContractId>> createAndExerciseFinalizeVotation(
      FinalizeVotation arg) {
    return createAnd().exerciseFinalizeVotation(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseFinalizeVotation} instead
   */
  @Deprecated
  public Update<Exercised<MIresultArbitrators.ContractId>> createAndExerciseFinalizeVotation(
      String finalizer) {
    return createAndExerciseFinalizeVotation(new FinalizeVotation(finalizer));
  }

  public static Update<Created<ContractId>> create(String tenant, String host, MIdetails miDetails,
      String visitor, String visitDetails, Set<String> voters, MIReport.ContractId miReportCid,
      Set<String> alreadyVoted, AssessmentDetails result) {
    return new Votation(tenant, host, miDetails, visitor, visitDetails, voters, miReportCid,
        alreadyVoted, result).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithoutKey<Contract, ContractId, Votation> getCompanion() {
    return COMPANION;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Votation fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Votation> valueDecoder() throws IllegalArgumentException {
    return ContractCompanion.valueDecoder(COMPANION);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(9);
    fields.add(new DamlRecord.Field("tenant", new Party(this.tenant)));
    fields.add(new DamlRecord.Field("host", new Party(this.host)));
    fields.add(new DamlRecord.Field("miDetails", this.miDetails.toValue()));
    fields.add(new DamlRecord.Field("visitor", new Party(this.visitor)));
    fields.add(new DamlRecord.Field("visitDetails", new Text(this.visitDetails)));
    fields.add(new DamlRecord.Field("voters", this.voters.toValue(v$0 -> new Party(v$0))));
    fields.add(new DamlRecord.Field("miReportCid", this.miReportCid.toValue()));
    fields.add(new DamlRecord.Field("alreadyVoted", this.alreadyVoted.toValue(v$0 -> new Party(v$0))));
    fields.add(new DamlRecord.Field("result", this.result.toValue()));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<Votation> templateValueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(9,0, recordValue$);
      String tenant = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String host = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      MIdetails miDetails = MIdetails.valueDecoder().decode(fields$.get(2).getValue());
      String visitor = PrimitiveValueDecoders.fromParty.decode(fields$.get(3).getValue());
      String visitDetails = PrimitiveValueDecoders.fromText.decode(fields$.get(4).getValue());
      Set<String> voters = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(5).getValue());
      MIReport.ContractId miReportCid =
          new MIReport.ContractId(fields$.get(6).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected miReportCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      Set<String> alreadyVoted =
          Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(7).getValue());
      AssessmentDetails result = AssessmentDetails.valueDecoder().decode(fields$.get(8).getValue());
      return new Votation(tenant, host, miDetails, visitor, visitDetails, voters, miReportCid,
          alreadyVoted, result);
    } ;
  }

  public static JsonLfDecoder<Votation> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("tenant", "host", "miDetails", "visitor", "visitDetails", "voters", "miReportCid", "alreadyVoted", "result"), name -> {
          switch (name) {
            case "tenant": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "host": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "miDetails": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, rentingPlatform.codegen.platform.types.mi.MIdetails.jsonDecoder());
            case "visitor": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "visitDetails": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "voters": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, rentingPlatform.codegen.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "miReportCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(6, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(rentingPlatform.codegen.platform.leaseagreement.modelmi.MIReport.ContractId::new));
            case "alreadyVoted": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(7, rentingPlatform.codegen.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "result": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(8, rentingPlatform.codegen.platform.types.mi.AssessmentDetails.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new Votation(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5]), JsonLfDecoders.cast(args[6]), JsonLfDecoders.cast(args[7]), JsonLfDecoders.cast(args[8])));
  }

  public static Votation fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("tenant", apply(JsonLfEncoders::party, tenant)),
        JsonLfEncoders.Field.of("host", apply(JsonLfEncoders::party, host)),
        JsonLfEncoders.Field.of("miDetails", apply(MIdetails::jsonEncoder, miDetails)),
        JsonLfEncoders.Field.of("visitor", apply(JsonLfEncoders::party, visitor)),
        JsonLfEncoders.Field.of("visitDetails", apply(JsonLfEncoders::text, visitDetails)),
        JsonLfEncoders.Field.of("voters", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), voters)),
        JsonLfEncoders.Field.of("miReportCid", apply(JsonLfEncoders::contractId, miReportCid)),
        JsonLfEncoders.Field.of("alreadyVoted", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), alreadyVoted)),
        JsonLfEncoders.Field.of("result", apply(AssessmentDetails::jsonEncoder, result)));
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
    if (!(object instanceof Votation)) {
      return false;
    }
    Votation other = (Votation) object;
    return Objects.equals(this.tenant, other.tenant) && Objects.equals(this.host, other.host) &&
        Objects.equals(this.miDetails, other.miDetails) &&
        Objects.equals(this.visitor, other.visitor) &&
        Objects.equals(this.visitDetails, other.visitDetails) &&
        Objects.equals(this.voters, other.voters) &&
        Objects.equals(this.miReportCid, other.miReportCid) &&
        Objects.equals(this.alreadyVoted, other.alreadyVoted) &&
        Objects.equals(this.result, other.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.tenant, this.host, this.miDetails, this.visitor, this.visitDetails,
        this.voters, this.miReportCid, this.alreadyVoted, this.result);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.leaseagreement.modelmi.Votation(%s, %s, %s, %s, %s, %s, %s, %s, %s)",
        this.tenant, this.host, this.miDetails, this.visitor, this.visitDetails, this.voters,
        this.miReportCid, this.alreadyVoted, this.result);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<Votation> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Votation, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public static ContractId fromContractId(
        com.daml.ledger.javaapi.data.codegen.ContractId<Votation> contractId) {
      return COMPANION.toContractId(contractId);
    }
  }

  public static class Contract extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, Votation> {
    public Contract(ContractId id, Votation data, Optional<String> agreementText,
        java.util.Set<String> signatories, java.util.Set<String> observers) {
      super(id, data, agreementText, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, Votation> getCompanion() {
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

    default Update<Exercised<ContractId>> exerciseVote(Vote arg) {
      return makeExerciseCmd(CHOICE_Vote, arg);
    }

    default Update<Exercised<ContractId>> exerciseVote(String voter, Responsability vote) {
      return exerciseVote(new Vote(voter, vote));
    }

    default Update<Exercised<MIresultArbitrators.ContractId>> exerciseFinalizeVotation(
        FinalizeVotation arg) {
      return makeExerciseCmd(CHOICE_FinalizeVotation, arg);
    }

    default Update<Exercised<MIresultArbitrators.ContractId>> exerciseFinalizeVotation(
        String finalizer) {
      return exerciseFinalizeVotation(new FinalizeVotation(finalizer));
    }
  }

  public static final class CreateAnd extends com.daml.ledger.javaapi.data.codegen.CreateAnd implements Exercises<CreateAndExerciseCommand> {
    CreateAnd(Template createArguments) {
      super(createArguments);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Votation, ?> getCompanion(
        ) {
      return COMPANION;
    }
  }
}

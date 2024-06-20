package rentingPlatform.codegen.platform.leaseagreement.modelmi;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.ContractFilter;
import com.daml.ledger.javaapi.data.CreateAndExerciseCommand;
import com.daml.ledger.javaapi.data.CreateCommand;
import com.daml.ledger.javaapi.data.CreatedEvent;
import com.daml.ledger.javaapi.data.DamlCollectors;
import com.daml.ledger.javaapi.data.DamlRecord;
import com.daml.ledger.javaapi.data.Date;
import com.daml.ledger.javaapi.data.ExerciseCommand;
import com.daml.ledger.javaapi.data.Identifier;
import com.daml.ledger.javaapi.data.Int64;
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
import rentingPlatform.codegen.platform.types.mi.MIdetails;
import rentingPlatform.codegen.platform.types.mi.Responsability;

public final class Votation extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("08537584ed7a5356973a2deba7db786c7576354638ad57dfcafbaad6c1c125a5", "Platform.LeaseAgreement.ModelMI", "Votation");

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

  public final LocalDate assessmentDate;

  public final LocalDate reparationDate;

  public final Long cost;

  public final Set<String> voters;

  public final MIReport.ContractId miReportCid;

  public final Set<String> alreadyVoted;

  public final List<Responsability> votes;

  public Votation(String tenant, String host, MIdetails miDetails, String visitor,
      String visitDetails, LocalDate assessmentDate, LocalDate reparationDate, Long cost,
      Set<String> voters, MIReport.ContractId miReportCid, Set<String> alreadyVoted,
      List<Responsability> votes) {
    this.tenant = tenant;
    this.host = host;
    this.miDetails = miDetails;
    this.visitor = visitor;
    this.visitDetails = visitDetails;
    this.assessmentDate = assessmentDate;
    this.reparationDate = reparationDate;
    this.cost = cost;
    this.voters = voters;
    this.miReportCid = miReportCid;
    this.alreadyVoted = alreadyVoted;
    this.votes = votes;
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
      String visitor, String visitDetails, LocalDate assessmentDate, LocalDate reparationDate,
      Long cost, Set<String> voters, MIReport.ContractId miReportCid, Set<String> alreadyVoted,
      List<Responsability> votes) {
    return new Votation(tenant, host, miDetails, visitor, visitDetails, assessmentDate,
        reparationDate, cost, voters, miReportCid, alreadyVoted, votes).create();
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
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(12);
    fields.add(new DamlRecord.Field("tenant", new Party(this.tenant)));
    fields.add(new DamlRecord.Field("host", new Party(this.host)));
    fields.add(new DamlRecord.Field("miDetails", this.miDetails.toValue()));
    fields.add(new DamlRecord.Field("visitor", new Party(this.visitor)));
    fields.add(new DamlRecord.Field("visitDetails", new Text(this.visitDetails)));
    fields.add(new DamlRecord.Field("assessmentDate", new Date((int) this.assessmentDate.toEpochDay())));
    fields.add(new DamlRecord.Field("reparationDate", new Date((int) this.reparationDate.toEpochDay())));
    fields.add(new DamlRecord.Field("cost", new Int64(this.cost)));
    fields.add(new DamlRecord.Field("voters", this.voters.toValue(v$0 -> new Party(v$0))));
    fields.add(new DamlRecord.Field("miReportCid", this.miReportCid.toValue()));
    fields.add(new DamlRecord.Field("alreadyVoted", this.alreadyVoted.toValue(v$0 -> new Party(v$0))));
    fields.add(new DamlRecord.Field("votes", this.votes.stream().collect(DamlCollectors.toDamlList(v$0 -> v$0.toValue()))));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<Votation> templateValueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(12,0, recordValue$);
      String tenant = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String host = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      MIdetails miDetails = MIdetails.valueDecoder().decode(fields$.get(2).getValue());
      String visitor = PrimitiveValueDecoders.fromParty.decode(fields$.get(3).getValue());
      String visitDetails = PrimitiveValueDecoders.fromText.decode(fields$.get(4).getValue());
      LocalDate assessmentDate = PrimitiveValueDecoders.fromDate.decode(fields$.get(5).getValue());
      LocalDate reparationDate = PrimitiveValueDecoders.fromDate.decode(fields$.get(6).getValue());
      Long cost = PrimitiveValueDecoders.fromInt64.decode(fields$.get(7).getValue());
      Set<String> voters = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(8).getValue());
      MIReport.ContractId miReportCid =
          new MIReport.ContractId(fields$.get(9).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected miReportCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      Set<String> alreadyVoted =
          Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(10).getValue());
      List<Responsability> votes = PrimitiveValueDecoders.fromList(Responsability.valueDecoder())
          .decode(fields$.get(11).getValue());
      return new Votation(tenant, host, miDetails, visitor, visitDetails, assessmentDate,
          reparationDate, cost, voters, miReportCid, alreadyVoted, votes);
    } ;
  }

  public static JsonLfDecoder<Votation> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("tenant", "host", "miDetails", "visitor", "visitDetails", "assessmentDate", "reparationDate", "cost", "voters", "miReportCid", "alreadyVoted", "votes"), name -> {
          switch (name) {
            case "tenant": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "host": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "miDetails": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, rentingPlatform.codegen.platform.types.mi.MIdetails.jsonDecoder());
            case "visitor": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "visitDetails": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "assessmentDate": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.date);
            case "reparationDate": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(6, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.date);
            case "cost": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(7, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "voters": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(8, rentingPlatform.codegen.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "miReportCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(9, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(rentingPlatform.codegen.platform.leaseagreement.modelmi.MIReport.ContractId::new));
            case "alreadyVoted": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(10, rentingPlatform.codegen.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "votes": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(11, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(rentingPlatform.codegen.platform.types.mi.Responsability.jsonDecoder()));
            default: return null;
          }
        }
        , (Object[] args) -> new Votation(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5]), JsonLfDecoders.cast(args[6]), JsonLfDecoders.cast(args[7]), JsonLfDecoders.cast(args[8]), JsonLfDecoders.cast(args[9]), JsonLfDecoders.cast(args[10]), JsonLfDecoders.cast(args[11])));
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
        JsonLfEncoders.Field.of("assessmentDate", apply(JsonLfEncoders::date, assessmentDate)),
        JsonLfEncoders.Field.of("reparationDate", apply(JsonLfEncoders::date, reparationDate)),
        JsonLfEncoders.Field.of("cost", apply(JsonLfEncoders::int64, cost)),
        JsonLfEncoders.Field.of("voters", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), voters)),
        JsonLfEncoders.Field.of("miReportCid", apply(JsonLfEncoders::contractId, miReportCid)),
        JsonLfEncoders.Field.of("alreadyVoted", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), alreadyVoted)),
        JsonLfEncoders.Field.of("votes", apply(JsonLfEncoders.list(Responsability::jsonEncoder), votes)));
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
        Objects.equals(this.assessmentDate, other.assessmentDate) &&
        Objects.equals(this.reparationDate, other.reparationDate) &&
        Objects.equals(this.cost, other.cost) && Objects.equals(this.voters, other.voters) &&
        Objects.equals(this.miReportCid, other.miReportCid) &&
        Objects.equals(this.alreadyVoted, other.alreadyVoted) &&
        Objects.equals(this.votes, other.votes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.tenant, this.host, this.miDetails, this.visitor, this.visitDetails,
        this.assessmentDate, this.reparationDate, this.cost, this.voters, this.miReportCid,
        this.alreadyVoted, this.votes);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.leaseagreement.modelmi.Votation(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)",
        this.tenant, this.host, this.miDetails, this.visitor, this.visitDetails,
        this.assessmentDate, this.reparationDate, this.cost, this.voters, this.miReportCid,
        this.alreadyVoted, this.votes);
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

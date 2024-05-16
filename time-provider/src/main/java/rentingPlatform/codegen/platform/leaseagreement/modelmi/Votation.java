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
import rentingPlatform.codegen.interface$.types.AssessmentDetails;
import rentingPlatform.codegen.interface$.types.MIkey;
import rentingPlatform.codegen.interface$.types.Responsability;

public final class Votation extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("3ab0b0842cdffab8c416d02894ad44bcc570eeb048f996af3c2257fb08640ba3", "Platform.LeaseAgreement.ModelMI", "Votation");

  public static final Choice<Votation, Vote, ContractId> CHOICE_Vote = 
      Choice.create("Vote", value$ -> value$.toValue(), value$ -> Vote.valueDecoder()
        .decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Votation, FinalizeVotation, MI.ContractId> CHOICE_FinalizeVotation = 
      Choice.create("FinalizeVotation", value$ -> value$.toValue(), value$ ->
        FinalizeVotation.valueDecoder().decode(value$), value$ ->
        new MI.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Votation, rentingPlatform.codegen.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        rentingPlatform.codegen.da.internal.template.Archive.valueDecoder().decode(value$),
        value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final ContractCompanion.WithoutKey<Contract, ContractId, Votation> COMPANION = 
      new ContractCompanion.WithoutKey<>(
        "rentingPlatform.codegen.platform.leaseagreement.modelmi.Votation", TEMPLATE_ID,
        ContractId::new, v -> Votation.templateValueDecoder().decode(v), Votation::fromJson,
        Contract::new, List.of(CHOICE_Vote, CHOICE_FinalizeVotation, CHOICE_Archive));

  public final String creator;

  public final String description;

  public final Set<String> voters;

  public final MIkey miKey;

  public final Set<String> alreadyVoted;

  public final AssessmentDetails result;

  public Votation(String creator, String description, Set<String> voters, MIkey miKey,
      Set<String> alreadyVoted, AssessmentDetails result) {
    this.creator = creator;
    this.description = description;
    this.voters = voters;
    this.miKey = miKey;
    this.alreadyVoted = alreadyVoted;
    this.result = result;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(Votation.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
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
  public Update<Exercised<MI.ContractId>> createAndExerciseFinalizeVotation(FinalizeVotation arg) {
    return createAnd().exerciseFinalizeVotation(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseFinalizeVotation} instead
   */
  @Deprecated
  public Update<Exercised<MI.ContractId>> createAndExerciseFinalizeVotation(String finalizer) {
    return createAndExerciseFinalizeVotation(new FinalizeVotation(finalizer));
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

  public static Update<Created<ContractId>> create(String creator, String description,
      Set<String> voters, MIkey miKey, Set<String> alreadyVoted, AssessmentDetails result) {
    return new Votation(creator, description, voters, miKey, alreadyVoted, result).create();
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
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(6);
    fields.add(new DamlRecord.Field("creator", new Party(this.creator)));
    fields.add(new DamlRecord.Field("description", new Text(this.description)));
    fields.add(new DamlRecord.Field("voters", this.voters.toValue(v$0 -> new Party(v$0))));
    fields.add(new DamlRecord.Field("miKey", this.miKey.toValue()));
    fields.add(new DamlRecord.Field("alreadyVoted", this.alreadyVoted.toValue(v$0 -> new Party(v$0))));
    fields.add(new DamlRecord.Field("result", this.result.toValue()));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<Votation> templateValueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(6,0, recordValue$);
      String creator = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String description = PrimitiveValueDecoders.fromText.decode(fields$.get(1).getValue());
      Set<String> voters = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(2).getValue());
      MIkey miKey = MIkey.valueDecoder().decode(fields$.get(3).getValue());
      Set<String> alreadyVoted =
          Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(4).getValue());
      AssessmentDetails result = AssessmentDetails.valueDecoder().decode(fields$.get(5).getValue());
      return new Votation(creator, description, voters, miKey, alreadyVoted, result);
    } ;
  }

  public static JsonLfDecoder<Votation> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("creator", "description", "voters", "miKey", "alreadyVoted", "result"), name -> {
          switch (name) {
            case "creator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "description": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "voters": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, rentingPlatform.codegen.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "miKey": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, rentingPlatform.codegen.interface$.types.MIkey.jsonDecoder());
            case "alreadyVoted": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, rentingPlatform.codegen.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "result": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, rentingPlatform.codegen.interface$.types.AssessmentDetails.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new Votation(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5])));
  }

  public static Votation fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("creator", apply(JsonLfEncoders::party, creator)),
        JsonLfEncoders.Field.of("description", apply(JsonLfEncoders::text, description)),
        JsonLfEncoders.Field.of("voters", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), voters)),
        JsonLfEncoders.Field.of("miKey", apply(MIkey::jsonEncoder, miKey)),
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
    return Objects.equals(this.creator, other.creator) &&
        Objects.equals(this.description, other.description) &&
        Objects.equals(this.voters, other.voters) && Objects.equals(this.miKey, other.miKey) &&
        Objects.equals(this.alreadyVoted, other.alreadyVoted) &&
        Objects.equals(this.result, other.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.creator, this.description, this.voters, this.miKey, this.alreadyVoted,
        this.result);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.leaseagreement.modelmi.Votation(%s, %s, %s, %s, %s, %s)",
        this.creator, this.description, this.voters, this.miKey, this.alreadyVoted, this.result);
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
    default Update<Exercised<ContractId>> exerciseVote(Vote arg) {
      return makeExerciseCmd(CHOICE_Vote, arg);
    }

    default Update<Exercised<ContractId>> exerciseVote(String voter, Responsability vote) {
      return exerciseVote(new Vote(voter, vote));
    }

    default Update<Exercised<MI.ContractId>> exerciseFinalizeVotation(FinalizeVotation arg) {
      return makeExerciseCmd(CHOICE_FinalizeVotation, arg);
    }

    default Update<Exercised<MI.ContractId>> exerciseFinalizeVotation(String finalizer) {
      return exerciseFinalizeVotation(new FinalizeVotation(finalizer));
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
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Votation, ?> getCompanion(
        ) {
      return COMPANION;
    }
  }
}

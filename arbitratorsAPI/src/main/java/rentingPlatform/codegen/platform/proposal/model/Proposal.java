package rentingPlatform.codegen.platform.proposal.model;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.ContractFilter;
import com.daml.ledger.javaapi.data.CreateAndExerciseCommand;
import com.daml.ledger.javaapi.data.CreateCommand;
import com.daml.ledger.javaapi.data.CreatedEvent;
import com.daml.ledger.javaapi.data.DamlCollectors;
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
import java.util.Set;
import rentingPlatform.codegen.platform.leaseagreement.service.Request;
import rentingPlatform.codegen.platform.types.common.House;
import rentingPlatform.codegen.platform.types.common.LeaseTerms;

public final class Proposal extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("b1c69ded5e6f9b3209adda4613b08585e35d988f49cc818e5af8942f840887f7", "Platform.Proposal.Model", "Proposal");

  public static final Choice<Proposal, Sign, ContractId> CHOICE_Sign = 
      Choice.create("Sign", value$ -> value$.toValue(), value$ -> Sign.valueDecoder()
        .decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Proposal, RequestLeaseAgreement, Request.ContractId> CHOICE_RequestLeaseAgreement = 
      Choice.create("RequestLeaseAgreement", value$ -> value$.toValue(), value$ ->
        RequestLeaseAgreement.valueDecoder().decode(value$), value$ ->
        new Request.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Proposal, rentingPlatform.codegen.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        rentingPlatform.codegen.da.internal.template.Archive.valueDecoder().decode(value$),
        value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final ContractCompanion.WithoutKey<Contract, ContractId, Proposal> COMPANION = 
      new ContractCompanion.WithoutKey<>("rentingPlatform.codegen.platform.proposal.model.Proposal",
        TEMPLATE_ID, ContractId::new, v -> Proposal.templateValueDecoder().decode(v),
        Proposal::fromJson, Contract::new, List.of(CHOICE_Sign, CHOICE_RequestLeaseAgreement,
        CHOICE_Archive));

  public final String proposer;

  public final House house;

  public final LeaseTerms leaseTerms;

  public final List<String> alreadySigned;

  public Proposal(String proposer, House house, LeaseTerms leaseTerms, List<String> alreadySigned) {
    this.proposer = proposer;
    this.house = house;
    this.leaseTerms = leaseTerms;
    this.alreadySigned = alreadySigned;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(Proposal.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseSign} instead
   */
  @Deprecated
  public Update<Exercised<ContractId>> createAndExerciseSign(Sign arg) {
    return createAnd().exerciseSign(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseSign} instead
   */
  @Deprecated
  public Update<Exercised<ContractId>> createAndExerciseSign(String signer) {
    return createAndExerciseSign(new Sign(signer));
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseRequestLeaseAgreement} instead
   */
  @Deprecated
  public Update<Exercised<Request.ContractId>> createAndExerciseRequestLeaseAgreement(
      RequestLeaseAgreement arg) {
    return createAnd().exerciseRequestLeaseAgreement(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseRequestLeaseAgreement} instead
   */
  @Deprecated
  public Update<Exercised<Request.ContractId>> createAndExerciseRequestLeaseAgreement(String signer,
      String operator) {
    return createAndExerciseRequestLeaseAgreement(new RequestLeaseAgreement(signer, operator));
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

  public static Update<Created<ContractId>> create(String proposer, House house,
      LeaseTerms leaseTerms, List<String> alreadySigned) {
    return new Proposal(proposer, house, leaseTerms, alreadySigned).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithoutKey<Contract, ContractId, Proposal> getCompanion() {
    return COMPANION;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Proposal fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Proposal> valueDecoder() throws IllegalArgumentException {
    return ContractCompanion.valueDecoder(COMPANION);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(4);
    fields.add(new DamlRecord.Field("proposer", new Party(this.proposer)));
    fields.add(new DamlRecord.Field("house", this.house.toValue()));
    fields.add(new DamlRecord.Field("leaseTerms", this.leaseTerms.toValue()));
    fields.add(new DamlRecord.Field("alreadySigned", this.alreadySigned.stream().collect(DamlCollectors.toDamlList(v$0 -> new Party(v$0)))));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<Proposal> templateValueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(4,0, recordValue$);
      String proposer = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      House house = House.valueDecoder().decode(fields$.get(1).getValue());
      LeaseTerms leaseTerms = LeaseTerms.valueDecoder().decode(fields$.get(2).getValue());
      List<String> alreadySigned = PrimitiveValueDecoders.fromList(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(3).getValue());
      return new Proposal(proposer, house, leaseTerms, alreadySigned);
    } ;
  }

  public static JsonLfDecoder<Proposal> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("proposer", "house", "leaseTerms", "alreadySigned"), name -> {
          switch (name) {
            case "proposer": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "house": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, rentingPlatform.codegen.platform.types.common.House.jsonDecoder());
            case "leaseTerms": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, rentingPlatform.codegen.platform.types.common.LeaseTerms.jsonDecoder());
            case "alreadySigned": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            default: return null;
          }
        }
        , (Object[] args) -> new Proposal(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3])));
  }

  public static Proposal fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("proposer", apply(JsonLfEncoders::party, proposer)),
        JsonLfEncoders.Field.of("house", apply(House::jsonEncoder, house)),
        JsonLfEncoders.Field.of("leaseTerms", apply(LeaseTerms::jsonEncoder, leaseTerms)),
        JsonLfEncoders.Field.of("alreadySigned", apply(JsonLfEncoders.list(JsonLfEncoders::party), alreadySigned)));
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
    if (!(object instanceof Proposal)) {
      return false;
    }
    Proposal other = (Proposal) object;
    return Objects.equals(this.proposer, other.proposer) &&
        Objects.equals(this.house, other.house) &&
        Objects.equals(this.leaseTerms, other.leaseTerms) &&
        Objects.equals(this.alreadySigned, other.alreadySigned);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.proposer, this.house, this.leaseTerms, this.alreadySigned);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.proposal.model.Proposal(%s, %s, %s, %s)",
        this.proposer, this.house, this.leaseTerms, this.alreadySigned);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<Proposal> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Proposal, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public static ContractId fromContractId(
        com.daml.ledger.javaapi.data.codegen.ContractId<Proposal> contractId) {
      return COMPANION.toContractId(contractId);
    }
  }

  public static class Contract extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, Proposal> {
    public Contract(ContractId id, Proposal data, Optional<String> agreementText,
        Set<String> signatories, Set<String> observers) {
      super(id, data, agreementText, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, Proposal> getCompanion() {
      return COMPANION;
    }

    public static Contract fromIdAndRecord(String contractId, DamlRecord record$,
        Optional<String> agreementText, Set<String> signatories, Set<String> observers) {
      return COMPANION.fromIdAndRecord(contractId, record$, agreementText, signatories, observers);
    }

    public static Contract fromCreatedEvent(CreatedEvent event) {
      return COMPANION.fromCreatedEvent(event);
    }
  }

  public interface Exercises<Cmd> extends com.daml.ledger.javaapi.data.codegen.Exercises.Archive<Cmd> {
    default Update<Exercised<ContractId>> exerciseSign(Sign arg) {
      return makeExerciseCmd(CHOICE_Sign, arg);
    }

    default Update<Exercised<ContractId>> exerciseSign(String signer) {
      return exerciseSign(new Sign(signer));
    }

    default Update<Exercised<Request.ContractId>> exerciseRequestLeaseAgreement(
        RequestLeaseAgreement arg) {
      return makeExerciseCmd(CHOICE_RequestLeaseAgreement, arg);
    }

    default Update<Exercised<Request.ContractId>> exerciseRequestLeaseAgreement(String signer,
        String operator) {
      return exerciseRequestLeaseAgreement(new RequestLeaseAgreement(signer, operator));
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
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Proposal, ?> getCompanion(
        ) {
      return COMPANION;
    }
  }
}

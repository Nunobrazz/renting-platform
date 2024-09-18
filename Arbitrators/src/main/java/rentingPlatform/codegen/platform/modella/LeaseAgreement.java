package rentingPlatform.codegen.platform.modella;

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
import rentingPlatform.codegen.platform.modelmi.AmicableAssessment;
import rentingPlatform.codegen.platform.modelmi.AvailableArbitrators;
import rentingPlatform.codegen.platform.modelmi.InviteArbitrators;
import rentingPlatform.codegen.platform.modelmi.MIReport;
import rentingPlatform.codegen.platform.modelmi.MIresultAmicable;
import rentingPlatform.codegen.platform.types.common.House;
import rentingPlatform.codegen.platform.types.common.LeaseTerms;
import rentingPlatform.codegen.platform.types.la.LAkey;
import rentingPlatform.codegen.platform.types.mi.AssessmentDetails;
import rentingPlatform.codegen.time.clock.DateClockUpdateEvent;

public final class LeaseAgreement extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("bef0965dc38d518ab3f749ea7cce7cf9cd13acb7b593b5f936707edcb2f1eff5", "Platform.ModelLA", "LeaseAgreement");

  public static final Choice<LeaseAgreement, AcceptAssessment, MIresultAmicable.ContractId> CHOICE_AcceptAssessment = 
      Choice.create("AcceptAssessment", value$ -> value$.toValue(), value$ ->
        AcceptAssessment.valueDecoder().decode(value$), value$ ->
        new MIresultAmicable.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<LeaseAgreement, CreateMI, MIReport.ContractId> CHOICE_CreateMI = 
      Choice.create("CreateMI", value$ -> value$.toValue(), value$ -> CreateMI.valueDecoder()
        .decode(value$), value$ ->
        new MIReport.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<LeaseAgreement, ProcessPayment, ContractId> CHOICE_ProcessPayment = 
      Choice.create("ProcessPayment", value$ -> value$.toValue(), value$ ->
        ProcessPayment.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<LeaseAgreement, InvokeArbitrators, InviteArbitrators.ContractId> CHOICE_InvokeArbitrators = 
      Choice.create("InvokeArbitrators", value$ -> value$.toValue(), value$ ->
        InvokeArbitrators.valueDecoder().decode(value$), value$ ->
        new InviteArbitrators.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<LeaseAgreement, rentingPlatform.codegen.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        rentingPlatform.codegen.da.internal.template.Archive.valueDecoder().decode(value$),
        value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<LeaseAgreement, SubmitAssessment, AmicableAssessment.ContractId> CHOICE_SubmitAssessment = 
      Choice.create("SubmitAssessment", value$ -> value$.toValue(), value$ ->
        SubmitAssessment.valueDecoder().decode(value$), value$ ->
        new AmicableAssessment.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final ContractCompanion.WithKey<Contract, ContractId, LeaseAgreement, LAkey> COMPANION = 
      new ContractCompanion.WithKey<>("rentingPlatform.codegen.platform.modella.LeaseAgreement",
        TEMPLATE_ID, ContractId::new, v -> LeaseAgreement.templateValueDecoder().decode(v),
        LeaseAgreement::fromJson, Contract::new, List.of(CHOICE_InvokeArbitrators,
        CHOICE_ProcessPayment, CHOICE_AcceptAssessment, CHOICE_SubmitAssessment, CHOICE_Archive,
        CHOICE_CreateMI), e -> LAkey.valueDecoder().decode(e));

  public final String operator;

  public final String lifecycler;

  public final String tenant;

  public final House house;

  public final LeaseTerms leaseTerms;

  public final List<LocalDate> paymentsToProcess;

  public final LAkey laKey;

  public LeaseAgreement(String operator, String lifecycler, String tenant, House house,
      LeaseTerms leaseTerms, List<LocalDate> paymentsToProcess, LAkey laKey) {
    this.operator = operator;
    this.lifecycler = lifecycler;
    this.tenant = tenant;
    this.house = house;
    this.leaseTerms = leaseTerms;
    this.paymentsToProcess = paymentsToProcess;
    this.laKey = laKey;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(LeaseAgreement.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseAcceptAssessment} instead
   */
  @Deprecated
  public static Update<Exercised<MIresultAmicable.ContractId>> exerciseByKeyAcceptAssessment(
      LAkey key, AcceptAssessment arg) {
    return byKey(key).exerciseAcceptAssessment(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseAcceptAssessment(signer,
      assessmentCid)} instead
   */
  @Deprecated
  public static Update<Exercised<MIresultAmicable.ContractId>> exerciseByKeyAcceptAssessment(
      LAkey key, String signer, AmicableAssessment.ContractId assessmentCid) {
    return byKey(key).exerciseAcceptAssessment(signer, assessmentCid);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseCreateMI} instead
   */
  @Deprecated
  public static Update<Exercised<MIReport.ContractId>> exerciseByKeyCreateMI(LAkey key,
      CreateMI arg) {
    return byKey(key).exerciseCreateMI(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseCreateMI(reporter, house,
      description, startingDate)} instead
   */
  @Deprecated
  public static Update<Exercised<MIReport.ContractId>> exerciseByKeyCreateMI(LAkey key,
      String reporter, House house, String description, LocalDate startingDate) {
    return byKey(key).exerciseCreateMI(reporter, house, description, startingDate);
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
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseProcessPayment(eventCid)} instead
   */
  @Deprecated
  public static Update<Exercised<ContractId>> exerciseByKeyProcessPayment(LAkey key,
      DateClockUpdateEvent.ContractId eventCid) {
    return byKey(key).exerciseProcessPayment(eventCid);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseInvokeArbitrators} instead
   */
  @Deprecated
  public static Update<Exercised<InviteArbitrators.ContractId>> exerciseByKeyInvokeArbitrators(
      LAkey key, InvokeArbitrators arg) {
    return byKey(key).exerciseInvokeArbitrators(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseInvokeArbitrators(inviter,
      availableArbitratorsCid, miReportCid)} instead
   */
  @Deprecated
  public static Update<Exercised<InviteArbitrators.ContractId>> exerciseByKeyInvokeArbitrators(
      LAkey key, String inviter, AvailableArbitrators.ContractId availableArbitratorsCid,
      MIReport.ContractId miReportCid) {
    return byKey(key).exerciseInvokeArbitrators(inviter, availableArbitratorsCid, miReportCid);
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
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseSubmitAssessment} instead
   */
  @Deprecated
  public static Update<Exercised<AmicableAssessment.ContractId>> exerciseByKeySubmitAssessment(
      LAkey key, SubmitAssessment arg) {
    return byKey(key).exerciseSubmitAssessment(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseSubmitAssessment(creator,
      assessment, miReportCid)} instead
   */
  @Deprecated
  public static Update<Exercised<AmicableAssessment.ContractId>> exerciseByKeySubmitAssessment(
      LAkey key, String creator, AssessmentDetails assessment, MIReport.ContractId miReportCid) {
    return byKey(key).exerciseSubmitAssessment(creator, assessment, miReportCid);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseAcceptAssessment} instead
   */
  @Deprecated
  public Update<Exercised<MIresultAmicable.ContractId>> createAndExerciseAcceptAssessment(
      AcceptAssessment arg) {
    return createAnd().exerciseAcceptAssessment(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseAcceptAssessment} instead
   */
  @Deprecated
  public Update<Exercised<MIresultAmicable.ContractId>> createAndExerciseAcceptAssessment(
      String signer, AmicableAssessment.ContractId assessmentCid) {
    return createAndExerciseAcceptAssessment(new AcceptAssessment(signer, assessmentCid));
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseCreateMI} instead
   */
  @Deprecated
  public Update<Exercised<MIReport.ContractId>> createAndExerciseCreateMI(CreateMI arg) {
    return createAnd().exerciseCreateMI(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseCreateMI} instead
   */
  @Deprecated
  public Update<Exercised<MIReport.ContractId>> createAndExerciseCreateMI(String reporter,
      House house, String description, LocalDate startingDate) {
    return createAndExerciseCreateMI(new CreateMI(reporter, house, description, startingDate));
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
  public Update<Exercised<ContractId>> createAndExerciseProcessPayment(
      DateClockUpdateEvent.ContractId eventCid) {
    return createAndExerciseProcessPayment(new ProcessPayment(eventCid));
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseInvokeArbitrators} instead
   */
  @Deprecated
  public Update<Exercised<InviteArbitrators.ContractId>> createAndExerciseInvokeArbitrators(
      InvokeArbitrators arg) {
    return createAnd().exerciseInvokeArbitrators(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseInvokeArbitrators} instead
   */
  @Deprecated
  public Update<Exercised<InviteArbitrators.ContractId>> createAndExerciseInvokeArbitrators(
      String inviter, AvailableArbitrators.ContractId availableArbitratorsCid,
      MIReport.ContractId miReportCid) {
    return createAndExerciseInvokeArbitrators(new InvokeArbitrators(inviter,
        availableArbitratorsCid, miReportCid));
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
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseSubmitAssessment} instead
   */
  @Deprecated
  public Update<Exercised<AmicableAssessment.ContractId>> createAndExerciseSubmitAssessment(
      SubmitAssessment arg) {
    return createAnd().exerciseSubmitAssessment(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseSubmitAssessment} instead
   */
  @Deprecated
  public Update<Exercised<AmicableAssessment.ContractId>> createAndExerciseSubmitAssessment(
      String creator, AssessmentDetails assessment, MIReport.ContractId miReportCid) {
    return createAndExerciseSubmitAssessment(new SubmitAssessment(creator, assessment,
        miReportCid));
  }

  public static Update<Created<ContractId>> create(String operator, String lifecycler,
      String tenant, House house, LeaseTerms leaseTerms, List<LocalDate> paymentsToProcess,
      LAkey laKey) {
    return new LeaseAgreement(operator, lifecycler, tenant, house, leaseTerms, paymentsToProcess,
        laKey).create();
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
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(7);
    fields.add(new DamlRecord.Field("operator", new Party(this.operator)));
    fields.add(new DamlRecord.Field("lifecycler", new Party(this.lifecycler)));
    fields.add(new DamlRecord.Field("tenant", new Party(this.tenant)));
    fields.add(new DamlRecord.Field("house", this.house.toValue()));
    fields.add(new DamlRecord.Field("leaseTerms", this.leaseTerms.toValue()));
    fields.add(new DamlRecord.Field("paymentsToProcess", this.paymentsToProcess.stream().collect(DamlCollectors.toDamlList(v$0 -> new Date((int) v$0.toEpochDay())))));
    fields.add(new DamlRecord.Field("laKey", this.laKey.toValue()));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<LeaseAgreement> templateValueDecoder() throws
      IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(7,0, recordValue$);
      String operator = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String lifecycler = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      String tenant = PrimitiveValueDecoders.fromParty.decode(fields$.get(2).getValue());
      House house = House.valueDecoder().decode(fields$.get(3).getValue());
      LeaseTerms leaseTerms = LeaseTerms.valueDecoder().decode(fields$.get(4).getValue());
      List<LocalDate> paymentsToProcess = PrimitiveValueDecoders.fromList(
            PrimitiveValueDecoders.fromDate).decode(fields$.get(5).getValue());
      LAkey laKey = LAkey.valueDecoder().decode(fields$.get(6).getValue());
      return new LeaseAgreement(operator, lifecycler, tenant, house, leaseTerms, paymentsToProcess,
          laKey);
    } ;
  }

  public static JsonLfDecoder<LeaseAgreement> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("operator", "lifecycler", "tenant", "house", "leaseTerms", "paymentsToProcess", "laKey"), name -> {
          switch (name) {
            case "operator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "lifecycler": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "tenant": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "house": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, rentingPlatform.codegen.platform.types.common.House.jsonDecoder());
            case "leaseTerms": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, rentingPlatform.codegen.platform.types.common.LeaseTerms.jsonDecoder());
            case "paymentsToProcess": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.date));
            case "laKey": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(6, rentingPlatform.codegen.platform.types.la.LAkey.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new LeaseAgreement(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5]), JsonLfDecoders.cast(args[6])));
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
        JsonLfEncoders.Field.of("paymentsToProcess", apply(JsonLfEncoders.list(JsonLfEncoders::date), paymentsToProcess)),
        JsonLfEncoders.Field.of("laKey", apply(LAkey::jsonEncoder, laKey)));
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
        Objects.equals(this.paymentsToProcess, other.paymentsToProcess) &&
        Objects.equals(this.laKey, other.laKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.operator, this.lifecycler, this.tenant, this.house, this.leaseTerms,
        this.paymentsToProcess, this.laKey);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.modella.LeaseAgreement(%s, %s, %s, %s, %s, %s, %s)",
        this.operator, this.lifecycler, this.tenant, this.house, this.leaseTerms,
        this.paymentsToProcess, this.laKey);
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
    default Update<Exercised<MIresultAmicable.ContractId>> exerciseAcceptAssessment(
        AcceptAssessment arg) {
      return makeExerciseCmd(CHOICE_AcceptAssessment, arg);
    }

    default Update<Exercised<MIresultAmicable.ContractId>> exerciseAcceptAssessment(String signer,
        AmicableAssessment.ContractId assessmentCid) {
      return exerciseAcceptAssessment(new AcceptAssessment(signer, assessmentCid));
    }

    default Update<Exercised<MIReport.ContractId>> exerciseCreateMI(CreateMI arg) {
      return makeExerciseCmd(CHOICE_CreateMI, arg);
    }

    default Update<Exercised<MIReport.ContractId>> exerciseCreateMI(String reporter, House house,
        String description, LocalDate startingDate) {
      return exerciseCreateMI(new CreateMI(reporter, house, description, startingDate));
    }

    default Update<Exercised<ContractId>> exerciseProcessPayment(ProcessPayment arg) {
      return makeExerciseCmd(CHOICE_ProcessPayment, arg);
    }

    default Update<Exercised<ContractId>> exerciseProcessPayment(
        DateClockUpdateEvent.ContractId eventCid) {
      return exerciseProcessPayment(new ProcessPayment(eventCid));
    }

    default Update<Exercised<InviteArbitrators.ContractId>> exerciseInvokeArbitrators(
        InvokeArbitrators arg) {
      return makeExerciseCmd(CHOICE_InvokeArbitrators, arg);
    }

    default Update<Exercised<InviteArbitrators.ContractId>> exerciseInvokeArbitrators(
        String inviter, AvailableArbitrators.ContractId availableArbitratorsCid,
        MIReport.ContractId miReportCid) {
      return exerciseInvokeArbitrators(new InvokeArbitrators(inviter, availableArbitratorsCid,
          miReportCid));
    }

    default Update<Exercised<Unit>> exerciseArchive(
        rentingPlatform.codegen.da.internal.template.Archive arg) {
      return makeExerciseCmd(CHOICE_Archive, arg);
    }

    default Update<Exercised<Unit>> exerciseArchive() {
      return exerciseArchive(new rentingPlatform.codegen.da.internal.template.Archive());
    }

    default Update<Exercised<AmicableAssessment.ContractId>> exerciseSubmitAssessment(
        SubmitAssessment arg) {
      return makeExerciseCmd(CHOICE_SubmitAssessment, arg);
    }

    default Update<Exercised<AmicableAssessment.ContractId>> exerciseSubmitAssessment(
        String creator, AssessmentDetails assessment, MIReport.ContractId miReportCid) {
      return exerciseSubmitAssessment(new SubmitAssessment(creator, assessment, miReportCid));
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

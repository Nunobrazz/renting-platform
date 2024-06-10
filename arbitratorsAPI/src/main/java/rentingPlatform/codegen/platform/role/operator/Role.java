package rentingPlatform.codegen.platform.role.operator;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

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
import rentingPlatform.codegen.platform.proposal.service.Request;
import rentingPlatform.codegen.platform.proposal.service.Service;

public final class Role extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("b1c69ded5e6f9b3209adda4613b08585e35d988f49cc818e5af8942f840887f7", "Platform.Role.Operator", "Role");

  public static final Choice<Role, ApproveProposalServiceRequest, Service.ContractId> CHOICE_ApproveProposalServiceRequest = 
      Choice.create("ApproveProposalServiceRequest", value$ -> value$.toValue(), value$ ->
        ApproveProposalServiceRequest.valueDecoder().decode(value$), value$ ->
        new Service.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Role, rentingPlatform.codegen.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        rentingPlatform.codegen.da.internal.template.Archive.valueDecoder().decode(value$),
        value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Role, ApproveLeaseAgreementService, rentingPlatform.codegen.platform.leaseagreement.service.Service.ContractId> CHOICE_ApproveLeaseAgreementService = 
      Choice.create("ApproveLeaseAgreementService", value$ -> value$.toValue(), value$ ->
        ApproveLeaseAgreementService.valueDecoder().decode(value$), value$ ->
        new rentingPlatform.codegen.platform.leaseagreement.service.Service.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final ContractCompanion.WithKey<Contract, ContractId, Role, String> COMPANION = 
      new ContractCompanion.WithKey<>("rentingPlatform.codegen.platform.role.operator.Role",
        TEMPLATE_ID, ContractId::new, v -> Role.templateValueDecoder().decode(v), Role::fromJson,
        Contract::new, List.of(CHOICE_ApproveProposalServiceRequest, CHOICE_Archive,
        CHOICE_ApproveLeaseAgreementService), e -> PrimitiveValueDecoders.fromParty.decode(e));

  public final String operator;

  public Role(String operator) {
    this.operator = operator;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(Role.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseApproveProposalServiceRequest} instead
   */
  @Deprecated
  public static Update<Exercised<Service.ContractId>> exerciseByKeyApproveProposalServiceRequest(
      String key, ApproveProposalServiceRequest arg) {
    return byKey(key).exerciseApproveProposalServiceRequest(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseApproveProposalServiceRequest(proposalReqCid)} instead
   */
  @Deprecated
  public static Update<Exercised<Service.ContractId>> exerciseByKeyApproveProposalServiceRequest(
      String key, Request.ContractId proposalReqCid) {
    return byKey(key).exerciseApproveProposalServiceRequest(proposalReqCid);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseArchive} instead
   */
  @Deprecated
  public static Update<Exercised<Unit>> exerciseByKeyArchive(String key,
      rentingPlatform.codegen.da.internal.template.Archive arg) {
    return byKey(key).exerciseArchive(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseArchive()} instead
   */
  @Deprecated
  public static Update<Exercised<Unit>> exerciseByKeyArchive(String key) {
    return byKey(key).exerciseArchive();
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseApproveLeaseAgreementService} instead
   */
  @Deprecated
  public static Update<Exercised<rentingPlatform.codegen.platform.leaseagreement.service.Service.ContractId>> exerciseByKeyApproveLeaseAgreementService(
      String key, ApproveLeaseAgreementService arg) {
    return byKey(key).exerciseApproveLeaseAgreementService(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseApproveLeaseAgreementService(laServiceReqCid,
      lifecycler, arbitrator)} instead
   */
  @Deprecated
  public static Update<Exercised<rentingPlatform.codegen.platform.leaseagreement.service.Service.ContractId>> exerciseByKeyApproveLeaseAgreementService(
      String key,
      rentingPlatform.codegen.platform.leaseagreement.service.Request.ContractId laServiceReqCid,
      String lifecycler, String arbitrator) {
    return byKey(key).exerciseApproveLeaseAgreementService(laServiceReqCid, lifecycler, arbitrator);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseApproveProposalServiceRequest} instead
   */
  @Deprecated
  public Update<Exercised<Service.ContractId>> createAndExerciseApproveProposalServiceRequest(
      ApproveProposalServiceRequest arg) {
    return createAnd().exerciseApproveProposalServiceRequest(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseApproveProposalServiceRequest} instead
   */
  @Deprecated
  public Update<Exercised<Service.ContractId>> createAndExerciseApproveProposalServiceRequest(
      Request.ContractId proposalReqCid) {
    return createAndExerciseApproveProposalServiceRequest(new ApproveProposalServiceRequest(proposalReqCid));
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
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseApproveLeaseAgreementService} instead
   */
  @Deprecated
  public Update<Exercised<rentingPlatform.codegen.platform.leaseagreement.service.Service.ContractId>> createAndExerciseApproveLeaseAgreementService(
      ApproveLeaseAgreementService arg) {
    return createAnd().exerciseApproveLeaseAgreementService(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseApproveLeaseAgreementService} instead
   */
  @Deprecated
  public Update<Exercised<rentingPlatform.codegen.platform.leaseagreement.service.Service.ContractId>> createAndExerciseApproveLeaseAgreementService(
      rentingPlatform.codegen.platform.leaseagreement.service.Request.ContractId laServiceReqCid,
      String lifecycler, String arbitrator) {
    return createAndExerciseApproveLeaseAgreementService(new ApproveLeaseAgreementService(laServiceReqCid,
        lifecycler, arbitrator));
  }

  public static Update<Created<ContractId>> create(String operator) {
    return new Role(operator).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithKey<Contract, ContractId, Role, String> getCompanion() {
    return COMPANION;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Role fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Role> valueDecoder() throws IllegalArgumentException {
    return ContractCompanion.valueDecoder(COMPANION);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(1);
    fields.add(new DamlRecord.Field("operator", new Party(this.operator)));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<Role> templateValueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0, recordValue$);
      String operator = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      return new Role(operator);
    } ;
  }

  public static JsonLfDecoder<Role> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("operator"), name -> {
          switch (name) {
            case "operator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            default: return null;
          }
        }
        , (Object[] args) -> new Role(JsonLfDecoders.cast(args[0])));
  }

  public static Role fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("operator", apply(JsonLfEncoders::party, operator)));
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
    if (!(object instanceof Role)) {
      return false;
    }
    Role other = (Role) object;
    return Objects.equals(this.operator, other.operator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.operator);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.role.operator.Role(%s)", this.operator);
  }

  /**
   * Set up an {@link ExerciseByKeyCommand}; invoke an {@code exercise} method on the result of
      this to finish creating the command, or convert to an interface first with {@code toInterface}
      to invoke an interface {@code exercise} method.
   */
  public static ByKey byKey(String key) {
    return new ByKey(new Party(key));
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<Role> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Role, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public static ContractId fromContractId(
        com.daml.ledger.javaapi.data.codegen.ContractId<Role> contractId) {
      return COMPANION.toContractId(contractId);
    }
  }

  public static class Contract extends ContractWithKey<ContractId, Role, String> {
    public Contract(ContractId id, Role data, Optional<String> agreementText, Optional<String> key,
        Set<String> signatories, Set<String> observers) {
      super(id, data, agreementText, key, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, Role> getCompanion() {
      return COMPANION;
    }

    public static Contract fromIdAndRecord(String contractId, DamlRecord record$,
        Optional<String> agreementText, Optional<String> key, Set<String> signatories,
        Set<String> observers) {
      return COMPANION.fromIdAndRecord(contractId, record$, agreementText, key, signatories,
          observers);
    }

    public static Contract fromCreatedEvent(CreatedEvent event) {
      return COMPANION.fromCreatedEvent(event);
    }
  }

  public interface Exercises<Cmd> extends com.daml.ledger.javaapi.data.codegen.Exercises.Archive<Cmd> {
    default Update<Exercised<Service.ContractId>> exerciseApproveProposalServiceRequest(
        ApproveProposalServiceRequest arg) {
      return makeExerciseCmd(CHOICE_ApproveProposalServiceRequest, arg);
    }

    default Update<Exercised<Service.ContractId>> exerciseApproveProposalServiceRequest(
        Request.ContractId proposalReqCid) {
      return exerciseApproveProposalServiceRequest(new ApproveProposalServiceRequest(proposalReqCid));
    }

    default Update<Exercised<Unit>> exerciseArchive(
        rentingPlatform.codegen.da.internal.template.Archive arg) {
      return makeExerciseCmd(CHOICE_Archive, arg);
    }

    default Update<Exercised<Unit>> exerciseArchive() {
      return exerciseArchive(new rentingPlatform.codegen.da.internal.template.Archive());
    }

    default Update<Exercised<rentingPlatform.codegen.platform.leaseagreement.service.Service.ContractId>> exerciseApproveLeaseAgreementService(
        ApproveLeaseAgreementService arg) {
      return makeExerciseCmd(CHOICE_ApproveLeaseAgreementService, arg);
    }

    default Update<Exercised<rentingPlatform.codegen.platform.leaseagreement.service.Service.ContractId>> exerciseApproveLeaseAgreementService(
        rentingPlatform.codegen.platform.leaseagreement.service.Request.ContractId laServiceReqCid,
        String lifecycler, String arbitrator) {
      return exerciseApproveLeaseAgreementService(new ApproveLeaseAgreementService(laServiceReqCid,
          lifecycler, arbitrator));
    }
  }

  public static final class CreateAnd extends com.daml.ledger.javaapi.data.codegen.CreateAnd implements Exercises<CreateAndExerciseCommand> {
    CreateAnd(Template createArguments) {
      super(createArguments);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Role, ?> getCompanion(
        ) {
      return COMPANION;
    }
  }

  public static final class ByKey extends com.daml.ledger.javaapi.data.codegen.ByKey implements Exercises<ExerciseByKeyCommand> {
    ByKey(Value key) {
      super(key);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Role, ?> getCompanion(
        ) {
      return COMPANION;
    }
  }
}

package rentingPlatform.codegen.platform.role.operator;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.codegen.DamlRecord;
import com.daml.ledger.javaapi.data.codegen.PrimitiveValueDecoders;
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
import rentingPlatform.codegen.platform.leaseagreement.service.Request;

public class ApproveLeaseAgreementService extends DamlRecord<ApproveLeaseAgreementService> {
  public static final String _packageId = "b80ed0eb60b6c3d918d4f24fbb5689a03c7ad2642b523a689de07104f792b41f";

  public final Request.ContractId laServiceReqCid;

  public final String lifecycler;

  public ApproveLeaseAgreementService(Request.ContractId laServiceReqCid, String lifecycler) {
    this.laServiceReqCid = laServiceReqCid;
    this.lifecycler = lifecycler;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static ApproveLeaseAgreementService fromValue(Value value$) throws
      IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<ApproveLeaseAgreementService> valueDecoder() throws
      IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      Request.ContractId laServiceReqCid =
          new Request.ContractId(fields$.get(0).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected laServiceReqCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      String lifecycler = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      return new ApproveLeaseAgreementService(laServiceReqCid, lifecycler);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("laServiceReqCid", this.laServiceReqCid.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("lifecycler", new Party(this.lifecycler)));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<ApproveLeaseAgreementService> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("laServiceReqCid", "lifecycler"), name -> {
          switch (name) {
            case "laServiceReqCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(rentingPlatform.codegen.platform.leaseagreement.service.Request.ContractId::new));
            case "lifecycler": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            default: return null;
          }
        }
        , (Object[] args) -> new ApproveLeaseAgreementService(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static ApproveLeaseAgreementService fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("laServiceReqCid", apply(JsonLfEncoders::contractId, laServiceReqCid)),
        JsonLfEncoders.Field.of("lifecycler", apply(JsonLfEncoders::party, lifecycler)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof ApproveLeaseAgreementService)) {
      return false;
    }
    ApproveLeaseAgreementService other = (ApproveLeaseAgreementService) object;
    return Objects.equals(this.laServiceReqCid, other.laServiceReqCid) &&
        Objects.equals(this.lifecycler, other.lifecycler);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.laServiceReqCid, this.lifecycler);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.role.operator.ApproveLeaseAgreementService(%s, %s)",
        this.laServiceReqCid, this.lifecycler);
  }
}

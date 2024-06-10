package rentingPlatform.codegen.platform.role.operator;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

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
import rentingPlatform.codegen.platform.proposal.service.Request;

public class ApproveProposalServiceRequest extends DamlRecord<ApproveProposalServiceRequest> {
  public static final String _packageId = "b1c69ded5e6f9b3209adda4613b08585e35d988f49cc818e5af8942f840887f7";

  public final Request.ContractId proposalReqCid;

  public ApproveProposalServiceRequest(Request.ContractId proposalReqCid) {
    this.proposalReqCid = proposalReqCid;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static ApproveProposalServiceRequest fromValue(Value value$) throws
      IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<ApproveProposalServiceRequest> valueDecoder() throws
      IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      Request.ContractId proposalReqCid =
          new Request.ContractId(fields$.get(0).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected proposalReqCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new ApproveProposalServiceRequest(proposalReqCid);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("proposalReqCid", this.proposalReqCid.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<ApproveProposalServiceRequest> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("proposalReqCid"), name -> {
          switch (name) {
            case "proposalReqCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(rentingPlatform.codegen.platform.proposal.service.Request.ContractId::new));
            default: return null;
          }
        }
        , (Object[] args) -> new ApproveProposalServiceRequest(JsonLfDecoders.cast(args[0])));
  }

  public static ApproveProposalServiceRequest fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("proposalReqCid", apply(JsonLfEncoders::contractId, proposalReqCid)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof ApproveProposalServiceRequest)) {
      return false;
    }
    ApproveProposalServiceRequest other = (ApproveProposalServiceRequest) object;
    return Objects.equals(this.proposalReqCid, other.proposalReqCid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.proposalReqCid);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.role.operator.ApproveProposalServiceRequest(%s)",
        this.proposalReqCid);
  }
}

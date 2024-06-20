package rentingPlatform.codegen.platform.proposal.service;

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
import rentingPlatform.codegen.platform.proposal.model.Proposal;

public class RejectProposal extends DamlRecord<RejectProposal> {
  public static final String _packageId = "08537584ed7a5356973a2deba7db786c7576354638ad57dfcafbaad6c1c125a5";

  public final Proposal.ContractId proposalCid;

  public RejectProposal(Proposal.ContractId proposalCid) {
    this.proposalCid = proposalCid;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static RejectProposal fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<RejectProposal> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      Proposal.ContractId proposalCid =
          new Proposal.ContractId(fields$.get(0).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected proposalCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new RejectProposal(proposalCid);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("proposalCid", this.proposalCid.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<RejectProposal> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("proposalCid"), name -> {
          switch (name) {
            case "proposalCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(rentingPlatform.codegen.platform.proposal.model.Proposal.ContractId::new));
            default: return null;
          }
        }
        , (Object[] args) -> new RejectProposal(JsonLfDecoders.cast(args[0])));
  }

  public static RejectProposal fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("proposalCid", apply(JsonLfEncoders::contractId, proposalCid)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof RejectProposal)) {
      return false;
    }
    RejectProposal other = (RejectProposal) object;
    return Objects.equals(this.proposalCid, other.proposalCid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.proposalCid);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.proposal.service.RejectProposal(%s)",
        this.proposalCid);
  }
}

package rentingPlatform.codegen.platform.leaseagreement.arbitratorsservice;

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
import rentingPlatform.codegen.platform.leaseagreement.modelmi.InviteArbitrators;

public class AcceptMI extends DamlRecord<AcceptMI> {
  public static final String _packageId = "b80ed0eb60b6c3d918d4f24fbb5689a03c7ad2642b523a689de07104f792b41f";

  public final InviteArbitrators.ContractId inviteArbitratorsCid;

  public AcceptMI(InviteArbitrators.ContractId inviteArbitratorsCid) {
    this.inviteArbitratorsCid = inviteArbitratorsCid;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static AcceptMI fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<AcceptMI> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      InviteArbitrators.ContractId inviteArbitratorsCid =
          new InviteArbitrators.ContractId(fields$.get(0).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected inviteArbitratorsCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new AcceptMI(inviteArbitratorsCid);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("inviteArbitratorsCid", this.inviteArbitratorsCid.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<AcceptMI> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("inviteArbitratorsCid"), name -> {
          switch (name) {
            case "inviteArbitratorsCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(rentingPlatform.codegen.platform.leaseagreement.modelmi.InviteArbitrators.ContractId::new));
            default: return null;
          }
        }
        , (Object[] args) -> new AcceptMI(JsonLfDecoders.cast(args[0])));
  }

  public static AcceptMI fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("inviteArbitratorsCid", apply(JsonLfEncoders::contractId, inviteArbitratorsCid)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof AcceptMI)) {
      return false;
    }
    AcceptMI other = (AcceptMI) object;
    return Objects.equals(this.inviteArbitratorsCid, other.inviteArbitratorsCid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.inviteArbitratorsCid);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.leaseagreement.arbitratorsservice.AcceptMI(%s)",
        this.inviteArbitratorsCid);
  }
}

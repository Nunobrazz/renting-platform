package rentingPlatform.codegen.platform.modelmi;

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

public class SetArbitrators extends DamlRecord<SetArbitrators> {
  public static final String _packageId = "6ca065ed990f710397d5bb273336a4eef438fdaf5c0d5e62b6e4e42cb9aa2b70";

  public final String inviter;

  public final InviteArbitrators.ContractId inviteArbitratorsCid;

  public SetArbitrators(String inviter, InviteArbitrators.ContractId inviteArbitratorsCid) {
    this.inviter = inviter;
    this.inviteArbitratorsCid = inviteArbitratorsCid;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static SetArbitrators fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<SetArbitrators> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      String inviter = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      InviteArbitrators.ContractId inviteArbitratorsCid =
          new InviteArbitrators.ContractId(fields$.get(1).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected inviteArbitratorsCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new SetArbitrators(inviter, inviteArbitratorsCid);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("inviter", new Party(this.inviter)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("inviteArbitratorsCid", this.inviteArbitratorsCid.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<SetArbitrators> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("inviter", "inviteArbitratorsCid"), name -> {
          switch (name) {
            case "inviter": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "inviteArbitratorsCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(rentingPlatform.codegen.platform.modelmi.InviteArbitrators.ContractId::new));
            default: return null;
          }
        }
        , (Object[] args) -> new SetArbitrators(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static SetArbitrators fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("inviter", apply(JsonLfEncoders::party, inviter)),
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
    if (!(object instanceof SetArbitrators)) {
      return false;
    }
    SetArbitrators other = (SetArbitrators) object;
    return Objects.equals(this.inviter, other.inviter) &&
        Objects.equals(this.inviteArbitratorsCid, other.inviteArbitratorsCid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.inviter, this.inviteArbitratorsCid);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.modelmi.SetArbitrators(%s, %s)",
        this.inviter, this.inviteArbitratorsCid);
  }
}

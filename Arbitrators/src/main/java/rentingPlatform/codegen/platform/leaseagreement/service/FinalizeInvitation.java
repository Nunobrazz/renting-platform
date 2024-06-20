package rentingPlatform.codegen.platform.leaseagreement.service;

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
import rentingPlatform.codegen.platform.leaseagreement.modelmi.InviteArbitrators;

public class FinalizeInvitation extends DamlRecord<FinalizeInvitation> {
  public static final String _packageId = "08537584ed7a5356973a2deba7db786c7576354638ad57dfcafbaad6c1c125a5";

  public final String inviter;

  public final InviteArbitrators.ContractId invitationCid;

  public FinalizeInvitation(String inviter, InviteArbitrators.ContractId invitationCid) {
    this.inviter = inviter;
    this.invitationCid = invitationCid;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static FinalizeInvitation fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<FinalizeInvitation> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      String inviter = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      InviteArbitrators.ContractId invitationCid =
          new InviteArbitrators.ContractId(fields$.get(1).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected invitationCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new FinalizeInvitation(inviter, invitationCid);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("inviter", new Party(this.inviter)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("invitationCid", this.invitationCid.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<FinalizeInvitation> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("inviter", "invitationCid"), name -> {
          switch (name) {
            case "inviter": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "invitationCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(rentingPlatform.codegen.platform.leaseagreement.modelmi.InviteArbitrators.ContractId::new));
            default: return null;
          }
        }
        , (Object[] args) -> new FinalizeInvitation(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static FinalizeInvitation fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("inviter", apply(JsonLfEncoders::party, inviter)),
        JsonLfEncoders.Field.of("invitationCid", apply(JsonLfEncoders::contractId, invitationCid)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof FinalizeInvitation)) {
      return false;
    }
    FinalizeInvitation other = (FinalizeInvitation) object;
    return Objects.equals(this.inviter, other.inviter) &&
        Objects.equals(this.invitationCid, other.invitationCid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.inviter, this.invitationCid);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.leaseagreement.service.FinalizeInvitation(%s, %s)",
        this.inviter, this.invitationCid);
  }
}

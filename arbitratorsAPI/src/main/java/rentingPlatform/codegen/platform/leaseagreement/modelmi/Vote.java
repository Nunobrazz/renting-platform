package rentingPlatform.codegen.platform.leaseagreement.modelmi;

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
import rentingPlatform.codegen.platform.types.mi.Responsability;

public class Vote extends DamlRecord<Vote> {
  public static final String _packageId = "4675aeb82c69164a49c2076e977f81eed1ed248ab4cb6bca91f769e1194714b0";

  public final String voter;

  public final Responsability vote;

  public Vote(String voter, Responsability vote) {
    this.voter = voter;
    this.vote = vote;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Vote fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Vote> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      String voter = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      Responsability vote = Responsability.valueDecoder().decode(fields$.get(1).getValue());
      return new Vote(voter, vote);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("voter", new Party(this.voter)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("vote", this.vote.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<Vote> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("voter", "vote"), name -> {
          switch (name) {
            case "voter": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "vote": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, rentingPlatform.codegen.platform.types.mi.Responsability.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new Vote(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static Vote fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("voter", apply(JsonLfEncoders::party, voter)),
        JsonLfEncoders.Field.of("vote", apply(Responsability::jsonEncoder, vote)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Vote)) {
      return false;
    }
    Vote other = (Vote) object;
    return Objects.equals(this.voter, other.voter) && Objects.equals(this.vote, other.vote);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.voter, this.vote);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.leaseagreement.modelmi.Vote(%s, %s)",
        this.voter, this.vote);
  }
}

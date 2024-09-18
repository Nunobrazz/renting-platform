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

public class AddObserver extends DamlRecord<AddObserver> {
  public static final String _packageId = "bef0965dc38d518ab3f749ea7cce7cf9cd13acb7b593b5f936707edcb2f1eff5";

  public final AvailableArbitratorsRequest.ContractId requestCid;

  public final String public$;

  public AddObserver(AvailableArbitratorsRequest.ContractId requestCid, String public$) {
    this.requestCid = requestCid;
    this.public$ = public$;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static AddObserver fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<AddObserver> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      AvailableArbitratorsRequest.ContractId requestCid =
          new AvailableArbitratorsRequest.ContractId(fields$.get(0).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected requestCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      String public$ = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      return new AddObserver(requestCid, public$);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("requestCid", this.requestCid.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("public", new Party(this.public$)));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<AddObserver> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("requestCid", "public$"), name -> {
          switch (name) {
            case "requestCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(rentingPlatform.codegen.platform.modelmi.AvailableArbitratorsRequest.ContractId::new));
            case "public$": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            default: return null;
          }
        }
        , (Object[] args) -> new AddObserver(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static AddObserver fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("requestCid", apply(JsonLfEncoders::contractId, requestCid)),
        JsonLfEncoders.Field.of("public$", apply(JsonLfEncoders::party, public$)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof AddObserver)) {
      return false;
    }
    AddObserver other = (AddObserver) object;
    return Objects.equals(this.requestCid, other.requestCid) &&
        Objects.equals(this.public$, other.public$);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.requestCid, this.public$);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.modelmi.AddObserver(%s, %s)",
        this.requestCid, this.public$);
  }
}

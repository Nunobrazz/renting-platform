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

public class AddArbitrator extends DamlRecord<AddArbitrator> {
  public static final String _packageId = "bef0965dc38d518ab3f749ea7cce7cf9cd13acb7b593b5f936707edcb2f1eff5";

  public final String arbitrator;

  public AddArbitrator(String arbitrator) {
    this.arbitrator = arbitrator;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static AddArbitrator fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<AddArbitrator> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      String arbitrator = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      return new AddArbitrator(arbitrator);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("arbitrator", new Party(this.arbitrator)));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<AddArbitrator> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("arbitrator"), name -> {
          switch (name) {
            case "arbitrator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            default: return null;
          }
        }
        , (Object[] args) -> new AddArbitrator(JsonLfDecoders.cast(args[0])));
  }

  public static AddArbitrator fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("arbitrator", apply(JsonLfEncoders::party, arbitrator)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof AddArbitrator)) {
      return false;
    }
    AddArbitrator other = (AddArbitrator) object;
    return Objects.equals(this.arbitrator, other.arbitrator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.arbitrator);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.modelmi.AddArbitrator(%s)",
        this.arbitrator);
  }
}

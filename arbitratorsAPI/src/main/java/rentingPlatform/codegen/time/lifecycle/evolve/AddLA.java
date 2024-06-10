package rentingPlatform.codegen.time.lifecycle.evolve;

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
import rentingPlatform.codegen.platform.types.la.LAkey;

public class AddLA extends DamlRecord<AddLA> {
  public static final String _packageId = "b1c69ded5e6f9b3209adda4613b08585e35d988f49cc818e5af8942f840887f7";

  public final LAkey laKey;

  public AddLA(LAkey laKey) {
    this.laKey = laKey;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static AddLA fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<AddLA> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      LAkey laKey = LAkey.valueDecoder().decode(fields$.get(0).getValue());
      return new AddLA(laKey);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("laKey", this.laKey.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<AddLA> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("laKey"), name -> {
          switch (name) {
            case "laKey": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, rentingPlatform.codegen.platform.types.la.LAkey.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new AddLA(JsonLfDecoders.cast(args[0])));
  }

  public static AddLA fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("laKey", apply(LAkey::jsonEncoder, laKey)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof AddLA)) {
      return false;
    }
    AddLA other = (AddLA) object;
    return Objects.equals(this.laKey, other.laKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.laKey);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.time.lifecycle.evolve.AddLA(%s)", this.laKey);
  }
}

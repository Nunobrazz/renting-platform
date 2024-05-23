package rentingPlatform.codegen.platform.types.mi;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Int64;
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
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Responsability extends DamlRecord<Responsability> {
  public static final String _packageId = "b80ed0eb60b6c3d918d4f24fbb5689a03c7ad2642b523a689de07104f792b41f";

  public final Long reporterResp;

  public final Long counterpartResp;

  public Responsability(Long reporterResp, Long counterpartResp) {
    this.reporterResp = reporterResp;
    this.counterpartResp = counterpartResp;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Responsability fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Responsability> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      Long reporterResp = PrimitiveValueDecoders.fromInt64.decode(fields$.get(0).getValue());
      Long counterpartResp = PrimitiveValueDecoders.fromInt64.decode(fields$.get(1).getValue());
      return new Responsability(reporterResp, counterpartResp);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("reporterResp", new Int64(this.reporterResp)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("counterpartResp", new Int64(this.counterpartResp)));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<Responsability> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("reporterResp", "counterpartResp"), name -> {
          switch (name) {
            case "reporterResp": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "counterpartResp": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            default: return null;
          }
        }
        , (Object[] args) -> new Responsability(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static Responsability fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("reporterResp", apply(JsonLfEncoders::int64, reporterResp)),
        JsonLfEncoders.Field.of("counterpartResp", apply(JsonLfEncoders::int64, counterpartResp)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Responsability)) {
      return false;
    }
    Responsability other = (Responsability) object;
    return Objects.equals(this.reporterResp, other.reporterResp) &&
        Objects.equals(this.counterpartResp, other.counterpartResp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.reporterResp, this.counterpartResp);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.types.mi.Responsability(%s, %s)",
        this.reporterResp, this.counterpartResp);
  }
}

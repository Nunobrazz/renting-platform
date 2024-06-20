package rentingPlatform.codegen.da.set.types;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.DamlCollectors;
import com.daml.ledger.javaapi.data.DamlRecord;
import com.daml.ledger.javaapi.data.Unit;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.codegen.PrimitiveValueDecoders;
import com.daml.ledger.javaapi.data.codegen.ValueDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfReader;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UncheckedIOException;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class Set<k> {
  public static final String _packageId = "97b883cd8a2b7f49f90d5d39c981cf6e110cf1f1c64427a28a6d58ec88c43657";

  public final Map<k, Unit> map;

  public Set(Map<k, Unit> map) {
    this.map = map;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static <k> Set<k> fromValue(Value value$, Function<Value, k> fromValuek) throws
      IllegalArgumentException {
    return Set.<k>valueDecoder(ValueDecoder.fromFunction(fromValuek)).decode(value$);
  }

  public static <k> ValueDecoder<Set<k>> valueDecoder(ValueDecoder<k> fromValuek) throws
      IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0, recordValue$);
      Map<k, Unit> map = PrimitiveValueDecoders.fromGenMap(fromValuek,
            PrimitiveValueDecoders.fromUnit).decode(fields$.get(0).getValue());
      return new Set<k>(map);
    } ;
  }

  public DamlRecord toValue(Function<k, Value> toValuek) {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(1);
    fields.add(new DamlRecord.Field("map", this.map.entrySet().stream()
        .collect(DamlCollectors.toDamlGenMap(v$0 -> toValuek.apply(v$0.getKey()), v$0 -> Unit.getInstance()))));
    return new DamlRecord(fields);
  }

  public static <k> JsonLfDecoder<Set<k>> jsonDecoder(JsonLfDecoder<k> decodek) {
    return JsonLfDecoders.record(Arrays.asList("map"), name -> {
          switch (name) {
            case "map": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.genMap(decodek, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.unit));
            default: return null;
          }
        }
        , (Object[] args) -> new Set<k>(JsonLfDecoders.cast(args[0])));
  }

  public static <k> Set<k> fromJson(String json, JsonLfDecoder<k> decodek) throws
      JsonLfDecoder.Error {
    return jsonDecoder(decodek).decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder(Function<k, JsonLfEncoder> makeEncoder_k) {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("map", apply(JsonLfEncoders.genMap(makeEncoder_k, JsonLfEncoders::unit), map)));
  }

  public String toJson(Function<k, JsonLfEncoder> makeEncoder_k) {
    var w = new StringWriter();
    try {
      this.jsonEncoder(makeEncoder_k).encode(new JsonLfWriter(w));
    } catch (IOException e) {
      // Not expected with StringWriter
      throw new UncheckedIOException(e);
    }
    return w.toString();
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Set<?>)) {
      return false;
    }
    Set<?> other = (Set<?>) object;
    return Objects.equals(this.map, other.map);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.map);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.da.set.types.Set(%s)", this.map);
  }
}

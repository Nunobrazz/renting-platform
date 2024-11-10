package rentingPlatform.codegen.platform.types.common;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Int64;
import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Text;
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

public class House extends DamlRecord<House> {
  public static final String _packageId = "6ca065ed990f710397d5bb273336a4eef438fdaf5c0d5e62b6e4e42cb9aa2b70";

  public final String host;

  public final String address;

  public final String details;

  public final Long listedRent;

  public House(String host, String address, String details, Long listedRent) {
    this.host = host;
    this.address = address;
    this.details = details;
    this.listedRent = listedRent;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static House fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<House> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(4,0,
          recordValue$);
      String host = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String address = PrimitiveValueDecoders.fromText.decode(fields$.get(1).getValue());
      String details = PrimitiveValueDecoders.fromText.decode(fields$.get(2).getValue());
      Long listedRent = PrimitiveValueDecoders.fromInt64.decode(fields$.get(3).getValue());
      return new House(host, address, details, listedRent);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(4);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("host", new Party(this.host)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("address", new Text(this.address)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("details", new Text(this.details)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("listedRent", new Int64(this.listedRent)));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<House> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("host", "address", "details", "listedRent"), name -> {
          switch (name) {
            case "host": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "address": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "details": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "listedRent": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            default: return null;
          }
        }
        , (Object[] args) -> new House(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3])));
  }

  public static House fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("host", apply(JsonLfEncoders::party, host)),
        JsonLfEncoders.Field.of("address", apply(JsonLfEncoders::text, address)),
        JsonLfEncoders.Field.of("details", apply(JsonLfEncoders::text, details)),
        JsonLfEncoders.Field.of("listedRent", apply(JsonLfEncoders::int64, listedRent)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof House)) {
      return false;
    }
    House other = (House) object;
    return Objects.equals(this.host, other.host) && Objects.equals(this.address, other.address) &&
        Objects.equals(this.details, other.details) &&
        Objects.equals(this.listedRent, other.listedRent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.host, this.address, this.details, this.listedRent);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.types.common.House(%s, %s, %s, %s)",
        this.host, this.address, this.details, this.listedRent);
  }
}

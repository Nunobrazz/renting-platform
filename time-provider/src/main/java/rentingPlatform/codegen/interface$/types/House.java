package rentingPlatform.codegen.interface$.types;

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
  public static final String _packageId = "3ab0b0842cdffab8c416d02894ad44bcc570eeb048f996af3c2257fb08640ba3";

  public final String host;

  public final String address;

  public final String details;

  public final Long rent;

  public House(String host, String address, String details, Long rent) {
    this.host = host;
    this.address = address;
    this.details = details;
    this.rent = rent;
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
      Long rent = PrimitiveValueDecoders.fromInt64.decode(fields$.get(3).getValue());
      return new House(host, address, details, rent);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(4);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("host", new Party(this.host)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("address", new Text(this.address)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("details", new Text(this.details)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("rent", new Int64(this.rent)));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<House> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("host", "address", "details", "rent"), name -> {
          switch (name) {
            case "host": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "address": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "details": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "rent": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
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
        JsonLfEncoders.Field.of("rent", apply(JsonLfEncoders::int64, rent)));
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
        Objects.equals(this.details, other.details) && Objects.equals(this.rent, other.rent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.host, this.address, this.details, this.rent);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.interface$.types.House(%s, %s, %s, %s)",
        this.host, this.address, this.details, this.rent);
  }
}

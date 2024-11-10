package rentingPlatform.codegen.platform.types.la;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Int64;
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
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import rentingPlatform.codegen.platform.types.common.House;

public class LAkey extends DamlRecord<LAkey> {
  public static final String _packageId = "6ca065ed990f710397d5bb273336a4eef438fdaf5c0d5e62b6e4e42cb9aa2b70";

  public final String tenant;

  public final House house;

  public final Long id;

  public LAkey(String tenant, House house, Long id) {
    this.tenant = tenant;
    this.house = house;
    this.id = id;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static LAkey fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<LAkey> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(3,0,
          recordValue$);
      String tenant = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      House house = House.valueDecoder().decode(fields$.get(1).getValue());
      Long id = PrimitiveValueDecoders.fromInt64.decode(fields$.get(2).getValue());
      return new LAkey(tenant, house, id);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(3);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("tenant", new Party(this.tenant)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("house", this.house.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("id", new Int64(this.id)));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<LAkey> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("tenant", "house", "id"), name -> {
          switch (name) {
            case "tenant": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "house": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, rentingPlatform.codegen.platform.types.common.House.jsonDecoder());
            case "id": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            default: return null;
          }
        }
        , (Object[] args) -> new LAkey(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2])));
  }

  public static LAkey fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("tenant", apply(JsonLfEncoders::party, tenant)),
        JsonLfEncoders.Field.of("house", apply(House::jsonEncoder, house)),
        JsonLfEncoders.Field.of("id", apply(JsonLfEncoders::int64, id)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof LAkey)) {
      return false;
    }
    LAkey other = (LAkey) object;
    return Objects.equals(this.tenant, other.tenant) && Objects.equals(this.house, other.house) &&
        Objects.equals(this.id, other.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.tenant, this.house, this.id);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.types.la.LAkey(%s, %s, %s)", this.tenant,
        this.house, this.id);
  }
}

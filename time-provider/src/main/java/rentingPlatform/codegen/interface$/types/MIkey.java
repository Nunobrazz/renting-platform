package rentingPlatform.codegen.interface$.types;

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

public class MIkey extends DamlRecord<MIkey> {
  public static final String _packageId = "0cf664e7a7bad84bfc31440cc4ea2b4c71a9a628dbeb0437bb65cac5ef779e5e";

  public final String reporter;

  public final House house;

  public final Breakdown breakdown;

  public MIkey(String reporter, House house, Breakdown breakdown) {
    this.reporter = reporter;
    this.house = house;
    this.breakdown = breakdown;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static MIkey fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<MIkey> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(3,0,
          recordValue$);
      String reporter = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      House house = House.valueDecoder().decode(fields$.get(1).getValue());
      Breakdown breakdown = Breakdown.valueDecoder().decode(fields$.get(2).getValue());
      return new MIkey(reporter, house, breakdown);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(3);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("reporter", new Party(this.reporter)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("house", this.house.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("breakdown", this.breakdown.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<MIkey> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("reporter", "house", "breakdown"), name -> {
          switch (name) {
            case "reporter": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "house": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, rentingPlatform.codegen.interface$.types.House.jsonDecoder());
            case "breakdown": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, rentingPlatform.codegen.interface$.types.Breakdown.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new MIkey(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2])));
  }

  public static MIkey fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("reporter", apply(JsonLfEncoders::party, reporter)),
        JsonLfEncoders.Field.of("house", apply(House::jsonEncoder, house)),
        JsonLfEncoders.Field.of("breakdown", apply(Breakdown::jsonEncoder, breakdown)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof MIkey)) {
      return false;
    }
    MIkey other = (MIkey) object;
    return Objects.equals(this.reporter, other.reporter) &&
        Objects.equals(this.house, other.house) && Objects.equals(this.breakdown, other.breakdown);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.reporter, this.house, this.breakdown);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.interface$.types.MIkey(%s, %s, %s)",
        this.reporter, this.house, this.breakdown);
  }
}

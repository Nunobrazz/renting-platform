package rentingPlatform.codegen.platform.types.mi;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Date;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import rentingPlatform.codegen.platform.types.common.House;

public class MIdetails extends DamlRecord<MIdetails> {
  public static final String _packageId = "b80ed0eb60b6c3d918d4f24fbb5689a03c7ad2642b523a689de07104f792b41f";

  public final String reporter;

  public final String counterpart;

  public final Long nArbitrators;

  public final House house;

  public final LocalDate startingDate;

  public final String description;

  public MIdetails(String reporter, String counterpart, Long nArbitrators, House house,
      LocalDate startingDate, String description) {
    this.reporter = reporter;
    this.counterpart = counterpart;
    this.nArbitrators = nArbitrators;
    this.house = house;
    this.startingDate = startingDate;
    this.description = description;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static MIdetails fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<MIdetails> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(6,0,
          recordValue$);
      String reporter = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String counterpart = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      Long nArbitrators = PrimitiveValueDecoders.fromInt64.decode(fields$.get(2).getValue());
      House house = House.valueDecoder().decode(fields$.get(3).getValue());
      LocalDate startingDate = PrimitiveValueDecoders.fromDate.decode(fields$.get(4).getValue());
      String description = PrimitiveValueDecoders.fromText.decode(fields$.get(5).getValue());
      return new MIdetails(reporter, counterpart, nArbitrators, house, startingDate, description);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(6);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("reporter", new Party(this.reporter)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("counterpart", new Party(this.counterpart)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("nArbitrators", new Int64(this.nArbitrators)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("house", this.house.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("startingDate", new Date((int) this.startingDate.toEpochDay())));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("description", new Text(this.description)));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<MIdetails> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("reporter", "counterpart", "nArbitrators", "house", "startingDate", "description"), name -> {
          switch (name) {
            case "reporter": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "counterpart": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "nArbitrators": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "house": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, rentingPlatform.codegen.platform.types.common.House.jsonDecoder());
            case "startingDate": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.date);
            case "description": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            default: return null;
          }
        }
        , (Object[] args) -> new MIdetails(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5])));
  }

  public static MIdetails fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("reporter", apply(JsonLfEncoders::party, reporter)),
        JsonLfEncoders.Field.of("counterpart", apply(JsonLfEncoders::party, counterpart)),
        JsonLfEncoders.Field.of("nArbitrators", apply(JsonLfEncoders::int64, nArbitrators)),
        JsonLfEncoders.Field.of("house", apply(House::jsonEncoder, house)),
        JsonLfEncoders.Field.of("startingDate", apply(JsonLfEncoders::date, startingDate)),
        JsonLfEncoders.Field.of("description", apply(JsonLfEncoders::text, description)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof MIdetails)) {
      return false;
    }
    MIdetails other = (MIdetails) object;
    return Objects.equals(this.reporter, other.reporter) &&
        Objects.equals(this.counterpart, other.counterpart) &&
        Objects.equals(this.nArbitrators, other.nArbitrators) &&
        Objects.equals(this.house, other.house) &&
        Objects.equals(this.startingDate, other.startingDate) &&
        Objects.equals(this.description, other.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.reporter, this.counterpart, this.nArbitrators, this.house,
        this.startingDate, this.description);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.types.mi.MIdetails(%s, %s, %s, %s, %s, %s)",
        this.reporter, this.counterpart, this.nArbitrators, this.house, this.startingDate,
        this.description);
  }
}

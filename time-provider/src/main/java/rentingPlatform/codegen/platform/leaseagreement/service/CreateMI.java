package rentingPlatform.codegen.platform.leaseagreement.service;

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
import rentingPlatform.codegen.interface$.types.Breakdown;

public class CreateMI extends DamlRecord<CreateMI> {
  public static final String _packageId = "bb7737a3fae0dab3c7cecc1b5d7d0840ffd1957d4501f41845dbecbd2bcf97c3";

  public final String reporter;

  public final Breakdown breakdown;

  public CreateMI(String reporter, Breakdown breakdown) {
    this.reporter = reporter;
    this.breakdown = breakdown;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static CreateMI fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<CreateMI> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      String reporter = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      Breakdown breakdown = Breakdown.valueDecoder().decode(fields$.get(1).getValue());
      return new CreateMI(reporter, breakdown);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("reporter", new Party(this.reporter)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("breakdown", this.breakdown.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<CreateMI> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("reporter", "breakdown"), name -> {
          switch (name) {
            case "reporter": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "breakdown": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, rentingPlatform.codegen.interface$.types.Breakdown.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new CreateMI(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static CreateMI fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("reporter", apply(JsonLfEncoders::party, reporter)),
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
    if (!(object instanceof CreateMI)) {
      return false;
    }
    CreateMI other = (CreateMI) object;
    return Objects.equals(this.reporter, other.reporter) &&
        Objects.equals(this.breakdown, other.breakdown);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.reporter, this.breakdown);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.leaseagreement.service.CreateMI(%s, %s)",
        this.reporter, this.breakdown);
  }
}

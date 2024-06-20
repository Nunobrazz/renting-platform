package rentingPlatform.codegen.platform.role.operator;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.DamlCollectors;
import com.daml.ledger.javaapi.data.Date;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import rentingPlatform.codegen.da.set.types.Set;

public class InitiateDateClock extends DamlRecord<InitiateDateClock> {
  public static final String _packageId = "08537584ed7a5356973a2deba7db786c7576354638ad57dfcafbaad6c1c125a5";

  public final String operator;

  public final List<String> providers;

  public final LocalDate clockDate;

  public final String public$;

  public final Set<String> waitingAccept;

  public InitiateDateClock(String operator, List<String> providers, LocalDate clockDate,
      String public$, Set<String> waitingAccept) {
    this.operator = operator;
    this.providers = providers;
    this.clockDate = clockDate;
    this.public$ = public$;
    this.waitingAccept = waitingAccept;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static InitiateDateClock fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<InitiateDateClock> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(5,0,
          recordValue$);
      String operator = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      List<String> providers = PrimitiveValueDecoders.fromList(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(1).getValue());
      LocalDate clockDate = PrimitiveValueDecoders.fromDate.decode(fields$.get(2).getValue());
      String public$ = PrimitiveValueDecoders.fromParty.decode(fields$.get(3).getValue());
      Set<String> waitingAccept =
          Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(4).getValue());
      return new InitiateDateClock(operator, providers, clockDate, public$, waitingAccept);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(5);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("operator", new Party(this.operator)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("providers", this.providers.stream().collect(DamlCollectors.toDamlList(v$0 -> new Party(v$0)))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("clockDate", new Date((int) this.clockDate.toEpochDay())));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("public", new Party(this.public$)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("waitingAccept", this.waitingAccept.toValue(v$0 -> new Party(v$0))));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<InitiateDateClock> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("operator", "providers", "clockDate", "public$", "waitingAccept"), name -> {
          switch (name) {
            case "operator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "providers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "clockDate": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.date);
            case "public$": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "waitingAccept": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, rentingPlatform.codegen.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            default: return null;
          }
        }
        , (Object[] args) -> new InitiateDateClock(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4])));
  }

  public static InitiateDateClock fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("operator", apply(JsonLfEncoders::party, operator)),
        JsonLfEncoders.Field.of("providers", apply(JsonLfEncoders.list(JsonLfEncoders::party), providers)),
        JsonLfEncoders.Field.of("clockDate", apply(JsonLfEncoders::date, clockDate)),
        JsonLfEncoders.Field.of("public$", apply(JsonLfEncoders::party, public$)),
        JsonLfEncoders.Field.of("waitingAccept", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), waitingAccept)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof InitiateDateClock)) {
      return false;
    }
    InitiateDateClock other = (InitiateDateClock) object;
    return Objects.equals(this.operator, other.operator) &&
        Objects.equals(this.providers, other.providers) &&
        Objects.equals(this.clockDate, other.clockDate) &&
        Objects.equals(this.public$, other.public$) &&
        Objects.equals(this.waitingAccept, other.waitingAccept);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.operator, this.providers, this.clockDate, this.public$,
        this.waitingAccept);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.role.operator.InitiateDateClock(%s, %s, %s, %s, %s)",
        this.operator, this.providers, this.clockDate, this.public$, this.waitingAccept);
  }
}

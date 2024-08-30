package rentingPlatform.codegen.platform.leaseagreement.modelmi;

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
import rentingPlatform.codegen.platform.types.mi.Responsability;

public class CreatePoll extends DamlRecord<CreatePoll> {
  public static final String _packageId = "a6bcfd7383b67eb87e5f0a5348ee1cec07394d6ff60d842a59c6ec0bfb5dfc76";

  public final String visitor;

  public final String visitDetails;

  public final Responsability vote;

  public final Long cost;

  public final LocalDate assessmentDate;

  public final LocalDate reparationDate;

  public CreatePoll(String visitor, String visitDetails, Responsability vote, Long cost,
      LocalDate assessmentDate, LocalDate reparationDate) {
    this.visitor = visitor;
    this.visitDetails = visitDetails;
    this.vote = vote;
    this.cost = cost;
    this.assessmentDate = assessmentDate;
    this.reparationDate = reparationDate;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static CreatePoll fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<CreatePoll> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(6,0,
          recordValue$);
      String visitor = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String visitDetails = PrimitiveValueDecoders.fromText.decode(fields$.get(1).getValue());
      Responsability vote = Responsability.valueDecoder().decode(fields$.get(2).getValue());
      Long cost = PrimitiveValueDecoders.fromInt64.decode(fields$.get(3).getValue());
      LocalDate assessmentDate = PrimitiveValueDecoders.fromDate.decode(fields$.get(4).getValue());
      LocalDate reparationDate = PrimitiveValueDecoders.fromDate.decode(fields$.get(5).getValue());
      return new CreatePoll(visitor, visitDetails, vote, cost, assessmentDate, reparationDate);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(6);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("visitor", new Party(this.visitor)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("visitDetails", new Text(this.visitDetails)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("vote", this.vote.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("cost", new Int64(this.cost)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("assessmentDate", new Date((int) this.assessmentDate.toEpochDay())));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("reparationDate", new Date((int) this.reparationDate.toEpochDay())));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<CreatePoll> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("visitor", "visitDetails", "vote", "cost", "assessmentDate", "reparationDate"), name -> {
          switch (name) {
            case "visitor": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "visitDetails": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "vote": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, rentingPlatform.codegen.platform.types.mi.Responsability.jsonDecoder());
            case "cost": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "assessmentDate": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.date);
            case "reparationDate": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.date);
            default: return null;
          }
        }
        , (Object[] args) -> new CreatePoll(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5])));
  }

  public static CreatePoll fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("visitor", apply(JsonLfEncoders::party, visitor)),
        JsonLfEncoders.Field.of("visitDetails", apply(JsonLfEncoders::text, visitDetails)),
        JsonLfEncoders.Field.of("vote", apply(Responsability::jsonEncoder, vote)),
        JsonLfEncoders.Field.of("cost", apply(JsonLfEncoders::int64, cost)),
        JsonLfEncoders.Field.of("assessmentDate", apply(JsonLfEncoders::date, assessmentDate)),
        JsonLfEncoders.Field.of("reparationDate", apply(JsonLfEncoders::date, reparationDate)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof CreatePoll)) {
      return false;
    }
    CreatePoll other = (CreatePoll) object;
    return Objects.equals(this.visitor, other.visitor) &&
        Objects.equals(this.visitDetails, other.visitDetails) &&
        Objects.equals(this.vote, other.vote) && Objects.equals(this.cost, other.cost) &&
        Objects.equals(this.assessmentDate, other.assessmentDate) &&
        Objects.equals(this.reparationDate, other.reparationDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.visitor, this.visitDetails, this.vote, this.cost, this.assessmentDate,
        this.reparationDate);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.leaseagreement.modelmi.CreatePoll(%s, %s, %s, %s, %s, %s)",
        this.visitor, this.visitDetails, this.vote, this.cost, this.assessmentDate,
        this.reparationDate);
  }
}

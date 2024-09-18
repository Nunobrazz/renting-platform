package rentingPlatform.codegen.platform.types.mi;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Date;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class AssessmentDetails extends DamlRecord<AssessmentDetails> {
  public static final String _packageId = "bef0965dc38d518ab3f749ea7cce7cf9cd13acb7b593b5f936707edcb2f1eff5";

  public final Responsability responsability;

  public final Long cost;

  public final LocalDate assessmentDate;

  public final LocalDate reparationDate;

  public AssessmentDetails(Responsability responsability, Long cost, LocalDate assessmentDate,
      LocalDate reparationDate) {
    this.responsability = responsability;
    this.cost = cost;
    this.assessmentDate = assessmentDate;
    this.reparationDate = reparationDate;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static AssessmentDetails fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<AssessmentDetails> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(4,0,
          recordValue$);
      Responsability responsability = Responsability.valueDecoder()
          .decode(fields$.get(0).getValue());
      Long cost = PrimitiveValueDecoders.fromInt64.decode(fields$.get(1).getValue());
      LocalDate assessmentDate = PrimitiveValueDecoders.fromDate.decode(fields$.get(2).getValue());
      LocalDate reparationDate = PrimitiveValueDecoders.fromDate.decode(fields$.get(3).getValue());
      return new AssessmentDetails(responsability, cost, assessmentDate, reparationDate);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(4);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("responsability", this.responsability.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("cost", new Int64(this.cost)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("assessmentDate", new Date((int) this.assessmentDate.toEpochDay())));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("reparationDate", new Date((int) this.reparationDate.toEpochDay())));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<AssessmentDetails> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("responsability", "cost", "assessmentDate", "reparationDate"), name -> {
          switch (name) {
            case "responsability": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, rentingPlatform.codegen.platform.types.mi.Responsability.jsonDecoder());
            case "cost": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "assessmentDate": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.date);
            case "reparationDate": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.date);
            default: return null;
          }
        }
        , (Object[] args) -> new AssessmentDetails(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3])));
  }

  public static AssessmentDetails fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("responsability", apply(Responsability::jsonEncoder, responsability)),
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
    if (!(object instanceof AssessmentDetails)) {
      return false;
    }
    AssessmentDetails other = (AssessmentDetails) object;
    return Objects.equals(this.responsability, other.responsability) &&
        Objects.equals(this.cost, other.cost) &&
        Objects.equals(this.assessmentDate, other.assessmentDate) &&
        Objects.equals(this.reparationDate, other.reparationDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.responsability, this.cost, this.assessmentDate, this.reparationDate);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.types.mi.AssessmentDetails(%s, %s, %s, %s)",
        this.responsability, this.cost, this.assessmentDate, this.reparationDate);
  }
}

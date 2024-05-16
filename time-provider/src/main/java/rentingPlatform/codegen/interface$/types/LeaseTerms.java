package rentingPlatform.codegen.interface$.types;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.DamlCollectors;
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

public class LeaseTerms extends DamlRecord<LeaseTerms> {
  public static final String _packageId = "3ab0b0842cdffab8c416d02894ad44bcc570eeb048f996af3c2257fb08640ba3";

  public final Long rent;

  public final LocalDate beginingDate;

  public final List<LocalDate> paymentDates;

  public final Long nArbitrators;

  public LeaseTerms(Long rent, LocalDate beginingDate, List<LocalDate> paymentDates,
      Long nArbitrators) {
    this.rent = rent;
    this.beginingDate = beginingDate;
    this.paymentDates = paymentDates;
    this.nArbitrators = nArbitrators;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static LeaseTerms fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<LeaseTerms> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(4,0,
          recordValue$);
      Long rent = PrimitiveValueDecoders.fromInt64.decode(fields$.get(0).getValue());
      LocalDate beginingDate = PrimitiveValueDecoders.fromDate.decode(fields$.get(1).getValue());
      List<LocalDate> paymentDates = PrimitiveValueDecoders.fromList(
            PrimitiveValueDecoders.fromDate).decode(fields$.get(2).getValue());
      Long nArbitrators = PrimitiveValueDecoders.fromInt64.decode(fields$.get(3).getValue());
      return new LeaseTerms(rent, beginingDate, paymentDates, nArbitrators);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(4);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("rent", new Int64(this.rent)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("beginingDate", new Date((int) this.beginingDate.toEpochDay())));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("paymentDates", this.paymentDates.stream().collect(DamlCollectors.toDamlList(v$0 -> new Date((int) v$0.toEpochDay())))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("nArbitrators", new Int64(this.nArbitrators)));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<LeaseTerms> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("rent", "beginingDate", "paymentDates", "nArbitrators"), name -> {
          switch (name) {
            case "rent": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "beginingDate": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.date);
            case "paymentDates": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.date));
            case "nArbitrators": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            default: return null;
          }
        }
        , (Object[] args) -> new LeaseTerms(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3])));
  }

  public static LeaseTerms fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("rent", apply(JsonLfEncoders::int64, rent)),
        JsonLfEncoders.Field.of("beginingDate", apply(JsonLfEncoders::date, beginingDate)),
        JsonLfEncoders.Field.of("paymentDates", apply(JsonLfEncoders.list(JsonLfEncoders::date), paymentDates)),
        JsonLfEncoders.Field.of("nArbitrators", apply(JsonLfEncoders::int64, nArbitrators)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof LeaseTerms)) {
      return false;
    }
    LeaseTerms other = (LeaseTerms) object;
    return Objects.equals(this.rent, other.rent) &&
        Objects.equals(this.beginingDate, other.beginingDate) &&
        Objects.equals(this.paymentDates, other.paymentDates) &&
        Objects.equals(this.nArbitrators, other.nArbitrators);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.rent, this.beginingDate, this.paymentDates, this.nArbitrators);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.interface$.types.LeaseTerms(%s, %s, %s, %s)",
        this.rent, this.beginingDate, this.paymentDates, this.nArbitrators);
  }
}

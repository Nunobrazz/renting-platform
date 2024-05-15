package rentingPlatform.codegen.platform.leaseagreement.modelmi;

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

public class FinalizeAssessment extends DamlRecord<FinalizeAssessment> {
  public static final String _packageId = "bb7737a3fae0dab3c7cecc1b5d7d0840ffd1957d4501f41845dbecbd2bcf97c3";

  public final String finalizer;

  public FinalizeAssessment(String finalizer) {
    this.finalizer = finalizer;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static FinalizeAssessment fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<FinalizeAssessment> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      String finalizer = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      return new FinalizeAssessment(finalizer);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("finalizer", new Party(this.finalizer)));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<FinalizeAssessment> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("finalizer"), name -> {
          switch (name) {
            case "finalizer": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            default: return null;
          }
        }
        , (Object[] args) -> new FinalizeAssessment(JsonLfDecoders.cast(args[0])));
  }

  public static FinalizeAssessment fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("finalizer", apply(JsonLfEncoders::party, finalizer)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof FinalizeAssessment)) {
      return false;
    }
    FinalizeAssessment other = (FinalizeAssessment) object;
    return Objects.equals(this.finalizer, other.finalizer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.finalizer);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.leaseagreement.modelmi.FinalizeAssessment(%s)",
        this.finalizer);
  }
}

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
import rentingPlatform.codegen.interface$.types.AssessmentDetails;
import rentingPlatform.codegen.interface$.types.MIkey;

public class SubmitAssessment extends DamlRecord<SubmitAssessment> {
  public static final String _packageId = "bb7737a3fae0dab3c7cecc1b5d7d0840ffd1957d4501f41845dbecbd2bcf97c3";

  public final String submitter;

  public final AssessmentDetails assessmentDetails;

  public final MIkey miKey;

  public SubmitAssessment(String submitter, AssessmentDetails assessmentDetails, MIkey miKey) {
    this.submitter = submitter;
    this.assessmentDetails = assessmentDetails;
    this.miKey = miKey;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static SubmitAssessment fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<SubmitAssessment> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(3,0,
          recordValue$);
      String submitter = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      AssessmentDetails assessmentDetails = AssessmentDetails.valueDecoder()
          .decode(fields$.get(1).getValue());
      MIkey miKey = MIkey.valueDecoder().decode(fields$.get(2).getValue());
      return new SubmitAssessment(submitter, assessmentDetails, miKey);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(3);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("submitter", new Party(this.submitter)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("assessmentDetails", this.assessmentDetails.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("miKey", this.miKey.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<SubmitAssessment> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("submitter", "assessmentDetails", "miKey"), name -> {
          switch (name) {
            case "submitter": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "assessmentDetails": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, rentingPlatform.codegen.interface$.types.AssessmentDetails.jsonDecoder());
            case "miKey": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, rentingPlatform.codegen.interface$.types.MIkey.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new SubmitAssessment(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2])));
  }

  public static SubmitAssessment fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("submitter", apply(JsonLfEncoders::party, submitter)),
        JsonLfEncoders.Field.of("assessmentDetails", apply(AssessmentDetails::jsonEncoder, assessmentDetails)),
        JsonLfEncoders.Field.of("miKey", apply(MIkey::jsonEncoder, miKey)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof SubmitAssessment)) {
      return false;
    }
    SubmitAssessment other = (SubmitAssessment) object;
    return Objects.equals(this.submitter, other.submitter) &&
        Objects.equals(this.assessmentDetails, other.assessmentDetails) &&
        Objects.equals(this.miKey, other.miKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.submitter, this.assessmentDetails, this.miKey);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.leaseagreement.service.SubmitAssessment(%s, %s, %s)",
        this.submitter, this.assessmentDetails, this.miKey);
  }
}
package rentingPlatform.codegen.platform.modella;

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
import rentingPlatform.codegen.platform.modelmi.MIReport;
import rentingPlatform.codegen.platform.types.mi.AssessmentDetails;

public class SubmitAssessment extends DamlRecord<SubmitAssessment> {
  public static final String _packageId = "bef0965dc38d518ab3f749ea7cce7cf9cd13acb7b593b5f936707edcb2f1eff5";

  public final String creator;

  public final AssessmentDetails assessment;

  public final MIReport.ContractId miReportCid;

  public SubmitAssessment(String creator, AssessmentDetails assessment,
      MIReport.ContractId miReportCid) {
    this.creator = creator;
    this.assessment = assessment;
    this.miReportCid = miReportCid;
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
      String creator = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      AssessmentDetails assessment = AssessmentDetails.valueDecoder()
          .decode(fields$.get(1).getValue());
      MIReport.ContractId miReportCid =
          new MIReport.ContractId(fields$.get(2).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected miReportCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new SubmitAssessment(creator, assessment, miReportCid);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(3);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("creator", new Party(this.creator)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("assessment", this.assessment.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("miReportCid", this.miReportCid.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<SubmitAssessment> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("creator", "assessment", "miReportCid"), name -> {
          switch (name) {
            case "creator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "assessment": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, rentingPlatform.codegen.platform.types.mi.AssessmentDetails.jsonDecoder());
            case "miReportCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(rentingPlatform.codegen.platform.modelmi.MIReport.ContractId::new));
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
        JsonLfEncoders.Field.of("creator", apply(JsonLfEncoders::party, creator)),
        JsonLfEncoders.Field.of("assessment", apply(AssessmentDetails::jsonEncoder, assessment)),
        JsonLfEncoders.Field.of("miReportCid", apply(JsonLfEncoders::contractId, miReportCid)));
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
    return Objects.equals(this.creator, other.creator) &&
        Objects.equals(this.assessment, other.assessment) &&
        Objects.equals(this.miReportCid, other.miReportCid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.creator, this.assessment, this.miReportCid);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.modella.SubmitAssessment(%s, %s, %s)",
        this.creator, this.assessment, this.miReportCid);
  }
}

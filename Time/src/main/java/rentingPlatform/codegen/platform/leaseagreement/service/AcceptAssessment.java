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
import rentingPlatform.codegen.platform.leaseagreement.modelmi.Assessment;

public class AcceptAssessment extends DamlRecord<AcceptAssessment> {
  public static final String _packageId = "a6bcfd7383b67eb87e5f0a5348ee1cec07394d6ff60d842a59c6ec0bfb5dfc76";

  public final String signer;

  public final Assessment.ContractId assessmentCid;

  public AcceptAssessment(String signer, Assessment.ContractId assessmentCid) {
    this.signer = signer;
    this.assessmentCid = assessmentCid;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static AcceptAssessment fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<AcceptAssessment> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      String signer = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      Assessment.ContractId assessmentCid =
          new Assessment.ContractId(fields$.get(1).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected assessmentCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new AcceptAssessment(signer, assessmentCid);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("signer", new Party(this.signer)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("assessmentCid", this.assessmentCid.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<AcceptAssessment> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("signer", "assessmentCid"), name -> {
          switch (name) {
            case "signer": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "assessmentCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(rentingPlatform.codegen.platform.leaseagreement.modelmi.Assessment.ContractId::new));
            default: return null;
          }
        }
        , (Object[] args) -> new AcceptAssessment(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static AcceptAssessment fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("signer", apply(JsonLfEncoders::party, signer)),
        JsonLfEncoders.Field.of("assessmentCid", apply(JsonLfEncoders::contractId, assessmentCid)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof AcceptAssessment)) {
      return false;
    }
    AcceptAssessment other = (AcceptAssessment) object;
    return Objects.equals(this.signer, other.signer) &&
        Objects.equals(this.assessmentCid, other.assessmentCid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.signer, this.assessmentCid);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.leaseagreement.service.AcceptAssessment(%s, %s)",
        this.signer, this.assessmentCid);
  }
}

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

public class SignAssessment extends DamlRecord<SignAssessment> {
  public static final String _packageId = "bb7737a3fae0dab3c7cecc1b5d7d0840ffd1957d4501f41845dbecbd2bcf97c3";

  public final String signer;

  public final Assessment.ContractId assessmentCid;

  public SignAssessment(String signer, Assessment.ContractId assessmentCid) {
    this.signer = signer;
    this.assessmentCid = assessmentCid;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static SignAssessment fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<SignAssessment> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      String signer = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      Assessment.ContractId assessmentCid =
          new Assessment.ContractId(fields$.get(1).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected assessmentCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new SignAssessment(signer, assessmentCid);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("signer", new Party(this.signer)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("assessmentCid", this.assessmentCid.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<SignAssessment> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("signer", "assessmentCid"), name -> {
          switch (name) {
            case "signer": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "assessmentCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(rentingPlatform.codegen.platform.leaseagreement.modelmi.Assessment.ContractId::new));
            default: return null;
          }
        }
        , (Object[] args) -> new SignAssessment(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static SignAssessment fromJson(String json) throws JsonLfDecoder.Error {
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
    if (!(object instanceof SignAssessment)) {
      return false;
    }
    SignAssessment other = (SignAssessment) object;
    return Objects.equals(this.signer, other.signer) &&
        Objects.equals(this.assessmentCid, other.assessmentCid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.signer, this.assessmentCid);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.leaseagreement.service.SignAssessment(%s, %s)",
        this.signer, this.assessmentCid);
  }
}

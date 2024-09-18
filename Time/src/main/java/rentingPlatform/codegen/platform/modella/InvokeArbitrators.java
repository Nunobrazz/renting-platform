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
import rentingPlatform.codegen.platform.modelmi.AvailableArbitrators;
import rentingPlatform.codegen.platform.modelmi.MIReport;

public class InvokeArbitrators extends DamlRecord<InvokeArbitrators> {
  public static final String _packageId = "bef0965dc38d518ab3f749ea7cce7cf9cd13acb7b593b5f936707edcb2f1eff5";

  public final String inviter;

  public final AvailableArbitrators.ContractId availableArbitratorsCid;

  public final MIReport.ContractId miReportCid;

  public InvokeArbitrators(String inviter, AvailableArbitrators.ContractId availableArbitratorsCid,
      MIReport.ContractId miReportCid) {
    this.inviter = inviter;
    this.availableArbitratorsCid = availableArbitratorsCid;
    this.miReportCid = miReportCid;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static InvokeArbitrators fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<InvokeArbitrators> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(3,0,
          recordValue$);
      String inviter = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      AvailableArbitrators.ContractId availableArbitratorsCid =
          new AvailableArbitrators.ContractId(fields$.get(1).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected availableArbitratorsCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      MIReport.ContractId miReportCid =
          new MIReport.ContractId(fields$.get(2).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected miReportCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new InvokeArbitrators(inviter, availableArbitratorsCid, miReportCid);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(3);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("inviter", new Party(this.inviter)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("availableArbitratorsCid", this.availableArbitratorsCid.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("miReportCid", this.miReportCid.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<InvokeArbitrators> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("inviter", "availableArbitratorsCid", "miReportCid"), name -> {
          switch (name) {
            case "inviter": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "availableArbitratorsCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(rentingPlatform.codegen.platform.modelmi.AvailableArbitrators.ContractId::new));
            case "miReportCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(rentingPlatform.codegen.platform.modelmi.MIReport.ContractId::new));
            default: return null;
          }
        }
        , (Object[] args) -> new InvokeArbitrators(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2])));
  }

  public static InvokeArbitrators fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("inviter", apply(JsonLfEncoders::party, inviter)),
        JsonLfEncoders.Field.of("availableArbitratorsCid", apply(JsonLfEncoders::contractId, availableArbitratorsCid)),
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
    if (!(object instanceof InvokeArbitrators)) {
      return false;
    }
    InvokeArbitrators other = (InvokeArbitrators) object;
    return Objects.equals(this.inviter, other.inviter) &&
        Objects.equals(this.availableArbitratorsCid, other.availableArbitratorsCid) &&
        Objects.equals(this.miReportCid, other.miReportCid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.inviter, this.availableArbitratorsCid, this.miReportCid);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.modella.InvokeArbitrators(%s, %s, %s)",
        this.inviter, this.availableArbitratorsCid, this.miReportCid);
  }
}

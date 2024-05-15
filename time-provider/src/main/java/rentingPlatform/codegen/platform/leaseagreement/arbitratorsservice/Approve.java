package rentingPlatform.codegen.platform.leaseagreement.arbitratorsservice;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

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

public class Approve extends DamlRecord<Approve> {
  public static final String _packageId = "bb7737a3fae0dab3c7cecc1b5d7d0840ffd1957d4501f41845dbecbd2bcf97c3";

  public final Service.ContractId serviceCid;

  public Approve(Service.ContractId serviceCid) {
    this.serviceCid = serviceCid;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Approve fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Approve> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      Service.ContractId serviceCid =
          new Service.ContractId(fields$.get(0).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected serviceCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new Approve(serviceCid);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("serviceCid", this.serviceCid.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<Approve> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("serviceCid"), name -> {
          switch (name) {
            case "serviceCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(rentingPlatform.codegen.platform.leaseagreement.arbitratorsservice.Service.ContractId::new));
            default: return null;
          }
        }
        , (Object[] args) -> new Approve(JsonLfDecoders.cast(args[0])));
  }

  public static Approve fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("serviceCid", apply(JsonLfEncoders::contractId, serviceCid)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Approve)) {
      return false;
    }
    Approve other = (Approve) object;
    return Objects.equals(this.serviceCid, other.serviceCid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.serviceCid);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.leaseagreement.arbitratorsservice.Approve(%s)",
        this.serviceCid);
  }
}

package rentingPlatform.codegen.platform.role.operator;

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
import rentingPlatform.codegen.platform.leaseagreement.arbitratorsservice.Service;

public class OfferArbitratorService extends DamlRecord<OfferArbitratorService> {
  public static final String _packageId = "3ab0b0842cdffab8c416d02894ad44bcc570eeb048f996af3c2257fb08640ba3";

  public final String arbitrator;

  public final Service.ContractId serviceCid;

  public OfferArbitratorService(String arbitrator, Service.ContractId serviceCid) {
    this.arbitrator = arbitrator;
    this.serviceCid = serviceCid;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static OfferArbitratorService fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<OfferArbitratorService> valueDecoder() throws
      IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      String arbitrator = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      Service.ContractId serviceCid =
          new Service.ContractId(fields$.get(1).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected serviceCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new OfferArbitratorService(arbitrator, serviceCid);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("arbitrator", new Party(this.arbitrator)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("serviceCid", this.serviceCid.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<OfferArbitratorService> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("arbitrator", "serviceCid"), name -> {
          switch (name) {
            case "arbitrator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "serviceCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(rentingPlatform.codegen.platform.leaseagreement.arbitratorsservice.Service.ContractId::new));
            default: return null;
          }
        }
        , (Object[] args) -> new OfferArbitratorService(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static OfferArbitratorService fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("arbitrator", apply(JsonLfEncoders::party, arbitrator)),
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
    if (!(object instanceof OfferArbitratorService)) {
      return false;
    }
    OfferArbitratorService other = (OfferArbitratorService) object;
    return Objects.equals(this.arbitrator, other.arbitrator) &&
        Objects.equals(this.serviceCid, other.serviceCid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.arbitrator, this.serviceCid);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.role.operator.OfferArbitratorService(%s, %s)",
        this.arbitrator, this.serviceCid);
  }
}

package rentingPlatform.codegen.platform.modella;

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
import rentingPlatform.codegen.time.clock.DateClockUpdateEvent;

public class ProcessPayment extends DamlRecord<ProcessPayment> {
  public static final String _packageId = "bef0965dc38d518ab3f749ea7cce7cf9cd13acb7b593b5f936707edcb2f1eff5";

  public final DateClockUpdateEvent.ContractId eventCid;

  public ProcessPayment(DateClockUpdateEvent.ContractId eventCid) {
    this.eventCid = eventCid;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static ProcessPayment fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<ProcessPayment> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      DateClockUpdateEvent.ContractId eventCid =
          new DateClockUpdateEvent.ContractId(fields$.get(0).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected eventCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new ProcessPayment(eventCid);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("eventCid", this.eventCid.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<ProcessPayment> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("eventCid"), name -> {
          switch (name) {
            case "eventCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(rentingPlatform.codegen.time.clock.DateClockUpdateEvent.ContractId::new));
            default: return null;
          }
        }
        , (Object[] args) -> new ProcessPayment(JsonLfDecoders.cast(args[0])));
  }

  public static ProcessPayment fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("eventCid", apply(JsonLfEncoders::contractId, eventCid)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof ProcessPayment)) {
      return false;
    }
    ProcessPayment other = (ProcessPayment) object;
    return Objects.equals(this.eventCid, other.eventCid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.eventCid);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.modella.ProcessPayment(%s)",
        this.eventCid);
  }
}

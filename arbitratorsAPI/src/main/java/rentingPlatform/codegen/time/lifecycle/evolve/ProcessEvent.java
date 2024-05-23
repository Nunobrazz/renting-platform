package rentingPlatform.codegen.time.lifecycle.evolve;

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

public class ProcessEvent extends DamlRecord<ProcessEvent> {
  public static final String _packageId = "b80ed0eb60b6c3d918d4f24fbb5689a03c7ad2642b523a689de07104f792b41f";

  public final DateClockUpdateEvent.ContractId eventCid;

  public ProcessEvent(DateClockUpdateEvent.ContractId eventCid) {
    this.eventCid = eventCid;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static ProcessEvent fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<ProcessEvent> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      DateClockUpdateEvent.ContractId eventCid =
          new DateClockUpdateEvent.ContractId(fields$.get(0).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected eventCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new ProcessEvent(eventCid);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("eventCid", this.eventCid.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<ProcessEvent> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("eventCid"), name -> {
          switch (name) {
            case "eventCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(rentingPlatform.codegen.time.clock.DateClockUpdateEvent.ContractId::new));
            default: return null;
          }
        }
        , (Object[] args) -> new ProcessEvent(JsonLfDecoders.cast(args[0])));
  }

  public static ProcessEvent fromJson(String json) throws JsonLfDecoder.Error {
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
    if (!(object instanceof ProcessEvent)) {
      return false;
    }
    ProcessEvent other = (ProcessEvent) object;
    return Objects.equals(this.eventCid, other.eventCid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.eventCid);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.time.lifecycle.evolve.ProcessEvent(%s)",
        this.eventCid);
  }
}

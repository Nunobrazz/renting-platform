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
import rentingPlatform.codegen.time.lifecycle.evolve.Evolve;

public class Approve extends DamlRecord<Approve> {
  public static final String _packageId = "a6bcfd7383b67eb87e5f0a5348ee1cec07394d6ff60d842a59c6ec0bfb5dfc76";

  public final String lifecycler;

  public final Evolve.ContractId evolveCid;

  public Approve(String lifecycler, Evolve.ContractId evolveCid) {
    this.lifecycler = lifecycler;
    this.evolveCid = evolveCid;
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
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      String lifecycler = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      Evolve.ContractId evolveCid =
          new Evolve.ContractId(fields$.get(1).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected evolveCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new Approve(lifecycler, evolveCid);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("lifecycler", new Party(this.lifecycler)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("evolveCid", this.evolveCid.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<Approve> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("lifecycler", "evolveCid"), name -> {
          switch (name) {
            case "lifecycler": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "evolveCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(rentingPlatform.codegen.time.lifecycle.evolve.Evolve.ContractId::new));
            default: return null;
          }
        }
        , (Object[] args) -> new Approve(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static Approve fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("lifecycler", apply(JsonLfEncoders::party, lifecycler)),
        JsonLfEncoders.Field.of("evolveCid", apply(JsonLfEncoders::contractId, evolveCid)));
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
    return Objects.equals(this.lifecycler, other.lifecycler) &&
        Objects.equals(this.evolveCid, other.evolveCid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.lifecycler, this.evolveCid);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.leaseagreement.service.Approve(%s, %s)",
        this.lifecycler, this.evolveCid);
  }
}

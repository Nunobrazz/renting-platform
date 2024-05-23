package rentingPlatform.codegen.interface$.signature;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.DamlCollectors;
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

public class SignatureView extends DamlRecord<SignatureView> {
  public static final String _packageId = "4f70403fcda1eda60c47e50a659fe21c06114319888163aa5702f0e89b553577";

  public final List<String> partiesToSign;

  public final List<String> alreadySigned;

  public SignatureView(List<String> partiesToSign, List<String> alreadySigned) {
    this.partiesToSign = partiesToSign;
    this.alreadySigned = alreadySigned;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static SignatureView fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<SignatureView> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      List<String> partiesToSign = PrimitiveValueDecoders.fromList(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(0).getValue());
      List<String> alreadySigned = PrimitiveValueDecoders.fromList(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(1).getValue());
      return new SignatureView(partiesToSign, alreadySigned);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("partiesToSign", this.partiesToSign.stream().collect(DamlCollectors.toDamlList(v$0 -> new Party(v$0)))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("alreadySigned", this.alreadySigned.stream().collect(DamlCollectors.toDamlList(v$0 -> new Party(v$0)))));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<SignatureView> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("partiesToSign", "alreadySigned"), name -> {
          switch (name) {
            case "partiesToSign": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "alreadySigned": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            default: return null;
          }
        }
        , (Object[] args) -> new SignatureView(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static SignatureView fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("partiesToSign", apply(JsonLfEncoders.list(JsonLfEncoders::party), partiesToSign)),
        JsonLfEncoders.Field.of("alreadySigned", apply(JsonLfEncoders.list(JsonLfEncoders::party), alreadySigned)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof SignatureView)) {
      return false;
    }
    SignatureView other = (SignatureView) object;
    return Objects.equals(this.partiesToSign, other.partiesToSign) &&
        Objects.equals(this.alreadySigned, other.alreadySigned);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.partiesToSign, this.alreadySigned);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.interface$.signature.SignatureView(%s, %s)",
        this.partiesToSign, this.alreadySigned);
  }
}

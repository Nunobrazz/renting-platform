package rentingPlatform.codegen.user;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Text;
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

public class SendMessage extends DamlRecord<SendMessage> {
  public static final String _packageId = "c911fdfc3964813e1caa91849f67e4b0ec3b6260c2d032ebcdf01d6c820d721b";

  public final String text;

  public final String sender;

  public SendMessage(String text, String sender) {
    this.text = text;
    this.sender = sender;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static SendMessage fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<SendMessage> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      String text = PrimitiveValueDecoders.fromText.decode(fields$.get(0).getValue());
      String sender = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      return new SendMessage(text, sender);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("text", new Text(this.text)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("sender", new Party(this.sender)));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<SendMessage> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("text", "sender"), name -> {
          switch (name) {
            case "text": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "sender": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            default: return null;
          }
        }
        , (Object[] args) -> new SendMessage(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static SendMessage fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(JsonLfEncoders.Field.of("text", apply(JsonLfEncoders::text, text)),
        JsonLfEncoders.Field.of("sender", apply(JsonLfEncoders::party, sender)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof SendMessage)) {
      return false;
    }
    SendMessage other = (SendMessage) object;
    return Objects.equals(this.text, other.text) && Objects.equals(this.sender, other.sender);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.text, this.sender);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.user.SendMessage(%s, %s)", this.text,
        this.sender);
  }
}

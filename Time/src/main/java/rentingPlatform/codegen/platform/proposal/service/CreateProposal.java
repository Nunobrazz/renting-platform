package rentingPlatform.codegen.platform.proposal.service;

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
import rentingPlatform.codegen.platform.types.common.House;
import rentingPlatform.codegen.platform.types.common.LeaseTerms;

public class CreateProposal extends DamlRecord<CreateProposal> {
  public static final String _packageId = "a6bcfd7383b67eb87e5f0a5348ee1cec07394d6ff60d842a59c6ec0bfb5dfc76";

  public final String proposer;

  public final House house;

  public final LeaseTerms leaseTerms;

  public CreateProposal(String proposer, House house, LeaseTerms leaseTerms) {
    this.proposer = proposer;
    this.house = house;
    this.leaseTerms = leaseTerms;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static CreateProposal fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<CreateProposal> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(3,0,
          recordValue$);
      String proposer = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      House house = House.valueDecoder().decode(fields$.get(1).getValue());
      LeaseTerms leaseTerms = LeaseTerms.valueDecoder().decode(fields$.get(2).getValue());
      return new CreateProposal(proposer, house, leaseTerms);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(3);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("proposer", new Party(this.proposer)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("house", this.house.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("leaseTerms", this.leaseTerms.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<CreateProposal> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("proposer", "house", "leaseTerms"), name -> {
          switch (name) {
            case "proposer": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "house": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, rentingPlatform.codegen.platform.types.common.House.jsonDecoder());
            case "leaseTerms": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, rentingPlatform.codegen.platform.types.common.LeaseTerms.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new CreateProposal(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2])));
  }

  public static CreateProposal fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("proposer", apply(JsonLfEncoders::party, proposer)),
        JsonLfEncoders.Field.of("house", apply(House::jsonEncoder, house)),
        JsonLfEncoders.Field.of("leaseTerms", apply(LeaseTerms::jsonEncoder, leaseTerms)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof CreateProposal)) {
      return false;
    }
    CreateProposal other = (CreateProposal) object;
    return Objects.equals(this.proposer, other.proposer) &&
        Objects.equals(this.house, other.house) &&
        Objects.equals(this.leaseTerms, other.leaseTerms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.proposer, this.house, this.leaseTerms);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.proposal.service.CreateProposal(%s, %s, %s)",
        this.proposer, this.house, this.leaseTerms);
  }
}

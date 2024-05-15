package rentingPlatform.codegen.platform.leaseagreement.arbitratorsservice;

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
import rentingPlatform.codegen.interface$.types.Responsability;
import rentingPlatform.codegen.platform.leaseagreement.modelmi.Votation;

public class SubmitVote extends DamlRecord<SubmitVote> {
  public static final String _packageId = "bb7737a3fae0dab3c7cecc1b5d7d0840ffd1957d4501f41845dbecbd2bcf97c3";

  public final String voter;

  public final Responsability vote;

  public final Votation.ContractId votationCid;

  public SubmitVote(String voter, Responsability vote, Votation.ContractId votationCid) {
    this.voter = voter;
    this.vote = vote;
    this.votationCid = votationCid;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static SubmitVote fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<SubmitVote> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(3,0,
          recordValue$);
      String voter = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      Responsability vote = Responsability.valueDecoder().decode(fields$.get(1).getValue());
      Votation.ContractId votationCid =
          new Votation.ContractId(fields$.get(2).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected votationCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new SubmitVote(voter, vote, votationCid);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(3);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("voter", new Party(this.voter)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("vote", this.vote.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("votationCid", this.votationCid.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<SubmitVote> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("voter", "vote", "votationCid"), name -> {
          switch (name) {
            case "voter": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "vote": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, rentingPlatform.codegen.interface$.types.Responsability.jsonDecoder());
            case "votationCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(rentingPlatform.codegen.platform.leaseagreement.modelmi.Votation.ContractId::new));
            default: return null;
          }
        }
        , (Object[] args) -> new SubmitVote(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2])));
  }

  public static SubmitVote fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("voter", apply(JsonLfEncoders::party, voter)),
        JsonLfEncoders.Field.of("vote", apply(Responsability::jsonEncoder, vote)),
        JsonLfEncoders.Field.of("votationCid", apply(JsonLfEncoders::contractId, votationCid)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof SubmitVote)) {
      return false;
    }
    SubmitVote other = (SubmitVote) object;
    return Objects.equals(this.voter, other.voter) && Objects.equals(this.vote, other.vote) &&
        Objects.equals(this.votationCid, other.votationCid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.voter, this.vote, this.votationCid);
  }

  @Override
  public String toString() {
    return String.format("rentingPlatform.codegen.platform.leaseagreement.arbitratorsservice.SubmitVote(%s, %s, %s)",
        this.voter, this.vote, this.votationCid);
  }
}

package ad.bidder.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Map;

/**
 * @author natalija
 */
@Data
@EqualsAndHashCode
@ToString
public class AdRequest {
    private String id;
    private Map<String, Object> attributes;
}

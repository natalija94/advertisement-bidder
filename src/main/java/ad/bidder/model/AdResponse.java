package ad.bidder.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author natalija
 */
@EqualsAndHashCode
@ToString
@Builder
@Data
public class AdResponse {
    private String id;
    private Double bid;
    private String content;
}
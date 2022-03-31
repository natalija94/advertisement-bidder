package ad.bidder.service;

import ad.bidder.exception.AdRequestFormatException;
import ad.bidder.model.AdRequest;
import ad.bidder.model.AdResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author natalija
 */
@Service
@Log4j2
public class AuctionRequestProcessor {

    public AdResponse processJsonRequest(String jsonRequest) throws AdRequestFormatException {
        AdRequest request = formatRequest(jsonRequest);
        return buildAdAuctionResponse(request);
    }

    public AdRequest formatRequest(String jsonRequest) throws AdRequestFormatException {
        if (StringUtils.isEmpty(jsonRequest)) {
            throw new AdRequestFormatException("Provided Json cannot be null");
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(jsonRequest, AdRequest.class);
        } catch (JsonProcessingException e) {
            throw new AdRequestFormatException("It is not the proper format of provided json.");
        }
    }

    private double getPriceForAuction() {
        BigDecimal randFromDouble = new BigDecimal(1000*Math.random());
        return randFromDouble.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }

    private AdResponse buildAdAuctionResponse(AdRequest adRequest) {
        if (adRequest == null) {
            throw new IllegalArgumentException("Method input must be specified.");
        }

        double price = getPriceForAuction();
        AdResponse response = AdResponse.builder()
                .id(adRequest.getId())
                .bid(getPriceForAuction())
                .content(String.format("%s:%s", adRequest.getId(), price))
                .build();
        log.info("Formatted response: {}", response);
        return response;
    }
}

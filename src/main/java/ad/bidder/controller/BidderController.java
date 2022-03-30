package ad.bidder.controller;

import ad.bidder.exception.AdRequestFormatException;
import ad.bidder.model.AdResponse;
import ad.bidder.service.AuctionRequestProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static ad.bidder.util.PathConstants.AD_REQUEST;
import static ad.bidder.util.PathConstants.BID_CONTROLLER_PATH;

/**
 * @author natalija
 */
@RestController
@Slf4j
@RequestMapping(value = BID_CONTROLLER_PATH,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class BidderController {

    final AuctionRequestProcessor auctionRequestProcessor;

    @Autowired
    public BidderController(AuctionRequestProcessor auctionRequestProcessor) {
        this.auctionRequestProcessor = auctionRequestProcessor;
    }

    @PostMapping(AD_REQUEST)
    public AdResponse auctionBid(@RequestBody String jsonRequest) {
        try {
            return auctionRequestProcessor.processJsonRequest(jsonRequest);
        } catch (AdRequestFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The request is not in expected JSON format. Please rely on documentation.", e);
        }
    }
}

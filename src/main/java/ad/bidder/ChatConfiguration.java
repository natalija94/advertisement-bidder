package ad.bidder;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author natalija
 */
@Configuration
@EnableAsync
@ComponentScan("ad.bidder")
public class ChatConfiguration {

}

package org.manu.spring.gcp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.function.Consumer;

@SpringBootApplication
@Slf4j
public class SpringCloudFunctionApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFunctionApplication.class, args);
		log.info("Starting my spring cloud fn...");
	}

	/**
	 * The background function which triggers on an event from Pub/Sub and consumes the Pub/Sub
	 * event message.
	 */
	@Bean
	public Consumer<PubSubMessage> pubSubFunction() {
		return message -> {
			// The PubSubMessage data field arrives as a base-64 encoded string and must be decoded.
			// See: https://cloud.google.com/functions/docs/calling/pubsub#event_structure
			String decodedMessage = new String(Base64.getDecoder().decode(message.getData()), StandardCharsets.UTF_8);
			log.info("Received Pub/Sub message with data: " + decodedMessage);
		};
	}
}

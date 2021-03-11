package org.manu.spring.gcp;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class PubSubMessage {
	private String data;
	private Map<String, String> attributes;
	private String messageId;
	private String publishTime;
}

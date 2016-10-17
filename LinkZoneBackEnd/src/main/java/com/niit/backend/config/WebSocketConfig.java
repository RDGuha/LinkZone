package com.niit.backend.config;

import org.springframework.context.annotation.Configuration;


@Configuration
@EnableWebSocketMessageBroker
//@ComponentScan("com.ahmad")
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{
 
	@Override
	public void configureMessageBroker(MessageBrokerRegistry messageBrokerRegistry){
		messageBrokerRegistry.enableSimpleBroker("/topic");
		messageBrokerRegistry.setApplicationDestinationPrefixes("/app");
	}
	
	

	@Override
	public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
		stompEndpointRegistry.addEndpoint("/chat").setAllowedOrigins("*").withSockJS();
		
	}
	
}

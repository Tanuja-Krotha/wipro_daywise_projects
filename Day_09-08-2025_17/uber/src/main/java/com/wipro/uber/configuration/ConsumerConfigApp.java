package com.wipro.uber.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.wipro.uber.dto.RideRequest;

@Configuration
public class ConsumerConfigApp {
	
	@Bean
    public ConsumerFactory<String, RideRequest> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), jsonDeserializer());
    }
	
	@Bean
	public JsonDeserializer<RideRequest> jsonDeserializer() {
	    JsonDeserializer<RideRequest> jsonDeserializer = new JsonDeserializer<>(RideRequest.class)
	    		.ignoreTypeHeaders();
	    //jsonDeserializer.addTrustedPackages("*");
	    return jsonDeserializer;
	}

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, RideRequest> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, RideRequest> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

}

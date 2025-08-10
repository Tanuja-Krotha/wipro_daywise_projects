package com.wipro.consumer.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.security.auth.Subject;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
public class AppConsumerConfig {

	/*@Bean
    public ConsumerFactory<String, String> consumerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(configProps);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }*/
	 @Bean
	    public ConsumerFactory<String, Subject> consumerFactory() {
	        JsonDeserializer<Subject> deserializer = new JsonDeserializer<>(Subject.class);
	        deserializer.setRemoveTypeHeaders(false);
	        deserializer.addTrustedPackages("*");
	        deserializer.setUseTypeMapperForKey(true);

	        Map<String, Object> config = new HashMap<>();
	        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	        config.put(ConsumerConfig.GROUP_ID_CONFIG, "my-group");
	        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);

	        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), deserializer);
	    }

	    @Bean
	    public ConcurrentKafkaListenerContainerFactory<String, Subject> kafkaListenerContainerFactory() {
	        ConcurrentKafkaListenerContainerFactory<String, Subject> factory =
	                new ConcurrentKafkaListenerContainerFactory<>();
	        factory.setConsumerFactory(consumerFactory());
	        return factory;
	    }

}

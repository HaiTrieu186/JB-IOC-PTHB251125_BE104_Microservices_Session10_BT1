package re.edu.pharmacyservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${kafka.topic.stock-events}")
    private String stockEventsTopic;

    @Value("${kafka.topic.price-updates}")
    private String priceUpdatesTopic;

    @Value("${kafka.topic.notifications}")
    private String notificationsTopic;

    @Bean
    public NewTopic stockEventsTopic() {
        return TopicBuilder.name(stockEventsTopic)
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic priceUpdatesTopic() {
        return TopicBuilder.name(priceUpdatesTopic)
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic notificationsTopic() {
        return TopicBuilder.name(notificationsTopic)
                .partitions(2)
                .replicas(1)
                .build();
    }
}
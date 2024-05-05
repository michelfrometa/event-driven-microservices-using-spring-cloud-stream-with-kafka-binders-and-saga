package org.aprender.playground.sec01;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;
import java.util.function.Function;

@Configuration
@Slf4j
public class KafkaConsumer {

    @Bean
    public Consumer<Flux<String>> consumerBinding() {
        return flux -> flux
                .doOnNext(log::info)
                .subscribe();
    }

    @Bean
    public Function<Flux<String>, Mono<Void>> functionBinding() {
        return flux -> flux
                .doOnNext(msg -> log.info("Function received: {}", msg))
                .then();
    }

}

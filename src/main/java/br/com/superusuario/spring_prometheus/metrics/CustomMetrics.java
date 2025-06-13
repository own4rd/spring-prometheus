package br.com.superusuario.spring_prometheus.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class CustomMetrics {

    private final Counter customMetricCounter;

    public CustomMetrics(MeterRegistry meterRegistry) {
        customMetricCounter = Counter.builder("aula_requests_total")
                .description("Número total de requisições")
                .tag("status", "200")
                .register(meterRegistry);
    }

    public void incrementCustomMetric() {
        customMetricCounter.increment();
    }
}

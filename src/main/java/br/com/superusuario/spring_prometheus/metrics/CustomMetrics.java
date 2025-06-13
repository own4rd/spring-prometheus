package br.com.superusuario.spring_prometheus.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class CustomMetrics {

    private final Counter customMetricCounter;
    private final AtomicLong freeBytesGauge;

    public CustomMetrics(MeterRegistry meterRegistry) {
        customMetricCounter = Counter.builder("aula_requests_total")
                .description("Número total de requisições")
                .tag("status", "200")
                .register(meterRegistry);


        freeBytesGauge = new AtomicLong(0);
        Gauge.builder("aula_free_bytes", freeBytesGauge, AtomicLong::get)
                .description("Quantidade de bytes livres")
                .register(meterRegistry);
    }

    public void incrementCustomMetric() {
        customMetricCounter.increment();
    }

    public void setFreeBytes(long bytes) {
        freeBytesGauge.set(bytes);
    }
}

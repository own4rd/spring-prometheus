package br.com.superusuario.spring_prometheus.metrics;

import io.micrometer.core.instrument.*;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;

@Component
public class CustomMetrics {

    private final Counter customMetricCounter;
    private final AtomicLong freeBytesGauge;
    private final Timer requestTimer;

    public CustomMetrics(MeterRegistry meterRegistry) {
        customMetricCounter = Counter.builder("aula_requests_total")
                .description("Número total de requisições")
                .tag("status", "200")
                .register(meterRegistry);


        freeBytesGauge = new AtomicLong(0);
        Gauge.builder("aula_free_bytes", freeBytesGauge, AtomicLong::get)
                .description("Quantidade de bytes livres")
                .register(meterRegistry);


        this.requestTimer = Timer.builder("aula_request_time_seconds")
                .description("Tempo de requisição da API")
                .serviceLevelObjectives(
                        Duration.ofMillis(100),
                        Duration.ofMillis(200),
                        Duration.ofMillis(300),
                        Duration.ofMillis(500)
                )
                .distributionStatisticExpiry(Duration.ofMinutes(5)) // opcional
                .distributionStatisticBufferLength(5)                // opcional
                .register(meterRegistry);
    }

    public void incrementCustomMetric() {
        customMetricCounter.increment();
    }

    public void setFreeBytes(long bytes) {
        freeBytesGauge.set(bytes);
    }

    public void record(double tempoEmSegundos) {
        long tempoEmMillis = (long) (tempoEmSegundos * 1000);
        requestTimer.record(tempoEmMillis, java.util.concurrent.TimeUnit.MILLISECONDS);
    }
}

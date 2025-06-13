package br.com.superusuario.spring_prometheus.metrics;

import io.prometheus.metrics.core.metrics.Counter;

public class CustomMetrics {

    public static final Counter AULA_REQUEST_COUNT = Counter.builder()
            .name("aula_requests_total")
            .help("Número total de requisições")
            .labelNames("statusCode")
            .register();
}


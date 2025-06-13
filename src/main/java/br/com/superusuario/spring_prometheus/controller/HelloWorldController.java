package br.com.superusuario.spring_prometheus.controller;

import br.com.superusuario.spring_prometheus.metrics.CustomMetrics;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String hello() {
        CustomMetrics.AULA_REQUEST_COUNT.labelValues("200").inc();
        return "Hello, world!";
    }
}


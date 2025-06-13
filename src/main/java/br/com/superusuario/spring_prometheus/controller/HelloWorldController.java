package br.com.superusuario.spring_prometheus.controller;

import br.com.superusuario.spring_prometheus.metrics.CustomMetrics;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private final CustomMetrics customMetrics;

    public HelloWorldController(CustomMetrics customMetrics) {
        this.customMetrics = customMetrics;
    }

    @GetMapping("/hello")
    public String hello() {
        customMetrics.incrementCustomMetric();

        double tempo = Math.min(Math.random() * 0.5, 0.5);
        customMetrics.record(tempo);
        return "Hello, world!";
    }
}

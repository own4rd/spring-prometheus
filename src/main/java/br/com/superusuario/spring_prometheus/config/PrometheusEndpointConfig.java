package br.com.superusuario.spring_prometheus.config;


import io.prometheus.metrics.exporter.servlet.jakarta.PrometheusMetricsServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrometheusEndpointConfig {

    @Bean
    public ServletRegistrationBean<PrometheusMetricsServlet> createPrometheusMetricsEndpoint() {
        return new ServletRegistrationBean<>(new PrometheusMetricsServlet(), "/metrics/*");
    }
}


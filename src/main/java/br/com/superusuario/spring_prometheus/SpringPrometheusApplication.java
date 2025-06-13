package br.com.superusuario.spring_prometheus;

import io.prometheus.metrics.instrumentation.jvm.JvmMetrics;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringPrometheusApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPrometheusApplication.class, args);
		JvmMetrics.builder().register();
	}

}

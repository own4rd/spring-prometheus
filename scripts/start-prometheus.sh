#! /bin/bash

docker run -d -p 9090:9090 -v "$PWD/prometheus.yml":/etc/prometheus/prometheus.yml prom/prometheus

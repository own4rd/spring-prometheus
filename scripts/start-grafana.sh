#! /bin/bash

docker run -d \
  -p 3000:3000 \
  --name grafana \
  grafana/grafana:latest

 echo "Grafana iniciado em http://localhost:3000 (usuário: admin, senha: admin)"


#!/usr/bin/env bash
set -euo pipefail

BASE_URL="${1:-http://localhost:8080}"

echo "Executando smoke test em ${BASE_URL}"

HEALTH=$(curl -sS "${BASE_URL}/actuator/health")
HOME_PAGE=$(curl -sS "${BASE_URL}/")

if [[ "${HEALTH}" != *'"status":"UP"'* ]]; then
  echo "Falha no endpoint de health"
  exit 1
fi

if [[ "${HOME_PAGE}" != *'Pipeline CI/CD com Java + Maven + SonarQube'* ]]; then
  echo "Falha na página inicial"
  exit 1
fi

echo "Smoke tests executados com sucesso"

#!/bin/bash
set -e

echo "Executando testes de integração..."
mvn -B -Dtest='*IntegrationTest' test
echo "Testes de integração executados com sucesso"

#!/bin/bash
set -e

echo "========================================="
echo "INICIANDO TESTES FUNCIONAIS"
echo "========================================="

mvn -B -Dtest='*FT' test

echo "========================================="
echo "TESTES FUNCIONAIS FINALIZADOS COM SUCESSO"
echo "========================================="
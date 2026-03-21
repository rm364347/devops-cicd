#!/bin/bash
set -e

echo "========================================="
echo "INICIANDO TESTES DE INTEGRAÇÃO"
echo "========================================="

mvn -B -Dtest='*IT' test

echo "========================================="
echo "TESTES DE INTEGRAÇÃO FINALIZADOS COM SUCESSO"
echo "========================================="

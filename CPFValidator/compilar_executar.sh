#!/bin/bash

# Criar diretório bin se não existir
mkdir -p bin

# Compilar todos os arquivos Java
echo "Compilando os arquivos Java..."
javac -d bin src/*.java

# Verificar se a compilação foi bem-sucedida
if [ $? -eq 0 ]; then
    echo "Compilação concluída com sucesso!"
    
    # Executar cada versão
    echo "Executando Versão com 1 Thread..."
    java -cp bin Versao1Thread
    
    echo "Executando Versão com 2 Threads..."
    java -cp bin Versao2Threads
    
    echo "Executando Versão com 3 Threads..."
    java -cp bin Versao3Threads
    
    echo "Executando Versão com 5 Threads..."
    java -cp bin Versao5Threads
    
    echo "Executando Versão com 6 Threads..."
    java -cp bin Versao6Threads
    
    echo "Executando Versão com 10 Threads..."
    java -cp bin Versao10Threads
    
    echo "Executando Versão com 15 Threads..."
    java -cp bin Versao15Threads
    
    echo "Executando Versão com 30 Threads..."
    java -cp bin Versao30Threads
    
    echo "Todas as versões foram executadas com sucesso!"
else
    echo "Erro na compilação!"
fi 
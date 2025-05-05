#!/bin/bash

mkdir -p bin # somente se n existir

echo "Compilando os arquivos Java..."
javac -d bin src/*.java

if [ $? -eq 0 ]; then
    echo "Compilação concluída com sucesso!"

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
# Sistema de Detecção de Fraudes em CPFs

## Descrição
Este sistema foi desenvolvido para analisar grandes volumes de dados de CPFs e verificar sua validade de acordo com o algoritmo oficial da Receita Federal. O objetivo é identificar possíveis fraudes em cadastros de clientes de um banco digital.

## Estrutura do Projeto
O projeto contém as seguintes classes:
- `CPFValidator`: Implementa o algoritmo de validação de CPF.
- `FileProcessor`: Responsável por ler os arquivos de texto contendo os CPFs.
- `ResultWriter`: Salva os resultados em arquivos.
- `CPFProcessorThread`: Classe responsável pelo processamento multithreaded dos arquivos.
- `Versao1Thread`, `Versao2Threads`, etc.: Implementações com diferentes números de threads.

## Versões Implementadas
Foram implementadas 8 versões do sistema, cada uma com um número diferente de threads:
1. Versão com 1 thread (30 arquivos para essa thread)
2. Versão com 2 threads (15 arquivos por thread)
3. Versão com 3 threads (10 arquivos por thread)
4. Versão com 5 threads (6 arquivos por thread)
5. Versão com 6 threads (5 arquivos por thread)
6. Versão com 10 threads (3 arquivos por thread)
7. Versão com 15 threads (2 arquivos por thread)
8. Versão com 30 threads (1 arquivo por thread)

## Como Compilar
Para compilar o projeto, navegue até o diretório raiz e execute o comando:
```
javac -d bin src/*.java
```

## Como Executar
Para executar cada versão do sistema, use os seguintes comandos:
```
java -cp bin Versao1Thread
java -cp bin Versao2Threads
java -cp bin Versao3Threads
java -cp bin Versao5Threads
java -cp bin Versao6Threads
java -cp bin Versao10Threads
java -cp bin Versao15Threads
java -cp bin Versao30Threads
```

## Resultados
Os resultados de tempo de execução são salvos em arquivos de texto com o formato `versao_X_threads.txt`, onde X é o número de threads utilizadas na execução. 
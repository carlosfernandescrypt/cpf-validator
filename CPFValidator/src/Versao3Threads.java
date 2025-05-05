import java.util.ArrayList;
import java.util.List;

public class Versao3Threads {
    public static void main(String[] args) {
        String diretorioCPFs = "/home/sea/Documentos/N!/cpfs";
        List<String> todosArquivos = FileProcessor.listarArquivos(diretorioCPFs);
        
        System.out.println("Versão 3 Threads - Iniciando processamento de " + todosArquivos.size() + " arquivos...");
        
        List<List<String>> arquivosPorThread = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            arquivosPorThread.add(new ArrayList<>());
        }
        
        for (int i = 0; i < todosArquivos.size(); i++) {
            arquivosPorThread.get(i % 3).add(todosArquivos.get(i));
        }
        
        long inicio = System.currentTimeMillis();
        
        CPFProcessorThread[] threads = new CPFProcessorThread[3];
        for (int i = 0; i < 3; i++) {
            threads[i] = new CPFProcessorThread(arquivosPorThread.get(i));
            threads[i].start();
        }
        
        try {
            for (CPFProcessorThread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        long fim = System.currentTimeMillis();
        long tempoExecucao = fim - inicio;
        
        int cpfsValidos = 0;
        int cpfsInvalidos = 0;
        
        for (CPFProcessorThread thread : threads) {
            cpfsValidos += thread.getCpfsValidos();
            cpfsInvalidos += thread.getCpfsInvalidos();
        }
        
        System.out.println("CPFs válidos: " + cpfsValidos);
        System.out.println("CPFs inválidos: " + cpfsInvalidos);
        System.out.println("Tempo de execução: " + tempoExecucao + " ms");
        
        ResultWriter.salvarTempoExecucao("versao_3_threads.txt", tempoExecucao);
    }
} 
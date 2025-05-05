import java.util.ArrayList;
import java.util.List;

public class Versao30Threads {
    public static void main(String[] args) {
        String diretorioCPFs = "/home/sea/Documentos/N!/cpfs";
        List<String> todosArquivos = FileProcessor.listarArquivos(diretorioCPFs);
        
        System.out.println("Versão 30 Threads - Iniciando processamento de " + todosArquivos.size() + " arquivos...");
        
        long inicio = System.currentTimeMillis();
        
        CPFProcessorThread[] threads = new CPFProcessorThread[todosArquivos.size()];
        
        for (int i = 0; i < todosArquivos.size(); i++) {
            List<String> arquivoThread = new ArrayList<>();
            arquivoThread.add(todosArquivos.get(i));
            
            threads[i] = new CPFProcessorThread(arquivoThread);
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
        
        ResultWriter.salvarTempoExecucao("versao_30_threads.txt", tempoExecucao);
    }
} 
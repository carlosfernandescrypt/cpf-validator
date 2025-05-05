import java.util.ArrayList;
import java.util.List;

public class Versao2Threads {
    public static void main(String[] args) {
        String diretorioCPFs = "/home/sea/Documentos/N!/cpfs";
        List<String> todosArquivos = FileProcessor.listarArquivos(diretorioCPFs);
        
        System.out.println("Versão 2 Threads - Iniciando processamento de " + todosArquivos.size() + " arquivos...");
        
        List<String> arquivosThread1 = new ArrayList<>();
        List<String> arquivosThread2 = new ArrayList<>();
        
        for (int i = 0; i < todosArquivos.size(); i++) {
            if (i < todosArquivos.size() / 2) {
                arquivosThread1.add(todosArquivos.get(i));
            } else {
                arquivosThread2.add(todosArquivos.get(i));
            }
        }
        
        long inicio = System.currentTimeMillis();
        
        CPFProcessorThread thread1 = new CPFProcessorThread(arquivosThread1);
        CPFProcessorThread thread2 = new CPFProcessorThread(arquivosThread2);
        
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        long fim = System.currentTimeMillis();
        long tempoExecucao = fim - inicio;
        
        int cpfsValidos = thread1.getCpfsValidos() + thread2.getCpfsValidos();
        int cpfsInvalidos = thread1.getCpfsInvalidos() + thread2.getCpfsInvalidos();
        
        System.out.println("CPFs válidos: " + cpfsValidos);
        System.out.println("CPFs inválidos: " + cpfsInvalidos);
        System.out.println("Tempo de execução: " + tempoExecucao + " ms");
        
        ResultWriter.salvarTempoExecucao("versao_2_threads.txt", tempoExecucao);
    }
} 
import java.util.List;

public class Versao1Thread {
    public static void main(String[] args) {
        String diretorioCPFs = "/home/sea/Documentos/N!/cpfs";
        List<String> arquivos = FileProcessor.listarArquivos(diretorioCPFs);
        
        System.out.println("Versão 1 Thread - Iniciando processamento de " + arquivos.size() + " arquivos...");
        
        long inicio = System.currentTimeMillis();
        
        CPFProcessorThread thread = new CPFProcessorThread(arquivos);
        thread.start();
        
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        long fim = System.currentTimeMillis();
        long tempoExecucao = fim - inicio;
        
        int cpfsValidos = thread.getCpfsValidos();
        int cpfsInvalidos = thread.getCpfsInvalidos();
        
        System.out.println("CPFs válidos: " + cpfsValidos);
        System.out.println("CPFs inválidos: " + cpfsInvalidos);
        System.out.println("Tempo de execução: " + tempoExecucao + " ms");
        
        ResultWriter.salvarTempoExecucao("versao_1_thread.txt", tempoExecucao);
    }
} 
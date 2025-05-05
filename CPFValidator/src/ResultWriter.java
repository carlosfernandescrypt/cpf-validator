import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ResultWriter {
    public static void salvarTempoExecucao(String nomeArquivo, long tempoExecucao) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write("Tempo de execução: " + tempoExecucao + " ms");
        } catch (IOException e) {
            System.err.println("Erro ao salvar o tempo de execução no arquivo: " + nomeArquivo);
            e.printStackTrace();
        }
    }
} 
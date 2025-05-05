import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor {
    private String caminhoArquivo;
    private int cpfsValidos;
    private int cpfsInvalidos;

    public FileProcessor(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
        this.cpfsValidos = 0;
        this.cpfsInvalidos = 0;
    }

    public void processarArquivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                linha = linha.trim();
                if (!linha.isEmpty()) {
                    if (CPFValidator.validaCPF(linha)) {
                        cpfsValidos++;
                    } else {
                        cpfsInvalidos++;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + caminhoArquivo);
            e.printStackTrace();
        }
    }

    public int getCpfsValidos() {
        return cpfsValidos;
    }

    public int getCpfsInvalidos() {
        return cpfsInvalidos;
    }

    public static List<String> listarArquivos(String diretorio) {
        java.io.File dir = new java.io.File(diretorio);
        List<String> arquivos = new ArrayList<>();
        
        if (dir.exists() && dir.isDirectory()) {
            for (java.io.File arquivo : dir.listFiles()) {
                if (arquivo.isFile() && arquivo.getName().matches("f\\d+-4-25\\.txt")) {
                    arquivos.add(arquivo.getAbsolutePath());
                }
            }
        }
        
        return arquivos;
    }
} 
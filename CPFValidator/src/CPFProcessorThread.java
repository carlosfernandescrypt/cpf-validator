import java.util.List;

public class CPFProcessorThread extends Thread {
    private List<String> arquivos;
    private int cpfsValidos;
    private int cpfsInvalidos;

    public CPFProcessorThread(List<String> arquivos) {
        this.arquivos = arquivos;
        this.cpfsValidos = 0;
        this.cpfsInvalidos = 0;
    }

    @Override
    public void run() {
        for (String arquivo : arquivos) {
            FileProcessor processor = new FileProcessor(arquivo);
            processor.processarArquivo();
            cpfsValidos += processor.getCpfsValidos();
            cpfsInvalidos += processor.getCpfsInvalidos();
        }
    }

    public int getCpfsValidos() {
        return cpfsValidos;
    }

    public int getCpfsInvalidos() {
        return cpfsInvalidos;
    }
} 
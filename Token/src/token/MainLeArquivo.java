package lexersimples;

import java.io.IOException;

public class MainLeArquivo {
    public static void main(String[] args) throws IOException{
        String path = "code.txt";
        LeArquivo.leitor(path);
    }
}

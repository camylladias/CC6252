package lexersimples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeArquivo {

    public static void leitor(String path) throws IOException {
	BufferedReader buffRead = new BufferedReader(new FileReader(path));
	String linha = "";
        while (true) {
            if (linha != null) {
            } else
            break;
            linha = buffRead.readLine();
	}
	buffRead.close();
    }
}

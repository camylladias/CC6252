import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main{

  public static void main(String[] args) throws IOException{
    // ler codigo -> passar para o lexico -> passar para o sintatico -> fazer a traducao    	
    //
    System.out.println("Digite o seu codigo:");
    //fazer leitura do codigo do usuario
    CharStream input = CharStreams.fromStream(System.in);
    // instanciar o analisar lexico
    atribuicaoLexer lexer = new atribuicaoLexer(input);
    // gerar os tokens
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    // instanciar o analisador sintatico
    atribuicaoParser parser = new atribuicaoParser(tokens); 
    ParseTree tree = parser.init();
    // andar sobre a arvore de derivacao
    ParseTreeWalker walker = new ParseTreeWalker();
    //inicia a traducao
    Tradutor tr = new Tradutor();
    walker.walk(tr, tree);
  }
}

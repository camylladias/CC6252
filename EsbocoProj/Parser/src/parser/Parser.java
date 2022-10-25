package parser;

import java.util.ArrayList;

public class Parser {
    private ArrayList<Token> tokens;
    private Token atual;
    
    public Token getnextToken(){
        Token t = tokens.get(0);
        tokens.remove(0);
        
        return t;
    }
    
    private void erro(String regra) {
        System.out.println("Regra: " + regra);
        System.out.println("token inválido: " + atual.getValor());
        System.exit(0);
    }
    
    public void function(){
        if (atual.getValor().equals("float")){
            atual = getnextToken();
            if (atual.getTipo().equals("id")){
                atual = getnextToken();    
                lparen();
                if (atual.getTipo().equals("args")){
                    atual = getnextToken();    
                    rparen();
                    if (atual.getValor().equals("{")){
                        atual = getnextToken();  
                        if (atual.getTipo().equals("comando")){
                            atual = getnextToken();    
                            if (atual.getValor().equals("}")){
                                atual = getnextToken();    

                            }else{
                                erro("'}' esperado");
                            }
                        }else{
                            erro("tipo Comando esperado");
                        }

                    }else{
                        erro("'{' esperado");
                    }
                }else{
                    erro("tipo args esperado");
                }
            }else{
                erro("tipo Id esperado");
            }
        }else{
            erro("'float' esperado");
        }
        
    }
    public void lparen(){
        if(atual.getValor().equals("(")){
            atual = getnextToken();
        }else{
            erro("'(' esperado");
        }
    }
    public void rparen(){
        if(atual.getValor().equals(")")){
            atual = getnextToken();
        }else{
            erro("')' esperado");
        }
    }
    
    
    public void fator(){
        if(atual.getTipo().equals("id") ||atual.getTipo().equals("id")){
           atual = getnextToken();
        }else{
            erro("Num ou Id esperado");
        }
    }
    public Parser(ArrayList<Token> tokens){
        this.tokens = tokens;
        System.out.println(tokens.size());
        System.out.println(getnextToken().getValor());
        System.out.println(getnextToken().getValor());
        System.out.println(tokens.size());
    }
}

package analizadorlexico;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
    // Define la lista de tokens conocidos
    private String codigo="";
    
   LinkedList<String> tokens = new LinkedList<>();
    
    private final String[] CLAVE = {
            // Palabras clave
            "break", "case", "catch", "class", "const", "continue", "debugger",
            "default", "delete", "do", "else", "export", "extends", "finally",
            "for", "function", "if", "import", "in", "instanceof", "new", "return",
            "super", "switch", "this", "throw", "try", "typeof", "var", "void",
            "while", "with"};

    private final String[] LIBRERIAS={"console"};
    
    private final String[] METODOS={"log"};
    
    private final String[] LITERALES = {            
            "\\\"([^\"]|\\.)*\"","'([^\']|\\.)*\'","(?<!\\w)\\d+\\.\\d+\\b","(?<!\\w)\\d+\\b","\\btrue\\b", "\\bfalse\\b", "\\bnull\\b"};
    
    private final String[] OPERADOR = {
            // Operadores lógicos
            "&&", "\\|\\|", "\\!", "\\|", "~"};
    
    private final String[] RELACIONAL = {"\\!=", "\\!==", "===", "==", ">", "<", ">=", "<="};
    
    private final String[] ASIGNACION = {"=", "\\+=", "\\-=", "\\*=", "\\/=", "\\%=", "\\**="};
    
    private final String[] ARITMETICO = {"\\+\\+", "--", "\\+", "-","/", "\\^", "\\*", "\\%", "\\*"};
    
    private final String[] SEPARADORES = {"\\(", "\\)", "\\{", "\\}", ";", ",", "\\.", "\\[", "\\]"}; //Separadores
            
    private final String REGEXIDENTIFICADOR = "(?<!\\w)[a-zA-Z_$][a-zA-Z0-9_$]*";

    // Construye la expresión regular para buscar los tokens
    private final String REGEXCLAVE = String.join("|", CLAVE);
    private final String REGEX_LIBRERIAS = String.join("|", LIBRERIAS);
    private final String REGEX_METODOS = String.join("|", METODOS);
    private final String REGEXLITERAL = String.join("|", LITERALES);
    private final String REGEXSEPARADOR = String.join("|", SEPARADORES);
    private final String REGEXOPERADOR = String.join("|", OPERADOR);
    private final String REGEXRELACIONAL = String.join("|", RELACIONAL);
    private final String REGEXASIGNACION = String.join("|", ASIGNACION);
    private final String REGEXARITMETICO = String.join("|", ARITMETICO);
    
    private Pattern pTodos = Pattern.compile("//|"+REGEXLITERAL+'|'+REGEXCLAVE+'|'+REGEX_LIBRERIAS+'|'+REGEX_METODOS+'|'+REGEXIDENTIFICADOR+'|'+REGEXSEPARADOR+'|'+REGEXRELACIONAL+'|'+REGEXASIGNACION+'|'+REGEXARITMETICO+'|'+REGEXOPERADOR+'|'+"\\w+");

    // Método para analizar el código fuente y devolver una lista de tokens
    public LinkedList analizar(String codigo){
        
        LinkedList<String> tipoToken=new LinkedList<>();
        Matcher todos = pTodos.matcher(codigo);
        
        while (todos.find()) {
            tokens.offer(todos.group());
        }
        
        while(!tokens.isEmpty()){
            String tokenAct=tokens.poll();
            String tipo="Desconocido";            

            if(tokenAct.matches(REGEXLITERAL)){
                tipo="Literal";
            }else if(tokenAct.matches(REGEXCLAVE)){
                tipo="Palabra reservada";
            }else if(tokenAct.matches(REGEX_LIBRERIAS)){
                tipo="Libreria";
            }else if(tokenAct.matches(REGEX_METODOS)){
                tipo="Método";
            }else if(tokenAct.matches(REGEXIDENTIFICADOR)){
                tipo="Identificador";
            }else if(tokenAct.matches(REGEXSEPARADOR)){
                if(tokenAct.equalsIgnoreCase("(")){
                    tipo="Parent-A";
                }else if(tokenAct.equalsIgnoreCase(")")){
                    tipo="Parent-C";
                }else if(tokenAct.equalsIgnoreCase("{")){
                    tipo="Llave-A";
                }else if(tokenAct.equalsIgnoreCase("}")){
                    tipo="Llave-C";
                }else if(tokenAct.equalsIgnoreCase(";")){
                    tipo="Cierre";
                }else if(tokenAct.equalsIgnoreCase(",")){
                    tipo="Coma";
                }else if(tokenAct.equalsIgnoreCase(".")){
                    tipo="Punto";
                }else if(tokenAct.equalsIgnoreCase("[")){
                    tipo="Corch-A";
                }else if(tokenAct.equalsIgnoreCase("]")){
                    tipo="Corch-C";
                }else{
                    tipo="SEPARADOR";
                }
            }else if(tokenAct.matches("//")){
                tipo="Comentario";
            }else if(tokenAct.matches(REGEXRELACIONAL)){
                tipo="Op relacional";
            }else if(tokenAct.matches(REGEXASIGNACION)){
                tipo="Op de asignación";
            }else if(tokenAct.matches(REGEXARITMETICO)){
                tipo="Op aritmético";
            }else if(tokenAct.matches(REGEXOPERADOR)){
                tipo="Op lógico";
            }
            
            tipoToken.offer(tipo);
            
            System.out.println(tokenAct +": "+tipo);
        }       
        
        return tipoToken;
      
    }
    
}

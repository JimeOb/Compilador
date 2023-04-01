package Old;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexerOld {
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

    private final String[] LIBRERIAS={"console","log"};
    
    private final String[] LITERAL = {            
            "\\\"([^\"]|\\.)*\"", // Cadenas de caracteres con comillas dobles
            "'([^\']|\\.)*\'"}; // Cadenas de caracteres con comillas simples
            
    private final String[] NUMEROS = {"(?<!\\w)\\d+\\.\\d+\\b","(?<!\\w)\\d+\\b"}; // Números 
    
    private final String[] LIT_BOOLEANO = {"\\btrue\\b", "\\bfalse\\b", "\\bnull\\b"}; //Booleanos
    
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
    private final String REGEXLIT_NUMEROS = String.join("|", NUMEROS);
    private final String REGEXLIT_BOOLEANOS = String.join("|", LIT_BOOLEANO);
    private final String REGEX_LIBRERIAS = String.join("|", LIBRERIAS);
    private final String REGEXLITERAL = String.join("|", LITERAL);
    private final String REGEXSEPARADOR = String.join("|", SEPARADORES);
    private final String REGEXOPERADOR = String.join("|", OPERADOR);
    private final String REGEXRELACIONAL = String.join("|", RELACIONAL);
    private final String REGEXASIGNACION = String.join("|", ASIGNACION);
    private final String REGEXARITMETICO = String.join("|", ARITMETICO);
    
    
    private Pattern pClave = Pattern.compile(REGEXCLAVE);
    private Pattern pNumeros = Pattern.compile(REGEXLIT_NUMEROS);
    private Pattern pBooleanos = Pattern.compile(REGEXLIT_BOOLEANOS);
    private Pattern pLiteral = Pattern.compile(REGEXLITERAL);
    private Pattern pOperador = Pattern.compile(REGEXOPERADOR);
    private Pattern pRelacional = Pattern.compile(REGEXRELACIONAL);
    private Pattern pAsignacion = Pattern.compile(REGEXASIGNACION);
    private Pattern pAritmetico = Pattern.compile(REGEXARITMETICO);
    private Pattern pSeparador = Pattern.compile(REGEXSEPARADOR);
    private Pattern pIdentificador = Pattern.compile(REGEXIDENTIFICADOR);
    
    private Pattern pTodos = Pattern.compile(REGEXLITERAL+'|'+REGEXLIT_NUMEROS+'|'+REGEXLIT_BOOLEANOS+'|'+REGEXCLAVE+'|'+REGEX_LIBRERIAS+'|'+REGEXIDENTIFICADOR+'|'+REGEXSEPARADOR+'|'+REGEXRELACIONAL+'|'+REGEXASIGNACION+'|'+REGEXARITMETICO+'|'+REGEXOPERADOR+'|'+"\\w+");

    // Método para analizar el código fuente y devolver una lista de tokens
    public void analizar(String codigo){
        
        
        
        analizadorE(pLiteral.matcher(this.codigo), "literal de cadena de texto");
        analizadorE(pNumeros.matcher(this.codigo), "literal numérico");
        analizadorE(pBooleanos.matcher(this.codigo), "literal booleano");
        analizadorE(pClave.matcher(this.codigo), "palabra reservada");
        analizadorE(pIdentificador.matcher(this.codigo), "identificador");        
        analizadorE(pSeparador.matcher(this.codigo), "separador");
        analizadorE(pRelacional.matcher(this.codigo), "operador relacional");
        analizadorE(pAsignacion.matcher(this.codigo), "operador de asignación");
        analizadorE(pAritmetico.matcher(this.codigo), "operador aritmético");
        analizadorE(pOperador.matcher(this.codigo), "operador lógico");
        
        
        if(this.codigo.trim().equals("")){
            System.out.println("TODO CORRECTO");
        }else{
            String[] errores = this.codigo.replaceAll("\\s+", " ").trim().split(" ");
            
            for (String error : errores) {
                System.out.println(error +": TOKEN NO VÁLIDO");
            }
        }
        
        // Encuentra cada token y agrégalo a la lista 
    }
    
    private void analizadorE(Matcher m, String tipo){
        
        while(m.find()){
            //System.out.println(m.group() +": "+tipo);
            
            if(tipo.equals("operador lógico") || tipo.equals("separador") || tipo.equals("operador aritmético") || tipo.equals("operador de asignación") || tipo.equals("operador relacional")){
                this.codigo=this.codigo.replaceFirst("\\"+m.group(), "");
            }else{
                this.codigo=this.codigo.replaceFirst(m.group(), "");
            }            
        }
    }
 
}

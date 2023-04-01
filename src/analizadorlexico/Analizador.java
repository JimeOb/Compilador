/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorlexico;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

//import org.antlr.v4.runtime.*;
//import org.antlr.v4.runtime.tree.*;


/**
 *
 * @author flora
 */
public class Analizador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList<String> tokens;
        Lexer analizadorL=new Lexer();
        String codigo="";
       
        try {
            BufferedReader reader = new BufferedReader(new FileReader("archivo.txt"));
            String linea;
            StringBuilder contenido = new StringBuilder();
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea);
                contenido.append("\n");
            }
            reader.close();
            codigo=contenido.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }      
              
        codigo=codigo.replaceAll("\\s+"," ").trim();
        
        tokens=analizadorL.analizar(codigo);
        
       // Sintaxis analizadorS=new Sintaxis(tokens);
       // analizadorS.imprimir();
       


       
        
    }
    
}

package analizadorlexico;

import java.util.LinkedList;

public class Sintaxis {
    
    LinkedList<String> tiposT;
    
    
    
    public Sintaxis(LinkedList<String> tiposT) {
        this.tiposT = tiposT;
    }

    public void imprimir() {
        for(String token: tiposT){
            System.out.println(token);
        }
    }
    
    public void analizar(){
        while(!tiposT.isEmpty()){
            String tipoA=tiposT.poll();
            if(tipoA.matches(tipoA)){
                
            }
        }
    }
}

# Compilador de Javascript en Java

<h4>Creado por: </h4>

  <ul>

   <li>Daniel Mauricio Cuesta Forero 20182020147 </li>
   <li>William Santiago Florian French 20192020007 </li>
   <li>Jersson Javier Ortegate Banderas 20201020139</li>
  
  </ul>

<div>
    <h3>Descripción:</h3>
    <p>El objetivo del proyecto es desarrollar un compilador de JavaScript en Java. Para lograr este objetivo, se deben implementar los siguientes componentes del compilador:

Analizador léxico: Este componente del compilador será responsable de analizar el código fuente de JavaScript y dividirlo en tokens o símbolos léxicos. El analizador léxico identificará cada palabra clave, identificador, operador, signo de puntuación y otros símbolos en el código fuente de JavaScript y los transformará en tokens. Los tokens se pasarán al analizador sintáctico para su posterior análisis.

Analizador sintáctico: Este componente del compilador analizará los tokens generados por el analizador léxico y comprobará si cumplen con la gramática de JavaScript. El analizador sintáctico construirá un árbol de sintaxis abstracta (AST) que representa la estructura del código fuente de JavaScript. Si el código fuente no cumple con la gramática de JavaScript, el analizador sintáctico generará un error de sintaxis.

Analizador semántico: Este componente del compilador analizará el AST generado por el analizador sintáctico y comprobará si cumple con las reglas semánticas de JavaScript. El analizador semántico verificará que los identificadores se hayan declarado antes de ser utilizados, que los tipos de datos sean compatibles en las operaciones, que las variables se utilicen correctamente en las declaraciones, entre otros aspectos. Si el código fuente no cumple con las reglas semánticas de JavaScript, el analizador semántico generará un error semántico.

Generador de código: Este componente del compilador tomará el AST validado por el analizador semántico y generará código objeto o bytecode. El código objeto es un formato de código intermedio que puede ser ejecutado por una máquina virtual de JavaScript. El generador de código se encargará de traducir el AST en código objeto.

Una vez que se hayan implementado estos componentes, se puede probar el compilador generando código objeto a partir del código fuente de JavaScript. También se pueden agregar características adicionales, como optimización de código, depuración y soporte para diferentes versiones de JavaScript.</p>

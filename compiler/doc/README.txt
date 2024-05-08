Compilador alike.jar (V1.0)
------------------------------
Autores:
- Daniel Herce Cruz, 848884
- Lucas Cauhé Viñao, 844665

Análisis léxico y sintáctico


Invocar como:

-------------------------------------------------------------
java -jar alike.jar <fichero_fuente_clike>
-------------------------------------------------------------

Si se invoca sin parámetros, lee desde la entrada estándar.

Compilación (desde la raíz del proyecto):

-------------------------------------------------------------
ant
-------------------------------------------------------------


Ejecución de los tests:
-------------------------------------------------------------
python3 test/test_alike.py dist/alike_4.jar test/
-------------------------------------------------------------

Características generales:

Contiene un analizador léxico y sintáctico (parser) para el lenguaje Alike
El lenguaje aceptado es de nivel 4

ESTADO ACTUAL -> no se generan los codeblocks de funciones y procs anidados


Analizador Semántico:
---------------------------------------------
El lenguaje permite el uso de parámetros escalares y de vectores, tanto por valor como por referencia en procedimientos y funciones (NIVEL 4)
Las inserciones en la tabla de símbolos se realizan en el nivel más alto que se pueda, de esta forma se tiene control total sobre qué símbolos se insertan en qué bloque y cuándo.
Se tiene recuperación de errores sintácticos y semánticos para hacer un análisis de todo el fichero fuente.
cuando hay un error semántico en una expresión por error de tipos, acabas propagando el tipo esperado para no tener efectos colaterales en posteriores expresiones que pueden estar bien definidas.
Se detectan los siguientes warnings -> 
    - División entera entre 0 cuando el 0 es producido por una serie de literales evaluables en tiempo de compilación.
    - Resultado de función no capturado
    - Guardas constantes cuando se utilizan operandos literales

Modificaciones en la Tabla de Símbolos:
---------------------------------------------
Se ha añadido el tipo VOID
Las consultas a la tabla de símbolos se transforman a minúsculas para hacer el lenguaje case insensitive

Organización del proyecto
---------------------------------------------
 - traductor/alike_4.jj -> fichero JavaCC del compilador
 - lib -> directorio de librerías para el compilador
 - lib/tools/SemanticFunctions.java -> Manejo a nivel semántico de la operativa del compilador
 - lib/tools/TypeValue.java -> Tipo de dato para atributos sintetizados empleado en el análisis semántico
 - lib/tools/exceptions -> Excepciones para el análisis semántico
 - lib/tools/Constants.java -> Constantes empleadas en el análisis semántico, actualmente solo la opción verbose
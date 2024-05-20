Compilador alike.jar (V1.0)
------------------------------
Autores:
- Daniel Herce Cruz, 848884
- Lucas Cauhé Viñao, 844665

Análisis léxico y sintáctico


Invocar como:

-------------------------------------------------------------
java -jar alike.jar [-c] [-x] [-v] <fichero_fuente_alike_sin_extensión>
-------------------------------------------------------------

Si se invoca sin parámetros, lee desde la entrada estándar.
El propio alike_4.jar generado permite los flags de -c para comentarios, -v para modo verboso y -x para generar XML.

Compilación (desde la raíz del proyecto):

-------------------------------------------------------------
ant
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

Generación de código:
---------------------------------------------
Se ha definido un nuevo objeto Attributes que permite almacenar el tipo de parámetros (valor o referencia) a la hora de realizar invocaciones
a funciones o procedimientos. Cada vez que se detecta una expresión, se consume un elemento de la cola FIFO de parámetros y se genera código 
consecuentemente y teniendo en cuenta el nivel 4 para el que está diseñado el compilador. Además, este objeto almacena un callback para instrucciones 
de I/O que permite resolver la operación directamente al nivel de donde se detecte la expresión con la que interactuar. Para strings esto es necesario
dado el planteamiento de la generación de código en la que al detectarse tókenes válidos, se apila en el stack su representación (valor, dirección o resolución de indirección)
 correspondiente para su uso posterior.

Para expresiones condicionales que se puedan resolver en tiempo de compilación se generará, o no, código, dependiendo también en el
análisis de condiciones previas que permitan no tener que generar el código correspondiente.

En el momento que se detecte un error de cualquier tipo, el compilador dejará de generar código. Esto está controlado por el objeto Constants
donde también se incluyen flags para depuración (comentarios y XML en el código de máquina P y mensajes por stdout).


Organización del proyecto
---------------------------------------------
 - traductor/alike_4.jj -> fichero JavaCC del compilador
 - lib -> directorio de librerías para el compilador
 - lib/tools/SemanticFunctions.java -> Manejo a nivel semántico de la operativa del compilador
 - lib/tools/TypeValue.java -> Tipo de dato para atributos sintetizados empleado en el análisis semántico
 - lib/tools/exceptions -> Excepciones para el análisis semántico
 - lib/tools/Constants.java -> Constantes empleadas en el análisis semántico, actualmente solo la opción verbose
 - lib/attributes/Attributes.java -> Gestión de parámetros de invocables e instrucciones de callback para I/O.
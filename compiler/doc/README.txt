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


Analizador Semántico:
---------------------------------------------
Las inserciones en la tabla de símbolos se realizan en el nivel más alto que se pueda.
De esta forma se tiene control total sobre qué símbolos se insertan en qué bloque y cuándo.
No se permite lógica booleana con operadores no booleanos (1 AND 0 no está permitido al igual que 2 OR 'a')
Para asegurarse de que las funciones devuelvan el tipo correcto, las instrucciones devolverán un tipo concreto (asignaciones void, returns el tipo que devuelvan) y 
si al final el conjunto de elementos devueltos es {void, <tipo esperado>} correcto, si no error (con tipos incorrectos salta antes el error)
Una función/procedimiento no devuelve referencias (mala praxis)
cuando hay un error semántico en una expresión por error de tipos, acabas propagando el tipo esperado para no tener efectos colaterales en posteriores expresiones que pueden estar bien definidas

Modificaciones TS:
---------------------------------------------
Se ha añadido el tipo VOID
Las consultas a la tabla de símbolos se transforman a minúsculas para hacer el lenguaje case insensitive

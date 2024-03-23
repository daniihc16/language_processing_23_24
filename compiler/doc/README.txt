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
python3 ../test/test_alike.py ./dist/alike.jar ../test/
-------------------------------------------------------------

Características generales:

Contiene un analizador léxico y sintáctico (parser) para el lenguaje Alike


Analizador Semántico:
---------------------------------------------
Las inserciones en la tabla de símbolos se realizan en el nivel más alto que se pueda.
De esta forma se tiene control total sobre qué símbolos se insertan en qué bloque y cuándo.

TODOS
- Funciones tienen que tener un return y que sea adecuado
- Mirar posibles bucles infinitos (guardas constantes)
- GET() los params pueden ser variables o comp de array -> donde meter que puedan ser comp de array y checkear que no estén fuera de rango si la expresion es constante

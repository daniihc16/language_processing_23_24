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

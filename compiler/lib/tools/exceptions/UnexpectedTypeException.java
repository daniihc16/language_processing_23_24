/*********************************************************************************
 * Excepción utilizada al analizar una expresión que devuelve un tipo inesperado.
 *
 * Fichero:    UnexpectedTypeException.java
// Fecha:      23/03/2024
// Versión:    v1.0
// Asignatura: Procesadores de Lenguajes, curso 2023-2024
// Autores: Daniel Herce y Lucas Cauhé
 **********************************************************************************/

package lib.tools.exceptions;
import java.util.*;
import lib.symbolTable.Symbol;

public class UnexpectedTypeException extends Exception {

	static public void getMessage(Symbol.Types expected_, Symbol.Types found_, int line, int col) {
		System.err.println("SEMANTIC ERROR (" + String.valueOf(line) +  ", " + String.valueOf(col) + "): Found unexpected type in expresion: Expected " + expected_.toString() + ", found " + found_.toString());
	}

	static public void getMessage(ArrayList<Symbol.Types> expected_, Symbol.Types found_) {
		System.err.println("SEMANTIC ERROR: Found unexpected type in expresion: Expected one of " + Arrays.toString(expected_.toArray()) + ", found " + found_.toString());
	}
}

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
    ArrayList<Symbol.Types> expected;
    Symbol.Types found;
	public UnexpectedTypeException(Symbol.Types expected_, Symbol.Types found_) {
        this.expected = new ArrayList<Symbol.Types>();
		this.expected.add(expected_);
        this.found = found_;
	}
	public UnexpectedTypeException(ArrayList<Symbol.Types> expected_, Symbol.Types found_) {
        this.expected = expected_;
        this.found = found_;
	}

	public String getMessage() {
		return "Found unexpected type in expresion: Expected " + this.expected.toString() + ", found " + this.found.toString();
	}
}
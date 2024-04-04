/*********************************************************************************
 * Excepción utilizada al analizar una expresión que devuelve un tipo inesperado.
 *
 * Fichero:    BadInvocation.java
// Fecha:      23/03/2024
// Versión:    v1.0
// Asignatura: Procesadores de Lenguajes, curso 2023-2024
// Autores: Daniel Herce y Lucas Cauhé
 **********************************************************************************/

package lib.tools.exceptions;
import java.util.*;
import lib.symbolTable.Symbol;

public class BadInvocation extends Exception {
    String id, msg;
	public BadInvocation(String id_, String msg_) {
        this.id = id_;
        this.msg = msg_;
	}
	

	public String getMessage() {
		return "Bad invocation error detected on: " + this.id + " -> " + this.msg;
	}
}
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
	public static void getMessage(String id, String msg) {
		System.err.println("SEMANTIC ERROR: Bad invocation error detected on: " + id + " -> " + msg);
	}
}
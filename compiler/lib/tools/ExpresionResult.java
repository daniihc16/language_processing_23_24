//*****************************************************************
// Tipo de datos devuelto por una expresión
//
// Fichero:    ExpresionResult.java
// Fecha:      23/03/2024
// Versión:    v1.0
// Asignatura: Procesadores de Lenguajes, curso 2023-2024
// Autores: Daniel Herce y Lucas Cauhé
//*****************************************************************

package lib.tools;

import lib.symbolTable.*;


public class ExpresionResult<T> {

    public T value;
    public Symbol.Types type;

    public ExpresionResult(Symbol.Types type_, T value_) {
        this.value = value_;
        this.type = type_;
    }
}

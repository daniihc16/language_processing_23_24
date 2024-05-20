//*****************************************************************
// Tipo de datos devuelto por una expresión
//
// Fichero:    TypeValue.java
// Fecha:      23/03/2024
// Versión:    v1.0
// Asignatura: Procesadores de Lenguajes, curso 2023-2024
// Autores: Daniel Herce y Lucas Cauhé
//*****************************************************************

package lib.tools;

import lib.symbolTable.*;


public class TypeValue<T> {

    public T value;
    public Symbol.Types type;

    // Para variables, indica si el valor es un literal o una variable
    // util para 
    public boolean isLiteral = true;
    
    // Para arrays, indica los índices mínimo y máximo
    public Symbol.Types baseType = Symbol.Types.UNDEFINED;
    public int minInd = 1;
    public int maxInd = 0;

    // Para funciones, indica si el valor devuelto es el resultado de una invocación
    // (para evitar que se intente asignar a una variable)
    public boolean resultOfInvocation = false;

    public TypeValue(Symbol.Types type_, T value_, boolean isLiteral_) {
        this.value = value_;
        this.type = type_;
        this.isLiteral = isLiteral_;
    }
    public TypeValue(Symbol.Types type_, T value_) {
        this.value = value_;
        this.type = type_;
    }

    public TypeValue(Symbol.Types type_, T value_, int minInd_, int maxInd_, Symbol.Types baseType_) {
        this.value = value_;
        this.type = type_;
        this.minInd = minInd_;
        this.maxInd = maxInd_;
        this.baseType = baseType_;
        this.isLiteral = false;
    }

    public TypeValue(Symbol.Types type_, boolean resultOfInvocation_, T value_) {
        this.value = value_;
        this.type = type_;
        this.resultOfInvocation = resultOfInvocation_;
    }

    // public String toString() {
    //     return "(" + baseType.toString() + "," + type.toString() + ")";
    // }
}

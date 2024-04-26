package lib.tools;

import java.util.*;

import lib.symbolTable.Symbol;

// procOFunc(a,b : ref integer, ...)

// p(x)
// procedure p(a: ref integer)...
// 
//      procOFunc(a, b, c + d, funcSinParam, func(a,b), array,  array(a), true and...)


// EL PASO POR PARÁMETROS ES BIEN JODIDO
// si en  procOFunc a es un parámetro por referencia: en procedure al invocarlo pasarán en la pila el parámetro que será el puntero a a
// por lo que en procOFunc se tiene que acabar pasando ese mismo puntero, es decir el valor del parámetro a y no la referencia auqnque en
// procOFunc el parámetro en la posición de a sea por referencia -> Si la variable que tienes es una referencia cambia el código generado

// en el contexto general, las referencias se hacen con solo un srf, pero hay que tener en cuenta, además, el contexto de la variable que se 
// está pasando: si la variable ya es por referencia, tendrá el mismo código que si fuese por valor (srf + drf) ya que quieres almacenar
// la dirección apuntada por esa variable, no la dirección de la variable que eventualmente podrás sobrescribir, invalidando la referencia 
// (la variable original pasada por referencia, x p.e, no se verá actualizada)

// entonces, cuando necesites pasar por valor, una variable que es una referencia, harás srf + drf + drf

public class Attributes {
    public static enum State {
        EnInvocacion,
        Normal
    }

    public State state = State.Normal;
    // paramIsRefInvocacion guarda, en el caso de que el estado sea "EnInvocacion", la lista de parámetros de la función invocada
    // para saber, a la hora de reconocer identificadores, si se han de pasar por valor o por referencia.
    // True -> parámetro por referencia
    // False -> caso contrario
    private Queue<Boolean> paramIsRefInvocacion;

    public Attributes(State state_) {state = state_;}

    public void setQueue(ArrayList<Symbol> params) {
        this.paramIsRefInvocacion = new PriorityQueue<Boolean>();
        for (Symbol param:params) this.paramIsRefInvocacion.add(param.parClass == Symbol.ParameterClass.REF);
    }

    public boolean consumeQueue() {
        return this.paramIsRefInvocacion.remove();
    }
}
package lib.attributes;

import java.util.*;

import lib.symbolTable.Symbol;
import lib.tools.codeGeneration.CodeBlock;
import lib.tools.codeGeneration.PCodeInstruction;

// procOFunc(a,b : ref integer, ...)

// p(x)
// procedure p(a: ref integer)...
// 
//      procOFunc(a, b, c + d, funcSinParam, func(a,b), array,  array(a), true and...)



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
        EnInvocacion, // Estamos en la invocación a un procedimiento o función, tendrás que consumir la cola para ver si se espera una referencia
        EnAsignacion, // Estamos en una asignación, se espera una referencia
        Normal
    }

    public static enum DequeueMethod {
        Remove,
        Peek
    }

    public State state = State.Normal;
    // paramIsRefInvocacion guarda, en el caso de que el estado sea "EnInvocacion", la lista de parámetros de la función invocada
    // para saber, a la hora de reconocer identificadores, si se han de pasar por valor o por referencia.
    // True -> parámetro por referencia
    // False -> caso contrario
    public Queue<Boolean> paramIsRefInvocacion;
    public DequeueMethod dequeueMethod;
    public PCodeInstruction.OpCode ioInst = null;

    public Attributes(State state_, DequeueMethod dequeueMethod_) {state = state_; dequeueMethod = dequeueMethod_;}
    public Attributes(State state_, DequeueMethod dequeueMethod_, PCodeInstruction.OpCode ioInst_) {state = state_; dequeueMethod = dequeueMethod_; ioInst = ioInst_;}

    public void setQueue(ArrayList<Symbol> params) {
        this.paramIsRefInvocacion = new LinkedList<Boolean>();
        for (Symbol param:params) {
            //System.err.println("Setting to queue parClass -> " + param.parClass.toString());
            this.paramIsRefInvocacion.add(param.parClass == Symbol.ParameterClass.REF);
        }
    }

    public void setQueue(Symbol.ParameterClass param) {
        this.paramIsRefInvocacion = new PriorityQueue<Boolean>();
        this.paramIsRefInvocacion.add(param == Symbol.ParameterClass.REF);
    }
    
    private boolean removeFromQueue() {
        boolean ext = this.paramIsRefInvocacion.remove();
        return ext;
    }

    private boolean peekQueue() {
        return this.paramIsRefInvocacion.peek();
    }

    public boolean consumeQueue() {
        if (this.state != State.Normal) {
            if (dequeueMethod == DequeueMethod.Remove) return removeFromQueue();
            return peekQueue();
        }
        return false; // no se va a usar
    }

    // cbInst añade la instrucción de entrada/salida a un bloque de código
    public void cbInst(Symbol.Types type, CodeBlock cb) {
        if (this.ioInst != null) {
            if (type == Symbol.Types.CHAR) cb.addInst(this.ioInst, 0);
            else cb.addInst(this.ioInst, 1);
        }
    }

    public boolean isEmptyQueue() {
        return this.paramIsRefInvocacion.isEmpty();
    }

}
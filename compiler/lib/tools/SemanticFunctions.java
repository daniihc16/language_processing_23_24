//*****************************************************************
// Tratamiento de errores sintácticos
//
// Fichero:    SemanticFunctions.java
// Fecha:      03/03/2022
// Versión:    v1.0
// Asignatura: Procesadores de Lenguajes, curso 2021-2022
//*****************************************************************


package lib.tools;


import java.util.*;
import traductor.Token;
import lib.symbolTable.*;
import lib.symbolTable.exceptions.*;
import lib.tools.exceptions.*;


public class SemanticFunctions {
   //private ErrorSemantico errSem; //clase común de errores semánticos


   public SemanticFunctions() {
       //errSem = new ErrorSemantico();
   }


   static public ArrayList<Symbol> simbolos_con_tipo(ArrayList<String> ids, boolean isRef, ArrayList<Symbol> t, Token min, Token max, Token neg1, Token neg2) {
       Symbol.ParameterClass p_class = isRef ? Symbol.ParameterClass.REF : Symbol.ParameterClass.VAL;
       int minInd = Integer.parseInt(min.image);
       int maxInd = Integer.parseInt(max.image);
       if (neg1 != null) minInd = minInd*(-1);
       if (neg2 != null) maxInd = maxInd*(-1);
       ArrayList<Symbol> ids_con_tipo = new ArrayList<Symbol>();
       for (int i=0; i<ids.size(); i++) {
           ids_con_tipo.add(new SymbolArray(ids.get(i), minInd, maxInd, t.get(i).type, p_class));
       }
       return ids_con_tipo;
   }

   /*
	* Devuelve una lista de símbolos con los nombres de los identificadores y el tipo de los mismos
	* @param ids Lista de identificadores
	* @param isRef Indica si los identificadores son referencias
	* @param t Tipo de los identificadores
    */
   static public ArrayList<Symbol> ids_simbolos_base(ArrayList<String> ids, boolean isRef, Symbol t) {
       ArrayList<Symbol> ids_symbols = new ArrayList<Symbol>();
       Symbol.ParameterClass p_class = isRef ? Symbol.ParameterClass.REF : Symbol.ParameterClass.VAL;
       for (String id : ids) {
           Symbol t_clone = t.clone();
           t_clone.name = id;
           t_clone.parClass = p_class;
           ids_symbols.add(t_clone);
       }
       return ids_symbols;
   	}

	/*
	 * Inserta un símbolo en la tabla de símbolos si no está ya definido. En ese caso mostrará un SEMANTIC_ERROR
	 * @param st Tabla de símbolos
	 * @param sym Símbolo a insertar
	 */
   static public void insertSymbol(SymbolTable st, Symbol sym) {
       try {
           st.insertSymbol(sym);
           System.out.println("Nuevo símbolo: " + st.toString());
       } catch (AlreadyDefinedSymbolException ads) {
           System.err.println("SEMANTIC_ERROR: Error insertando nuevo símbolo " + ads.getMessage(sym) + ": Ya declarado");
       }
   	}

   /*
	* Crea un nuevo bloque en la tabla de símbolos y añade los parámetros de un procedimiento (si los tiene)
	* @param st Tabla de símbolos
	* @param proc Símbolo del procedimiento que contiene (o no) los parámetros
    */
   static public void newProcBlock(SymbolTable st, SymbolProcedure proc) {
       SemanticFunctions.insertSymbol(st, proc);
		st.insertBlock();
		if (proc.parList != null) {
			for (Symbol param : proc.parList) {
				SemanticFunctions.insertSymbol(st, param);
			}
		}
   	}
	
	/*
	 * Crea un nuevo bloque en la tabla de símbolos y añade los parámetros de una función (si los tiene)
	 * @param st Tabla de símbolos
	 * @param func Símbolo de la función que contiene (o no) los parámetros
	 */
	static public void newFuncBlock(SymbolTable st, SymbolFunction func) {
       SemanticFunctions.insertSymbol(st, func);
		st.insertBlock();
		if (func.parList != null) {
			for (Symbol param : func.parList) {
				SemanticFunctions.insertSymbol(st, param);
			}
		}
   	}

	static public void inst_escribir(ArrayList<TypeValue> exps) {
		// todas las expresiones de una instrucción de escribir deben ser de tipo char o string, los enteros
		// han de convertirse con int2char()
		for (TypeValue exp:exps) {
			if (exp.type != Symbol.Types.STRING &&
			exp.type != Symbol.Types.CHAR &&
			exp.type != Symbol.Types.INT &&
			exp.type != Symbol.Types.BOOL) UnexpectedTypeException.getMessage(Symbol.Types.STRING, exp.type);
		}
	}

	static public TypeValue expresion(TypeValue prel, Token op, TypeValue rest_rel, int tAND, int tOR) {
		if (rest_rel != null) {
			if (prel.type != Symbol.Types.BOOL) UnexpectedTypeException.getMessage(Symbol.Types.BOOL, prel.type);
			if (rest_rel.type != Symbol.Types.BOOL) UnexpectedTypeException.getMessage(Symbol.Types.BOOL, rest_rel.type);
			// evaluamos prematuramente las relaciones para determinar un posible valor constante
			if (prel.type == Symbol.Types.BOOL && rest_rel.type == Symbol.Types.BOOL && prel.value != null && rest_rel.value != null) {
				if (op.kind == tAND) return new TypeValue(Symbol.Types.BOOL, (boolean)prel.value && (boolean)rest_rel.value);
				else if (op.kind == tOR) return new TypeValue(Symbol.Types.BOOL, (boolean)prel.value || (boolean)rest_rel.value);
			} else {
				return new TypeValue(Symbol.Types.BOOL, null);
			}
		}
		return prel;
	}

}



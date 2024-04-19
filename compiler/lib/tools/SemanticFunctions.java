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

import javax.sound.sampled.AudioFileFormat.Type;

import traductor.Token;
import lib.symbolTable.*;
import lib.symbolTable.exceptions.*;
import lib.tools.exceptions.*;


public class SemanticFunctions {
   //private ErrorSemantico errSem; //clase común de errores semánticos


   public SemanticFunctions() {
       //errSem = new ErrorSemantico();
   }


   /*
	* Devuelve una lista de símbolos con los nombres de los identificadores y el tipo de los mismos
	* @param ids Lista de identificadores
	* @param isRef Indica si los identificadores son referencias
	* @param t Tipo de los identificadores
	* @param min Token con el valor mínimo del rango
	* @param max Token con el valor máximo del rango
	* @param neg1 Token con el signo negativo del valor mínimo del rango
	* @param neg2 Token con el signo negativo del valor máximo del rango
	* @return ArrayList<Symbol> con los símbolos de los identificadores
    */
   static public ArrayList<Symbol> simbolos_con_tipo(ArrayList<String> ids, boolean isRef, ArrayList<Symbol> t, Token min, Token max, Token neg1, Token neg2) {
       Symbol.ParameterClass p_class = isRef ? Symbol.ParameterClass.REF : Symbol.ParameterClass.VAL;
       int minInd = Integer.parseInt(min.image);
       int maxInd = Integer.parseInt(max.image);
       if (neg1 != null) minInd = minInd*(-1);
       if (neg2 != null) maxInd = maxInd*(-1);
	   // comprobación rango no vacío
	   if (minInd > maxInd) System.err.println("SEMANTIC ERROR: Void range: " + min.image + " is greater than" + max.image);
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

	static public Symbol getSymbol(SymbolTable st, String sym) {
		try {
			return st.getSymbol(sym);
		} catch (SymbolNotFoundException e) {
			System.err.println("SEMANTIC ERROR: Symbol not found: " + sym);
			return null;
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

	

	/*
	 * Comprueba que el tipo de las componentes de una expresión booleana sea correcto y evalua su valor
	 * si es posible. En caso de que solo haya una componenete de la expresión, rest_rel = null, devuelve
	 * el valor de la expresión
	 * @param prel Componente izquierda de la expresión
	 * @param op Operador de la expresión
	 * @param rest_rel Componente derecha de la expresión
	 * @param tAND Token del operador AND
	 */
	static public TypeValue expresion(TypeValue prel, TypeValue rest_rel, Token op, int tAND, int tOR) {
		if (rest_rel != null) {
			if (prel.type != Symbol.Types.BOOL) UnexpectedTypeException.getMessage(Symbol.Types.BOOL, prel.type, op.beginLine, op.beginColumn);
			if (rest_rel.type != Symbol.Types.BOOL) UnexpectedTypeException.getMessage(Symbol.Types.BOOL, rest_rel.type, op.beginLine, op.beginColumn);
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

	/*
	 * Comprueba que el tipo de las componentes de una expresión relacional sea correcto y evalua su valor
	 * si es posible. En caso de que solo haya una componenete de la expresión, exp2 = null, devuelve
	 * el valor de la expresión
	 * @param exp1 Componente izquierda de la expresión
	 * @param op Operador de la expresión
	 * @param exp2 Componente derecha de la expresión
	 * @param tEQ Token del operador ==
	 * @param tNE Token del operador !=
	 * @param tLT Token del operador <
	 * @param tLE Token del operador <=
	 * @param tGT Token del operador >
	 * @param tGE Token del operador >=
	 */
	static public TypeValue relacion(TypeValue exp1, Token op, TypeValue exp2, int tEQ, int tNE, int tLT, int tLE, int tGT, int tGE) {
		// Si hay un operador relacional y por tanto una exp2 el resultado es un booleano
		if (exp2 != null) {
			// Si hay un operador relacional y las expresiones no son del mismo tipo, lanzamos una excepción
			if (exp1.type != exp2.type) UnexpectedTypeException.getMessage(exp1.type, exp2.type, op.beginLine, op.beginColumn);
			if (exp1.type != Symbol.Types.VOID && exp1.type != Symbol.Types.ARRAY && exp1.type != Symbol.Types.STRING && exp1.type == exp2.type && exp1.value != null && exp2.value != null) {
				// Si ambas expresiones son constantes, evaluamos la relación
				if (op.kind == tEQ) return new TypeValue(Symbol.Types.BOOL, exp1.value == exp2.value);
				else if (op.kind == tNE) return new TypeValue(Symbol.Types.BOOL, exp1.value != exp2.value);
				else if (exp1.type == Symbol.Types.BOOL) return new TypeValue(Symbol.Types.BOOL, null);
				else if (exp1.type == Symbol.Types.CHAR) return new TypeValue(Symbol.Types.BOOL, null);
				else if (op.kind == tLT) return new TypeValue(Symbol.Types.BOOL, (int)exp1.value < (int)exp2.value);
				else if(op.kind == tLE) return new TypeValue(Symbol.Types.BOOL, (int)exp1.value <= (int) exp2.value);
				else if(op.kind == tGT) return new TypeValue(Symbol.Types.BOOL, (int)exp1.value > (int)exp2.value);
				else if(op.kind == tGE) return new TypeValue(Symbol.Types.BOOL, (int)exp1.value >= (int) exp2.value);
				UnexpectedTypeException.getMessage(Symbol.Types.INT, exp1.type, op.beginLine, op.beginColumn);
				return new TypeValue(Symbol.Types.BOOL, null);
			} 
			if (exp1.type == Symbol.Types.ARRAY || exp2.type == Symbol.Types.ARRAY) UnexpectedTypeException.getMessage(Symbol.Types.INT, Symbol.Types.ARRAY, op.beginLine, op.beginColumn);
			if (exp1.type == Symbol.Types.STRING || exp2.type == Symbol.Types.STRING) UnexpectedTypeException.getMessage(Symbol.Types.INT, Symbol.Types.STRING, op.beginLine, op.beginColumn);
			if (exp1.type == Symbol.Types.VOID || exp2.type == Symbol.Types.VOID) UnexpectedTypeException.getMessage(Symbol.Types.INT, Symbol.Types.VOID, op.beginLine, op.beginColumn);
			// Si alguna de las expresiones no es constante, devolvemos su tipo (ambas tienen el mismo)
			return new TypeValue(Symbol.Types.BOOL, null);
		}
		return exp1;
	}

	/*
	 * Comprueba que el tipo de las componentes de una expresión aritmética sea correcto y evalua su valor
	 * si es posible. En caso de que solo haya una componenete de la expresión, term_resultante = null, devuelve
	 * el valor de la expresión
	 * @param ops Operador de la expresión
	 * @param term Componente izquierda de la expresión
	 * @param op Operador de la expresión
	 * @param term_resultante Componente derecha de la expresión
	 * @param tPLUS Token del operador +
	 * @param tMINUS Token del operador -
	 * @return TypeValue con el resultado de la expresión
	 * @throws UnexpectedTypeException Si el tipo de las expresiones no es correcto
	 * @throws BadInvocation Si la invocación a una función o procedimiento no es correcta
	 */
	static public TypeValue expresion_simple(Token ops, TypeValue term, Token op, TypeValue term_resultante, int tPLUS, int tMINUS) {
		// Si hay un operador + o - el término debe ser de tipo entero
		if (ops != null && term.type != Symbol.Types.INT) UnexpectedTypeException.getMessage(Symbol.Types.INT, term.type, ops.beginLine, ops.beginColumn);
		// Si el término es constante, lo evaluamos antes de mirar las expresiones resultantes
		if (term.value != null) {
			if (ops == null) term = new TypeValue(term.type, term.value, term.isLiteral);
			else if (ops.kind == tPLUS && term.type == Symbol.Types.INT) term = new TypeValue(term.type, term.value, term.isLiteral);
			else if (ops.kind == tMINUS && term.type == Symbol.Types.INT) term = new TypeValue(term.type, (int)term.value*-1);
			else UnexpectedTypeException.getMessage(Symbol.Types.INT, term.type, ops.beginLine, ops.beginColumn);
		}

		if (term_resultante == null) return term;
		if (term.type != Symbol.Types.INT) UnexpectedTypeException.getMessage(Symbol.Types.INT, term.type, op.beginLine, op.beginColumn);
		if (term_resultante.type != Symbol.Types.INT) UnexpectedTypeException.getMessage(Symbol.Types.INT, term_resultante.type, op.beginLine, op.beginColumn);
		
		if (term.type == Symbol.Types.INT && term_resultante.type == Symbol.Types.INT && term.value != null && term_resultante.value != null) {
			if (op.kind == tPLUS) return new TypeValue(Symbol.Types.INT, (int)term.value + (int)term_resultante.value);
			else return new TypeValue(Symbol.Types.INT, (int)term.value - (int)term_resultante.value);
		} 
		return new TypeValue(Symbol.Types.INT, null);
	}

	/*
	 * Comprueba que el tipo de las componentes de una expresión aritmética sea correcto y evalua su valor
	 * si es posible. En caso de que solo haya una componenete de la expresión, term_resultante = null, devuelve
	 * el valor de la expresión
	 * @param term Componente izquierda de la expresión
	 * @param op Operador de la expresión
	 * @param term_resultante Componente derecha de la expresión
	 * @param tPLUS Token del operador +
	 * @param tMINUS Token del operador -
	 * @return TypeValue con el resultado de la expresión
	 * @throws UnexpectedTypeException Si el tipo de las expresiones no es correcto
	 */
	static public TypeValue una_o_mas_expresiones_simples(TypeValue term, Token op, TypeValue term_resultante, int tPLUS, int tMINUS) {
		if (term_resultante != null) {
			if (term.type != Symbol.Types.INT) UnexpectedTypeException.getMessage(Symbol.Types.INT, term.type, op.beginLine, op.beginColumn);
			if (term_resultante.type != Symbol.Types.INT) UnexpectedTypeException.getMessage(Symbol.Types.INT, term_resultante.type, op.beginLine, op.beginColumn);
			if (term.type == Symbol.Types.INT && term_resultante.type == Symbol.Types.INT && term.value != null && term_resultante.value != null) {
				if (op.kind == tPLUS) return new TypeValue(Symbol.Types.INT, (int)term.value + (int)term_resultante.value);
				else return new TypeValue(Symbol.Types.INT, (int)term.value - (int)term_resultante.value);
			} else {
				return new TypeValue(Symbol.Types.INT, null);
			}
		} 
		return term;
	}

	/*
	 * Comprueba que el tipo de las componentes de una expresión aritmética sea correcto y evalua su valor
	 * si es posible. En caso de que solo haya una componenete de la expresión, fact_resultante = null, devuelve
	 * el valor de la expresión
	 * @param fact Componente izquierda de la expresión
	 * @param op Operador de la expresión
	 * @param fact_resultante Componente derecha de la expresión
	 * @param tTIMES Token del operador *
	 * @param tDIV Token del operador /
	 * @param tMOD Token del operador %
	 * @return TypeValue con el resultado de la expresión
	 * @throws UnexpectedTypeException Si el tipo de las expresiones no es correcto
	 */
	static public TypeValue termino(TypeValue fact, Token op, TypeValue fact_resultante, int tTIMES, int tDIV, int tMOD) {
		if (fact_resultante != null) {
			if (fact.type != Symbol.Types.INT) UnexpectedTypeException.getMessage(Symbol.Types.INT, fact.type, op.beginLine, op.beginColumn);
			if (fact_resultante.type != Symbol.Types.INT) UnexpectedTypeException.getMessage(Symbol.Types.INT, fact_resultante.type, op.beginLine, op.beginColumn);
			if (fact.type == Symbol.Types.INT && fact_resultante.type == Symbol.Types.INT && fact.value != null && fact_resultante.value != null) {
				if (op.kind == tTIMES) return new TypeValue(Symbol.Types.INT, (int)fact.value * (int)fact_resultante.value);
				else if (op.kind == tDIV) {
					if ((int)fact_resultante.value != 0) return new TypeValue(Symbol.Types.INT, (int)fact.value / (int)fact_resultante.value);
					System.err.println("WARNING ("+ op.beginLine + ", " + op.beginColumn +") : Attempting integer division by zero");
					return new TypeValue(Symbol.Types.INT, null);
				}
				else if (op.kind == tMOD) return new TypeValue(Symbol.Types.INT, (int)fact.value % (int)fact_resultante.value);
			}
			return new TypeValue(Symbol.Types.INT, null);
		}
		return fact;
	}

	/*
	 * Comprueba que el tipo de una expresión con un not delante sea booleano y evalua su valor si es posible
	 * @param p Componente de la expresión
	 * @return TypeValue con el resultado de la expresión
	 * @throws UnexpectedTypeException Si el tipo de la expresión no es correcto
	 */
	static public TypeValue not_primario(TypeValue p, int line, int column) {
		if (p.type == Symbol.Types.BOOL) {
			if (p.value != null) return new TypeValue(Symbol.Types.BOOL, !(boolean)p.value);
			return new TypeValue(Symbol.Types.BOOL, null);
		}
		UnexpectedTypeException.getMessage(Symbol.Types.BOOL, p.type, line, column);
		return p;
	}

	/*
	 * Comprueba que el id proporcionado se corresponde con una función o un procedimiento sin parámetros
	 * o al de un array. Devuelve un TypeValue con el tipo correspondiente y el valor en caso del array
	 * @param id Token con el id de la invocación
	 * @param st Tabla de símbolos
	 * @return TypeValue con el tipo de la invocación
	 * @throws BadInvocation Si la invocación no es correcta (se han pasado parámetros a un procedimiento o función sin parámetros)
	 * @throws UnexpectedTypeException Si el tipo de la invocación no es correcto
	 */
	static public TypeValue var_o_func_sin_params(Token id, SymbolTable st) {
		Symbol sid = SemanticFunctions.getSymbol(st, id.image);
		if (sid == null) return new TypeValue(Symbol.Types.UNDEFINED, null);
		if (sid.type == Symbol.Types.FUNCTION ) {
			SymbolFunction sfid = (SymbolFunction)sid;
			if (sfid.parList != null) BadInvocation.getMessage(sfid.name, "Function has too many arguments", id.beginLine, id.beginColumn);
			return new TypeValue(sfid.returnType, true, null);
		} else if (sid.type == Symbol.Types.PROCEDURE) {
			SymbolProcedure spid = (SymbolProcedure)sid;
			if (spid.name == st.getMainProc()) BadInvocation.getMessage(spid.name, "Principal Procedure cannot be invoked", id.beginLine, id.beginColumn);
			if (spid.parList != null) BadInvocation.getMessage(spid.name, "Function has too many arguments", id.beginLine, id.beginColumn);
			return new TypeValue(Symbol.Types.VOID, true, null);
		} else if (sid.type == Symbol.Types.ARRAY) {
			SymbolArray said = (SymbolArray)sid;
			return new TypeValue(sid.type, null, said.minInd, said.maxInd, said.baseType);
		}
		return new TypeValue(sid.type, null, false);
	}

	/*
	 * Devuelve un TypeValue con el tipo correspondiente a el tipo de la invocación a una un procedimiento o función
	 * @param exp1 Componente izquierda de la expresión
	 * @param op Operador de la expresión
	 * @param exp2 Componente derecha de la expresión
	 * @param tEQ Token del operador ==
	 * @param tNE Token del operador !=
	 * @param tLT Token del operador <
	 * @param tLE Token del operador <=
	 * @param tGT Token del operador >
	 * @param tGE Token del operador >=
	 */
	static public TypeValue invoc_func_o_comp_array(Token id, ArrayList<TypeValue> exps, SymbolTable st) {
		Symbol sid = SemanticFunctions.getSymbol(st, id.image);
		if (sid == null) return new TypeValue(Symbol.Types.UNDEFINED, null);
		if (sid.type == Symbol.Types.FUNCTION) {
			SymbolFunction sfid = (SymbolFunction)sid;
			if (sfid.parList == null) BadInvocation.getMessage(sfid.name, "Function expected no params", id.beginLine, id.beginColumn);
			else if(sfid.parList.size() != exps.size()) BadInvocation.getMessage(sfid.name, "Function with incorrect number of arguments, expected " + sfid.parList.size()+ " found " + exps.size(), id.beginLine, id.beginColumn);
			else { 
				for (int i=0; i<exps.size(); i++) {
					// Un array se considera del mismo tipo si tiene el mismo tipo y rango que otro
					if (sfid.parList.get(i).type == Symbol.Types.ARRAY){
						SymbolArray symArrayFunc = (SymbolArray)sfid.parList.get(i);
						TypeValue symArrayExp = exps.get(i);
						if (symArrayFunc.baseType != symArrayExp.baseType) UnexpectedTypeException.getMessage(symArrayFunc.baseType, symArrayExp.baseType, id.beginLine, id.beginColumn);
						if (symArrayFunc.minInd != symArrayExp.minInd || symArrayFunc.maxInd != symArrayExp.maxInd) BadInvocation.getMessage("Array", "Ranges vary in sizes", id.beginLine, id.beginColumn);
					}
					if (sfid.parList.get(i).type != exps.get(i).type) UnexpectedTypeException.getMessage(sfid.parList.get(i).type, exps.get(i).type, id.beginLine, id.beginColumn);
					if (sfid.parList.get(i).parClass == Symbol.ParameterClass.REF && exps.get(i).isLiteral) BadInvocation.getMessage(sfid.parList.get(i).name, "Expected reference type, found literal", id.beginLine, id.beginColumn);
				}
			}
			return new TypeValue(sfid.returnType, true, null);
		} else if (sid.type == Symbol.Types.PROCEDURE) {
			SymbolProcedure spid = (SymbolProcedure)sid;
			// procedimiento principal no es invocable
			if (spid.name == st.getMainProc()) BadInvocation.getMessage(spid.name, "Principal Procedure cannot be invoked", id.beginLine, id.beginColumn);
			if (spid.parList == null) BadInvocation.getMessage(spid.name, "Procedure expected no params", id.beginLine, id.beginColumn);
			else if(spid.parList.size() != exps.size()) BadInvocation.getMessage(spid.name, "Procedure with incorrect number of arguments, expected " + spid.parList.size()+ " found " + exps.size(), id.beginLine, id.beginColumn);
			else { 
				for (int i=0; i<exps.size(); i++) {
					if (spid.parList.get(i).type == Symbol.Types.ARRAY){
						SymbolArray symArrayProc = (SymbolArray)spid.parList.get(i);
						TypeValue symArrayExp = exps.get(i);
						if (symArrayProc.baseType != symArrayExp.baseType) UnexpectedTypeException.getMessage(symArrayProc.baseType, symArrayExp.baseType, id.beginLine, id.beginColumn);
						if (symArrayProc.minInd != symArrayExp.minInd || symArrayProc.maxInd != symArrayExp.maxInd) BadInvocation.getMessage("Array", "Ranges vary in sizes", id.beginLine, id.beginColumn);
					}
					if (spid.parList.get(i).type != exps.get(i).type) UnexpectedTypeException.getMessage(spid.parList.get(i).type, exps.get(i).type, id.beginLine, id.beginColumn);
					if (spid.parList.get(i).parClass == Symbol.ParameterClass.REF && exps.get(i).isLiteral) BadInvocation.getMessage(spid.parList.get(i).name, "Expected reference type, found literal", id.beginLine, id.beginColumn);
				}
			}
			return new TypeValue(Symbol.Types.VOID, true, null);
		} else if (sid.type == Symbol.Types.ARRAY) {
			SymbolArray said = (SymbolArray)sid;
			if (exps.size() > 1) BadInvocation.getMessage(said.name, "Invalid index", id.beginLine, id.beginColumn);
			TypeValue exp = exps.get(0);
			if (exp.type != Symbol.Types.INT) UnexpectedTypeException.getMessage(Symbol.Types.INT, exp.type, id.beginLine, id.beginColumn);
			if (exp.type == Symbol.Types.INT && exp.value != null && ((int)exp.value < said.minInd || (int)exp.value > said.maxInd)) BadInvocation.getMessage(said.name, "Array index out of bounds", id.beginLine, id.beginColumn);
			return new TypeValue(said.baseType, null, false);
		}
		// Error, no hay ninguna invocación id(..) que no sea una función o un elemento de un array
		ArrayList<Symbol.Types> expectedTypes = new ArrayList<Symbol.Types>();
		expectedTypes.add(Symbol.Types.FUNCTION);
		expectedTypes.add(Symbol.Types.PROCEDURE);
		expectedTypes.add(Symbol.Types.ARRAY);
		UnexpectedTypeException.getMessage(expectedTypes, sid.type, id.beginLine, id.beginColumn);
		return new TypeValue(Symbol.Types.UNDEFINED, null);
		
	}

	/*
	 * Comprueba que el tipo de las componentes que se leen son INT, CHAR o un array de INT
	 * o CHAR
	 * @param exps Lista de expresiones a leer
	 * @param get Token con la instrucción de lectura
	 * @throws UnexpectedTypeException Si el tipo de las expresiones no es correcto
	 */
	static public void inst_leer(ArrayList<TypeValue> exps, Token get) {
		ArrayList<Symbol.Types> expectedTypes = new ArrayList<Symbol.Types>();
		expectedTypes.add(Symbol.Types.INT);
		expectedTypes.add(Symbol.Types.CHAR);
		
		for (TypeValue exp:exps) {
			if (exp.isLiteral) BadInvocation.getMessage("GET", "Cannot read into literal value", get.beginLine, get.beginColumn);
			if ((exp.type != Symbol.Types.INT && exp.type != Symbol.Types.CHAR)
				|| (exp.type == Symbol.Types.ARRAY && exp.baseType != Symbol.Types.INT && exp.baseType != Symbol.Types.CHAR)) {
				UnexpectedTypeException.getMessage(expectedTypes, exp.type, get.beginLine, get.beginColumn);
			}
		}
	}

	/*
	 * Comprueba que el tipo de las expresiones de una instrucción de escribir sea correcto
	 * @param exp Expresión a comprobar
	 * @param expected Tipo esperado
	 */
	static public void inst_escribir(ArrayList<TypeValue> exps, int line, int column) {
		// todas las expresiones de una instrucción de escribir deben ser de tipo char o string, los enteros
		// han de convertirse con int2char()
		for (TypeValue exp:exps) {
			if (exp.type != Symbol.Types.STRING &&
			exp.type != Symbol.Types.CHAR &&
			exp.type != Symbol.Types.INT &&
			exp.type != Symbol.Types.BOOL) UnexpectedTypeException.getMessage(Symbol.Types.STRING, exp.type, line, column);
		}
	}


	/*
	 * Comprueba que el tipo de la asignación sea el correcto
	 * @param id Identificador al que se asigna
	 * @param exp Expresión que se asigna
	 * @param pos Token con la posición de la asignación
	 */
	static public void inst_invocacion_o_asignacion(TypeValue id, TypeValue exp, Token pos) {
		if (pos != null) /* asignación */ {
			if (id.resultOfInvocation) BadInvocation.getMessage("Asignación", "Left side of assignment is a function or procedure", pos.beginLine, pos.beginColumn);
			else if (id.type == Symbol.Types.ARRAY) {
				// Los vectores no son asignables directamente pero sus componentes sí, estas devuelven
				// el tipo base del vector así que con hacer la comprobación de tipos es suficiente
				BadInvocation.getMessage("array", "array cannot be assigned", pos.beginLine, pos.beginColumn);
				// este rango vacío indica que no se ha generado un TypeValue de identificador de array
				// por tanto es tipo array pero no el identificador solo, por lo que es un acceso a una componente
				// if (id.minInd == 1 && id.maxInd == 0) BadInvocation.getMessage("array", "array cannot be assigned", pos.beginLine, pos.beginColumn);
				// else if (id.baseType != exp.type) UnexpectedTypeException.getMessage(id.baseType, exp.type, pos.beginLine, pos.beginColumn);
			} else if (id.type != exp.type) UnexpectedTypeException.getMessage(id.type, exp.type, pos.beginLine, pos.beginColumn);
			
		} else /* invocación */ {
			// si se invoca a una función, no se captura el valor devuelto
			// se puede no generar el código de llamada a la función si no se captura el resultado
			if (id.type == Symbol.Types.FUNCTION) System.err.println("WARNING: Unhandled function return value");
			else if (id.type != Symbol.Types.VOID) BadInvocation.getMessage("symbol", "is not declared as procedure", 0, 0);
		}
		
	}

	static public void inst_if(TypeValue expif, Token tif) {
		if (expif.type != Symbol.Types.BOOL) UnexpectedTypeException.getMessage(Symbol.Types.BOOL, expif.type, tif.beginLine, tif.beginColumn);
		if (expif.value != null) System.err.println("WARNING (" + tif.beginLine + ", " + tif.beginColumn + "): Constant condition in if instruction");
	}

	static public void inst_while(TypeValue exp, Token twhile) {
		if (exp.type != Symbol.Types.BOOL) UnexpectedTypeException.getMessage(Symbol.Types.BOOL, exp.type, twhile.beginLine, twhile.beginColumn);
		if (exp.value != null) System.err.println("WARNING(" + twhile.beginLine + ", " + twhile.beginColumn + "): Constant condition in while instruction");
	}

	static public void inst_return(TypeValue exp, Symbol sf_, Token treturn) {
		if (sf_.type != Symbol.Types.FUNCTION) BadInvocation.getMessage(sf_.name, "Return statement inside of a procedure >:(", treturn.beginLine, treturn.beginColumn);
		else {
			SymbolFunction sf = (SymbolFunction)sf_;
			if (sf.returnType != exp.type) UnexpectedTypeException.getMessage(sf.returnType, exp.type, treturn.beginLine, treturn.beginColumn);
		}
	}
}



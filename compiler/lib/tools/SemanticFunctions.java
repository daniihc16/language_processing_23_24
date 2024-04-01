//*****************************************************************
// Tratamiento de errores sintácticos
//
// Fichero:    SemanticFunctions.java
// Fecha:      03/03/2022
// Versión:    v1.0
// Asignatura: Procesadores de Lenguajes, curso 2021-2022
//*****************************************************************

package lib.tools.SemanticFunctions;

import java.util.*;
//import traductor.Token;
import lib.symbolTable.*;
import lib.symbolTable.exceptions.*;

public class SemanticFunctions {
	//private ErrorSemantico errSem; //clase común de errores semánticos

	public SemanticFunctions() {
		//errSem = new ErrorSemantico();
	}

	// public ArrayList<Symbol> simbolos_con_tipo(ArrayList<String> ids, boolean isRef, ArrayList<Symbol> t, Object min, Token max, Token neg1, Token neg2) {
	// 	Symbol.ParameterClass p_class = isRef ? Symbol.ParameterClass.REF : Symbol.ParameterClass.VAL;
	// 	int minInd = Integer.parseInt(min.image);
	// 	int maxInd = Integer.parseInt(max.image);
	// 	if (neg1 != null) minInd = minInd*(-1);
	// 	if (neg2 != null) maxInd = maxInd*(-1);
	// 	ArrayList<Symbol> ids_con_tipo = new ArrayList<Symbol>();
	// 	for (int i=0; i<ids.size(); i++) {
	// 		ids_con_tipo.add(new SymbolArray(ids.get(i), minInd, maxInd, t.get(i).type, p_class));
	// 	}
	// 	return ids_con_tipo;
	// }
}

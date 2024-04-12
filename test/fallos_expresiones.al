--Fichero que prueba el reconocimiento semántico de expresiones
-- Probar (-true) o en general '-' <tipo no entero> da error
-- Probar a pasar por referencia un '+x' y '+1' (el primero ok, el segundo no ok)
-- probar a devolver y pasar un array con tipo distinto base y rangos
-- invocar al main proc (y ver que falla)
procedure fallos_expresiones is
	var_integer: integer;
	var_char: character;
	var_boolean: boolean;
	var_array: array(1..5) of integer;
------------------------------------------------------
begin
	-- Aunque no se han inicializado las variables, semanticamente es correcto
	var_boolean := not var_boolean;
	var_boolean := not true;
	var_boolean := not false;
	var_boolean := true and false;
	var_boolean := true and true;
	var_boolean := false and false;
	var_boolean := true or false;
	var_boolean := true or true;
	var_boolean := false or false;

	var_boolean := true and var_boolean;
	var_boolean := var_boolean and true;

	var_boolean := 5 < 6;
	var_boolean := 5 <= 6;
	var_boolean := 5 > 6;
	var_boolean := 5 >= 6;
	var_boolean := 5 = 6;
	var_boolean := 5 /= 6;

	var_boolean := 5 + 6 < 6 and 5 - 6 > 6;
	
	-- Fallos
	var_boolean := not 5;
	var_boolean := not 'a';
	var_boolean := not var_integer;
	var_boolean := not var_char;
	var_boolean := not var_array;
	var_boolean := not (5 + 6);
	var_boolean := not (5.0 + 6.0);
	var_boolean := -true;
	var_boolean := -var_integer;
	var_boolean := -var_char;
	var_boolean := -var_array;
	var_boolean := var_integer > 3 or a > 5;

	var_boolean := 5 < 'a';
	var_boolean := 5 <= 'a';
	var_boolean := 5 > 'a';
	var_boolean := 5 >= 'a';
	var_boolean := 5 = 'a';
	var_boolean := 5 /= 'a';

	var_boolean := 5 + 'a' < 6 and 5 - 'a' > 6;
	var_boolean := 5 + 6.0 < 6 and 5 - 6.0 > 6;
	var_boolean := 5.0 + 6 < 6 and 5.0 - 6 > 6;
	var_boolean := 5.0 + 6.0 < 6 and 5.0 - 6.0 > 6;

	var_boolean := 5 + var_char < 6 and 5 - var_char > 6;
	var_boolean := 5 + var_integer < 6 and 5 - var_integer > 6;
	var_boolean := 5 + var_array < 6 and 5 - var_array > 6;
	var_boolean := 5 + var_boolean < 6 and 5 - var_boolean > 6;

	var_char := 5 + 6;
	var_char := 5 - 6;
	var_char := 5 * 6;
	var_char := 5 / 6;
	var_char := 5 mod 6;
	var_char := 5 div 6;
	var_char := 5 and 6;
	var_char := 5 or 6;
	var_char := 5 < 6;
	var_char := 5 <= 6;
	var_char := 5 > 6;
	var_char := 5 >= 6;
	var_char := 5 = 6;
	var_char := 5 /= 6;

	var_char := 5 + 'a';
	var_char := 5 - 'a';
	var_char := 5 * 'a';
	var_char := 5 / 'a';
	var_char := 5 mod 'a';
	var_char := 5 div 'a';
	var_char := 5 and 'a';
	
	

	// Probar a pasar por referencia +var_int y -var_int
end;
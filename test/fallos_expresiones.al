--Fichero que prueba el reconocimiento semántico de expresiones

procedure fallos_expresiones is
	var_integer: integer;
	var_char: character;
	var_boolean: boolean;
	var_array: array(1..5) of integer;
	-- insertar simbolo ya declarado l87
	var_char: character;
------------------------------------------------------
-- probar rango no vacio l51
-- fallo cabecera_funcion -> declarar una función que devuelva un tipo distinto a entero, booleano o caracter 
-- function func_sin_params return array(5..1) of integer is
function func_sin_params return boolean is
	var_bool_array: array(1..5) of boolean;
	var_integer: integer;
	var_char: character;
	var_boolean: boolean;
begin
	-- fallos instrucción if -> Warning expresión constante
	if true then 
		null;
	end if;
	if true or (false and true) then
		null;
	end if;
	if true and false then
		null;
	end if;
	if ((true and false) or (5 > 6 and (not true or 4 = 67))) then
		null;
	end if;
	if VaR_BooLean then
		null;
	end if;
	-- fallos instrucción if -> condición no booleana en if y elsif
	if (var_integer) then
		null;
	end if;
	if ("bad") then
		null;
	elsif ("bad") then
		null;
	elsif (var_bool_array) then
		null;
	elsif (var_array(1)) then -- ok
		null;
	end if;
	
	var_boolean := var_array(7); -- indexar un array con un valor fuera de rango
	var_boolean := var_array("bad"); -- indexar un array con un valor no entero
	var_boolean := var_array(2, 3); -- indexar un arrray con 2 valores, ej: v(2,3)
	
	-- fallos instrucción while -> condición no booleana en while
	while (true) loop
		null;
	end loop;
	while (var_char) loop
		null;
	end loop;
end;
------------------------------------------------------
function func_con_params return integer is
	var_integer: integer;
	var_char: character;
	var_boolean: boolean;
	var_array: array(1..5) of integer;
begin
	-- fallos instrucción return -> return con tipo distinto al de la función
	return var_boolean;
end;
------------------------------------------------------
procedure proc_sin_params is
	var_integer: integer;
	var_char: character;
	var_boolean: boolean;
	var_array: array(1..5) of integer;
begin
	null;
end;
------------------------------------------------------
procedure proc_con_params is
	var_integer: integer;
	var_char: character;
	var_boolean: boolean;
	var_array: array(1..5) of integer;
begin
	-- return en procedimiento
	return var_boolean;
end;
------------------------------------------------------
begin

	-- invocar al main proc (y ver que falla)
	fallos_expresiones;
	
	-- probar simbolo no encontrado l95
	var_not_found := 1;

	-- fallos factor -> probar not factor y factor != BOOL
	var_boolean := not true; -- ok
	var_boolean := not false; -- ok
	var_boolean := not var_boolean; -- ok

	var_boolean := not 1;
	var_boolean := not var_integer;
	var_boolean := not var_array;
	var_boolean := not var_char;
	var_boolean := not 'c';
	var_boolean := not "bad";
	var_boolean := not func_sin_params;
	var_boolean := not proc_sin_params;

	-- fallos expresión simple:
	-- probar una expresión simple con + y - delante y el tipo no es entero
		-- probar que si el valor de un término con + y - delante es distinto de null
		var_integer := -true;
		var_integer := +true;
		var_integer := +'c';
		var_integer := -'c';
	var_integer := -var_array;
	var_integer := +var_boolean;
	var_integer := -var_char;
	var_integer := -func_con_params; -- ok
	var_integer := +func_con_params; -- ok
	var_integer := -proc_sin_params;

	-- fallos expresion, que los operadores no sean booleanos
	var_boolean := true > not false;
	var_boolean := 'c' > 'b';
	var_boolean := 'c' > not false;
	var_boolean := true > 'c';
	var_boolean := var_array > var_array; -- var_array > var_boolean;
	var_boolean := "hello" > "world";
	var_boolean := proc_con_params > var_char;
	var_boolean := var_array(1) > func_con_params; -- ok

	-- fallos termino

	-- probar con más de un factor, factores != INT
	var_integer := 5 + 6 / 54 * 8 mod 3 - (4+4) * func_con_params; -- ok
	var_integer := 5 + true / (5 > 6) + var_array * var_boolean mod 'c' * proc_sin_params; 
	-- probar división entre 0
	var_integer := 5 / 0;
	var_integer := 5 / (-4+20/4-1);


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
	var_boolean := 5 + 6 < 6 and 5 - 6 > 6;


	var_boolean := 5 + var_char < 6 and 5 - var_char > 6;
	var_boolean := 5 + var_integer < 6 and 5 - var_integer > 6;
	var_boolean := 5 + var_array < 6 and 5 - var_array > 6;
	var_boolean := 5 + var_boolean < 6 and 5 - var_boolean > 6;

	var_char := 5 + 6;
	var_char := 5 - 6;
	var_char := 5 * 6;
	var_char := 5 / 6;
	var_char := 5 mod 6;
	var_char := 5 / 6;
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
	var_char := 5 / 'a';
	var_char := 5 and 'a';
	
	
	
		
end;
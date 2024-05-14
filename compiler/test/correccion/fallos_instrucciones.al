procedure fallos_instrucciones is
	var_integer: integer;
	var_char: character;
    var_bool: boolean;
	var_boolean: boolean;
	var_array: array(1..5) of integer;
    var_bool_array: array(1..5) of boolean;
    -- rango indices no valido
    var_bad_array: array(5..1) of integer;
------------------------------------------------------
procedure procedimiento is
begin
	null;
end;
------------------------------------------------------
function funcion(i : integer) return integer is
begin
	return 1;
end;
------------------------------------------------------
begin
    funcion(1) := 4;
    -- fallos instrucción leer:
    -- intentar leer en una variable que no es ni entero ni caracter
    get(var_array, var_boolean);
    -- intentar leer en una variable que no está declarada
    get(undefined);
    -- intentar leer en un literal
    --get(57, "yes", 'c', true);
    -- intentar leer en una componente de un array que no es ni entero ni caracter
    get(var_array(1)); -- ok
    get(var_bool_array(1));

	
	-- fallos instruccion escribir:
	-- escribir array
    put(var_array);
    put_line(var_array);
    put(var_array(1)); -- ok
    put_line(var_array(1)); -- ok
    put(var_bool_array(1)); -- ok
    put_line(var_bool_array(1)); -- ok
    put("yes", 'c', 1, true); -- ok
    put_line("yes", 'c', 1, true); -- ok
	
	-- inst_invocacion_o_asignacion
    -- asignar un valor a un literal
    -- 1 := 1; -- da error sintáctico como esperado
    -- asignar un valor a una función o procedimiento
    funcion := 1;
    funcion := true;
    procedimiento := 1;
    procedimiento := true;
    funcion := funcion;
    procedimiento := procedimiento;
	-- asignar un valor a un array, no a sus componentes
    var_array := var_bool_array;
    -- asignación de tipos distintos
    var_integer := var_boolean;
    var_boolean := var_integer;
    var_integer := "bad";
    var_char := "bad";
    -- asignación a una componente de array con tipo incorrecto
    var_array(1) := var_bool_array(3);
	-- invocacion a funcion sin capturar el resultado
    funcion;
    procedimiento; -- ok
end;
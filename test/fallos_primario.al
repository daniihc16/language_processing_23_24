procedure fallos_primario is
	var_integer: integer;
	var_char: character;
	var_boolean: boolean;
	var_array: array(1..5) of integer;
    var_bool_array: array(1..5) of boolean;
    var_OOR_array: array(1..4) of integer; -- array with bad range

------------------------------------------------------
function func_con_params(bool_param: boolean; integer_param: integer; char_param: character; array_param: array(1..5) of integer; 
                        ref_bool_param: ref  boolean; ref_integer_param: ref integer; ref_char_param: ref character; 
                        ref_array_param: ref array(1..5) of integer) 
return integer is
begin
	return 1;
end;
------------------------------------------------------
procedure proc_con_params(bool_param: boolean; integer_param: integer; char_param: character; array_param: array(1..5) of integer;
                        ref_bool_param: ref boolean; ref_integer_param: ref integer; ref_char_param: ref character; 
                        ref_array_param: ref array(1..5) of integer) 
is
begin
	null;
end;
------------------------------------------------------
procedure proc_sin_params is
begin
	null;
end;
------------------------------------------------------
function func_sin_params return integer is
begin
	return 1;
end;
------------------------------------------------------
begin
--fallos primario:
    var_integer := func_con_params(true, -1, int2char(4), var_array, var_boolean, +var_integer, var_char, var_array); -- ok
    proc_con_params(true, -1, int2char(4), var_array, var_boolean, var_integer, var_char, var_array); -- ok


    -- función y procedimiento con parámetros incorrectos
    -- Probar a pasar por referencia +var_int y -var_int
    var_integer := func_con_params(-6, int2char(4), "upss", var_bool_array, true, -7, 'c', var_bool_array);
    proc_con_params(-6, int2char(4), "upss", var_bool_array, true, +7, 'c', var_bool_array);


    -- función y procedimiento con un número incorrecto de parámetros (probar más y menos)
    -- var_integer := func_con_params(true, -1, int2char(4), var_array, var_boolean, var_integer, var_char); -- 1 menos
    -- var_integer := func_con_params(true, -1, int2char(4), var_array, var_boolean, var_integer, var_char, var_array, 1); -- 1 más
    -- proc_con_params(true, -1, int2char(4), var_array, var_boolean, var_integer, var_char); -- 1 menos
    -- proc_con_params(true, -1, int2char(4), var_array, var_boolean, var_integer, var_char, var_array, 1); -- 1 más


    -- función y procedimientos declarados sin parámetros pero se le pasan
    var_integer := func_sin_params(1,2,3,4);
    var_integer := func_sin_params("bad");
    var_integer := func_sin_params('c');
    var_integer := func_sin_params(true);
    proc_sin_params(1,2,3,4);
    proc_sin_params("bad");
    proc_sin_params('c');
    proc_sin_params(true);--

    -- función y procedimientos declarados con parámetros pero no se le pasan
    var_integer := func_con_params;
    proc_con_params;--

    -- función y procedimientos con parámetro de tipo array con distinto tipo base y mismo rango
    var_integer := func_con_params(true, -1, int2char(4), var_bool_array, var_boolean, var_integer, var_char, var_bool_array);
    proc_con_params(true, -1, int2char(4), var_bool_array, var_boolean, var_integer, var_char, var_bool_array);--

    -- función y procedimientos con parámetro de tipo array con distinto rango y mismo tipo base
    var_integer := func_con_params(true, -1, int2char(4), var_OOR_array, var_boolean, var_integer, var_char, var_OOR_array);
    proc_con_params(true, -1, int2char(4), var_OOR_array, var_boolean, var_integer, var_char, var_OOR_array);--

    -- hacer invocación con un identificador que no es función, procedimiento o array
    var_array;
    var_integer;
    var_boolean;
    var_char;
    -- int2char y char2int con tipos incorrectos
    var_char := int2char('c');
    var_char := int2char("bad");
    var_char := int2char(true);
    var_integer := char2int(1);
    var_integer := char2int("bad");
    var_integer := char2int(true);

end;

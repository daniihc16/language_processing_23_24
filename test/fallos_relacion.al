procedure fallos_relacion is
	var_integer: integer;
	var_char: character;
	var_boolean: boolean;
	var_array: array(1..5) of integer;

    function func_sin_params return integer is
	    var_array: array(1..1) of boolean;
	    var_integer: integer;
	    var_char: character;
	    var_boolean: boolean;
    begin
        null;
    end;
    ------------------------------------------------------
    function func_con_params return integer is
    begin
    	null;
    end;
    ------------------------------------------------------
    procedure proc_sin_params is
    begin
    	null;
    end;
    ------------------------------------------------------
begin
-- fallos relacion:
	-- | | tipos operadores distintos (todas las combinaciones)
    var_boolean := not var_integer;
    var_boolean := not var_char;
    var_boolean := not var_array;
    var_boolean := not func_sin_params;
    var_boolean := not proc_sin_params;

    var_boolean := var_integer < var_char;
    var_boolean := var_integer < var_array;
    var_boolean := var_integer < func_sin_params; -- ok
    var_boolean := var_integer < proc_sin_params;

    var_boolean := var_char < var_integer;
    var_boolean := var_char < var_array;
    var_boolean := var_char < func_sin_params;
    var_boolean := var_char < proc_sin_params;

    var_boolean := var_array < var_integer;
    var_boolean := var_array < var_char;
    var_boolean := var_array < func_sin_params;
    var_boolean := var_array < proc_sin_params;

    var_boolean := func_sin_params < var_integer; --ok
    var_boolean := func_sin_params < var_char;
    var_boolean := func_sin_params < var_array;
    var_boolean := func_sin_params < proc_sin_params;

    var_boolean := proc_sin_params < var_integer;
    var_boolean := proc_sin_params < var_char;
    var_boolean := proc_sin_params < var_array;
    var_boolean := proc_sin_params < func_sin_params;

	-- | | operaciones probar las operaciones con tipos iguales, distintos de INT (todas las combinaciones, incluyendo array y string)
    var_boolean := var_char < var_char; -- ok
    var_boolean := var_array < var_array;
    var_boolean := func_sin_params < func_sin_params; -- ok
    var_boolean := proc_sin_params < proc_sin_params;

	-- | | operadores del mismo tipo distinto de array y string con valor

end;
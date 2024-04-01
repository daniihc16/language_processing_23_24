--Fichero que prueba el reconocimiento semántico de put_line
-- Probar a escribir array -> fallo
-- escritura de un entero -> sale el entero como carácter: put(9) -> '9'
-- escritura de un bool -> 'true' | 'false'
procedure fallos_put_line is
	var_integer: integer;
	var_char: character;
	var_boolean: boolean;
	var_array: array(1..5) of integer;
------------------------------------------------------
begin
	-- Aunque no se han inicializado las variables, semanticamente es correcto

	put_line("Esto es un entero: ", int2char(var_integer));
	put_line("Esto es un char: ", var_char);
	put_line("Esto es un boolean: ", var_boolean);
	put_line("Esto es un entero: ", 9);
	put_line("Esto es un entero: ", int2char(3+3+3));
	put_line("Esto es un boolean: ", true);
	put_line("Esto es un boolean: ", false);
	put_line("Esto es un char: ", 'a');
	put_line("Esto es un char: ", '9');
	put_line("Esto es un char: ", ' ');

	put_line("Esto es un entero da error: ", 3+3+3);
	put_line("Esto es un array da error: ", var_array);
	put_line("Esto es un entero da error: ", var_integer);


	put_line;  -- Esto simplemente escribe un salto de línea
	put("Esto es un entero: ", int2char(var_integer));
	put("Esto es un char: ", var_char);
	put("Esto es un boolean: ", var_boolean);
	put("Esto es un entero: ", 9);
	put_line("Esto es un entero: ", int2char(3+3+3));
	put("Esto es un boolean: ", true);
	put("Esto es un boolean: ", false);
	put("Esto es un char: ", 'a');
	put("Esto es un char: ", '9');
	put("Esto es un string con comillas simples: ", 's');
	put("Esto es un char: ", ' ');
	
	put_line("Esto es un entero da error: ", 3+3+3);
	put("Esto es un array da error: ", var_array);
	put("Esto es un entero da error: ", var_integer);
end;
procedure a is
	var_a, var_b: integer;
	enb: integer;
------------------------------------------------------
begin
    get(var_a, var_b);
    get(var_a);
    get(var_b);
    
    put_line("var_a",var_a);
    put_line("var_b",var_b);
    put_line("a+b",var_a+var_b);
end;
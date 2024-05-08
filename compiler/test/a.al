procedure a is
	var_a, var_b: integer;
	enb: integer;
    v_array: array(0..3) of integer;
    
procedure proc_con_v(v: array(0..3) of integer) is
begin 
    null;
end;
procedure proc_con_v_ref(v_por_ref: ref array(0..3) of integer) is
begin
    proc_con_v(v_por_ref);
    --put_line("proc_con_v_ref");
    --put_line("v_por_ref(0)",v_por_ref(0));
    --put_line("v_por_ref(1)",v_por_ref(1));
    --put_line("v_por_ref(2)",v_por_ref(2));

end;
------------------------------------------------------
begin
    get(var_a, var_b);
    get(var_a);
    get(var_b);
    
    put_line("var_a",var_a);
    put_line("var_b",var_b);
    put_line("a+b",var_a+var_b);
    --put_line(true, 2, 'c', -1); -- HACER QUE SE PUEDA ESCRIBIR EL -1

    -- Un valor que tienes por referencia se lo pasas a una función que lo pida por valor
    -- Tiene que apilar todos los valores del vector original
    -- v_array(0) := 1;
    -- v_array(1) := 2;
    -- v_array(2) := 3;
    -- v_array(3) := 4;

    proc_con_v_ref(v_array);


end;
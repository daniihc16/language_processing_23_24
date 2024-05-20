procedure testwhile is
    var_a, var_b: integer;

procedure whilerefs(a,b: ref integer) is
begin
    while a > b loop
        var_a := a;
    end loop;
end;

begin
    while var_a > var_b loop
        var_a := 1;
    end loop;

    while false loop
        var_a := 4;
    end loop;
    
    while true loop
        var_a := 6;
    end loop;
end;
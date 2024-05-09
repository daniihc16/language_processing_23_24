procedure testif is
    var_a, var_b: integer;

begin
    if var_a > var_b then
        var_a := 1;
    elsif var_b > var_a then
        var_a := 1;
    else
        var_a := 1;
    end if;

    if false then
        var_a := 1;
    else
        var_b := 1;
    end if;

    
end;
procedure testif is
    var_a, var_b: integer;

procedure testifrefs(a,b: ref integer) is
begin
    if a > b then
        var_a := a;
    else
        var_b := b;
    end if;
end;

begin
    if var_a > var_b then
        var_a := 1;
    elsif var_b > var_a then
        var_a := 2;
    else
        var_a := 3;
    end if;

    if false then
        var_a := 4;
    else
        var_b := 5;
    end if;

    if true then
        var_a := 6;
    end if;
end;
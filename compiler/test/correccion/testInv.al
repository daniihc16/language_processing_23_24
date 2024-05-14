procedure a is
	a,b : boolean;
    c,d : integer;
    
procedure f(v: bool) is
begin 
    null;
end;

procedure proc_con_params(a,b: integer; c: ref integer) is
begin
    
    f(a and b);
    f(a and b=2);
    f(a=b);
    f(c+d > d);
    f(a and not b);
    f(not b);


end;
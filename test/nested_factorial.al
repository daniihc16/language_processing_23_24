procedure nested_factorial is
n: integer;

function factorial(n: integer) return integer is
	function factorial_rec(n: integer) return integer is
    begin
        if (n = 1) then
            return 1;
        else
            return n * factorial_rec(n - 1);
        end if;
    end;
begin
    return factorial_rec(n);
end;

begin
    put ("Escribe un numero (>0): ");
	get (n);
  	put_line(n, "! = ", factorial(n));
end;
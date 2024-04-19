----------------------------------------------------------------------
--- TEST QUE  COMPRUEBA DECLARACIONES ANIDADAS DE PROCEDIMIENTOS
----------------------------------------------------------------------
procedure cambio_base is
	num, base: integer;
	enb: integer;
procedure procesoPapa is
        procedure iniciar (s: ref array(0..100) of integer) is
        --------------------------------------------------------------------
            i: integer;
        --------------------------------------------------------------------------
            procedure dato (d: ref integer) is
            begin
                d:=0;
                while d <= 0 loop
                    put ("Escribe un numero (>0): ");
                    get (d);
                    if d <= 0 then
                        put_line("El numero debe ser > 0.");
                    end if;
                end loop;
            end;
        begin
            i := 1;
            while i <= elementos loop
                colonia(i) := (i mod 20) = 0;
                i := i + 1;
            end loop;
        end;


    begin
        i := 0;
        while i <= ndigitos loop
            s(i) := 0;
            i := i + 1;
        end loop;
    end;


    function dec_b(n: integer;b: integer) return integer is
        resto,valRec: integer;
    begin
        if (n < b) then
            return n;
        else
            resto := n mod b;

            valRec := dec_b (n / b, b);
            return valRec*10 + resto;
        end if;
    end;

    begin
        num := 4;
        Base := 2;

        put("Este programa convierte n=",num," a base b=", base);
        put_line(", y luego efectúa la conversión inversa.");
        put_line;
        put_line("n: ",num);
        put_line("b: ",base);
        enB := dec_b(num,base);
        put_line("dec_b(",num,",",base,"): ",enB);
        put_line("b_dec(",enB,",",base,"): ",b_dec(enB,base));
    end;
end;

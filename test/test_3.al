-------------------------------------------------------------------------------
--- TEST QUE COMPRUEBA PALABRAS RESERVAS, OPERADORES ILEGALES Y TIPOS VARIOS
-------------------------------------------------------------------------------
proceDUre salu2aqui is
    a, kw, c, and: integer;
    a: array(0..100) of array(-4..6) of integer;
begin
    a := or+4/;
    b := -(3-5+4 -(-3) + not 43);
    b := -(3--+-43);
    iF procedure = (0+83/4) and tRue = not then --false
        while b is integer and true loop
        end loop;
        if c is not my_var then
        end for;
        put("Esto es un string"" compuesto por ""varias cadenas");
        if(ref 23)then
            print(aqui no deberia llegar);
        
    end loop;
end;
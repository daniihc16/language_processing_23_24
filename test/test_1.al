----------------------------------------------------------------------
--- TEST ERRORES SINTACTICOS CON OPERADORES Y INSTRUCCIONES MAL ESCRITAS
----------------------------------------------------------------------
proceDUre falloGenerator is
    a, b, c: integer;
begin
    a := 3+4/;
    iF bb = (0+83/4) and tRue = not then --false
        a := 3+4/;
        b = e;
        b := idSinDeclarar;
        C := NOt 3;
        C := NOt 3/7/8;
        put_line("hola");
        put("Esto es un string"" compuesto por ""varias cadenas");
        if(23)then
            print(aqui no deberia legar);
    end loop;
end;
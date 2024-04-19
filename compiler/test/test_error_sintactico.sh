#!/bin/bash
# Ejecutamos el programa de parseado de tokens y vemos si hay algún error

# para cada fichero del directorio de test
#find ../test -name \*.al -print | xargs -I '{}' java -jar dist/alike.jar '{}' | grep "*.al\|ERROR"

for file in $(ls *.al)
do
    echo "Procesando $file"
    java -jar ../practica_1/dist/alike.jar $file | grep "ERROR"
done
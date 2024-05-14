#!/bin/bash
# Script ejecutado desde ./compiler

PATH_TO_COMPILER="dist/alike_4.jar"
PATH_TO_COMPILER_TEACHER="../alike/alike.jar"
COMMENT=""

COMPILER=$PATH_TO_COMPILER
if [ "$1" = "-t" ]; then
    COMPILER=$PATH_TO_COMPILER_TEACHER 
    TARGET=$2 
elif [ "$1" = "-c" ]; then
        COMMENT="$1"
        TARGET="$2.al"
else
    TARGET="$1.al"
fi

TEST_CON_IMPUT=""

PATH_TO_ENSAMBLADOR="../alike/pcode_tools/linux/ensamblador"
PATH_TO_MAQUINAP="../alike/pcode_tools/linux/maquinap"

# Compilar todos los ficheros *.al con el compilador nuestro
# java -jar ../alike/alike.jar -x   test/a
#../alike/pcode_tools/linux/ensamblador test/a
#../alike/pcode_tools/linux/maquinap test/a

if [ "$1" = "-t" ]; then
echo "--------------------------------- Compilando con compilador PROFESORES ---------------------------------"
else
    echo "--------------------------------- Compilando TARGET con compilador ---------------------------------"
fi
echo "--------------------------------- Compilando TARGET con compilador ---------------------------------"
echo "java -jar $COMPILER $COMMENT "test/${TARGET}""
java -jar $COMPILER $COMMENT "test/${TARGET}"

TARGET=$(echo $TARGET | cut -d '.' -f1)

echo "--------------------------------- Generando ensamblador ---------------------------------"
echo "$PATH_TO_ENSAMBLADOR test/${TARGET}"
$PATH_TO_ENSAMBLADOR "test/$TARGET"

echo "--------------------------------- Ejecutando maquina_p ---------------------------------"
echo "$PATH_TO_MAQUINAP test/${TARGET}"
$PATH_TO_MAQUINAP "test/${TARGET}"

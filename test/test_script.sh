#!/bin/bash
# Script ejecutado desde ./alike

PATH_TO_COMPILER="dist/alike_4.jar"
PATH_TO_COMPILER_TEACHER="../CompiladorTeacher/alike.jar"

PATH_TO_ENSAMBLADOR="pcode_tools/linux/ensamblador"
PATH_TO_MAQUINAP="pcode_tools/linux/maquinap"
PATH_TO_TEST="../test"

COMMENT=""

COMPILER=$PATH_TO_COMPILER
if [ "$1" = "-t" ]; then
    COMPILER=$PATH_TO_COMPILER_TEACHER 
    TARGET=$2 
elif [ "$1" = "-c" ]; then
    COMMENT="$1"
    TARGET=$2
else
    TARGET=$1
fi

TEST_CON_IMPUT=""



if [ "$1" = "-t" ]; then
    echo "--------------------------------- Compilando con compilador PROFESORES ---------------------------------"
else
    echo "--------------------------------- Compilando TARGET con compilador ---------------------------------"
fi

echo "java -jar $COMPILER $COMMENT "${PATH_TO_TEST}/${TARGET}""
java -jar $COMPILER $COMMENT "${PATH_TO_TEST}/${TARGET}"
mv "$TARGET.pcode" $PATH_TO_TEST

TARGET=$(echo $TARGET | cut -d '.' -f1)

echo "--------------------------------- Generando ensamblador ---------------------------------"
echo "$PATH_TO_ENSAMBLADOR ${PATH_TO_TEST}/${TARGET}"
$PATH_TO_ENSAMBLADOR "${PATH_TO_TEST}/$TARGET"

echo "--------------------------------- Ejecutando maquina_p ---------------------------------"
echo "$PATH_TO_MAQUINAP ${PATH_TO_TEST}/${TARGET}"
$PATH_TO_MAQUINAP "${PATH_TO_TEST}/${TARGET}"

#/bin/bash
# Script ejecutado desde ./compiler
TARGET=$1

TEST_CON_IMPUT=""
PATH_TO_COMPILER="dist/alike_4.jar"
PATH_TO_COMPILER_TEACHER="../alike/alike.jar"
PATH_TO_ENSAMBLADOR="../alike/pcode_tools/linux/ensamblador"
PATH_TO_MAQUINAP="../alike/pcode_tools/linux/maquinap"

# Compilar todos los ficheros *.al con el compilador nuestro
# java -jar ../alike/alike.jar -x   test/a
#../alike/pcode_tools/linux/ensamblador test/a
#../alike/pcode_tools/linux/maquinap test/a
echo "Compilando TARGET con nuestro compilador"
echo "java -jar $PATH_TO_COMPILER -x  "test/${TARGET}.al""
java -jar $PATH_TO_COMPILER  "test/${TARGET}.al"

# echo "Generando ensamblador"
# echo "$PATH_TO_ENSAMBLADOR "test/${TARGET}""
# $PATH_TO_ENSAMBLADOR "test/${TARGET}"

# echo "Ejecutando maquina_p"
# echo "$PATH_TO_MAQUINAP "test/${TARGET}""
# $PATH_TO_MAQUINAP "test/${TARGET}"

Usar estos bloques para llenar la información del archivo json (en caso no exista uno):
# Terrestres
mvn exec:java -Dexec.args="lobo|terrestre|auuu"
mvn exec:java -Dexec.args="elefante|terrestre|pffff"
mvn exec:java -Dexec.args="gato|terrestre|miau"
mvn exec:java -Dexec.args="leon|terrestre|rugido"
mvn exec:java -Dexec.args="conejo|terrestre|click"

# Acuaticos
mvn exec:java -Dexec.args="pez|acuatico|glub"
mvn exec:java -Dexec.args="delfin|acuatico|ee-ee"
mvn exec:java -Dexec.args="ballena|acuatico|whooo"
mvn exec:java -Dexec.args="tiburon|acuatico|grrrr"
mvn exec:java -Dexec.args="medusa|acuatico|whoosh"

# Voladores
mvn exec:java -Dexec.args="aguila|volador|caw"
mvn exec:java -Dexec.args="murcielago|volador|chchch"
mvn exec:java -Dexec.args="halcon|volador|kreee"
mvn exec:java -Dexec.args="pato|volador|cuac"
mvn exec:java -Dexec.args="golondrina|volador|twee"


También se podría eliminar el archivo animales.json  y ejecutar el bloque, este creará el archivo con los registros.
****************************************************************************************************************************************************

Usar mvn exec:java para mostrarlos agrupados por tipo.
Usar para filtrar según tipo:
 mvn exec:java -Dexec.args="filtrar|acuatico"
 mvn exec:java -Dexec.args="filtrar|terrestre"
 mvn exec:java -Dexec.args="filtrar|volador"

*************************************************************************
Para correr el test:
mvn test






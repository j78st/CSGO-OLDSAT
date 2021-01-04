# README


## Compilation
``
mvn package
``
## Execution
``
mvn exec:java
``

## Genération de la documentation
``
mvn package && mvn javadoc:javadoc -Dshow=private
``

La génération du javadoc nécessite de recompiler le projet entier.
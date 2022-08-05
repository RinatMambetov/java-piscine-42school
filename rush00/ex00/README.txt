######################################################################################################
#                                                                                                    #
#   Instructions for compiling and starting sourcecode from the console (non-IDE).                   #
#   Instruction is written for the state where the console is opened in the project’s root folder.   #
#                                                                                                    #
######################################################################################################

# Clean
cd ConsoleGame
mvn clean

mvn validate compile test package

# Run program from archive with specific parameters:
java -jar ./target/app-1.0.jar --enemiesCount=5 --wallsCount=20 --size=10 --profile=production




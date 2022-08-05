mkdir target

# Set the destination directory for class files
javac src/java/edu/school21/printer/*/*.java -d ./target

# Specify where to find user class files
java -classpath ./target edu.school21.printer.app.Program . 0 /Users/rinat/Documents/image.png

#rm -rf target
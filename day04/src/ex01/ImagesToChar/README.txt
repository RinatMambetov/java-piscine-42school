mkdir target

# Set the destination directory for class files
javac src/java/edu/school21/printer/*/*.java -d ./target

# copy resources directory
cp -R src/resources target

# create jar-file in accordance with the manifest, which describes the starting point for launching the archive
jar cfm target/images-to-chars-printer.jar src/manifest.txt -C target .

# adding execute rights
chmod +x target/images-to-chars-printer.jar

# run jar archive with arguments
java -jar target/images-to-chars-printer.jar . 0

#rm -rf target

find   src/vehicles/*.java src/tools/*.java src/weather/*.java > sources.txt
javac -d . -sourcepath ./src @sources.txt
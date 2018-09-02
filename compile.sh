#!/bin/bash
find src/exception/*.java src/logger/*.java src/simulator/*.java src/validator/*.java > sources.txt 
javac -d . -sourcepath ./src @sources.txt 
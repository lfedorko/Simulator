#!/bin/sh
find src/*/*.java > sources.txt
javac -d . -sourcepath ./src @sources.txt
#!/bin/bash
javac -d bin_java -cp "lib/*" src/Main/model/*.java src/Main/controller/*.java src/Main/view/*.java src/Tests/*.java src/Main/Main.java
java -Dnet.bytebuddy.experimental=true -cp "lib/*:bin_java" org.junit.platform.console.ConsoleLauncher --scan-classpath

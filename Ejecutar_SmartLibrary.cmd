@echo off
cd /d "%~dp0"
if not exist out mkdir out
javac -encoding UTF-8 -d out src\*.java
if errorlevel 1 (
    echo No se pudo compilar. Comprueba que tienes instalado el JDK.
    pause
    exit /b 1
)
javaw -cp out SmartLibraryInterfaz

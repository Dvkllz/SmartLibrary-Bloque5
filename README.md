# SmartLibrary Bloque 5

Fragmento del taller sobre relaciones entre objetos y contratos. Incluye el informe en Word, los diagramas de clases y componentes en formato editable Draw.io y PNG, el código Java y la salida de ejecución.

## Ejecutar

Desde la carpeta del repositorio, con JDK 17 o posterior:

```powershell
New-Item -ItemType Directory -Force out
javac -encoding UTF-8 -d out src/*.java
java -cp out PruebaSmartLibrary
```

La primera prueba renueva del 8 al 15 de octubre de 2026. La segunda comprueba el rechazo de una fecha igual y una anterior. Los rechazos deben conservar la fecha y la cantidad de renovaciones.

## Archivos

- `SmartLibrary_Bloque5.docx`: respuestas, decisiones y conclusión.
- `diagramas/clases.drawio` y `diagramas/clases.png`: modelo de clases.
- `diagramas/componentes.drawio` y `diagramas/componentes.png`: vista funcional.
- `src/`: implementación parcial y prueba mínima.
- `evidencia/ejecucion.txt`: salida real de las pruebas.

Libro–Ejemplar se representa con agregación bajo el supuesto de que retirar la ficha del catálogo no destruye los ejemplares físicos. Cada ejemplar registrado sigue vinculado a un único libro. Las reservas solo se incluyen en el diseño; su implementación queda fuera del fragmento solicitado.


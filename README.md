# SmartLibrary Bloque 5

Fragmento del taller sobre relaciones entre objetos y contratos. Incluye el informe en Word, los diagramas de clases y componentes trabajados en Visual Paradigm Online, sus exportaciones SVG y PNG y las copias editables para importar, el código Java y la salida de ejecución.

## Ejecutar con interfaz

Con JDK 17 o posterior, abre `Ejecutar_SmartLibrary.cmd`. La ventana permite escribir la nueva fecha, renovar, consultar el historial y reiniciar el ejemplo. El archivo `SmartLibrary.jar` también se puede ejecutar con `java -jar SmartLibrary.jar`. Para compilar desde la carpeta del repositorio:

```powershell
New-Item -ItemType Directory -Force out
javac -encoding UTF-8 -d out src/*.java
java -cp out SmartLibraryInterfaz
```

El ejemplo empieza con devolución el 8 de octubre de 2026. Prueba el 15 de octubre y después una fecha igual o anterior. Los avisos aparecen en la ventana y las renovaciones se muestran en la tabla.

## Ejecutar las pruebas de consola

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
- `diagramas/*_vp.drawio`: copias para importar los mismos modelos en Visual Paradigm Online.
- `diagramas/*_vp.svg` y `diagramas/*_vp.png`: exportaciones reales de Visual Paradigm Online.
- `src/`: implementación parcial y prueba mínima.
- `evidencia/ejecucion.txt`: salida real de las pruebas.
- `evidencia/interfaz.txt` y capturas: comprobación de la renovación desde la ventana.

Libro–Ejemplar se representa con agregación bajo el supuesto de que retirar la ficha del catálogo no destruye los ejemplares físicos. Cada ejemplar registrado sigue vinculado a un único libro. Las reservas solo se incluyen en el diseño; su implementación queda fuera del fragmento solicitado.

## Diagramas en Visual Paradigm Online

- [Diagrama de clases](https://online.visual-paradigm.com/app/diagrams/#diagram:workspace=vrslgbij&proj=0&id=2)
- [Diagrama de componentes](https://online.visual-paradigm.com/app/diagrams/#diagram:workspace=vrslgbij&proj=0&id=1)

Los proyectos editables están guardados en la cuenta de Visual Paradigm. Los enlaces abren ese espacio y pueden requerir iniciar sesión. Las exportaciones incluidas se pueden consultar sin esa cuenta.

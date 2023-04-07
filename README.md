# Conversor de unidades

### Descripción:
Este es un proyecto creado para cubrir la solicitud del [Challenge ONE Back End - Java](https://www.aluracursos.com/challenges/oracle-one-back-end/conversordemoneda/sprint01) del Programa ONE donde el desafío es crear un conversor de monedas tomando como referencia la moneda del país del participante, en este caso del sol peruano (PEN) frente a las principales divisas del mundo. Además como plus se dejo libertad para que el desarrollador cree otro tipo de conversor, para lo cual se añadió un conversor de temperatura.

### Resumen del desarrollo:
1. El proyecto está desarrollado bajo el sistema Vista, Modelo, Controlador.
2. Se tiene un paquete principal llamado: proyecto y dentro de el dos paquetes denominados: codigo y gui.
3. Dentro del paquete codigo se desarrolló el objeto de los posibles cruces de conversión. Por ejemplo: De Soles a Yenes o De Celcius a Kelvin.
4. Además dentro de código se implemento una API de [ApiLayer](https://apilayer.com/marketplace/exchangerates_data-api?utm_source=apilayermarketplace&utm_medium=featured) para obtener en tiempo real el valor de la moneda a convertir.
5. En el paquete gui se desarrolló Modelo donde se tiene las funciones que realizan las operaciones de conversión tanto para moneda como temperatura.
6. También en el paquete gui se desplegó el código de Vista donde se creó cada componente de la ventana a mostrar, inicializó dichos componentes y se los estilizó.
7. Como parte final en gui se implementó la conexión entre Modelo y Vista, además de la configuración de que realizar cuando ocurren eventos específicos en la ventana generada por Vista.

### Funcionamiento
1. Para iniciar el programa se creó la clase Ejecutar que está en dentro del paquete proyecto.
2. Al hacer RUN en la clase Ejecutar aparecerá la siguiente aplicación en el centro de la ventana principal del computador.

  * La aplicación tiene 7 componentes visuales:
      * Título "Conversor - Challenge ONE"
      * ComboBox con los tipos de conversor "Elige un conversor"
      * ComboBox con las opciones para cada tipo de conversor "Opciones disponibles"
      * Una etiqueta de texto frente "Ingrese una cantidad" a una caja para recepcionar la cantidad que ingrese el usuario.
      * Una segunda etiqueta de texto "Resultado" frente a otra caja donde se mostrará la conversión realizada.

<p align="center"><img src="https://user-images.githubusercontent.com/83378496/230690853-67b5a875-ce7d-40b2-8e9b-3d8e85f2b04c.png" alt="Challenge-Pantalla-Inicial"></p>
      
3. Al cliquear el ComboBox "Elige un conversor" se desplegará los conversores disponibles, actualmente aparecería Conversor de moneda y Conversor de temperatura.
4. De acuerdo al conversor elegido, al cliquear el ComboBox "Opciones disponibles" aparecerán los cruces que el usuario puede escoger para realizar la conversión. Por ejemplo: De Soles a Euros.  
5. Luego que el usuario tenga elegido el tipo de conversor y la opción de conversión deberá ingresar la cantidad a convertir en la caja con etiqueta "Ingrese una cantidad" y presionar "Enter" para que se muestre el resultado en la caja con etiqueta "Resultado". 

<div align="center"><video src="https://user-images.githubusercontent.com/83378496/230691240-fc35f236-ec89-4798-b7ad-ace329caf672.mp4"></div>

6. Si el usuario ingresa un dato diferente a un número entero o decimal, el programa lanzará un pop up indicando "Solo se permite números"

<p align="center"><img src="https://user-images.githubusercontent.com/83378496/230692145-24e1016c-a3b2-49d0-899c-60a9962624be.png" alt="Challenge-PopUP-Nonumeros"></p>

### Desarrollado en
* [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)

### Lenguaje utilizado 
* [Java](https://www.oracle.com/java/technologies/javase/jdk19-archive-downloads.html)

### Desarrollador
[<img src="https://avatars.githubusercontent.com/u/83378496?v=4" width=90><br><sub>Cristhian Criollo</sub>](https://github.com/ccriollohuaman)



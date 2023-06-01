# _*Informe Ciberseguridad*_

- [Introducción](#introducción)
- [Dificultades](#dificultades)
- [Conclusiones](#conclusiones)

### Introducción

La seguridad de la información es un aspecto fundamental en el mundo digital, donde los datos pueden ser vulnerados o robados por agentes maliciosos. Para proteger la información, se utilizan técnicas de cifrado y descifrado, que consisten en transformar los datos mediante algoritmos y claves, de forma que solo puedan ser leídos por quienes posean las claves adecuadas. Existen diferentes tipos de algoritmos y claves, que ofrecen distintos niveles de seguridad y rendimiento.

En este informe se presenta un proyecto de cifrador/descifrador de archivos, que permite al usuario cifrar o descifrar cualquier tipo de archivo con una contraseña. El proyecto utiliza el algoritmo PBKDF2 para generar una clave de 256 bits a partir de la contraseña, y el algoritmo AES para cifrar o descifrar el archivo con la clave obtenida. Además, el proyecto incluye el cálculo y la verificación del hash SHA-256 del archivo original y del archivo descifrado, para garantizar su integridad.


### Dificultades

El proyecto ha tenido que superar algunas dificultades durante su desarrollo, que se pueden resumir en los siguientes puntos:

+ Elegir los algoritmos y las librerías adecuadas para el cifrado y el descifrado. Se ha optado por usar PBKDF2 y AES por ser algoritmos estándar y robustos, que ofrecen una buena seguridad y un buen rendimiento. Sin embargo, estos algoritmos requieren el uso de librerías específicas de Java, como javax.crypto o java.security, que pueden presentar algunas limitaciones o incompatibilidades según la versión o la plataforma utilizada.
+ Manejar los posibles errores o excepciones que puedan surgir durante el proceso de cifrado o descifrado. Algunos ejemplos son: archivos no encontrados, contraseñas incorrectas, formatos inválidos, problemas de codificación o decodificación, etc. Estos errores deben ser capturados y tratados adecuadamente, mostrando mensajes informativos al usuario o realizando acciones correctivas.
+ Garantizar la confidencialidad y la integridad de los archivos. Además de cifrar o descifrar los archivos con una clave segura, es importante asegurar que los archivos no hayan sido modificados o alterados durante su transmisión o almacenamiento, y que provengan de fuentes fiables. Para ello, se ha implementado el cálculo y la verificación del hash SHA-256 del archivo original y del archivo descifrado, que permite detectar cualquier cambio en los datos.

### Conclusiones 
+ El proyecto de cifrador/descifrador de archivos ha sido una experiencia práctica y útil, que ha permitido aplicar los conocimientos teóricos sobre criptografía a un caso real y relevante. La aplicación desarrollada cumple con los requisitos funcionales establecidos, ofreciendo al usuario una interfaz sencilla e intuitiva para cifrar o descifrar sus archivos con una contraseña. El proyecto también ha servido para identificar las dificultades y limitaciones que implica el uso de la criptografía en el ámbito informático, así como las posibles mejoras o ampliaciones que se podrían realizar en el futuro.
+ El proyecto de cifrador/descifrador de archivos ha sido un reto interesante y provechoso, que ha permitido poner en práctica los conceptos teóricos sobre criptografía a un problema concreto y actual. La aplicación desarrollada satisface los requisitos funcionales establecidos, ofreciendo al usuario una interfaz simple y amigable para cifrar o descifrar sus archivos con una contraseña.

## <b> Presentado por: </b>
<b> 😊😊 Operation Group: 😊😊 </b>

+ [Nicolás Gómez Botero](https://github.com/nicolasg1911 "Nicolás G.")
+ [Camilo González Velasco](https://github.com/camilogonzalez7424 "Camilo G.")
+ [Jhorman G. Mera Escobar](https://github.com/JhormanMera "Jhorman M.")

<br>


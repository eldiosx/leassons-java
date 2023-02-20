Made by Daniel Delgado Jiménez


La inicialización de las torres se hace en el método "inicializarTorres()" donde se crea un arreglo de listas ArrayList que representa las tres torres. Luego se agrega la cantidad de discos ingresada por el usuario a la primera torre en orden descendente (de mayor a menor). También se establece el número de turnos en 0.

Luego, en el método "jugar()", el programa entra en un bucle mientras la torre 3 (torre C) no tenga todos los discos en orden descendente. En cada turno, el programa muestra el estado actual de las torres y pide al usuario que ingrese desde qué torre quiere mover el disco y a qué torre quiere moverlo. Si el movimiento es válido, se mueve el disco y se registra el movimiento en un archivo de texto llamado "movimientos.txt".

El método "mueve()" es el encargado de validar si el movimiento es válido y mover el disco de una torre a otra. El método verifica que la torre de origen y la torre de destino estén en el rango de 0 a 2 (en caso contrario, se emite un mensaje de error). Si la torre de origen no está vacía y la torre de destino está vacía o tiene un disco más grande en la parte superior, el disco se mueve de una torre a otra.

Finalmente, cuando el juego ha terminado (todos los discos están en la torre C), se muestra un mensaje de felicitación al usuario con el número de turnos que se tomaron para resolver el juego.


Posibilidad de añadir constructores:

Generar constructores en este código permitiría inicializar las variables de la clase en el momento de la creación del objeto. Actualmente, las variables se inicializan en los métodos inicializarTorres() y main(). Al crear un constructor, se podrían mover estas inicializaciones al momento de crear el objeto. Esto también permitiría crear objetos de esta clase con diferentes configuraciones de variables.

Por ejemplo, se podría crear un constructor que tome como parámetro el número de discos, de manera que se puedan crear objetos de la clase App con diferentes cantidades de discos. También se podría crear un constructor que tome como parámetro un archivo de salida, para que el usuario pueda especificar el archivo donde se guardarán los movimientos del juego.

En cuanto a los getters y setters, en este código no hay variables privadas que requieran de estos métodos. Las variables numDiscos, torres y turnos son variables de clase, por lo que se pueden acceder a ellas directamente. Sin embargo, si se quisiera añadir variables privadas a la clase en el futuro, sería necesario generar getters y setters para poder acceder a ellas desde fuera de la clase.

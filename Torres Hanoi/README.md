Made by Daniel Delgado Jiménez

La inicialización de las torres se hace en el método "inicializarTorres()" donde se crea un arreglo de listas ArrayList que representa las tres torres. Luego se agrega la cantidad de discos ingresada por el usuario a la primera torre en orden descendente (de mayor a menor). También se establece el número de turnos en 0.

Luego, en el método "jugar()", el programa entra en un bucle mientras la torre 3 (torre C) no tenga todos los discos en orden descendente. En cada turno, el programa muestra el estado actual de las torres y pide al usuario que ingrese desde qué torre quiere mover el disco y a qué torre quiere moverlo. Si el movimiento es válido, se mueve el disco y se registra el movimiento en un archivo de texto llamado "movimientos.txt".

El método "mueve()" es el encargado de validar si el movimiento es válido y mover el disco de una torre a otra. El método verifica que la torre de origen y la torre de destino estén en el rango de 0 a 2 (en caso contrario, se emite un mensaje de error). Si la torre de origen no está vacía y la torre de destino está vacía o tiene un disco más grande en la parte superior, el disco se mueve de una torre a otra.

Finalmente, cuando el juego ha terminado (todos los discos están en la torre C), se muestra un mensaje de felicitación al usuario con el número de turnos que se tomaron para resolver el juego.
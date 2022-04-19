use bot_java_coach;

-- INGRESO DE DATOS --
insert into Niveles(id_nivel, nombre_nivel)
	values (1,'B�sico'),
	(2,'Intermedio'),
	(3,'Avanzado');

insert into capitulos (numero_capitulo, nombre_capitulo, id_nivel)	
	values(1,'Fundamentos',1),
	(2,'Operadores y Sentencias',1),
	(3,'Core Java APIs',1),
	(4,'Metodos y Encapsulamiento',2),
	(5,'Dise�o de Clase',2),
	(6,'Excepciones',3);
	
insert into conceptos (id_capitulo,
    numero_concepto,
    nombre_concepto,
    contenido_concepto)
	values (1,
		1, 
		"Atributos",
		"Los atributos, tambien llamados datos o variables, son porciones de
		 informacion que un objeto posee o conoce de si mismo. Una clase puede tener cualquier numero de atributos o no tener ninguno. 
		Se declaran con un identificador y el tipo de dato correspondiente.\nLos atributos son las caracteristicas individuales que diferencian
		 un objeto de otro y determinan su apariencia, estado u otras cualidades.\nAdem s los atributos y tienen asociado un modificador que define su visibilidad seg n se muestra en la siguiente tabla.\n\nModificador\tVisibilidad\npublic\t\tPublica (+)\nprotected\tProtegida/en la herencia (#)\nprivate\t\tPrivada (-)\npackage\t\tDe paquete (~)\n"),
		(3,1,"Paquete java.nio.file", "El java.nio.file paquete define interfaces y clases para que la m�quina virtual Java acceda a archivos, atributos de archivo y sistemas de archivos. Esta API se puede utilizar para superar muchas de las limitaciones de la java.io.Fileclase. El toPathm�todo puede usarse para obtener un archivo Pathque usa la ruta abstracta representada por un Fileobjeto para ubicar un archivo. El resultado Pathpuede usarse con la Filesclase para proporcionar un acceso m�s eficiente y extenso a operaciones de archivo adicionales, atributos de archivo y excepciones de E / S para ayudar a diagnosticar errores cuando falla una operaci�n en un archivo"),
		(6,1, "Excepciones","Las excepciones permiten que un m�todo informe al c�digo que lo ha invocado acerca de alg�n error o situaci�n an�mala que se haya producido durante su ejecuci�n. Por ejemplo, supongamos un m�todo que recibe un c�digo postal y devuelve el nombre del ayuntamiento al cual pertenece. En el caso normal de que el c�digo postal sea correcto, el m�todo devolver�a el nombre del ayuntamiento. En el caso de que el c�digo postal que se le haya pasado no exista o su formato sea incorrecto, el m�todo lo notificar�a lanzando una excepci�n. Una excepci�n en Java es un objeto de la clase Exception o de alguna de sus subclases");

insert into Preguntas(contenido_pregunta, id_concepto)
	values ('�Qu� son los atributos?',1),
	('�Cu�l de las siguientes afirmaciones es correcta?',2);

INSERT INTO ejemplos (contenido_ejemplo,descripcion_ejemplo,id_concepto)
	VALUES ('Metodos Get','public String getName() { return name; }',3),
	('Metodo Set','public void setName(){ name = newName;}',3),
	('En la l�nea 4,  s�lo hay un elemento en el array y el �ndice 1 no est� permitido. Java mostr� la excepci�n:\\n ZooException in thread "main" \\n java.lang.ArrayIndexOutOfBoundsException: 1 \\n at mainmethod.Zoo.main(Zoo.java:7)','El rol de las excepciones',2),
	('import java.util.*','Comodines',8);

INSERT INTO usuarios
(nombre_usuario, contrasenia, nombre, apellido, fecha_nacimiento, email, telefono, id_nivel)
VALUES('dcontreras', '123456', 'Doralys', 'Contreras', '1989-08-24', 'doralisacr@gmail.com', '0123456789', 2),
('dblanco', '123456', 'Daniel', 'Blanco', '1989-08-22', 'lic.danielblanco@gmail.com', '0123456789', 1),
('vocanto', '123456', 'Victor', 'Ocanto', '1980-09-12', '', '0123456789', 1); --Linea reservada para que el profe inserte su mail datos.

INSERT INTO respuestas
(contenido_respuestas, id_pregunta, es_correcta)
VALUES('3)Son las instancias de una clase', 12, 0),
('1)Las excepciones de tiempo de ejecuci�n son lo mismo que las excepciones chequeadas', 13, 0),
('2) Las excepciones de tiempo de ejecuci�n son lo mismo que las excepciones no chequeadas', 13, 0),
('3) Pod�s declarar �nicamente excepciones no chequeadas', 13, 3);
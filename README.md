# TP_API_Java_coach_bot

Se trata de una API para manejar una base de conocimientos para un bot que sea un coach de Java. Se realizó como para del trabajo practico para la finalización del curso de programación backend.

Instrucciones generales:

1. En el directorio "collection_postman", encontrará la colección de postman que debe ser importada con el mismo.
2. En el directorio "scripts_generacion_bd" encontrará los scripts a ejecutar para generar la base de datos y su data.
3. Para la prueba del endopoint /enviar/consejo, se recomienda ingresar un registro en la base de datos que contenga un dirección de correo válida, para recibir el mail correspondiente.

El bot cuenta con los siguientes endpoints:

• /conceptos : este endopint debe devolver una lista de conceptos 
• /concepto/crear : este endpoint debe poder almacenar un concepto nuevo 
• /concepto/eliminar : este endpoint debe poder eliminar un concepto 
• /concepto/actualizar : este endpoint debe poder actualizar un concepto 
• /cuestionario/por/concepto : este endpoint debe recibir un concepto y debe devolver las preguntas y respuestas posibles relacionadas a este concepto. • /cuestionario/id_respuesta/id_pregunta/ : este enpoint debe validar si el id_respuesta enviado es valido para el id_pregunta correspondiente. Este endpoint resuelve el cuestionario del endpoint anterior. 
• /enviar/consejo : este endpoint sirve para enviar un consejo aleatorio (concepto) via correo a un destinatario. 
• /generar/reporte : este endpoint sirve para generar un PDF con las cantidades de conceptos, preguntas, respuestas y ejemplos relacionados.

Cualquier consulta o sugerencia comunicarse al mail: doralisacr@gmail.com.
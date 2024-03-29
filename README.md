# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso 2022/23)
Autor/a: Raquel Ortega

## Estructura de las carpetas del proyecto

* **/src**: Directorio con el código fuente.
  * **fp.birdStrikes**: Paquete que contiene los tipos del proyecto.
  * **fp.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset del proyecto.
    * **BirdStrikes.csv**: Archivo csv que contiene datos de diferentes partidas de ajedrez.
    
## Estructura del *dataset*

* **name**: de tipo String, contiene el nombre del aeropuerto.
* **model**: de tipo String, contiene el modelo del avion.
* **ImpactFlight**:de tipo String, contiene el impacto que ha tenido sobre el avion.
* **LocalDate**: de tipo LocalDate, contiene el dia del accidente.
* **recordID**: de tipo Integer, indica el ID del avión.
* **IndicatedDamage**: de tipo Indicatedamage, contiene el tipo del impacto que ha sufrido el avion.
* **NumberEngines**: de tipo Integer, indica la cantidad de motores que tiene el avion.
* **Airline**: de tipo String, contiene el nombre de la empresa propietaria del avion.
* **originState**: de tipo String, contiene el estado americano en el que ocurrió.
* **WhenPhaseFlight**: de tipo String, contiene la fase del vuelo en la que ocurrió.
* **Size**: de tipo Size, contiene el tamaño del pajaro que chocó.
* **Species**: de tipo String, contiene la especie del pajaro que chocó.
* **When**: de tipo Integer, contiene la hora en la que ocurrió el accidente.
* **TimeDay**: de tipo Timeofday, propiedad derivada, contiene el momento del dia del accidente.
* **PilotWarned**: de tipo YesNo, indica si el piloto fue avisado de los animales locales.
* **Timeout**: de tipo Integer, contiene las horas que el avion se quedo fuera de servicio.
* **Other**: de tipo Integer, contiene otros gastos.
* **Repair**: de tipo Integer, contiene los gastos de la reparación.
* **TotalCost**: de tipo Integer, contiene el gasto total.
* **MilesFromAirport**: de tipo Integer, contiene cuan lejos estaba el avion del aeropuerto cuando ocurrio el accidente.
* **FeetAbove**: de tipo Integer, contiene como de alto estaba el avion cuando ocurrio el accidente.
* **Speed**: de tipo Integer, contiene la velocidad del avion cuando ocurrió el accidente.

### Tipo Base - BirdStrike
Representa un choque de pajaro en un avion en concreto.
**Propiedades**:

* **name**: de tipo String, contiene el nombre del aeropuerto.
* **model**: de tipo String, contiene el modelo del avion.
* **ImpactFlight**:de tipo String, contiene el impacto que ha tenido sobre el avion.
* **LocalDate**: de tipo LocalDate, contiene el dia del accidente.
* **recordID**: de tipo Integer, indica el ID del avión.
* **IndicatedDamage**: de tipo Indicatedamage, contiene el tipo del impacto que ha sufrido el avion.
* **NumberEngines**: de tipo Integer, indica la cantidad de motores que tiene el avion.
* **Airline**: de tipo String, contiene el nombre de la empresa propietaria del avion.
* **originState**: de tipo String, contiene el estado americano en el que ocurrió.
* **WhenPhaseFlight**: de tipo String, contiene la fase del vuelo en la que ocurrió.
* **Size**: de tipo Size, contiene el tamaño del pajaro que chocó.
* **Species**: de tipo String, contiene la especie del pajaro que chocó.
* **When**: de tipo Integer, contiene la hora en la que ocurrió el accidente.
* **TimeDay**: de tipo Timeofday, propiedad derivada, contiene el momento del dia del accidente.
* **PilotWarned**: de tipo YesNo, indica si el piloto fue avisado de los animales locales.
* **Timeout**: de tipo Integer, contiene las horas que el avion se quedo fuera de servicio.
* **Other**: de tipo Integer, contiene otros gastos.
* **Repair**: de tipo Integer, contiene los gastos de la reparación.
* **TotalCost**: de tipo Integer, contiene el gasto total.
* **MilesFromAirport**: de tipo Integer, contiene cuan lejos estaba el avion del aeropuerto cuando ocurrio el accidente.
* **FeetAbove**: de tipo Integer, contiene como de alto estaba el avion cuando ocurrio el accidente.
* **Speed**: de tipo Integer, contiene la velocidad del avion cuando ocurrió el accidente.

**Constructores**: 

- C1: Tiene un parámetro por cada propiedad básica del tipo.
- C2: Crea un objeto de tipo BirdStrike con los parametros: String name, LocalDate flightDate, IndicatedDamage indicatedDamage, Size size, String species, YesNo pilotWarned.

**Restricciones**:
 
- R1: El numero de motores debe ser mayor de 0.
- R2: El numero de horas que pasó fuera de servicio debe ser mayor de 0.
- R3: El coste total debe ser la suma de los gastos de reparacion y otros.
- R4: El coste de reparacion debe ser mayor de 0.
- R5: El coste de otros debe ser mayor de 0.

***Criterio de igualdad**: Dos choques son iguales si todas sus propiedades básicas son iguales.

**Criterio de ordenación**: Por fecha, y luego hora.

#### Tipos auxiliares:
-Bird: representa un pajaro con las siguientes propuedades: -Size -Species -PilotWarned

###Factoría - FactoriaBirdStrikes
-BirdStrikes leerBirdStrikes(String nombreFichero): Crea un objeto de tipo BirdStrike a partir de la unformacion recogida en el archivo csv, cuya ruta se da como parametro.

**Tipo Contenedor - BirdStrikes**:
Clase contenedora de los objetos de tipo BIrdStrike.

***Propiedades:***
-birdStrikes de tipo List<BirdStrike>, consultable. Lista de BirdStrikes.
-numero BirdStrikes, de tipo Integer, consultable. Numero de birdStrikes en el contenedor.

***Constructores***:

-C1: Constructor por defecto. Crea un objeto de tipo BirdStrikes sin ningun BirdStrike almacenado.
-C2: COnstructor con un oarametro de tipo Collection<BirdStrike>. Crea un objeto de tipo BirdStrikes con las birdStrikes incluidas en la coleccion dada como parametro.

***Criterio de igualdad***: Dos BirdStrikes son iguales si lo son sus propiedades.

***Otras propiedades***:

- void agrearBirdStrikes(BirdStrike b): Añade un BirdStrike.

- void agregarCollection(Collection<BirdStrikes> c): Añade una colleccion de birdStrikes.

- void eliminarBirdStrike(BirdStrike b): Elimina un BirdStrike.

- Boolean existeAvionNombreYModelo(String name, String model): Devuelve true si existe este modelo y ese nombre de avion.

- Double getMediaCosteTotal(): Devuelve la media del coste total de todos los BirdStrikes.

- Collection<BirdStrike> getFiltradoPorHoraDelDia(Timeofday timeday): Devuelve una coleccion filtrada por el momento del día designado.

- Map<String, Set<Size>> getTamañoPorEspecie(): Devuelve un map que por cada especie nos devuelve el tamaño que esa especie de pajaro puede tener.

- Map<Boolean, Integer> getCuantosPilotosFueronAvisados(): Devuelve un map que relaciona si fue avisado el piloto o no con la cantidad a la que le pasó.


- Boolean existeAvionNombreYModelo2(String name, String model):Devuelve true si existe este modelo y ese nombre de avion. Por streams.
	
- Double getMediaCosteTotal2():Devuelve la media del coste total de todos los BirdStrikes. Por streams.
	
- Collection<BirdStrike> getFiltradoPorHoraDelDia2(Timeofday timeday): Devuelve una colleccion filtrada por el momento del día designado.
	
- OptionalDouble calcularMaximoCosteTotal(Boolean pilotWarned): Devuelve el coste total máximo si el piloto cumple que fue/no fue avisado.
	
- List<BirdStrike> seleccionFiltradoOrdenado(Size size, int year): Devuelve una lista filtrada ordenada de todos los birdstrikes que cumplan que el pajaro tenia un tamaño determinado y el año es ese.
	
- Map<String, Set<Size>> getTamañoPorEspecie2():Devuelve un map que por cada especie nos devuelve el tamaño que esa especie de pajaro puede tener.
	
- Map<Timeofday, Integer> getNumAccidentesPorMomento(): Devuelve un map que por cada momento del día (Dusk, day, night, dawn) nos da la cantidad de birdstrikes que ha habido.
	
- Map<Size, Integer> getMaximoCosteTotalPorTamaño(): Devuelve un map que asocia a cada tamaño el mayor coste total.
	
- SortedMap<Integer, List<BirdStrike>> getMasRapidosPorNumeroDeEngines(Integer n): Devuelve un SortedMap que asocia a cada numero de motores los n vuelos mas rapidos con ese numero.
	
- Map<String, Integer> getMaxMillasDesdeElAeropuertoPorLineaDeVuelo(): Devuelve un map que asocia a cada linea de vuelos las distancia maxima a la que se encontró el avion cuando el accidente sucedió.

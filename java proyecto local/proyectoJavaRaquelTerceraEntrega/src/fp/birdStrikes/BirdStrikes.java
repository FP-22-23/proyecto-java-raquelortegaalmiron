package fp.birdStrikes;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.SortedMap;

public interface BirdStrikes {
	
	List<BirdStrike> getBirdStrikes();

	Integer getNumeroBirdStrikes();
	
	void agregarBirdStrike(BirdStrike b);
	
	void agregarColeccion(Collection<BirdStrike> c);
	
	void eliminarBirdStike(BirdStrike p);
	
	Boolean existeAvionNombreYModelo(String name, String model);
	
	Double getMediaCosteTotal();
	
	Collection<BirdStrike> getFiltradoPorHoraDelDia(Timeofday timeday);
	
	Map<String, Set<Size>> getTamañoPorEspecie();
	
	Map<Boolean, Integer> getCuantosPilotosFueronAvisados();
		
	//tercera entrega
	
	Boolean existeAvionNombreYModelo2(String name, String model);
	
	Double getMediaCosteTotal2();
	
	Collection<BirdStrike> getFiltradoPorHoraDelDia2(Timeofday timeday);
	
	OptionalDouble calcularMaximoCosteTotal(Boolean pilotWarned);
	
	List<BirdStrike> seleccionFiltradoOrdenado(Size size, int year);
	
	Map<String, Set<Size>> getTamañoPorEspecie2();
	
	Map<Timeofday, Integer> getNumAccidentesPorMomento();
	
	Map<Size, Integer> getMaximoCosteTotalPorTamaño();
	
	SortedMap<Integer, List<BirdStrike>> getMasRapidosPorNumeroDeEngines(Integer n);
	
	Map<String, Integer> getMaxMillasDesdeElAeropuertoPorLineaDeVuelo();


	}

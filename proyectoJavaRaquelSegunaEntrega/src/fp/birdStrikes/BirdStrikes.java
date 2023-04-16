package fp.birdStrikes;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

	}

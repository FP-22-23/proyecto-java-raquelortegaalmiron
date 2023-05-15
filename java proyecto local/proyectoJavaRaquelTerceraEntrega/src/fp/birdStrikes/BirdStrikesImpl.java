package fp.birdStrikes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class BirdStrikesImpl implements BirdStrikes{

	private List<BirdStrike> BirdStrikes;

	public BirdStrikesImpl() {
		BirdStrikes = new ArrayList<BirdStrike>();
	}
	
	public BirdStrikesImpl(Collection<BirdStrike> birdStrikes) {
		this.BirdStrikes = new ArrayList<BirdStrike>(birdStrikes);
	}
	
	public BirdStrikesImpl(Stream<BirdStrike> birdStrike) {
		this.BirdStrikes = birdStrike.collect(Collectors.toList());
	}
	
	public List<BirdStrike> getBirdStrikes() {
		return BirdStrikes;
	}

		
	public Integer getNumeroBirdStrikes() {
		return BirdStrikes.size();
	}

	@Override
	public void agregarBirdStrike(BirdStrike c) {
		BirdStrikes.add(c);
		
	}

	@Override
	public void agregarColeccion(Collection<BirdStrike> c) {
		BirdStrikes.addAll(c);
		
	}

	@Override
	public void eliminarBirdStike(BirdStrike p) {
		BirdStrikes.remove(p);
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(BirdStrikes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BirdStrikesImpl other = (BirdStrikesImpl) obj;
		return Objects.equals(BirdStrikes, other.BirdStrikes);
	}

	@Override
	public String toString() {
		return "BirdStrikes [BirdStrikes=" + BirdStrikes + "]";
	}

	@Override
	public Boolean existeAvionNombreYModelo(String name, String model) {
		boolean existe = false;
		for(BirdStrike b: BirdStrikes) {
			if(b.getName().equals(name) && b.getModel().equals(model)) {
				existe = true;
			}
		}
		return existe;
	}

	@Override
	public Double getMediaCosteTotal() {
        Double res = 0.0;
        Double suma = 0.0;
        Integer cont = 0;
        for (BirdStrike p: BirdStrikes) {
            suma+= p.getTotalCost();
            cont++;
            }
        if (cont>0) {
            res = suma/cont;
            }
        return res;
	}

	@Override
	public Collection<BirdStrike> getFiltradoPorHoraDelDia(Timeofday timeday) {
		List<BirdStrike> filtrado = new ArrayList<>();
		for(BirdStrike b: BirdStrikes) {
			if(b.getTimeDay().equals(timeday)) {
				filtrado.add(b);
			}
		}
		return filtrado;
	}

	@Override
	public Map<String, Set<Size>> getTamañoPorEspecie() {
		Map<String, Set<Size>> res = new HashMap<>();
		
		for(BirdStrike b : BirdStrikes) {
			String species = b.getSpecies();
			Size tamaño = b.getSize();
			
			if (!res.containsKey(species)) {
				res.put(species, new HashSet<Size>());
			}
			res.get(species).add(tamaño);
		}
		
		return res;
	}

	@Override
	public Map<Boolean, Integer> getCuantosPilotosFueronAvisados() {
		Map<Boolean, Integer> res = new HashMap<Boolean, Integer>();
		for(BirdStrike b: BirdStrikes) {
			Boolean clave = b.getPilotWarned();
			if(res.containsKey(clave)) {
				res.put(clave, res.get(clave)+1);
			}else {
				res.put(clave, 1);
				}
			}
		return res;
	}
	
	//tercera entrega
	
	public Boolean existeAvionNombreYModelo2(String name, String model) {
		return BirdStrikes.stream()
				.anyMatch(x -> x.getName().equals(name) 
				&& x.getModel().equals(model));
	}
	
	public Double getMediaCosteTotal2() {
		return BirdStrikes.stream()
				.mapToDouble(BirdStrike::getTotalCost)
				.average()
				.orElse(0.0);
	}
	public Collection<BirdStrike> getFiltradoPorHoraDelDia2(Timeofday timeday) {
		return BirdStrikes.stream().filter(birdStrike -> timeday == birdStrike.getTimeDay()).collect(Collectors.toSet());
	}
	
	public OptionalDouble calcularMaximoCosteTotal(Boolean pilotWarned) {
	    return BirdStrikes.stream()
	            .filter(bs -> bs.getPilotWarned() == pilotWarned)
	            .mapToDouble(BirdStrike::getTotalCost)
	            .max();
	}
	public List<BirdStrike> seleccionFiltradoOrdenado(Size size, int year) {
	    return BirdStrikes.stream()
	            .filter(bs -> bs.getSize() == size && bs.getFlightDate().getYear() == year)
	            .sorted(Comparator.comparing(BirdStrike::getFlightDate))
	            .collect(Collectors.toList());
	}	
	
	
	
	public Map<String, Set<Size>> getTamañoPorEspecie2() {
		return BirdStrikes.stream()
				.collect(Collectors.groupingBy(
					BirdStrike::getSpecies,
					Collectors.mapping(BirdStrike::getSize, Collectors.toSet())));
	}
	
	public Map<Timeofday, Integer> getNumAccidentesPorMomento(){
		return BirdStrikes.stream()
				.collect(Collectors.groupingBy(
						BirdStrike::getTimeDay,
						Collectors.collectingAndThen(Collectors.counting(),Long::intValue)));
	}
	
	public Map<Size, Integer> getMaximoCosteTotalPorTamaño(){
		return BirdStrikes.stream()
		        .collect(Collectors.groupingBy(
		            BirdStrike::getSize,
		            Collectors.mapping(BirdStrike::getTotalCost, Collectors.maxBy(Integer::compareTo))
		        ))
		        .entrySet().stream()
		        .collect(Collectors.toMap(
		            Map.Entry::getKey,
		            e -> e.getValue().orElseThrow(IllegalStateException::new)
		        ));
	}

	
	public SortedMap<Integer, List<BirdStrike>> getMasRapidosPorNumeroDeEngines(Integer n){
		return BirdStrikes.stream()
				.collect(Collectors.groupingBy(BirdStrike::getNumberEngines,
						TreeMap::new,
						Collectors.collectingAndThen(
								Collectors.toCollection(
										() -> new TreeSet<>(Comparator.comparing(BirdStrike::getSpeed).reversed())),
								c -> c.stream().limit(n).collect(Collectors.toList()))));	
	}
	
	public Map<String, Integer> getMaxMillasDesdeElAeropuertoPorLineaDeVuelo(){
		return BirdStrikes.stream()
				.collect(Collectors.groupingBy(BirdStrike::getAirline,
						Collectors.maxBy(Comparator.comparingInt(BirdStrike::getMilesFromAirport))))
				.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey,e -> e.getValue().orElse(null).getMilesFromAirport()));
	}
	
	
	
}


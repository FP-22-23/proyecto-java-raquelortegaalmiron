package fp.birdStrikes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class BirdStrikesImpl implements BirdStrikes{

	private List<BirdStrike> BirdStrikes;

	public BirdStrikesImpl() {
		BirdStrikes = new ArrayList<BirdStrike>();
	}
	
	public BirdStrikesImpl(Collection<BirdStrike> birdStrikes) {
		this.BirdStrikes = new ArrayList<BirdStrike>(birdStrikes);
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
		return BirdStrikes.stream().anyMatch(x -> x.getName().equals(name) 
				&& x.getModel().equals(model));
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
		return BirdStrikes.stream().filter(birdStrike -> timeday == birdStrike.getTimeDay()).collect(Collectors.toSet());
	}

	@Override
	public Map<String, Set<Size>> getTamañoPorEspecie() {
		return BirdStrikes.stream().collect(Collectors.groupingBy(BirdStrike::getSpecies, Collectors.mapping(BirdStrike::getSize, Collectors.toSet())));
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
}


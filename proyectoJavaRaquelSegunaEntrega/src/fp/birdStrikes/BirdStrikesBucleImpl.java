package fp.birdStrikes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BirdStrikesBucleImpl implements BirdStrikes{
	
	private List<BirdStrike> birdStrikes;

	public BirdStrikesBucleImpl() {
		birdStrikes = new ArrayList<BirdStrike>();
	}

	public BirdStrikesBucleImpl(Collection<BirdStrike> birdStrikes) {
		this.birdStrikes = new ArrayList<BirdStrike>(birdStrikes);
	}
	//metodos
	@Override
	public Integer getNumeroBirdStrikes() {
		return birdStrikes.size();
	}

	@Override
	public void agregarBirdStrike(BirdStrike b) {
		birdStrikes.add(b);
		
	}

	@Override
	public void agregarColeccion(Collection<BirdStrike> c) {
		birdStrikes.addAll(c);
		
	}

	@Override
	public void eliminarBirdStike(BirdStrike p) {
		 birdStrikes.remove(p);
		
	}
	//exists
	
	public Boolean existeAvionNombreYModelo(String name, String model) {
		return birdStrikes.stream().anyMatch(x -> x.getName().equals(name) 
				&& x.getModel().equals(model));
		}
	
	//media
	
	public Double getMediaCosteTotal() {
        Double res = 0.0;
        Double suma = 0.0;
        Integer cont = 0;
        for (BirdStrike p: birdStrikes) {
            suma+= p.getTotalCost();
            cont++;
            }
        if (cont>0) {
            res = suma/cont;
            }
        return res;
        }
	//filtrado
	
	public Collection<BirdStrike> getFiltradoPorHoraDelDia(Timeofday timeday) {
		return birdStrikes.stream().filter(birdStrike -> timeday == birdStrike.getTimeDay()).collect(Collectors.toSet());
	}
	
	//agrupacion
	public Map<String, Set<Size>> getTamañoPorEspecie(){
		return birdStrikes.stream().collect(Collectors.groupingBy(BirdStrike::getSpecies, Collectors.mapping(BirdStrike::getSize, Collectors.toSet())));
	}
	//acumulacion
	
	public Map<Boolean, Integer> getCuantosPilotosFueronAvisados(){
		Map<Boolean, Integer> res = new HashMap<Boolean, Integer>();
		for(BirdStrike b: birdStrikes) {
			Boolean clave = b.getPilotWarned();
			if(res.containsKey(clave)) {
				res.put(clave, res.get(clave)+1);
			}else {
				res.put(clave, 1);
				}
			}
		return res;
	}

	@Override
	public List<BirdStrike> getBirdStrikes() {
		return birdStrikes;
	}
}

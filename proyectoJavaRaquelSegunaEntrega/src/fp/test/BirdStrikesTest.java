package fp.test;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import fp.birdStrikes.BirdStrike;
import fp.birdStrikes.BirdStrikes;
import fp.birdStrikes.FactoriaBirdStrikes;
import fp.birdStrikes.Size;
import fp.birdStrikes.Timeofday;

public class BirdStrikesTest {
	
	public static void main(String[] args) {
		BirdStrikes birdStrikes = FactoriaBirdStrikes.leerBirdStrikes("data/BirdStrikes.csv");
		//BirdStrike birdStrike = new BirdStrike(birdStrikes);
		testGetNumeroBirdStrikes(birdStrikes);
		testExisteAvionNombreYModelo(birdStrikes,"SANTA MARIA PUBLIC","C-208");
		testGetFiltradoPorHoraDelDia(birdStrikes, Timeofday.DAWN);
		testGetTamañoPorEspecie(birdStrikes);
		testGetCuantosPilotosFueronAvisados(birdStrikes);
		//testGetBirdStrikes(birdStrikes);
		
		}
	private static void testGetNumeroBirdStrikes(BirdStrikes birdStrikes){
		try {Integer num = birdStrikes.getNumeroBirdStrikes();
		System.out.println("Hay " + num + " leidos." + "\n");
		}catch (IllegalArgumentException i) {
			System.out.println(i.getMessage());
		}
	}
	private static void testExisteAvionNombreYModelo(BirdStrikes birdStrikes, String name, String model) {
		try { Boolean b = birdStrikes.existeAvionNombreYModelo(name, model);
		System.out.println(b + "." + "\n");
		}catch (IllegalArgumentException i) {
			System.out.println(i.getMessage());
		}
	}
	private static void testGetFiltradoPorHoraDelDia(BirdStrikes birdStrikes, Timeofday timeday) {
		try { Collection<BirdStrike> b = birdStrikes.getFiltradoPorHoraDelDia(timeday);
			System.out.println("La lista filtrada por el momento del dia es:" + b + "." + "\n");
		}catch (IllegalArgumentException i) {
			System.out.println(i.getMessage());
		}
	}
	private static void testGetTamañoPorEspecie(BirdStrikes birdStrikes) {
		try { Map<String, Set<Size>> m = birdStrikes.getTamañoPorEspecie();
		System.out.println(m + "." + "\n");
		}catch (IllegalArgumentException i) {
			System.out.println(i.getMessage());
		}
	}
	private static void testGetCuantosPilotosFueronAvisados(BirdStrikes birdStrikes) {
		try {Map<Boolean, Integer> m = birdStrikes.getCuantosPilotosFueronAvisados();
		System.out.println("Fueron avisados " + m.get(true) + " y no fueron avisados " + m.get(false) + "."+ "\n");
		}catch (IllegalArgumentException i) {
			System.out.println(i.getMessage());
		}
	}
	/*
	private static void testGetBirdStrikes(BirdStrikes birdStrikes) {
		try {List<BirdStrike> l = birdStrikes.getBirdStrikes();
		System.out.println("Los Bird Strikes que se leyeron fueron:" + l +"\n");
		}catch (IllegalArgumentException i) {
			System.out.println(i.getMessage());
		}
	}
	*/
}

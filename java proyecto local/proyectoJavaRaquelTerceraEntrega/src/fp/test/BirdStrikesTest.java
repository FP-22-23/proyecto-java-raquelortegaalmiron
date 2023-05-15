package fp.test;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.SortedMap;

import fp.birdStrikes.BirdStrike;
import fp.birdStrikes.BirdStrikes;
import fp.birdStrikes.FactoriaBirdStrikes;
import fp.birdStrikes.Size;
import fp.birdStrikes.Timeofday;

public class BirdStrikesTest {
	
	public static void main(String[] args) {
		BirdStrikes birdStrikes = FactoriaBirdStrikes.leerBirdStrikes("data/BirdStrikes.csv");
		testGetNumeroBirdStrikes(birdStrikes);
		testExisteAvionNombreYModelo(birdStrikes,"SANTA MARIA PUBLIC","C-208");
		//testGetMediaCosteTotal(birdStrikes);
		testGetFiltradoPorHoraDelDia(birdStrikes, Timeofday.DAWN);
		testGetTamañoPorEspecie(birdStrikes);
		testGetCuantosPilotosFueronAvisados(birdStrikes);
		
		testExisteAvionNombreYModelo2(birdStrikes,"SANTA FE MUNICIPAL", "BE-1900");
		testGetMediaCosteTotal2(birdStrikes);
		testGetFiltradoPorHoraDelDia2(birdStrikes, Timeofday.NIGHT);
		testCalcularMaximoCosteTotal(birdStrikes, true);
		testSeleccionFiltradoOrdenado(birdStrikes, Size.LARGE, 2011);
		testGetTamañoPorEspecie2(birdStrikes);
		testGetNumAccidentesPorMomento(birdStrikes);
		testGetMaximoCosteTotalPorTamaño(birdStrikes);
		testGetMasRapidosPorNumeroDeEngines(birdStrikes, 3);
		testgetMaxMillasDesdeElAeropuertoPorLineaDeVuelo(birdStrikes);
		
		
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
		
	    public static void testGetMediaCosteTotal(BirdStrikes birdStrikes) {
			try { Double m = birdStrikes.getMediaCosteTotal();
			System.out.println("La media total del coste fue de:" + m + "." + "\n");
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
	
	//tercera entrega

    public static void testExisteAvionNombreYModelo2(BirdStrikes birdStrikes, String name, String model) {
		try { Boolean b = birdStrikes.existeAvionNombreYModelo2(name, model);
		System.out.println(b + "." + "\n");
		}catch (IllegalArgumentException i) {
			System.out.println(i.getMessage());
		}
    }
    public static void testGetMediaCosteTotal2(BirdStrikes birdStrikes) {
		try { Double m = birdStrikes.getMediaCosteTotal2();
		System.out.println("La media total del coste fue de:" + m + "." + "\n");
		}catch (IllegalArgumentException i) {
			System.out.println(i.getMessage());
		}
    }
    
	private static void testGetFiltradoPorHoraDelDia2(BirdStrikes birdStrikes, Timeofday timeday) {
		try { Collection<BirdStrike> b = birdStrikes.getFiltradoPorHoraDelDia2(timeday);
			System.out.println("La lista filtrada por el momento del dia es:" + b + "." + "\n");
		}catch (IllegalArgumentException i) {
			System.out.println(i.getMessage());
		}
	}
	
	private static void testCalcularMaximoCosteTotal(BirdStrikes birdStrikes, Boolean pilotWarned) {
		try { OptionalDouble m = birdStrikes.calcularMaximoCosteTotal(pilotWarned);
		System.out.println("El máximo coste total cuando el piloto tenía este estado de aviso ("+ pilotWarned + ") fue de " + m + "." + "\n");
	}catch (IllegalArgumentException i) {
		System.out.println(i.getMessage());
		}
	}
	
	private static void testSeleccionFiltradoOrdenado(BirdStrikes birdStrikes, Size size, int year) {
		try { List<BirdStrike> n = birdStrikes.seleccionFiltradoOrdenado(size, year);
		System.out.println("La lista de BirdStrikes filtrada por el tamñao del pajaro y el año es:" + n + "." + "\n");
	}catch (IllegalArgumentException i) {
		System.out.println(i.getMessage());
		}
	}
	private static void testGetTamañoPorEspecie2(BirdStrikes birdStrikes) {
		try { Map<String, Set<Size>> m = birdStrikes.getTamañoPorEspecie2();
		System.out.println(m + "." + "\n");
		}catch (IllegalArgumentException i) {
			System.out.println(i.getMessage());
		}
	}
	
	private static void testGetNumAccidentesPorMomento(BirdStrikes birdStrikes) {
		try {Map<Timeofday, Integer> m = birdStrikes.getNumAccidentesPorMomento();
		System.out.println("El numero de accidentes ocurridos en los distintos momentos del dia es de:" + m + "." + "\n");
		}catch (IllegalArgumentException i) {
			System.out.println(i.getMessage());
		}
	}
	
	private static void testGetMaximoCosteTotalPorTamaño(BirdStrikes birdStrikes) {
		try {Map<Size, Integer> m = birdStrikes.getMaximoCosteTotalPorTamaño();
		System.out.println("El coste total máximo causado por cada tamaño de pajaro es de:" + m + "." + "\n");
		}catch (IllegalArgumentException i) {
			System.out.println(i.getMessage());
		}
	}
	private static void testGetMasRapidosPorNumeroDeEngines(BirdStrikes birdStrikes, Integer n) {
		try {SortedMap<Integer, List<BirdStrike>> s = birdStrikes.getMasRapidosPorNumeroDeEngines(n);
		System.out.println("Los" + n + "vuelos donde se alcanzó las mayores velocidades por cada numero de motor son:" + s + "." + "\n");
		}catch (IllegalArgumentException i) {
			System.out.println(i.getMessage());
		}
	}
	private static void testgetMaxMillasDesdeElAeropuertoPorLineaDeVuelo(BirdStrikes birdStrikes) {
		try {Map<String, Integer> m = birdStrikes.getMaxMillasDesdeElAeropuertoPorLineaDeVuelo();
		System.out.println("El vuelo en el que se tomó la maxima distacia antes del accidente por cada linea de vuelos es:" + m + "." + "\n");
		}catch (IllegalArgumentException i) {
			System.out.println(i.getMessage());
		}
	}
}

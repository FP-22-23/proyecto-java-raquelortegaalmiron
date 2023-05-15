package fp.test;

import java.time.LocalDate;

import fp.birdStrikes.BirdStrike;
import fp.birdStrikes.IndicatedDamage;
import fp.birdStrikes.Size;

public class BirdStrikeTest {	
	
	public static void mostrarBirdStrike(BirdStrike b) {
		System.out.println(b);
		}
	
	public static void testConstructor1(String name, String model, String impactFlight, LocalDate flightDate,
			Integer recordID, IndicatedDamage indicatedDamage, Integer numberEngines, String airline,
			String originState, String whenPhaseFlight, Size size, String species, Integer when, Boolean pilotWarned,
			Integer timeOut, Integer other, Integer repair, Integer totalCost, Integer milesFromAirport,
			Integer feetAbove, Integer speed) {
		
		try {
			BirdStrike b1 = new BirdStrike(name, model, impactFlight, flightDate,
					recordID, indicatedDamage, numberEngines, airline,
					originState, whenPhaseFlight, size, species, when, pilotWarned,
					timeOut, other, repair, totalCost, milesFromAirport,
					feetAbove, speed);	
			mostrarBirdStrike(b1);
			
		} catch(IllegalArgumentException e) {
			System.out.println("Excepción capturada:\n   " + e);	
		} catch (Exception e) {
			System.out.println("Excepción inesperada:\n   " + e);
		}

	}
	
	public static void testConstructor2(String name, LocalDate flightDate, IndicatedDamage indicatedDamage, Size size, String species,
			Boolean pilotWarned) {
		try {
			BirdStrike b2 = new BirdStrike(name, flightDate, indicatedDamage, size,  species,
			pilotWarned);
			mostrarBirdStrike(b2);
		} catch(IllegalArgumentException e) {
			System.out.println("Excepción capturada:\n   " + e);	
		} catch (Exception e) {
			System.out.println("Excepción inesperada:\n   " + e);
		}
	}
	public static void main(String [] args) {
	
		BirdStrike b = new BirdStrike("SANTA MARIA PUBLIC", "C-208", "Aborted Take-off", LocalDate.of(2005, 4, 5), 229628,IndicatedDamage.NO , 1, "WeSTAIR", "California", "Take-off run", Size.LARGE, "Turkey vulture", 755, true,1,0,0,0,0,0,85);
		System.out.println(b);	
		
		testConstructor1("SANTA MARIA PUBLIC", "C-208", "Aborted Take-off", LocalDate.of(2005, 4, 5), 229628,IndicatedDamage.NO , 1, "WeSTAIR", "California", "Take-off run", Size.LARGE, "Turkey vulture", 755, true,1,0,0,0,0,0,85);
		testConstructor2("SANTA MARIA PUBLIC", LocalDate.of(2005, 4, 5), IndicatedDamage.NO , Size.LARGE, "Turkey vulture", true );
		
	}
	
}

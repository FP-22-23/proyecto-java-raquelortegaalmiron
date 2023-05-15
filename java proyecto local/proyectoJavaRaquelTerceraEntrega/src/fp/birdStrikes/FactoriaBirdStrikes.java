package fp.birdStrikes;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class FactoriaBirdStrikes {
	
	public static BirdStrikes leerBirdStrikes(String nombreFichero) {
		BirdStrikes res = null;
		try {
			List<BirdStrike> birdStrikes=Files.lines(Paths.get(nombreFichero))
					.skip(0)
					.map(FactoriaBirdStrikes::parsearBirdStrike)
					.collect(Collectors.toList());
			
			res = new BirdStrikesImpl(birdStrikes);
		}   catch(IOException e) {
			System.out.println("Fichero no encontrado:" + nombreFichero);
			e.printStackTrace();
		}
		return res;
	}
	private static BirdStrike parsearBirdStrike(String linea) {
		String[] trozos=linea.split(";");
		
		String name = trozos[0].trim();
		String model = trozos[1].trim();
		String impactFlight = trozos[2].trim();
		LocalDate flightDate = LocalDate.parse(trozos[3].trim(), DateTimeFormatter.ofPattern("M/dd/yyyy"));
		Integer recordID = Integer.parseInt(trozos[4].trim());
		IndicatedDamage indicatedDamage= IndicatedDamage.valueOf(trozos[5].trim().toUpperCase());
		Integer numberEngines = Integer.parseInt(trozos[6].trim());
		String airline = trozos[7].trim();
		String originState = trozos[8].trim();
		String whenPhaseFlight = trozos[9].trim();
		Size size= Size.valueOf(trozos[10].trim().toUpperCase());
		String species=trozos[11].trim();
		Integer when = Integer.parseInt(trozos[12].trim());
		Boolean pilotWarned = parseaBooleano(trozos[13].trim());
		Integer timeOut = Integer.parseInt(trozos[14].trim());
		Integer other = Integer.parseInt(trozos[15].trim());
		Integer repair = Integer.parseInt(trozos[16].trim());
		Integer totalCost = Integer.parseInt(trozos[17].trim());
		Integer milesFromAirport = Integer.parseInt(trozos[18].trim());
		Integer feetAbove = Integer.parseInt(trozos[19].trim());
		Integer speed = Integer.parseInt(trozos[20].trim());
		
		return new BirdStrike(name, model, impactFlight, flightDate,recordID,
				indicatedDamage, numberEngines, airline, originState,
				whenPhaseFlight, size, species, when, pilotWarned,
				timeOut, other, repair, totalCost, milesFromAirport,
				feetAbove, speed);
	}
	
	private static boolean parseaBooleano(String pilotWarned) {
		String res = null;
				switch(pilotWarned) {
				case "Y":
					res = "true";
					break;
				case "N":
					res = "false";
				}
				boolean result = Boolean.parseBoolean(res);
				return result;
	}
	public static BirdStrikes leerBirdStrikes2(String nombreFichero) {	
		BirdStrikes res = null;
		try {
			List<BirdStrike> birdStrikes=Files.lines(Paths.get(nombreFichero))
					.skip(0)
					.map(FactoriaBirdStrikes::parsearBirdStrike)
					.collect(Collectors.toList());
			
			res = new BirdStrikesImpl(birdStrikes.stream());
		}   catch(IOException e) {
			System.out.println("Fichero no encontrado:" + nombreFichero);
			e.printStackTrace();
		}
		return res;
		}
	}

package fp.test;

import fp.birdStrikes.FactoriaBirdStrikes;

import fp.birdStrikes.BirdStrike;
import fp.birdStrikes.BirdStrikes;

public class TestFactoriaBirdStrikes {
	
	public static void main(String[] args) {
		testLeerBirdStrikes("data/BirdStrikes.csv");
	}

	private static void testLeerBirdStrikes(String fichero) {
		BirdStrikes birdStrikes = FactoriaBirdStrikes.leerBirdStrikes(fichero);
		for(BirdStrike b: birdStrikes.getBirdStrikes()) {
			System.out.println(b);
		}
	}

}


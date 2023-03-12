package src.fp.test;

import java.time.LocalDate;
import java.time.LocalTime;

import src.fp.birdStrikes.BirdStrike;
import src.fp.birdStrikes.IndicatedDamage;
import src.fp.birdStrikes.Size;
import src.fp.birdStrikes.YesNo;
import src.fp.birdStrikes.Timeofday;

public class BirdStrikeTest {

	public static void main(String[] args) {
		
		
		BirdStrike b = new BirdStrike("SANTA MARIA PUBLIC", "< 1000ft", "C-208", "Aborted Take-off", LocalDate.of(2005, 4, 5), 229628,IndicatedDamage.NO , 1, "WeSTAIR", "California", "Take-off run", Size.LARGE, "Turkey vulture", 755, YesNo.Y,1,0,0,0,0,0,85);
		System.out.println(b);		
		}
}

package fp.birdStrikes;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fp.utiles.Checkers;

public class BirdStrike implements Comparable <BirdStrike>{

	//Atributos
	private	String name;
	private String model;
	private String impactFlight;
	private LocalDate flightDate;
	private Integer recordID;
	private IndicatedDamage indicatedDamage;
	private Integer numberEngines;
	private String airline;
	private String originState;
	private String whenPhaseFlight;
	private Size size;
	private String species;
	private Integer when; //en verdad es una hora pero en el csv viene como un entero
	//private Timeofday timeDay; va a ser la derivada
	private Boolean pilotWarned;
	private Integer timeOut;
	private Integer other;
	private Integer repair;
	private Integer totalCost;
	private Integer milesFromAirport;
	private Integer feetAbove;
	private Integer speed;
	//Auxiliar bird lleva tamaño, especie y si se avisó al piloto
	//lsita avion lleva nombre, modelo
	
	//Constructores
	public BirdStrike(String name, String model, String impactFlight, LocalDate flightDate,
			Integer recordID, IndicatedDamage indicatedDamage, Integer numberEngines, String airline,
			String originState, String whenPhaseFlight, Size size, String species, Integer when, Boolean pilotWarned,
			Integer timeOut, Integer other, Integer repair, Integer totalCost, Integer milesFromAirport,
			Integer feetAbove, Integer speed) {
		this.name = name;
		this.model = model;
		this.impactFlight = impactFlight;
		this.flightDate = flightDate;
		this.recordID = recordID;
		this.indicatedDamage = indicatedDamage;
		this.numberEngines = numberEngines;
		this.airline = airline;
		this.originState = originState;
		this.whenPhaseFlight = whenPhaseFlight;
		this.size = size;
		this.species = species;
		this.when = when;
		this.pilotWarned = pilotWarned;
		this.timeOut = timeOut;
		this.other = other;
		this.repair = repair;
		this.totalCost = totalCost;
		this.milesFromAirport = milesFromAirport;
		this.feetAbove = feetAbove;
		this.speed = speed;
	
	}
	

	public BirdStrike(String name, LocalDate flightDate, IndicatedDamage indicatedDamage, Size size, String species,
			Boolean pilotWarned) {
		this.name = name;
		this.flightDate = flightDate;
		this.indicatedDamage = indicatedDamage;
		this.size = size;
		this.species = species;
		this.pilotWarned = pilotWarned;
	
	}


	//Getters y setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getImpactFlight() {
		return impactFlight;
	}

	public void setImpactFlight(String impactFlight) {
		this.impactFlight = impactFlight;
	}

	public LocalDate getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(LocalDate flightDate) {
		this.flightDate = flightDate;
	}

	public Integer getRecordID() {
		return recordID;
	}

	public void setRecordID(Integer recordID) {
		this.recordID = recordID;
	}

	public IndicatedDamage getIndicatedDamage() {
		return indicatedDamage;
	}

	public void setIndicatedDamage(IndicatedDamage indicatedDamage) {
		this.indicatedDamage = indicatedDamage;
	}

	public Integer getNumberEngines() {
		return numberEngines;
	}

	public void setNumberEngines(Integer numberEngines) {
		Checkers.check("El numero de motornes no es posible", getNumberEngines()>0);
		this.numberEngines = numberEngines;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getOriginState() {
		return originState;
	}

	public void setOriginState(String originState) {
		this.originState = originState;
	}

	public String getWhenPhaseFlight() {
		return whenPhaseFlight;
	}

	public void setWhenPhaseFlight(String whenPhaseFlight) {
		this.whenPhaseFlight = whenPhaseFlight;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public Integer getWhen() {
		return when;
	}

	public void setWhen(Integer when) {
		this.when = when;
	}

	public Boolean getPilotWarned() {
		return pilotWarned;
	}

	public void setPilotWarned(Boolean pilotWarned) {
		this.pilotWarned = pilotWarned;
	}

	public Integer getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(Integer timeOut) {
		Checkers.check("El número de horas es incorrecto", getTimeOut()>0);
		this.timeOut = timeOut;
	}

	public Integer getOther() {
		return other;
	}

	public void setOther(Integer other) {
		Checkers.check("El coste es incorrecto", getOther()>=0);
		
		this.other = other;
	}

	public Integer getRepair() {
		return repair;
	}

	public void setRepair(Integer repair) {
		Checkers.check("El coste es incorrecto", getOther()>0);
		this.repair = repair;
	}

	public Integer getTotalCost() {
		Checkers.check("El coste total debe ser la suma de los otros gastos", getTotalCost() == getRepair() + getOther());
		return totalCost;
	}

	public void setTotalCost(Integer totalCost) {
		this.totalCost = totalCost;
	}

	public Integer getMilesFromAirport() {
		return milesFromAirport;
	}

	public void setMilesFromAirport(Integer milesFromAirport) {
		this.milesFromAirport = milesFromAirport;
	}

	public Integer getFeetAbove() {
		return feetAbove;
	}

	public void setFeetAbove(Integer feetAbove) {
		this.feetAbove = feetAbove;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}
	//Propiedad derivada
	public Timeofday getTimeDay() {
		Timeofday res = Timeofday.NIGHT;
		if (when <= 500) {
			res = Timeofday.NIGHT; 
		}
		else if (500 < when && when <= 630) {//else if (when.compareTo(5:00)>0 && when.compareTo(6:30)<=0) {
			res = Timeofday.DAWN;
		}
		else if (630 < when && when <= 1830) {//else if (when.compareTo(6:30)>0 && when.compareTo(18:30)<=0) {
			res = Timeofday.DAY;
		}
		else if(2000 < when && when <= 2100) {//else if (when.compareTo(18:30)>0 && when.compareTo(21:00)<=0 {
			res = Timeofday.DUSK;
		}
		else if (2100 < when && when <= 2359) {//else if (when.compareTo(21:30)>0 && when.compareTo(23:59)<=0) {
			res = Timeofday.NIGHT;
		}
		return res;
	}
	
	//propiedad conjunto avion
	
	public List<String> getAvion(){
		ArrayList<String> a = new ArrayList<String>();
		a.add(getName());
		a.add(getModel());
		
		return a;
	}
	
	
	//representacion como cadena
	public String toString() {
		return "BirdStrikes [name=" + name + ", model=" + model + ", impactFlight="
				+ impactFlight + ", flightDate=" + flightDate + ", recordID=" + recordID + ", indicatedDamage="
				+ indicatedDamage + ", numberEngines=" + numberEngines + ", airline=" + airline + ", originState="
				+ originState + ", whenPhaseFlight=" + whenPhaseFlight + ", size=" + size + ", species=" + species
				+ ", when=" + when + ", pilotWarned=" + pilotWarned + ", timeOut=" + timeOut + ", other=" + other
				+ ", repair=" + repair + ", totalCost=" + totalCost + ", milesFromAirport=" + milesFromAirport
				+ ", feetAbove=" + feetAbove + ", speed=" + speed + "]";
	}
	
	//criterio igualdad
	@Override
	public int hashCode() {
		return Objects.hash(airline, feetAbove, flightDate, impactFlight, indicatedDamage, milesFromAirport, model,
				name, numberEngines, originState, other, pilotWarned, recordID, repair, size, species, speed, timeOut,
				totalCost, when, whenPhaseFlight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BirdStrike other = (BirdStrike) obj;
		return Objects.equals(airline, other.airline) && Objects.equals(feetAbove, other.feetAbove)
				&& Objects.equals(flightDate, other.flightDate) && Objects.equals(impactFlight, other.impactFlight)
				&& indicatedDamage == other.indicatedDamage && Objects.equals(milesFromAirport, other.milesFromAirport)
				&& Objects.equals(model, other.model) && Objects.equals(name, other.name)
				&& Objects.equals(numberEngines, other.numberEngines) && Objects.equals(originState, other.originState)
				&& Objects.equals(this.other, other.other) && pilotWarned == other.pilotWarned
				&& Objects.equals(recordID, other.recordID) && Objects.equals(repair, other.repair)
				&& size == other.size && Objects.equals(species, other.species) && Objects.equals(speed, other.speed)
				&& Objects.equals(timeOut, other.timeOut) && Objects.equals(totalCost, other.totalCost)
				&& Objects.equals(when, other.when) && Objects.equals(whenPhaseFlight, other.whenPhaseFlight);
	
	}

	
	//criterio ordenacion
	public int compareTo(BirdStrike a) {
		int res = flightDate.compareTo(a.getFlightDate());
		if (res == 0) {
			res = when.compareTo(a.getWhen());
		}
		return res;
	}
}


import java.util.*;

public class Practica8{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		Torneo MM = new Torneo();
		String aux;
		
		MM.inicio();
		
		System.out.print("Nombre del torneo: ");
		MM.setNombre(in.nextLine());
		
		System.out.print("Region: ");
		MM.setRegion(in.nextLine());
		
		System.out.print("Partidas jugadas: ");
		MM.setPartidasJugadas(in.nextInt());
		MM.setPartidasPendientes(4 - MM.getPartidasJugadas());
		aux = in.nextLine();
		
		for(int i = 0; i < 5; i++){
			System.out.print("\nEquipo " + (i + 1) + ": ");
			MM.equipos[i].setNombre(in.nextLine());
			
			System.out.print("Division: ");
			MM.equipos[i].setDivision(in.nextLine());
			
			for(int j = 0; j < 10; j++){
				do{
					System.out.print("Jugador " + (j + 1) + ": ");
					aux = in.nextLine();
				}while(MM.buscarJugador(aux) == 5);
				
				MM.equipos[i].jugadores[j].setNombre(aux);
			}
		}
		
		
		System.out.println("\n\tTorneo " + MM.getNombre() + "       Region: " + MM.getRegion() + "       No. de participantes: " + MM.getNoEquipos());
		System.out.println("\t\tPartidas jugadas: " + MM.getPartidasJugadas() + "    Partidas pendientes: " + MM.getPartidasPendientes());
		for(int i = 0; i < 5; i++){
			System.out.print("\n\tEquipo: " + MM.equipos[i].getNombre());
			System.out.println("     Division: " + MM.equipos[i].getDivision());
			
			System.out.print("\tJugadores: " + MM.equipos[i].getJugadores());
			System.out.println("     Puntuacion total: " + MM.equipos[i].puntosTotales());
			
			for(int j = 0; j < 10; j++){
				for(int k = 0; k < 2; k++){
					if(k == 0){
						System.out.print("Camisa: " + MM.equipos[i].jugadores[j].getNoUniforme() + "\t");
					}
					else if(k == 1){
						System.out.print("Nombre: " + MM.equipos[i].jugadores[j].getNombre() + "\t");
					}
				}
				System.out.println("");
			}
			System.out.println("\n\n");
		}
	}
}
 
class Equipo{
	private String nombre, division, entrenador;
	private int torneosParticipados, torneosGanados, torneosPerdidos;
	protected Jugador jugadores[] = new Jugador[10];
	
	public int getJugadores(){
		int i = 0;
		while(i < 10){
			if(jugadores[i].getNombre() == ""){
				return i;
			}
			i++;
		}
		return i;
	}
	
	public int puntosTotales(){
		int suma = 0;
		for(int i = 0; i < 10; i++){
			suma = jugadores[i].getPuntos();
		}
		return suma;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getDivision(){
		return division;
	}
	
	public void setDivision(String division){
		this.division = division;
	}
	
	public void inicio(){
		for(int i = 0; i < 10; i++){
			jugadores[i] = new Jugador();
			jugadores[i].setNombre("");
			jugadores[i].setNoUniforme(i + 5);
		}
	}
}

class Jugador{
	private int noJugador, puntos, estatura;
	private String nombre, posicion;
	
	public int getNoUniforme(){
		return noJugador;
	}
	
	public int getPuntos(){
		return puntos;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public void setPuntos(int puntos){
		this.puntos = puntos;
	}
	
	public void setNoUniforme(int noJugador){
		this.noJugador = noJugador;
	}
}

class Torneo{
	private String nombre, region;
	private int noEquipos, noPartidasJugadas, noPartidasPendientes;
	protected static Equipo equipos[] = new Equipo[5];
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getRegion(){
		return region;
	}
	
	public void setRegion(String region){
		this.region = region;
	}
	
	public int getNoEquipos(){
		int i = 0;
		while(i < 5){
			if(equipos[i].getNombre() == ""){
				return i;
			}
			i++;
		}
		return i;
	}
	
	public int getPartidasJugadas(){
		return noPartidasJugadas;
	}
	
	public void setPartidasJugadas(int noPartidasJugadas){
		this.noPartidasJugadas = noPartidasJugadas;
	}
	
	public int getPartidasPendientes(){
		return noPartidasPendientes;
	}
	
	public void setPartidasPendientes(int noPartidasPendientes){
		this.noPartidasPendientes = noPartidasPendientes;
	}
	
	public void inicio(){
		for(int i = 0; i < 5; i++){
			equipos[i] = new Equipo();
			equipos[i].setNombre("");
			equipos[i].setDivision("");
			equipos[i].inicio(); 
		}
	}
	
	public int buscarJugador(String player){
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 10; j++){
				if(player.equals(equipos[i].jugadores[j].getNombre())){
					return 5;
				}
			}
		}
		return 0;
	}
}
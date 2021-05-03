import java.util.*;

class C{
	static int T = 5, P = 10;
	
}

public class Practica8{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		Torneo MM = new Torneo();
		String aux;
		
		MM.inicio();
		
		for(int i = 0; i < C.T; i++){
			System.out.print("Equipo " + i + ": ");
			MM.equipos[i].setNombre(in.nextLine());
			
			for(int j = 0; j < C.P; j++){
				do{
					System.out.print("Jugador " + j + ": ");
					aux = in.nextLine();
				}while(MM.buscarJugador(aux) == C.T);
				
				MM.equipos[i].jugadores[j].setNombre(aux);
			}
		}
		
		for(int i = 0; i < C.T; i++){
			System.out.println("\n\tEquipo: " + MM.equipos[i].getNombre() + "\n");
			
			for(int j = 0; j < C.P; j++){
				for(int k = 0; k < 3; k++){
					if(k == 0){
						System.out.print("Camisa: " + MM.equipos[i].jugadores[j].getNoUniforme() + "\t");
					}
					else if(k == 1){
						System.out.print("Nombre: " + MM.equipos[i].jugadores[j].getNombre() + "\t");
					}
					else if(k == 2){
						System.out.print("Puntos: " + MM.equipos[i].jugadores[j].getPuntos() + "\t");
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
	private String torneosParticipados[], torneosGanados[], torneosPerdidos[];
	protected Jugador jugadores[] = new Jugador[C.P];
	
	public int getJugadores(){
		int i = 0;
		while(i < C.P){
			if(jugadores[i].getNombre() == ""){
				return i;
			}
			i++;
		}
		return i;
	}
	
	public int puntosTotales(){
		int suma = 0;
		for(int i = 0; i < C.P; i++){
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
	
	public void inicio(){
		for(int i = 0; i < C.P; i++){
			jugadores[i] = new Jugador();
			jugadores[i].setNombre("");
			jugadores[i].setPuntos(0);
			jugadores[i].setNoUniforme(i + C.T);
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
	protected static Equipo equipos[] = new Equipo[C.T];
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getRegion(){
		return region;
	}
	
	public int getNoEquipos(){
		return noEquipos;
	}
	
	public int getPartidasJugadas(){
		return noPartidasJugadas;
	}
	
	public int getPartidasPendientes(){
		return noPartidasPendientes;
	}
	
	public void inicio(){
		for(int i = 0; i < C.T; i++){
			equipos[i] = new Equipo();
			equipos[i].setNombre("");
			equipos[i].inicio(); 
		}
	}
	
	public int buscarJugador(String player){
		for(int i = 0; i < C.T; i++){
			for(int j = 0; j < C.P; j++){
				if(player.equals(equipos[i].jugadores[j].getNombre())){
					return C.T;
				}
			}
		}
		return 0;
	}
}
import java.util.Scanner;
public class Avion {
	Scanner valor = new Scanner(System.in);
	protected int horizontal = 0;
	protected boolean vertical = true;
	protected String Matricula;
	protected String Autonomia;
	protected double Alçada;
	protected String Capacitat;
	protected double Posicion;
	Avion (String Matricula, String Autonomia, double Alçada, String Capacitat, double Posicion) {
		this.Matricula = Matricula;
		this.Autonomia = Autonomia;
		this.Alçada = Alçada;
		this.Capacitat = Capacitat;
		this.Posicion = Posicion;
	}
	public String getMatricula() {
		return Matricula;
	}
	public void setMatricula(String matricula) {
		Matricula = matricula;
	}
	public String getAutonomia() {
		return Autonomia;
	}
	public void setAutonomia(String autonomia) {
		Autonomia = autonomia;
	}
	public double getAlçada() {
		return Alçada;
	}
	public void setAlçada(double alçada) {
		Alçada = alçada;
	}
	public String getCapacitat() {
		return Capacitat;
	}
	public void setCapacitat(String capacitat) {
		Capacitat = capacitat;
	}
	public double getPosicion() {
		return Posicion;
	}
	public void setPosicion(double posicion) {
		Posicion = posicion;
	}
	public double ModificarPos(int horizontal) {
		System.out.println("Indicar si el avion debe avanzar o retroceder");
		System.out.println("1. Avanzar \n0. Retroceder");
		horizontal = valor.nextInt();
		if (horizontal==1) {
			Posicion = Posicion+1;
		}
		else if (horizontal==0) {
			Posicion = Posicion-1;
		}
		else {
			System.out.println("Valor no valido");
		}
		return Posicion;
	}
	public double ModificarAlt(boolean vertical) {
		System.out.println("Indicar si el avion debe subir o bajar");
		System.out.println("true. Subir \nfalse. Bajar");
		vertical = valor.nextBoolean();
		if (vertical==true) {
			Alçada = Alçada+1;
		}
		else {
			Alçada = Alçada-1;
		}
		return Alçada;
	}
	public void imprimir() {
		System.out.println(this.Matricula + " " + this.Alçada + " " + this.Posicion);
	}
}

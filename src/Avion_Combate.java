
public class Avion_Combate extends Avion {
	protected int Municion;
	Avion_Combate(String Matricula, String Autonomia, double Alçada, String Capacitat, double Posicion, int Municion) {
		super(Matricula, Autonomia, Alçada, Capacitat, Posicion);
		this.Municion = Municion;
		// TODO Auto-generated constructor stub
	}
	public int getMunicion() {
		return Municion;
	}
	public void setMunicion(int municion) {
		Municion = municion;
	}
	public double ModificarPos(int horizontal) {
		System.out.println("Indicar si el avion debe avanzar o retroceder");
		System.out.println("1. Avanzar \n0. Retroceder");
		horizontal = valor.nextInt();
		if (horizontal==1) {
			Posicion = Posicion+2;
		}
		else if (horizontal==0) {
			Posicion = Posicion-2;
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
			Alçada = Alçada+2;
		}
		else {
			Alçada = Alçada-2;
		}
		return Alçada;
	}
	public int atacar() {
		Municion = Municion-1;
		return Municion;
	}
	public void imprimir() {
		System.out.println(this.Matricula + " " + this.Alçada + " " + this.Posicion);
		System.out.println("Municion restante: " + this.Municion);
	}
}

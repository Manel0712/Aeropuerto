import java.util.Scanner;
public class Aeropuerto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Avion aviones[] = new Avion[10];
		Scanner valor = new Scanner(System.in);
		int tipo = 0;
		int c = 0;
		int c2 = 0;
		int c3 = 0;
		int horizontal = 0;
		boolean vertical = true;
		boolean acabar = false;
		do {
			System.out.println("Elige una opcion: ");
			System.out.println("1. Añadir avion \n2. Mover avion \n3. Atacar \n4. Salir");
			int opcion = valor.nextInt();
			switch (opcion) {
				case 1:
					if (c<10) {
						System.out.println("Introduce el tipo de avion que quieres crear");
						System.out.println("1. Avion Normal\n2. Avion de Combate");
						tipo = valor.nextInt();
						if (tipo==1) {
							System.out.println("Indica la Matricula");
							String Matricula = valor.next();
							System.out.println("Indica la Autonomia");
							String Autonomia = valor.next();
							double Alçada = 0;
							System.out.println("Indica la Capacitat");
							String Capacitat = valor.next();
							double Posicion = 0;
							Avion nuevo = new Avion(Matricula, Autonomia, Alçada, Capacitat, Posicion);
							aviones[c] = nuevo;
						}
						else if (tipo==2) {
							System.out.println("Indica la Matricula");
							String Matricula = valor.next();
							System.out.println("Indica la Autonomia");
							String Autonomia = valor.next();
							double Alçada = 0;
							System.out.println("Indica la Capacitat");
							String Capacitat = valor.next();
							double Posicion = 0;
							System.out.println("Indica la Municion");
							int Municion = valor.nextInt();
							Avion_Combate nuevo = new Avion_Combate(Matricula, Autonomia, Alçada, Capacitat, Posicion, Municion);
							aviones[c] = nuevo;
						}
						c++;
					}
					else {
						System.out.println("Aeropuerto lleno");
					}
					break;
				case 2:
					System.out.println("Selecciona el avion");
					c2 = valor.nextInt();
					System.out.println("¿Que quieres modificar?");
					System.out.println("1. Posicion X \n2. Altura");
					c3 = valor.nextInt();
					if (c3==1) {
						if (aviones[c2] instanceof Avion_Combate) {
							Avion_Combate nuevo = (Avion_Combate)aviones[c2];
							aviones[c2].Posicion = nuevo.ModificarPos(horizontal);
						}
						else {
							Avion nuevo = aviones[c2];
							aviones[c2].Posicion = nuevo.ModificarPos(horizontal);
						}
					}
					else if (c3==2) {
						if (aviones[c2] instanceof Avion_Combate) {
							Avion_Combate nuevo = (Avion_Combate)aviones[c2];
							aviones[c2].Alçada = nuevo.ModificarAlt(vertical);
						}
						else {
							Avion nuevo = aviones[c2];
							aviones[c2].Alçada = nuevo.ModificarAlt(vertical);
						}
					}
					else {
						System.out.println("Valor no valido");
					}
					break;
				case 3:
					System.out.println("Selecciona el avion");
					c2 = valor.nextInt();
					if (aviones[c2] instanceof Avion_Combate) {
						System.out.println("Selecciona el avion que quieres atacar");
						c3 = valor.nextInt();
						if (aviones[c3] instanceof Avion_Combate) {
							if (Math.abs(aviones[c3].getPosicion()-aviones[c2].getPosicion())<4&&Math.abs(aviones[c3].getAlçada()-aviones[c2].getAlçada())<4) {
								((Avion_Combate)aviones[c2]).atacar();
								aviones[c3] = null;
							}
							else {
								System.out.println("Avion inalcanzable");
							}
						}
						else {
							System.out.println("No se puede atacar porque no es un avion de combate");
						}
					}
					else {
						System.out.println("Este avion no puede atacar");
					}
					break;
				case 4:
					for (int i=0;i<c;i++) {
						if (aviones[i]!=null) {
							aviones[i].imprimir();
							for (int i2=0;i2<c;i2++) {
								if (aviones[i]!=null) {
									if (aviones[i2].getPosicion()==aviones[i].getPosicion()||aviones[i2].getAlçada()==aviones[i].getAlçada()) {
										System.out.println("Peligro\nEl avion " + aviones[i] + " esta en la misma posicion y/o altura que el avion " + aviones[i2]);
									}
								}
							}
						}
					}
					acabar = true;
					break;
				default:
					System.out.println("Valor no valido");
			}
		}
		while (!acabar);
	}
}

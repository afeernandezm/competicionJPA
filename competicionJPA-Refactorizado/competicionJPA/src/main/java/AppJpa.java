
public class AppJpa {

	public static void main(String[] args) {

		int opcion;

		do {
			System.out.println("Menú:");
			System.out.println("==========================");
			System.out.println("1. Insertar puntuacion");
			System.out.println("2. Revisar clasificacion");
			System.out.println("3. Modificar atleta");
			System.out.println("4. Eliminar atleta");
			System.out.println("5. Salir");
			System.out.println("==========================");
			System.out.print("Seleccione una opción: ");
			System.out.println("");
			System.out.println("");

			opcion = Integer.parseInt(Utilidades.s.nextLine());

			switch (opcion) {
			case 1:
				System.out.println("Has seleccionado la opción 1\n");
				Utilidades.insertarAtleta();
				break;

			case 2:
				int opcion2;
				do {
					System.out.println("==========================");
					System.out.println("1. Filtrar por genero femenino");
					System.out.println("2. Filtrar por genero masculino");
					System.out.println("3. Filtrar por Master masculino");
					System.out.println("4. Filtrar por Master femenino");
					System.out.println("5. Mostrar todo");
					System.out.println("6. Salir");
					System.out.println("==========================");
					System.out.print("Seleccione una opción: ");
					opcion2 = Integer.parseInt(Utilidades.s.nextLine());
					switch (opcion2) {
					case 1:
						Utilidades.filtraPorMujer();
						break;
					case 2:
						Utilidades.filtraPorHombre();
						break;
					case 3:
						Utilidades.filtraPorHombreMaster();
						break;
					case 4:
						Utilidades.filtraPorMujerMaster();
						break;
					case 5:
						Utilidades.muestraAtletasEnOrdenPorTotal();
						break;
					case 6:
						System.out.println("Saliendo...");
						break;
					default:
						break;
					}
				} while (opcion != 6);
				break;
			case 3:
				System.out.println("Has seleccionado la opción 3\n");
				Utilidades.modificarAtletaPorId();
				break;
			case 4:
				System.out.println("Has seleccionado la opción 4\n");
				Utilidades.eliminarAtletaPorId();
				System.out.print("\nAtleta borrado con éxito ");
				break;
			case 5:
				System.out.println("Saliendo");
				break;
			default:
				System.out.println("Opción inválida");
				break;
			}
		} while (opcion != 5);
	}

}

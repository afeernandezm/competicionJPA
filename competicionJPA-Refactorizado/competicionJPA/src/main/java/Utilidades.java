import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Atleta;

public class Utilidades {
	static EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	static Atleta atleta = new Atleta();

	static Scanner s = new Scanner(System.in);

	static String nombreCompleto;
	static String genero;
	static int edad;
	static int benchPress;
	static int deadLift;
	static int squat;
	static int total;
	static int idAtletaBorrar;
	static int idAtletaModificar;

	public static void insertarAtleta() {
		System.out.print("Nombre del atleta: ");
		nombreCompleto = (s.nextLine());

		System.out.print("\nEdad: ");
		edad = Integer.parseInt(s.nextLine());

		System.out.print("\nGenero: ");
		genero = (s.nextLine());

		System.out.print("\nPress: ");
		benchPress = Integer.parseInt(s.nextLine());

		System.out.print("\nPeso muerto: ");
		deadLift = Integer.parseInt(s.nextLine());

		System.out.print("\nSentadilla: ");
		squat = Integer.parseInt(s.nextLine());

		total = (benchPress + deadLift + squat);
		System.out.print("\nTotal: " + total);
		entity.getTransaction().begin();
		atleta.setFullName(nombreCompleto);
		atleta.setAge(edad);
		atleta.setGenre(genero);
		atleta.setBenchPress(benchPress);
		atleta.setDeadlift(deadLift);
		atleta.setSquat(squat);
		atleta.setTotal(total);

		entity.persist(atleta);
		entity.getTransaction().commit();
		System.out.println("\nInsertado con éxito");
	}

	public static void filtraPorMujer() {
		entity.getTransaction().begin();
		Query query = entity.createQuery(
				"SELECT a FROM Atleta a WHERE lower(genre)=lower('femenino') ORDER BY a.total DESC", Atleta.class);

		List<Atleta> listaAtleta = query.getResultList();
		System.out.println("================\n");
		for (Atleta a : listaAtleta) {
			System.out.println(a);
		}
		System.out.println("================\n");
		entity.getTransaction().commit();
	}

	public static void filtraPorHombre() {
		entity.getTransaction().begin();
		Query query2 = entity.createQuery(
				"SELECT a FROM Atleta a WHERE lower(genre)=lower('masculino') ORDER BY a.total DESC", Atleta.class);

		List<Atleta> listaAtleta2 = query2.getResultList();
		System.out.println("================\n");
		for (Atleta a : listaAtleta2) {
			System.out.println(a);
		}
		System.out.println("================\n");
		entity.getTransaction().commit();
	}

	public static void filtraPorHombreMaster() {
		entity.getTransaction().begin();
		Query query3 = entity.createQuery(
				"SELECT a FROM Atleta a WHERE lower(genre)=lower('masculino') AND age>32 ORDER BY a.total DESC",
				Atleta.class);

		List<Atleta> listaAtleta3 = query3.getResultList();
		System.out.println("================\n");
		for (Atleta a : listaAtleta3) {
			System.out.println(a);
		}
		System.out.println("================\n");
		entity.getTransaction().commit();
	}

	public static void filtraPorMujerMaster() {
		entity.getTransaction().begin();
		Query query4 = entity.createQuery(
				"SELECT a FROM Atleta a WHERE lower(genre)=lower('femenino') AND age>32 ORDER BY a.total DESC",
				Atleta.class);

		List<Atleta> listaAtleta4 = query4.getResultList();
		System.out.println("================\n");
		for (Atleta a : listaAtleta4) {
			System.out.println(a);
		}
		System.out.println("================\n");
		entity.getTransaction().commit();
	}

	public static void muestraAtletasEnOrdenPorTotal() {
		entity.getTransaction().begin();
		Query query5 = entity.createQuery("SELECT a FROM Atleta a ORDER BY a.total DESC", Atleta.class);

		List<Atleta> listaAtleta5 = query5.getResultList();
		System.out.println("================\n");
		for (Atleta a : listaAtleta5) {
			System.out.println(a);
		}
		System.out.println("================\n");
		entity.getTransaction().commit();
	}

	public static void modificarAtletaPorId() {
		entity.getTransaction().begin();
		Query query3 = entity.createQuery("SELECT a FROM Atleta a", Atleta.class);

		List<Atleta> listaAtleta3 = query3.getResultList();
		entity.getTransaction().commit();
		System.out.println("Datos atletas: \n");
		entity.getTransaction().begin();
		System.out.println("================\n");
		for (Atleta a : listaAtleta3) {
			System.out.println(a);
		}
		System.out.println("================\n");
		entity.getTransaction().commit();

		entity.getTransaction().begin();
		System.out.print("\nInserta el id del atleta a modificar: ");

		idAtletaModificar = Integer.parseInt(s.nextLine());
		Atleta atleta2 = entity.find(Atleta.class, idAtletaModificar);
		System.out.print("\nInserta el nuevo press: ");
		benchPress = Integer.parseInt(s.nextLine());
		System.out.print("\nInserta el nuevo Peso muerto: ");
		deadLift = Integer.parseInt(s.nextLine());

		System.out.print("\nInserta la nueva Sentadilla: ");
		squat = Integer.parseInt(s.nextLine());

		total = (benchPress + deadLift + squat);
		System.out.print("\nTotal: " + total + "\n");

		atleta2.setBenchPress(benchPress);
		atleta2.setDeadlift(deadLift);
		atleta2.setSquat(squat);
		atleta2.setTotal(total);

		entity.merge(atleta2);
		entity.getTransaction().commit();

		entity.getTransaction().begin();
		System.out.println("================\n");
		for (Atleta a : listaAtleta3) {
			System.out.println(a);
		}
		System.out.println("================\n");
		entity.getTransaction().commit();
	}

	public static void eliminarAtletaPorId() {
		entity.getTransaction().begin();
		Query query2 = entity.createQuery("SELECT a FROM Atleta a", Atleta.class);

		List<Atleta> listaAtleta2 = query2.getResultList();
		entity.getTransaction().commit();
		System.out.println("Atletas disponibles: \n");
		entity.getTransaction().begin();
		System.out.println("================\n");
		for (Atleta a : listaAtleta2) {
			System.out.println(a);
		}
		System.out.println("================\n");
		entity.getTransaction().commit();
		System.out.print("\nInserta el id del atleta a eliminar: ");

		idAtletaBorrar = Integer.parseInt(s.nextLine());
		entity.getTransaction().begin();
		Atleta atletaBorrar = entity.find(Atleta.class, idAtletaBorrar);
		entity.remove(atletaBorrar);
		entity.getTransaction().commit();
	}
	
}

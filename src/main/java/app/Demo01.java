package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {

	public static void main(String[] args) {
		
		// Agregar un nuevo usuario
		Usuario u = new Usuario();
		u.setCodigo(10);
		u.setNombre("Eren");
		u.setApellido("Yeager");
		u.setUsuario("eren@mail.com");
		u.setClave("tatakae");
		u.setFchnacim("2000/01/01");
		u.setTipo(1);
		u.setEstado(1);
		
		// Proceso de registro
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		em.getTransaction().begin();
		try {
			
			em.persist(u); //registrar
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.err.println("Error al registrar usuario..." + e.getMessage());
			//em.getTransaction().rollback();
		}
		em.close();
		System.out.println("Terminó...");
	}

}

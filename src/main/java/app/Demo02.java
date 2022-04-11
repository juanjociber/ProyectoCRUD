package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {

	public static void main(String[] args) {
		
		// Agregar un nuevo usuario a modificar
		Usuario u = new Usuario();
		u.setCodigo(13);
		u.setNombre("Carla");
		u.setApellido("Toro");
		u.setUsuario("U013@gmail.com");
		u.setClave("10002");
		u.setFchnacim("2022/03/21");
		u.setTipo(2);
		u.setEstado(1);
		
		// Proceso de actualizacion
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		em.getTransaction().begin();
		try {
			
			em.merge(u); // si id, existe actualiza el usuario, sino agrega el usuario
			
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.err.println("Error al actualizar usuario..." + e.getMessage());
			//em.getTransaction().rollback();
		}
		em.close();
		System.out.println("Terminó...");
	}

}

package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo05 {
	public static void main(String[] args) {
		//	versi�n mejorada del metodo eliminar
		//	fabrica --> DAO
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		//	Manejador de Entidades
		EntityManager em = fabrica.createEntityManager();
		//	empieza el proceso --> reg, act o elim
		em.getTransaction().begin();
		
		//	proceso de eliminaci�n
		//	select ... where id ...
		Usuario u = em.find(Usuario.class, 13);
		//	devuelve un obj de Entidad, si encuentra el ID, sino devuelve null
		if(u==null)
			System.err.println("Usuario NO existe!!!");
		else
			em.remove(u);
		
		//	confirmaci�n
		em.getTransaction().commit();
		//	cierre
		em.close();
	}
}

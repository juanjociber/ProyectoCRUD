package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo04 {
	public static void main(String[] args) {
		//Obj >>> encontrar y devolver los datos de un Usuario, según su código.
		
					//	fabrica --> DAO
					EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
					//	Manejador de Entidades
					EntityManager em = fabrica.createEntityManager();
					//	empieza el proceso	--> En Búsqueda --> em.getTransaction().begin();
					
					//	select ... where id ...
					Usuario u = em.find(Usuario.class, 1);
					//	devuelve un obj de Entidad, si encuentra el ID, sino devuelve null
					if(u==null)
						System.err.println("Usuario NO existe!!!");
					else
						System.out.println(u);
					//	cierre
					em.close();
	}
}

package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo06 {
	public static void main(String[] args) {
			//	Obj >>> Listado de todos los usuarios
		
			//	fabrica --> DAO
			EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
			EntityManager em = fabrica.createEntityManager();
			
			//	select * from tb_usuarios  ----------->  select u.* from tb_usuarios u
			TypedQuery<Usuario> consulta = em.createQuery("select u from Usuario u", Usuario.class);
			//	-- establecer parámetros
			List<Usuario> lstUsuarios = consulta.getResultList();
			
			/* List<Usuario> lstUsuarios = 
							em.createQuery("select u from Usuario u", Usuario.class).getResultList(); */
			
			for (Usuario u : lstUsuarios) {
				System.out.println(u);
			}
			
			//	cierre
			em.close();
	}
}

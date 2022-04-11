package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo07 {
	public static void main(String[] args) {
				//	Obj >>> listar los usuario, seg�n el tipo --> uso de par�metros
		
				//	fabrica --> DAO
				EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
				EntityManager em = fabrica.createEntityManager();
				
				//	select * from tb_usuarios where idtipo = ?
				TypedQuery<Usuario> consulta = 
						em.createQuery("select u from Usuario u where u.tipo = :xtipo", Usuario.class);
				//	-- establecer par�metros
				consulta.setParameter("xtipo", 2);
				List<Usuario> lstUsuarios = consulta.getResultList();
				
				
				for (Usuario u : lstUsuarios) {
					System.out.println(u);
				}
				
				//	cierre
				em.close();
	}
}

package org.example.persistencia;

import org.example.logica.Empleado;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class EmpleadoJpaController {

    //Atributo
    private EntityManagerFactory emf = null;

    public EmpleadoJpaController() {
        //Obtener la unidad de persistencia.
        this.emf = Persistence.createEntityManagerFactory("empleadosPU");
    }

    //Getter
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //Métodos para interactuar con la base de datos.

    //Crear registro de empleado.
    public void create(Empleado empleado) {
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(empleado);
        em.getTransaction().commit();
    }


    //Listar registros de empleados.
    public List<Empleado> findEmpleadoEntities() {
        EntityManager em = null;
        em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Empleado.class));
        Query q = em.createQuery(cq);
        return q.getResultList();
    }


    //Actualizar registro de empleado.
    public void edit(Empleado empleado) {
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction().begin();
        em.merge(empleado);
        em.getTransaction().commit();
    }

    //Eliminar registro de empleado por Id.
    public void destroy(int id) {
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction().begin();
        Empleado empleado = em.find(Empleado.class, id);
        em.remove(empleado);
        em.getTransaction().commit();
    }

    //Buscar registro de empleado por id.
    public Empleado findEmpleado(int id) {
        EntityManager em = getEntityManager();
        return em.find(Empleado.class, id);
    }

    //Buscar registro de empleado por cargo.
    public List<Empleado> findEmpleadoCargo(String cargo) {
        EntityManager em = getEntityManager();
        Query q = em.createQuery("SELECT e FROM Empleado e WHERE e.cargo = :cargo");
        q.setParameter("cargo", cargo);
        List<Empleado> empleados = q.getResultList();
        return empleados;
    }


}






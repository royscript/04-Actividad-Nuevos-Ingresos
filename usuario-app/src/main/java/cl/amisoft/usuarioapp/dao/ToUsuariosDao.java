package cl.amisoft.usuarioapp.dao;

import cl.amisoft.usuarioapp.models.ToUsuarios;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ToUsuariosDao {
    @PersistenceContext
    protected EntityManager em;

    public Optional<ToUsuarios> obtenerUsuario(Long ccrUsuario) {
        TypedQuery<ToUsuarios> query = em.createQuery("Select u from ToUsuarios u where u.ccrUsuario = :ccrUsuario", ToUsuarios.class)
                .setParameter("ccrUsuario", ccrUsuario);
        ToUsuarios c = query.getResultList().isEmpty() ? null : query.getResultList().get(0);
        return Optional.ofNullable(c);
    }

    public List<ToUsuarios> listar() {
        return em.createQuery("from ToUsuarios u order by u.ccrUsuario asc", ToUsuarios.class).getResultList();
    }

    @Transactional
    public ToUsuarios agregar(ToUsuarios toUsuarios) {
        em.persist(toUsuarios);
        return toUsuarios;
    }

    @Transactional
    public ToUsuarios eliminar(ToUsuarios toUsuarios) {
        em.remove(toUsuarios);
        return toUsuarios;
    }

    @Transactional
    public ToUsuarios editar(ToUsuarios toUsuarios) {
        em.merge(toUsuarios);
        return toUsuarios;
    }
}

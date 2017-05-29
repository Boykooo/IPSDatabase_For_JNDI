package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public abstract class GenericDao<Entity, PK> {

    @PersistenceContext
    private EntityManager manager;
    private Class<Entity> entityClass;

    public GenericDao(Class<Entity> entityClass) {
        this.entityClass = entityClass;
    }

    protected GenericDao() {
    }

    public Entity findById(PK o) {
        return manager.find(entityClass, o);
    }

    public List<Entity> findAll() {

        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Entity> cq = cb.createQuery(entityClass);

        CriteriaQuery<Entity> all = cq.select(cq.from(entityClass));
        TypedQuery<Entity> allQuery = manager.createQuery(all);

        return allQuery.getResultList();
    }

    public void insert(Entity entity) {
        manager.persist(entity);
    }

    public void update(Entity entity) {
        manager.merge(entity);
    }

    public boolean delete(PK key) {
        Entity entity = findById(key);
        if (entity != null) {
            manager.remove(entity);
            return true;
        }

        return false;
    }
}

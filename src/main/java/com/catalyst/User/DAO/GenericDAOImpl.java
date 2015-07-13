
package com.catalyst.User.DAO;

import java.util.List;
import java.io.Serializable;
import org.hibernate.Criteria;
import java.lang.reflect.Type;
import java.lang.reflect.ParameterizedType;
import org.springframework.stereotype.Repository;

/*
    Generic DAO Implementation Class
    By Using Generic Layers I Can Load A Single Service To Handle Shared Functionality
        Between Entities, Such As listAll().
*/
@Repository("genericDAO")
public abstract class GenericDAOImpl <E, K extends Serializable> extends AbstractDAO implements GenericDAO <E, K>
{
    // Used To Get Name Of Current Class
    protected Class<? extends E> persistentClass;
    
    public GenericDAOImpl()
    {
        Type hType = getClass().getGenericSuperclass();
        ParameterizedType hParamType = (ParameterizedType)hType;
        persistentClass = (Class)hParamType.getActualTypeArguments()[0];
    }

    @Override
    public void addByEntity(E argEntity)
    {
        persist(argEntity); // These Methods Are Defined In AbstractDAO
    }
    
    @Override
    public void updateByEntity(E argEntity)
    {
        update(argEntity); // These Methods Are Defined In AbstractDAO
    }
    
    @Override
    public void deleteByID(int argID)
    {
        E hEntity;
        hEntity = (E)getSession().load(persistentClass, argID);
        if(hEntity != null)
        {
            delete(hEntity); // These Methods Are Defined In AbstractDAO
        }
    }
    
    @Override
    public E findByID(int argID)
    {
        return (E)getSession().load(persistentClass, argID);
    }
    
    @Override
    public List<E> listAll()
    {
        Criteria criteria = getSession().createCriteria(persistentClass); // These Methods Are Defined In AbstractDAO ( getSession() )
        return (List<E>)criteria.list();
    }
}
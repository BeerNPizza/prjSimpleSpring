package com.catalyst.User.DAO;

import java.util.List;
import java.io.Serializable;
import org.hibernate.Criteria;
import java.lang.reflect.Type;
import ma.glasnost.orika.MapperFacade;
import java.lang.reflect.ParameterizedType;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
/*
    Generic DAO Implementation Class
    By Using Generic Layers I Can Load A Single Service To Handle Shared Functionality
        Between Entities, Such As listAll().
*/
@Repository("genericDAO")
public abstract class GenericDAOImpl <E, K extends Serializable> extends AbstractDAO implements GenericDAO <E, K>
{
    @Autowired
    MapperFacade OrikaMapper;
    
    protected Class<? extends E> persistentClass; // Used To Get Name Of Current Class
    
    public GenericDAOImpl()
    {
        Type hType = getClass().getGenericSuperclass();
        ParameterizedType hParamType = (ParameterizedType)hType;
        persistentClass = (Class)hParamType.getActualTypeArguments()[0];
    }

    @Override
    public void addByEntity(E argEntity)
    {
        persist(argEntity);
    }
    
    @Override
    public void updateByEntity(E argEntity)
    {
        update(argEntity);
    }
    
    @Override
    public void deleteByID(int argID)
    {
        E hEntity = (E)getSession().load(persistentClass, argID);
        if(hEntity != null)
        {
            delete(hEntity);
        }
    }
    
    @Override
    public E findByID(int argID) // This Method Is For General Use, It Lazily Loads An Entity With Refrences To Other Data
    {
        return (E)getSession().load(persistentClass, argID);
    }
    
    @Override
    public E findByID_API(int argID) // This Method Is For API Use ONLY [Loads All Refrences To Data]
    {
        return(OrikaMapper.map((E)getSession().load(persistentClass, argID), persistentClass));
    }
    
    @Override
    public List<E> listAll()
    {
        Criteria criteria = getSession().createCriteria(persistentClass);
        return (List<E>)criteria.list();
    }
}
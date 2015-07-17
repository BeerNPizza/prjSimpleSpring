package com.catalyst.User.DAO;

import java.util.List;

/*
    Rather Than Create DAO's For Each Entity That All Do The Same Thing (Methods Below)
    We Can Create A Generic DAO Layer That Can Handle Functionality For Any Entity We
    Pass Into It. This Cuts Down The Number Of Classes And Duplicate Code.
    
    We're Still Gonna Create DAO's For Each Entity But Now Their Methods Will Specific To
    Actions We Can Do With That Entity Type. Common Methods Are Now Stored In The GenericDAO.
*/
public interface GenericDAO <E, K> // E = Entity And K = Key
{
    public List<E> listAll();
    public E findByID(int argID);
    public E findByID_API(int argID);
    public void deleteByID(int argID);
    public void addByEntity(E argEntity);
    public void updateByEntity(E argEntity);
}
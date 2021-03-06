package com.catalyst.User.Service;

import java.util.List;

public interface GenericService<E, K>
{
    public List<E> listAll();
    public E findByID(int argID, boolean isAPI);
    public void deleteByID(int argID);
    public void addByEntity(E argEntity);
    public void updateByEntity(E argEntity);
}
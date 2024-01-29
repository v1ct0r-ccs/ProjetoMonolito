package com.anbruvic.projetomonolito.service.generic;


import com.anbruvic.projetomonolito.dao.generic.IGenericDAO;
import com.anbruvic.projetomonolito.domain.Persistente;
import com.anbruvic.projetomonolito.exceptions.DAOException;
import com.anbruvic.projetomonolito.exceptions.MaisDeUmRegistroException;
import com.anbruvic.projetomonolito.exceptions.TableException;
import com.anbruvic.projetomonolito.exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;

public abstract class GenericService<T extends Persistente, E extends Serializable> implements IGenericService<T,E> {

    protected IGenericDAO<T, E> dao;

    public GenericService(IGenericDAO<T, E> dao) {
        this.dao = dao;
    }

    @Override
    public T cadastrar(T entity) throws DAOException, TipoChaveNaoEncontradaException {
        return this.dao.cadastrar(entity);
    }

    @Override
    public void excluir(T entity) throws DAOException {
        this.dao.excluir(entity);
    }

    @Override
    public T alterar(T entity) throws DAOException, TipoChaveNaoEncontradaException {
        return this.dao.alterar(entity);
    }

    @Override
    public T consultar(E valor) throws DAOException, MaisDeUmRegistroException, TableException {
        return this.dao.consultar(valor);
    }

    @Override
    public Collection<T> buscarTodos() throws DAOException {
        return this.dao.buscarTodos();
    }


}

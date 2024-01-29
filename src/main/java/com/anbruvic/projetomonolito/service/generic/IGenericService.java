package com.anbruvic.projetomonolito.service.generic;


import com.anbruvic.projetomonolito.domain.Persistente;
import com.anbruvic.projetomonolito.exceptions.DAOException;
import com.anbruvic.projetomonolito.exceptions.MaisDeUmRegistroException;
import com.anbruvic.projetomonolito.exceptions.TableException;
import com.anbruvic.projetomonolito.exceptions.TipoChaveNaoEncontradaException;


import java.io.Serializable;
import java.util.Collection;

public interface IGenericService<T extends Persistente, E extends Serializable> {

    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException, TipoChaveNaoEncontradaException;

    public void excluir(T entity) throws DAOException;

    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException, MaisDeUmRegistroException, TableException;

    public Collection<T> buscarTodos() throws DAOException;
}

package com.anbruvic.projetomonolito.service;

import com.anbruvic.projetomonolito.dao.generic.IGenericDAO;
import com.anbruvic.projetomonolito.domain.Venda;
import com.anbruvic.projetomonolito.exceptions.DAOException;
import com.anbruvic.projetomonolito.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaService extends IGenericDAO<Venda, Long> {

    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

    public Venda consultarComCollection(Long id);

}

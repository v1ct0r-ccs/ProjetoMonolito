package com.anbruvic.projetomonolito.service;

import com.anbruvic.projetomonolito.dao.IVendaDAO;
import com.anbruvic.projetomonolito.domain.Venda;
import com.anbruvic.projetomonolito.exceptions.DAOException;
import com.anbruvic.projetomonolito.exceptions.TipoChaveNaoEncontradaException;
import com.anbruvic.projetomonolito.service.generic.GenericService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class VendaService extends GenericService<Venda, Long> implements IVendaService {

    IVendaDAO dao;

    @Inject
    public VendaService(IVendaDAO dao) {
        super(dao);
        this.dao = dao;
    }

    @Override
    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
        venda.setStatus(Venda.Status.CONCLUIDA);
        dao.finalizarVenda(venda);
    }

    @Override
    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
        venda.setStatus(Venda.Status.CANCELADA);
        dao.cancelarVenda(venda);
    }

    @Override
    public Venda consultarComCollection(Long id) {
        return dao.consultarComCollection(id);
    }

    @Override
    public Venda cadastrar(Venda entity) throws DAOException, TipoChaveNaoEncontradaException {
        entity.setStatus(Venda.Status.INICIADA);
        return super.cadastrar(entity);
    }



}

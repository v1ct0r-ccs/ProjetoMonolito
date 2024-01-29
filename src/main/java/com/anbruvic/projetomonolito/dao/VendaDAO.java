package com.anbruvic.projetomonolito.dao;

import com.anbruvic.projetomonolito.dao.generic.GenericDAO;
import com.anbruvic.projetomonolito.domain.Cliente;
import com.anbruvic.projetomonolito.domain.Produto;
import com.anbruvic.projetomonolito.domain.Venda;
import com.anbruvic.projetomonolito.exceptions.DAOException;
import com.anbruvic.projetomonolito.exceptions.TipoChaveNaoEncontradaException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class VendaDAO extends GenericDAO<Venda, Long> implements IVendaDAO {

    public VendaDAO() {
        super(Venda.class);
    }

    @Override
    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
        super.alterar(venda);
    }

    @Override
    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
        super.alterar(venda);
    }

    @Override
    public void excluir(Venda venda)  throws DAOException {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }

    @Override
    public Venda cadastrar(Venda entity) throws TipoChaveNaoEncontradaException, DAOException {
        try {
            entity.getProdutos().forEach(prod -> {
                Produto prodJpa = entityManager.merge(prod.getProduto());
                prod.setProduto(prodJpa);
            });
            Cliente cliente = entityManager.merge(entity.getCliente());
            entity.setCliente(cliente);
            entityManager.persist(entity);
            return entity;
        } catch (Exception e) {
            throw new DAOException("ERRO SALVANDO VENDA ", e);
        }
    }

    @Override
    public Venda consultarComCollection(Long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Venda> query = builder.createQuery(Venda.class);
        Root<Venda> root = query.from(Venda.class);
        root.fetch("cliente");
        root.fetch("produtos");
        query.select(root).where(builder.equal(root.get("id"), id));
        TypedQuery<Venda> tpQuery = entityManager.createQuery(query);
        Venda venda = tpQuery.getSingleResult();
        return venda;
    }
}

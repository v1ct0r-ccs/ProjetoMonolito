package com.anbruvic.projetomonolito.dao;


import com.anbruvic.projetomonolito.dao.generic.GenericDAO;
import com.anbruvic.projetomonolito.domain.Produto;

import jakarta.persistence.TypedQuery;

import java.util.List;

public class ProdutoDAO extends GenericDAO<Produto, String> implements IProdutoDAO {

    public ProdutoDAO() {
        super(Produto.class);
    }

    @Override
    public List<Produto> filtrarProdutos(String query) {
        TypedQuery<Produto> tpQuery =
                this.entityManager.createNamedQuery("Produto.findByNome", this.persistenteClass);
        tpQuery.setParameter("nome", "%" + query + "%");
        return tpQuery.getResultList();
    }

}

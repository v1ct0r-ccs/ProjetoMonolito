package com.anbruvic.projetomonolito.service;

import com.anbruvic.projetomonolito.dao.IProdutoDAO;
import com.anbruvic.projetomonolito.domain.Produto;
import com.anbruvic.projetomonolito.service.generic.GenericService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    private IProdutoDAO produtoDAO;

    @Inject
    public ProdutoService(IProdutoDAO produtoDAO) {
        super(produtoDAO);
        this.produtoDAO = produtoDAO;
    }

    @Override
    public List<Produto> filtrarProdutos(String query) {
        return produtoDAO.filtrarProdutos(query);
    }

}
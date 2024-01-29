package com.anbruvic.projetomonolito.dao;

import com.anbruvic.projetomonolito.dao.generic.IGenericDAO;
import com.anbruvic.projetomonolito.domain.Produto;

import java.util.List;

public interface IProdutoDAO extends IGenericDAO<Produto, String> {

    List<Produto> filtrarProdutos(String query);
}

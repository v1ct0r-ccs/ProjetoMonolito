package com.anbruvic.projetomonolito.service;

import com.anbruvic.projetomonolito.domain.Produto;
import com.anbruvic.projetomonolito.service.generic.IGenericService;

import java.util.List;

public interface IProdutoService extends IGenericService<Produto, String> {

    List<Produto> filtrarProdutos(String query);

}

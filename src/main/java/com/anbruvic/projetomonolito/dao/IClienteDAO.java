package com.anbruvic.projetomonolito.dao;


import com.anbruvic.projetomonolito.dao.generic.IGenericDAO;
import com.anbruvic.projetomonolito.domain.Cliente;

import java.util.List;


public interface IClienteDAO extends IGenericDAO<Cliente, Long> {

    List<Cliente> filtrarClientes(String query);
}

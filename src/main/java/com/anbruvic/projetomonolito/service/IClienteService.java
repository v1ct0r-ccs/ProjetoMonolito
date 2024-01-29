package com.anbruvic.projetomonolito.service;


import com.anbruvic.projetomonolito.domain.Cliente;
import com.anbruvic.projetomonolito.exceptions.DAOException;
import com.anbruvic.projetomonolito.service.generic.IGenericService;

import java.util.List;

public interface IClienteService extends IGenericService<Cliente, Long> {

    Cliente buscarPorCPF(Long cpf) throws DAOException;

    List<Cliente> filtrarClientes(String query);

}

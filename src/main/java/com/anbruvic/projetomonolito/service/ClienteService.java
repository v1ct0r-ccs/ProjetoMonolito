package com.anbruvic.projetomonolito.service;

import com.anbruvic.projetomonolito.dao.IClienteDAO;
import com.anbruvic.projetomonolito.domain.Cliente;
import com.anbruvic.projetomonolito.exceptions.DAOException;
import com.anbruvic.projetomonolito.exceptions.MaisDeUmRegistroException;
import com.anbruvic.projetomonolito.exceptions.TableException;
import com.anbruvic.projetomonolito.service.generic.GenericService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

    private IClienteDAO clienteDAO;

    @Inject
    public ClienteService(IClienteDAO clienteDAO) {
        super(clienteDAO);
        this.clienteDAO = clienteDAO;
    }

    @Override
    public Cliente buscarPorCPF(Long cpf) throws DAOException {
        try {
            return this.dao.consultar(cpf);
        } catch (MaisDeUmRegistroException | TableException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Cliente> filtrarClientes(String query) {
        return clienteDAO.filtrarClientes(query);
    }

}

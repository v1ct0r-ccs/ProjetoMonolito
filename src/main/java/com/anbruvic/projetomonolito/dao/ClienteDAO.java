package com.anbruvic.projetomonolito.dao;


import com.anbruvic.projetomonolito.dao.generic.GenericDAO;
import com.anbruvic.projetomonolito.domain.Cliente;

import jakarta.persistence.TypedQuery;

import java.util.List;

public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {

    public ClienteDAO() {
        super(Cliente.class);
    }

    @Override
    public List<Cliente> filtrarClientes(String query) {
        TypedQuery<Cliente> tpQuery =
                this.entityManager.createNamedQuery("Cliente.findByNome", this.persistenteClass);
        tpQuery.setParameter("nome", "%" + query + "%");
        return tpQuery.getResultList();

    }

}
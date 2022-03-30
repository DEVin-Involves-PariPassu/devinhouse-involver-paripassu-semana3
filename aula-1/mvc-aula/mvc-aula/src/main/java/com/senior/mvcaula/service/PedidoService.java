package com.senior.mvcaula.service;

import com.senior.mvcaula.model.Pedido;
import com.senior.mvcaula.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    private PedidoRepository repository;

    public PedidoService(PedidoRepository repository){
        this.repository = repository;
    }

    public List<Pedido> listaPedido(){
        return repository.findAll();
    }

    public Pedido adicionaPedido(Pedido pedido){
        return repository.save(pedido);
    }
}

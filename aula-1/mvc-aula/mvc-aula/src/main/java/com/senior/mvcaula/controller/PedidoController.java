package com.senior.mvcaula.controller;

import com.senior.mvcaula.controller.dto.NovoPedidoDto;
import com.senior.mvcaula.model.Pedido;
import com.senior.mvcaula.service.PedidoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    private PedidoService service;

    public PedidoController(PedidoService service){
        this.service = service;
    }

    @GetMapping
    public String listaPedidos(Model model){
        List<Pedido> pedidos = service.listaPedido();
        model.addAttribute("pedidos", pedidos);
        return "pedido";
    }

    @GetMapping("/formulario")
    public String formulario(NovoPedidoDto novoPedidoDto){
        return "pedido/formulario";
    }

    @PostMapping("/novo")
    public String novoPedido(@Valid NovoPedidoDto pedidoDto, BindingResult result){
        if (result.hasErrors())
            return "pedido/formulario";
        service.adicionaPedido(pedidoDto.converter());
        return "redirect:/pedido";
    }
}

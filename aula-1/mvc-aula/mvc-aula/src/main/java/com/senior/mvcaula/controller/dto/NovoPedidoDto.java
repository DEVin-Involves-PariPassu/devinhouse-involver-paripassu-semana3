package com.senior.mvcaula.controller.dto;

import com.senior.mvcaula.model.Pedido;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class NovoPedidoDto {

    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty
    private String descricao;
    @NotNull @NotEmpty
    private String valor;
    @org.hibernate.validator.constraints.br.CPF
    private String cpf;

    public Pedido converter(){
        Pedido pedido = new Pedido();
        pedido.setNome(nome);
        pedido.setDescricao(descricao);
        pedido.setValor(Double.parseDouble(valor));
        pedido.setDataPedido(LocalDate.now());
        return pedido;
    }
}

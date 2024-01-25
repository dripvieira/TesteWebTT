package com.titansoftware.steps.comprasSteps;

import com.titansoftware.funcs.comprasFuncs.PedidoDeComprasItemAItemFunc;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class PedidoDeComprasItemAItemStep {
    PedidoDeComprasItemAItemFunc pedidosDeComprasItemAItemFunc = new PedidoDeComprasItemAItemFunc();

    @E("registrar novo pedido")
    public void RegistrarNovoPedido(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> usuario = dataTable.asMaps();
        String codigoProdutoPedido = usuario.get(0).get("Codigo_produto_pedido");
        String quantidadeProdutoPedido = usuario.get(0).get("Quantidade_produto_pedido");
        pedidosDeComprasItemAItemFunc.InserirDadosPedido(codigoProdutoPedido, quantidadeProdutoPedido);

    }

    @E("confirmar o registro")
    public void registraPedidoDeCompras() {
        pedidosDeComprasItemAItemFunc.registraPedidoDeCompras();


    }

    @Então("deve visualizar a mensagem {string}")
    public void vizualizarPedidoDeCompra(String msg) {
        Assert.assertEquals(msg, pedidosDeComprasItemAItemFunc.vizualizarPedidoDeCompras());
    }

}

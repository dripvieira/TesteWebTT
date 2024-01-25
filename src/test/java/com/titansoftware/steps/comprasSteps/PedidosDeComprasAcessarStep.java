package com.titansoftware.steps.comprasSteps;

import com.titansoftware.funcs.comprasFuncs.PedidoDeComprasAcessarFunc;
import io.cucumber.java.pt.Quando;

public class PedidosDeComprasAcessarStep {

    PedidoDeComprasAcessarFunc pedidoDeComprasAssercaoFunc = new PedidoDeComprasAcessarFunc();

    @Quando("estiver na página de incluir pedido de compras")
    public void paginaPedidoDeCompra() throws InterruptedException {
        pedidoDeComprasAssercaoFunc.incluirNovoPedido();

    }


}

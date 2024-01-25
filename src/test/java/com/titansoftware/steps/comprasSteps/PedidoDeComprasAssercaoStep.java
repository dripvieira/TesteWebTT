package com.titansoftware.steps.comprasSteps;

import com.titansoftware.funcs.comprasFuncs.ModuloComprasAcessosFuncs;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import org.junit.Assert;

public class PedidoDeComprasAssercaoStep {
    ModuloComprasAcessosFuncs moduloComprasAcessosFuncs = new ModuloComprasAcessosFuncs();

    @Então("deve visualizar o status de pedido {string}")
    public void assercaoPedidoDeCompras(String msg) throws InterruptedException {
        moduloComprasAcessosFuncs.acessarModuloCompras();
        moduloComprasAcessosFuncs.acessarMenuCompras();
        moduloComprasAcessosFuncs.AcessarSubMenuPedidoDeCompras();
        moduloComprasAcessosFuncs.filtrarPedido();
        Assert.assertEquals(msg, moduloComprasAcessosFuncs.assercaoPedidoDeCompras());
    }

    @E("deve visualizar o status no meio do processo de pedido {string}")
    public void assercaoPedidoDeComprasMeio(String msg) throws InterruptedException {
        moduloComprasAcessosFuncs.acessarModuloCompras();
        moduloComprasAcessosFuncs.acessarMenuCompras();
        moduloComprasAcessosFuncs.AcessarSubMenuPedidoDeCompras();
        moduloComprasAcessosFuncs.filtrarPedido();
        Assert.assertEquals(msg, moduloComprasAcessosFuncs.assercaoPedidoDeCompras());
    }
}

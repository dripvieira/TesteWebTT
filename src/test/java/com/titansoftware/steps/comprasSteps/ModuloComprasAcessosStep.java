package com.titansoftware.steps.comprasSteps;

import com.titansoftware.funcs.comprasFuncs.ModuloComprasAcessosFuncs;
import io.cucumber.java.pt.E;

public class ModuloComprasAcessosStep {
    ModuloComprasAcessosFuncs moduloComprasAcessosFuncs = new ModuloComprasAcessosFuncs();


    @E("acessar a página pedido de compras")
    public void acessarPedidoDeCompras() throws InterruptedException {
        moduloComprasAcessosFuncs.acessarModuloCompras();
        moduloComprasAcessosFuncs.acessarMenuCompras();
        moduloComprasAcessosFuncs.AcessarSubMenuPedidoDeCompras();
    }
}

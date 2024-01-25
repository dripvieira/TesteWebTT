package com.titansoftware.funcs.comprasFuncs;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.pages.comprasPages.PedidoDeComprasAcessarPage;
import org.openqa.selenium.JavascriptExecutor;

public class PedidoDeComprasAcessarFunc extends BaseTeste {

    PedidoDeComprasAcessarPage pedidoDeComprasAssercaoPage = new PedidoDeComprasAcessarPage();

    /**
     * Acessa a página de inclusão de novo pedido
     *
     * @throws InterruptedException aplicação não possui elementos com parâmetros passiveis de serem utilizados para esperas aninhadas
     */
    public void incluirNovoPedido() {
        driver.findElement(pedidoDeComprasAssercaoPage.getIncluirNovoPedido()).click();
        driver.findElement(pedidoDeComprasAssercaoPage.getTipoDePedido()).click();
    }
}

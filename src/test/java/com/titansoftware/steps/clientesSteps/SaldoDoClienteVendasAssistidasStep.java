package com.titansoftware.steps.clientesSteps;

import com.titansoftware.funcs.clientesFuncs.ModuloClientesAcessosFunc;
import com.titansoftware.funcs.clientesFuncs.SaldoDoClienteVendasAssistidasFunc;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;

public class SaldoDoClienteVendasAssistidasStep {


    SaldoDoClienteVendasAssistidasFunc saldoDoClienteVendasAssistidasFunc = new SaldoDoClienteVendasAssistidasFunc();
    ModuloClientesAcessosFunc moduloClientesAcessosFunc = new ModuloClientesAcessosFunc();

    @E("visualizar saldo inicial do cliente")
    public void saldoInicial() throws InterruptedException {
        moduloClientesAcessosFunc.acessarModuloClientes();
        moduloClientesAcessosFunc.acessarMenuCliente();
        moduloClientesAcessosFunc.acessarSubMenuCliente();
        saldoDoClienteVendasAssistidasFunc.ResgatarSaldoInicial();
    }

    @E("visualizar saldo pos Venda")
    public void saldoPosVenda() throws InterruptedException {
        moduloClientesAcessosFunc.acessarModuloClientes();
        moduloClientesAcessosFunc.acessarMenuCliente();
        moduloClientesAcessosFunc.acessarSubMenuCliente();
        saldoDoClienteVendasAssistidasFunc.ResgatarSaldoPosVenda();
    }


    @E("entrar na página manutenção de clientes")
    public void saldoPosBaixa() throws InterruptedException {
        moduloClientesAcessosFunc.acessarModuloClientes();
        moduloClientesAcessosFunc.acessarMenuCliente();
        moduloClientesAcessosFunc.acessarSubMenuCliente();
        saldoDoClienteVendasAssistidasFunc.ResgatarSaldoPosBaixa();
    }

    @Então("deve visualizar valor do saldo final do cliente!")
    public void resgatarSaldo() {
        saldoDoClienteVendasAssistidasFunc.AssercaoSaldos();
    }
}

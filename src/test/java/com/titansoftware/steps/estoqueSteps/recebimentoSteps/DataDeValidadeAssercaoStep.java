package com.titansoftware.steps.estoqueSteps.recebimentoSteps;

import com.titansoftware.funcs.EstoqueFuncs.ModuloEstoqueAcessosFunc;
import com.titansoftware.funcs.EstoqueFuncs.RecebimentoFuncs.NotaFiscalFuncs.DataDeValidadeAssercaoFunc;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Então;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class DataDeValidadeAssercaoStep {

    DataDeValidadeAssercaoFunc dataDeValidadeAssercaoFunc = new DataDeValidadeAssercaoFunc();
    ModuloEstoqueAcessosFunc moduloEstoqueAcessosFunc = new ModuloEstoqueAcessosFunc();

    @Então("deve visualizar a data de vencimento!")
    public void dataDeValidade(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> usuario = dataTable.asMaps();
        String validadeRomaneio = usuario.get(0).get("Validade_Romaneio");
        moduloEstoqueAcessosFunc.acessarModuloEstoque();
        moduloEstoqueAcessosFunc.acessarMenuRecebimento();
        moduloEstoqueAcessosFunc.acessarSubMenuNotaFiscal2();
        dataDeValidadeAssercaoFunc.pesquisarNF();
        dataDeValidadeAssercaoFunc.consultarNF();
        dataDeValidadeAssercaoFunc.consultarextratoRomaneio();
        Assert.assertEquals(validadeRomaneio, dataDeValidadeAssercaoFunc.resgatarDataDeValidade());
    }

}

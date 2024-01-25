package com.titansoftware.steps.estoqueSteps.recebimentoSteps;

import com.titansoftware.funcs.EstoqueFuncs.ModuloEstoqueAcessosFunc;
import com.titansoftware.funcs.EstoqueFuncs.RecebimentoFuncs.NotaFiscalFuncs.ExclusaoNfFunc;
import com.titansoftware.funcs.fiscal.livrosFiscais.manutencao.AssercaoGravaNFLivroFiscalFunc;
import com.titansoftware.funcs.fiscal.livrosFiscais.manutencao.EntrarModuloFiscalFunc;
import com.titansoftware.funcs.fiscal.livrosFiscais.manutencao.ExclusaoLivroFiscalFunc;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;

public class ConsultarNfRecebimentoStep {

    ExclusaoNfFunc exclusaoNfFunc = new ExclusaoNfFunc();
    ExclusaoLivroFiscalFunc exclusaoLivroFiscal = new ExclusaoLivroFiscalFunc();

    AssercaoGravaNFLivroFiscalFunc assercaoGravaNFLivroFiscalFunc = new AssercaoGravaNFLivroFiscalFunc();
    EntrarModuloFiscalFunc entrarModuloFiscalFunc = new EntrarModuloFiscalFunc();
    ModuloEstoqueAcessosFunc moduloEstoqueAcessosFunc = new ModuloEstoqueAcessosFunc();

    @E("resgatar status no meio do processo")
    public void numeroNF() throws InterruptedException {
        entrarModuloFiscalFunc.acessarModuloFiscal();
        entrarModuloFiscalFunc.acessarMenuLivroFiscal();
        entrarModuloFiscalFunc.acessarSubMenuManutencaoLivroFiscal();
        assercaoGravaNFLivroFiscalFunc.acessarManutencaoLivroFiscal();
        assercaoGravaNFLivroFiscalFunc.assercaoStatusMeio();
    }

    @E("consultar NF no recebimento")
    public void consultarNf() throws InterruptedException {
        moduloEstoqueAcessosFunc.acessarModuloEstoque();
        moduloEstoqueAcessosFunc.acessarMenuRecebimento();
        moduloEstoqueAcessosFunc.acessarSubMenuNotaFiscal2();
        exclusaoNfFunc.consultarNfRecebimento();
    }

    @Então("deve visualizar o status Excluído!")
    public void validarStatusLivroFiscal() throws InterruptedException {
        exclusaoNfFunc.assercaoStatus();
    }

    @E("excluir NF no livro fiscal")
    public void excluirLivroFiscal() throws InterruptedException {
        entrarModuloFiscalFunc.acessarModuloFiscal();
        entrarModuloFiscalFunc.acessarMenuLivroFiscal();
        entrarModuloFiscalFunc.acessarSubMenuManutencaoLivroFiscal();
        exclusaoLivroFiscal.excluirLivroFiscal();
    }
}

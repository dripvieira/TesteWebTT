#language: pt
# encoding: UTF-8
# author: Adriano Vieira
# Date: 13/06/2023
# version: 1.0

Funcionalidade: Asserção custo bruto de um produto

  Com essa funcionalidade iremos conseguir cadastrar uma Nota Fiscal validar o custo bruto de um produto.

  Como um usuário logado na aplicação
  Eu quero inserir os dados da Nota fiscal e consultar o custo bruto do produto
  Para validar o registro do custo bruto

  Contexto:
    Dado estiver na tela de login
    E inserir os dados do usuário
      | login | senha      |
      | adm   | tit@n_2006 |
    E coletar o custo bruto do produto

  @Smoke_test @EntradaDeNF+CustoBruto @Recebimento
  Esquema do Cenário: Validar custo bruto de produto

    Quando estiver na tela de Gerenciamento de Notas Fiscais
    E inserir os dados da Nota Fiscal
      | Emitente   | Data   | Natureza_da_Operação   | Número_NF   | Série_NF   | Modelo_Documento_Fiscal   | Chave_NFE   | Valor_Total   | Código_Produto   | Quantidade_produto   | Preço_produto   |
      | <Emitente> | <Data> | <Natureza da Operação> | <Número NF> | <Série NF> | <Modelo Documento Fiscal> | <Chave NFE> | <Valor Total> | <Código Produto> | <Quantidade produto> | <Preço produto> |
    E  inserir os dados do romaneio
      | Quantidade_Romaneio   | Validade_Romaneio   |
      | <Quantidade Romaneio> | <Validade Romaneio> |
    E criticar a entrada de NF
    E validar a entrada de NF
    Então deve visualizar o custo bruto do produto.

    Exemplos:
      | Emitente | Data     | Natureza da Operação | Número NF | Série NF | Modelo Documento Fiscal | Chave NFE                                    | Valor Total | Código Produto | Quantidade produto | Preço produto | Quantidade Romaneio | Validade Romaneio |
      | 2059     | 23062023 | 3                    |           | 23       | 01                      | 11112222333344445555666677778888999900001111 | 36,00       | 20000          | 3                  | 12,00         | 3                   | 31012024          |



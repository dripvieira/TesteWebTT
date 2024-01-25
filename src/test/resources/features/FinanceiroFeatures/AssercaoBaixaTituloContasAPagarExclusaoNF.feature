#language: pt
# encoding: UTF-8
# author: Caíque W.
# Date: 11/08/2023
# version: 1.0


Funcionalidade: Validar a baixa título no módulo contas à pagar após exclusão de Nota Fiscal
  Com essa funcionalidade iremos conseguir excluir uma NF e fazer a asserção do status título contas à pagar

  Como um usuário logado na aplicação
  Eu quero inserir os dados da Nota fiscal e respectivos produtos
  Para registrar a entrada dos produtos no estoque

  Contexto:
    Dado estiver na tela de login
    E inserir os dados do usuário
      | login | senha      |
      | adm   | tit@n_2006 |

  @Smoke_test @ExclusaoDeNFValidarTituloContasAPagar @Recebimento
  Esquema do Cenário: Validar a baixa título no módulo contas à pagar

    Quando estiver na tela de Gerenciamento de Notas Fiscais
    E inserir os dados da Nota Fiscal
      | Emitente   | Data   | Natureza_da_Operação   | Número_NF   | Série_NF   | Modelo_Documento_Fiscal   | Chave_NFE   | Valor_Total   | Código_Produto   | Quantidade_produto   | Preço_produto   |
      | <Emitente> | <Data> | <Natureza da Operação> | <Número NF> | <Série NF> | <Modelo Documento Fiscal> | <Chave NFE> | <Valor Total> | <Código Produto> | <Quantidade produto> | <Preço produto> |
    E  inserir os dados do romaneio
      | Quantidade_Romaneio   | Validade_Romaneio   |
      | <Quantidade Romaneio> | <Validade Romaneio> |
    E criticar a entrada de NF
    E validar a entrada de NF
    E validar status no meio do processo
    E excluir NF no livro fiscal
    Então validar status na tela contas à pagar

    Exemplos:
      | Emitente | Data     | Natureza da Operação | Número NF | Série NF | Modelo Documento Fiscal | Chave NFE | Valor Total | Código Produto | Quantidade produto | Preço produto | Quantidade Romaneio | Validade Romaneio |
      | 2059     | 23062023 | 3                    |           | 23       | 01                      |           | 36,00       | 20000          | 3                  | 12,00         | 3                   | 31012024          |



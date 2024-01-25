#language: pt
# encoding: UTF-8
# author: Adriano Vieira
# Date: 23/05/2023
# version: 1.0

Funcionalidade: Dar entrada na NF e validar data de vencimento do produto
  Com essa funcionalidade iremos conseguir dar entrada numa NF e validar a data de vencimento do produto

  Como um usuário logado na aplicação
  Eu quero inserir os dados da Nota fiscal e e consultar data de validade
  Para validar a data de vencimento

  Contexto:
    Dado estiver na tela de login
    E inserir os dados do usuário
      | login | senha      |
      | adm   | tit@n_2006 |


  @Smoke_test @DataDeValidade @Recebimento
  Esquema do Cenário: Validar a entrada de NF + Data de vencimento

    Quando estiver na tela de Gerenciamento de Notas Fiscais
    E inserir os dados da Nota Fiscal
      | Emitente   | Data   | Natureza_da_Operação   | Número_NF   | Série_NF   | Modelo_Documento_Fiscal   | Chave_NFE   | Valor_Total   | Código_Produto   | Quantidade_produto   | Preço_produto   |
      | <Emitente> | <Data> | <Natureza da Operação> | <Número NF> | <Série NF> | <Modelo Documento Fiscal> | <Chave NFE> | <Valor Total> | <Código Produto> | <Quantidade produto> | <Preço produto> |
    E  inserir os dados do romaneio
      | Quantidade_Romaneio   | Validade_Romaneio   |
      | <Quantidade Romaneio> | <Validade Romaneio> |
    E criticar a entrada de NF
    E validar a entrada de NF
    Então deve visualizar a data de vencimento!
      | Validade_Romaneio   |
      | <Validade Romaneio> |
    Exemplos:
      | Emitente | Data     | Natureza da Operação | Número NF | Série NF | Modelo Documento Fiscal | Chave NFE                                    | Valor Total | Código Produto | Quantidade produto | Preço produto | Quantidade Romaneio | Validade Romaneio |
      | 2059     | 23062023 | 3                    |           | 23       | 01                      | 11112222333344445555666677778888999900001111 | 36,00       | 20000          | 3                  | 12,00         | 3                   | 31/01/2030        |


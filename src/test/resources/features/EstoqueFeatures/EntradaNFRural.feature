#language: pt
# encoding: UTF-8
# author: Adriano Vieira
# Date: 27/06/2023
# version: 1.0

Funcionalidade: Entrada de NF de produtor Rural
  Com essa funcionalidade iremos conseguir dar entrada numa NF de Produtor Rural e fazer a asserção da geração de contra nota no módulo Faturamento.

  Como um usuário logado na aplicação
  Eu quero dar entrada numa Nota Fiscal Rural
  Para registrar a contra nota no faturamento

  Contexto:
    Dado estiver na tela de login
    E inserir os dados do usuário
      | login | senha      |
      | adm   | tit@n_2006 |

  @Smoke_test @EntradaDeNFRural @Recebimento
  Esquema do Cenário: Dar entrada em uma NF Rural e gerar contra nota no módulo Faturamento

    Quando estiver na tela de Gerenciamento de Notas Fiscais
    E inserir os dados da Nota Fiscal
      | Emitente   | Data   | Natureza_da_Operação   | Número_NF   | Série_NF   | Modelo_Documento_Fiscal   | Chave_NFE   | Valor_Total   | Código_Produto   | Quantidade_produto   | Preço_produto   |
      | <Emitente> | <Data> | <Natureza da Operação> | <Número NF> | <Série NF> | <Modelo Documento Fiscal> | <Chave NFE> | <Valor Total> | <Código Produto> | <Quantidade produto> | <Preço produto> |
    E criticar a entrada de NF
    E validar a entrada de NF
    Então deve visualizar a contra nota no módulo Faturamento com a mensagem "Emitida"
    Exemplos:
      | Emitente | Data     | Natureza da Operação | Número NF | Série NF | Modelo Documento Fiscal | Chave NFE                                    | Valor Total | Código Produto | Quantidade produto | Preço produto | Quantidade Romaneio | Validade Romaneio |
      | 4692     | 23062023 | 2                    |           | 23       | 01                      | 11112222333344445555666677778888999900001111 | 36,00       | 103314         | 3                  | 12,00         | 3                   | 31012024          |



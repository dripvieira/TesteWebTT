#language: pt
# encoding: UTF-8
# author: Adriano Vieira
# Date: 27/06/2023
# version: 1.0

Funcionalidade: Entrada de NF com devolução automática
  Com essa funcionalidade iremos conseguir dar entrada numa NF com devolução automática e fazer a asserção no faturamento.

  Como um usuário logado na aplicação
  Eu dar entrada numa Nota Fiscal Rural
  Para registrar a contra nota no faturamento

  Contexto:
    Dado estiver na tela de login
    E inserir os dados do usuário
      | login | senha      |
      | adm   | tit@n_2006 |

  @Smoke_test @Entrada_de_NF+Devolucao_Automatica @Recebimento
  Esquema do Cenário: Dar entrada em uma NF e gerar devolução automática no faturamento

    Quando estiver na tela de Gerenciamento de Notas Fiscais
    E inserir os dados da Nota Fiscal
      | Emitente   | Data   | Natureza_da_Operação   | Número_NF   | Série_NF   | Modelo_Documento_Fiscal   | Chave_NFE   | Valor_Total   | Código_Produto   | Quantidade_produto   | Preço_produto   |
      | <Emitente> | <Data> | <Natureza da Operação> | <Número NF> | <Série NF> | <Modelo Documento Fiscal> | <Chave NFE> | <Valor Total> | <Código Produto> | <Quantidade produto> | <Preço produto> |
    E  inserir dados incorretos de Romaneio
      | Quantidade_Romaneio   | Validade_Romaneio   |
      | <Quantidade Romaneio> | <Validade Romaneio> |
    E criticar a entrada de NF
    E gerar NF de devolução automatica
    E gerar a nota de devolução automática no faturamento
    E coletar dados da NF
    E acessar a tela de Gerenciamento de Notas Fiscais
    Então validar a devolução autmomatica no recebimento
    Exemplos:
      | Emitente | Data     | Natureza da Operação | Número NF | Série NF | Modelo Documento Fiscal | Chave NFE                                    | Valor Total | Código Produto | Quantidade produto | Preço produto | Quantidade Romaneio | Validade Romaneio |
      | 2059     | 23062023 | 3                    |           | 23       | 01                      | 11112222333344445555666677778888999900001111 | 36,00       | 20000          | 3                  | 12,00         | 2                   | 31012024          |
#    Ao preencher com emitente 1 , valor total não é calculado analisar possível falha ou bug
#      | 1        | 23062023 | 3                    |           | 23       | 01                      | 11112222333344445555666677778888999900001111 | 36,00       | 20000          | 3                  | 12,00         | 2                   | 31012024          |


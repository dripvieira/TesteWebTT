#language: pt
# encoding: UTF-8
# author: Adriano Vieira
# Date: 23/05/2023
# version: 1.0

Funcionalidade: Asserção produtos em estoque
  Com essa funcionalidade iremos conseguir dar entrada numa NF e fazer a asserção da quantidade no estoque

  Como um usuário logado na aplicação
  Eu quero inserir os dados da Nota fiscal e respectivos produtos
  Para registrar a entrada dos produtos no estoque

  Contexto:
    Dado estiver na tela de login
    E inserir os dados do usuário
      | login | senha      |
      | adm   | tit@n_2006 |
    E coletar a quantidade em estoque

  @Smoke_test @EntradaDeNF+Estoque @Recebimento
  Esquema do Cenário: Validar a entrada de NF + Produto
    Quando estiver na tela de Gerenciamento de Notas Fiscais
    E inserir os dados da Nota Fiscal
      | Emitente   | Data   | Natureza_da_Operação   | Número_NF   | Série_NF   | Modelo_Documento_Fiscal   | Chave_NFE   | Valor_Total   | Código_Produto   | Quantidade_produto   | Preço_produto   |
      | <Emitente> | <Data> | <Natureza da Operação> | <Número NF> | <Série NF> | <Modelo Documento Fiscal> | <Chave NFE> | <Valor Total> | <Código Produto> | <Quantidade produto> | <Preço produto> |
    E  inserir os dados do romaneio
      | Quantidade_Romaneio   | Validade_Romaneio   |
      | <Quantidade Romaneio> | <Validade Romaneio> |
    E criticar a entrada de NF
    E validar a entrada de NF
    Então deve visualizar a quantidade em estoque na tela de estoque!
    Exemplos:
      | Emitente | Data     | Natureza da Operação | Número NF | Série NF | Modelo Documento Fiscal | Chave NFE                                    | Valor Total | Código Produto | Quantidade produto | Preço produto | Quantidade Romaneio | Validade Romaneio |
      | 2059     | 23062023 | 3                    |           | 23       | 01                      | 11112222333344445555666677778888999900001111 | 36,00       | 20000          | 5                  | 12,00         | 5                   | 31012024          |


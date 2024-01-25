#language: pt
# encoding: UTF-8
# author: Caíque Walter
# Date: 12/09/2023
# version: 1.0

Funcionalidade: Inserir desconto no produto e realizar a verificação se o desconto foi aplicado corretamente no recebimento
  Com essa funcionalidade conseguiremos dar validar custo de produtos com desconto

  Como um usuário logado na aplicação
  Eu quero inserir os dados da Nota fiscal e respectivos produtos
  Para validar custo do produto descontando porcentagem cadastrada

  Contexto:
    Dado estiver na tela de login
    E inserir os dados do usuário
      | login | senha      |
      | adm   | tit@n_2006 |

    E inserir desconto ao produto
      | Desconto | Produto |
      | 20       | 20000   |

  @Smoke_test @Validar_Custo_Desconto @Recebimento
  Esquema do Cenário: Validar custo total de nota com desconto
    Quando estiver na tela de Gerenciamento de Notas Fiscais
    E inserir os dados da Nota Fiscal
      | Emitente   | Data   | Natureza_da_Operação   | Número_NF   | Série_NF   | Modelo_Documento_Fiscal   | Chave_NFE   | Valor_Total   | Código_Produto   | Quantidade_produto   | Preço_produto   |
      | <Emitente> | <Data> | <Natureza da Operação> | <Número NF> | <Série NF> | <Modelo Documento Fiscal> | <Chave NFE> | <Valor Total> | <Código Produto> | <Quantidade produto> | <Preço produto> |
    Então validar custo total da nota com desconto

    Exemplos:
      | Emitente | Data     | Natureza da Operação | Número NF | Série NF | Modelo Documento Fiscal | Chave NFE | Valor Total | Código Produto | Quantidade produto | Preço produto |
      | 2059     | 23062023 | 3                    |           | 23       | 01                      |           | 36,00       | 20000          | 3                  | 1500          |


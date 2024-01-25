#language: pt
# encoding: UTF-8
# author: Adriano Vieira
# Date: 02/10/2023
# version: 1.0

Funcionalidade: Entrada de NF via importação XML
  Com essa funcionalidade iremos conseguir gerar uma NF XML no faturamento e fazer a importação do XML no recebimento.

  Como um usuário logado na aplicação
  Eu quero gerar uma nota XML no faturamento e realizar a importação no recebimento
  Para registrar a esntrada da NF

  Contexto:
    Dado estiver na tela de login
    E inserir os dados do usuário
      | login | senha      |
      | adm   | tit@n_2006 |

  @Smoke_test @EntradaXML @Recebimento
  Esquema do Cenário: Gerar um NF XML no faturamento e realizar a importação no recebimento

    Quando estiver na tela de emissão de fatura
    E inserir os dados da Nota Fiscal e gerar uma fatura
      | Código   | Produto   | Quantidade   |
      | <Codigo> | <Produto> | <Quantidade> |
    E estiver na tela de importação de Notas Fiscais
    E realizar a importação do XMl
    E  inserir os dados do romaneio
      | Quantidade_Romaneio   | Validade_Romaneio   |
      | <Quantidade Romaneio> | <Validade Romaneio> |
    E criticar a entrada de NF
    E validar a entrada de NF
    Exemplos:
      | Codigo | Produto | Quantidade | Quantidade Romaneio | Validade Romaneio |
      | 381    | 100193  | 9          | 9                   | 31/12/2045        |
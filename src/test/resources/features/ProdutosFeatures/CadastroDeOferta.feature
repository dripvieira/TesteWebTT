#language: pt
# encoding: UTF-8
# author: Adriano Vieira
# Date: 10/11/2023
# version: 1.0

Funcionalidade: cadastrar oferta de produto e gerar carga no PDV
  Com essa funcionalidade iremos conseguir cadastrar uma oferta para um produto e gerar uma carga no PDV

  Como um usuário logado na aplicação
  Eu quero cadastrar uma oferta para um produto
  Para poder gerar uma carga no PDV

  Contexto:
    Dado estiver na tela de login
    E inserir os dados do usuário
      | login | senha      |
      | adm   | tit@n_2006 |

  @Smoke_test @CadastrarOferta @Produtos
  Cenário: Validar o cadastramento de oferta e carga no PDV
    Quando estiver na tela de preço de ofertas
    E inserir os dados da oferta
    E acessar o SubMenuCargaPDV
    E gerar uma carga no PDV
    Então deve visualizar a mensagem "Carga concluída"!!!

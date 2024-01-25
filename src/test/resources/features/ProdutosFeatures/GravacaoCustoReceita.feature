#language: pt
# encoding: UTF-8
# author: Adriano Vieira
# Date: 04/07/2023
# version: 1.0

Funcionalidade: cadastrar e calcular custo da receita de um produto
  Com essa funcionalidade iremos cadastrar a receita de um novo produto utilizando produtos em estoque

  Como um usuário logado na aplicação
  Eu quero cadastrar a receita utilizando produtos em estoque
  Para poder gerar um novo produto

  Contexto:
    Dado estiver na tela de login
    E inserir os dados do usuário
      | login | senha      |
      | adm   | tit@n_2006 |
    E estiver na tela de manutenção de produtos
    E inserir os dados do produto
      | Tipo_PLU | Tipo_Produto       | Descrição_curta | Descrição_comercial | Descrição_tecnica              | Referencia | Classificação_Mercadologica | Fornecedor_principal | Divisão   | Etiqueta | Etiqueta_facing | Mix_de_produtos | Prazo_de_entrega | Volume | Peso_bruto | Peso_liquido |
      | Pesado   | 04-Produto Acabado | <CAFÉ TITAN >   | <CAFÉ TITAN 350 ML> | <CAFÉ TITAN PET CAFEINA 350ML> | 1354       | 01.02.05.005.007            | 1                    | <Divisão> | 5        | 5               | Padrão          | 7                | 350    | 3,5        | 3,45         |

  @Smoke_test @CadastrarReceita @Produtos
  Esquema do Cenário: Gravar o custo de através da geração de uma receita
    Quando estiver na tela de receita de produtos
    E inserir os dados da receita
      | PLU da Receita   | Quantidade   | Caloria   | Carboidrato   | Proteína   | Gordura   | Gorduras Saturadas   | Colesterol   | Fibra Alimentar   | Cálcio   | Ferro   | Sódio   | Gordura Trans   | PLU Café   | Quant Café   | PLU Água   | Quant Água   | PLU Açucar   | Quant Açucar   |
      | <PLU da Receita> | <Quantidade> | <Caloria> | <Carboidrato> | <Proteína> | <Gordura> | <Gorduras Saturadas> | <Colesterol> | <Fibra Alimentar> | <Cálcio> | <Ferro> | <Sódio> | <Gordura Trans> | <PLU Café> | <Quant Café> | <PLU Água> | <Quant Água> | <PLU Açucar> | <Quant Açucar> |

    Então deve visualizar  a receita criada com sucesso!!!

    Exemplos:
      | PLU da Receita | Quantidade | Caloria | Carboidrato | Proteína | Gordura | Gorduras Saturadas | Colesterol | Fibra Alimentar | Cálcio | Ferro | Sódio | Gordura Trans | PLU Café | Quant Café | PLU Água | Quant Água | PLU Açucar | Quant Açucar |
      | 21778          | 100        | 111     | 111         | 111      | 111     | 111                | 111        | 111             | 111    | 111   | 111   | 111           | 101612   | 0,5        | 80       | 1          | 4007       | 0,2          |








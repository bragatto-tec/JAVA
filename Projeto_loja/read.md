# PROJETO MACKSHOP

**Capacitando o Sucesso do Varejo por meio de Inovação perfeita**

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Status](https://img.shields.io/badge/Status-Concluído-success?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)

*Construído com as ferramentas e tecnologias:*

---

## 📋 Tabela de Conteúdo

- [Visão Geral](#-visão-geral)
- [Funcionalidades](#-funcionalidades)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Pré-requisitos](#-pré-requisitos)
- [Instalação](#-instalação)
- [Utilização](#-utilização)
- [Exemplos de Uso](#-exemplos-de-uso)
- [Tecnologias](#-tecnologias)
- [Contribuindo](#-contribuindo)
- [Licença](#-licença)
- [Contato](#-contato)

---

## 🎯 Visão Geral

O **MackShop** é uma ferramenta de desenvolvimento fundamental que fornece as estruturas de dados e a lógica essenciais necessárias para gerenciar informações de estoque, vendas e produtos em um ambiente de varejo. Ele atua como a espinha dorsal para a construção de sistemas abrangentes de gerenciamento de varejo, permitindo o processamento de transações e a geração de relatórios eficientes.

### Porque Projeto-loja?

Este projeto simplifica o desenvolvimento de soluções de gestão de retalho, oferecendo um núcleo sólido para as operações de inventário e vendas. As características principais incluem:

- 🗄️ **Inicialização das Estruturas de Dados**: Configura os componentes fundamentais para o gerenciamento de produtos, níveis de stock e dados de vendas.

- 🛒 **Gestão de Vendas e Estoques**: Facilita atualizações nos níveis de estoque e processa transações de vendas de forma perfeita.

- 📊 **Capacidades Reportadoras**: Suporta análise de dados e acompanhamento histórico de vendas para a tomada de decisões informadas.

- 🔧 **Extensibilidade**: Projetado para servir como uma base flexível para aplicações de varejo personalizadas.

- 🎯 **Núcleo do Sistema Backbone**: Fornece uma base confiável para a construção de ferramentas de gestão de retalho escaláveis.

---

## ✨ Funcionalidades

### 🏪 Gestão de Catálogo
- Visualização completa de produtos disponíveis
- Exibição de ID, nome, preço e quantidade em estoque
- Filtragem automática de produtos sem estoque

### 🛍️ Sistema de Vendas
- Adicionar produtos ao carrinho de compras
- Validação automática de estoque disponível
- Resumo detalhado da venda atual
- Cálculo automático de subtotais e total geral

### 📄 Emissão de Nota Fiscal
- Geração automática de nota fiscal após finalização
- Identificação única de pedido (ID sequencial)
- Detalhamento completo dos itens vendidos
- Formatação profissional com informações da empresa

### 📊 Histórico e Relatórios
- Armazenamento completo de todas as vendas realizadas
- Busca de vendas específicas por ID do pedido
- Emissão de segunda via de nota fiscal
- Relatório de produtos com estoque baixo

### 🔐 Funcionalidades Administrativas
- Reposição de estoque de produtos
- Alertas de estoque abaixo do limite mínimo (10 unidades)
- Controle total sobre o inventário

---

## 🏗️ Estrutura do Projeto

```
proj_mack1shop/
│
├── proj_mack1shop.java          # Arquivo principal do sistema
│
└── Estruturas de Dados:
    ├── Arrays de Produtos
    │   ├── idsProdutos[]         # IDs únicos dos produtos
    │   ├── nomesProdutos[]       # Nomes descritivos
    │   ├── precosProdutos[]      # Preços unitários
    │   └── estoquesProdutos[]    # Quantidades disponíveis
    │
    ├── Arrays de Venda Atual
    │   ├── vendaAtualIds[]       # IDs dos produtos no carrinho
    │   └── vendaAtualQuantidades[] # Quantidades selecionadas
    │
    └── Histórico de Vendas
        ├── historicoIdsPedidos[]     # IDs dos pedidos finalizados
        ├── historicoValoresPedidos[] # Valores totais
        └── historicoItensVendidos[]  # Matriz com detalhes [pedidoID][produtoID][qtd]
```

---

## 📦 Pré-requisitos

Antes de executar o projeto, certifique-se de ter:

- ☕ **Java JDK 8 ou superior** instalado
- 💻 Um ambiente de desenvolvimento Java (Eclipse, IntelliJ IDEA, VS Code, etc.)
- 🖥️ Terminal/Prompt de comando

### Verificando a instalação do Java:

```bash
java -version
javac -version
```

---

## 🚀 Instalação

### 1️⃣ Clone o repositório

```bash
git clone https://github.com/seu-usuario/mackshop.git
cd mackshop
```

### 2️⃣ Compile o projeto

```bash
javac proj_mack1shop.java
```

### 3️⃣ Execute o programa

```bash
java proj_mack1shop
```

---

## 💡 Utilização

### Menu Principal

Ao executar o programa, você terá acesso às seguintes opções:

```
===== MENU =====
1. Inicializar base
2. Exibir catálogo de produtos
3. Adicionar item à venda
4. Ver resumo da venda atual
5. Finalizar venda (gerar histórico e Nota Fiscal)
6. Ver histórico de vendas
7. Buscar venda específica do histórico
8. (Admin) Repor estoque
9. (Admin) Relatório de estoque baixo
0. Sair
```

### ⚠️ Importante
**Sempre execute a opção 1 (Inicializar base) antes de utilizar qualquer outra funcionalidade!**

---

## 📖 Exemplos de Uso

### Exemplo 1: Realizando uma Venda

```
1. Selecione opção 1 para inicializar a base
2. Selecione opção 2 para ver o catálogo
3. Selecione opção 3 para adicionar produtos ao carrinho
   - Digite o ID do produto (ex: 101)
   - Digite a quantidade desejada (ex: 2)
4. Selecione opção 4 para ver o resumo da venda
5. Selecione opção 5 para finalizar e gerar a nota fiscal
```

### Exemplo 2: Gerenciamento de Estoque

```
1. Selecione opção 9 para ver produtos com estoque baixo
2. Selecione opção 8 para repor estoque
   - Digite o ID do produto
   - Digite a quantidade a adicionar
```

### Exemplo 3: Consultar Histórico

```
1. Selecione opção 6 para ver todas as vendas
2. Selecione opção 7 para buscar uma venda específica
   - Digite o ID do pedido (ex: 1001)
```

---

## 🛠️ Tecnologias

Este projeto foi desenvolvido utilizando:

- **Linguagem**: Java
- **Paradigma**: Programação Procedural
- **Estruturas de Dados**: Arrays unidimensionais e bidimensionais
- **Entrada/Saída**: Scanner (java.util)

### Conceitos Aplicados:

- ✅ Métodos estáticos (static)
- ✅ Passagem de parâmetros por referência (arrays)
- ✅ Manipulação de arrays
- ✅ Estruturas de controle (if/else, for, do-while)
- ✅ Formatação de saída (printf)
- ✅ Validação de dados

---

## 🤝 Contribuindo

Contribuições são bem-vindas! Para contribuir:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/NovaFuncionalidade`)
3. Commit suas mudanças (`git commit -m 'Adiciona nova funcionalidade'`)
4. Push para a branch (`git push origin feature/NovaFuncionalidade`)
5. Abra um Pull Request

---


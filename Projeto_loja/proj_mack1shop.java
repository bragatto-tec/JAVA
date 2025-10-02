import java.util.Scanner;

public class proj_mack1shop {
    static void inicializarBase (int[] idsProdutos, String[] nomesProdutos, double[] precosProdutos, int[] estoquesProdutos,int[] vendaAtuallds, 
    int[] vendaAtualQuantidades, int[] historicoldsPedidos,double[] historicoValoresPedidos, int[][] historicoltensVendidos){
        System.out.print("Faça a predefinição do tamanho do estoque");
        
        idsProdutos[0] = 101; nomesProdutos[0] = "Mouse Gamer"; precosProdutos[0] = 150.00; estoquesProdutos[0] = 25;
        idsProdutos[1] = 203; nomesProdutos[1] = "Teclado Mecanico"; precosProdutos[1] = 350.00; estoquesProdutos[1] = 15;
        idsProdutos[2] = 401; nomesProdutos[2] = "Headset ultra "; precosProdutos[2] = 420.00; estoquesProdutos[2] = 12;
        idsProdutos[3] = 512; nomesProdutos[3] = "Monitor"; precosProdutos[3] = 1800.00; estoquesProdutos[3] = 5;
        idsProdutos[4] = 634; nomesProdutos[4] = "Cadeira Gamer"; precosProdutos[4] = 1250.00; estoquesProdutos[4] = 8;
        idsProdutos[5] = 888; nomesProdutos[5] = "Mesa Led"; precosProdutos[5] = 700; estoquesProdutos[5] = 0;


        for (int i = 0; i < vendaAtuallds.length; i++) {
            vendaAtuallds[i] = 0;
            vendaAtualQuantidades[i] = 0;
        }

        for (int i = 0; i < historicoldsPedidos.length; i++) {
            historicoldsPedidos[i] = 0;
            historicoValoresPedidos[i] = 0.0;
        }
        
        for (int i = 0; i < historicoltensVendidos.length; i++) {
            for (int j = 0; j < historicoltensVendidos[i].length; j++) {
                historicoltensVendidos[i][j] = 0;
            }
        }
    }

    static void catalogo(int[] idsProdutos, String[] nomesProdutos, double[] precosProdutos, int[] estoquesProdutos){
        for(int i = 0 ; i < estoquesProdutos.length; i++){
            if (estoquesProdutos[i] > 0){
            System.out.printf("ID: %-5d | Produto: %-20s | Preço: R$ %-8.2f | Estoque: %d\n", idsProdutos[i],nomesProdutos[i], precosProdutos[i], 
            estoquesProdutos[i]);
        }
    }
}
    
    static int buscarIndiceDoProdutoPorId(int idParaBuscar, int[] catalogoIds) {
        for (int i = 0; i < catalogoIds.length; i++) {
            if (idParaBuscar == catalogoIds[i]) {
                return i; 
            }
        }
        return -1; 
    }

    static String buscarNomeDoProdutoPorId(int idParaBuscar, int[] catalogoIds, String[] catalogoNomes) {
        for (int i = 0; i < catalogoIds.length; i++) {
            if (idParaBuscar == catalogoIds[i]) {
                return catalogoNomes[i];
            }
        }
        return "Produto não encontrado";
    }
    static double buscarPrecoDoProdutoPorId(int idParaBuscar, int[] catalogoIds, double[] catalogoPrecos) {
        for (int i = 0; i < catalogoIds.length; i++) {
            if (idParaBuscar == catalogoIds[i]) {
                return catalogoPrecos[i];
            }
        }
        return 0; 
    }
    
    static void addItem(int[] idsProdutos, String[] nomesProdutos, int[] estoquesProdutos, int[] vendaAtuallds, int[] vendaAtualQuantidades) {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o ID do produto que deseja adicionar ao carrinho: ");
        int idProdutoAdd = input.nextInt();

        int indiceProduto = buscarIndiceDoProdutoPorId(idProdutoAdd, idsProdutos);

        if (indiceProduto != -1) {
            System.out.print("Digite a quantidade desejada do produto: ");
            int quantidadeDesejada = input.nextInt();

            if (quantidadeDesejada > 0 && quantidadeDesejada <= estoquesProdutos[indiceProduto]) {
                int proximoSlotVazio = -1;
                for (int j = 0; j < vendaAtuallds.length; j++) {
                    if (vendaAtuallds[j] == 0) {
                        proximoSlotVazio = j;
                        break;
                    }
                }

                if (proximoSlotVazio != -1) {
                    vendaAtuallds[proximoSlotVazio] = idProdutoAdd;
                    vendaAtualQuantidades[proximoSlotVazio] = quantidadeDesejada;

                    String nomeProduto = buscarNomeDoProdutoPorId(idProdutoAdd, idsProdutos, nomesProdutos);
                    System.out.println("\nSUCESSO: " + quantidadeDesejada + " unidade(s) do produto '" + nomeProduto + "' adicionada(s).");
                } else {
                    System.out.println("O carrinho de compras está cheio.");
                }

            } else {
                System.out.println("Estoque insuficiente ou quantidade incorreta.");
                System.out.println("Estoque disponível: " + estoquesProdutos[indiceProduto]);
            }
        } else {
            System.out.println("Produto com ID " + idProdutoAdd + " não encontrado no catálogo.");
        }
    }

    static void resumoAtual(int[] vendaAtuallds, int[] vendaAtualQuantidades, int[] idsProdutos, String[] nomesProdutos, double[] precosProdutos){
        System.out.println("\n===== RESUMO DA VENDA ATUAL =====");

        if (vendaAtuallds[0] == 0) {
            System.out.println("O carrinho de compras está vazio.");
            System.out.println("===============================");
            return;
        }

        float totalGeral = 0;
        for (int i = 0; i < vendaAtuallds.length; i++) {
            int idDoItem = vendaAtuallds[i];

            if (idDoItem == 0) {
                break;
            }
            
            int qtdDoItem = vendaAtualQuantidades[i];
            String nomeDoItem = buscarNomeDoProdutoPorId(idDoItem, idsProdutos, nomesProdutos);
            double precoUnico = buscarPrecoDoProdutoPorId(idDoItem, idsProdutos, precosProdutos);
            double subtotal = precoUnico * qtdDoItem;
            totalGeral += subtotal;

            System.out.printf("Produto: %-20s | Qtd: %-3d | Preço Un.: R$ %-8.2f | Subtotal: R$ %-8.2f\n",
            nomeDoItem, qtdDoItem, precoUnico, subtotal);
        }

        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("VALOR TOTAL DA VENDA: R$ %.2f\n", totalGeral);
    }

    static void finalizar(int[] vendaAtuallds, int[] vendaAtualQuantidades, int[] idsProdutos, String[] nomesProdutos, double[] precosProdutos,
                          int[] estoquesProdutos, int[] historicoldsPedidos, double[] historicoValoresPedidos, int[][] historicoltensVendidos){

        if (vendaAtuallds[0] == 0) {
            System.out.println("\n Não é possível finalizar a venda com o carrinho vazio.");
            return;
        }

        double valorTotalVenda = 0;
        for (int i = 0; i < vendaAtuallds.length; i++) {
            if (vendaAtuallds[i] == 0) break;
            double preco = buscarPrecoDoProdutoPorId(vendaAtuallds[i], idsProdutos, precosProdutos);
            valorTotalVenda += preco * vendaAtualQuantidades[i];
        }

        int indiceDoHistorico = -1;
        for (int i = 0; i < historicoldsPedidos.length; i++) {
            if (historicoldsPedidos[i] == 0) {
                indiceDoHistorico = i;
                break;
            }
        }

        int linhaInicialMatriz = -1;
        for (int i = 0; i < historicoltensVendidos.length; i++) {
            if (historicoltensVendidos[i][0] == 0) {
                linhaInicialMatriz = i;
                break;
            }
        }

        if (indiceDoHistorico != -1 && linhaInicialMatriz != -1) {
            int novoPedidoId = 1001 + indiceDoHistorico;
            historicoldsPedidos[indiceDoHistorico] = novoPedidoId;
            historicoValoresPedidos[indiceDoHistorico] = valorTotalVenda;

            int linhaAtual = linhaInicialMatriz;
            for (int i = 0; i < vendaAtuallds.length; i++) {
                if (vendaAtuallds[i] == 0) break;

                historicoltensVendidos[linhaAtual][0] = novoPedidoId;
                historicoltensVendidos[linhaAtual][1] = vendaAtuallds[i];
                historicoltensVendidos[linhaAtual][2] = vendaAtualQuantidades[i];
                linhaAtual++;
            }

            for (int i = 0; i < vendaAtuallds.length; i++) {
                if (vendaAtuallds[i] == 0) break;
                int idProduto = vendaAtuallds[i];
                int qtdVendida = vendaAtualQuantidades[i];
                int indiceNoCatalogo = buscarIndiceDoProdutoPorId(idProduto, idsProdutos);
                if (indiceNoCatalogo != -1) {
                    estoquesProdutos[indiceNoCatalogo] -= qtdVendida;
                }
            }

            imprimirNotaFiscal(novoPedidoId, vendaAtuallds, vendaAtualQuantidades, idsProdutos, nomesProdutos, precosProdutos);

            for (int i = 0; i < vendaAtuallds.length; i++) {
                if (vendaAtuallds[i] == 0) break;
                vendaAtuallds[i] = 0;
                vendaAtualQuantidades[i] = 0;
            }

            System.out.println("\n\nVenda finalizada com sucesso!");

        } else {
            System.out.println("\nERRO: Não foi possível salvar a venda. O histórico de vendas está cheio.");
        }
    }


    static void imprimirNotaFiscal(int pedidoId, int[] vendaAtuallds, int[] vendaAtualQuantidades, int[] idsProdutos, String[] nomesProdutos, 
    double[] precosProdutos) {
        double totalVenda = 0;
        System.out.println("\n*****************************************************************");
        System.out.println("* MACKSHOP                                                      *");
        System.out.println("* CNPJ: 12.345.678/0001-99                                      *");
        System.out.println("* NOTA FISCAL - VENDA AO CONSUMIDOR                             *");
        System.out.printf("* Pedido ID: %-52d*\n", pedidoId);
        System.out.println("* Data de Emissão: 21/09/2025 15:30:00                          *");
        System.out.println("*****************************************************************");
        System.out.println("| # | ID  | DESCRIÇÃO          | QTD | VL. UNIT. | VL. TOTAL  |");
        System.out.println("-----------------------------------------------------------------");

        for (int i = 0; i < vendaAtuallds.length; i++) {
            if (vendaAtuallds[i] == 0) break;

            int idItem = vendaAtuallds[i];
            int qtdItem = vendaAtualQuantidades[i];
            String nomeItem = buscarNomeDoProdutoPorId(idItem, idsProdutos, nomesProdutos);
            double precoItem = buscarPrecoDoProdutoPorId(idItem, idsProdutos, precosProdutos);
            double subtotal = qtdItem * precoItem;
            totalVenda += subtotal;

            System.out.printf("| %-2d| %-4d| %-18s | %-3d | R$ %-7.2f | R$ %-8.2f |\n",(i + 1), idItem, nomeItem, qtdItem, precoItem, subtotal);
        }
        
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("| SUBTOTAL                                        | R$ %-8.2f |\n", totalVenda);
        System.out.printf("| TOTAL                                           | R$ %-8.2f |\n", totalVenda);
        System.out.println("*****************************************************************");
        System.out.println("* OBRIGADO PELA PREFERÊNCIA! VOLTE SEMPRE!                      *");
        System.out.println("*****************************************************************");
    }

    
    static void historico(Scanner input, int[] historicoldsPedidos, double[] historicoValoresPedidos){
        if (historicoldsPedidos[0] == 0) {
            System.out.println("Nenhuma venda foi finalizada ainda.");
        } else {
            for (int i = 0; i < historicoldsPedidos.length; i++) {
                int pedidoId = historicoldsPedidos[i];
                if (pedidoId == 0) {
                    break;
                }
                double valorTotal = historicoValoresPedidos[i];
                System.out.printf("Pedido ID: %d - Valor Total: R$ %.2f\n", pedidoId, valorTotal);
            }
        }

    }

    static void buscaVenda(Scanner input, int[][] historicoltensVendidos, int[] idsProdutos, String[] nomesProdutos, double[] precosProdutos){
            System.out.print("\nDigite o ID do pedido que deseja: ");
            int pedidoIdBuscado = input.nextInt();
            input.nextLine();

            boolean encontrouVenda = false;
            double totalDaVenda = 0;
            int contador = 1;

            for (int i = 0; i < historicoltensVendidos.length; i++) {
                if (historicoltensVendidos[i][0] == pedidoIdBuscado) {
                    if (!encontrouVenda) {
                        // ...então a venda existe! Imprimimos o cabeçalho da nota.
                        System.out.println("\n*****************************************************************");
                        System.out.println("* NOTA FISCAL - VENDA AO CONSUMIDOR (2ª Via)           *");
                        System.out.printf("* Pedido ID: %-52d*\n", pedidoIdBuscado);
                        System.out.println("*****************************************************************");
                        System.out.println("| # | ID  | DESCRIÇÃO          | QTD | VL. UNIT. | VL. TOTAL  |");
                        System.out.println("-----------------------------------------------------------------");
                        encontrouVenda = true;
                    }

                    int idProduto = historicoltensVendidos[i][1];
                    int quantidade = historicoltensVendidos[i][2];

                    String nomeItem = buscarNomeDoProdutoPorId(idProduto, idsProdutos, nomesProdutos);
                    double precoItem = buscarPrecoDoProdutoPorId(idProduto, idsProdutos, precosProdutos);

                    double subtotal = quantidade * precoItem;
                    totalDaVenda += subtotal;

                    System.out.printf("| %-2d| %-4d| %-18s | %-3d | R$ %-7.2f | R$ %-8.2f |\n",
                            contador, idProduto, nomeItem, quantidade, precoItem, subtotal);

                    contador++;
                }
            }
            if (encontrouVenda) {
                System.out.println("-----------------------------------------------------------------");
                System.out.printf("| TOTAL                                                 | R$ %-8.2f |\n", totalDaVenda);
                System.out.println("*****************************************************************");
            } else {
                // Se não, a variável 'encontrouVenda' ainda será falsa.
                System.out.println("\nPedido com o ID " + pedidoIdBuscado + " não consta no histórico.");
            }
        }


    static void reporAdm(Scanner input, int[] idsProdutos, int[] estoquesProdutos, String[] nomesProdutos){
        System.out.println("\nSomente para ADM");
        System.out.print("Digite o ID do produto para repor: ");
        int idProduto = input.nextInt();
        input.nextLine(); 

        int indiceProduto = buscarIndiceDoProdutoPorId(idProduto, idsProdutos);

        if (indiceProduto == -1) {
            System.out.println("Produto com ID " + idProduto + " não encontrado.");
        } else {
            System.out.print("Digite a quantidade a ser adicionada ao estoque: ");
            int quantidadeAdicionar = input.nextInt();
            input.nextLine();

            if (quantidadeAdicionar > 0) {
                estoquesProdutos[indiceProduto] += quantidadeAdicionar;
                System.out.println("\nEstoque do produto '" + nomesProdutos[indiceProduto] + "' atualizado.");
            } else {
                System.out.println("A quantidade para reposição deve ser maior que zero.");
            }
        }
        
    }

    static void relatorioAdm(Scanner input, int[] idsProdutos, String[] nomesProdutos, int[] estoquesProdutos){
        final int limitar = 10;
        boolean encontrouProdutoBaixo = false;

        for (int i = 0; i < idsProdutos.length; i++) {
            if (idsProdutos[i] == 0) {
                break;
            }
            if (estoquesProdutos[i] < limitar) {
                System.out.printf("ID: %-5d | Produto: %-20s | Estoque Atual: %d\n", idsProdutos[i], nomesProdutos[i], estoquesProdutos[i]);
                encontrouProdutoBaixo = true;
            }
        }
        if (!encontrouProdutoBaixo) {
            System.out.println("Nenhum produto com estoque baixo.");
        }
    }

    static void exibirMenu(){
        System.out.println("Sempre executar o inicializar base antes de acionar as demais funções");
        System.out.println("\n===== MENU =====");
        System.out.println("1. Inicializar base");
        System.out.println("2. Exibir catálogo de produtos");
        System.out.println("3. Adicionar item à venda");
        System.out.println("4. Ver resumo da venda atual");
        System.out.println("5. Finalizar venda (gerar histórico e Nota Fiscal)");
        System.out.println("6. Ver histórico de vendas");
        System.out.println("7. Buscar venda específica do histórico");
        System.out.println("8. (Admin) Repor estoque");
        System.out.println("9. (Admin) Relatório de estoque baixo");
        System.out.println("0. Sair");
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] idsProdutos = new int[50];
        String[] nomesProdutos = new String[50];
        double[] precosProdutos = new double[50];
        int[] estoquesProdutos = new int[50];

       
        int[] vendaAtuallds = new int[100];
        int[] vendaAtualQuantidades = new int[100];

        int[] historicoldsPedidos = new int[500];
        double[] historicoValoresPedidos = new double[500];
        int[][] historicoltensVendidos = new int[2000][3];

        int opcao;
        System.out.println("Digite a opção para o que deseja(Sempre executar o inicializar base antes de acionar as demais funções)");

        do { 
            exibirMenu();
            opcao = input.nextInt();
            input.nextLine(); 
            switch (opcao){
                case 1:
                    inicializarBase(idsProdutos, nomesProdutos, precosProdutos, estoquesProdutos, vendaAtuallds, vendaAtualQuantidades, historicoldsPedidos, 
                    historicoValoresPedidos, historicoltensVendidos);
                    break;
                case 2:
                    catalogo(idsProdutos, nomesProdutos, precosProdutos, estoquesProdutos);
                    break;
                case 3:
                    addItem(idsProdutos, nomesProdutos, estoquesProdutos, vendaAtuallds, vendaAtualQuantidades);
                    break;
                case 4:
                    resumoAtual(vendaAtuallds, vendaAtualQuantidades, idsProdutos, nomesProdutos, precosProdutos);
                    break;
                case 5:
                    finalizar(vendaAtuallds, vendaAtualQuantidades, idsProdutos, nomesProdutos, precosProdutos, estoquesProdutos, 
                          historicoldsPedidos, historicoValoresPedidos, historicoltensVendidos);
                    break;
                case 6:
                    historico(input, historicoldsPedidos, historicoValoresPedidos);
                    break;
                case 7: 
                    buscaVenda(input, historicoltensVendidos, idsProdutos, nomesProdutos, precosProdutos);
                    break;
                case 8: 
                    reporAdm(input, idsProdutos, estoquesProdutos, nomesProdutos);
                    break;
                case 9:
                    relatorioAdm(input, idsProdutos, nomesProdutos, estoquesProdutos);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        
        } while (opcao != 0);
        input.close();
    }
}

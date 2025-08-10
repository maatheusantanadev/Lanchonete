package atv01_jefte;

import java.util.ArrayList;
import java.util.Scanner;

public class lanchonete {
    public static void main(String[] args) {
        ArrayList<Produto> produtos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 - cadastrar produto\n" +
                    "2 - editar\n" +
                    "3 - excluir\n" +
                    "4 - listar\n" +
                    "5 - vender\n" +
                    "0 - sair\n");
            System.out.println("Escolha a opção desejada!\n");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    String codigo;
                    String descricao;
                    Double preco;
                    String imagem;

                    System.out.println("Digite o código do produto: ");
                    codigo = scanner.nextLine();
                    System.out.println("Digite a descrição do produto: ");
                    descricao = scanner.nextLine();
                    System.out.println("Digite o preço do produto: ");
                    preco = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Adicione a imagem do produto: ");
                    imagem = scanner.nextLine().trim();

                    Produto produto$ = new Produto(codigo, descricao, preco, imagem);
                    produto$.mover(imagem);
                    produtos.add(produto$);
                    System.out.println("Produto cadastrado!\n");
                    break;


                case 2:
                    while (true) {
                        String codigo1;
                        System.out.println("\nDigite o código do produto: ");
                        codigo1 = scanner.nextLine();

                        for (Produto produto : produtos) {
                            if (produto.getCodigo().equals(codigo1)) {
                                System.out.println(produto);
                            }

                            System.out.println("\n1- Código\n" +
                                    "2- Descrição\n" +
                                    "3- Preço\n" +
                                    "4- Imagem\n" +
                                    "Digite o número do que deseja atualizar?");
                            int opcao = scanner.nextInt();
                            scanner.nextLine();
                            produto.editarProduto(opcao);
                            break;
                        }

                        System.out.println("Deseja cancelar? digite 's'.: ");
                        String sair = scanner.nextLine().toLowerCase();
                        if (sair.equals("s")) {
                            break;
                        }
                    }
                    break;

                case 3:
                    int index = 0;
                    for (Produto produto : produtos) {
                        index += 1;
                        System.out.println(index + "-" + "\n" + produto + "\n");
                    }

                    System.out.println("\nO que deseja excluir?");
                    int opcao = scanner.nextInt();
                    scanner.nextLine();
                    produtos.remove(opcao - 1);
                    System.out.println("\nProduto removido!");
                    break;

                case 4:
                    for (Produto produto : produtos) {
                        System.out.println(produto + "\n");
                    }
                    break;

                case 5:
                    int index1 = 0;
                    int codigoCliente;
                    int quantidade;
                    Double precoTotal = null;

                    for (Produto produto : produtos) {
                        index1 += 1;
                        System.out.printf("%-8s %-20s %-10s%n", "Código", "Descrição", "Preço");
                        System.out.printf("%-8d %-20s %-10.2f%n", index1, produto.getDescricao(), produto.getPreco());
                    }

                    System.out.println("Digite o código do produto que deseja escolher: ");
                    codigoCliente = scanner.nextInt() - 1;
                    scanner.nextLine();
                    System.out.println("Digite a quantidade que deseja: ");
                    quantidade = scanner.nextInt();
                    scanner.nextLine();

                    for (Produto produto : produtos){
                        while (true) {
                            if (produtos.get(codigoCliente).equals(produto)) {
                                precoTotal = produto.getPreco() * quantidade;
                                break;
                            } else {
                                System.out.println("Digite uma opção válida!");
                            }
                        }
                    }
                    System.out.printf("%-7s %-10.2f", "Total: ", precoTotal);
                    System.out.println();
                    break;

                case 0:
                    System.out.println("Sistema encerrado!");
                    System.exit(0);
            }
        }
    }
}

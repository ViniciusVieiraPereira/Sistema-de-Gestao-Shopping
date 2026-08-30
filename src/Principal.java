import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Loja loja = null;
        Produto produto = null;
        int opcao = 0;

        while (opcao != 3) {
            System.out.println("\n(1) criar uma loja");
            System.out.println("(2) criar um produto");
            System.out.println("(3) sair");
            System.out.print("Digite a opção: ");

            opcao = teclado.nextInt();
            teclado.nextLine();

            if (opcao == 1) {
                loja = cadastrarLoja(teclado);
            } else if (opcao == 2) {
                produto = cadastrarProduto(teclado);
            } else if (opcao == 3) {
                System.out.println("Saindo.");
            } else {
                System.out.println("Opção inválida");
            }
        }

        if (loja != null && produto != null) {
            System.out.println("\nRESULTADO");

            Data dataTeste = new Data(20, 10, 2023);

            if (produto.estaVencido(dataTeste)) {
                System.out.println("PRODUTO VENCIDO");
            } else {
                System.out.println("PRODUTO NÃO VENCIDO");
            }

            System.out.println("\nDados da Loja:");
            System.out.println(loja);
        }
    }

    public static Loja cadastrarLoja(Scanner teclado) {
        System.out.println("\nCadastrando Loja");
        System.out.print("Nome: ");
        String nome = teclado.nextLine();
        System.out.print("Quantidade Funcionários: ");
        int quantidadeFuncionarios = teclado.nextInt();
        System.out.print("Salário Base: ");
        double salario = teclado.nextDouble();
        teclado.nextLine();
        System.out.print("Quantidade máxima de produtos no estoque: ");
        int maxProdutos = teclado.nextInt();
        teclado.nextLine();

        System.out.println("Endereço");
        System.out.print("Rua: ");
        String rua = teclado.nextLine();
        System.out.print("Número: ");
        String numero = teclado.nextLine();
        System.out.print("Complemento: ");
        String complemento = teclado.nextLine();
        System.out.print("Bairro: ");
        String bairro = teclado.nextLine();
        System.out.print("Cidade: ");
        String cidade = teclado.nextLine();
        System.out.print("Estado: ");
        String estado = teclado.nextLine();
        System.out.print("CEP: ");
        String cep = teclado.nextLine();

        Endereco endereco = new Endereco(rua, numero, complemento, bairro, cidade, estado, cep);

        System.out.println("Data de Fundação");
        System.out.print("Dia: ");
        int d = teclado.nextInt();
        System.out.print("Mês: ");
        int m = teclado.nextInt();
        System.out.print("Ano: ");
        int a = teclado.nextInt();
        teclado.nextLine();

        Data fundacao = new Data(d, m, a);

        return new Loja(nome, quantidadeFuncionarios, salario, endereco, fundacao, maxProdutos);
    }

    public static Produto cadastrarProduto(Scanner teclado) {
        System.out.println("\nCadastrando Produto");
        System.out.print("Nome: ");
        String nome = teclado.nextLine();
        System.out.print("Preço: ");
        double preco = teclado.nextDouble();

        System.out.println("..: Data de Validade :..");
        System.out.print("Dia: ");
        int d = teclado.nextInt();
        System.out.print("Mês: ");
        int m = teclado.nextInt();
        System.out.print("Ano: ");
        int a = teclado.nextInt();
        teclado.nextLine();

        Data validade = new Data(d, m, a);

        return new Produto(nome, preco, validade);
    }
}
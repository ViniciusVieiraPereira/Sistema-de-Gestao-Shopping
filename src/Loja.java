public class Loja {
    private String nome;
    private int quantidadeFuncionarios;
    private double salarioBaseFuncionarios;
    private Endereco endereco;
    private Data dataFundacao;
    private Produto[] estoqueProdutos;

    public Loja(String nome, int quantidadeFuncionarios, double salario, Endereco endereco,
            Data dataFundacao, int maxProdutos) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionarios = salario;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.estoqueProdutos = new Produto[maxProdutos];
    }

    public Loja(String nome, int quantidadeFuncionarios, Endereco endereco, Data dataFundacao, int maxProdutos) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionarios = -1;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.estoqueProdutos = new Produto[maxProdutos];

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeFuncionarios() {
        return quantidadeFuncionarios;
    }

    public void setQuantidadeFuncionarios(int quantidadeFuncionarios) {
        this.quantidadeFuncionarios = quantidadeFuncionarios;
    }

    public double getSalarioBaseFuncionario() {
        return salarioBaseFuncionarios;
    }

    public void setSalarioBaseFuncionario(int salarioBaseFuncionarios) {
        this.salarioBaseFuncionarios = salarioBaseFuncionarios;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Data getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Data dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public double gastosComSalario() {
        if (this.salarioBaseFuncionarios == -1) {
            return -1;
        }
        return this.quantidadeFuncionarios * this.salarioBaseFuncionarios;
    }

    public Produto[] getEstoqueProdutos() {
        return estoqueProdutos;
    }

    public void setEstoqueProdutos(Produto[] estoqueProdutos) {
        this.estoqueProdutos = estoqueProdutos;
    }

    public char tamanhoDaLoja() {
        if (this.quantidadeFuncionarios < 10) {
            return 'P';
        } else if (this.quantidadeFuncionarios <= 30) {
            return 'M';
        } else {
            return 'G';
        }
    }

    public void imprimeProdutos() {
        System.out.println("Produtos em Estoque (" + nome + ")");
        boolean possuiProdutos = false;
        for (Produto p : estoqueProdutos) {
            if (p != null) {
                System.out.println(p);
                possuiProdutos = true;
            }
        }
        if (!possuiProdutos) {
            System.out.println("Estoque vazio.");
        }
    }

    public boolean insereProduto(Produto produto) {
        if (produto == null)
            return false;

        for (int i = 0; i < estoqueProdutos.length; i++) {
            if (estoqueProdutos[i] == null) {
                estoqueProdutos[i] = produto;
                return true;
            }
        }
        return false;
    }

    public boolean removeProduto(String nomeProduto) {
        for (int i = 0; i < estoqueProdutos.length; i++) {
            if (estoqueProdutos[i] != null && estoqueProdutos[i].getNome().equalsIgnoreCase(nomeProduto)) {
                estoqueProdutos[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String salarioFormatado = (salarioBaseFuncionarios == -1) ? "Não definido" : "R$ " + salarioBaseFuncionarios;
        return "Loja: " + nome +
                "\nFuncionários: " + quantidadeFuncionarios + " | Salário Base: " + salarioFormatado +
                "\nFundada em: " + dataFundacao +
                "\nEndereco: " + endereco +
                "\nCapacidade do Estoque:" + estoqueProdutos.length;
    }
}
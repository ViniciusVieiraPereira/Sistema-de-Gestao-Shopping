public class Produto {
    private String nome;
    private Double preco;
    private Data dataValidade;

    public Produto(String nome, double preco, Data dataValidade) {
        this.nome = nome;
        this.preco = preco;
        this.dataValidade = dataValidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Data getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Data dataValidade) {
        this.dataValidade = dataValidade;
    }

    public boolean estaVencido(Data dataReferencia) {
        if (this.dataValidade.getAno() < dataReferencia.getAno()) {
            return true;
        } else if (this.dataValidade.getAno() > dataReferencia.getAno()) {
            return false;
        }

        if (this.dataValidade.getMes() < dataReferencia.getMes()) {
            return true;
        } else if (this.dataValidade.getMes() > dataReferencia.getMes()) {
            return false;
        }

        return this.dataValidade.getDia() < dataReferencia.getDia();
    }

    @Override
    public String toString() {
        return "Produto: " + nome + " | Preço: R$ " + preco + "| Validade:" + dataValidade;
    }
}
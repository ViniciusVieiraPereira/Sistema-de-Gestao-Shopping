public class Shopping {
    private String nome;
    private Endereco endereco;
    private Loja[] lojas;

    public Shopping(String nome, Endereco endereco, int maxLojas) {
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[maxLojas];
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Loja[] getLojas() {
        return lojas;
    }

    public void setLojas(Loja[] lojas) {
        this.lojas = lojas;
    }

    public boolean insereLoja(Loja loja) {
        if (loja == null)
            return false;

        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] == null) {
                lojas[i] = loja;
                return true;
            }
        }
        return false;
    }

    public boolean removeLoja(String nomeLoja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] != null && lojas[i].getNome().equalsIgnoreCase(nomeLoja)) {
                lojas[i] = null;
                return true;
            }
        }
        return false;
    }

    public int quantidadeLojasPorTipo(String tipoLoja) {
        int contador = 0;
        boolean tipoValido = false;

        if (tipoLoja.equalsIgnoreCase("Cosmetico") |
                tipoLoja.equalsIgnoreCase("Vestuario") |
                tipoLoja.equalsIgnoreCase("Bijuteria") |
                tipoLoja.equalsIgnoreCase("Alimentacao") |
                tipoLoja.equalsIgnoreCase("Informatica")) {
            tipoValido = true;
        }

        if (!tipoValido) {
            return -1;
        }

        for (Loja l : lojas) {
            if (l != null) {
                if (tipoLoja.equalsIgnoreCase("Cosmetico") && l instanceof Cosmetico)
                    contador++;
                else if (tipoLoja.equalsIgnoreCase("Vestuario") && l instanceof Vestuario)
                    contador++;
                else if (tipoLoja.equalsIgnoreCase("Bijuteria") && l instanceof Bijuteria)
                    contador++;
                else if (tipoLoja.equalsIgnoreCase("Alimentacao") && l instanceof Alimentacao)
                    contador++;
                else if (tipoLoja.equalsIgnoreCase("Informatica") && l instanceof Informatica)
                    contador++;
            }
        }

        return contador;
    }

    public Informatica lojaSeguroMaisCaro() {
        Informatica lojaMaisCara = null;
        double maiorSeguro = -1;

        for (Loja l : lojas) {
            if (l != null && l instanceof Informatica) {
                Informatica lojaInfo = (Informatica) l;

                if (lojaInfo.getSeguroEletronicos() > maiorSeguro) {
                    maiorSeguro = lojaInfo.getSeguroEletronicos();
                    lojaMaisCara = lojaInfo;
                }
            }
        }

        return lojaMaisCara;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("SHOPPING: ").append(nome).append("\n");
        sb.append("ENDEREÇO: ").append(endereco).append("\n");
        sb.append("CAPACIDADE MÁXIMA DE LOJAS: ").append(lojas.length).append("\n");
        sb.append("LISTA DE LOJAS CADASTRADAS\n");

        boolean temLoja = false;
        for (Loja l : lojas) {
            if (l != null) {
                sb.append("\n[").append(l.getClass().getSimpleName()).append("]\n")
                        .append(l.toString()).append("\n");
                temLoja = true;
            }
        }

        if (!temLoja) {
            sb.append("Nenhuma loja cadastrada até o momento.\n");
        }
        sb.append("");
        return sb.toString();
    }
}

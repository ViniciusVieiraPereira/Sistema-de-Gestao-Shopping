public class Data {
    private int dia;
    private int mes;
    private int ano;
    public Data(int dia, int mes, int ano) {
        if (validarData(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            System.out.println("Erro: Data inválida informada (" + dia + "/" + mes + "/" + ano + "). Definindo para a data padrão: 1/1/2000");
            this.dia = 1;
            this.mes = 1;
            this.ano = 2000;
        }
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public boolean verificaAnoBissexto() {
        return (this.ano % 4 == 0 && this.ano % 100 != 0) || (this.ano % 400 == 0);
    }

    private boolean validarData(int d, int m, int a) {
        if (m < 1 || m > 12 || a < 0) {
            return false;
        }

        int diasNoMes;
        switch (m) {
            case 2:
                boolean isBissexto = (a % 4 == 0 && a % 100 != 0) || (a % 400 == 0);
                diasNoMes = isBissexto ? 29 : 28;
                break;
            case 4: case 6: case 9: case 10:
                diasNoMes = 30;
                break;
            default:
                diasNoMes = 31;
                break;
        }

        return d >= 1 && d <= diasNoMes;
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }
}
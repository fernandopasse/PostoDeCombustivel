package trabalho;

public class BombaCombustivel {

    private int numeroDoLacre;
    private double capacidadeDeCombustivel;
    private int tipo;
    public static int limita;
    private double valorDoLitro;
    private boolean status;
    private String bandeira;

    public BombaCombustivel(int numeroDoLacre, double valorDoLitro, String bandeira, int tipo) {
        BombaCombustivel.limita++;
        this.numeroDoLacre = numeroDoLacre;
        this.valorDoLitro = valorDoLitro;
        this.bandeira = bandeira;
        this.status = true;
        this.tipo = tipo;
        /*
         * Ajusta a capacidade de combustivel de acordo com o tipo
         *
         */
        switch (this.tipo) {
            case 1:
                this.capacidadeDeCombustivel = 600;
                break;
            case 2:
                this.capacidadeDeCombustivel = 700;
                break;
            case 3:
                this.capacidadeDeCombustivel = 900;
                break;
        }
    }

    public void reabastecerBomba(int litros) {
        this.capacidadeDeCombustivel = litros;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }
    
    public void setLimita(int limita) {
        BombaCombustivel.limita = limita;
    }
    
    public double getCapacidadeDeCombustivel() {
        return capacidadeDeCombustivel;
    }

    public int getNumeroDoLacre() {
        return numeroDoLacre;
    }

    public void setNumeroDoLacre(int numeroDoLacre) {
        this.numeroDoLacre = numeroDoLacre;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
        if (this.status == true) {
            switch (this.tipo) {
                case 1:
                    this.capacidadeDeCombustivel = 600;
                    break;
                case 2:
                    this.capacidadeDeCombustivel = 700;
                    break;
                case 3:
                    this.capacidadeDeCombustivel = 900;
                    break;
            }
        }
    }

    public String getTipo() {
        String tipo_retorno = null;
        switch (this.tipo) {
            case 1:
                tipo_retorno = "Gasolina";
                break;
            case 2:
                tipo_retorno = "Álcool";
                break;
            case 3:
                tipo_retorno = "Óleo diesel";
                break;
        }
        return tipo_retorno;
    }

    public double getValorDoLitro() {
        return valorDoLitro;
    }
    /*
     * Lança uma exceção se o valor do combustível for menor ou igual a zero
     */

    public void setValorDoLitro(double valorDoLitro) throws Exception {
        if (valorDoLitro <= 0) {
            throw new Exception("O valor do litro tem que ser positivo.");
        }

        this.valorDoLitro = valorDoLitro;
    }

    public void abastecerLitros(double quantidadeDeCombustivel) throws Exception {
        if (this.capacidadeDeCombustivel <= 40) {
            this.setStatus(false);
            throw new Exception("Limite de segurança atingido.");
        }
        if ((this.capacidadeDeCombustivel - quantidadeDeCombustivel) <= 40) {
            throw new Exception("Este valor supera o limite de segurança.");
        }

        this.capacidadeDeCombustivel = this.capacidadeDeCombustivel - quantidadeDeCombustivel;
    }

    public void abastecerValor(double valorEmDinheiro) throws Exception {

        double quant = valorEmDinheiro / this.getValorDoLitro();
        if (quant >= capacidadeDeCombustivel) {
            throw new Exception("Este valor supera a quantidade de combustivel.");
        }
        if (capacidadeDeCombustivel <= 40) {
            this.setStatus(false);
            throw new Exception("Limite de segurança atingido.");
        }
        if (this.capacidadeDeCombustivel - quant <= 40) {
            throw new Exception("Este valor supera o limite de segurança.");
        }
        this.capacidadeDeCombustivel = this.capacidadeDeCombustivel - quant;
    }
}

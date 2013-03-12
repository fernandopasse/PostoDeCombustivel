package trabalho;

/**
 * @author Fernando
 */
public class Vendas {
   private int lacreDaBomba;
   private double valorTotal;
   private String tipoDeCombustivel;

    public Vendas(int lacreDaBomba, double valorTotal, String tipoDeCombustivel) {
        this.lacreDaBomba = lacreDaBomba;
        this.valorTotal = valorTotal;
        this.tipoDeCombustivel = tipoDeCombustivel;
    }
    public int getLacreDaBomba() {
        return lacreDaBomba;
    }

    public void setLacreDaBomba(int lacreDaBomba) {
        this.lacreDaBomba = lacreDaBomba;
    }

    public String getTipoDeCombustivel() {
        return tipoDeCombustivel;
    }

    public void setTipoDeCombustivel(String tipoDeCombustivel) {
        this.tipoDeCombustivel = tipoDeCombustivel;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }
}

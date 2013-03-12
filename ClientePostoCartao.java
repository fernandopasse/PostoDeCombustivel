package trabalho;

/**
 *
 * @author Fernando
 */
public class ClientePostoCartao {
    private String nome;
    private long cpf;
    private int numeroDoCartao;

    public ClientePostoCartao(String nome, long cpf, int numeroDoCartao){
        this.nome = nome;
        this.cpf = cpf;
        this.numeroDoCartao = numeroDoCartao;

    }
    public long getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroDoCartao() {
        return numeroDoCartao;
    }

    public void setNumeroDoCartao(int numeroDoCartao) {
        this.numeroDoCartao = numeroDoCartao;
    }
}

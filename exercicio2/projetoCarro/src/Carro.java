public class Carro {
    private String nome;
    private int velocidade;
    
    public Carro(String nome) {
        this.nome  = nome;
        velocidade = 0;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public String getNome() {
        return nome;
    }

    public void acelerar() {
        velocidade += 10;
    }

    public void reduzir() {
        velocidade -= 10;
    }
}   



/**
 * Classe que representa uma nave do jogador no jogo
 * 
 * @author Julio Cesar Alves
 * @version 2016-04-08
 */

import java.util.Scanner;
import java.util.Random;

public class Nave
{
    // posição da nave na tela
    private int posX;
    private int posY;
    
    // velocidade da nave ao mover (em pixels)
    private final int velocidade;
    
    // dimensões da nave
    private int largura;
    private int altura;
    
    // indica se a nave do jogador esta viva
    private boolean estaViva;

    // nome do jogador
    private String nomeJogador;    

    // numero de escudos da nava
    private int numeroDeEscudos;
    

    /**
     * Controi uma nave com as caracteristicas iniciais padrao
     */
    public Nave()
    {        
        Scanner entrada = null;
        String novoNome = null;
        try {
            entrada = new Scanner(System.in);
            novoNome = entrada.nextLine();
        }
        finally {
            if(entrada != null)
                entrada.close();
        }

        // tamanho padrao da nave
        largura = 50;
        altura = 50; 
        
        // velocidade da nave
        velocidade = 15;                

        inicializar();
        alterarNome(novoNome);
    }
    
    /**
     * Sorteia um numero de 0 a 5, que será o numero de escudos da nave
     */
    public int gerarEscudos()
    {
        Random gerador = new Random();
        int numeroGerado = gerador.nextInt(6);
        
        return numeroGerado;
    }

    /**
     * Reinicia as característivas da nave (quando recomeca o jogo, por exemplo)
     */
    public void inicializar()
    {                       
        // posição inicial da nave na tela
        posX = 10;
        posY = 200;
        
        estaViva = true;

        // numero de escudos
        numeroDeEscudos = gerarEscudos();
    }
    /**
     * Altera o atributo nomeJogador
     */

    public void alterarNome(String novoNome)
    {
        this.nomeJogador = novoNome;
    }

    /**
     * Retorna a posição X da nave na tela
     */
    public int getPosX()
    {
        return posX;
    }
    
    /**
     * Retorna a posição Y da nave na tela
     */
    public int getPosY()
    {
        return posY;
    }
    
    /**
     * Retorna a largura da nave
     */
    public int getLargura()
    {
        return largura;
    }
    
    /**
     * Retorna a altura da nave
     */
    public int getAltura()
    {
        return altura;
    }
    
    /**
     * Retorna se a nave esta viva
     */
    public boolean estaViva()
    {
        return estaViva;
    }
    
    /**
     * Altera as dimensoes da nave (para que ela fique do tamanho da figura que a representa)
     * 
     * @param largura nova largura da nave
     * @param altura nova altura da nave
     */
    public void alterarTamanho(int largura, int altura)
    {
        this.largura = largura;
        this.altura = altura;
    }
    
    /**
     * Retorna o texto a ser exibido próximo à nave
     */
    public String getTextoExibicao()
    {
        // retorna o nome do Jogador
        
    switch (numeroDeEscudos) {
        case 1:                    
            return nomeJogador + " *";
        case 2:                    
            return nomeJogador + " * *";                
        case 3:                    
            return nomeJogador + " * * *";                    
        case 4:                    
            return nomeJogador + " * * * *";
        case 5:                    
            return nomeJogador + " * * * * *";
    }
    
    return nomeJogador;
    }
    
    /**
     * Move a nave pra direita, se ela estiver viva
     */
    public void moverDireita()
    {
        if (estaViva)
        {
            posX += velocidade;
        }
    }
    
    /**
     * Move a nave pra esquerda, se ela estiver viva
     */
    public void moverEsquerda()
    {
        if (estaViva)
        {
            posX -= velocidade;
        }
    }

    /**
     * Move a nave pra cima, se ela estiver viva
     */
    public void moverCima()
    {
        if (estaViva)
        {
            posY -= velocidade;
        }
    }

    /**
     * Move a nave pra baixo, se ela estiver viva
     */
    public void moverBaixo()
    {
        if (estaViva)
        {
            posY += velocidade;
        }
    }
        
    /**
     * Realiza um tiro se a nave estiver viva
     * 
     * @return Retorna o tiro criado, ou null se a nave não atirou
     */
    public Tiro atirar()
    {  
        if (estaViva)
        {            
            return new Tiro(posX+largura, posY + (int)(altura/2), false);
        }
        else
        {
            return null;
        }
    }
    
    /**
     * Trata quando a nave do jogador toma um tiro, se ela estiver viva
     */
    public void tomarTiro()
    {
        if (estaViva)
        {
            if (numeroDeEscudos == 0) {
            // morre se nao tiver escudos
            estaViva = false;
            } else {
            // se tiver escudos, desconta um
                numeroDeEscudos--;                
            }
        }
    }
}

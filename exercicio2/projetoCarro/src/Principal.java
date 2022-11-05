import java.util.Scanner;

public class Principal {
    private Scanner entrada = new Scanner(System.in);
    private Carro[] carroDoUsuario;
    private Contador cont;

    public Principal() {
        carroDoUsuario = new Carro[5];
    }

    public void menu() {
        System.out.println("1)  Criar o carro");
        System.out.println("2)  Acelerar o carro");
        System.out.println("3)  Reduzir a velocidade");
        System.out.println("4)  Exibir os dados do carro");
        System.out.println("5)  Sair");
    }

    public void trataMenu() {
        int opcao = 0;
        int velocidade;
        String nome;
        String carroEscolhido;
        cont = new Contador();
        
        while(opcao != 5) {
            menu();
            int nmrCarros = cont.getContador();
            opcao = Integer.parseInt(entrada.nextLine());
            switch (opcao) {
                case 1:
                    if (nmrCarros < 4) {                    
                        cont.incrementa();
                        nmrCarros = cont.getContador();                    
                        System.out.print("Digite o nome do carro: ");
                        nome = entrada.nextLine();
                        carroDoUsuario[nmrCarros] = new Carro(nome);                    
                    
                    } else {
                        System.out.println("Nao e possivel criar mais carros.");
                    }

                break;

                case 2:
                    System.out.println("Qual carro voce deseja acelerar?");                
                    carroEscolhido = entrada.nextLine();
                    for (int i = 0; i <= nmrCarros; i++) {
                        String compara = carroDoUsuario[i].getNome();
                        if(carroEscolhido.equals(compara)) {
                            carroDoUsuario[i].acelerar();
                        }
                    }

                break;

                case 3:
                System.out.println("Qual carro voce deseja reduzir?");                
                carroEscolhido = entrada.nextLine();
                for (int i = 0; i <= nmrCarros; i++) {
                    String compara = carroDoUsuario[i].getNome();
                    if(carroEscolhido.equals(compara)) {
                        carroDoUsuario[i].reduzir();
                    }
                }

                break;

                case 4:
                for (int i = 0; i <= nmrCarros; i++) {
                    nome = carroDoUsuario[i].getNome();
                    velocidade = carroDoUsuario[i].getVelocidade();

                    System.out.println("Nome e velocidade: ");
                    System.out.println(nome);
                    System.out.println(velocidade);
                    System.out.println("*******************");
                }
                    
                break;

            }
        }
        entrada.close();
    }
}

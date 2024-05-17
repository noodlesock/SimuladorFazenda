import java.util.Scanner;

public class FazendaSimConsole {

	  public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Fazenda fazenda = new Fazenda(1000, 50); // Dinheiro inicial: $1000, Terreno inicial: 50 unidades

	        boolean jogando = true;
	        while (jogando) {
	            System.out.println("\n=== SIMULADOR DE FAZENDA ===");
	            System.out.println("1. Plantar plantação");
	            System.out.println("2. Colher plantação");
	            System.out.println("3. Comprar animal");
	            System.out.println("4. Alimentar animais");
	            System.out.println("5. Exibir status");
	            System.out.println("6. Sair");
	            System.out.print("Escolha uma opção: ");

	            // Verificar se a próxima entrada é um número inteiro
	            if (scanner.hasNextInt()) {
	                int opcao = scanner.nextInt();
	                switch (opcao) {
	                    case 1:
	                        System.out.print("Digite a plantação (trigo/milho): ");
	                        String plantacao = scanner.next();
	                        System.out.print("Digite a quantidade: ");
	                        int quantidade = scanner.nextInt();
	                        fazenda.plantar(plantacao, quantidade);
	                        break;
	                    case 2:
	                        System.out.print("Digite a plantação para colher (trigo/milho): ");
	                        plantacao = scanner.next();
	                        System.out.print("Digite a quantidade: ");
	                        quantidade = scanner.nextInt();
	                        fazenda.colher(plantacao, quantidade);
	                        break;
	                    case 3:
	                        System.out.print("Digite o animal para comprar (vaca/porco): ");
	                        String animal = scanner.next();
	                        fazenda.comprarAnimal(animal);
	                        break;
	                    case 4:
	                        fazenda.alimentarAnimais();
	                        break;
	                    case 5:
	                        fazenda.exibirStatus();
	                        break;
	                    case 6:
	                        jogando = false;
	                        break;
	                    default:
	                        System.out.println("Opção inválida.");
	                }
	            } else {
	                // Se não for um número inteiro, leia como texto e verifique se é "sair"
	                String opcaoTexto = scanner.next();
	                if (opcaoTexto.equalsIgnoreCase("sair")) {
	                    jogando = false;
	                } else {
	                    System.out.println("Opção inválida.");
	                }
	            }
	        }

	        scanner.close();
	    }
}

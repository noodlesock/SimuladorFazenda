import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SimuladorFazenda {
    private int dinheiro;
    private int terreno;
    private Map<String, Integer> plantacoes;
    private List<String> animais;

    public SimuladorFazenda(int dinheiro, int terreno) {
        this.dinheiro = dinheiro;
        this.terreno = terreno;
        this.plantacoes = new HashMap<>();
        this.animais = new ArrayList<>();
    }

    public void plantar(String plantacao, int quantidade) {
        int custo = quantidade * getCustoPlantacao(plantacao);
        if (custo <= dinheiro && terreno >= quantidade) {
            dinheiro -= custo;
            terreno -= quantidade;
            plantacoes.put(plantacao, plantacoes.getOrDefault(plantacao, 0) + quantidade);
            System.out.println("Você plantou " + quantidade + " unidades de " + plantacao + ".");
        } else {
            System.out.println("Recursos insuficientes para plantar.");
        }
    }

    public void colher(String plantacao, int quantidade) {
        if (plantacoes.containsKey(plantacao)) {
            int colheita = Math.min(quantidade, plantacoes.get(plantacao));
            plantacoes.put(plantacao, plantacoes.get(plantacao) - colheita);
            dinheiro += colheita * getPrecoPlantacao(plantacao);
            terreno += colheita;
            System.out.println("Você colheu " + colheita + " unidades de " + plantacao + ".");
        } else {
            System.out.println("Você não possui essa plantação plantada.");
        }
    }

    public void comprarAnimal(String animal) {
        int custo = getCustoAnimal(animal);
        if (custo <= dinheiro) {
            dinheiro -= custo;
            animais.add(animal);
            System.out.println("Você comprou um " + animal + ".");
        } else {
            System.out.println("Recursos insuficientes para comprar " + animal + ".");
        }
    }

    public void alimentarAnimais() {
        int custoTotal = 0;
        for (String animal : animais) {
            custoTotal += getCustoAlimentacao(animal);
        }
        if (custoTotal <= dinheiro) {
            dinheiro -= custoTotal;
            System.out.println("Animais alimentados com sucesso!");
        } else {
            System.out.println("Recursos insuficientes para alimentar os animais.");
        }
    }

    public void exibirStatus() {
        System.out.println("Dinheiro: $" + dinheiro);
        System.out.println("Terreno disponível: " + terreno + " unidades");
        System.out.println("Plantações plantadas: " + plantacoes);
        System.out.println("Animais: " + animais);
    }

    private int getCustoPlantacao(String plantacao) {
        // Implementação fictícia dos custos de cada plantação
        if (plantacao.equals("trigo")) {
            return 10;
        } else if (plantacao.equals("milho")) {
            return 15;
        } else {
            return 0;
        }
    }

    private int getPrecoPlantacao(String plantacao) {
        // Implementação fictícia dos preços de cada plantação na colheita
        if (plantacao.equals("trigo")) {
            return 5;
        } else if (plantacao.equals("milho")) {
            return 8;
        } else {
            return 0;
        }
    }

    private int getCustoAnimal(String animal) {
        // Implementação fictícia dos custos de cada animal
        if (animal.equals("vaca")) {
            return 50;
        } else if (animal.equals("porco")) {
            return 40;
        } else {
            return 0;
        }
    }

    private int getCustoAlimentacao(String animal) {
        // Implementação fictícia dos custos de alimentação de cada animal
        if (animal.equals("vaca")) {
            return 20;
        } else if (animal.equals("porco")) {
            return 15;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimuladorFazenda fazenda = new SimuladorFazenda(1000, 50); // Dinheiro inicial: $1000, Terreno inicial: 50 unidades

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
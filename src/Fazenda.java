import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fazenda {
    private int dinheiro;
    private int terreno;
    private Map<String, Integer> plantacoes;
    private List<String> animais;

    public Fazenda(int dinheiro, int terreno) {
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
            System.out.println("Você plantou " + quantidade + " unidades de " + plantacao);
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

    public int getDinheiro() {
		return dinheiro;
	}

	public int getTerreno() {
		return terreno;
	}

	public Map<String, Integer> getPlantacoes() {
		return plantacoes;
	}

	public List<String> getAnimais() {
		return animais;
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
}
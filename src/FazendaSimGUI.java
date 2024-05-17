import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;

// Feito com WindowBuilder para Eclipse

public class FazendaSimGUI {

	private JFrame frameFazenda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FazendaSimGUI window = new FazendaSimGUI();
					window.frameFazenda.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FazendaSimGUI() {
		initialize();
	}

	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Fazenda jogo = new Fazenda(1000, 50);
		frameFazenda = new JFrame();
		frameFazenda.getContentPane().setBackground(new Color(245, 245, 245));
		frameFazenda.setResizable(false);
		frameFazenda.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frameFazenda.setTitle("Fazenda Simulator");
		frameFazenda.setBounds(100, 100, 380, 175);
		frameFazenda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameFazenda.getContentPane().setLayout(new MigLayout("", "[][][]", "[][][][]"));
		
		JLabel amtDinheiro = new JLabel("Dinheiro: " + jogo.getDinheiro());
		frameFazenda.getContentPane().add(amtDinheiro, "cell 0 0");
		JLabel amtAnimais = new JLabel("Terreno: " + jogo.getTerreno());
		frameFazenda.getContentPane().add(amtAnimais, "cell 1 0");
		
		JLabel tituloPlantação = new JLabel("Plantação");
		tituloPlantação.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tituloPlantação.setIcon(new ImageIcon(FazendaSimGUI.class.getResource("/img/planta.png")));
		frameFazenda.getContentPane().add(tituloPlantação, "cell 0 1,alignx center,aligny top");
		
		JLabel tituloAnimais = new JLabel("Animais");
		tituloAnimais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tituloAnimais.setIcon(new ImageIcon(FazendaSimGUI.class.getResource("/img/chicken.png")));
		frameFazenda.getContentPane().add(tituloAnimais, "cell 1 1,alignx center,aligny top");
		
		JLabel tituloOpcoes = new JLabel("Opções");
		tituloOpcoes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tituloOpcoes.setIcon(new ImageIcon(FazendaSimGUI.class.getResource("/img/ajustes.png")));
		frameFazenda.getContentPane().add(tituloOpcoes, "cell 2 1,alignx center,aligny top");
		
		JButton btnPlantar = new JButton("Plantar");
		btnPlantar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Object[] itens = { "trigo", "milho" };
			      Object selItem = JOptionPane.showInputDialog(null,
			          "Escolha algo a plantar: ", "Opção",
			              JOptionPane.INFORMATION_MESSAGE, null,
			                  itens, itens [0]);
			      int selValor = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade em número:"));
			      jogo.plantar(selItem.toString(), selValor);
			      amtDinheiro.setText("Dinheiro: " + jogo.getDinheiro());
			      amtAnimais.setText("Terreno: " + jogo.getTerreno());

			}
		});
		btnPlantar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frameFazenda.getContentPane().add(btnPlantar, "cell 0 2,growx,aligny top");
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					 Object[] itens = { "vaca", "porco" };
				      Object selItem = JOptionPane.showInputDialog(null,
				          "Escolha o animal a comprar: ", "Opção",
				              JOptionPane.INFORMATION_MESSAGE, null,
				                  itens, itens [0]);
				    jogo.comprarAnimal(selItem.toString());
					amtDinheiro.setText("Dinheiro: " + jogo.getDinheiro());
					amtAnimais.setText("Terreno: " + jogo.getTerreno());
			}
		});
		btnComprar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frameFazenda.getContentPane().add(btnComprar, "cell 1 2,growx,aligny top");
		
		JButton btnStatus = new JButton("Status");
		btnStatus.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			       JOptionPane.showMessageDialog(null,"Dinheiro: $" + jogo.getDinheiro() + "\n"+ 
			    		   "Terreno disponível: " + jogo.getTerreno() + " unidades\n" + 
			    		   "Plantações plantadas: " + jogo.getPlantacoes() + "\n" +  
			    		   "Animais: " + jogo.getAnimais(),
			    		   null, JOptionPane.DEFAULT_OPTION);
				amtDinheiro.setText("Dinheiro: " + jogo.getDinheiro());
				amtAnimais.setText("Terreno: " + jogo.getTerreno());
			}
		});
		frameFazenda.getContentPane().add(btnStatus, "cell 2 2,growx,aligny top");
		
		JButton btnColher = new JButton("Colher");
		btnColher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Object[] itens = { "trigo", "milho" };
			      Object selItem = JOptionPane.showInputDialog(null,
			          "Escolha algo a colher: ", "Opção",
			              JOptionPane.INFORMATION_MESSAGE, null,
			                  itens, itens [0]);
			    int selValor = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade:"));
			    jogo.colher(selItem.toString(), selValor);
				amtDinheiro.setText("Dinheiro: " + jogo.getDinheiro());
				amtAnimais.setText("Terreno: " + jogo.getTerreno());
			}
		});
		btnColher.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frameFazenda.getContentPane().add(btnColher, "cell 0 3,growx,aligny top");
		
		JButton btnAlimento = new JButton("Alimentar");
		btnAlimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAlimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    jogo.alimentarAnimais();
				amtDinheiro.setText("Dinheiro: " + jogo.getDinheiro());
				amtAnimais.setText("Terreno: " + jogo.getTerreno());
			}
		});
		frameFazenda.getContentPane().add(btnAlimento, "cell 1 3,growx,aligny top");
	}

	
}

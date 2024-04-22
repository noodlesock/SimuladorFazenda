import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

// Feito com WindowBuilder para Eclipse

public class Fazendinha {

	private JFrame frameFazenda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fazendinha window = new Fazendinha();
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
	public Fazendinha() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameFazenda = new JFrame();
		frameFazenda.setResizable(false);
		frameFazenda.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frameFazenda.setTitle("Fazenda Simulator");
		frameFazenda.setBounds(100, 100, 380, 175);
		frameFazenda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameFazenda.getContentPane().setLayout(new MigLayout("align 50% 50%", "", ""));
		
		JLabel tituloPlantação = new JLabel("Plantação");
		tituloPlantação.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tituloPlantação.setIcon(new ImageIcon(Fazendinha.class.getResource("/img/planta.png")));
		frameFazenda.getContentPane().add(tituloPlantação, "cell 0 0,alignx center,aligny top");
		
		JLabel tituloAnimais = new JLabel("Animais");
		tituloAnimais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tituloAnimais.setIcon(new ImageIcon(Fazendinha.class.getResource("/img/chicken.png")));
		frameFazenda.getContentPane().add(tituloAnimais, "cell 1 0,alignx center,aligny top");
		
		JLabel tituloOpcoes = new JLabel("Opções");
		tituloOpcoes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tituloOpcoes.setIcon(new ImageIcon(Fazendinha.class.getResource("/img/configur.png")));
		frameFazenda.getContentPane().add(tituloOpcoes, "cell 2 0,alignx center,aligny top");
		
		JButton btnPlantar = new JButton("Plantar");
		btnPlantar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frameFazenda.getContentPane().add(btnPlantar, "cell 0 1,growx,aligny top");
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frameFazenda.getContentPane().add(btnComprar, "cell 1 1,growx,aligny top");
		
		JButton btnStatus = new JButton("Status");
		btnStatus.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frameFazenda.getContentPane().add(btnStatus, "cell 2 1,growx,aligny top");
		
		JButton btnColher = new JButton("Colher");
		btnColher.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frameFazenda.getContentPane().add(btnColher, "cell 0 2,growx,aligny top");
		
		JButton btnAlimento = new JButton("Alimentar");
		btnAlimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAlimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frameFazenda.getContentPane().add(btnAlimento, "cell 1 2,growx,aligny top");
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frameFazenda.getContentPane().add(btnSair, "cell 2 2,growx,aligny top");
	}

}

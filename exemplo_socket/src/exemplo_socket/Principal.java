package exemplo_socket;

import javax.swing.JOptionPane;

public class Principal {
		public static void main(String[] args) {
			
			Aluno x = new Aluno();
			x.nome ="Molina";
			x.idade = 40;
			
			Aluno y = new Aluno();
			y.nome = "Joao";
			y.idade = 26;
			
			Aluno z = new Aluno();
			z.nome = JOptionPane.showInputDialog("Informe seu nome:");
			z.idade = Integer.valueOf(JOptionPane.showInputDialog("Informe sua Idade:"));

			System.out.println(y.nome);
			
		}
}

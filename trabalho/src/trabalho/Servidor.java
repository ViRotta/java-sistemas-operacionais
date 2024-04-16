package trabalho;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor {
	
	private ServerSocket serverSocket;
	
	public void criarServerSocket (int porta) throws IOException {
		serverSocket = new ServerSocket(porta); 
	}
	
	public Socket esperarConexao() throws IOException{
		Socket s = serverSocket.accept();
		return s;
	}
	
	public void trataConexao(Socket s) throws IOException {
		ObjectOutputStream output = new ObjectOutputStream(s.getOutputStream());
		ObjectInputStream input = new ObjectInputStream(s.getInputStream());
		
		//Definição do protocolo de comunicação
		//cliente: Olá 
		//Servidor: Olá mundo
		String msg = input.readUTF();
		System.out.println("Mensagem recebida:" + msg);
		if(msg.equals("Olá")) {
			output.writeUTF(msg + " Mundo!");
		}
		
		output.flush(); //commit : amplique o qua vc
		input.close(); //fechando comunicação: canal de entrada e saida
		output.close();//fechando comunicação: canal de entrada e saida
		
	}
	
	public void fecharConexao() throws IOException {
		serverSocket.close();
		
	}
	
	public static void main(String[] args) {
		
		try {
			Servidor servidor =  new Servidor();
			System.out.println("Aguardando conexão...");
			servidor.criarServerSocket(5555);
			while(true) {
				Socket socket = servidor.esperarConexao();
				System.out.println("Cliente conectado!");
				servidor.trataConexao(socket);
				System.out.println("Cliente finalizado!");
				//servidor.fecharConexao();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	

}

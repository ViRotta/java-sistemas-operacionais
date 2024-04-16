package trabalho;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
	
	public static void main(String[] args) {
		
		try {
			
			String host = "localhost";
			int porta = 5555;
			Socket s = new Socket(host, porta);
			
			//Conexão 
			ObjectOutputStream output = 
					new ObjectOutputStream(s.getOutputStream());
			ObjectInputStream input = 
					new ObjectInputStream(s.getInputStream());
			
			output.writeUTF("Olá");
			output.flush(); //"envie a mensagem"
			
			String mensageTratada = input.readUTF();
			System.out.println(mensageTratada);
			
		//Com o código cima starta o servidor
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

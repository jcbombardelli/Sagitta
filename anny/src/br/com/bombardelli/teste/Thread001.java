package br.com.bombardelli.teste;
 
import java.util.Scanner;

import br.com.anny.core.SingletonThread;
import br.com.bombardelli.emulacao.TemperaturaAleatoria;
import br.com.bombardelli.emulacao.UmidadeAleatoria;


public class Thread001 { 


	public static void main(String[] args) { 

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		
		String op = null;

		do{
			try {
				montaMenuConsole();
				op = input.nextLine();
				;
				switch (Integer.parseInt(op)) {
				case 1:
					SingletonThread.novaThread(new TemperaturaAleatoria(), "geraAleatorio");
					break;
				case 2:
					SingletonThread.novaThread(new UmidadeAleatoria(),"geraAleatorio");
					break;
				case 9:
					for(Thread t : SingletonThread.getListaThreads())
						t.run();
				default:
					break;
				}

			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}



		}while(!op.equals("0"));
	} 


	private static void montaMenuConsole(){
		System.out.println("Escolha uma Opção...");
		System.out.println("1 - Monitorar Temperatura");
		System.out.println("2 - Monitorar Umidade");
		System.out.println("9 - Executa todas as threads");
		System.out.println("0 - Sair");
	}

}

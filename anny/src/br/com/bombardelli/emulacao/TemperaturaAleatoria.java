package br.com.bombardelli.emulacao;
import java.util.Random;


public class TemperaturaAleatoria {

	private static Random r = new Random();
	static final String FRASE_TEMPERATURA = "Temperatura atual : ";

	public static void geraAleatorio(){
		System.out.println(FRASE_TEMPERATURA +  r.nextInt(50));
	}

}

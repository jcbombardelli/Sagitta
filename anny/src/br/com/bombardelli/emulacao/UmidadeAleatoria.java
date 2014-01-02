package br.com.bombardelli.emulacao;

import java.util.Random;


public class UmidadeAleatoria {

	private static Random r = new Random();
	static final String FRASE_UMIDADE = "Umidade Atual : ";

	public static void geraAleatorio(){
		System.out.println(FRASE_UMIDADE + r.nextInt(100));
	}


}

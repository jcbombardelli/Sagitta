package br.com.bombardelli.teste;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TesteProperties {

	public static void main(String[] args) {
		
		// o arquivo encontra-se no mesmo diret�rio //da aplica��o  
		File file = new File("arduino.properties");      
		Properties props = new Properties();  
		FileInputStream fis = null;  
		try {  
		    fis = new FileInputStream(file);  
		    //l� os dados que est�o no arquivo  
		    props.load(fis);    
		    fis.close();  
		}  
		catch (IOException ex) {  
		    System.out.println(ex.getMessage());  
		    ex.printStackTrace();  
		} 
		

		System.out.println(props.getProperty("Porta"));
	}

}

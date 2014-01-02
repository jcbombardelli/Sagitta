package br.com.anny.core.raspberry;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//import raspberrry.tcpip.ConexaoIP;

public class PropriedadesRaspberry {

/*	public static void main(String args[]){
		gravaProriedadesRaspberry();
	}
	
	private static void gravaProriedadesRaspberry(){
		try {
			List<String> lista = new ArrayList<String>(propriedadesJava());

			File file = new File("raspberry.properties");      
			Properties props = new Properties();  

			for(String nome : lista){
				String valor = System.getProperty(nome) != null ? System.getProperty(nome) : "null";
				props.setProperty(nome, valor);
			}
			
			ConexaoIP cip = new ConexaoIP();
			props.setProperty("IP_Local", cip.getIpLocal());
			props.setProperty("IP_Dispositivo", cip.getIpInternet());
			props.setProperty("Nome_Dispositivo", cip.getDispositivo());
			props.setProperty("Nome_Placa", cip.getNomeDaPlaca());

			FileOutputStream fos = new FileOutputStream(file);  
			props.store(fos, "Configurações Gerais informadas pelo RaspberryPI"); 
			fos.flush();
			fos.close();
		}  
		catch (IOException e) {  
			System.out.println(e.getMessage());  
			e.printStackTrace();  
		} 

	}

	private static List<String> propriedadesJava(){
		List<String> lista = new ArrayList<String>();
		lista.add("awt.toolkit");
		lista.add("file.encoding.pkg");
		lista.add("file.encoding");		
		lista.add("file.separador");
		lista.add("java.awt.graphicsenv");
		lista.add("java.awt.printerjob");
		lista.add("java.class.path");
		lista.add("java.class.version");
		lista.add("java.compiler");
		lista.add("java.endorsed.dirs");
		lista.add("java.ext.dirs");
		lista.add("java.home");
		lista.add("java.io.tempdir");
		lista.add("java.library.path");
		lista.add("java.runtime.name");
		lista.add("java.runtime.version");
		lista.add("java.specification.name");
		lista.add("java.specification.vendor");
		lista.add("java.specification.version");
		lista.add("java.vendor");
		lista.add("java.vendor.url");
		lista.add("java.vendor.url.bug");
		lista.add("java.version");
		lista.add("java.vm.specification.name");
		lista.add("java.vm.specification.vendeor");
		lista.add("java.vm.specification.version");
		lista.add("java.vm.info");
		lista.add("java.vm.name");
		lista.add("java.vm.vendor");
		lista.add("java.vm.version");
		lista.add("line.separator");
		lista.add("os.name");
		lista.add("os.arch");
		lista.add("os.version");
		lista.add("path.separator");
		lista.add("sun.boot.class.path");
		lista.add("sun.io.unicode.encoding");
		lista.add("sun.cpu.endian");
		lista.add("sun.desktop");
		lista.add("sun.cpu.isalist");
		lista.add("sun.java.command");
		lista.add("sun.arch.data.model");
		lista.add("sun.java.launcher");
		lista.add("sun.os.patch.level");
		lista.add("sun.jnu.encoding");
		lista.add("sun.boot.library.path");
		lista.add("sun.management.compiler");
		lista.add("user.name");
		lista.add("user.home");
		lista.add("user.dir");
		lista.add("user.country");
		lista.add("user.script");
		lista.add("user.variant");		
		lista.add("user.home");
		lista.add("user.timezone");
		lista.add("user.language");
		
		return lista;

	}*/
}

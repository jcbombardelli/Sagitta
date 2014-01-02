package br.com.anny.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class SuperAnny {

	private static final String ANNY_PROPERTIES="./anny.properties";
	private static final SimpleDateFormat formataData = new SimpleDateFormat("dd/mm/yyy");
	private static final SimpleDateFormat formataHora = new SimpleDateFormat("hh:mm:ss");
	private static Properties properties;

	public static void main(String arg[]) throws IOException{
		configuraAnnyProperties();;
	}


	private static void criaAnnyProperties() throws IOException {
		Date iniciandoSistema = new Date();
		properties = new Properties();
		properties.setProperty("anny.time.data", formataData.format(iniciandoSistema));
		properties.setProperty("anny.time.hora", formataHora.format(iniciandoSistema));
		properties.setProperty("anny.flag.configurado", "0");
		FileOutputStream fos = new FileOutputStream(new File(ANNY_PROPERTIES));
		properties.store(fos, "Configurações do Sistema ANNY");
		fos.flush();
		fos.close();
	}

	public static void configuraAnnyProperties() throws IOException{
		try {
			FileInputStream fis = new FileInputStream(ANNY_PROPERTIES);
			properties = new Properties();
			properties.load(fis);
			fis.close();			
		} catch (FileNotFoundException e) {
			criaAnnyProperties();
			configuraAnnyProperties();
		}

		List<String> propriedadesJavaRaspberry = new ArrayList<String>(getPropriedadesJava());
		ConexaoTCPIP tcpIp = new ConexaoTCPIP();


		if(properties.getProperty("anny.flag.configurado").equals("0")){

			for(String nome : propriedadesJavaRaspberry)
				properties.setProperty(nome, System.getProperty(nome) != null ? System.getProperty(nome) : "null");

			//TODO verificar sistema operacional e copiar os aquivos corretos de acordo com o S.O
			//Lib RXTX e o que mais for necessario para o sistema funcionar adequadamente
			//Pensar na probabiliadde de utilziar phyton ou node.js para confiurar em tempo de execução
			//Tentar tormar o mais auto-gerenciavel o possivel


			//TODO Tratar exceções em ConexaoTCPIP
			properties.setProperty("anny.raspberry.placa", tcpIp.getNomeDaPlaca());
			properties.setProperty("anny.raspberry.ethernet", tcpIp.getIpLocal());
			properties.setProperty("anny.raspberry.internet", tcpIp.getIpInternet());

			properties.setProperty("anny.arduino.porta", "null");
			properties.setProperty("anny.arduino.baudrate", "null");
			properties.setProperty("anny.arduino.serial", "null");

		}else if(properties.getProperty("anny.flag.configurado").equals("1")){

			if(!properties.getProperty("java.runtime.version").equals(System.getProperty("java.runtime.version")))
				for(String nome : propriedadesJavaRaspberry)
					properties.setProperty(nome, System.getProperty(nome) != null ? System.getProperty(nome) : "null");

			if(!properties.getProperty("anny.raspberry.placa").equals(tcpIp.getNomeDaPlaca()))
				properties.setProperty("anny.raspberry.placa", tcpIp.getNomeDaPlaca());

			if(!properties.getProperty("anny.raspberry.ethernet").equals(tcpIp.getIpLocal()))
				properties.setProperty("anny.raspberry.ethernet", tcpIp.getIpLocal());

			if(!properties.getProperty("anny.raspberry.internet").equals(tcpIp.getIpInternet()))
				properties.setProperty("anny.raspberry.internet", tcpIp.getIpInternet());

			if(!properties.getProperty("anny.arduino.porta").equals("null")){
				//TODO Estabelecer Conexao
			}


		}
		else{
			//possivel falha de segurança ou algoritmo, deverá ser gerado um "log"
			criaAnnyProperties();
			configuraAnnyProperties();
		}

		properties.setProperty("anny.flag.configurado", "1");
		FileOutputStream fos = new FileOutputStream(ANNY_PROPERTIES);
		properties.store(fos, "Configurações do Sistema ANNY");
		fos.close();




	}

	private static List<String> getPropriedadesJava(){
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
	}


}



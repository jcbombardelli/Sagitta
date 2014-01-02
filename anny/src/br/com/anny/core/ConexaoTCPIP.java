package br.com.anny.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.util.Enumeration;

public class ConexaoTCPIP {

	private String nomeDaPlaca;
	private String ipLocal;
	private String ipInternet;
	private String dispositivo;
	private final static String URLCheckIP = "http://checkip.amazonaws.com";

	public String getNomeDaPlaca() {
		return nomeDaPlaca;
	}
	private void setNomeDaPlaca(String nomeDaPlaca) {
		this.nomeDaPlaca = nomeDaPlaca;
	}
	public String getIpLocal() {
		return ipLocal;
	}
	private void setIpLocal(String ipLocal) {
		this.ipLocal = ipLocal;
	}
	public String getIpInternet() {
		return ipInternet;
	}
	private void setIpInternet(String ipInternet) {
		this.ipInternet = ipInternet;
	}
	public String getDispositivo() {
		return dispositivo;
	}
	private void setDispositivo(String dispositivo) {
		this.dispositivo = dispositivo;
	}


	private static String getIpExterno() throws Exception {
		URL meuIP = new URL(URLCheckIP);
		BufferedReader in = null;

		try {			
			in = new BufferedReader(new InputStreamReader(meuIP.openStream()));
			return in.readLine();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public ConexaoTCPIP(){
		try {
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

			while (interfaces.hasMoreElements()) {
				NetworkInterface iface = interfaces.nextElement();
				if (iface.isLoopback() || !iface.isUp() || iface.isVirtual())
					continue;

				Enumeration<InetAddress> enderecos = iface.getInetAddresses();
				while(enderecos.hasMoreElements()) {
					InetAddress ender = enderecos.nextElement();

					//Garante que somente o endereço de IPV4 seja listado
					if(ender.getHostAddress().length() > 0  && ender.getHostAddress().length() <= 15 ){
						//Garante que somente portas Windows e as primeiras portas de LAN e WAN no Linux sejam listadas
						if(iface.getName().substring(0, 3).equals("net") || iface.getName().equals("eth0") || iface.getName().equals("wlan0")){						
							setNomeDaPlaca(iface.getDisplayName());
							setDispositivo(iface.getName());
							setIpLocal(ender.getHostAddress());
						}
					}
				}
			}
		} catch (SocketException e) {
			throw new RuntimeException(e);
		}

		try {
			//Busca o IP atachado no roteador
			setIpInternet(getIpExterno());
		} catch (Exception e) {
			setIpInternet("Sem Conexão de Internet Ativa");
			e.printStackTrace();
		}
	}
}

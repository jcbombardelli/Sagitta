package br.com.anny.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class SingletonThread {

	private static SingletonThread instancia;
	private static List<Thread> listaThreads = new ArrayList<Thread>();	
	private SingletonThread() {}	

	public static List<Thread> getListaThreads() {
		return listaThreads;
	}

	public static SingletonThread getInstancia(){
		return instancia = instancia == null ? new SingletonThread() : instancia;
	}


	//TODO Estipular melhor a regra que envolve o "Object o"	
	public static void novaThread(final Object o, final String metodo ){

		getListaThreads().add(new Thread(){

			@Override
			public void run() {			
				try {
					Method method = null;
					method = o.getClass().getMethod(metodo);
					method.invoke(o);
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void terminaThread(final String thread){
		
	}



}

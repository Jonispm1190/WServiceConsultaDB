package com.jon.examen.ws;

import javax.xml.ws.Endpoint;


public class obtenerPorIdPublisher {

	public static void main(String[] args) {  
		  Endpoint.publish("http://localhost:8080/WS/obtnerPorIdInterface",new obtenerPorIdImplements());  
		 }  
}

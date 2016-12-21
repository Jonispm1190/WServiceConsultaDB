package com.jon.examen.ws;



import java.util.List;

import javax.jws.WebService;

import com.jon.examen.control.User;
import com.jon.examen.modelo.consultas;

@WebService(endpointInterface="com.jon.examen.ws.obtenerPorIdInterface")  
public class obtenerPorIdImplements implements obtenerPorIdInterface {

	@Override
	public User UsuarioPorId(int id) {
		return consultas.getRecordById(id);
	}

	@Override
	public List<User> TodosLosUsuarios() {
		
		return consultas.getAllRecords();
	}

}

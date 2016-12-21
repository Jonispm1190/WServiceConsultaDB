package com.jon.examen.ws;


import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import com.jon.examen.control.User;

@WebService  
public interface obtenerPorIdInterface {
	@WebMethod public User UsuarioPorId(int id);
	@WebMethod public List<User> TodosLosUsuarios();
}

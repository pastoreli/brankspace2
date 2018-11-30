package fateczl.blankspace.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import fateczl.blankspace.boundary.App;
import fateczl.blankspace.dao.DaoUsuario;
import fateczl.blankspace.entity.Usuario;

public class AcessoController {

	public Usuario logar(String email, String senha) {
		
		DaoUsuario daoUsuario = new DaoUsuario();
		
		Usuario usuario = daoUsuario.logar(email, passwordEncryption(senha));
		
		App.usuario = usuario;
		
		return usuario;
		
	}
	
	public void logout() {
		
	}
	
	public static String passwordEncryption(String password){
		
		MessageDigest algorithm = null;
		try {
			algorithm = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		byte messageDigest[] = null;
		
		try {
			messageDigest = algorithm.digest(password.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		 
		StringBuilder hexString = new StringBuilder();
		
		for (byte b : messageDigest) {
			hexString.append(String.format("%02X", 0xFF & b));
		}
		 
		return hexString.toString();
		
	}
	
}

package fateczl.blankspace.controller;

import java.util.ArrayList;
import java.util.List;

import fateczl.blankspace.dao.DaoUsuario;
import fateczl.blankspace.entity.Usuario;

public class UsuarioController {

	DaoUsuario daoUsuario = new DaoUsuario();
	
	public List<Usuario> listarSeguidores(Usuario usuario) {
		return daoUsuario.listarSeguidoresSeguintes(usuario, 0);
	}
	
	public List<Usuario> listarSeguintes(Usuario usuario) {
		return daoUsuario.listarSeguidoresSeguintes(usuario, 1);
	}
	
	public boolean isSeguindo(Usuario seguidor, Usuario seguinte) {
		return daoUsuario.isSeguindo(seguidor, seguinte);
	}
	
	public int contarPublicacoes(Usuario usuario) {
		return daoUsuario.contarPublicacoes(usuario);
	}
	
	public int contarSeguidores(Usuario usuario) {
		return daoUsuario.contarSeguidores(usuario, 0);
	}
	
	public int contarSeguintes(Usuario usuario) {
		return daoUsuario.contarSeguidores(usuario, 1);
	}
	
	public List<Usuario> pesquisarUsuario(String pesquisa, int idUsuario) {
		return daoUsuario.pesquisarUsuario(pesquisa, idUsuario);
	}
	
	public boolean seguirUsuario(Usuario seguidor, Usuario seguido) {
		return daoUsuario.seguirUsuario(seguidor, seguido);
	}
	
	public boolean removerSeguidor(Usuario seguido, Usuario seguidor) {
		return daoUsuario.desvincularUsuario(seguido, seguidor);
	}
	
	public boolean deixarDeSeguirUsuario(Usuario seguidor, Usuario seguido) {
		return daoUsuario.desvincularUsuario(seguidor, seguido);
	}
	
	public Usuario cadastrarUsuario(Usuario usuario) {
		usuario.setSenha(AcessoController.passwordEncryption(usuario.getSenha()));
		return daoUsuario.cadastrarUsuario(usuario);
	}
	
	public Usuario editarUsuario(Usuario usuario) {
		return null;
	}
	
	public boolean removerUsuario(Usuario usuario) {
		return false;
	}
	
}

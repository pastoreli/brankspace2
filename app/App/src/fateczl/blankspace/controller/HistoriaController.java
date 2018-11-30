package fateczl.blankspace.controller;

import java.util.ArrayList;
import java.util.List;

import fateczl.blankspace.boundary.App;
import fateczl.blankspace.dao.DaoHistoria;
import fateczl.blankspace.entity.Colecao;
import fateczl.blankspace.entity.Historia;
import fateczl.blankspace.entity.Publicacao;
import fateczl.blankspace.entity.Usuario;

public class HistoriaController implements PublicacaoController{

	DaoHistoria daoHistoria = new DaoHistoria();
	
	@Override
	public List<Publicacao> listarPublicacoesFeed(Usuario usuario) {
		return daoHistoria.listarPublicacoesFeed(usuario);
	}

	@Override
	public List<Publicacao> listarPublicacoesUsuario(Usuario usuario, int statusPublicacao) {
		return daoHistoria.listarPublicacoesUsuario(usuario, statusPublicacao);
	}

	@Override
	public List<Publicacao> listarFavoritosUsuario(Usuario usuario) {
		return daoHistoria.listarFavoritosUsuario(usuario);
	}

	@Override
	public List<Publicacao> listarPublicacoesParentes(Publicacao publicacao) {
		return daoHistoria.listarPublicacoesParentes(publicacao);
	}

	@Override
	public List<Publicacao> pesquisarPublicacoes(String pesquisa) {
		return daoHistoria.pesquisarPublicacoes(pesquisa);
	}

	@Override
	public boolean criarPublicacao(Publicacao publicacao, int idUsuario, int statusPublicacao) {
		return daoHistoria.criarPublicacao(publicacao, idUsuario, statusPublicacao);
	}

	@Override
	public Publicacao editarPublicacao(Publicacao publicacao) {
		// TODO Auto-generated method stub
		return daoHistoria.editarPublicacao(publicacao);
	}

	@Override
	public boolean removerPublicacao(Publicacao publicacao) {
		return daoHistoria.removerPublicacao(publicacao);
	}

	@Override
	public boolean adicionarPublicacaoFavorito(Publicacao publicacao, Usuario usuario) {
		return daoHistoria.adicionarPublicacaoFavorito(publicacao, usuario);
	}

	@Override
	public boolean removerPublicacaoFavorito(Publicacao publicacao, Usuario usuario) {
		return daoHistoria.removerPublicacaoFavorito(publicacao, usuario);
	}

	@Override
	public boolean isFavorito(Publicacao publicacao, Usuario usuario) {
		return daoHistoria.isFavorito(publicacao, usuario);
	}

}

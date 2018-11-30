package fateczl.blankspace.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import fateczl.blankspace.boundary.App;
import fateczl.blankspace.dao.DaoColecao;
import fateczl.blankspace.entity.Colecao;
import fateczl.blankspace.entity.Publicacao;
import fateczl.blankspace.entity.Usuario;

public class ColecaoController implements PublicacaoController{

	DaoColecao daoColecao = new DaoColecao();
	
	@Override
	public List<Publicacao> listarPublicacoesFeed(Usuario usuario) {
		return daoColecao.listarPublicacoesFeed(usuario);
	}

	@Override
	public List<Publicacao> listarPublicacoesUsuario(Usuario usuario, int statusPublicacao) {
		return daoColecao.listarPublicacoesUsuario(usuario, statusPublicacao);
	}

	@Override
	public List<Publicacao> listarFavoritosUsuario(Usuario usuario) {
		return daoColecao.listarFavoritosUsuario(usuario);
	}

	@Override
	public List<Publicacao> listarPublicacoesParentes(Publicacao publicacao) {
		return null;
	}

	@Override
	public List<Publicacao> pesquisarPublicacoes(String pesquisa) {
		return daoColecao.pesquisarPublicacoes(pesquisa);
	}

	@Override
	public boolean criarPublicacao(Publicacao publicacao, int idUsuario, int statusPublicacao) {
		return daoColecao.criarPublicacao(publicacao, idUsuario, statusPublicacao);
	}

	@Override
	public Publicacao editarPublicacao(Publicacao publicacao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removerPublicacao(Publicacao publicacao) {
		return daoColecao.removerPublicacao(publicacao);
	}

	@Override
	public boolean adicionarPublicacaoFavorito(Publicacao publicacao, Usuario usuario) {
		return daoColecao.adicionarPublicacaoFavorito(publicacao, usuario);
	}

	@Override
	public boolean removerPublicacaoFavorito(Publicacao publicacao, Usuario usuario) {
		return daoColecao.removerPublicacaoFavorito(publicacao, usuario);
	}

	@Override
	public boolean isFavorito(Publicacao publicacao, Usuario usuario) {
		return daoColecao.isFavorito(publicacao, usuario);
	}

}

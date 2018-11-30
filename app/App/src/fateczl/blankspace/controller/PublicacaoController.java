package fateczl.blankspace.controller;

import java.util.List;

import fateczl.blankspace.entity.Publicacao;
import fateczl.blankspace.entity.Usuario;

public interface PublicacaoController {

	public List<Publicacao> listarPublicacoesFeed(Usuario usuario);
	
	public List<Publicacao> listarPublicacoesUsuario(Usuario usuario, int statusPublicacao);
	
	public List<Publicacao> listarFavoritosUsuario(Usuario usuario);
	
	public List<Publicacao> listarPublicacoesParentes(Publicacao publicacao);
	
	public List<Publicacao> pesquisarPublicacoes(String pesquisa);
	
	public boolean criarPublicacao(Publicacao publicacao, int idUsuario, int statusPublicacao);
	
	public Publicacao editarPublicacao(Publicacao publicacao);
	
	public boolean removerPublicacao(Publicacao publicacao);
	
	public boolean adicionarPublicacaoFavorito(Publicacao publicacao, Usuario usuario);
	
	public boolean removerPublicacaoFavorito(Publicacao publicacao, Usuario usuario);
	
	public boolean isFavorito(Publicacao publicacao, Usuario usuario);
	
}

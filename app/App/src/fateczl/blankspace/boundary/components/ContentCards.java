package fateczl.blankspace.boundary.components;

import fateczl.blankspace.boundary.App;
import fateczl.blankspace.controller.ColecaoController;
import fateczl.blankspace.controller.HistoriaController;
import fateczl.blankspace.controller.UsuarioController;
import fateczl.blankspace.entity.Colecao;
import fateczl.blankspace.entity.Historia;
import fateczl.blankspace.entity.Publicacao;
import fateczl.blankspace.entity.Usuario;
import javafx.scene.layout.GridPane;

public class ContentCards extends GridPane{
	
	HistoriaController historiaController = new HistoriaController();
	ColecaoController colecaoController = new ColecaoController();
	UsuarioController usuarioController = new UsuarioController();
	
	public ContentCards(Usuario usuario, int type/*0 feed collection, 1 feed history, 2 collection, 3 hitory, 4 users 5 favorites*/, int status, String search, Colecao colecao) {
		
		setHgap(10);
		setVgap(10);
		
		if(type == 0) {
			int c = 0, l = 0;
			int count = 0;
			for(Publicacao i : colecaoController.listarPublicacoesFeed(usuario)) {
				add(new CardCollection((Colecao)i), l, c);
				if(l < 3) {
					l++;
				}else {
					c++;
					l=0;
				}
			}
		}
		
		if(type == 1) {
			int c = 0, l = 0;
			int count = 0;
			for(Publicacao i : historiaController.listarPublicacoesFeed(usuario)) {
				add(new CardHistory((Historia)i), l, c);
				if(l < 3) {
					l++;
				}else {
					c++;
					l=0;
				}
			}
		}
		
		if(type == 2) {
			
			if(usuario == App.usuario && status != 3 && search == null) add(new CardCreateCollection(status), 0, 0);
			
			int c = 0, l = usuario == App.usuario && status != 3 && search == null? 1 : 0;
			for(Publicacao i : search== null
					? colecaoController.listarPublicacoesUsuario(usuario, status) 
					: colecaoController.pesquisarPublicacoes(search)) {
				add(new CardCollection((Colecao)i), l, c);
				if(l < 3) {
					l++;
				}else {
					c++;
					l=0;
				}
			}
		}
		
		if(type == 3) {
			
			int c = 0, l = 0;
			int count = 0;
			for(Publicacao i : search == null 
					? (colecao == null 
							?historiaController.listarPublicacoesUsuario(usuario, status)
							: historiaController.listarPublicacoesParentes(colecao))
					: (historiaController.pesquisarPublicacoes(search))) {
				add(new CardHistory((Historia)i), l, c);
				if(l < 3) {
					l++;
				}else {
					c++;
					l=0;
				}
			}
		}
		
		if(type == 4) {
			
			int c = 0, l = 0;
			for(Usuario i : usuarioController.pesquisarUsuario(search, usuario.getId())) {
				add(new CardUser(i), l, c);
				if(l < 3) {
					l++;
				}else {
					c++;
					l=0;
				}
			}
		}
		
		if(type == 5) {
			int c = 0, l = 0;
			int count = 0;
			for(Publicacao i : historiaController.listarFavoritosUsuario(usuario)) {
				add(new CardHistory((Historia)i), l, c);
				if(l < 3) {
					l++;
				}else {
					c++;
					l=0;
				}
			}
		}
		
		if(type == 6) {
			int c = 0, l = 0;
			int count = 0;
			for(Publicacao i : colecaoController.listarFavoritosUsuario(usuario)) {
				add(new CardCollection((Colecao)i), l, c);
				if(l < 3) {
					l++;
				}else {
					c++;
					l=0;
				}
			}
		}
		
	}
	
}

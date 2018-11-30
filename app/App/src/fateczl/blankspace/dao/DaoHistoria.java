package fateczl.blankspace.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import fateczl.blankspace.entity.Colecao;
import fateczl.blankspace.entity.Historia;
import fateczl.blankspace.entity.Publicacao;
import fateczl.blankspace.entity.Usuario;

public class DaoHistoria implements DaoPublicacao{

	DBConnection dbConnection = new DBConnection();
	
	@Override
	public List<Publicacao> listarPublicacoesFeed(Usuario usuario){
		
		List<Publicacao> listResult = new ArrayList<>();
		
		try {
			
			String query = "SELECT tbS.idUsuarioSeguidor, tbS.idUsuarioSeguinte, tbUP.idUsuario, tbUP.idPublicacao, tbUP.donoPublicacao, tbP.dataModificacao, DATE(tbP.dataModificacao) as date, tbP.statusPublicacao, tbH.idHistoria, tbH.tituloHistoria, tbH.conteudoHistoria, tbH.imagemHistoria, tbH.dataCriacao, tbH.idColecao"
					+ " FROM tbSeguidor as tbS"
					+ " INNER JOIN tbUsuarioPublicacao as tbUP ON tbS.idUsuarioSeguinte = tbUP.idUsuario"
					+ " INNER JOIN tbPublicacao as tbP ON tbUP.idPublicacao = tbP.idPublicacao"
					+ " INNER JOIN tbHistoria as tbH ON tbUP.idPublicacao = tbH.idPublicacao"
					+ " WHERE tbS.idUsuarioSeguidor = ? AND tbUP.donoPublicacao = 1 AND tbP.statusPublicacao = 1"
					+ " ORDER BY date DESC";
			
			PreparedStatement declaration = dbConnection.CONNECTION.prepareStatement(query);
			declaration.setInt(1, usuario.getId());
			
			ResultSet result = declaration.executeQuery();
			
			while(result.next()) {
				
				Historia historia = new Historia();
				historia.setIdPublicacao(result.getInt("tbUP.idPublicacao"));
				historia.setUsuario(usuario);
				historia.setTitulo(result.getString("tbH.tituloHistoria"));
				historia.setStatus(result.getInt("tbP.statusPublicacao"));
				historia.setDataCriacao(result.getDate("tbH.dataCriacao"));
				historia.setDataModificacao(result.getDate("tbP.DataModificacao"));
				historia.setTipoPublicacao(2 /*2 = history*/);
				historia.setConteudo(result.getString("tbH.conteudoHistoria"));
				historia.setImagem(result.getString("tbH.imagemHistoria"));
				historia.setIdUsuario(result.getInt("tbUP.idUsuario"));
				
				listResult.add(historia);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listResult;

	}
	
	@Override
	public List<Publicacao> listarPublicacoesUsuario(Usuario usuario, int statusPublicacao) {
		
		List<Publicacao> listResult = new ArrayList<>();
		
		try {
			
			String query = "SELECT tbUP.idUsuario, tbUP.idPublicacao, tbUP.donoPublicacao, tbP.DataModificacao, DATE(tbP.dataModificacao) as date, tbP.statusPublicacao, tbH.idHistoria, tbH.tituloHistoria, tbH.conteudoHistoria, tbH.imagemHistoria, tbH.dataCriacao, tbH.idColecao"
					+ " FROM tbUsuarioPublicacao as tbUP"
					+ " INNER JOIN tbHistoria as tbH ON tbUp.idPublicacao = tbH.idPublicacao"
					+ " INNER JOIN tbPublicacao as tbP ON tbUP.idPublicacao = tbP.idPublicacao"
					+ " WHERE tbUP.idUsuario = ? AND tbUP.donoPublicacao = 1 AND tbP.statusPublicacao = ?"
					+ " ORDER BY date DESC";
			
			PreparedStatement declaration = dbConnection.CONNECTION.prepareStatement(query);
			declaration.setInt(1, usuario.getId());
			declaration.setInt(2, statusPublicacao);
			
			ResultSet result = declaration.executeQuery();
			while(result.next()) {
				Historia historia = new Historia();
				historia.setIdPublicacao(result.getInt("tbUP.idPublicacao"));
				historia.setUsuario(usuario);
				historia.setTitulo(result.getString("tbH.tituloHistoria"));
				historia.setStatus(result.getInt("tbP.statusPublicacao"));
				historia.setDataCriacao(result.getDate("tbH.dataCriacao"));
				historia.setDataModificacao(result.getDate("tbP.DataModificacao"));
				historia.setTipoPublicacao(2 /*2 = history*/);
				historia.setConteudo(result.getString("tbH.conteudoHistoria"));
				historia.setImagem(result.getString("tbH.imagemHistoria"));
				historia.setIdUsuario(result.getInt("tbUP.idUsuario"));
				
				listResult.add(historia);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listResult;
		
	}
	
	@Override
	public List<Publicacao> listarFavoritosUsuario(Usuario usuario){
		List<Publicacao> listResult = new ArrayList<>();
		
		try {
			
			String query = "SELECT tbUP.idUsuario, tbUP.idPublicacao, tbUP.donoPublicacao, tbP.DataModificacao, DATE(tbP.dataModificacao) as date, tbP.statusPublicacao, tbH.idHistoria, tbH.tituloHistoria, tbH.conteudoHistoria, tbH.imagemHistoria, tbH.dataCriacao, tbH.idColecao"
					+ " FROM tbUsuarioPublicacao as tbUP"
					+ " INNER JOIN tbHistoria as tbH ON tbUp.idPublicacao = tbH.idPublicacao"
					+ " INNER JOIN tbPublicacao as tbP ON tbUP.idPublicacao = tbP.idPublicacao"
					+ " WHERE tbUP.idUsuario = ? AND tbUP.favoritoPublicacao = 1 AND tbP.statusPublicacao = 1"
					+ " ORDER BY date DESC";
			
			PreparedStatement declaration = dbConnection.CONNECTION.prepareStatement(query);
			declaration.setInt(1, usuario.getId());
			
			ResultSet result = declaration.executeQuery();
			while(result.next()) {
				
				Historia historia = new Historia();
				historia.setIdPublicacao(result.getInt("tbUP.idPublicacao"));
				historia.setUsuario(usuario);
				historia.setTitulo(result.getString("tbH.tituloHistoria"));
				historia.setStatus(result.getInt("tbP.statusPublicacao"));
				historia.setDataCriacao(result.getDate("tbH.dataCriacao"));
				historia.setDataModificacao(result.getDate("tbP.DataModificacao"));
				historia.setTipoPublicacao(2 /*2 = history*/);
				historia.setConteudo(result.getString("tbH.conteudoHistoria"));
				historia.setImagem(result.getString("tbH.imagemHistoria"));
				
				listResult.add(historia);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listResult;
	}
	
	@Override
	public List<Publicacao> listarPublicacoesParentes(Publicacao publicacao) {
		
		List<Publicacao> listResult = new ArrayList<>();
		
		try {
			
			String query = "SELECT tbP.idPublicacao, tbP.DataModificacao, tbP.statusPublicacao, tbUP.idUsuario, tbUP.donoPublicacao, tbH.idHistoria, tbH.tituloHistoria, tbH.conteudoHistoria, tbH.imagemHistoria, tbH.dataCriacao, tbH.idColecao, tbH.idPublicacao"
					+ " FROM tbPublicacao as tbP"
					+ " INNER JOIN tbUsuarioPublicacao as tbUP ON tbP.idPublicacao = tbUP.idPublicacao"
					+ " INNER JOIN tbColecao as tbC ON tbP.idPublicacao = tbC.idPublicacao"
					+ " INNER JOIN tbHistoria as tbH ON tbC.idColecao = tbH.idColecao"
					+ " WHERE tbP.idPublicacao = ? AND tbP.statusPublicacao > 0 AND tbUP.donoPublicacao = 1";
			
			PreparedStatement declaration = dbConnection.CONNECTION.prepareStatement(query);
			declaration.setInt(1, publicacao.getIdPublicacao());
			
			ResultSet result = declaration.executeQuery();
			
			while(result.next()) {
				Historia historia = new Historia();
				historia.setIdPublicacao(result.getInt("tbH.idPublicacao"));
				historia.setTitulo(result.getString("tbH.tituloHistoria"));
				historia.setStatus(result.getInt("tbP.statusPublicacao"));
				historia.setDataCriacao(result.getDate("tbH.dataCriacao"));
				historia.setDataModificacao(result.getDate("tbP.DataModificacao"));
				historia.setTipoPublicacao(2 /*2 = history*/);
				historia.setConteudo(result.getString("tbH.conteudoHistoria"));
				historia.setImagem(result.getString("tbH.imagemHistoria"));
				historia.setIdUsuario(result.getInt("tbUP.idUsuario"));
				
				listResult.add(historia);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listResult;
	}
	
	@Override
	public List<Publicacao> pesquisarPublicacoes(String pesquisa) {
		List<Publicacao> listResult = new ArrayList<>();
		
		try {
			
			String query = "SELECT tbUP.idUsuario, tbUP.idPublicacao, tbUP.donoPublicacao, tbP.DataModificacao, tbP.statusPublicacao, tbH.idHistoria, tbH.tituloHistoria, tbH.conteudoHistoria, tbH.imagemHistoria, tbH.dataCriacao, tbH.idColecao"
					+ " FROM tbUsuarioPublicacao as tbUP"
					+ " INNER JOIN tbHistoria as tbH ON tbUp.idPublicacao = tbH.idPublicacao"
					+ " INNER JOIN tbPublicacao as tbP ON tbUP.idPublicacao = tbP.idPublicacao"
					+ " WHERE tbP.statusPublicacao = 1 AND (tbH.tituloHistoria LIKE ? OR tbH.conteudoHistoria LIKE ?)";
			
			PreparedStatement declaration = dbConnection.CONNECTION.prepareStatement(query);
			declaration.setString(1, "%"+pesquisa+"%");
			declaration.setString(2, "%"+pesquisa+"%");
			
			ResultSet result = declaration.executeQuery();
			
			while(result.next()) {
				
				Historia historia = new Historia();
				historia.setIdPublicacao(result.getInt("tbUP.idPublicacao"));
				historia.setTitulo(result.getString("tbH.tituloHistoria"));
				historia.setStatus(result.getInt("tbP.statusPublicacao"));
				historia.setDataCriacao(result.getDate("tbH.dataCriacao"));
				historia.setDataModificacao(result.getDate("tbP.DataModificacao"));
				historia.setTipoPublicacao(2 /*2 = history*/);
				historia.setConteudo(result.getString("tbH.conteudoHistoria"));
				historia.setImagem(result.getString("tbH.imagemHistoria"));
				historia.setIdUsuario(result.getInt("tbUP.idUsuario"));
				
				listResult.add(historia);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listResult;
	}
	
	@Override
	public boolean criarPublicacao(Publicacao publicacao, int idUsuario, int statusPublicacao) {
		try {
		
			//create a publication
			String query = "INSERT INTO tbPublicacao(dataModificacao, statusPublicacao)"
					+ "VALUES (?,?)";
			
			PreparedStatement declaration = dbConnection.CONNECTION.prepareStatement(query);
			declaration.setDate(1, new Date(new java.util.Date().getTime()));
			declaration.setInt(2, statusPublicacao);
			
			declaration.execute();
			
			//get publication's last id
			query = "SELECT MAX(idPublicacao) as idPublicacao FROM tbPublicacao";
			
			Statement statement = dbConnection.CONNECTION.createStatement();
			
			ResultSet result = statement.executeQuery(query);
			
			int idPublication = 0;
			
			if(result.next()) {
				idPublication = result.getInt("idPublicacao");
			}
			
			//create a history
			if(((Historia)publicacao).getColecao() == null) {
				query = "INSERT INTO tbHistoria(tituloHistoria, conteudoHistoria, imagemHistoria, dataCriacao, idPublicacao)"
						+ "VALUES (?,?,?,?,?)";
			}else {
				query = "INSERT INTO tbHistoria(tituloHistoria, conteudoHistoria, imagemHistoria, dataCriacao, idPublicacao, idColecao)"
						+ "VALUES (?,?,?,?,?,?)";
			}
			
			declaration = dbConnection.CONNECTION.prepareStatement(query);
			declaration.setString(1, publicacao.getTitulo());
			declaration.setString(2, ((Historia)publicacao).getConteudo());
			declaration.setString(3, "card_cover.jpg");
			declaration.setDate  (4, new Date(new java.util.Date().getTime()));
			declaration.setInt   (5, idPublication);
			if(((Historia)publicacao).getColecao() != null) {
				declaration.setInt(6, ((Historia)publicacao).getColecao().getIdColecao());
			}
			
			declaration.execute();
			
			//create a user publication
			query = "INSERT INTO tbUsuarioPublicacao(idUsuario, idPublicacao, donoPublicacao)"
					+ "VALUES (?,?,?)";
			  
			declaration = dbConnection.CONNECTION.prepareStatement(query);
			declaration.setInt(1, idUsuario);
			declaration.setInt(2, idPublication);
			declaration.setInt(3, 1); /*Is owner*/
			declaration.execute();
			
			return true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public Publicacao editarPublicacao(Publicacao publicacao) {
		
		try {
			
			String query = "UPDATE tbHistoria SET tituloHistoria = ?, conteudoHistoria = ?"
					+ " WHERE idPublicacao = ?";
			
			PreparedStatement declaration = dbConnection.CONNECTION.prepareStatement(query);
			declaration.setString(1, publicacao.getTitulo());
			declaration.setString(2, ((Historia)publicacao).getConteudo());
			declaration.setInt(3, publicacao.getIdPublicacao());
			declaration.execute();
			
			query = "UPDATE tbPublicacao SET dataModificacao = ?"
					+ " WHERE idPublicacao = ?";
			
			java.util.Date date = new java.util.Date();
			
			declaration = dbConnection.CONNECTION.prepareStatement(query);
			declaration.setDate(1, new Date(date.getTime()));
			declaration.setInt(2, publicacao.getIdPublicacao());
			
			publicacao.setDataModificacao(date);
			return publicacao;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@Override
	public boolean removerPublicacao(Publicacao publicacao) {
		
		try {
			
			String query = "UPDATE tbPublicacao SET statusPublicacao = 0 WHERE idPublicacao = ?";
			
			PreparedStatement declaration = dbConnection.CONNECTION.prepareStatement(query);
			declaration.setInt(1, publicacao.getIdPublicacao());
			
			return declaration.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean adicionarPublicacaoFavorito(Publicacao publicacao, Usuario usuario) {
		
		try {
			String query = "INSERT INTO tbUsuarioPublicacao(idUsuario, idPublicacao, favoritoPublicacao)"
					+ "VALUES (?,?,?)";
			 
			PreparedStatement declaration = dbConnection.CONNECTION.prepareStatement(query);
			declaration.setInt(1, usuario.getId());
			declaration.setInt(2, publicacao.getIdPublicacao());
			declaration.setInt(3, 1); /*Is favorite*/
			
			return declaration.execute();
				
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean removerPublicacaoFavorito(Publicacao publicacao, Usuario usuario) {
		try {
			String query = "DELETE FROM tbUsuarioPublicacao WHERE idUsuario = ? AND idPublicacao = ? AND favoritoPublicacao = 1";
			 
			PreparedStatement declaration = dbConnection.CONNECTION.prepareStatement(query);
			declaration.setInt(1, usuario.getId());
			declaration.setInt(2, publicacao.getIdPublicacao());
			
			return declaration.execute();
				
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean isFavorito(Publicacao publicacao, Usuario usuario) {
		try {
			String query = "SELECT idUsuario, idPublicacao, favoritoPublicacao"
					+ " FROM tbUsuarioPublicacao WHERE idUsuario = ? AND idPublicacao = ? AND favoritoPublicacao = 1";
			 
			PreparedStatement declaration = dbConnection.CONNECTION.prepareStatement(query);
			declaration.setInt(1, usuario.getId());
			declaration.setInt(2, publicacao.getIdPublicacao());
			
			return declaration.executeQuery().next();
				
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}

package fateczl.blankspace.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import fateczl.blankspace.entity.Colecao;
import fateczl.blankspace.entity.Historia;
import fateczl.blankspace.entity.Publicacao;
import fateczl.blankspace.entity.Usuario;

public class DaoColecao implements DaoPublicacao{

	DBConnection dbConnection = new DBConnection();
	
	@Override
	public List<Publicacao> listarPublicacoesFeed(Usuario usuario){
		List<Publicacao> listResult = new ArrayList<>();
		
		try {
			
			String query = "SELECT tbS.idUsuarioSeguidor, tbS.idUsuarioSeguinte, tbUP.idUsuario, tbUP.idPublicacao, tbUP.donoPublicacao, tbP.dataModificacao, DATE(tbP.dataModificacao) as date, tbP.statusPublicacao, tbC.idColecao, tbC.tituloColecao, tbC.descricaoColecao, tbC.dataCriacao"
					+ " FROM tbSeguidor as tbS"
					+ " INNER JOIN tbUsuarioPublicacao as tbUP ON tbS.idUsuarioSeguinte = tbUP.idUsuario"
					+ " INNER JOIN tbPublicacao as tbP ON tbUP.idPublicacao = tbP.idPublicacao"
					+ " INNER JOIN tbColecao as tbC ON tbUP.idPublicacao = tbC.idPublicacao"
					+ " WHERE tbS.idUsuarioSeguidor = ? AND tbUP.donoPublicacao = 1 AND tbP.statusPublicacao = 1"
					+ " ORDER BY date DESC";
			
			PreparedStatement declaration = dbConnection.CONNECTION.prepareStatement(query);
			declaration.setInt(1, usuario.getId());
			
			ResultSet result = declaration.executeQuery();
			
			while(result.next()) {
				
				Colecao colecao = new Colecao();
				colecao.setIdPublicacao(result.getInt("tbUP.idPublicacao"));
				colecao.setUsuario(usuario);
				colecao.setTitulo(result.getString("tbC.tituloColecao"));
				colecao.setStatus(result.getInt("tbP.statusPublicacao"));
				colecao.setDataCriacao(result.getDate("tbC.dataCriacao"));
				colecao.setDataModificacao(result.getDate("tbP.DataModificacao"));
				colecao.setIdColecao(result.getInt("tbC.idColecao"));
				colecao.setTipoPublicacao(1 /*1 = collection*/);
				colecao.setDescricao(result.getString("tbC.descricaoColecao"));
				colecao.setIdUsuario(result.getInt("tbUP.idUsuario"));
				
				listResult.add(colecao);
				
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
			
			String query = "SELECT tbUP.idUsuario, tbUP.idPublicacao, tbUP.donoPublicacao, tbP.DataModificacao, Date(tbP.DataModificacao) as date, tbP.statusPublicacao, tbC.idColecao, tbC.tituloColecao, tbC.descricaoColecao,  tbC.dataCriacao"
					+ " FROM tbUsuarioPublicacao as tbUP"
					+ " INNER JOIN tbColecao as tbC ON tbUp.idPublicacao = tbC.idPublicacao"
					+ " INNER JOIN tbPublicacao as tbP ON tbUP.idPublicacao = tbP.idPublicacao"
					+ " WHERE tbUP.idUsuario = ? AND tbUP.donoPublicacao = "+1+" AND tbP.statusPublicacao = ?"
					+ " ORDER BY date DESC";
			
			PreparedStatement declaration = dbConnection.CONNECTION.prepareStatement(query);
			declaration.setInt(1, usuario.getId());
			declaration.setInt(2, statusPublicacao);
			
			ResultSet result = declaration.executeQuery();
			
			while(result.next()) {
				
				Colecao colecao = new Colecao();
				colecao.setIdPublicacao(result.getInt("tbUP.idPublicacao"));
				colecao.setUsuario(usuario);
				colecao.setTitulo(result.getString("tbC.tituloColecao"));
				colecao.setStatus(result.getInt("tbP.statusPublicacao"));
				colecao.setDataCriacao(result.getDate("tbC.dataCriacao"));
				colecao.setDataModificacao(result.getDate("tbP.DataModificacao"));
				colecao.setIdColecao(result.getInt("tbC.idColecao"));
				colecao.setTipoPublicacao(1 /*1 = coleção*/);
				colecao.setDescricao(result.getString("tbC.descricaoColecao"));
				colecao.setIdUsuario(result.getInt("tbUP.idUsuario"));
				
				listResult.add(colecao);
				
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
			
			String query = "SELECT tbUP.idUsuario, tbUP.idPublicacao, tbUP.favoritoPublicacao, tbP.DataModificacao, Date(tbP.DataModificacao) as date, tbP.statusPublicacao, tbC.idColecao, tbC.tituloColecao, tbC.descricaoColecao,  tbC.dataCriacao"
					+ " FROM tbUsuarioPublicacao as tbUP"
					+ " INNER JOIN tbColecao as tbC ON tbUp.idPublicacao = tbC.idPublicacao"
					+ " INNER JOIN tbPublicacao as tbP ON tbUP.idPublicacao = tbP.idPublicacao"
					+ " WHERE tbUP.idUsuario = ? AND tbUP.favoritoPublicacao = 1 AND tbP.statusPublicacao = 1"
					+ " ORDER BY date DESC";
			
			PreparedStatement declaration = dbConnection.CONNECTION.prepareStatement(query);
			declaration.setInt(1, usuario.getId());
			
			ResultSet result = declaration.executeQuery();
			
			while(result.next()) {
				
				Colecao colecao = new Colecao();
				colecao.setIdPublicacao(result.getInt("tbUP.idPublicacao"));
				colecao.setUsuario(usuario);
				colecao.setTitulo(result.getString("tbC.tituloColecao"));
				colecao.setStatus(result.getInt("tbP.statusPublicacao"));
				colecao.setDataCriacao(result.getDate("tbC.dataCriacao"));
				colecao.setDataModificacao(result.getDate("tbP.DataModificacao"));
				colecao.setIdColecao(result.getInt("tbC.idColecao"));
				colecao.setTipoPublicacao(1 /*1 = coleção*/);
				colecao.setDescricao(result.getString("tbC.descricaoColecao"));
				
				listResult.add(colecao);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listResult;
	}
	
	@Override
	public List<Publicacao> listarPublicacoesParentes(Publicacao publicacao){
		return null;
	}
	
	@Override
	public List<Publicacao> pesquisarPublicacoes(String pesquisa) {
		List<Publicacao> listResult = new ArrayList<>();
		
		try {
			
			String query = "SELECT tbUP.idUsuario, tbUP.idPublicacao, tbUP.donoPublicacao, tbP.DataModificacao, tbP.statusPublicacao, tbC.idColecao, tbC.tituloColecao, tbC.descricaoColecao,  tbC.dataCriacao"
					+ " FROM tbUsuarioPublicacao as tbUP"
					+ " INNER JOIN tbColecao as tbC ON tbUp.idPublicacao = tbC.idPublicacao"
					+ " INNER JOIN tbPublicacao as tbP ON tbUP.idPublicacao = tbP.idPublicacao"
					+ " WHERE tbP.statusPublicacao = 1 AND (tbC.tituloColecao LIKE ? OR tbC.descricaoColecao LIKE ?)";
			
			PreparedStatement declaration = dbConnection.CONNECTION.prepareStatement(query);
			declaration.setString(1, "%"+pesquisa+"%");
			declaration.setString(2, "%"+pesquisa+"%");
			
			ResultSet result = declaration.executeQuery();
			
			while(result.next()) {
				
				Colecao colecao = new Colecao();
				colecao.setIdPublicacao(result.getInt("tbUP.idPublicacao"));
				colecao.setTitulo(result.getString("tbC.tituloColecao"));
				colecao.setStatus(result.getInt("tbP.statusPublicacao"));
				colecao.setDataCriacao(result.getDate("tbC.dataCriacao"));
				colecao.setDataModificacao(result.getDate("tbP.DataModificacao"));
				colecao.setTipoPublicacao(1 /*1 = coleção*/);
				colecao.setDescricao(result.getString("tbC.descricaoColecao"));
				colecao.setIdUsuario(result.getInt("tbUP.idUsuario"));
				
				listResult.add(colecao);
				
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
			query = "INSERT INTO tbColecao(tituloColecao, descricaoColecao, dataCriacao, idPublicacao)"
					+ "VALUES (?,?,?,?)";
			
			declaration = dbConnection.CONNECTION.prepareStatement(query);
			declaration.setString(1, publicacao.getTitulo());
			declaration.setString(2, ((Colecao)publicacao).getDescricao());
			declaration.setDate(3, new Date(new java.util.Date().getTime()));
			declaration.setInt(4, idPublication);
			
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
		return null;
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

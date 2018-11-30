package fateczl.blankspace.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fateczl.blankspace.controller.AcessoController;
import fateczl.blankspace.entity.Publicacao;
import fateczl.blankspace.entity.Usuario;

public class DaoUsuario {
	
	DBConnection dbConnection = new DBConnection();
	
	public Usuario logar(String email, String senha) {
		
		try {
			
			String query = "SELECT idUsuario, emailUsuario, nomeUsuario, sobrenomeUsuario, carreiraUsuario, nascimentoUsuario, senhaUsuario"
					+ " FROM tbUsuario WHERE emailUsuario = ? AND senhaUsuario = ?";
			
			PreparedStatement declaration = dbConnection.CONNECTION.prepareStatement(query);
			declaration.setString(1, email);
			declaration.setString(2, senha);
			
			ResultSet result = declaration.executeQuery();
			
			if(result.next()) {
				
				Usuario usuario = new Usuario();
				usuario.setId(result.getInt("idUsuario"));
				usuario.setEmail(result.getString("emailUsuario"));
				usuario.setNome(result.getString("nomeUsuario"));
				usuario.setSobrenome(result.getString("sobrenomeUsuario"));
				usuario.setCarreira(result.getString("carreiraUsuario"));
				usuario.setNascimento(result.getDate("nascimentoUsuario"));
				
				return usuario;
				
			}else {
				return null;
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public List<Usuario> listarSeguidoresSeguintes(Usuario usuario, int type) {
		List<Usuario> listResult = new ArrayList<>();
		
		try {
			
			String query = "SELECT tbS.idUsuarioSeguidor, tbS.idUsuarioSeguinte, tbU.idUsuario, tbU.emailUsuario, tbU.nomeUsuario, tbU.sobrenomeUsuario, tbU.carreiraUsuario, tbU.nascimentoUsuario, tbU.senhaUsuario"
					+ " FROM tbSeguidor as tbS"
					+ " INNER JOIN tbUsuario as tbU ON "+(type == 0? "tbS.idUsuarioSeguidor" : "tbS.idUsuarioSeguinte")+" = tbU.idUsuario"
					+ (type == 0 ? " WHERE tbS.idUsuarioSeguinte = ?" : " WHERE tbS.idUsuarioSeguidor = ?");
			
			PreparedStatement declaration = dbConnection.CONNECTION.prepareStatement(query);
			declaration.setInt(1, usuario.getId());
			
			ResultSet result = declaration.executeQuery();
			
			while(result.next()) {
				
				Usuario usuarioL = new Usuario();
				usuarioL.setId(result.getInt("tbU.idUsuario"));
				usuarioL.setEmail(result.getString("tbU.emailUsuario"));
				usuarioL.setNome(result.getString("tbU.nomeUsuario"));
				usuarioL.setSobrenome(result.getString("tbU.sobrenomeUsuario"));
				usuarioL.setCarreira(result.getString("tbU.carreiraUsuario"));
				usuarioL.setNascimento(result.getDate("tbU.nascimentoUsuario"));
				listResult.add(usuarioL);
				
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listResult;
		
	}
	
	public boolean isSeguindo(Usuario seguidor, Usuario seguinte) {
		try {
			
			String query = "SELECT idUsuarioSeguidor, idUsuarioSeguinte"
					+ " FROM tbSeguidor WHERE idUsuarioSeguidor = ? AND idUsuarioSeguinte = ?";
			
			PreparedStatement declaration = dbConnection.CONNECTION.prepareStatement(query);
			
			declaration.setInt(1, seguidor.getId());
			declaration.setInt(2, seguinte.getId());
			
			ResultSet result = declaration.executeQuery();
			
			return result.next();
				
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean desvincularUsuario(Usuario seguidor, Usuario seguido) {
		System.out.println(seguidor.getId()+" - "+seguido.getId());
		try {
			
			String query = "DELETE FROM tbSeguidor WHERE idUsuarioSeguidor = ? AND idUsuarioSeguinte = ?";
			
			PreparedStatement declaration = dbConnection.CONNECTION.prepareStatement(query);
			declaration.setInt(1, seguidor.getId());
			declaration.setInt(2, seguido.getId());
			
			return declaration.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean seguirUsuario(Usuario seguidor, Usuario seguido) {
		try {
			
			String query = "INSERT INTO tbSeguidor(idUsuarioSeguidor, idUsuarioSeguinte)"
					+ " values (?,?)";
			
			 PreparedStatement declaration = dbConnection.CONNECTION.prepareStatement(query);
			
			declaration.setInt(1, seguidor.getId());
			declaration.setInt(2, seguido.getId());
			
			return declaration.execute();
				
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public int contarSeguidores(Usuario usuario, int type) {
		
		try {
		
			String query = "SELECT COUNT("+(type == 0?"idUsuarioSeguinte" : "idUsuarioSeguinte")+") as con, idUsuarioSeguidor, idUsuarioSeguinte FROM tbSeguidor  "
					+ " WHERE "+(type == 0?"idUsuarioSeguinte" : "idUsuarioSeguidor")+" =?";
			
			PreparedStatement declaration = dbConnection.CONNECTION.prepareStatement(query);
			declaration.setInt(1, usuario.getId());
			
			ResultSet result = declaration.executeQuery();
			
			if(result.next()) {
				return result.getInt("con");
			}else {
				return 0;
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
			
	}
	
	public int contarPublicacoes(Usuario usuario) {
		try {
			
			String query = "SELECT COUNT(idUsuario) as con, idUsuario, donoPublicacao"
					+ " FROM tbUsuarioPublicacao WHERE idUsuario = ? AND donoPublicacao = 1";
			
			PreparedStatement declaration = dbConnection.CONNECTION.prepareStatement(query);
			declaration.setInt(1, usuario.getId());
			
			ResultSet result = declaration.executeQuery();
			
			if(result.next()) {
				return result.getInt("con");
			}else {
				return 0;
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public List<Usuario> pesquisarUsuario(String pesquisa, int idUsuario) {
		
		List<Usuario> listResult = new ArrayList<>();
		
		try {
			String query = "SELECT idUsuario, emailUsuario, nomeUsuario, sobrenomeUsuario, carreiraUsuario, nascimentoUsuario, senhaUsuario"
					+ " FROM tbUsuario WHERE idUsuario <> ? AND (emailUsuario LIKE ? OR nomeUsuario LIKE ? OR sobrenomeUsuario LIKE ? OR carreiraUsuario LIKE ?)";
			
			PreparedStatement declaration = dbConnection.CONNECTION.prepareStatement(query);
			declaration.setInt(1, idUsuario);
			declaration.setString(2, "%"+pesquisa+"%");
			declaration.setString(3, "%"+pesquisa+"%");
			declaration.setString(4, "%"+pesquisa+"%");
			declaration.setString(5, "%"+pesquisa+"%");
			
			ResultSet result = declaration.executeQuery();
			
			while(result.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(result.getInt("idUsuario"));
				usuario.setEmail(result.getString("emailUsuario"));
				usuario.setNome(result.getString("nomeUsuario"));
				usuario.setSobrenome(result.getString("sobrenomeUsuario"));
				usuario.setCarreira(result.getString("carreiraUsuario"));
				usuario.setNascimento(result.getDate("nascimentoUsuario"));
				
				listResult.add(usuario);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(listResult.size());
		
		return listResult;
		
	}
	
	public Usuario cadastrarUsuario(Usuario usuario) {
		
		String query = "INSERT INTO tbUsuario(emailUsuario, nomeUsuario, sobrenomeUsuario, carreiraUsuario, nascimentoUsuario, senhaUsuario)"
				+ "VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement declaration = dbConnection.CONNECTION.prepareStatement(query);
			
			declaration.setString(1, usuario.getEmail());
			declaration.setString(2, usuario.getNome());
			declaration.setString(3, usuario.getSobrenome());
			declaration.setString(4, usuario.getCarreira());
			declaration.setDate(5, new Date(usuario.getNascimento().getTime()));
			declaration.setString(6, usuario.getSenha());
			
			declaration.execute();
			
			return usuario;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}

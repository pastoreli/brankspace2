package fateczl.blankspace.entity;

import java.util.Calendar;
import java.util.Date;

public class Publicacao {

	private int idPublicacao;
	private Usuario usuario;
	private String titulo;
	private int status;					/*0: Inativo, 1: Publicada, 2: Arquivada, 3: Rascunho*/
	private Date dataCriacao;
	private Date dataModificacao;
	private int tipoPublicacao; 		/*1 Coleção, 2 Historia*/
	private int idUsuario;
	
	public int getIdPublicacao() {
		return idPublicacao;
	}
	public void setIdPublicacao(int idPublicacao) {
		this.idPublicacao = idPublicacao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Date getDataModificacao() {
		return dataModificacao;
	}
	public void setDataModificacao(Date dataModificacao) {
		this.dataModificacao = dataModificacao;
	}
	public int getTipoPublicacao() {
		return tipoPublicacao;
	}
	public void setTipoPublicacao(int tipoPublicacao) {
		this.tipoPublicacao = tipoPublicacao;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
}

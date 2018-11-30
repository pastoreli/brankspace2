package fateczl.blankspace.entity;

public class Historia  extends Publicacao{

	private int idHistoria;
	private String conteudo;
	private String imagem;
	private Colecao colecao;
	
	public int getIdHistoria() {
		return idHistoria;
	}
	public void setIdHistoria(int idHistoria) {
		this.idHistoria = idHistoria;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public Colecao getColecao() {
		return colecao;
	}
	public void setColecao(Colecao colecao) {
		this.colecao = colecao;
	}
}

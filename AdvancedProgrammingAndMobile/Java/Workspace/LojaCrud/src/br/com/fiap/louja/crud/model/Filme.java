package br.com.fiap.louja.crud.model;

import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Filme {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String sinopse;
	private String genero;
	private String ondeAssistir;
	private boolean assistido;
	private int avaliacao;
	
	
	
	public Vector<String> getDataArray() {
		Vector<String> data = new Vector<String>();
		data.add(id.toString());
		data.add(titulo);
		data.add(sinopse);
		data.add(genero);
		data.add(ondeAssistir);
		data.add(assistido? "Sim" : "Não");
		data.add(avaliacao+"");
		
		return data;
	}


	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public String getTitulo() { return titulo; }

	public void setTitulo(String titulo) { this.titulo = titulo; }

	public String getSinopse() { return sinopse; }

	public void setSinopse(String sinopse) { this.sinopse = sinopse; }

	public String getGenero() { return genero; }

	public void setGenero(String genero) { this.genero = genero; }

	public String getOndeAssistir() { return ondeAssistir; }

	public void setOndeAssistir(String ondeAssistir) { this.ondeAssistir = ondeAssistir; }

	public boolean isAssistido() { return assistido; }

	public void setAssistido(boolean assistido) { this.assistido = assistido; }

	public int getAvaliacao() { return avaliacao; }


	public void setAvaliacao(int avaliacao) { this.avaliacao = avaliacao; }
	
	

}

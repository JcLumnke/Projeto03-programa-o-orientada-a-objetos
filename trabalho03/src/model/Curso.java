package model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome_curso;
	private String descricao;
	private int horas_curso;
	private String nome_Professor;
	private String curso_gratuito;
	private String possui_certificado;
	
	public Curso() {
		
	}

	public Curso(String nome_curso, String descricao, int horas_curso, String nome_Professor, String curso_gratuito,
			String possui_certificado) {

		super();
		this.nome_curso = nome_curso;
		this.descricao = descricao;
		this.horas_curso = horas_curso;
		this.nome_Professor = nome_Professor;
		this.curso_gratuito = curso_gratuito;
		this.possui_certificado = possui_certificado;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome_curso() {
		return nome_curso;
	}

	public void setNome_curso(String nome_curso) {
		this.nome_curso = nome_curso;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getHoras_curso() {
		return horas_curso;
	}

	public void setHoras_curso(int horas_curso) {
		this.horas_curso = horas_curso;
	}

	public String getNome_Professor() {
		return nome_Professor;
	}

	public void setNome_Professor(String nome_Professor) {
		this.nome_Professor = nome_Professor;
	}

	public String getCurso_gratuito() {
		return curso_gratuito;
	}

	public void setCurso_gratuito(String curso_gratuito) {
		this.curso_gratuito = curso_gratuito;
	}

	public String getPossui_certificado() {
		return possui_certificado;
	}

	public void setPossui_certificado(String possui_certificado) {
		this.possui_certificado = possui_certificado;
	}

	public void setPossui_certificado(int i) {
		// TODO Auto-generated method stub
		
	}

	 void setCurso_gratuito(int i) {
		// TODO Auto-generated method stub
		
	}

}

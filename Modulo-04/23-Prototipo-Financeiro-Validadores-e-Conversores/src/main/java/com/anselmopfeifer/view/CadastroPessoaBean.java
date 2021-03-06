package com.anselmopfeifer.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import com.anselmopfeifer.model.Pessoa;
import com.anselmopfeifer.model.RamoAtividade;
import com.anselmopfeifer.model.TipoPessoa;
import com.anselmopfeifer.service.GestaoRamosAtividades;

@ManagedBean
@ViewScoped
public class CadastroPessoaBean implements Serializable {
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	private Pessoa pessoa = new Pessoa();
	private List<RamoAtividade> atividade = new ArrayList<RamoAtividade>();

	@PostConstruct
	public void init() {
		GestaoRamosAtividades gestaoAtividades = new GestaoRamosAtividades();
		this.atividade = gestaoAtividades.listarTodas();
	}

    public void verificaTipo(ValueChangeEvent event){
        this.pessoa.setTipo((TipoPessoa) event.getNewValue());
        this.pessoa.setDataNascimento(null);
        this.pessoa.setRamoAtividade(new RamoAtividade());

        //pula todasa as validações e rederiza tela
        FacesContext.getCurrentInstance().renderResponse();
    }
    
	public void cadastrar() {
		System.out.println("Tipo: " + this.pessoa.getTipo());
		System.out.println("Pessoa: " + this.pessoa.getNome());
		System.out.println("Email: " + this.pessoa.getEmail());
		System.out.println("Data nascimento: " + this.pessoa.getDataNascimento());
		System.out.println("Ramo de Atividade: " + this.pessoa.getRamoAtividade());
		
		this.pessoa = new Pessoa();
		
		String msg = "Cadastro efetuado com sucesso!";
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
	}

	public TipoPessoa[] getTiposPessoas() {
		return TipoPessoa.values();
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public List<RamoAtividade> getAtividade() {
		return atividade;
	}
}

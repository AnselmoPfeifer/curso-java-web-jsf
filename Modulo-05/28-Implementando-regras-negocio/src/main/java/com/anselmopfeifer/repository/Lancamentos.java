package com.anselmopfeifer.repository;

import java.util.List;

import com.anselmopfeifer.model.Lancamento;

public interface Lancamentos {
	

	public List<Lancamento> todos();
	
	public Lancamento comDadosIguais(Lancamento lancamento);
	
	public Lancamento guardar(Lancamento lancamento);
	
	public void remover(Lancamento lancamento);
}

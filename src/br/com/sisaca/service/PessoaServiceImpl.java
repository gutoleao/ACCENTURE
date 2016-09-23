package br.com.sisaca.service;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sisaca.dao.PessoaDAO;
import br.com.sisaca.exceptions.PessoaNaoEncontradaException;
import br.com.sisaca.model.Pessoa;

@Service
@Transactional(readOnly = true)
@ManagedBean(name="pessoaServiceImpl")
@SessionScoped
public class PessoaServiceImpl implements PessoaService {

	private PessoaDAO pessoaDAO;

	public void setPessoaDAO(PessoaDAO pessoaDAO) {
		this.pessoaDAO = pessoaDAO;
	}

	@Override
	public void addPessoa(Pessoa p) {
		pessoaDAO.addPessoa(p);

	}

	@Override
	public void deletePessoa(Pessoa p) throws PessoaNaoEncontradaException {
		pessoaDAO.deletePessoa(p);

	}

	@Override
	public Pessoa consultarPessoa(Pessoa p) throws PessoaNaoEncontradaException {
		return pessoaDAO.consultarPessoa(p);
	}

	@Override
	public ArrayList<Pessoa> listar() {
		return pessoaDAO.listar();
	}

}

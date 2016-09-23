package br.com.sisaca.service;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sisaca.dao.EnderecoDAO;
import br.com.sisaca.exceptions.EnderecoNaoEncontradoException;
import br.com.sisaca.model.Endereco;

@Service
@Transactional(readOnly = true)
@ManagedBean(name="enderecoServiceImpl")
@SessionScoped
public class EnderecoServiceImpl implements EnderecoService {

	private EnderecoDAO enderecoDAO;

	public void setEnderecoDAO(EnderecoDAO enderecoDAO) {
		this.enderecoDAO = enderecoDAO;
	}

	@Override
	public void addEndereco(Endereco end) {
		enderecoDAO.addEndereco(end);

	}

	@Override
	public void deleteEndereco(Endereco end) throws EnderecoNaoEncontradoException {
		enderecoDAO.deleteEndereco(end);

	}

	@Override
	public Endereco consultarEndereco(Endereco end) throws EnderecoNaoEncontradoException {

		return enderecoDAO.consultarEndereco(end);
	}

	@Override
	public ArrayList<Endereco> listar() {

		return enderecoDAO.listar();
	}

}

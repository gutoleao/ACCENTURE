package br.com.sisaca.service;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sisaca.dao.MeioDAO;
import br.com.sisaca.exceptions.MeioNaoEncontradoException;
import br.com.sisaca.model.Meio;

@Service
@Transactional(readOnly = true)
@ManagedBean(name="meioServiceImpl")
@SessionScoped
public class MeioServiceImpl implements MeioService {

	private MeioDAO meioDAO;

	public void setMeioDAO(MeioDAO meioDAO) {
		this.meioDAO = meioDAO;
	}

	@Override
	public void addMeio(Meio meio) {
		meioDAO.addMeio(meio);

	}

	@Override
	public void deleteMeio(Meio meio) throws MeioNaoEncontradoException {
		meioDAO.deleteMeio(meio);

	}

	@Override
	public Meio consultarMeio(Meio meio) throws MeioNaoEncontradoException {

		return meioDAO.consultarMeio(meio);
	}

	@Override
	public ArrayList<Meio> listar() {

		return meioDAO.listar()	;
	}

}

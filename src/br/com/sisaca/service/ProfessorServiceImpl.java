package br.com.sisaca.service;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sisaca.dao.ProfessorDAO;
import br.com.sisaca.exceptions.ProfessorNaoEncontradoException;
import br.com.sisaca.model.Professor;

@Service
@Transactional(readOnly = true)
@ManagedBean(name="professorServiceImpl")
@SessionScoped
public class ProfessorServiceImpl implements ProfessorService {

	private ProfessorDAO professorDAO;

	public void setProfessorDAO(ProfessorDAO professorDAO) {
		this.professorDAO = professorDAO;
	}

	@Override
	public void addProfessor(Professor prof) {
		professorDAO.addProfessor(prof);
	}

	@Override
	public void deleteProfessor(Professor prof) throws ProfessorNaoEncontradoException {
		professorDAO.deleteProfessor(prof);

	}

	@Override
	public Professor consultarProf(Professor prof) throws ProfessorNaoEncontradoException {

		return professorDAO.consultarProf(prof);
	}

	@Override
	public ArrayList<Professor> listar() {

		return professorDAO.listar();
	}

}

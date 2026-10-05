package com.gft.staffwa.services;

import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.staffwa.models.Funcionario;
import com.gft.staffwa.repositories.Filter;
import com.gft.staffwa.repositories.Funcionarios;
import com.gft.staffwa.utils.TerminoWa;

@Service
public class FuncionarioService {

	@Autowired
	private Funcionarios funcionarios;

	public List<Funcionario> filtrar(Filter filtro, Pageable pageable) {
		final String nomeFuncionario = (filtro).getBusca() == null ? "" : filtro.getBusca();
		return this.funcionarios.findByNomeContainingAndAlocacaoIsNull(nomeFuncionario, pageable);
	}

	public List<Funcionario> filtrarAlocados(Filter filtro, Pageable pageable) {
		final String nomeFuncionario = (filtro).getBusca() == null ? "" : filtro.getBusca();
		return this.funcionarios.findByNomeContainingAndAlocacaoIsNotNull(nomeFuncionario, pageable);
	}

	public void salvar(Funcionario funcionario) throws DataIntegrityViolationException {
		try {
			funcionario.setTerminoWa(TerminoWa.calcularData(funcionario.getInicioWa(), 15));
			this.funcionarios.save(funcionario);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Matrícula já registrada");
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}

	public Long countByAlocacaoIsNull() {
		return funcionarios.countByAlocacaoIsNull();
	}

	public Long countByAlocacaoIsNotNull() {
		return funcionarios.countByAlocacaoIsNotNull();
	}

	public Long countByDataDeAlocacaoAfter() {

		Date data7diasAtras = new DateTime().minusDays(7).toDate();

		return funcionarios.countByDataDeAlocacaoAfter(data7diasAtras);
	}

	public List<Object[]> groupAndCountByTerminoWa() {
		return funcionarios.groupAndCountByTerminoWa();
	}

	public void deletar(Long id) {
		funcionarios.deleteById(id);
	}

}

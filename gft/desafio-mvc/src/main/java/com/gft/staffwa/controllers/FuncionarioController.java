package com.gft.staffwa.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.staffwa.models.EnumCargo;
import com.gft.staffwa.models.Funcionario;
import com.gft.staffwa.models.Level;
import com.gft.staffwa.models.Tecnologia;
import com.gft.staffwa.models.UnidadeGFT;
import com.gft.staffwa.repositories.Filter;
import com.gft.staffwa.repositories.Levels;
import com.gft.staffwa.services.FuncionarioService;
import com.gft.staffwa.services.TecnologiaService;
import com.gft.staffwa.services.UnidadeGftService;
import com.gft.staffwa.utils.Paginacao;

@Controller
@RequestMapping("/wa/funcionarios")
public class FuncionarioController {

	private static final String CADASTRO_FUNCIONARIO = "CadastroFuncionario";

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private UnidadeGftService unidadeGftService;

	@Autowired
	private TecnologiaService tecnologiaService;

	@Autowired
	private Levels levels;

	@GetMapping
	public ModelAndView renderFuncionarios(@ModelAttribute("filtro") Filter filtro, Pageable pageable) {

		ModelAndView mv = new ModelAndView("Funcionarios");

		List<Funcionario> funcionarios = this.funcionarioService.filtrar(filtro, pageable);

		Paginacao.setPaginacao(mv, "funcionarios", pageable, funcionarioService.countByAlocacaoIsNull());

		mv.addObject("funcionarios", funcionarios);
		return mv;
	}

	@GetMapping("/cadastrar")
	public ModelAndView renderCadastrarFuncionario() {

		ModelAndView mv = new ModelAndView(CADASTRO_FUNCIONARIO);

		mv.addObject(new Funcionario());

		return mv;
	}

	@PostMapping("/cadastrar")
	public String salvarFuncionario(@Validated Funcionario funcionario, Errors errors, RedirectAttributes attributes) {
		try {

			if (errors.hasErrors()) {
				return CADASTRO_FUNCIONARIO;
			}

			this.funcionarioService.salvar(funcionario);

			attributes.addFlashAttribute("mensagem", "Funcionário salvo com sucesso!");

			return "redirect:/wa/funcionarios";

		} catch (Exception e) {
			errors.rejectValue("", null, e.getMessage());
			return CADASTRO_FUNCIONARIO;
		}
	}

	@GetMapping("{id}")
	public ModelAndView editar(@PathVariable("id") Funcionario funcionario) {

		ModelAndView mv = new ModelAndView(CADASTRO_FUNCIONARIO);
		mv.addObject(funcionario);

		return mv;
	}

	@DeleteMapping("{id}")
	public String deletar(Funcionario funcionario, RedirectAttributes attributes) {

		funcionarioService.deletar(funcionario.getId());

		attributes.addFlashAttribute("mensagem", "Funcionário excluído com sucesso");

		return "redirect:/wa/funcionarios";
	}

	@GetMapping("/termino-wa")
	public @ResponseBody List<Object[]> groupByTerminoWa() {
		return funcionarioService.groupAndCountByTerminoWa();
	}

	@ModelAttribute("cargos")
	public List<EnumCargo> cargos() {
		return Arrays.asList(EnumCargo.values());
	}

	@ModelAttribute("menuFuncionarios")
	public boolean menuFuncionarios() {
		return true;
	}

	@ModelAttribute("tecnologias")
	public List<Tecnologia> tecnologias() {
		return this.tecnologiaService.findAll();
	}

	@ModelAttribute("locais")
	public List<UnidadeGFT> locais() {
		return this.unidadeGftService.findAll();
	}

	@ModelAttribute("levels")
	public List<Level> levels() {
		return levels.findAll();
	}

}

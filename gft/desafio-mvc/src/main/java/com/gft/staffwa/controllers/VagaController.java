package com.gft.staffwa.controllers;

import java.util.List;

import com.gft.staffwa.models.Level;
import com.gft.staffwa.models.Tecnologia;
import com.gft.staffwa.models.Vaga;
import com.gft.staffwa.repositories.Filter;
import com.gft.staffwa.repositories.Levels;
import com.gft.staffwa.services.TecnologiaService;
import com.gft.staffwa.services.VagaService;
import com.gft.staffwa.utils.Paginacao;

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

@Controller
@RequestMapping("/wa/vagas")
public class VagaController {

  private static final String CADASTRO_VAGA = "CadastroVaga";

  @Autowired
  VagaService vagaService;

  @Autowired
  TecnologiaService tecnologiaService;

  @Autowired
  Levels levels;

  @GetMapping
  public ModelAndView renderVagas(@ModelAttribute("filtro") Filter filtro, Pageable pageable) {
    ModelAndView mv = new ModelAndView("Vagas");

    List<Vaga> vagas = this.vagaService.filtrar(filtro, pageable);

    Paginacao.setPaginacao(mv, "vagas", pageable, vagaService.countByQtdVagasGreaterThan(0));

    mv.addObject("vagas", vagas);

    return mv;
  }

  @GetMapping("/cadastrar")
  public ModelAndView renderCadastrarVaga() {

    ModelAndView mv = new ModelAndView(CADASTRO_VAGA);

    mv.addObject(new Vaga());

    return mv;
  }

  @PostMapping("/cadastrar")
  public String salvarFuncionario(@Validated Vaga vaga, Errors errors, RedirectAttributes attributes) {
    try {

      if (errors.hasErrors()) {
        return CADASTRO_VAGA;
      }

      this.vagaService.salvar(vaga);

      attributes.addFlashAttribute("mensagem", "Vaga salva com sucesso!");

      return "redirect:/wa/vagas";

    } catch (Exception e) {
      errors.rejectValue("", null, e.getMessage());
      return CADASTRO_VAGA;
    }
  }

  @GetMapping("{id}")
  public ModelAndView editar(@PathVariable("id") Vaga vaga) {

    ModelAndView mv = new ModelAndView(CADASTRO_VAGA);
    mv.addObject(vaga);

    return mv;
  }

  @DeleteMapping("{id}")
  public String deletar(Vaga vaga, RedirectAttributes attributes) {

    vagaService.deletar(vaga);

    attributes.addFlashAttribute("mensagem", "Vaga excluída com sucesso");

    return "redirect:/wa/vagas";
  }

  @GetMapping("/por-data")
  public @ResponseBody List<Object[]> getVagasPorData() {
    return vagaService.groupAndCountByData();
  }

  @ModelAttribute("tecnologias")
  public List<Tecnologia> tecnologias() {
    return this.tecnologiaService.findAll();
  }

  @ModelAttribute("menuVagas")
  public boolean menuVagas() {
    return true;
  }

  @ModelAttribute("levels")
  public List<Level> levels() {
    return levels.findAll();
  }
}

package com.gft.staffwa.controllers;

import java.util.List;

import com.gft.staffwa.models.Funcionario;
import com.gft.staffwa.models.Tecnologia;
import com.gft.staffwa.models.Vaga;
import com.gft.staffwa.repositories.Alocacao;
import com.gft.staffwa.repositories.Funcionarios;
import com.gft.staffwa.repositories.Tecnologias;
import com.gft.staffwa.repositories.Vagas;
import com.gft.staffwa.services.AlocacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/wa/alocacao")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AlocacaoController {

  @Autowired
  AlocacaoService alocacaoService;

  @Autowired
  Funcionarios funcionarios;

  @Autowired
  Vagas vagas;

  @Autowired
  Tecnologias tecnologias;

  @GetMapping
  public ModelAndView renderAlocacao() {
    var mv = new ModelAndView("Alocacao");
    mv.addObject(new Alocacao());
    return mv;
  }

  @PostMapping
  public String alocarFuncionario(@ModelAttribute("alocacao") Alocacao alocacao, Errors errors,
      RedirectAttributes attributes) {

    try {
      alocacaoService.alocarFuncionarioEmVaga(alocacao.getFuncionario(), alocacao.getVaga());

      attributes.addFlashAttribute("mensagem", "Alocado com sucesso!");

      return "redirect:/wa/alocacao";

    } catch (Exception e) {
      errors.rejectValue("", null, e.getMessage());
      return "Alocacao";
    }

  }

  @ModelAttribute("funcionarios")
  public List<Funcionario> funcionarios() {
    return funcionarios.findByAlocacaoIsNull();
  }

  @ModelAttribute("vagas")
  public List<Vaga> vagas() {
    return vagas.findByQtdVagasGreaterThan(0);
  }

  @ModelAttribute("menuAlocacao")
  public boolean menuAlocacao() {
    return true;
  }

  @ModelAttribute("tecnologias")
  public List<Tecnologia> tecnologias() {
    return tecnologias.findAll();
  }

}

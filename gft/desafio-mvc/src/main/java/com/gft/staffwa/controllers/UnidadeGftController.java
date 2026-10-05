package com.gft.staffwa.controllers;

import java.util.List;

import com.gft.staffwa.models.UnidadeGFT;
import com.gft.staffwa.services.UnidadeGftService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/wa/unidades")
public class UnidadeGftController {

  private static final String CADASTRO_UNIDADE = "CadastroUnidade";

  @Autowired
  private UnidadeGftService unidadeGftService;

  @GetMapping("/cadastrar")
  public ModelAndView renderCadastroUnidade() {

    var mv = new ModelAndView(CADASTRO_UNIDADE);

    mv.addObject(new UnidadeGFT());

    return mv;
  }

  @PostMapping("/cadastrar")
  public String salvarFuncionario(@Validated UnidadeGFT unidadeGft, Errors errors, RedirectAttributes attributes) {
    try {

      if (errors.hasErrors()) {
        return CADASTRO_UNIDADE;
      }

      this.unidadeGftService.salvar(unidadeGft);

      attributes.addFlashAttribute("mensagem", "Unidade salva com sucesso!");

      return "redirect:/wa/unidades/cadastrar";

    } catch (Exception e) {
      errors.rejectValue("", null, e.getMessage());
      return CADASTRO_UNIDADE;
    }
  }

  @DeleteMapping("{id}")
  public String deletar(UnidadeGFT unidadeGFT, RedirectAttributes attributes) {

    unidadeGftService.deletar(unidadeGFT.getId());

    attributes.addFlashAttribute("mensagem", "Unidade excluída com sucesso");

    return "redirect:/wa/unidades/cadastrar";
  }

  @ModelAttribute("unidades")
  public List<UnidadeGFT> unidades() {
    return this.unidadeGftService.findAll();
  }
}

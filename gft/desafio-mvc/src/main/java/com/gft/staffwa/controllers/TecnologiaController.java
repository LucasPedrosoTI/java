package com.gft.staffwa.controllers;

import java.util.List;

import com.gft.staffwa.models.Tecnologia;
import com.gft.staffwa.services.TecnologiaService;

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
@RequestMapping("/wa/tecnologias")
public class TecnologiaController {

  private static final String CADASTRO_TECNOLOGIA = "CadastroTecnologia";

  @Autowired
  private TecnologiaService tecnologiaService;

  @GetMapping("/cadastrar")
  public ModelAndView renderCadastroTecnologia() {

    var mv = new ModelAndView(CADASTRO_TECNOLOGIA);

    mv.addObject(new Tecnologia());

    return mv;
  }

  @PostMapping("/cadastrar")
  public String salvarFuncionario(@Validated Tecnologia tecnologia, Errors errors, RedirectAttributes attributes) {
    try {

      if (errors.hasErrors()) {
        return CADASTRO_TECNOLOGIA;
      }

      this.tecnologiaService.salvar(tecnologia);

      attributes.addFlashAttribute("mensagem", "Tecnologia salva com sucesso!");

      return "redirect:/wa/tecnologias/cadastrar";

    } catch (Exception e) {
      errors.rejectValue("", null, e.getMessage());
      return CADASTRO_TECNOLOGIA;
    }
  }

  @DeleteMapping("{id}")
  public String deletar(Tecnologia tecnologia, RedirectAttributes attributes) {

    tecnologiaService.deletar(tecnologia.getId());

    attributes.addFlashAttribute("mensagem", "Tecnologia excluída com sucesso");

    return "redirect:/wa/tecnologias/cadastrar";
  }

  @ModelAttribute("tecnologias")
  public List<Tecnologia> tecnologias() {
    return this.tecnologiaService.findAll();
  }
}

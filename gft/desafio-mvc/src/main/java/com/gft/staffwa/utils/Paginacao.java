package com.gft.staffwa.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.data.domain.Pageable;
import org.springframework.web.servlet.ModelAndView;

public class Paginacao {
  static public void setPaginacao(ModelAndView mv, String rotaAtual, Pageable pageable, Long totalInstances) {

    int totalPaginas = getTotalPaginas(totalInstances, pageable);

    List<Integer> nroPaginas = Optional.of(getListaDePaginas(pageable, totalPaginas)).orElse(new ArrayList<Integer>());

    addObjectsToModel(mv, nroPaginas, pageable, rotaAtual);
  }

  private static List<Integer> getListaDePaginas(Pageable pageable, int totalPaginas) {

    int paginaAtual = pageable.getPageNumber();

    int paginasAnteriores = getPaginasAnteriores(paginaAtual, totalPaginas);

    int proxPaginas = getProxPaginas(paginaAtual, totalPaginas);

    return IntStream.rangeClosed(paginasAnteriores, proxPaginas).boxed().collect(Collectors.toList());
  }

  private static int getProxPaginas(int paginaAtual, int totalPaginas) {
    int inicio = paginaAtual - 2;
    int fim = paginaAtual + 2;

    if (inicio <= 0) {
      fim += ((inicio - 1) * (-1));
    }

    fim = fim > totalPaginas ? totalPaginas : fim;

    return fim;
  }

  private static int getPaginasAnteriores(int paginaAtual, int totalPaginas) {
    int inicio = paginaAtual - 2;

    if (paginaAtual + 1 == totalPaginas) {
      inicio--;
    }

    if (inicio <= 0) {
      inicio = 1;
    }

    return inicio;
  }

  private static int getTotalPaginas(long totalInstances, Pageable pageable) {
    return (int) Math.ceil((double) totalInstances / (double) pageable.getPageSize());
  }

  private static void addObjectsToModel(ModelAndView mv, List<Integer> nroPaginas, Pageable pageable,
      String rotaAtual) {
    mv.addObject("nroPaginas", nroPaginas);
    mv.addObject("paginaAtual", pageable.getPageNumber());
    mv.addObject("hasPrevious", pageable.hasPrevious());
    mv.addObject("rotaAtual", rotaAtual);
  }
}

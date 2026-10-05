package com.gft.staffwa.converters;

import com.gft.staffwa.models.UnidadeGFT;
import com.gft.staffwa.repositories.UnidadesGFT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UnidadeGftConverter implements Converter<String, UnidadeGFT> {

  @Autowired
  UnidadesGFT unidadesGft;

  @Override
  public UnidadeGFT convert(String id) {
    return unidadesGft.getOne(Long.parseLong(id));
  }

}

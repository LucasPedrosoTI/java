package com.gft.staffwa.converters;

import com.gft.staffwa.models.Tecnologia;
import com.gft.staffwa.repositories.Tecnologias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TecnologiaConverter implements Converter<String, Tecnologia> {

  @Autowired
  Tecnologias tecnologias;

  @Override
  public Tecnologia convert(String id) {

    return tecnologias.getOne(Long.parseLong(id));
  }

}

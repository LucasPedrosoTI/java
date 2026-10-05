package com.gft.staffwa.converters;

import com.gft.staffwa.models.Level;
import com.gft.staffwa.repositories.Levels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LevelConverter implements Converter<String, Level> {

  @Autowired
  Levels levels;

  @Override
  public Level convert(String id) {

    return levels.getOne(Long.parseLong(id));
  }

}

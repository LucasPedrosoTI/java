package com.gft.staffwa.utils;

import java.util.Date;

import org.joda.time.DateTime;

public class TerminoWa {

  public static Date calcularData(Date data, int dias) {
    return new DateTime(data).plusDays(dias).toDate();
  }
}

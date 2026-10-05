package com.lucaspedrosoti.expensetracker.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private Integer userId;
  private String firstName;
  private String lastName;
  private String email;
  private String password;

}

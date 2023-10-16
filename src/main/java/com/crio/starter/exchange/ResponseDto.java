package com.crio.starter.exchange;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class ResponseDto {

  private String message;

  public ResponseDto(String text){
    this.message=text;
  }

  public String getMessage(){
    return message;
  }
}

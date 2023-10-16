package com.crio.starter.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "greetings")
@NoArgsConstructor
public class GreetingsEntity {

  private String extId;

  private String message;

  public String getMessage(){
    return message;
  }
  public String getExtId(){
    return extId;
  }

  public void setMessage(String message){
    this.message=message;
  }
  public void setExtId(String Idd){
    this.extId=Idd;
  }

}

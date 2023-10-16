package com.crio.starter.exchange;

import lombok.Data;
import org.springframework.lang.NonNull;


@Data
public class memeRequest {
    //@NonNull
    private String name;
    //@NonNull
    private String url;
   // @NonNull
    private String caption;
    
}

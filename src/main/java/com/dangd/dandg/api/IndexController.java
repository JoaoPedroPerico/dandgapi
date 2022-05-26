package com.dangd.dandg.api;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public MensagemRaiz get() {
        MensagemRaiz retorno = new MensagemRaiz();
        return retorno;
    }

    @GetMapping("/userInfo")
    public UserDetails userInfo(@AuthenticationPrincipal UserDetails user) {
        return user;
    }
}

class MensagemRaiz implements Serializable {
    public String boasVindas = "Bem vindo a API de D&D 5e, Dugenons and Griffins. Acesse /swagger-ui/index.html";
    public String referencia = "Essa API se baseia no System Reference Document 5.1. https://dnd.wizards.com/resources/systems-reference-document";
    public String[] tecnologiasUsadas = {"Java","SpringBoot","MySQL","JPA","Lombok","DTO",
            "ModelMapper","H2","Swagger","Git/GitHub"};
}

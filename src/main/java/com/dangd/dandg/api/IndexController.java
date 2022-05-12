package com.dangd.dandg.api;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String get() {
        return "Bem vindo a API de D&D 5e, Dugenons and Griffins.\n" +
                "Essa API se baseia no System Reference Document 5.1.\n" +
                "https://dnd.wizards.com/resources/systems-reference-document\n" +
                "Tecnologias usadas:\n" +
                ">>Java\n" +
                ">>SpringBoot\n" +
                ">>MySQL\n" +
                ">>JPA\n" +
                ">>Lombok\n" +
                ">>DTO\n" +
                ">>ModelMapper\n" +
                ">>H2\n" +
                ">>Swagger\n" +
                ">>Git/GitHub\n";
    }
}

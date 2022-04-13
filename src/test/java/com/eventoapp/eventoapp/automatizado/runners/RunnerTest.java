package com.eventoapp.eventoapp.automatizado.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        dryRun = false,
        features = "src/test/java",
        glue = "steps",
        monochrome = true,
        publish = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        //tags = ("@CadastroUsuarioComDadosInvalidos"),
        //tags = ("@CadastroUsuarioComDadosValidos"),
        //tags = ("@LoginUsuario"),
        tags = ("@CadastroAnimal"),
        stepNotifications = true
)
public class RunnerTest {

}

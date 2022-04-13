#langauage eng
Feature: Página index

  @indexCadastrar
  Scenario: Abrir navegador e validar página index

    Given Que eu esteja na página index
    When Que eu clique no botao Cadastrar
    Then Sou direcionado para cadastrar um evento

  @indexListar
  Scenario: Abrir navegador e validar página index

    Given Que eu esteja na página index
    When Que eu clique no botao Listar
    Then Sou direcionado para listar um evento

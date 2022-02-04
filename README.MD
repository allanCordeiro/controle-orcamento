# Controle de Orçamento - Alura Challenge

Projeto Alura Challenge Backend para construção de uma API Rest para controle de orçamento.

Informações sobre o desafio: https://www.alura.com.br/challenges/back-end-2/semana-01-api-rest

*Swagger da aplicação: https://allan-controle-orcamento.herokuapp.com/swagger-ui.html*

 ## Semana 1
- [X] Definição de stack
- [X] Construir e expor CRUD via API Rest
- [X] Testes unitários via Postman
 ## Semana 2
- [X] Inserir a coluna categoria no banco de dados
- [X] Considerar a categorização de despesas
- [X] Criar @RequestParam para busca com querystring no endpoint de receitas por descrição
- [X] Criar @RequestParam para busca com querystring no endpoint de despesas por descrição
- [X] Permitir busca de despesas por mês
- [X] Permitir busca de receitas por mês
- [X] Criar endpoint de resumo por mês
- [ ] Criação de testes automatizados
 ## Semana 3 e 4
- [X] Processo de autorização e autenticação
- [X] Deploy da aplicação

## Débito técnico
- [X] Documentação no Swagger
- [ ] Testes automatizados
- [ ] Ajuste no controller de usuários
- [ ] Ajuste no arquivo properties de DEV 

## Stack
- Java 11;
- Springboot;
- PostegreSQL 14;

## Testes unitários
Os testes foram gerados no <a href="https://www.postman.com/">Postman</a>. As coleções foram separadas por tipo de orçamento e estão disponíveis no diretório */postmanUnitTests*.

O processo para execução do teste está documentado no site oficial do <a href="https://www.postman.com/postman/workspace/test-examples-in-postman/collection/1559645-820d771d-70ab-452f-9edd-0904dbc315b8?ctx=documentation">Postman</a>.

Todas as requisições utilizam as seguintes variáveis globais:

```
{{url}}
{{port}}
```
Que representam a URL e a porta do ambiente em que aplicação estiver executando. Caso não utilize as collections online do Postman, é necessário criar as variáveis globais no seu próprio Workspace.


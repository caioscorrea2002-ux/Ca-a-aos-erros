# Sistema Escolar — Spring Boot

Projeto base da atividade **Caça aos Erros** (Programação Web 1 · Senac Rio).

API REST de um sistema escolar de cadastro com **Professor**, **Aluno** e **Matrícula**,
usando Java 17, Spring Boot, Spring Data JPA e banco H2 em memória.

## Como executar

```bash
./mvnw spring-boot:run
```

Com o servidor rodando, teste os endpoints no Insomnia ou no Postman
(`/professores`, `/alunos` e `/matriculas`) e acesse o console do banco em
`http://localhost:8080/h2-console`.


1. Falta de anotações estruturais nos Controllers: Os controladores (AlunoController, ProfessorController, MatriculaController) podem não estar devidamente anotados com @RestController e @RequestMapping, impedindo que o Spring reconheça os endpoints da API.   

2. Ausência de @RequestBody e @Valid nos métodos HTTP: Nos métodos de criação ou alteração, os DTOs (como DadosCadastroAluno e DadosCadastroProfessor) necessitam da anotação @RequestBody para capturar o JSON e @Valid para acionar as regras de validação do Bean Validation.   

3. Ausência de @Transactional nas operações de escrita: Métodos que realizam persistência, atualização ou remoção de dados na base de dados devem incluir a anotação @Transactional para garantir a consistência transacional.   

4. Mapeamento incorreto do Endereço: A classe Endereco deve estar anotada como @Embeddable e ser corretamente incorporada na entidade de domínio correspondente (como Aluno ou Professor), evitando falhas no mapeamento do Hibernate.   

5. Assinatura incorreta nos Repositories: As interfaces de acesso aos dados (AlunoRepository, ProfessorRepository, MatriculaRepository) têm de estender devidamente o JpaRepository<Entidade, Long> com os tipos genéricos corretos.   

6. Inconsistências nos Records (DTOs): Os registos de dados (DadosAtualizacaoAluno, DadosListagemProfessor, etc.) podem conter tipos de atributos ou nomes divergentes em relação aos campos definidos nas entidades principais.   

7. Uso incorreto de Enumerações: As classes de tipo enumerado, como Turno e Disciplina, devem ser referenciadas de forma exata nas entidades e nos respetivos DTOs de cadastro para prevenir erros de conversão e desserialização. 

8. Configurações incompletas nos perfis de propriedades: Os ficheiros de configuração (application.properties, application-dev.properties e application-test.properties) exigem parâmetros válidos para a ligação à base de dados e gestão do dialeto do Hibernate"# Ca-a-aos-erros" 
"# Ca-a-aos-erros" 
"# Ca-a-aos-erros" 
"# Ca-a-aos-erros" 
"# Ca-a-aos-erros" 

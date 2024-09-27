# Tratamento de Base de dados
> Implementa um código para tratar uma base de dados, centralizar estes dados, e por fim, responder algumas perguntas.

### Descrição breve
    O Twitter é uma rede social famosa e que vem sendo constantemente objeto de estudo pelo mundo. Neste trabalho será utilizado um dataset que registra uma análise de sentimentos realizadas em twitters de 15 idiomas diferentes, sendo estas: Albanês, Bósnio, Búlgaro,
    Croata, Inglês, Alemão, Húngaro, Polonês, Português, Russo, Sérvio, Eslovaco, Esloveno, Espanhol e Sueco.
___
### Perguntas à responder
1. Qual o volume de tweets para cada idioma?  
2. Qual o volume total de tweets positivos?  
2.1. E qual o volume total de tweets negativos?  
3. Qual o idioma com mais tweets negativos?  
3.1. Qual o idioma com mais tweets positivos?  
3.2. É possível fazer um ranking dos idiomas?  
4. Algum tweeter teve registro em mais de um idioma?  
4.1. Qual, quais e/ou quantos?

___

### Sobre o Código:

* **Classe Usuário:** Salva os dados dos usuários.
Essa classe foi criada para termos uma ferramenta de comparação global entre alguns dados dos arquivos.

* **Classe Idioma:** Guarda os dados importantes de cada arquivo, sendo estes dados a quantidade de tweets positivos, negativos e netros. Além disso, é salvo a lingua do arquivo para uso posterior.
Essa classe foi criada para termos uma ferramenta de comparação global entre os arquivos.

* **Classe Célula:** Funciona como a célula das listas, guardando dentro de si objetos do tipo idioma.

* **Classe ListaIdioma:** Monta a lista dos idiomas. Possui dois métodos de inserção: um para a lista rankeada por tweets positivos e outro para rankear a lista por tweets negativos. 
Além disso, possui um método para imprimir os valores da lista.


* **Classe ListaUsuarios:** Monta a lista dos usuários. Possui um método de inserção que, além de inserir, testa se o usuário já foi inserido e, caso tenha sido, testa se foi na mesma língua ou em outra língua.
Caso seja de outra língua é somado 1 (um) no contador de línguas, de forma que fica entendido que este usuário tweetou em mais de um idioma.

Após a criação destas classes foi criado a classe "Leitor":

* **Classe Leitor:** Possui um método para ler linha a linha do arquivo passado como parâmetro e criar as listas de usuário e idioma.
Dentro deste método é chamado outro método que verifica qual sentimento o tweet possui. 
No fim, todos os dados obtidos são mandados para serem armazenados dentro da classe DataSet.

Por fim, foram criadas as classes "DataSet" e "Principal":

* **Classe DataSet:** Essa classe funciona como um grande "banco de dados", utilizando métodos "sets" para guardar todos os usuários e idiomas que o leitor enviar. 
Além disso possui um método para cada questão, de forma a processar os dados que foram salvos para responder as perguntas do trabalho.

* **Classe Principal:** Preenche um objeto DataSet com todos os dados necessários para responder as perguntas do trabalho e posteriormente chama um método que acessa as respostas do DataSet.

___
### *Tecnologias Usadas:*
* Java
* Estrutura de dados
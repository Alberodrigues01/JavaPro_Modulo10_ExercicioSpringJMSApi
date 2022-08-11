# JavaPro_Modulo10_ExercicioSpringJMSApi
Exercício para conclusão do Módulo 10 da formação Java-PRO pela Mentorama. 
O objetivo do exercício é a implementação de conceitos e estrutura de programação baseada no framework Spring WebFlux. 
Para tanto é necessário implementar conexões com duas outras funcionalidades: MongoDB como banco de dados e ActiveMQ como "boker" de mensagens.
É importante observar os comandos de configuração registrados no application.properties para conexão com as duas funcionalidades. 
Sendo que o MongoDB deve ser utilizado através da imagem no Docker. 
Observar que o comando para instalar o MongoDB no Docker é:

docker run --name mongodb -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME= #seu username# -e MONGO_INITDB_ROOT_PASSWORD= #sua password# mongo

Utilizar também a interface gráfica do MongoDB: Mongo Compass. Através da interface gráfica será possível visualizar a criação do banco de dados <database.name>
e collections <@Documents>. Observar que deve ser usado os mesmos username e password que foram utilizados na instação do MongoDB no Docker para a criação
da conexão através do Mongo Compass.
O MongoDB funcionará na porta tradicional 27017 e o ActiveMQ na porta 61616.
Observa as @Annotation`s requeridas.
Não utilizamos a Application "extendendo" a especificação "AbstractReactiveMongoConfiguration". Utilizamos a especificação completa de todas as variáveis de 
mapeamento do MongoDB no arquivo application.properties.
A API em si é um CRUD simples de envio de avaliações (notas) sobre filmes.
Utilizar o Postman para simular a comunicação via web.

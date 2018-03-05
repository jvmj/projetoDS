# projetoDS

Algumas observações importantes sobre o projeto:</br>

1 - O main da aplicação está no pacote main, classe Application (br.ufpe.cin.jvmj.main).</br>
2 - A classe ApplicationController (pacote br.ufpe.cin.jvmj.main) especifica os formatos das chamadas à API REST e realiza as requisições solicitadas no exercício. </br>
3 - O modelo de dados proposto para a solução está disponível em: https://github.com/jvmj/projetoDS/blob/master/modeloER.png. A persistência foi implementada utilizando o MS-SQL. </br>
4 - O projeto ao ser iniciado gera as tabelas do referido modelo de dados, bem como os respectivos dados necessários para realizar testes.  Este script é chamado na classe principal do projeto -> Application (pacote br.ufpe.cin.jvmj.main). Caso necessitem, também disponibilizei o arquivo .sql, em https://github.com/jvmj/projetoDS/blob/master/script.sql </br>
5 - A API REST foi construída utilizando o framework Spring. A base do projeto foi montada com base em um projeto disponibilizado pela própria Spring em https://github.com/spring-guides/gs-rest-service, usando o Eclipse Spring Tool Suite com o Maven. A partir deste projeto, todo o modelo de dados e arquitetura foram implementados. Foi adotado o modelo em camadas - essentials - persistence - business - facade. A classe ApplicationController (main) é quem realiza a comunicação com a classe Facade (fachada). </br>

</br>
</br>

Por fim, é importante esclarecer que este projeto é um protótipo simples, no qual procurei elaborar uma arquitetura que fosse mais facilmente mantida e compreendida e que atendesse aos aspectos funcionais solicitados. Como pode ser percebido, alguns tipos de dados precisam ser ajustados, tais como a data do envio (classe Envio) e o array de bytes (classe Arquivo). Seria necessário  ajustar estes tipos no modelo das classes e no modelo de dados e testar o comportamento, principalmente em nível de banco de dados. Outros aspectos como segurança e performance neste momento não foram considerados, por questões de restrição de tempo. Sendo assim,  neste momento procurei me ater aos aspectos funcionais e a uma modelagem que permita uma evolução adequada do código.


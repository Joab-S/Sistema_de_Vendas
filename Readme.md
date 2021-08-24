# Sistema de Vendas

### Integrantes:

* Antonio Gabriel Magalhães Alves - 496218

* Cecília Hélen Nunes Câmara - 500593

* Joab da Silva Rocha - 495920

* Samyra Vitória Lima de Almeida - 497641

* Thiago da Costa Gadelha - 499284

### Instruções de execução:

Fizemos o projeto com JDK 11. Fizemos o front com JavaFX 11, então é necessário ter o javafx baixado para executar.

1. Logar com a conta de nome "Admin" e Senha "Admin" e apertar o botão BuscarVendedores para ver a tabela de vendedores cadastrados.Daí basta
pesquisar pelo ID na tela para ser direcionado para os perfis da tabela para que a senha possa ser vista.
É preferível fazer isso na primeira execução para ver com que usuários se pode logar.

2. No menu de cima, há as funcionalidades Home, Carrinho e Perfil.
Home gera um botão que direciona para a Home(Menu administrador ou menu vendedor)
Carrinho gera um botão que direciona para o carrinho.
Usuário gera um botão para o perfil e outro para sair. O primeiro direciona para a tela de perfil do usuario logado e o outro direciona para 
a tela de login e desloga o usuario.

3. Os cadastros e as remoções são feitos na conta de admin.
No cadastro de produto, não pode passar um produto com o mesmo nome (De qualquer forma, há uma label).
No cadastro de vendedor, não pode passar usuários com o mesmo nome email de outros usuários (De qualquer forma, há uma label).

4. Para adicionar um produto ao carrinho basta adicionar na parte de vendas (Basta apertar o botão de nova venda ou carrinho) ou ir ao menu 
produto(Para ir ao menu produto basta pesquisar o produto por id ou nome).

5. No carrinho, basta pesquisar para adicionar um produto.Pagamento direciona para uma tela para escolher o método de pagamento. Para encerrar o processo, basta apertar em finalizar compra.

6. Para buscar vendas, basta pesquisar pelo id, pelo nome do vendedor ou pela data, ao fim da pesquisa, o usuário será redirecionado para a tela de menu vendas, expondo os dados daquela venda.

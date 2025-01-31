
# **Hortfruit Online: Marketplace**  

🚀 **Hortfruit Online** é uma plataforma digital projetada para conectar empreendedores locais do setor alimentício—como produtores de frutas, verduras e legumes—diretamente aos consumidores da região. A plataforma visa promover o **comércio justo e sustentável**, incentivando a compra de produtos frescos sem intermediários e fortalecendo a economia local.  

## **🔨 Funcionalidades**  
✅ **Cadastro de Produtores**: Permite que empreendedores criem perfis e cadastrem seus produtos.  
✅ **Catálogo de Produtos**: Exibição de itens disponíveis, com filtros por categoria, preço e origem.  
✅ **Carrinho de Compras**: Facilidade para adicionar itens ao carrinho e concluir pedidos.  
✅ **Avaliações e Comentários**: Os consumidores podem avaliar e comentar sobre os produtos e produtores.  
✅ **Sistema de Pagamento Seguro**: Integração para transações online confiáveis.  

---

## **🔧 Tecnologias Utilizadas**  
Backend: Java Spring Boot e Docker (Deploy no Railway)
Frontend: Angular (Deploy no Vercel)
Banco de Dados: PostgreSQL (Deploy no Tembo) 


### **Infraestrutura e Deploy**  
- **Banco de dados hospedado no PlanetScale**  
- **Backend hospedado na Railway**  

---

## **📡 API Endpoints**  
### **Usuário**  
🔹 `GET /user` → Retorna todos os usuários.  
🔹 `GET /user/:id` → Retorna um usuário pelo ID.  
🔹 `POST /user` → Cria um novo usuário.  
🔹 `POST /login` → Autentica um usuário.  
🔹 `POST /logout` → Faz logout do usuário.  

### **Produtos**  
🔹 `GET /products` → Lista todos os produtos.  
🔹 `GET /products/:id` → Retorna detalhes de um produto.  
🔹 `POST /products` → Adiciona um novo produto. *(Autenticado)*  

### **Carrinho de Compras**  
🔹 `POST /cart` → Adiciona um produto ao carrinho.  
🔹 `GET /cart` → Retorna os itens do carrinho do usuário.  
🔹 `DELETE /cart/:id` → Remove um item do carrinho.  

---

## **📸 Layout**  
![Hortfruit Online](https://github.com/user-attachments/assets/fc64bb2e-fc0c-4a85-a96e-e2a7d65e5a5f)  

---

## **🔗 Links Úteis**  
🔹 **Repositório do Projeto**: [GitHub](https://github.com/Yeil-sr/Hortfruit-Online)  
 

📌 **Observação:** Este projeto está em constante aprimoramento e novos recursos podem ser adicionados futuramente!  


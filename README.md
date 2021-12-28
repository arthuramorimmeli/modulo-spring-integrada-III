#Controle Restaurante


API Rest para gerenciar pedidos, mesas e pratos de um restaurante atravez de endpoints.




## Consultas


### Consulta de Pedidos

#### Consultar todas os pedidos
````
 http://localhost:8080/order
````
#### Consultar pedido pelo ID
````
 http://localhost:8080/order/{id}
````

#### Consultar pedidos pelo ID da mesa
````
http://localhost:8080/order/{id}
````

#### Consultar pedido pelo nome da mesa mesa
````
http://localhost:8080/order/{tableName}
````

### Consulta de Mesas (GET)

#### Consulta todas as mesas
````
http://localhost:8080/table
````

#### Consulta mesa por ID
````
http://localhost:8080/table/{id}
````

#### Consulta mesa por nome
````
http://localhost:8080/table/{id}
````


### Consulta de Pratos

#### Consulta todos os pratos
````
http://localhost:8080/dish
````

#### Consulta pratos por ID
````
http://localhost:8080/dish/{id}
````

### Parametros dos Endpoints

Parametro   | Significado
--------- | ------
{id} | Numero identificador
{tableId} | Numero de identificação da mesa
{tableName} | Nome da mesa


## Cadastros (POST)

### Cadastrar Mesa

#### Endpoint
````
http://localhost:8080/table
````

#### Json para enviar as informações
````
{
    "name": "Mesa 2",
    "totalConsumed": 0.0
}
````

### Cadastrar Prato

#### Endpoint
````
http://localhost:8080/dish
````

#### Json para enviar as informações
````
{
    "price": 24.90,
    "description": "Sushi 50 peças"
}
````

### Cadastrar Pedido

#### Endpoint
````
http://localhost:8080/order
````

#### Json para enviar as informações
````
{
    "tableId": 1929329
}
````

### Adicionar Prato a um Pedido

#### Endpoint
````
http://localhost:8080/order/add-dish
````

#### Json para enviar as informações
````
{
    "dishId": 1929329,
    "orderId": 8787878
}
````



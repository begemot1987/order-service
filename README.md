# order-service

Spring Boot REST service that allows to manage create orders and get items by lowest price. Also, there is order validation (The order is valid for 10 minutes. All invalid orders are removed from DB)


## Used technologies
* MySQL
* Hibernate
* Spring Boot
* Maven
* Mockito

## List of endpoints
* `GET: /items` - shows all items stored in DB
* `GET: /items/search?item={item}&quantity={quantity}` - return cheapest item from DB with required quantity. If there are not enough items, return all available.
* `GET: /orders` - shows all orders stored in DB
* `POST: /orders` - save order to DB

## HOW TO USE
1. Install MySQL.
2. Create new schema in MySQL.
3. Fork and clone this project.
4. Replace `YOUR_DATABASE_URL`, `YOUR_USERNAME`, `YOUR_PASSWORD` with your information in `application.properties` file in `src/main/resources` folder.
5. Run this app.
6. Test data will be created on application startup. You may use Postman to manage stored date. For example: <br/>
   `POST: /orders {"quantity" : "5", "itemId" : "1"}` <br/>
7. Have fun :)

Eureka 
http://localhost:8761/eureka


Payement :- Port :- 8088
Service registry :-- /payment
curl --location 'localhost:8088/payment/dopayment'
--header 'Content-Type: application/json'
--data '{
"orderId":"12" , "ammount":199 }' 

Order port :-8089
Service registry :-- /order
curl --location 'localhost:8089/order/add'
--header 'Content-Type: application/json'
--data '{ "order":{ "id":2, "quantity":1, "totalPrice":20000, "name":"Mobile" }, "payment":{} }'

API Gateway 8989

Order

curl --location 'http://localhost:8989/order/add' \
--header 'Content-Type: application/json' \
--data '{
   "order":{ "id":2,
    "quantity":1,
    "totalPrice":122,
    "name":"Mobile"
   },
   "payment":{}
}'

Payment 
curl --location 'http://localhost:8989/payment/dopayment' \
--header 'Content-Type: application/json' \
--data '{    
    "orderId":"12"   ,
    "ammount":199
}'

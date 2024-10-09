Payement :-
Port :- 8088

curl --location 'localhost:8088/payment/dopayment' \
--header 'Content-Type: application/json' \
--data '{    
    "orderId":"12"   ,
    "ammount":199
}'
Order 
port :-8089 

curl --location 'localhost:8089/order/add' \
--header 'Content-Type: application/json' \
--data '{
   "order":{ "id":2,
    "quantity":1,
    "totalPrice":20000,
    "name":"Mobile"
   },
   "payment":{}
}'

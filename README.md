# pruebaIAS
curl --location 'http://localhost:8085/airline' \
--header 'Content-Type: application/json' \
--data '{
    "idUsuario": 1,
    "idVuelo":1,
    "idTiquete":1,
    "ciudad":"Neiva",
    "idReserva": 1
}'
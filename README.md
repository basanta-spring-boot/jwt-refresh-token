# jwt-refresh-token

## Quick steps to understand JWT flow

1. User need to sign up

```
curl --location --request POST 'http://localhost:8080/products/new' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name":"Basant",
    "password":"Pwd1",
    "email":"basant@gmail.com",
    "roles":"ROLE_ADMIN"
}'
```
2. First time user need to login once to generate token 

```
curl --location --request POST 'http://localhost:8080/products/authenticate' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username":"Basant",
    "password":"Pwd1"
}'
```

3. Access the API by passing token as a bearer in authorization header

```
curl --location --request GET 'http://localhost:8080/products/all' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJCYXNhbnQiLCJpYXQiOjE2ODM1Mjk4NzMsImV4cCI6MTY4MzUzMDA1M30.-g4IMlQ5QVr9asPwUjZjzGGDiDHIm-KbKzhdpjLBxB0'
```

4. Try after token expired (It should fail with 403 error)

5. Get the tokenId from DB or from postman and send request to get new token (Refresh Token)

```
curl --location --request POST 'http://localhost:8080/products/refreshToken' \
--header 'Content-Type: application/json' \
--data-raw '{
    "refreshToken":"cabb4071-9293-4e57-b727-49eb6c590100"
}'
```

6. Once you recived the accessToken , continue to use it until it exceed the expiration limit

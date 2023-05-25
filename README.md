## Micronaut Auth Microservice
Auth service for creating user credentials and distributing JWT's 

Application runs on port 8080

## Image
https://github.com/chatgut/micronauth/pkgs/container/micronauth

## Endpoints
<B>Create account:</B>

`POST /auth/register`

<B>Login:</B>

`POST /auth`

<B>JSON example create account and create token:</B>
```
{
  "username":"user1",
  "password": "password"
}
```
<B>Refresh token:</B>

`POST /auth/refresh`

<B>JSON example refresh token:</B>
```
{
  "refresh_token": "eyJhbGciOiJIUzI1NiJ9.MzUyNzczZjItZjA0Ny00ZDQ5LTlmNmQtZGQ4NGM4N2YyYTRh.YxA9Q2w_ca0iZQwxA6XG6Ns1sgtc1NKf0tVHJXr_nG0",
  "grant_type":"refresh_token"
}
```




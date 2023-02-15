# SOLID BANK APP

  REST API Application working with client Accounts. Can authorize and registrate user. Every user will have several bank accounts with unique ID.

## Authorization
  Every request except. Login and register will require "Bearer authorizaiton". That means writing "Bearer + jwt token" to headers each time. 

### Below listed avaliable operations: 

| Reques Type        | Path           | Description  | Body | 
| ------------- |:-------------:| -----:| -----:|
| GET      | /accounts | List all avaliable accounts of the current user | not required |
| POST | /accounts | Create bank account for current user | required "type" (string) of the account |
| GET | /accounts/{account_id} | List current account ({account_id}) | not required |
| DELETE | /accounts/{account_id} | Delete current account ({account_id}) | not required | 
| POST | /accounts/{account_id}/withdraw      | Withdraw some amount of money from current account ({account_id}) | required "amount" (double) for the withdraw | 
| POST | /accounts/{account_id}/deposit      | Deposit some amount of money to current account ({account_id}) | required "amount" (double) for the deposit | 
| GET | /accounts/{account_id}/transactions      | List all transactions for the current account and user | not required | 
| POST | /accounts/{account_id}/transfer      | Transfer all money from one account ({account_id}) to another | required "destination_account_id" (string) for the transfer | 
| POST | /register      | For user registration | required "username" (string) and "password" (string) for the registration | 
| POST | /login      | For user login | required "username" (string) and "password" (string) for the authentication | 
| POST | /perform_logout | For user logout | not required | 

### Additional information
  You can check "/swagger-ui/index.html#/" for the additional API documentation and "/h2-console" for checking database information. Spring security will not secure these two roots.

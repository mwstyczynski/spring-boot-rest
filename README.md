## Repository Content

The following repository contains my attempts to understand REST Endpoints declarations within Spring Boot applications.

The idea is to be able to create user and to have tax calculation returned depending on income threshold within three
values ranges

## Payload Examples

### Create Customer

POST on [http://localhost:8080/user]() with the following payload body example:

`{
"actor": "owner",
"user": {
"firstName": "Adam",
"lastName": "Whatever",
"dateOfBirth": "1990-12-16",
"countryOfResidence": "Japan",
"incomeLastYear": 37.21
}
}`

Will return `customerId` and response `message`.

### Get Customer

GET on [http://localhost:8080/user?id=*****]() -paste `customerId` here

Will return `user` data along with `calculatedTax` value

### Change Income

PUT on [http://localhost:8080/user?id=*****]() with the following payload body example:

`{
"actor": "accountant",
"newIncomeValue": 42.12,
"reason": "Increased balance established"
}`

Will return `customerId` and response `message` along with `updatedTaxCalculation` value.

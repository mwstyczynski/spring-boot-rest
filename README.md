## Repository Content

The following repository contains my attempts to understand REST Endpoints declarations within Spring Boot applications.

The idea is to be able to create user and to have tax calculation returned depending on the taxing threshol, within three
values ranges.

## Available Actions

### Create Customer

POST on [http://localhost:8080/user]() with body declared in
`CreateCustomer.http`- will return `customerId` and response `message`.

### Get Customer

GET on [http://localhost:8080/user?id=*****]() using `customerId`- will return `user` data along with value of
`calculatedTax` and `establishedThreshold`.

### Change Income

PUT on [http://localhost:8080/user?id=*****]() using `customerId`, with body declared in
`ChangeIncome.http`- will return `customerId` and response `message` along with value of `updatedTaxCalculation` and
`updatedThreshold`.

## Tests

Testing framework was created and can be found in
the [Test Automation Framework](https://github.com/mwstyczynski/REST-Test-Automation) repository- tests will work only
after application is running locally and endpoints are available.

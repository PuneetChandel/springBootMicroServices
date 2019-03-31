# springBootMicroServices

1. Deploy on PCF

Name server 
https://nameserver.cfapps.io/

2. Load Bill rates

https://billing-service.cfapps.io/billingService
POST 
{
	"id":1,
	"tier" : "SILVER",
	"amount": 2000
}

Fetch Bill Rates
GET : https://billing-service.cfapps.io/billingService/GOLD

3. Blogger

POST https://blogger-service.cfapps.io/bloggers
{
	"name" : "James Chan",
	"type" : "GOLD"
}

GET https://blogger-service.cfapps.io/bloggers/1

GET Billing https://blogger-service.cfapps.io/bloggers/1/billing

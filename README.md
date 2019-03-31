# springBootMicroServices


Deploy on PCF
1.Load Bill rates

https://billing-service.cfapps.io/billingService
POST 
{
	"id":1,
	"tier" : "SILVER",
	"amount": 2000
}

Fetch Bill Rates
GET : https://billing-service.cfapps.io/billingService/GOLD

2. Blogger

POST https://blogger-service.cfapps.io/bloggers
{
	"name" : "James Chan",
	"type" : "GOLD"
}

GET https://blogger-service.cfapps.io/bloggers/1

GET Billing https://blogger-service.cfapps.io/bloggers/1/billing

We can also use service registry from PCF and there will not be need to create a separte APP for Eureka Naming server

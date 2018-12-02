# SmartHostCodeTest
CodeTask for SmartHost

A SpringBoot application has RestAPI method :

http://127.0.0.1:8080/checkavailability

Method type = POST.
Request Body parameter (type=application/json):

{ 
  "prices":[222,33,44,234],
  "freePremiumRooms":3,
  "freeEconomyRooms":2
} 

Response example:

{
"economyRooms":{
"roomsUsed": 2,
"earned": 77
},
"premiumRooms":{
"roomsUsed": 2,
"earned": 456
}
}


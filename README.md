# SpringRestfulKotlinDemo

You need clone project<br/>
 
And You can run the application using ```./mvnw spring-boot:run``` <br/>

Or you can build the JAR file with ```./mvnw clean package``` <br/>
Then you can run the JAR file: ```java -jar target/spring-restful-kotlin-0.0.1-SNAPSHOT``` <br/>


- ```POST```<br/>
```
  curl -H "Content-Type: application/json" -X POST -d '{ 
    "title" : "first note", 
    "text" : "text note" 
  }' http://localhost:8080/
```

- ```GET``` ```curl http://localhost:8080/```<br/>

Answer :<br/>
```
[
  {
  "id":"0f2f1345-0925-4692-b133-489ac66f9069",
  "title":"first note",
  "text":"text note",
  "dateCreate":1515062987699,
  "dateUpdate":1515062987699
  },
  {
  "id":"753c0c4b-bf21-46b3-94ba-8e6131017395",
  "title":"second note",
  "text":"text note",
  "dateCreate":1515063341874,
  "dateUpdate":1515063341874
  }
]
```

- ```DELETE``` ```http://localhost:8080/{id}```<br/>
```curl -X DELETE http://localhost:8080/10f2f1345-0925-4692-b133-489ac66f9069```<br/>


- ```PUT``` ```http://localhost:8080/{id}```<br/>
```
curl -H "Content-Type: application/json" -X PUT -d '{
    "title":"first note",
    "text":"text update note"
}'  http://localhost:8080/0f2f1345-0925-4692-b133-489ac66f9069
```

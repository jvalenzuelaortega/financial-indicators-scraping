# Scriping Web for Financial Indicators

Aplicacion que hace Scraping para obtener los valores del Dolar, Uf y Euro

## Getting started 🚀

To test the project it is essential to have some tools

See **Deployment** to learn how to deploy the project.


### Prerequisites 📋

```
Java 17
Gradle 7.4.2
Git
```

### Installation 🔧

```
git clone https://github.com/jvalenzuelaortega/financial-indicators-scraping.git
```

```
cd financial-indicators-scraping && cd financialindicators
```

```
gradle build
```

```
gradle run
```

The project should run smoothly.

## Running the tests ⚙️

To run tests use the following command

```
gradle test
```

## Deployment 📦

To test, execute 

```
gradle run
```

Open Postman or HTTPie and run one of the two available URLs

```
http://localhost:9090/get-all-indicators
```

```
http://localhost:9090/get-indicator?indicator=dollar
```
In this endpoint you can use as query param: *uf*, *dollar*, *euro* and *ipv*

**Response**

```json
{"code":200,"message":"Successfully","date":"16/09/2024","data":[{"indicatorName":"uf","value":"37.857,46","localDate":"16/09/2024"},{"indicatorName":"ivp","value":"39.265,44","localDate":"16/09/2024"},{"indicatorName":"dollar","value":"925,61","localDate":"16/09/2024"},{"indicatorName":"euro","value":"1.025,72","localDate":"16/09/2024"}]}

```

```json
{"code":200,"message":"Successfully","date":"16/09/2024","data":"925,61"}
```

## Built with 🛠️


* [Gradle](https://gradle.org/) - Dependency manager
* [Javalin](https://javalin.io/) - lightweight java web framework

## Contributing 🖇️

_In construction ..._

## Versioned 📌

_In construction ..._

## Authors ✒️

* **Juan Valenzuela** - *Base development* - [jvalenzuelaortega](https://github.com/jvalenzuelaortega)
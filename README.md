# Resilienece4j Springboot
- Đây là 1 thư viện java
  ```groovy
     implementation 'org.springframework.cloud:spring-cloud-starter-circuitbreaker-resilience4j'
    implementation group: 'org.springframework.boot', name: 'spring-boot-starter-actuator'
    implementation group: 'org.springframework.boot', name: 'spring-boot-starter-aop'
  ```
## (Circuit Breaker)
```java
 @GetMapping
    @CircuitBreaker(name = SERVICE_A, fallbackMethod = "serviceAFallback")
    public String serviceA(){
        return restTemplate.getForObject(BASE_URL, String.class);
    }
```
- [Kết quả từ service B http://localhost:8080/b](http://localhost:8080/b)
  ![image](https://github.com/chicuongdev2002/Resilience4J_Springboot/assets/124854803/1317d5dc-f311-4125-bc9d-dcb4e9f7453c)
- [Kết quả từ service A http://localhost:8080/a](http://localhost:8080/a)
  ![image](https://github.com/chicuongdev2002/Resilience4J_Springboot/assets/124854803/fb71cfdc-d70e-40ac-8c44-c5ae2dd0840e)
- Kết quả khi tắt Service B sẽ gọi đến phương thức serviceAFallback() được khi báo trong CircuitBreaker
```java
 public String serviceAFallback(Exception e) {
        return "Đây là phương thức dự phòng cho Service A";
    }
```
  ![image](https://github.com/chicuongdev2002/Resilience4J_Springboot/assets/124854803/98e00b0a-6974-41f3-a97c-9d26533fe8fb)
- [Kết quả trang localhost:8081/](http://localhost:8081/actuator/health)http://localhost:8081/actuator/health
```json
{
  "status": "UP",
  "components": {
    "circuitBreakers": {
      "status": "UNKNOWN",
      "details": {
        "serviceA": {
          "status": "CIRCUIT_OPEN",
          "details": {
            "failureRate": "100.0%",
            "failureRateThreshold": "50.0%",
            "slowCallRate": "0.0%",
            "slowCallRateThreshold": "100.0%",
            "bufferedCalls": 3,
            "slowCalls": 0,
            "slowFailedCalls": 0,
            "failedCalls": 3,
            "notPermittedCalls": 2,
            "state": "OPEN"
          }
        }
      }
    }
```
## (Retry)
## (RateLimiter)

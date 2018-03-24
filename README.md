The purpose of this sample project is to use Spring Cloud for microservices and try development
related tasks. 
One of them is to run Integration tests or Smoke tests when other services are involved.
Some things we might want to do
 - Test if we are sending the correct headers to the remote service in a request.
 - As a consumer of API, use canned responses to test features of the Application.
 - Emulate failures for bad requests to remote services and test Failure response handling.

The `GamesController` is a `RestController` that for seemingly useless reasons requests  another
service, `library-service` using `DiscoveryClient`,`Ribbon` and a `Loadbalanced RestTemplate` Bean.
 
 The `library-service` does not exist or is not reachable for the purposes of the Integration Test
 and we need to stub a response that we normally expect from the library service. With that we can
 continue testing the GamesController.
 
 However, due to `DiscoveryClient` and the `LoadBalanced` `RestTemplate` we need to register the
 `library-service` for the Ribbon Client list of hosts otherwise tests will fail. 
 
In this project I attempt different ways to do both local and end-to-end testing when external
services are involved.

 - One way is to disable discovery, change the remote URL to a local Mocked test Controller. This is
 done by using a RestTemplate bean without Ribbon, changing external URL to localhost and optionally
 a Security Configuration that allows access to localhost Mock Controller.
 
 - Use Spring Cloud Contracts verifier with `<skipTests>True</sckipTests>` + 
 Spring Cloud Stub Runner. See branch `spring-cloud-contracts`
 [![Build Status](https://travis-ci.org/abshkd/spring-cloud-sample-games.svg?branch=spring-cloud-contracts)](https://travis-ci.org/abshkd/spring-cloud-sample-games)

 
 - Docker based TestExecutionListener
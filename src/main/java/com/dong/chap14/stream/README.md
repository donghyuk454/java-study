# Sample Project


## 목적

Lambda 와 Stream 을 사용해 간단한 스프링 프로젝트를 유사하게 구현해보기 !

## 주요 class 설명

### Application, Controller, Service, Repository

1) Application 은 Controller 에 있는 함수를 호출한다.
2) Controller.class 는 해당 요청에 맞는 Service 의 메소드를 실행한다. 성공 여부와 결과값을 담은 BaseResponse 를 반환한다.
3) Service 는 비즈니스 로직을 담당한다. 비즈니스 로직에 필요한 데이터는 Repository 에 요청한다.
4) Repository 는 DataManager.class 로 부터 데이터베이스( List )를 받아온다. 이후 조건에 맞는 데이터를 반환한다.

### BaseResponse.class
Controller 가 반환하는 기본적인 Response 형식이다. 요청 성공 여부를 확인할 수 있는 status, 결과값이 담기는 제네릭 타입의 body, 에러가 발생한 경우 에러 메세지가 담긴 message 로 구성되어 있다.

생성자는 정적 팩토리 메소드로 정의하였으며, 총 두 가지가 있다.
1) #### isOk
- 성공인 경우에 사용하기 위한 생성자이다. error 가 아닌 상황이므로 message 는 입력하지 않는다.
2) #### isBadRequest
- 실패인 경우 사용하기 위한 생성자이다. error 를 확인하기 위한 message 를 입력하지만, body 는 입력하지 않는다.

Application 은 해당 객체의 status 를 통해 성공 여부를 확인하고, body 값을 요청의 결과로 확인한다. error 상황인 경우 message 를 확인한다.

### DataManager.class
ArrayList 형식으로 제작한 데이터 베이스와의 연결성을 담당한다.
JPA 의 EntityManager 와 유사한 역할을 하고 있다.
1) #### getData()
- 데이터베이스에 있는 List<Person> 전체를 반환한다.
2) #### persist(Person person)
- 데이터의 영속성, 즉 데이터를 추가하거나 저장한다.
3) #### getAllDataWithMap()
- 데이터베이스에 있는 List 전체를 Map 으로 변환해 반환한다. 
이 때, key 는 person 의 id, value 는 person 객체이다. 

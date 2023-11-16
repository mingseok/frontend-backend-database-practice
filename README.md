## spring과 DB를 연동하여 CRUD 연습하기


본 프로젝트 시작 전 연동을 연습해보기

```
frontend(JSP) <--> backend(spring boot) <--> database(MySQL)
```

<br/>

### 사이드 프로젝트 목표

- JSP를 활용해 frontend 화면을 만들기

- Spring boot로 API 만들기(member 생성, 삭제, 업데이트 등) 

- Spring boot의 API가 호출되면 데이터베이스의 테이블에 데이터가 
  
  생성, 삭제, 업데이트 되도록 spring boot와 데이터베이스 연동하기.

<br/>

### DB 연동 과정 기록

[정리 링크](https://github.com/mingseok/TIL/blob/main/%ED%98%BC%EC%9E%90%EA%B8%B0%EB%8A%A5%EA%B5%AC%ED%98%84/DB%20%EC%97%B0%EA%B2%B0.md#1-mysql-%EB%93%A4%EC%96%B4%EA%B0%80%EA%B8%B0---root-%EC%9C%BC%EB%A1%9C-%EC%9D%BC%EB%8B%A8-%EB%93%A4%EC%96%B4%EA%B0%80%EC%9E%90-%EB%B9%84%EB%B2%88-1234)


<br/><br/>

## 테이블 정보

```sql
# 맴버 테이블
create table members(
    id          int auto_increment,
    login_id    varchar(10) not null,
    member_pwd  varchar(80) not null,
    member_name varchar(10) not null,
    join_date   datetime    not null,
    primary key (id)
);

# 유저 테이블의 role_id 관련
CREATE TABLE user(
    id      BIGINT PRIMARY KEY AUTO_INCREMENT,
    name    VARCHAR(255) NOT NULL,
    email   VARCHAR(255) NOT NULL,
    role_id INT          NOT NULL,
    FOREIGN KEY (role_id) REFERENCES role (id)
);

# 유저
CREATE TABLE role(
    id    INT PRIMARY KEY AUTO_INCREMENT,
    key_id VARCHAR (255) NOT NULL UNIQUE,
    title VARCHAR(255) NOT NULL
);

```

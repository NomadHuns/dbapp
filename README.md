# JDBC를 이용한 자바 dbapp

## JDBC 라이브러리 추가
```gradle
// https://mvnrepository.com/artifact/mysql/mysql-connector-java
implementation group: 'mysql', name: 'mysql-connector-java', version: '8.0.30'
```

## 데이터베이스 테이블 생성
```sql
create database metadb;

use metadb;

create table product (
	id int primary key auto_increment,
    name varchar(50),
    price int,
    qty int,
    created_at timestamp
);
```

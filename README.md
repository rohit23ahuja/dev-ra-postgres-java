# dev-ra-postgres-java
Postgres java playground
* create postgres db.
* create different types of objects in postgres - tables, stored procedures, stored functions etc.
* connect to postgres and call postgres objects using jdbc.
* connect to postgres and call postgres objects using spring jdbc.
* connect to postgres and call postgres objects using spring boot jdbc.
* connect to postgres and call postgres objects using spring jdbc in a spring batch job.
* set up multi module maven project.

## multi module maven project 
* good guide on setting multi module project with spring boot - https://spring.io/guides/gs/multi-module

## jdbc postgres
* in postgres, there are two types of stored objects.
* function that return a result value.
* procedures that can perform transaction control.
* In JDBC both are called using `CallableStatement` using standard JDBC escape call syntax `{call storedobject(?)}`.
* Property with value `escapeSyntaxCallMode=callIfNoReturn` is used to map `CallableStatements` with return value to 
stored functions and `CallableStatements` without return values to stored procedures.

## Reference Links
* https://mkyong.com/maven/maven-how-to-create-a-multi-module-project/
* https://spring.io/guides/gs/multi-module
* https://jdbc.postgresql.org/documentation/callproc/
# Список контактов
___
### Описание проекта
Веб приложение для составление списка контактов про принципу __CRUD__. Архитектура разделена на слои. 
Приложение может:
+ создавать
+ редактировать
+ удалять
Все полученные даныее сохраняються в базе данных MySQL.

### Запуск приложения
Для запуска нужно скачать репозиторий с помощью команды
```
$ git clone {https://github.com/ElvinTM/ContactList.git}
```
Либо скачать тут файл [ZIP](https://github.com/ElvinTM/ContactList/archive/refs/heads/main.zip)

Приложение работает на http://localhost:8080/, однако порт можно добавить в __application.yml.
Данный файл находиться по пути ___ContactList/src/main/resources/application.yml___
```yaml
server:
  port = 8080
```
для этого нужно добавить данную записть с указанием любого другово свободного порта для корректного запуска.

Так же в __application.yml можно изменить настройки подключения к базе данных MySQL.

```yaml
spring:
  application:
    name: ContactList
  jpa:
    generate-ddl: true
  datasource:
    url: jdbc:mysql://localhost/contact?serverTimezone=Europe/Moscow&useSSL=false
    username: root
    password: root
```

### Библиотеки
В работе использовались следующие библиотеки:
* SpringBoot
* SpringDataJPA
* Lombok
* Thymeleaf

# ***Address Analyst***
___
## *Table of contents*
+ Description
+ Program overview
+ Installation
+ Project structure
+ Third party libraries
---
## Description
`Консольное приложение, которое:`

+ Считает путь к файлу
  + ***.xml*** (Пример элемента: ***item city="Братск" street="Большая Октябрьская улица" house="65" floor="5" /***)
  + ***.csv*** (Пример элемента: ***"Братск";"Большая Октябрьская улица";65;5***)
+ Обработает полученные из файла данные
  + Отображает ***дублирующиеся*** записи
  + Отображает, ***сколько в каждом городе 1,2,3,4,5 этажных зданий***

`Технологии`
+ Система сборки ***Maven, Java 19***.
---
## Program overview
___Номинальный режим работы___
+ Старт программы
---
![Image alt](https://github.com/MorozovArYu/Infomaximus/raw/main/src/diagram/startProgram.png)

---
+ Подсчет количества зданий в городе
---
![Image alt](https://github.com/MorozovArYu/Infomaximus/raw/main/src/diagram/countOfFloorsResult.png)

---
+ Подсчет количество повторений в исходных данных
---
![Image alt](https://github.com/MorozovArYu/Infomaximus/raw/main/src/diagram/countOfDuplicateResult.png)

---
+ Остановка программы
---
![Image alt](https://github.com/MorozovArYu/Infomaximus/raw/main/src/diagram/stopProgram.png)

---
___Исключения в работе программы___
___
![Image alt](https://github.com/MorozovArYu/Infomaximus/raw/main/src/diagram/Exceptions.png)

---
## Install
[Скачать ***.jar*** файл](https://github.com/MorozovArYu/Infomaximus/raw/main/target/Infomaximus-1.0-SNAPSHOT.jar) 

Открыть командную строку и перейти в папку с ***.jar*** файлом

Пример:
`cd "/home/usr/"`

Запусть программу командой: `java -jar Infomaximus-1.0-SNAPSHOT.jar`
___
## Project structure
___Программа (MVC)___
![Image alt](https://github.com/MorozovArYu/Infomaximus/raw/main/src/diagram/Infomaximus_javaClasses.png)

___Тесты___
![Image alt](https://github.com/MorozovArYu/Infomaximus/raw/main/src/diagram/Infomaximus_javaTest.png)

___
## Third party libraries
![Image alt](https://github.com/MorozovArYu/Infomaximus/raw/main/src/diagram/Infomaximus_projectModules.png)

---

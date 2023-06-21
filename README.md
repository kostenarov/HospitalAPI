HospitalAPI simulation project
==============================
Съдържание
----------
1. [Описание](#Описание)
2. [Опицание на базата данни](#Описание-на-базата-данни)
3. [Как се ползва](#Как-се-ползва)
4. [Използвани технологии](#Използвани-технологии)

Описание
--------
Проектът представлява симулация на система за управление за болници. Клиентите могат да добавят болници, стаи, легла, пациенти, лекари, операции и линейки.

Описание на базата данни
-------------------------
![image](https://github.com/kostenarov/HospitalAPI/assets/61360809/d1b07fe3-9e20-4c21-a19a-253914c946dc)
Бзата данни се състои от 7 таблица:
* Hospitals - съдържа данни за болниците
* Rooms - съдържа данни за стаите
* Beds - съдържа данни за леглата
* Patients - съдържа данни за пациентите
* Doctors - съдържа данни за лекарите
* Operations - съдържа данни за операциите
* Ambulances - съдържа данни за линейките

Как се ползва
-------------
Проектът може да бъде хостван локално или на облак, като например Microsoft Azure.

Локално хостване:

1.Клоинване на репото
    git clone https://github.com/kostenarov/HospitalAPI.git

2.Конфигуриране на базата данни в MySQL Workbench

3.Конфигуриране на файла application.properties

4.Стартиране на проекта

Облак:
За да се хоства проектът на Microsoft Azure е необходимо да се изпълнят следните стъпки:

1.Клоинване на репото
git clone https://github.com/kostenarov/HospitalAPI.git

2.Конфигуриране на remote database в Azure

3.Създаване нов Spring Web App в Azure

4.Deploy на проекта в Azure

Kubernetes:
За да се хоства проектът на Kubernetes е необходимо да се изпълнят следните стъпки:
1.Клониране на репото

2.Конфигуриране на remote database в Azure

3.Създаване на Dockerfile

4.Създаване на Kubernetes cluster

Използвани технологии
----------------------
Spring Boot, Spring Data JPA, MySQL, Maven, Microsoft Azure



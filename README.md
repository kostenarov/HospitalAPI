![image](https://github.com/kostenarov/HospitalAPI/assets/61360809/2574a0d2-c9b9-4600-a1ae-5607c51f136c)
Hospital REST API.
Hospital: Has field for id, Name and City.
Room: Has fields for id and the id of the hospital it's in.
Bed: Has fields for id, the id of the hospital and the id of the room as well as the id of the patient that is in it.
Ambulance: So far only id and the id of the hospital
Abstract class Person that has the following atributes: First name, last name and age fo the person.(In the works)
Patient: Id, age, first and last name, operation, if any, bed and the admission date
Doctor:  Id, age, first and last name, operations(one doctor can participate in multiple operations, but only one doctor can participate in an operation) and hospital.

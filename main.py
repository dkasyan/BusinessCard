#from faker import Faker
#fake = Faker()

#fake.name()
#import Faker
#import os 

class BaseContact:
    def __init__(self, name, surname, email):
        self.name = name
        self.surname = surname
        self.email = email

class BusinesCard(BusinessContact):
    def __init__(self, max_load, *args, **kwargs):
        super().__init__(*args, **kwargs)
        self.max_load = max_load
        self.company_name = company_name
        self.company_position = company_position


  #  Używając dziedziczenia, rozdziel podstawową klasę wizytówki na dwie osobne: pierwsza (BaseContact) powinna przechowywać podstawowe dane kontaktowe takie jak imię, nazwisko, telefon, adres e-mail. Za pomocą kolejnej klasy (BusinessContact) rozszerz klasę bazową o przechowywanie informacji związanych z pracą danej osoby – stanowisko, nazwa firmy, telefon służbowy.
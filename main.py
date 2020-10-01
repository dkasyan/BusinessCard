from faker import Faker
fake = Faker('pl_PL')

#fake.profile()
fake_profil = fake.profile()
name = str.split(fake_profil["name"])[0]
surname = str.split(fake_profil["name"])[1]
phone = str.split(fake_profil["ssn"])[0]
email = str.split(fake_profil["mail"])[0]

class BaseContact:
    def __init__(self, name, surname, phone, email):
        self.name = name
        self.surname = surname
        self.phone = phone
        self.email = email

class BusinessContact(BaseContact):
    def __init__(self,  )
        self.job = job
        self.company = company
        



#stanowisko, nazwa firmy, telefon służbowy.
##BaseContact(name, surname, phone, email)
 #   def __str__(self):
 #       return 'sadaf'

 #   def napisz(osoba):
 #       print(f'{osoba.e}')


#class BusinessContact(BaseContact):

#    def __init__(self, kolor, *args):
#        self.k = kolor
#        super().__init__(*args)

 #   def makijaż(self):
 #       print(f'szminka w kolorze {self.k}')


#osoby = [
#    BusinessContact(faker.color(), faker.first_name(), faker.last_name(), faker.email()) for _ in range(10)
#]

#for osoba in osoby:
#    osoba.makijaż()


#class BaseContact:
#    def __init__(self, name, surname, email):
 #       self.name = faker.name()
 #       self.surname = surname
 #       self.email = email
 #       self.company = faker.company
 #   def printname():
 #       print(faker.name())        

#class BusinesCard(BusinessContact):
#    def __init__(self, max_load, *args, **kwargs):
#        super().__init__(*args, **kwargs)
#        self.max_load = max_load
#        self.company_name = company_name
#        self.company_position = company_position

#BaseContact()
  #  Używając dziedziczenia, rozdziel podstawową klasę wizytówki na dwie osobne: pierwsza (BaseContact) powinna przechowywać podstawowe dane kontaktowe takie jak imię, nazwisko, telefon, adres e-mail. Za pomocą kolejnej klasy (BusinessContact) rozszerz klasę bazową o przechowywanie informacji związanych z pracą danej osoby – stanowisko, nazwa firmy, telefon służbowy.
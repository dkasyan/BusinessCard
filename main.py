from faker import Faker
import phonenumbers 
from phonenumbers import carrier
from phonenumbers.phonenumberutil import number_type
import logging


logging.basicConfig(level=logging.DEBUG, format='%(asctime)s %(message)s', filename="logfile.log")

number = "+49 176 1234 5678"
carrier._is_mobile(number_type(phonenumbers.parse(number))) 

fake = Faker('pl_PL')

class BaseContact:
    def __init__(self, name, surname, phone, email):
        self.name = name
        self.surname = surname
        self.phone = phone
        self.email = email
    
    def contact(self):
        print(f'Wybieram numer {self.phone} i dzwonie do {self.name} {self.surname}')
    def __str__(self):
        return f'{self.name} {self.surname} {self.phone} {self.email}'

class BaseContact:

    def __init__(self, name, surname, phone, email):
        self.name = name
        self.surname = surname
        self.phone = phone
        self.email = email


    def contact(self):
        print(f'Wybieram numer {self.phone} i dzwonie do {self.name} {self.surname}')

    def __str__(self):
        return f'{self.name} {self.surname} {self.phone} {self.email}'

    @property
    def label_length(self):
        # TODO: czy potrzebujemy az tylu zmiennych?
        a = len(self.name)
        b = len(self.surname)
        c = a + b
        return c


class BusinessContact(BaseContact):
    def __init__(self, job, company, businesphone, *args, **kwargs):
        super().__init__(*args, **kwargs)
        self.job = job
        self.company = company
        self.businesphone = businesphone

    def contact(self):
        print(f'Wybieram numer {self.businesphone} i dzwonie do {self.name} {self.surname}')

    def __str__(self):
        return f'{self.name} {self.surname} {self.phone} {self.email} {self.job} {self.company} {self.businesphone}'

def create_contacts(business, amount):
    for i in range(amount):
        fakek_profil = fake.profile()
        fk_name = str.split(fakek_profil["name"])[0]
        fk_surname = str.split(fakek_profil["name"])[1]
        fk_phone = fake.phone_number()
        fk_email = str.split(fakek_profil["mail"])[0]
        fk_job = str.split(fakek_profil["job"])
        fk_company = fake.bs()
        fk_businesphone = fake.phone_number()
        if business == False:
            private = BaseContact(name=fk_name, surname=fk_surname, phone=fk_phone, email=fk_email)
            private.contact()
        else:
            business = BusinessContact(name=fk_name, surname=fk_surname, phone=fk_phone, email=fk_email, job=fk_job, company=fk_company, businesphone=fk_businesphone)
            business.contact()



create_contacts(False, 4)
create_contacts(True, 2)





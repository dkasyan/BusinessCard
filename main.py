from faker import Faker
import phonenumbers 


from phonenumbers import carrier
from phonenumbers.phonenumberutil import number_type

number = "+49 176 1234 5678"
carrier._is_mobile(number_type(phonenumbers.parse(number))) 

fake = Faker('pl_PL')



#fake.profile()
fake_profil = fake.profile()
f_name = str.split(fake_profil["name"])[0]
f_surname = str.split(fake_profil["name"])[1]
f_phone = fake.phone_number()
f_email = str.split(fake_profil["mail"])[0]
f_job = str.split(fake_profil["job"])
f_company = fake.bs()
f_businesphone = fake.phone_number()


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
    def label_length(self):
        a = len(self.name)
        b = len(self.surname)
        c = a + b 
        print(f'Długość imienia i nazwiska to {c}')


class BusinessContact(BaseContact):
    def __init__(self, name, surname, phone, email, job, company, businesphone):
        super().__init__(name, surname, phone, email)
        self.job = job
        self.company = company
        self.businesphone = businesphone

    def contact(self):
        print(f'Wybieram numer {self.businesphone} i dzwonie do {self.name} {self.surname}')

    def __str__(self):
        return f'{self.name} {self.surname} {self.phone} {self.email} {self.job} {self.company} {self.businesphone}'

print("################")      
kolega = BaseContact(name = f_name, surname = f_surname, phone = f_phone, email = f_email)
kolega.contact()
#print(kolega)
kolega.label_length()
print("################")
wspolpracownik = BusinessContact(name = f_name, surname = f_surname, phone = f_phone, email = f_email, job = f_job, company = f_company, businesphone = f_businesphone)
wspolpracownik.contact()
#print(wspolpracownik)
##### losowa wizytówka

def create_contacts (type, amount):



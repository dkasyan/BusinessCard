from faker import Faker
fake = Faker('pl_PL')

fake_profil = fake.profile()
fake_company = fake.bs()
print(fake_profil)
print(str.split(fake_profil["mail"])[0])
print(fake_company)
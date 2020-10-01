from faker import Faker
fake = Faker('pl_PL')

fake_profil = fake.profile()

print(str.split(fake_profil["mail"])[0])
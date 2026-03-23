from zeep import Client

wsdl = 'http://localhost:9001/banque?wsdl'

client = Client(wsdl=wsdl)

solde = client.service.consulterSolde(1)
print("Solde :", solde)

client.service.deposer(1, 500)
client.service.retirer(1, 200)

print("Nouveau solde :", client.service.consulterSolde(1))

compte = client.service.getCompte(1)
print("Solde :", compte)
from fastapi import FastAPI
from pydantic import BaseModel
import pickle

app = FastAPI(title="Bank API - BI & AI")

class Client(BaseModel):
    name: str
    income: float
    age: int
    debt: float
    default: bool  

db = []

try:
    with open("model_bank.pkl", "rb") as f:
        model = pickle.load(f)
except:
    model = None

@app.post("/clients/")
def create_client(client: Client):
    db.append(client)
    return {"message": "Client ajouté", "id": len(db)-1}

@app.get("/clients/")
def list_clients():
    return {"clients": db, "total": len(db)}

@app.get("/clients/{client_id}")
def get_client(client_id: int):
    if client_id < len(db):
        return db[client_id]
    return {"error": "Client non trouvé"}

@app.get("/kpi/total_clients")
def total_clients():
    return {"total_clients": len(db)}

@app.get("/kpi/avg_income")
def avg_income():
    if len(db) == 0:
        return {"avg_income": 0}
    avg = sum(c.income for c in db) / len(db)
    return {"avg_income": avg}

@app.get("/kpi/default_rate")
def default_rate():
    if len(db) == 0:
        return {"default_rate": 0}
    count = sum(1 for c in db if c.default)
    return {"default_rate": count / len(db)}

@app.get("/kpi/risk_clients")
def risk_clients():
    count = sum(1 for c in db if c.debt > 3000)
    return {"risk_clients": count}

@app.post("/predict")
def predict(client: Client):
    if model is None:
        return {"error": "Modèle non chargé"}

    features = [[client.income, client.age, client.debt]]
    prediction = model.predict(features)[0]

    return {
        "client": client.name,
        "decision": prediction
    }
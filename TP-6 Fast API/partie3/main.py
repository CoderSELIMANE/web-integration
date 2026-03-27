from fastapi import FastAPI
from pydantic import BaseModel
import pickle

app = FastAPI(title="E-commerce API with BI & AI")

class Item(BaseModel):
    name: str
    price: float
    in_stock: bool = True
    sales: int
    views: int

db = []

try:
    with open("model.pkl", "rb") as f:
        model = pickle.load(f)
except:
    model = None

@app.post("/items/")
def create_item(item: Item):
    db.append(item)
    return {
        "message": "Item créé avec succès",
        "item": item,
        "id": len(db) - 1
    }

@app.get("/items/{item_id}")
def read_item(item_id: int):
    if item_id < len(db):
        return db[item_id]
    return {"error": "Item not found"}

@app.get("/items/")
def list_items():
    return {
        "items": db,
        "count": len(db)
    }

@app.get("/kpi/total_products")
def total_products():
    return {"total_products": len(db)}

@app.get("/kpi/total_value")
def total_value():
    total = sum(item.price for item in db)
    return {"total_value": total}

@app.get("/kpi/in_stock")
def in_stock_products():
    count = sum(1 for item in db if item.in_stock)
    return {"in_stock": count}

@app.post("/predict")
def predict(item: Item):
    if model is None:
        return {"error": "Modèle non chargé. Exécute training.py d'abord."}

    features = [[item.price, item.sales, item.views]]
    prediction = model.predict(features)[0]

    return {
        "product": item.name,
        "prediction": prediction
    }
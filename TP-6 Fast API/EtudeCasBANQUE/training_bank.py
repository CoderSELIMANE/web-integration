from sklearn.tree import DecisionTreeClassifier
import pickle

data = [
    {"income": 5000, "age": 30, "debt": 1000, "label": "Accepté"},
    {"income": 2000, "age": 25, "debt": 3000, "label": "Risque"},
    {"income": 1000, "age": 40, "debt": 5000, "label": "Refusé"},
    {"income": 7000, "age": 35, "debt": 500, "label": "Accepté"},
    {"income": 3000, "age": 28, "debt": 2000, "label": "Risque"},
    {"income": 1500, "age": 50, "debt": 4000, "label": "Refusé"}
]

X = [[d["income"], d["age"], d["debt"]] for d in data]
y = [d["label"] for d in data]

model = DecisionTreeClassifier()
model.fit(X, y)

with open("model_bank.pkl", "wb") as f:
    pickle.dump(model, f)

print("Modèle banque prêt")
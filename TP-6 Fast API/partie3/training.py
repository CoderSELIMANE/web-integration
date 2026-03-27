from sklearn.tree import DecisionTreeClassifier
import pickle

data = [
    {"price": 50, "sales": 200, "views": 1000, "label": "High"},
    {"price": 1200, "sales": 20, "views": 200, "label": "Low"},
    {"price": 300, "sales": 80, "views": 500, "label": "Medium"},
    {"price": 20, "sales": 300, "views": 1500, "label": "High"},
    {"price": 800, "sales": 40, "views": 300, "label": "Low"},
    {"price": 150, "sales": 120, "views": 700, "label": "Medium"}
]

X = [[d["price"], d["sales"], d["views"]] for d in data]
y = [d["label"] for d in data]

model = DecisionTreeClassifier()
model.fit(X, y)

with open("model.pkl", "wb") as f:
    pickle.dump(model, f)

print("Modèle entraîné et sauvegardé (model.pkl)")
import streamlit as st
import requests

st.title(" Dashboard Banque")

st.header("Ajouter un client")

name = st.text_input("Nom")
income = st.number_input("Revenu")
age = st.number_input("Age")
debt = st.number_input("Dette")
default = st.checkbox("Défaut de paiement")

if st.button("Ajouter"):
    data = {
        "name": name,
        "income": income,
        "age": age,
        "debt": debt,
        "default": default
    }
    res = requests.post("http://127.0.0.1:8000/clients/", json=data)
    st.success("Client ajouté")

st.header("KPI")

if st.button("Afficher KPI"):
    total = requests.get("http://127.0.0.1:8000/kpi/total_clients").json()
    avg = requests.get("http://127.0.0.1:8000/kpi/avg_income").json()
    rate = requests.get("http://127.0.0.1:8000/kpi/default_rate").json()

    st.write(total)
    st.write(avg)
    st.write(rate)

st.header("Prédiction crédit")

if st.button("Prédire"):
    data = {
        "name": name,
        "income": income,
        "age": age,
        "debt": debt,
        "default": default
    }
    res = requests.post("http://127.0.0.1:8000/predict", json=data)
    st.write(res.json())
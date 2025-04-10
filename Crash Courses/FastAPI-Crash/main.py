# --------------------------------------------
# FASTAPI TEA API - BEGINNER PRACTICE PROJECT
# --------------------------------------------

# ------------ IMPORTS ------------

from fastapi import FastAPI  # FastAPI framework for building APIs
from pydantic import BaseModel  # For data validation and structure
from typing import List  # To define list types

app = FastAPI()  # Creating an instance of the FastAPI class, which will handle all routing and request handling.

# Data model using Pydantic for validation
class Tea(BaseModel):
    id: int
    name: str
    origin: str

# In-memory storage (resets when server restarts)
teas: List[Tea] = []

# Root route
@app.get("/")
def read_root():
    return {"message": "Welcome to apni pathshala"}

# Get all teas
@app.get("/teas")
def get_teas():
    return teas

# Add new tea
@app.post("/teas")
def add_tea(tea: Tea):
    teas.append(tea)
    return tea

# Update existing tea by ID
@app.put("/teas/{tea_id}")
def update_tea(tea_id: int, updated_tea: Tea):
    for index, tea in enumerate(teas):
        if tea.id == tea_id:
            teas[index] = updated_tea
            return updated_tea
    return {"error": "Tea not found"}

# Delete tea by ID
@app.delete("/teas/{tea_id}")
def delete_tea(tea_id: int):
    for index, tea in enumerate(teas):
        if tea.id == tea_id:
            deleted = teas.pop(index)
            return deleted
    return {"error": "Tea not found"}

#!/bin/bash

APP_NAME="main"

if ! command -v python3 &> /dev/null && ! command -v python &> /dev/null
then
    echo "Python is not installed. Please install Python 3.7+ to continue."
    exit 1
fi

PYTHON_CMD=$(command -v python3 || command -v python)

if [ ! -d "venv" ]; then
  echo "Creating virtual environment..."
  $PYTHON_CMD -m venv .venv
fi

source venv/bin/activate 2>/dev/null || source venv/Scripts/activate

pip install --upgrade pip
pip install -r requirements.txt
pip install fastapi uvicorn

echo "Running FastAPI server..."
uvicorn "$APP_NAME:app" --reload

# 🍵 FastAPI - Apni Pathshala Tea API

A simple FastAPI project to manage a collection of teas.  
This project demonstrates basic RESTful API operations using FastAPI.

---

## 📚 Features

- `GET /` → Welcome message
- `GET /teas` → Get all teas
- `POST /teas` → Add a new tea
- `PUT /teas/{tea_id}` → Update an existing tea
- `DELETE /teas/{tea_id}` → Delete a tea

---

## ⚙️ Requirements

- Python 3.7 or above
- pip

---

## 🚀 Installation & Run Instructions

You can run this project on both **Linux/macOS** and **Windows**.

### 🟢 Option 1: Use the `run.sh` Script (Linux/macOS or Git Bash on Windows)

> Ensure you have `bash` installed on Windows or run in WSL/Git Bash terminal.

1. Clone the repo
   ```bash
   git clone https://github.com/theNKCodes/Code_Journey.git
   cd "Crash Courses/FastAPI-Crash"
   ```

2. Make the script executable:
   ```bash
   chmod +x run.sh
   ```

3. Run the script:
   ```bash
   ./run.sh
   ```

The script will:
- Create and activate a virtual environment
- Install FastAPI and Uvicorn
- Run the FastAPI server on `http://127.0.0.1:8000`

---

### 🔵 Option 2: Manual Setup

1. **Clone the repo**
   ```bash
   git clone https://github.com/theNKCodes/Code_Journey.git
   cd "Crash Courses/FastAPI-Crash"
   ```

2. **Create a virtual environment**
   - Linux/macOS:
     ```bash
     python3 -m venv venv
     source venv/bin/activate
     ```
   - Windows:
     ```bash
     python -m venv venv
     venv\Scripts\activate
     ```

3. **Install dependencies**
   ```bash
   pip install fastapi uvicorn
   ```

4. **Run the server**
   ```bash
   uvicorn main:app --reload
   ```

---

## 🌐 API Endpoints

### `GET /`
Returns:
```json
{
  "message": "Welcome to apni pathshala"
}
```

---

### `GET /teas`
Returns a list of teas:
```json
[
  {
    "id": 1,
    "name": "Bubble Tea",
    "origin": "Homemade"
  }
]
```

---

### `POST /teas`
Add a new tea:

**Request Body:**
```json
{
  "id": 1,
  "name": "Bubble Tea",
  "origin": "Homemade"
}
```

---

### `PUT /teas/{tea_id}`
Update a tea:

**Request Body:**
```json
{
  "id": 1,
  "name": "Bubble Tea",
  "origin": "Japan"
}
```

---

### `DELETE /teas/{tea_id}`
Deletes a tea by its ID.

---

## 🔬 API Testing (CURL Examples)

### Get Root
```bash
curl -X GET http://127.0.0.1:8000/
```

### Get All Teas
```bash
curl -X GET http://127.0.0.1:8000/teas
```

### Add a Tea
```bash
curl -X POST http://127.0.0.1:8000/teas \
  -H "Content-Type: application/json" \
  -d '{"id": 1, "name": "Bubble Tea", "origin": "Homemade"}'
```

### Update a Tea
```bash
curl -X PUT http://127.0.0.1:8000/teas/1 \
  -H "Content-Type: application/json" \
  -d '{"id": 1, "name": "Bubble Tea", "origin": "Japan"}'
```

### Delete a Tea
```bash
curl -X DELETE http://127.0.0.1:8000/teas/1
```

---

## 📖 API Docs

Once running, you can explore your API using:
- Swagger UI: [http://127.0.0.1:8000/docs](http://127.0.0.1:8000/docs)
- Redoc: [http://127.0.0.1:8000/redoc](http://127.0.0.1:8000/redoc)

---

## 📝 Notes

- All data is **in-memory** (not persistent).
- Restarting the server will clear the data.
- This project is suitable for learning and prototyping FastAPI.

---

## 👨‍💻 Author

Made with ❤️ for learning FastAPI and building beautiful APIs by Nikhil Kamble 😇

This provides a complete setup with both the documentation and automation script needed to run the project. The `run.sh` script simplifies the setup process for Unix-based systems and Git Bash on Windows.

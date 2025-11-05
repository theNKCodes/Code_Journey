---

# 🐘 PostgreSQL Practice Guide

Welcome to my PostgreSQL practice repository!
This document is a full record of the SQL commands, concepts, and relationships I practiced using the PostgreSQL `psql` terminal.

---

## 🧠 Basics

### Print anything in terminal

```bash
echo "hello PostgreSQL"
```

### Connect to PostgreSQL

```bash
psql --username=freecodecamp --dbname=postgres
```

---

## 🗄️ Working with Databases

### List all databases

```sql
\l
```

### Create a new database

```sql
CREATE DATABASE database_name;
```

### Connect to a database

```sql
\c database_name
```

### Rename a database

```sql
ALTER DATABASE database_name RENAME TO new_database_name;
```

---

## 📋 Working with Tables

### List all tables

```sql
\d
```

### Create a table

```sql
CREATE TABLE table_name();
```

You can also create a table with columns directly:

```sql
CREATE TABLE table_name(
  column_name DATATYPE CONSTRAINTS
);
```

### Drop a table

```sql
DROP TABLE table_name;
```

---

## ✏️ Table Modifications

### Add a column

```sql
ALTER TABLE table_name ADD COLUMN column_name DATATYPE;
```

### Drop a column

```sql
ALTER TABLE table_name DROP COLUMN column_name;
```

### Rename a column

```sql
ALTER TABLE table_name RENAME COLUMN column_name TO new_name;
```

### Add a constraint (e.g. NOT NULL)

```sql
ALTER TABLE table_name ADD COLUMN column_name VARCHAR(30) NOT NULL;
```

### Add a primary key

```sql
ALTER TABLE table_name ADD PRIMARY KEY(column_name);
```

### Drop a constraint

```sql
ALTER TABLE table_name DROP CONSTRAINT constraint_name;
```

### Add a numeric column

```sql
ALTER TABLE table_name ADD COLUMN weight NUMERIC(4,1);
```

> **NUMERIC(4,1)** = 4 digits total, 1 after the decimal.

---

## 🔢 Data Types Overview

| Data Type       | Description                             |
| --------------- | --------------------------------------- |
| `SERIAL`        | Auto-incrementing integer with NOT NULL |
| `VARCHAR(n)`    | String of up to `n` characters          |
| `NUMERIC(p, s)` | Decimal number (precision, scale)       |
| `DATE`          | Date in format `'YYYY-MM-DD'`           |

---

## 📥 Inserting Data

### Insert one row

```sql
INSERT INTO table_name(column_1, column_2) VALUES(value1, value2);
```

### Insert multiple rows

```sql
INSERT INTO characters(name, homeland, favorite_color)
VALUES
('Mario', 'Mushroom Kingdom', 'Red'),
('Luigi', 'Mushroom Kingdom', 'Green'),
('Peach', 'Mushroom Kingdom', 'Pink');
```

---

## 🔍 Querying Data

### View specific columns

```sql
SELECT column1, column2 FROM table_name;
```

### View all columns

```sql
SELECT * FROM table_name;
```

### Order results

```sql
SELECT * FROM table_name ORDER BY column_name;
```

---

## ✏️ Updating and Deleting Data

### Update data

```sql
UPDATE table_name SET column_name = new_value WHERE condition;
```

Example:

```sql
UPDATE characters SET favorite_color = 'Orange' WHERE name = 'Daisy';
```

### Delete data

```sql
DELETE FROM table_name WHERE condition;
```

Example:

```sql
DELETE FROM characters WHERE username = 'Luigi';
```

---

## 🔗 Relationships and Keys

### One-to-One Relationship

Add a **foreign key** with a **UNIQUE** and **NOT NULL** constraint:

```sql
ALTER TABLE table_name ADD COLUMN column_name INT REFERENCES referenced_table(column_name);
ALTER TABLE table_name ADD UNIQUE(column_name);
ALTER TABLE table_name ALTER COLUMN column_name SET NOT NULL;
```

Example: linking `characters` and `more_info`.

---

### One-to-Many Relationship

Example: one character can have many sounds.

```sql
ALTER TABLE sounds ADD COLUMN character_id INT NOT NULL REFERENCES characters(character_id);
```

---

### Many-to-Many Relationship

Create a **junction table** (e.g. `character_actions`):

```sql
CREATE TABLE character_actions();

ALTER TABLE character_actions
ADD FOREIGN KEY(character_id) REFERENCES characters(character_id);

ALTER TABLE character_actions
ADD FOREIGN KEY(action_id) REFERENCES actions(action_id);

ALTER TABLE character_actions
ADD PRIMARY KEY(character_id, action_id);
```

> The **composite primary key** (`character_id`, `action_id`) ensures unique pairs.

---

## 📅 Working with Dates

Format: `'YYYY-MM-DD'`

```sql
INSERT INTO more_info(birthday, height, weight)
VALUES ('1989-07-31', NULL, NULL);
```

---

## 🔊 Example Tables and Relationships

### Example Table: `sounds`

```sql
CREATE TABLE sounds(
  sound_id SERIAL PRIMARY KEY,
  sound VARCHAR(40) NOT NULL UNIQUE,
  character_id INT NOT NULL REFERENCES characters(character_id)
);
```

### Example Table: `actions`

```sql
CREATE TABLE actions(
  action_id SERIAL PRIMARY KEY,
  action VARCHAR(40) NOT NULL UNIQUE
);
```

### Example Junction Table: `character_actions`

```sql
CREATE TABLE character_actions(
  character_id INT REFERENCES characters(character_id),
  action_id INT REFERENCES actions(action_id),
  PRIMARY KEY(character_id, action_id)
);
```

---

## 🔍 Joining Tables

### One-to-One Join

```sql
SELECT * FROM characters
FULL JOIN more_info
ON characters.character_id = more_info.character_id;
```

### One-to-Many Join

```sql
SELECT * FROM characters
FULL JOIN sounds
ON characters.character_id = sounds.character_id;
```

### Many-to-Many Join (Three Tables)

```sql
SELECT * FROM character_actions
FULL JOIN characters ON character_actions.character_id = characters.character_id
FULL JOIN actions ON character_actions.action_id = actions.action_id;
```

---

## 🏁 Summary

✅ Learned how to:

* Create, connect, and rename databases
* Create, alter, and drop tables
* Insert, update, delete, and select data
* Add constraints, primary keys, and foreign keys
* Understand relationships (One-to-One, One-to-Many, Many-to-Many)
* Perform JOIN operations
* Use different data types effectively

---

### 💡 Tip

You can always view schema details in PostgreSQL using:

```sql
\d table_name
```

---

### 🏆 Congratulations!

You now understand core PostgreSQL concepts, relationships, and commands. Keep practicing and building larger database systems! 🚀

---
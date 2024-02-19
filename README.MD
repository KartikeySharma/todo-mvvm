# Todo List App

A simple todo list app written in Kotlin using Room Database.

## Features

- Add new todo items.
- Mark todo items as checked or unchecked.
- Delete todo items.
- View a list of all todo items.

## Structure of files in src
```
+---data
|   |   TodoRepository.kt
|   |
|   \---db
|           Todo.kt
|           TodoDao.kt
|           TodoDatabase.kt
|
\---ui
MainActivity.kt
TodoAdapter.kt
TodoViewModel.kt
```

## Getting Started

### Prerequisites

- Android Studio installed.
- Emulator or a physical Android device.

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/todo-list-app.git

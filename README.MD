# Todo List App

A simple Android Todo List application written in Kotlin following the MVVM architecture pattern.

## What does the App do?
The Todo List App allows users to create and manage a TODO list with text-only items, 
mark items as DONE or NOT DONE, and persist the list across app sessions using Room Database. 
You can also delete TODO list items individually.

The app provides a simple solution for organizing and tracking tasks.

## Features
- Create a TODO list with text-only items.
- Mark TODO list items as DONE or NOT DONE.
- Delete TODO list items (both DONE/NOT DONE).
- Persistent storage of TODO list items using Room Database.
- Single-screen user interface designed to be intuitive and user-friendly.

## Architecture
The app follows the Model-View-ViewModel (MVVM) architecture pattern:
- Model: The Todo data class represents a TODO list item, and the TodoDatabase with TodoDao manages data persistence.
- View: The MainActivity serves as the single-screen user interface, displaying the TODO list and handling user interactions.
- ViewModel: The TodoViewModel acts as an intermediary between the UI and data, providing data to the UI and handling user actions.

## File Structure
The TODO android app follows the Model-View-ViewModel (MVVM) architecture pattern, 
separating concerns into data, UI, and the core of the application. Here's a brief description:
```
\---todo
    |   
    |---data: Contains the data layer components.
    |   |   
    |   |---TodoRepository.kt: Manages the data access and serves as a single source of truth for the UI.
    |   |
    |   \---db: Houses the database-related components.
    |       |   
    |       |---Todo.kt: Represents the data model for a Todo item.
    |       |---TodoDao.kt: Defines the Data Access Object (DAO) for interacting with the Todo database.
    |       |---TodoDatabase.kt: Implements the Room Database for storing Todo items.
    |   
    \---ui: Contains the user interface components following the MVVM architecture.
        |   
        |---MainActivity.kt: Serves as the main entry point for the application and hosts the UI components.
        |---TodoAdapter.kt: Manages the presentation of Todo items in a RecyclerView.
        |---TodoViewModel.kt: Acts as an intermediary between the UI and the data, providing data to the UI and handling user interactions.

```

## Getting Started

### Prerequisites
- Android Studio installed.
- Emulator or a physical Android device 
  - Enable USB Debugging via Developer Options in Settings

- Gradle Script Requirements
  - Java JDK VERSION_17
  - For more details, have a look at the Gradle config below
  
<details> 
<summary>Click to expand</summary>

```
defaultConfig {
        applicationId = "com.example.todo"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
```
</details>

### Installation

1. Download the project zip file from [this link](https://github.com/ma-shamshiri/Human-Activity-Recognition#readme).
2. Extract the contents of the zip file to your preferred location.
3. Open Android Studio.
4. Click on "File" > "Open Project" and navigate to the location where you extracted the project.
5. Select the "todo-list-app" directory.
6. Build and run the app on your preferred emulator or device.


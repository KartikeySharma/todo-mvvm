# Todo List App

A simple todo list app written in Kotlin using Room Database.

## Features

- Add new todo items.
- Mark todo items as checked or unchecked.
- Delete todo items.
- View a list of all todo items.

## Architecture and File Structure
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

1. Download the project zip file from [this link](<provide your download link here>).
2. Extract the contents of the zip file to your preferred location.
3. Open Android Studio.
4. Click on "File" > "Open Project" and navigate to the location where you extracted the project.
5. Select the "todo-list-app" directory.
6. Build and run the app on your preferred emulator or device.


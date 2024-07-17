# My Notes 
---

# Notes Application

A simple notes application built using Kotlin, following the MVVM pattern, and utilizing Hilt for dependency injection. The application uses Room for database persistence and Jetpack Compose for the UI.

## Features

- Create, update, and delete notes
- View notes in a list
- Search notes
- Store notes locally using Room
- Clean architecture with MVVM pattern
- Dependency injection with Hilt
- Modern UI with Jetpack Compose

## Getting Started

### Prerequisites

- Android Studio 4.2 or higher
- Kotlin 1.5.0 or higher
- Gradle 7.0 or higher

### Installation

1. Clone the repository from GitHub.
2. Open the project in Android Studio.
3. Build the project using Gradle.
4. Run the project on an Android emulator or device.

## Architecture

This project follows the MVVM (Model-View-ViewModel) architecture pattern:

- *Model*: Represents the data layer, including the Room database and repository.
- *View*: Composed of Jetpack Compose UI components.
- *ViewModel*: Provides data to the UI and handles user interactions.

## Dependency Injection

The project uses Hilt for dependency injection. Hilt simplifies the process of providing dependencies in Android applications.

### Setting Up Hilt

1. Add the Hilt dependencies to your project-level and app-level build.gradle files.
2. Annotate your Application class with @HiltAndroidApp.

## Persistence

Room is used for local data storage. It provides an abstraction layer over SQLite to allow fluent database access while harnessing the full power of SQLite.

### Setting Up Room

1. Add the Room dependencies to your build.gradle file.
2. Create your Entity, Dao, and Database classes.

## User Interface

The UI is built using Jetpack Compose, Android's modern toolkit for building native UI.

### Setting Up Compose

1. Add the Compose dependencies to your build.gradle file.
2. Enable Jetpack Compose in your build.gradle file.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request.

## Contact

If you have any questions or feedback, feel free to reach out to:

- Shakya (GitHub: shakya1527)
- Email: sinhashakya15@gmail.com
---

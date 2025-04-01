# Robondroid

This project will guide you through creating a comprehensive Android application using a modern toolkit, using Kotlin and Jetpack Compose

## Features
- Comprehensive Kotlin implementation.
- Highly modular and maintainable codebase.
- Sample project demonstrating the latest tech stacks.
- Follows MVVM with Clean Architecture.
- Uses Jetpack Compose for modern UI development.

## Getting Started

### Prerequisites
- Kotlin 1.5 or above
- Gradle 6.8 or above
- Firebase Setup: To integrate Firebase, create a new project in the Firebase console, register your app, and download the google-services.json file. Place this file in your app's app directory. This step is crucial for utilizing Firebase Auth

### Installation
1. Clone the repository:
    ```sh
    git clone https://github.com/RkrishnaRobo/Robondroid.git
    cd Robondroid
    ```
2. Build the project:
    ```sh
    ./gradlew build
    ```

### Running the Application
To run the application, use the following command:
```sh
./gradlew installDebug
```

This will compile the project and install the debug APK on a connected device or emulator.

Alternatively, you can assemble the debug APK without installing it:
```sh
./gradlew assembleDebug
```

You can then manually install the APK from the `app/build/outputs/apk/debug/` directory.

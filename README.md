# Robondroid

This project will guide you through creating a comprehensive Android application using a modern toolkit. Designed following the principles of Clean Architecture, utilizing a multi-modular approach. It includes several layers, including the UI Layer, Domain Layer, Data Layer,to ensure a solid separation of concerns and enhance maintainability.

## Features
- Comprehensive Kotlin implementation.
- Highly modular and maintainable codebase.
- Sample project demonstrating the latest tech stacks.
- Follows MVVM with Clean Architecture.
- Uses Jetpack Compose for modern UI development.

## Tech Stack & Open-source Libraries

- **[Kotlin](https://kotlinlang.org/)**: The primary language for application development, emphasizing safety, simplicity, and interoperability.
  
- **[Jetpack Compose](https://developer.android.com/jetpack/compose)**: Used for modern UI development, leveraging custom composables and animations for a dynamic and responsive design.
  
- **[Multi-Module](https://developer.android.com/topic/modularization)**: Multi-module architecture is a great way to achieve code separation and provide easily testable code and a high understanding of the project structure.
  
- **Asynchronous Programming**:
   - **[Coroutines](https://github.com/Kotlin/kotlinx.coroutines)** and **[Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/)**: Manage asynchronous tasks and streamline data stream processing, guaranteeing a smooth user experience.

- **Dependency Injection Frameworks**:
   - **[Hilt](https://dagger.dev/hilt/)**: Provide scalable and maintainable object creation and management, optimizing app architecture and development workflow.

- **[Ktor](https://ktor.io/docs/client-create-new-application.html)**: Ktor is a lightweight, asynchronous web framework for Kotlin. It’s built on top of coroutines, making it a perfect fit for modern asynchronous programming in Kotlin

- **[Kotlin Symbol Processing (KSP)](https://github.com/google/ksp)**: Streamlines code generation and processing, enhancing development efficiency.

- **Jetpack Libraries**:
   - **ViewModel**: Centralizes UI-related data management, making it resilient to configuration changes.
   - **SavedStateHandle**: Enhances state management by preserving UI data across system-initiated process terminations.
 
- **Material Design 3**: Adopts the latest Material Design guidelines for a cohesive, dynamic user interface and enhanced user experience, leveraging the newest components, theming, and layout principles.
  
- **Authentication Systems**:
   - **Firebase Auth**: Offers support for diverse authentication mechanisms, including email & password and Gmail, ensuring secure user access and streamlined account management.

- **Code Quality Tools**:
   - **[Detekt](https://github.com/detekt/detekt)**: Monitors code quality and maintainability, enforcing best practices and coding standards.
   - **[Ktlint](https://ktlint.github.io/)**: Enforces Kotlin coding standards and formatting guidelines to ensure consistent code style across the project.

- **Project Organization**:
   - Implements a multi-module structure with a version catalogue, promoting modular development and easier dependency management.
  
[Coming up next ...]

- **Database and Storage Solutions**:
   - **[Proto DataStore](https://developer.android.com/topic/libraries/architecture/datastore#proto-datastore)**: A modern, type-safe data storage solution that leverages Kotlin coroutines and Flow for storing structured data asynchronously, securely, and consistently. Proto DataStore uses protocol buffers to serialize data, enabling more complex data storage scenarios than traditional key-value stores.
   - **[SQLDelight](https://github.com/sqldelight/sqldelight?tab=readme-ov-file)**: If Room provides an abstraction layer over SQLite, SQLDelight takes it a step further.It generates type-safe Kotlin APIs from SQL statements. In a Kotlin multi-platform world,‘data’ layer is key here, as it needs to be consistent across all platforms. This is where SQLDelight steps in, ensuring a reliable and uniform data layer across various environments.
     
- **Image Loading and Animation Libraries**:
   - **Coil**: Efficiently loads and displays images, optimizing memory and network usage.
   - **Lottie**: Implements complex animations sourced from JSON files, enriching the UI with engaging visuals.
 
- **Testing Suite**:
   - Employs **JUnit 4 & 5**, **[Mockk](https://mockk.io/)**, and **[turbine](https://github.com/cashapp/turbine)** for comprehensive testing across units and integration points.

- **Performance Optimization**:
  - **Baseline Profiles**: Enhances app startup and runtime performance by pre-compiling essential methods.
  - **Macrobenchmark**: Optimizes critical user journeys, addressing performance bottlenecks for a smoother experience.

- **Continuous Integration and Deployment** (CI/CD):
   - **GitHub Actions**: Automates testing, building, and deployment, streamlining development cycles.

### Architecture Overview

![robondroid_arch](https://github.com/user-attachments/assets/00367924-e625-4a2e-b077-a4144737a35c)

           

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

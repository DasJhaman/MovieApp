# Movies App

The Movies App serves as a working model for a Kotlin Multiplatform (KMP) project. It demonstrates the effective utilization of Kotlin's capabilities, 
showcasing the power of creating cross-platform applications from a single source code through the use of Jetpack Compose Multiplatform.

# Template Features
The Movies App comes with several preconfigured features to accelerate your development process:

<ul>
<li> Version Catalogs </li>
<li> Compose Multiplatform </li>
<li> Koin for dependency injection </li>
<li> Ktor for networking </li>
<li> BuildKonfig embedding values from gradle file </li>
<li> Voyger for screen  </li>
<li> Kotlin serialization </li>
<li> Moko resource for shared string resources, fonts and images</li>
</ul>

# iOS with German Language
![image](https://github.com/DasJhaman/MovieApp/assets/8167091/918c6574-5aa0-4795-8e9f-e1ecf0b63250)
![image](https://github.com/DasJhaman/MovieApp/assets/8167091/b140cc98-af0c-4a86-9ca7-34a9f06642cf)

# Android with English Language
![image](https://github.com/DasJhaman/MovieApp/assets/8167091/24308e84-96bd-4469-8736-513ded6a4189)
![image](https://github.com/DasJhaman/MovieApp/assets/8167091/9723cf98-9c7a-4940-978f-6ec75f303ae5)


## Run the app

- Open this directory in Android Studio.
- Wait for gradle to sync dependencies.
- Please add following values to your local properties file:
```
  API_BASE_URL=https://api.themoviedb.org/3/
  IMAGE_BASE_URL=https://image.tmdb.org/t/p/w780
  AUTH_TOKEN={$value}
```
- Please replace '{$value}' to your original bearer token which you ll get it by singing up https://www.themoviedb.org/
- Build & run the app.
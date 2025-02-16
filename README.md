# Drizzle 
Drizzle is a weather forecast app built using Java, allowing users to check current and future weather conditions for their location and selected locations.

## Screenshots
<img src="https://github.com/user-attachments/assets/4db25a4e-77d8-435a-879d-c77c96940368" width=300/>
<img src="https://github.com/user-attachments/assets/db276c06-f30d-420f-9c95-26d260c3f778" width=300/>
<img src="https://github.com/user-attachments/assets/f5c98907-0c34-4357-b1f9-6c3f02c2115f" width=300/>
<img src="https://github.com/user-attachments/assets/0d411de1-64be-461f-afd6-3154377761e3" width=300/>
<img src="https://github.com/user-attachments/assets/1daef3ee-3d9f-4871-aa01-f9c53f7ad91c" width=300/>
<img src="https://github.com/user-attachments/assets/83b31e25-ffa7-4e29-ae41-1c3e556b919a" width=300/>

## Features

### User Interface
* Intuitive NavigationUI for seamless navigation (Current Weather, Forecast, Settings).
* Visually appealing Material Design layouts.
* Fragment-based architecture for modularity.
* Uses TextView, ImageView, RecyclerView, and MaterialCardView for effective weather display.

### Location Services
* Uses FusedLocationProviderClient for location retrieval.
* Requests location permissions (Manifest.permission.ACCESS_FINE_LOCATION) and handles them smoothly.
  
### Weather Data Display
* Fetches real-time weather data from Free Weather API.
* Displays temperature, humidity, wind speed, and weather icons.
* Provides hourly and daily forecasts.
* Supports both device location and custom locations.

### UI Customization
* Light and dark mode support.
* Options to customize font sizes and color schemes.
* Responsive layouts using ConstraintLayout.
* Orientation support(landscape and portrait)

### Fragment Management and Navigation
* Uses FragmentManager to manage different screens.
* Implements NavigationUI for smooth user experience.
* Includes a navigation drawer or bottom navigation bar.

## Tech Stack

* Programming Language: Java
* UI Design: XML, Material Design
* API Integration: Free Weather API (https://www.weatherapi.com/)
* Location Services: FusedLocationProviderClient
* Navigation: NavigationUI, FragmentManager
* Storage: SharedPreferences
* Networking: Retrofit
* DI : Hilt
* State management : ViewModel

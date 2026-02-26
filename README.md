# MusicProfiler

Builds a mood-specific user profile based on tag data pulled from Last.FM

## Overview

MusicProfiler analyzes your music listening habits from Last.FM to build a personalized mood-based profile. By extracting and analyzing the tags associated with your favorite tracks, it identifies patterns in your music preferences and categorizes them by mood and genre.

This is an Android application built with Gradle and AndroidX.

## Features

- Fetch listening data from Last.FM API
- Analyze track tags to determine mood patterns
- Generate mood-specific user profiles

## Requirements

- Android Studio (Arctic Fox or newer)
- JDK 11 or higher
- Android SDK 34

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/ajansen7/MusicProfiler.git
   cd MusicProfiler
   ```

2. Open the project in Android Studio:
   - File → Open → Select the `MusicProfiler` folder
   - Wait for Gradle sync to complete

3. Configure your Last.FM API key in `app/src/.../MainActivity.java`

4. Build and run on an emulator or device:
   - Build → Build APK(s)

## License

See [LICENSE](LICENSE) for more information.

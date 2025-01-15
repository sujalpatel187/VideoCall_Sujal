# Video Call App

This is an Android video call application built using Kotlin and XML. The app leverages the ZEGOCLOUD API for video call connectivity and functionality. API calls are handled using OkHttp, and the project is developed in Android Studio.

## Features
- One-to-one video calling functionality.
- Seamless video and audio streaming using ZEGOCLOUD API.
- Simple and user-friendly UI designed with XML layouts.
- Network communication implemented with OkHttp for API calls.

## Getting Started

### Prerequisites
Before you begin, ensure you have the following:
- Android Studio installed on your system.
- A ZEGOCLOUD account for obtaining the required App ID and App Sign.
- Internet connectivity for API communication.

### Setup Instructions
1. Clone this repository:
   ```bash
   git clone https://github.com/sujalpatel187/VideoCall_Sujal.git
   ```

2. Open the project in Android Studio.

3. Add your ZEGOCLOUD credentials:
   - Sign up or log in to your [ZEGOCLOUD account](https://www.zegocloud.com/).
   - Obtain your App ID and App Sign from the ZEGOCLOUD dashboard.
   - Add these credentials in your `strings.xml` file:
     ```xml
     <string name="zego_app_id">YOUR_APP_ID</string>
     <string name="zego_app_sign">YOUR_APP_SIGN</string>
     ```

4. Sync the project with Gradle to download all dependencies.

### Dependencies
Ensure the following dependencies are added to your `build.gradle` file:
```gradle
implementation 'com.squareup.okhttp3:okhttp:4.9.3'
implementation 'com.zegocloud:zego-zim-sdk:latest_version'
```
Replace `latest_version` with the latest version available on the [ZEGOCLOUD SDK documentation](https://docs.zegocloud.com/).

## Usage
1. Launch the app on an Android device or emulator.
2. Enter the necessary details to connect with another user.
3. Initiate a video call.

## Project Structure
- **UI (XML layouts)**: Designed to provide a simple and interactive user experience.
- **Kotlin**: Handles application logic and integrates ZEGOCLOUD SDK.
- **OkHttp**: Used for API calls.

## Contributing
Contributions are welcome! Follow these steps to contribute:
1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Commit your changes and push them to your fork.
4. Submit a pull request.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact
For any queries or suggestions, feel free to reach out:
- GitHub: [Sujal Patel](https://github.com/sujalpatel187)

---

Happy coding!


📚 BookAppCompose
An elegant and modular Android app for browsing books, built entirely with Jetpack Compose. 
This project demonstrates Clean Architecture principles, offline caching, and seamless API integration — all written in Kotlin.

🛠️ Built With
Kotlin

Jetpack Compose

MVVM + Clean Architecture

Room DB

Dagger Hilt

Retrofit

Coroutines + Flow

Navigation Compose

📱 Features
🔍 Search for books from remote API

🗂️ Browse a list of books with beautiful UI

❤️ Add to favorites (stored offline with Room)

⚡ Fast performance with asynchronous loading

🔁 Uses Flow for reactive UI updates

🔒 Follows Clean Architecture (data, domain, UI layers)

🧠 Architecture Overview
│
├── data         // Remote & local data sources
│   ├── api
│   ├── db
│   └── repository
│
├── domain       // Business logic
│   ├── model
│   └── usecase
│
├── presentation // UI layer (Compose)
│   ├── screens
│   └── viewmodel

▶️ Getting Started
1.Clone the repository:
git clone https://github.com/nouryashy/BookAppCompose.git

2.Open in Android Studio (Hedgehog or later)

3.Run on emulator or physical device

💡 Future Improvements
* Add dark mode support
  
* Implement paging
  
* UI tests with Compose Test APIs
  
* Lottie animations for empty states

🤝 Contribution
Contributions are welcome! If you'd like to improve this project, feel free to fork and open a pull request.

📄 License
MIT License © Nourhan Ashmawy

🔗 Connect with Me
* LinkedIn :https://www.linkedin.com/in/nourhan-ashmawy/

* GitHub :https://github.com/nouryashy

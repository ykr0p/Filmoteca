plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.google.devtools.ksp") version "1.9.0-1.0.13" // Plagin KSP for обработки annotations Room

}

android {
    namespace = "com.example.filmoteca"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.filmoteca"
        minSdk = 27
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true // Turn on ViewBinding
    }

}

dependencies {
    // Network requests
    implementation(libs.okhttp)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)

    // Загрузка изображений
    implementation(libs.coil)

    // Архитектурные компоненты
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.runtime.ktx)

    // Data base
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.ksp) // Обработчик аннотаций Room

    // Асинхронность
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)

    // JSON
    implementation(libs.gson)

    // UI components
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.recyclerview)
    implementation(libs.activity.ktx) // Для by viewModels()

    // Tests
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Material Design 3
    implementation(libs.androidx.benchmark.macro)
    implementation(libs.my.library)

    // обёртка над стандартным Log в Android
    implementation(libs.timber)
}
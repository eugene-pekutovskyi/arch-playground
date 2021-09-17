plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = Versions.COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = "com.eugene.pekutovskyi.archplayground"
        minSdkPreview = Versions.MIN_SDK_VERSION
        targetSdk = Versions.TARGET_SDK_VERSION
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xjvm-default=compatibility")
    }
}

dependencies {
    implementation(Libs.ANDROID_X_CORE)
    implementation(Libs.APP_COMPAT)
    implementation(Libs.MATERIAL)
    implementation(Libs.CONSTRAINT_LAYOUT)

    //dagger
    implementation(Libs.DAGGER)
    kapt(Libs.DAGGER_ANDROID_PROCESSOR)
    kapt(Libs.DAGGER_COMPILER)

    //rxjava
    implementation(Libs.RX_JAVA)

    //ribs
    implementation(Libs.RIB_ANDROID)
    annotationProcessor(Libs.RIB_COMPILER)
    testImplementation(Libs.RIB_TEST)

    testImplementation(Libs.JUNIT)
}
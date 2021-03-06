object ApplicationId {
    val id = "id.co.rezkyauliapratama.multi_module_cleanarch_kotlin"
}

object Release {
    val versionCode = 1
    val versionName = "1.0"

    val compileSdkVersion = 28
    val targetSdkVersion = 28
    val minSdkVersion = 17
}

object Config {
    val gradle = "com.android.tools.build:gradle:3.4.0"
    val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlinVersion}"
}

object Version {
    // Kotlin based
    const val kotlinVersion = "1.3.31"
    const val kotlinCoreVersion = "1.0.2"

    //RxJava & RxAndroid
    const val rxkotlinVersion = "2.2.0"
    const val rxandroidVersion = "2.1.0"
    const val rxbindingVersion = "2.1.1"

    //Dagger
    const val daggerVersion = "2.18"

    //Networking
    const val retrofitVersion = "2.4.0"
    const val okhttpLoggingVersion = "3.11.0"

    //Android jetpack
    const val appcompatVersion = "1.1.0-alpha05"
    const val constraintLayoutVersion = "2.0.0-alpha5"
    const val navigationVersion = "1.0.0"
    const val lifecycleVersion = "2.0.0"
    const val materialComponentVersion = "1.0.0"
    const val legacySupportVersion = "1.0.0"

    //test
    const val testRunnerVersion = "1.1.1"
    const val junitVersion = "4.12"
}

object Dependencies {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.kotlinVersion}"
}

object Support {
    val core = "androidx.core:core-ktx:${Version.kotlinCoreVersion}"
    val appCompat = "androidx.appcompat:appcompat:${Version.appcompatVersion}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.constraintLayoutVersion}"
    val lifeCycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Version.lifecycleVersion}"
    val materialComponent = "com.google.android.material:material:${Version.materialComponentVersion}"
    val legacySupport = "androidx.legacy:legacy-support-v4:${Version.legacySupportVersion}"
}

object Retrofit {
    val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofitVersion}"
    val gsonConverter = "com.squareup.retrofit2:converter-gson:${Version.retrofitVersion}"
    val adapterRxJava = "com.squareup.retrofit2:adapter-rxjava2:${Version.retrofitVersion}"
    val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Version.okhttpLoggingVersion}"
}

object Reactivex {
    val android = "io.reactivex.rxjava2:rxandroid:${Version.rxandroidVersion}"
    val kotlin = "io.reactivex.rxjava2:rxkotlin:${Version.rxkotlinVersion}"
    val rxBinding = "com.jakewharton.rxbinding2:rxbinding:${Version.rxbindingVersion}"
}

object Dagger {
    val dagger = "com.google.dagger:dagger:${Version.daggerVersion}"
    val daggerCompiler = "com.google.dagger:dagger-compiler:${Version.daggerVersion}"
}

object TestLibs {
    val junit = "junit:junit:${Version.junitVersion}"
    val testRunner = "androidx.test:runner:${Version.testRunnerVersion}"
}
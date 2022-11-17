plugins {
    id("me.him188.maven-central-publish") version "1.0.0-dev-3"
    kotlin("multiplatform") version "1.7.10"
    kotlin("plugin.serialization") version "1.7.10"
}

group = "net.ormr.userskripter"
version = "0.0.1-dev-6"

repositories {
    mavenLocal()
    mavenCentral()
}

mavenCentralPublish {
    useCentralS01()
    singleDevGithubProject("Olivki", "userskripter")
    licenseApacheV2()
}

kotlin {
    explicitApi()

    js(IR) {
        binaries.library()
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }

    sourceSets {
        val jsMain by getting {
            languageSettings {
                optIn("kotlin.contracts.ExperimentalContracts")
            }

            dependencies {
                api("org.jetbrains.kotlinx:kotlinx-html:0.7.5")
                api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
                api("org.kodein.di:kodein-di:7.14.0")
                api("org.kodein.di:kodein-di-conf:7.14.0")
                api("net.ormr.kcss:kcss-dsl:0.1.0")
                api("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.0-RC")
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}
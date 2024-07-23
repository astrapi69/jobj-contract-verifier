# Configuring Multiple Maven Repositories in Gradle

This guide will show you how to configure multiple Maven repositories in your Gradle project's `repositories` section.

## Step 1: Set Up Your `build.gradle`

Ensure your `build.gradle` includes the necessary configurations. Here's an example configuration with multiple repositories:

```groovy
plugins {
    id 'java'
    id 'maven-publish'
}

group = 'com.example'
version = '1.0-SNAPSHOT'

repositories {
    maven {
        name = 'github-repo'
        url = uri('https://github.com/YOUR_USERNAME/YOUR_REPOSITORY/raw/master/releases')
    }
    maven {
        name = 'another-repo'
        url = uri('https://another.repository.url/releases')
    }
    maven {
        name = 'yet-another-repo'
        url = uri('https://yet.another.repository.url/releases')
    }
    mavenCentral()
}

dependencies {
    implementation 'com.example:my-project:1.0-SNAPSHOT'
    // Add more dependencies here
}

publishing {
    publications {
        mavenJava(MavenPublication) {
            from components.java
        }
    }
    repositories {
        maven {
            name = 'github'
            url = uri('https://github.com/YOUR_USERNAME/YOUR_REPOSITORY/raw/master/releases')
        }
    }
}
```

## Step 2: Upload Published Artifacts

Create a releases directory in your repository and move the latest version of your published artifacts to this directory:
```shell
mkdir releases
mv build/publications/mavenJava/* releases/{your-package-path}/{latest-release-version}/
mv ~/.m2/repository/{your-package-path}/{latest-release-version}/* releases/{your-package-path}/{latest-release-version}/
```
Replace the placeholder {your-package-path} and {latest-release-version} with the appropriate values

Note: you have also have an xml file 'maven-metadata.xml' in the directory 'releases/{your-package-path}/' so the hole
path of the file would be 'releases/{your-package-path}/maven-metadata.xml'

Here is a version with a shell script to automate the movement of published artifacts into the appropriate folders 
based on the variables for {your-package-path} and {latest-release-version}. This script takes command-line arguments 
for these variables to make the process more dynamic.

**Shell Script: move_artifacts.sh**
```shell
#!/bin/bash

# Check if the correct number of arguments was passed
if [ "$#" -ne 2 ]; then
    echo "Usage: $0 your-package-path latest-release-version"
    exit 1
fi

# Assign command-line arguments to variables
PACKAGE_PATH=$1
RELEASE_VERSION=$2

# Create the necessary directory structure
mkdir -p releases/${PACKAGE_PATH}/${RELEASE_VERSION}

# Move artifacts from the build directory to the releases directory
mv build/publications/mavenJava/* releases/${PACKAGE_PATH}/${RELEASE_VERSION}/

# Move artifacts from the local Maven repository
mv ~/.m2/repository/${PACKAGE_PATH}/${RELEASE_VERSION}/* releases/${PACKAGE_PATH}/${RELEASE_VERSION}/

# Move the maven-metadata.xml file to the appropriate directory
mv ~/.m2/repository/${PACKAGE_PATH}/maven-metadata-local.xml releases/${PACKAGE_PATH}/maven-metadata.xml

# Output the status
echo "Artifacts moved successfully to releases/${PACKAGE_PATH}/${RELEASE_VERSION}/"
```
# Usage Instructions for the Script:

1. **Ensure the script is executable:**
   You might need to make the script executable by running the following command:
```shell
chmod +x move_artifacts.sh
```
2. **Run the script with appropriate arguments:**
   Execute the script by providing the package path and the release version as arguments:
```shell
./move_artifacts.sh your-package-path latest-release-version
```
This script simplifies the process of organizing your artifacts into the correct directories on your local machine
before you push them to your GitHub repository. It helps maintain a structured release directory that aligns with 
Maven's standard repository layout, facilitating easier dependency management for consumers of your library.

## Step 3: Configure Git and Upload Files

Initialize the repository, add files, and push them to GitHub:
```shell
git init
git add .
git commit -m "Initial commit"
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/YOUR_REPOSITORY.git
git push -u origin main
```

## Step 4: Gradle Repository Configuration for Consumers

Consumers of your Maven repositories can add the following configurations to their build.gradle to access the various repositories:
```groovy
repositories {
    maven {
        url "https://github.com/YOUR_USERNAME/YOUR_REPOSITORY/raw/master/releases"
    }
    maven {
        url "https://another.repository.url/releases"
    }
    maven {
        url "https://yet.another.repository.url/releases"
    }
    mavenCentral()
}

dependencies {
    implementation 'com.example:my-project:1.0-SNAPSHOT'
    // Add more dependencies here
}
```

By following these steps, you will have configured multiple Maven repositories in your Gradle project.

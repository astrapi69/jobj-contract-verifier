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
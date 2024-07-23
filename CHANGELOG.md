## Change log
----------------------

Version 5.2
-------------

CHANGED:

- update of gradle to new version 8.9
- replaced test dependency testng with junit-jupiter
- removed unused dependency easy-random
- rename of module to io.github.astrapisixtynine.jobj.contract.verifier

Version 5.1
-------------

ADDED:

- new class ContractVerifier created
- new annotation class Experimental created
- new check methods in class EqualsHashCodeAndToStringCheck created

Version 5
-------------

ADDED:

- new libs.versions.toml file for new automatic catalog versions update

CHANGED:

- update of jdk to version 17
- update of gradle to new version 8.8
- update gradle-plugin dependency of com.github.ben-manes:gradle-versions-plugin to new version 0.51.0
- update of gradle-plugin dependency 'com.diffplug.spotless:spotless-plugin-gradle' to new minor version 7.0.0.BETA1
- update of gradle-plugin org.ajoberstar.grgit:grgit-gradle to new version 5.2.2
- update of dependency randomizer to new version 10.2
- update of test dependency test-object to new version 8.2
- update of test dependency testng to new version 7.10.2
- replaced obsolete dependency jobj-clone with the new dependency jobj-cloner in version 2.1

Version 4
-------------

ADDED:

- new gradle-plugin 'com.diffplug.spotless:spotless-plugin-gradle' in version 6.9.1 for formatting source code

CHANGED:

- update of jdk to version 11
- update of gradle to new version 7.5.1
- update of gradle-plugin org.ajoberstar.grgit:grgit-gradle to new version 5.0.0
- update of dependency randomizer version to 8.6
- update of test dependency test-object to new version 6.1

Version 3.5
-------------

ADDED:

- new gradle-plugin org.ajoberstar.grgit:grgit-gradle in version 4.1.1 for create git tags
- new gradle options for improve gradle build performance
- new dependency org.jeasy:easy-random-core in version 4.3.0

CHANGED:

- update of gradle to new version 7.3.3
- update of dependency jobj-clone to new version 3.4
- update of gradle-plugin com.github.ben-manes.versions to new version 0.41.0
- update of dependency randomizer version to 8.5
- update of test dependency testng to new version 7.5
- update of test dependency test-objects to new version 5.7
- removed of dependency io.github.benas:random-beans

Version 3.4
-------------

CHANGED:

- update of gradle to new version 6.9
- update of dependency jobj-clone to new version 3.3
- update of gradle-plugin com.github.ben-manes.versions to new version 0.39.0
- update of dependency randomizer-core version to 8
- update of test dependency testng to new version 7.4.0
- update of test dependency test-objects to new version 5.4
- changed to new package io.github.astrapi69

Version 3.3
-------------

ADDED:

- new build system gradle

CHANGED:

- removed maven build system and all related files
- removed all lombok dependent imports
- update of dependency randomizer-core version to 6.8

Version 3.2
-------------

CHANGED:

- update of parent version to 5
- update of dependency randomizer-core version to 6.0.1

Version 3.1.2
-------------

CHANGED:

- update of dependency randomizer-core version to 5.8.3
- update of dependency test-objects version to 5.2

Version 3.1.1
-------------

CHANGED:

- update of dependency jobject-clone version to 3.1.2
- update of dependency randomizer-core version to 5.8.2

Version 3.1
-------------

ADDED:

- new class ContractVerifier created that can verify a given class the contracts of the methods equals, hashcode and toString

CHANGED:

- update of dependency jobject-clone version to 3
- update of test-objects dependency version to 5.0.1

Version 3
-------------

ADDED:

- this changelog file
- created PULL_REQUEST_TEMPLATE.md file
- created CODE_OF_CONDUCT.md file
- created CONTRIBUTING.md file
- provide package.html for the javadoc of packages
- moved classes from obsolet jobject-evaluate project

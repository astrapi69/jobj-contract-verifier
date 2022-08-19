# Overview

<div style="text-align: center">

[![Build Status](https://api.travis-ci.com/astrapi69/jobj-contract-verifier.svg?branch=develop)](https://travis-ci.com/github/astrapi69/jobj-contract-verifier)
[![Coverage Status](https://coveralls.io/repos/github/astrapi69/jobj-contract-verifier/badge.svg?branch=develop)](https://coveralls.io/github/astrapi69/jobj-contract-verifier?branch=develop)
[![Open Issues](https://img.shields.io/github/issues/astrapi69/jobj-contract-verifier.svg?style=flat)](https://github.com/astrapi69/jobj-contract-verifier/issues)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/de.alpharogroup/jobj-contract-verifier/badge.svg)](https://maven-badges.herokuapp.com/maven-central/de.alpharogroup/jobj-contract-verifier)
[![Javadocs](http://www.javadoc.io/badge/de.alpharogroup/jobj-contract-verifier.svg)](http://www.javadoc.io/doc/de.alpharogroup/jobj-contract-verifier)
[![MIT license](http://img.shields.io/badge/license-MIT-brightgreen.svg?style=flat)](http://opensource.org/licenses/MIT)
[![Hits Of Code](https://hitsofcode.com/github/astrapi69/jobj-contract-verifier)](https://hitsofcode.com/github/astrapi69/jobj-contract-verifier/view)
[![Lines Of Code](https://tokei.rs/b1/github/astrapi69/jobj-contract-verifier)](https://github.com/astrapi69/jobj-contract-verifier)

</div>

Utility library for verify if java objects fulfill the contracts of equals, hashcode and toString.

> Please support this project by simply putting a Github <!-- Place this tag where you want the button to render. -->
<a class="github-button" href="https://github.com/astrapi69/jobj-contract-verifier" data-icon="octicon-star" aria-label="Star astrapi69/jobj-contract-verifier on GitHub">Star ⭐</a>
>
> Share this library with friends on Twitter and everywhere else you can
>
> If you love this project [![donation](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)


## gradle dependency

You can first define the version in the ext section and add than the following gradle dependency to
your project `build.gradle` if you want to import the core functionality of jobj-contract-verifier:

define version in file gradle.properties

```
jobjContractVerifierVersion=4
```

or in build.gradle ext area

```
    jobjContractVerifierVersion = "4"
```

and than add the dependency to the dependencies area

```
    testImplementation("io.github.astrapi69:jobj-contract-verifier:$jobjContractVerifierVersion")
```

## Maven dependency

Maven dependency is now on sonatype.
Check out [sonatype repository](https://oss.sonatype.org/index.html#nexus-search;gav~de.alpharogroup~jobj-contract-verifier~~~) for latest snapshots and releases.

Add the following maven dependency to your project `pom.xml` if you want to import the core functionality of jobj-contract-verifier:

Than you can add the dependency to your dependencies:

    <properties>
            ...
        <!-- JOBJ-CONTRACT-VERIFIER version -->
        <jobj-contract-verifier.version>4</jobj-contract-verifier.version>
            ...
    </properties>
            ...
        <dependencies>
            ...
            <!-- JOBJ-CONTRACT-VERIFIER DEPENDENCY -->
            <dependency>
                <groupId>io.github.astrapi69</groupId>
                <artifactId>jobj-contract-verifier</artifactId>
                <version>${jobj-contract-verifier.version}</version>
                <scope>test</scope>
            </dependency>
            ...
        </dependencies>

# Donations

This project is kept as an open source product and relies on contributions to remain being
developed. If you like this library, please consider a donation

over paypal: <br><br>
<a href="https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=MJ7V43GU2H386" target="_blank">
<img src="https://www.paypalobjects.com/en_US/GB/i/btn/btn_donateCC_LG.gif" alt="PayPal this" title="PayPal – The safer, easier way to pay online!" style="border: none" />
</a>
<br><br>
or over bitcoin(BTC) with this address:

bc1ql2y99q7e8psndhcc3gferk03esw3qqf677rhjy

<img src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/bc1ql2y99q7e8psndhcc3gferk03esw3qqf677rhjy.png"
alt="Donation Bitcoin Wallet" width="250"/>

or over FIO with this address:

FIO7tFMUVAA9cHiPPqKMfMXiSxHrbpiFyRYqTketNuM67aULuwjop

<img src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/FIO7tFMUVAA9cHiPPqKMfMXiSxHrbpiFyRYqTketNuM67aULuwjop.png"
alt="Donation FIO Wallet" width="250"/>

or over Ethereum(ETH) with:

0xc057D159D3C8f3311E73568b334FF6fE82EB2b7D

<img src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/0xc057D159D3C8f3311E73568b334FF6fE82EB2b7D.png"
alt="Donation Ethereum Wallet" width="250"/>

or over Ethereum Classic(ETC) with:

0xF708cA86D86C246B69c3F4BAe431eBbe0c2bfddD

<img src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/0xF708cA86D86C246B69c3F4BAe431eBbe0c2bfddD.png"
alt="Donation Ethereum Classic Wallet" width="250"/>

or over Dogecoin(DOGE) with:

D5yi4Um8cpakd6yPRm2hGWuQ5nrVzhSSW1

<img src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/D5yi4Um8cpakd6yPRm2hGWuQ5nrVzhSSW1.png"
alt="Donation Dogecoin Wallet" width="250"/>

or over Monero(XMR) with:

49bqeRQ7Bf49oJFVC72pqpe5hFbb62pfXDYPdLsadGGF81KZW2ZfrPZ8PbAVu5X2v1TYAspeczMya3cYQysNS4usRRPQHVw

<img src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/49bqeRQ7Bf49oJFVC72pqpe5hFbb62pfXDYPdLsadGGF81KZW2ZfrPZ8PbAVu5X2v1TYAspeczMya3cYQysNS4usRRPQHVw.png"
alt="Donation Monero Wallet" width="250"/>

or over flattr:

<a href="http://flattr.com/thing/4067696/astrapi69jobj-contract-verifier-on-GitHub" target="_blank">
<img src="http://api.flattr.com/button/flattr-badge-large.png" alt="Flattr this" title="Flattr this" style="border: none" />
</a>

## Note

No animals were harmed in the making of this library.

## License

The source code comes under the liberal MIT License, making jobj-contract-verifier great for all types of applications.

## Semantic Versioning

The versions of jobj-contract-verifier are maintained with the Simplified Semantic Versioning guidelines.

Release version numbers will be incremented in the following format:

`<major>.<minor>.<patch>`

For detailed information on versioning for this project you can visit this [wiki page](https://github.com/lightblueseas/mvn-parent-projects/wiki/Simplified-Semantic-Versioning).

## Want to Help and improve it? ###

The source code for jobj-contract-verifier are on GitHub. Please feel free to fork and send pull requests!

Create your own fork of [astrapi69/jobj-contract-verifier/fork](https://github.com/astrapi69/jobj-contract-verifier/fork)

To share your changes, [submit a pull request](https://github.com/astrapi69/jobj-contract-verifier/pull/new/develop).

Don't forget to add new units tests on your changes.

## Contacting the Developers

Do not hesitate to contact the jobj-contract-verifier developers with your questions, concerns, comments, bug reports, or feature requests.
- Feature requests, questions and bug reports can be reported at the [issues page](https://github.com/astrapi69/jobj-contract-verifier/issues).

# Similar projects

- [equalsverifier](https://github.com/jqno/equalsverifier) EqualsVerifier can be used in Java unit tests to verify whether the contract for the equals and hashCode methods is met.

## Credits

|**Travis CI**|
|     :---:      |
|[![Travis CI](https://travis-ci.com/images/logos/TravisCI-Full-Color.png)](https://travis-ci.com/github)|
|Special thanks to [Travis CI](https://travis-ci.com/github) for providing a free continuous integration service for open source projects|
|     <img width=1000/>     |

|**Nexus Sonatype repositories**|
|     :---:      |
|[![sonatype repository](https://img.shields.io/nexus/r/https/oss.sonatype.org/de.alpharogroup/jobj-contract-verifier.svg?style=for-the-badge)](https://oss.sonatype.org/index.html#nexus-search;gav~de.alpharogroup~jobj-contract-verifier~~~)|
|Special thanks to [sonatype repository](https://www.sonatype.com) for providing a free maven repository service for open source projects|
|     <img width=1000/>     |

|**coveralls.io**|
|     :---:      |
|[![Coverage Status](https://coveralls.io/repos/github/astrapi69/jobj-contract-verifier/badge.svg?branch=develop)](https://coveralls.io/github/astrapi69/jobj-contract-verifier?branch=develop)|
|Special thanks to [coveralls.io](https://coveralls.io) for providing a free code coverage for open source projects|
|     <img width=1000/>     |

|**javadoc.io**|
|     :---:      |
|[![Javadocs](http://www.javadoc.io/badge/de.alpharogroup/jobj-contract-verifier.svg)](http://www.javadoc.io/doc/de.alpharogroup/jobj-contract-verifier)|
|Special thanks to [javadoc.io](http://www.javadoc.io) for providing a free javadoc documentation for open source projects|
|     <img width=1000/>     |

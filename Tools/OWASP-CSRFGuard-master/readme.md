## OWASP CSRFGuard 3.1.0

[http://www.owasp.org/index.php/Category:OWASP_CSRFGuard_Project](http://www.owasp.org/index.php/Category:OWASP_CSRFGuard_Project)

BSD License, All rights reserved.

## Overview

Welcome to the home of the OWASP CSRFGuard Project! OWASP CSRFGuard is a library that implements a variant of the synchronizer token pattern to mitigate the risk of Cross-Site Request Forgery (CSRF) attacks. The OWASP CSRFGuard library is integrated through the use of a JavaEE Filter and exposes various automated and manual ways to integrate per-session or pseudo-per-request tokens into HTML. When a user interacts with this HTML, CSRF prevention tokens (i.e. cryptographically random synchronizer tokens) are submitted with the corresponding HTTP request. It is the responsibility of OWASP CSRFGuard to ensure the token is present and is valid for the current HTTP request. Any attempt to submit a request to a protected resource without the correct corresponding token is viewed as a CSRF attack in progress and is discarded. Prior to discarding the request, CSRFGuard can be configured to take one or more actions such as logging aspects of the request and redirecting the user to a landing page. The latest release enhances this strategy to support the optional verification of HTTP requests submitted using Ajax as well as the optional verification of referrer headers.

## Project Lead

The CSRFGuard project is run by Azzeddine RAMRAMI. He can be contacted at azzeddine.ramrami AT owasp.org.

## License

OWASP CSRFGuard 3.1.0 is offered under the [BSD license](http://www.opensource.org/licenses/bsd-license.php)

## Using with Maven
OWASP CSRFGuard 3.1.0 will be available on Maven Central.  Add the following dependency to your Maven POM file to use the library:


```
<dependency>
    <groupId>org.owasp</groupId>
    <artifactId>csrfguard</artifactId>
    <version>3.1.0</version>
</dependency>
```

## Building the code

1. Make sure that you have [Apache Maven](http://maven.apache.org/) 3.0.4 or higher installed;
2. Make sure that you have [GPG](http://www.gnupg.org/) installed and a secret key generated with it;
3. Clone this repository locally;
4. Build the ```csrfguard``` project first as ```cd csrfguard``` followed by ```mvn clean install```;
5. Build and run the ```csrfguard-test``` project as ```cd ../csrfguard-test``` followed by ```mvn clean package tomcat7:run```;
6. Use a web browser to access ```http://localhost:8000``` to open the home page of the test project.

## Uploading to the Maven Central repository

1. Follow the [Sonatype Open-Source Project Maven Repository Usage Guide](https://docs.sonatype.org/display/Repository/Sonatype+OSS+Maven+Repository+Usage+Guide) to create a Sonatype user account;
2. Next, [open a support request](https://issues.sonatype.org/browse/OSSRH) to get your newly created username added to the Maven groupId ```org.owasp```;
3. Once the support request has been completed, follow the instructions in the Sonatype Maven repository usage guide mentioned above to upload new versions to the Maven Central repository.

## Email List

You can sign up for the OWASP CSRFGuard email list [here.]( https://lists.owasp.org/mailman/listinfo/owasp-csrfguard)

## Last News

An important security fix has been applied to the CSRFGuard version 3.0.


Do a token pre-fetch on every page.

Instead of hard coding the CSRF token, we send a POST request to fetch the token and populate the JS variable.

Thanks to Ahamed Nafeez <ahamednafeez@gmail.com> for this fix.



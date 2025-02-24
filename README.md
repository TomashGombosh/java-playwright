# Java playwright example
## Table of contents

* [Preconditions](#preconditions)
    * [Windows](#windows)
    * [Mac OS](#macos)
* [Run using IDE](#idea)
* [Run using gradle](#run-gradle)
* [Validate using gradle](#validate)

### Preconditions

<h4 id="windows">Windows</h4>

##### Install and Setup Java

1. Install Java 21 or higher on your local machine. To download Java21 jdk click on [that](https://www.oracle.com/uk/java/technologies/downloads/) and install java for Windows.
1. To set up JAVA_HOME follow the next steps:
    1. Click the left button of the mouse on the 'My computer' icon and choose 'Settings' in the drop-down list;
    1. In the 'System' window click 'Additional parameters of the system';
    1. Click on the button 'Environment variables';
    1. In the modal window 'System variables' click button 'Add';
    1. In the field 'Variable name' fill 'JAVA_HOME';
    1. In the field 'Variable value' fill <path to jdk>;
    1. Click the 'OK' button;
    1. Open 'PATH' in the 'System variables';
    1. At the bottom of the list add %JAVA_HOME%\lib, %JAVA_HOME%\bin and %JAVA_HOME%\jre;
1. To check the acceptance of changes, open the command line of your machine and run the following 'path' command, at the end of the change you need to set <path to jdk>\lib,<path to jdk>\bin and <path to jdk>\jre
1. Restart

<h4 id="macos">Mac OS</h4>

1. Install with Homebrew
    1. Install Homebrew using the command (*if the homebrew already installed into you mac os skip that step*) ``/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install.sh)"``
    1. Install java 21 using command `brew install openjdk`
    1. Set JAVA_HOME using command `export JAVA_HOME=/path/to/java` (*usually for homebrew install it would be /Library/Java/JavaVirtualMachines/jdk/Contents/Home*)
    1. Set JAVA_HOME to the patch using command `PATH=$JAVA_HOME/lib:$JAVA_HOME/bin:$JAVA_HOME/jre:$PATH`
    1. Restart 

<h3 id="idea">Run using IDE</h3>

* Install `IntelliJ IDEA` IDE
* Install _Lombok Plugin_: `IntelliJ IDEA > Preferences > Plugins > Browse repositories > Lombok Plugin`
* _Enable annotation processing_: `IntelliJ IDEA > Preferences > Build, Execution, Deployment > Compiler > Annotation Processors > Enable annotation processing`
* Checkout project from git
* Start import as `Gradle` project
* Go to the `src/test/java/com/tomashgombosh` click on the right button and click ``Run 'Test' in 'com.tomashgombosh...'``

<h3 id="run-gradle">Run using gradle</h3>

* Checkout project from git
* Go to the checkout folder using ``cd java-playwright``
* Start test using 
  * Run powershell
     ```powershell
       ./gradlew allureServe
     ```
  * Run bash/zsh
     ```shell
       ./gradlew allureServe
     ```

* After test finished to generate the report: 
    * Run powershell
      ```powershell
        ./gradlew allureServe
      ```
    * Run bash/zsh
      ```shell
        ./gradlew allureServe
      ```

<h3 id="validate">Validate and test using gradle</h3>

* Run powershell
  ```powershell
    ./gradlew clean validate
  ```
* Run bash/zsh
  ```shell
    ./gradlew clean validate
  ```
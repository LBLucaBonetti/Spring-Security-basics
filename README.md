# Spring-Security-basics

Source code of my talk

### Repository structure

Here is a list of what you will find in this repository, branch by branch:

- <code>main</code>: a Spring Boot basic project exposing a single REST endpoint, unsecured, for reference
- <code>feature/xss</code>: code example for the XSS vulnerability
- <code>feature/csrf</code>: code example for the CSRF vulnerability
- <code>feature/oauth2</code>: code example for OAuth2 (with JWTs and roles)

### Notes for IntelliJ IDEA

Go to <code>File > Settings > Build, Execution, Deployment > Compiler</code> and turn the <code>
Build project automatically</code> flag on.

Go to <code>File > Settings > Advanced Settings</code> and under <code>Compiler</code> turn
the <code>Allow auto-make to start even if developed application is currently running</code> flag
on.

You will now be able to automatically make your app restart after each modification without having
to manually restart the whole thing.

Open the <code>/src/main/java/it/lbsoftware/demo/DemoApplication.java</code> file and click on the
green play button that appears on the left of the class name, then choose <code>Run 'DemoApplication.main()'</code> to
start the app.
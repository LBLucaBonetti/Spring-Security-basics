# Spring-Security-basics

Source code of my talk

### Repository structure

Here is a list of what you will find in this repository, branch by branch:

- <code>main</code>: a Spring Boot basic project exposing a single REST endpoint, unsecured, for reference
- <code>feature/xss</code>: code example for the XSS vulnerability
- <code>feature/csrf</code>: code example for the CSRF vulnerability
- <code>feature/oauth2</code>: code example for OAuth2 (with JWTs and roles)
- <code>feature/spring-security</code>: code example for Spring Security (automatic login required, default security
  headers and protections, ...)

### <code>feature/xss</code>

Run the <code>DemoApplication.java</code> class; when the application has started, you will find two endpoints in
<code>MyController.java</code> as code comments.
The first is the "good" one and the second is the "evil" one. When you copy and paste the second in the address bar of a
browser, the secret in localStorage will be revealed.

### <code>feature/csrf</code>

Run the <code>DemoApplication.java</code> class; when the application has started, navigate to <a href="localhost:8080">
localhost:8080</a> and you will see the index page. Now click on <code>"Go to users page"</code> and you will be
prompted to log in. Type <code>user</code> as
the username and <code>password</code> as the password. These credentials come from the <code>
application.properties</code> file and
are stored in-memory for the example application. Now log in. You will find the current list of users of your app is
empty.
Try adding one and click on <code>"Add"</code>. Without logging out, open another tab in the same browser and find your
MailHog
instance at <a href="localhost:8025">localhost:8025</a>. You like winning money, you open the e-mail and click on the
link you see: there you have your
CSRF vulnerability easily exploited! You successfully added an unwanted user to the app, check that in the list
where an <code>EVIL</code> name should have appeared.

### <code>feature/oauth2</code>

Run the <code>DemoApplication.java</code> class; when the application has started, open a browser in incognito mode (you
will easily switch between users by doing so) and navigate to <a href="localhost:8080/roles">localhost:8080/roles</a>.
The endpoint should return an error <code>401</code> indicating you lack the right credentials to call it.
In the root of the project you have a <code>demo-fe</code> directory. From a terminal with <a href="https://nodejs.org">
node</a> available, without stopping the backend app, launch <code>npm install</code> and then <code>npm run dev</code>.
The frontend application should start at <a href="localhost:5173">localhost:5173</a>. Open it. You will be redirected to
Keycloak, our "local Google". Use <code>user1@gmail.com</code> or <code>user2@gmail.com</code> and <code>password</code>
to log in. Click on <code>"Go to About"</code> and you will automatically make a request to your backend endpoint.
If everything is ok, you will see some roles of the user you logged in with; <code>user1@gmail.com</code> is an
<code>admin</code> and <code>user2@gmail.com</code> is a regular <code>user</code>.
If you want to switch user, close the browser and open it again in incognito mode.
Log back in with the other user and click again on "Go to About" to perform another request to your backend.
You should now have the opposite role of the first user you logged in with (<code>admin</code> or <code>
user</code>).

### <code>feature/spring-security</code>

Run the <code>DemoApplication.java</code> class; when the application has started, navigate to <a href="localhost:8080">
localhost:8080</a> and you will be prompted to log in. Use the <code>user</code> username and the password you find in
the terminal screen of the app. After logging in, you will be automatically redirected to the automatically-protected
greetings page.

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
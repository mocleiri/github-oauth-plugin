#Jenkins Github OAuth Plugin _+ embeddable build status patch_


##About the patch


This is a patched version of the [Jenkins Github OAuth Plugin](https://github.com/mocleiri/github-oauth-plugin) which introduces a (configurable) hole to display the [embeddable build status icon](https://wiki.jenkins-ci.org/display/JENKINS/Embeddable+Build+Status+Plugin) to non-authorized users. This allows you to put build status icons on external websites for the world to see, for example on [GitHub](https://github.com/PhenotypeFoundation/GSCF#download-a-war-file).

The patched plugin is available for download [here](https://github.com/4np/github-oauth-plugin/tree/master/target)… You can upload it manually in Jenkins' Plugin Manager's advanced tab and it will replace the regular _Github OAuth Plugin_ (if installed).

### 1. manually upload the [patched plugin](https://github.com/4np/github-oauth-plugin/tree/master/target) and restart Jenkins
![upload](https://dl.dropbox.com/s/srukykaaqump9a5/Jenkins%20-%20Upload%20Plugin.png?token_hash=AAHTVZzA5tVLWcZKBKx-iYcUY_K4VwEQSw4ie9n0lfEphg&dl=1)

### 2. after restarting jenkins the plugin is installed
![installed](https://dl.dropbox.com/s/k0l78qv41wfjfzp/Jenkins%20-%20Installed%20Plugin.png?token_hash=AAGqxJiKt1RTbrqEMZrEAOok-j9V_XbkrcVmAfJ6Y9jFiA&dl=1)

### 3. configure Jenkins' global security
![configure](https://dl.dropbox.com/s/g0pqf1jrthw5wll/Jenkins%20-%20Configure%20Global%20Security.png?token_hash=AAG94N3LRZ5DBaI_pRLIhNKWgvRpKYVyKoRpLUlXSS0h7w&dl=1)

### 4. enable READ access to the build status icon
![enable read](https://dl.dropbox.com/s/sf731hr9f4glsm8/Jenkins%20-%20enable%20build%20status%20icon.png?token_hash=AAFO326GiOQkqvvHdL-xv23N0Wv_QlxGasZCZ0tyJe6Yrw&dl=1)

### 5. open one of the jobs' [embeddable build status](https://wiki.jenkins-ci.org/display/JENKINS/Embeddable+Build+Status+Plugin)
![job](https://wiki.jenkins-ci.org/download/attachments/60918124/snapshot1.png?version=2&modificationDate=1336589268000)

### 6. and use the embeddable build status icon [externally](https://github.com/PhenotypeFoundation/GSCF#download-a-war-file)
![icon](https://wiki.jenkins-ci.org/download/attachments/60918124/ebs.png?version=1&modificationDate=1336586636000)


#Original unpatched plugin documentation

Read more: [http://wiki.jenkins-ci.org/display/JENKINS/Github+OAuth+Plugin](http://wiki.jenkins-ci.org/display/JENKINS/Github+OAuth+Plugin)


Overview
--------

The idea behind this plugin is that github already knows which users are committers on specific projects.

So we should be able to have an authentication process using OAuth that allows users to login to jenkins using their github credentials.

There are two key parts to this plugin:

A. GithubSecurityRealm: 

This handles the authentication and acquisition of the github oauth token for the connecting user.

This takes the client id and client secret from the application registration here: https://github.com/settings/applications/new

The entry should look like this:

Main URL: http://127.0.0.1:8080
Callback URL: http://127.0.0.1:8080/securityRealm/finishLogin

With 127.0.0.1:8080 replaced with the hostname and port of your jenkins instance.


B. GithubAuthorizationStrategy:

This defines:

1. Comma separated list of users that should be given admin privileges.

2. Comma separated list of organizations whose members should be given read and build permissions on the jobs.

3. Check box to give other authenticated users read permission.

4. Check box to allow anonymous users READ permission for the /github-webhook.  
This only has meaning if the github-plugin is installed and the remote github repository post commit hook has been setup accordingly.

5. Check box to allow anonymous users READ permission for the /job/*/badge/icon [embeddable build status icon](https://wiki.jenkins-ci.org/display/JENKINS/Embeddable+Build+Status+Plugin).

The plugin works but there are still some areas like form validation that need work.  And some other cases where exceptions are thrown when perhaps there is a better way.

Notes:

The user must be a public member in the organizations that are declared.

License
-------

	(The MIT License)

	Copyright (c) 2011 Michael O'Cleirigh

	Permission is hereby granted, free of charge, to any person obtaining
	a copy of this software and associated documentation files (the
	'Software'), to deal in the Software without restriction, including
	without limitation the rights to use, copy, modify, merge, publish,
	distribute, sublicense, and/or sell copies of the Software, and to
	permit persons to whom the Software is furnished to do so, subject to
	the following conditions:

	The above copyright notice and this permission notice shall be
	included in all copies or substantial portions of the Software.

	THE SOFTWARE IS PROVIDED 'AS IS', WITHOUT WARRANTY OF ANY KIND,
	EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
	MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
	IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
	CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
	TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
	SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.


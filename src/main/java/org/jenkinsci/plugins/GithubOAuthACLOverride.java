/**
 The MIT License

Copyright (c) 2012 Michael O'Cleirigh

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.



 */
package org.jenkinsci.plugins;

import hudson.Extension;
import hudson.model.Descriptor;
import hudson.security.ACLPermissionOverride;
import hudson.security.AuthorizationStrategy;
import hudson.security.GroupDetails;
import hudson.security.Permission;
import hudson.security.SecurityRealm;

import java.io.IOException;
import java.util.logging.Logger;

import jenkins.model.Jenkins;

import org.acegisecurity.Authentication;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UsernameNotFoundException;
import org.kohsuke.github.GHOrganization;
import org.kohsuke.github.GHUser;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;

/**
 * 
 * Implementation of the AbstractPasswordBasedSecurityRealm that uses github
 * oauth to verify the user can login.
 * 
 * This is based on the MySQLSecurityRealm from the mysql-auth-plugin written by
 * Alex Ackerman.
 */
@Extension
public class GithubOAuthACLOverride extends ACLPermissionOverride {

  
	@Override
	public boolean checkPermission(Authentication a, Permission p) {
		
		GithubSecurityRealm realm = (GithubSecurityRealm) Jenkins.getInstance().getSecurityRealm();
		
		GithubOAuthMembershipLogic logic = realm.getMembershipLogic();
		return logic.hasPermission(a, p);
	}
}

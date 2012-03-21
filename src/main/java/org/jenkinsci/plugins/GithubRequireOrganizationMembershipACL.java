/**
 The MIT License

Copyright (c) 2011 Michael O'Cleirigh

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

import hudson.security.ACL;
import hudson.security.Permission;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import jenkins.model.Jenkins;
import org.acegisecurity.Authentication;
import org.kohsuke.stapler.Stapler;

/**
 * @author Mike
 * 
 */
public class GithubRequireOrganizationMembershipACL extends ACL {

	private static final Logger log = Logger
			.getLogger(GithubRequireOrganizationMembershipACL.class.getName());

		
	private GithubOAuthMembershipLogic logic;

	/*
	 * (non-Javadoc)
	 * 
	 * @see hudson.security.ACL#hasPermission(org.acegisecurity.Authentication,
	 * hudson.security.Permission)
	 */
	@Override
	public boolean hasPermission(Authentication a, Permission permission) {

		return logic.hasPermission(a, permission);

	}


	public GithubRequireOrganizationMembershipACL(String adminUserNames,
			String organizationNames, boolean authenticatedUserReadPermission,
			boolean allowGithubWebHookPermission,
            boolean allowCcTrayPermission,
			boolean allowAnonymousReadPermission) {
		super();
		
		logic = new GithubOAuthMembershipLogic(adminUserNames, organizationNames, authenticatedUserReadPermission, allowGithubWebHookPermission, allowCcTrayPermission, allowAnonymousReadPermission);
		

	}

	public List<String> getOrganizationNameList() {
		return logic.getOrganizationNameList();
	}

	public List<String> getAdminUserNameList() {
		return logic.getAdminUserNameList();
	}

	public boolean isAuthenticatedUserReadPermission() {
		return logic.isAuthenticatedUserReadPermission();
	}

	public boolean isAllowGithubWebHookPermission() {
		return logic.isAllowGithubWebHookPermission();
	}

	public boolean isAllowCcTrayPermission() {
		return logic.isAllowCcTrayPermission();
	}

	public boolean isAllowAnonymousReadPermission() {
		return logic.isAllowAnonymousReadPermission();
	}
	
	

	

}

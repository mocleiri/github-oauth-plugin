/**
 * 
 */
package org.jenkinsci.plugins;

import hudson.security.GlobalMatrixAuthorizationStrategy;

/**
 * @author mocleiri
 * 
 * Extends the basic @see {@link GlobalMatrixAuthorizationStrategy} but adds in support for the github-webhook.
 *
 */
public class GithubGlobalMatrixAuthorizationStrategy extends
		GlobalMatrixAuthorizationStrategy {

	/**
	 * 
	 */
	public GithubGlobalMatrixAuthorizationStrategy() {
		// TODO Auto-generated constructor stub
	}

}

import jenkins.model.*
import hudson.security.*
import org.jenkinsci.plugins.*

def instance = Jenkins.getInstance()

def githubRealm = new GithubSecurityRealm(
  'https://github.com',
  'https://api.github.com',
  args[0],
  args[1]
)
instance.setSecurityRealm(githubRealm)

def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
instance.setAuthorizationStrategy(strategy)

instance.save()

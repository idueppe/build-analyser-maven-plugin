Build Analyser Maven Plugin
===========================

This plugin prints for each maven lifecycle phases the configured plugin goals.

Supported Goals
---------------------------
* print
* help

Example:

`[INFO] Project: Maven Build Analyser Plugin`
`[INFO] ------------------------------------------------------------------------`
[INFO] the plugin org.apache.maven.plugins:maven-plugin-plugin:2.9:helpmojo is executed in its default phase.
[INFO] 
[INFO] validate:
[INFO] 
[INFO] initialize:
[INFO] 
[INFO] generate-sources:
[INFO] 
[INFO] process-sources:
[INFO] 
[INFO] generate-resources:
[INFO] 	org.apache.maven.plugins:maven-plugin-plugin:2.9:descriptor (executionId:default-descriptor)
[INFO] 
[INFO] process-resources:
[INFO] 	org.apache.maven.plugins:maven-resources-plugin:2.4.3:resources (executionId:default-resources)
[INFO] 
[INFO] compile:
[INFO] 	org.apache.maven.plugins:maven-compiler-plugin:2.3.2:compile (executionId:default-compile)
[INFO] 
[INFO] process-classes:
[INFO] 
[INFO] generate-test-sources:
[INFO] 
[INFO] process-test-sources:
[INFO] 
[INFO] generate-test-resources:
[INFO] 
[INFO] process-test-resources:
[INFO] 	org.apache.maven.plugins:maven-resources-plugin:2.4.3:testResources (executionId:default-testResources)
[INFO] 
[INFO] test-compile:
[INFO] 	org.apache.maven.plugins:maven-compiler-plugin:2.3.2:testCompile (executionId:default-testCompile)
[INFO] 
[INFO] process-test-classes:
[INFO] 
[INFO] test:
[INFO] 	org.apache.maven.plugins:maven-surefire-plugin:2.7.2:test (executionId:default-test)
[INFO] 
[INFO] prepare-package:
[INFO] 
[INFO] package:
[INFO] 	org.apache.maven.plugins:maven-plugin-plugin:2.9:addPluginArtifactMetadata (executionId:default-addPluginArtifactMetadata)
[INFO] 	org.apache.maven.plugins:maven-source-plugin:2.1.2:jar-no-fork (executionId:attach-sources)
[INFO] 	org.apache.maven.plugins:maven-jar-plugin:2.3.1:jar (executionId:default-jar)
[INFO] 
[INFO] pre-integration-test:
[INFO] 
[INFO] integration-test:
[INFO] 
[INFO] post-integration-test:
[INFO] 
[INFO] verify:
[INFO] 
[INFO] install:
[INFO] 	org.apache.maven.plugins:maven-install-plugin:2.3.1:install (executionId:default-install)
[INFO] 
[INFO] deploy:
[INFO] 	org.apache.maven.plugins:maven-deploy-plugin:2.5:deploy (executionId:default-deploy)
[INFO] 
[INFO] clean:
[INFO] 	org.apache.maven.plugins:maven-clean-plugin:2.4.1:clean (executionId:default-clean)
[INFO] 
[INFO] site:
[INFO] 	org.apache.maven.plugins:maven-site-plugin:2.0.1:site (executionId:default-site)
[INFO] 
[INFO] site-deploy:
[INFO] 	org.apache.maven.plugins:maven-site-plugin:2.0.1:deploy (executionId:default-deploy)
[INFO] 
`

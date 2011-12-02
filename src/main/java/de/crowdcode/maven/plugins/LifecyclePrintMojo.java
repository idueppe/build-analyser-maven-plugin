package de.crowdcode.maven.plugins;

/*
 * Copyright 2011 by crowdcode
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Ingo Düppe
 */
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.descriptor.PluginDescriptor;
import org.apache.maven.project.MavenProject;

/**
 * Goal prints out the lifecycles of a project with the attached plugins and
 * there goals.
 * 
 * Display lifecycle phases and plugin goals.<br/> Call <pre>  mvn build-analyser:print</pre> to display the phases and goals.
 * 
 * @goal print
 * 
 */
public class LifecyclePrintMojo extends AbstractMojo {

	/**
	 * @parameter expression="${project}"
	 * @readonly
	 */
	protected MavenProject project;

	/**
	 * @parameter expression="${pluginDescriptor}"
	 * @readonly
	 */
	protected PluginDescriptor pluginDescriptor;

	private Map<String, List<String>> phaseMapping;

	// TODO: this should be retrieve from the maven api
	private static String[] defaultLifecyclePhases = { "validate",
			"initialize", "generate-sources", "process-sources",
			"generate-resources", "process-resources", "compile",
			"process-classes", "generate-test-sources", "process-test-sources",
			"generate-test-resources", "process-test-resources",
			"test-compile", "process-test-classes", "test", "prepare-package",
			"package", "pre-integration-test", "integration-test",
			"post-integration-test", "verify", "install", "deploy" };

	public void execute() throws MojoExecutionException, MojoFailureException {
		getLog().info("------------------------------------------------------------------------");
		getLog().info("");
		getLog().info("Project: " + project.getName());
		getLog().info("------------------------------------------------------------------------");
		initLifecylePhaseMapping();
		parsePlugins();
		printPlugins();
	}

	private void initLifecylePhaseMapping() {
		phaseMapping = new LinkedHashMap<String, List<String>>();
		for (String phase : defaultLifecyclePhases) {
			phaseMapping.put(phase, new ArrayList<String>());
		}
	}

	private void printPlugins() {
		getLog().info("");
		for (Map.Entry<String, List<String>> entry : phaseMapping.entrySet()) {
			getLog().info(entry.getKey()+":");
			for (String plugin : entry.getValue()) {
				getLog().info("\t" + plugin);
			}
			getLog().info("");
		}
	}

	private void parsePlugins() {
		@SuppressWarnings("unchecked")
		List<Plugin> buildPlugins = project.getBuildPlugins();
		for (Plugin plugin : buildPlugins) {
			parseExecutions(plugin, plugin.getExecutions());
		}
	}

	private void parseExecutions(Plugin plugin, List<PluginExecution> executions) {
		for (PluginExecution execution : executions) {
			List<String> goals = execution.getGoals();
			for (String goal : goals) {
				addGoalToLifecyle(goal, plugin, execution);
			}
		}
	}

	private void addGoalToLifecyle(String goal, Plugin plugin, PluginExecution execution) {
		if (execution.getPhase() == null) {
			getLog().info("the plugin "+ plugin.getId()+":"+goal+" is executed in its default phase.");
			// TODO need to start analysis here... what is the default phase of the goal?
		} else {
			List<String> pluginGoals = getLifecylcePhase(execution.getPhase());

			String text = plugin.getArtifactId()+":"+goal;
			text += "\t("+ plugin.getId()+" ,executionId="+execution.getId()+")";
			
			pluginGoals.add(text);
		}
	}


	private List<String> getLifecylcePhase(String phase) {
		if (!phaseMapping.containsKey(phase)) {
			phaseMapping.put(phase, new ArrayList<String>());
		}
		return phaseMapping.get(phase);
	}

}

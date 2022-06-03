package com.sg.features;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin={"pretty"} ,features="classpath:com/sg/features",
glue="com.sg.bdd.steps")
public class AccountUserStoriesTest {
}

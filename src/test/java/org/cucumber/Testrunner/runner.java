
package org.cucumber.Testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/FeatureFileFolder", glue = "org.cucumber.stepdef")
public class runner extends AbstractTestNGCucumberTests {

}
/*
 * Copyright 2014 michael-simons.eu.
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

package ac.simons.biking2.misc;

import ac.simons.biking2.misc.About.VMProperties;
import java.time.Duration;
import org.junit.Test;
import org.outsideMyBox.testUtils.BeanLikeTester;

import org.outsideMyBox.testUtils.BeanLikeTester.PropertiesAndValues;

/**
 * @author Michael J. Simons, 2014-05-23
 */
public class AboutTest {    
    @Test
    public void beanShouldWorkAsExpected() {
	final BeanLikeTester beanLikeTester = new BeanLikeTester(VMProperties.class);
	
	final PropertiesAndValues defaultValues = new PropertiesAndValues();
	defaultValues.put("version", System.getProperty("java.runtime.version"));	
	defaultValues.put("uptime", null);	
	defaultValues.put("usedMemory", null);	
	defaultValues.put("freeMemory", null);	
	defaultValues.put("totalMemory", null);	
	defaultValues.put("maxMemory", null);	
 
	beanLikeTester.testDefaultValues(defaultValues);
	
	final PropertiesAndValues values = new PropertiesAndValues();
	values.put("uptime", Duration.ofDays(1));	
	values.put("usedMemory", 2l);	
	values.put("freeMemory", 3l);	
	values.put("totalMemory", 5l);	
	values.put("maxMemory", 10l);	
	
	beanLikeTester.testMutatorsAndAccessors(defaultValues, values);
    }
}

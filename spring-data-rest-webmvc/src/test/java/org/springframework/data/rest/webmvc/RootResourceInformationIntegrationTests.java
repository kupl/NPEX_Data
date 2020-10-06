/*
 * Copyright 2014 the original author or authors.
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
package org.springframework.data.rest.webmvc;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.rest.webmvc.jpa.Address;
import org.springframework.data.rest.webmvc.jpa.JpaRepositoryConfig;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for {@link RootResourceInformation}.
 * 
 * @author Oliver Gierke
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaRepositoryConfig.class)
@Transactional
public class RootResourceInformationIntegrationTests extends AbstractControllerIntegrationTests {

	/**
	 * @see DATAREST-217
	 */
	@Test
	public void getIsNotSupportedIfFindAllIsNotExported() {

		RootResourceInformation information = getResourceInformation(Address.class);
		assertThat(information.supports(HttpMethod.GET, ResourceType.COLLECTION), is(false));
	}

	/**
	 * @see DATAREST-217
	 */
	@Test
	public void postIsNotSupportedIfSaveIsNotExported() {

		RootResourceInformation information = getResourceInformation(Address.class);
		assertThat(information.supports(HttpMethod.POST, ResourceType.COLLECTION), is(false));
	}
}

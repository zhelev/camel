/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.management;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.openmbean.TabularData;

import org.apache.camel.CamelContext;
import org.apache.camel.ManagementStatisticsLevel;
import org.apache.camel.ServiceStatus;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.apache.camel.management.DefaultManagementObjectNameStrategy.TYPE_PROCESSOR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisabledOnOs(OS.AIX)
public class ManagedRecipientListTest extends ManagementTestSupport {

    @Override
    protected CamelContext createCamelContext() throws Exception {
        CamelContext context = super.createCamelContext();
        context.getManagementStrategy().getManagementAgent().setStatisticsLevel(ManagementStatisticsLevel.Extended);
        return context;
    }

    @Test
    public void testManageRecipientList() throws Exception {
        MockEndpoint foo = getMockEndpoint("mock:foo");
        foo.expectedMessageCount(2);

        MockEndpoint bar = getMockEndpoint("mock:bar");
        bar.expectedMessageCount(1);

        template.sendBodyAndHeader("direct:start", "Hello World", "whereto", "mock:foo");
        template.sendBodyAndHeader("direct:start", "Bye World", "whereto", "mock:foo");
        template.sendBodyAndHeader("direct:start", "Hi World", "whereto", "mock:bar");

        assertMockEndpointsSatisfied();

        // get the stats for the route
        MBeanServer mbeanServer = getMBeanServer();

        // get the object name for the delayer
        ObjectName on = getCamelObjectName(TYPE_PROCESSOR, "mysend");

        // should be on route1
        String routeId = (String) mbeanServer.getAttribute(on, "RouteId");
        assertEquals("route1", routeId);

        String camelId = (String) mbeanServer.getAttribute(on, "CamelId");
        assertEquals(context.getManagementName(), camelId);

        String state = (String) mbeanServer.getAttribute(on, "State");
        assertEquals(ServiceStatus.Started.name(), state);

        Boolean parallel = (Boolean) mbeanServer.getAttribute(on, "ParallelProcessing");
        assertFalse(parallel.booleanValue());

        String lan = (String) mbeanServer.getAttribute(on, "ExpressionLanguage");
        assertEquals("header", lan);

        String uri = (String) mbeanServer.getAttribute(on, "Expression");
        assertEquals("whereto", uri);

        TabularData data = (TabularData) mbeanServer.invoke(on, "extendedInformation", null, null);
        assertNotNull(data);
        assertEquals(2, data.size());
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:start")
                        .recipientList(header("whereto")).id("mysend");
            }
        };
    }

}

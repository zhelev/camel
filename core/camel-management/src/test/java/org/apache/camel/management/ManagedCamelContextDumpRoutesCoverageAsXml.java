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

import org.w3c.dom.Document;

import org.apache.camel.builder.RouteBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisabledOnOs(OS.AIX)
public class ManagedCamelContextDumpRoutesCoverageAsXml extends ManagementTestSupport {

    @Test
    public void testRouteCoverageStats() throws Exception {
        // get the stats for the route
        MBeanServer mbeanServer = getMBeanServer();
        ObjectName on = getContextObjectName();

        getMockEndpoint("mock:foo").expectedMessageCount(1);
        getMockEndpoint("mock:bar").expectedMessageCount(2);
        template.asyncSendBody("direct:start", "Hello World");
        template.asyncSendBody("direct:bar", "Hi World");
        template.asyncSendBody("direct:bar", "Bye World");
        assertMockEndpointsSatisfied();

        String xml = (String) mbeanServer.invoke(on, "dumpRoutesCoverageAsXml", null, null);
        log.info(xml);

        assertTrue(xml.contains("exchangesTotal=\"3\""));
        assertTrue(xml.contains("exchangesTotal=\"2\""));

        // should be valid XML
        Document doc = context.getTypeConverter().convertTo(Document.class, xml);
        assertNotNull(doc);
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:start").routeId("foo")
                        .to("log:foo")
                        .delay(100)
                        .to("mock:foo");

                from("direct:bar").routeId("bar")
                        .to("log:bar")
                        .to("mock:bar");
            }
        };
    }

}

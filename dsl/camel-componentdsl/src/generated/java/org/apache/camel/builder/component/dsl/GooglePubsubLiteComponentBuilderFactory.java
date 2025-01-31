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
package org.apache.camel.builder.component.dsl;

import javax.annotation.processing.Generated;
import org.apache.camel.Component;
import org.apache.camel.builder.component.AbstractComponentBuilder;
import org.apache.camel.builder.component.ComponentBuilder;
import org.apache.camel.component.google.pubsublite.GooglePubsubLiteComponent;

/**
 * Send and receive messages to/from Google Cloud Platform PubSub Lite Service.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.maven.packaging.ComponentDslMojo")
public interface GooglePubsubLiteComponentBuilderFactory {

    /**
     * Google PubSub Lite (camel-google-pubsub-lite)
     * Send and receive messages to/from Google Cloud Platform PubSub Lite
     * Service.
     * 
     * Category: cloud,messaging
     * Since: 4.6
     * Maven coordinates: org.apache.camel:camel-google-pubsub-lite
     * 
     * @return the dsl builder
     */
    static GooglePubsubLiteComponentBuilder googlePubsubLite() {
        return new GooglePubsubLiteComponentBuilderImpl();
    }

    /**
     * Builder for the Google PubSub Lite component.
     */
    interface GooglePubsubLiteComponentBuilder
            extends
                ComponentBuilder<GooglePubsubLiteComponent> {
        /**
         * Allows for bridging the consumer to the Camel routing Error Handler,
         * which mean any exceptions (if possible) occurred while the Camel
         * consumer is trying to pickup incoming messages, or the likes, will
         * now be processed as a message and handled by the routing Error
         * Handler. Important: This is only possible if the 3rd party component
         * allows Camel to be alerted if an exception was thrown. Some
         * components handle this internally only, and therefore
         * bridgeErrorHandler is not possible. In other situations we may
         * improve the Camel component to hook into the 3rd party component and
         * make this possible for future releases. By default the consumer will
         * use the org.apache.camel.spi.ExceptionHandler to deal with
         * exceptions, that will be logged at WARN or ERROR level and ignored.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: false
         * Group: consumer
         * 
         * @param bridgeErrorHandler the value to set
         * @return the dsl builder
         */
        default GooglePubsubLiteComponentBuilder bridgeErrorHandler(
                boolean bridgeErrorHandler) {
            doSetProperty("bridgeErrorHandler", bridgeErrorHandler);
            return this;
        }
        /**
         * The number of quota bytes that may be outstanding to the client. Must
         * be greater than the allowed size of the largest message (1 MiB).
         * 
         * The option is a: &lt;code&gt;long&lt;/code&gt; type.
         * 
         * Default: 10485760
         * Group: consumer (advanced)
         * 
         * @param consumerBytesOutstanding the value to set
         * @return the dsl builder
         */
        default GooglePubsubLiteComponentBuilder consumerBytesOutstanding(
                long consumerBytesOutstanding) {
            doSetProperty("consumerBytesOutstanding", consumerBytesOutstanding);
            return this;
        }
        /**
         * The number of messages that may be outstanding to the client. Must be
         * 0.
         * 
         * The option is a: &lt;code&gt;long&lt;/code&gt; type.
         * 
         * Default: 1000
         * Group: consumer (advanced)
         * 
         * @param consumerMessagesOutstanding the value to set
         * @return the dsl builder
         */
        default GooglePubsubLiteComponentBuilder consumerMessagesOutstanding(
                long consumerMessagesOutstanding) {
            doSetProperty("consumerMessagesOutstanding", consumerMessagesOutstanding);
            return this;
        }
        /**
         * Whether the producer should be started lazy (on the first message).
         * By starting lazy you can use this to allow CamelContext and routes to
         * startup in situations where a producer may otherwise fail during
         * starting and cause the route to fail being started. By deferring this
         * startup to be lazy then the startup failure can be handled during
         * routing messages via Camel's routing error handlers. Beware that when
         * the first message is processed then creating and starting the
         * producer may take a little time and prolong the total processing time
         * of the processing.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: false
         * Group: producer
         * 
         * @param lazyStartProducer the value to set
         * @return the dsl builder
         */
        default GooglePubsubLiteComponentBuilder lazyStartProducer(
                boolean lazyStartProducer) {
            doSetProperty("lazyStartProducer", lazyStartProducer);
            return this;
        }
        /**
         * Maximum number of producers to cache. This could be increased if you
         * have producers for lots of different topics.
         * 
         * The option is a: &lt;code&gt;int&lt;/code&gt; type.
         * 
         * Default: 100
         * Group: producer (advanced)
         * 
         * @param publisherCacheSize the value to set
         * @return the dsl builder
         */
        default GooglePubsubLiteComponentBuilder publisherCacheSize(
                int publisherCacheSize) {
            doSetProperty("publisherCacheSize", publisherCacheSize);
            return this;
        }
        /**
         * How many milliseconds should each producer stay alive in the cache.
         * 
         * The option is a: &lt;code&gt;int&lt;/code&gt; type.
         * 
         * Default: 180000
         * Group: producer (advanced)
         * 
         * @param publisherCacheTimeout the value to set
         * @return the dsl builder
         */
        default GooglePubsubLiteComponentBuilder publisherCacheTimeout(
                int publisherCacheTimeout) {
            doSetProperty("publisherCacheTimeout", publisherCacheTimeout);
            return this;
        }
        /**
         * How many milliseconds should a producer be allowed to terminate.
         * 
         * The option is a: &lt;code&gt;int&lt;/code&gt; type.
         * 
         * Default: 60000
         * Group: producer (advanced)
         * 
         * @param publisherTerminationTimeout the value to set
         * @return the dsl builder
         */
        default GooglePubsubLiteComponentBuilder publisherTerminationTimeout(
                int publisherTerminationTimeout) {
            doSetProperty("publisherTerminationTimeout", publisherTerminationTimeout);
            return this;
        }
        /**
         * Whether autowiring is enabled. This is used for automatic autowiring
         * options (the option must be marked as autowired) by looking up in the
         * registry to find if there is a single instance of matching type,
         * which then gets configured on the component. This can be used for
         * automatic configuring JDBC data sources, JMS connection factories,
         * AWS Clients, etc.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: true
         * Group: advanced
         * 
         * @param autowiredEnabled the value to set
         * @return the dsl builder
         */
        default GooglePubsubLiteComponentBuilder autowiredEnabled(
                boolean autowiredEnabled) {
            doSetProperty("autowiredEnabled", autowiredEnabled);
            return this;
        }
        /**
         * The Service account key that can be used as credentials for the
         * PubSub Lite publisher/subscriber. It can be loaded by default from
         * classpath, but you can prefix with classpath:, file:, or http: to
         * load the resource from different systems.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: security
         * 
         * @param serviceAccountKey the value to set
         * @return the dsl builder
         */
        default GooglePubsubLiteComponentBuilder serviceAccountKey(
                java.lang.String serviceAccountKey) {
            doSetProperty("serviceAccountKey", serviceAccountKey);
            return this;
        }
    }

    class GooglePubsubLiteComponentBuilderImpl
            extends
                AbstractComponentBuilder<GooglePubsubLiteComponent>
            implements
                GooglePubsubLiteComponentBuilder {
        @Override
        protected GooglePubsubLiteComponent buildConcreteComponent() {
            return new GooglePubsubLiteComponent();
        }
        @Override
        protected boolean setPropertyOnComponent(
                Component component,
                String name,
                Object value) {
            switch (name) {
            case "bridgeErrorHandler": ((GooglePubsubLiteComponent) component).setBridgeErrorHandler((boolean) value); return true;
            case "consumerBytesOutstanding": ((GooglePubsubLiteComponent) component).setConsumerBytesOutstanding((long) value); return true;
            case "consumerMessagesOutstanding": ((GooglePubsubLiteComponent) component).setConsumerMessagesOutstanding((long) value); return true;
            case "lazyStartProducer": ((GooglePubsubLiteComponent) component).setLazyStartProducer((boolean) value); return true;
            case "publisherCacheSize": ((GooglePubsubLiteComponent) component).setPublisherCacheSize((int) value); return true;
            case "publisherCacheTimeout": ((GooglePubsubLiteComponent) component).setPublisherCacheTimeout((int) value); return true;
            case "publisherTerminationTimeout": ((GooglePubsubLiteComponent) component).setPublisherTerminationTimeout((int) value); return true;
            case "autowiredEnabled": ((GooglePubsubLiteComponent) component).setAutowiredEnabled((boolean) value); return true;
            case "serviceAccountKey": ((GooglePubsubLiteComponent) component).setServiceAccountKey((java.lang.String) value); return true;
            default: return false;
            }
        }
    }
}
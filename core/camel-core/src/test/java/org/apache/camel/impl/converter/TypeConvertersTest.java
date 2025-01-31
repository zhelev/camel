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
package org.apache.camel.impl.converter;

import org.apache.camel.ContextTestSupport;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TypeConvertersTest extends ContextTestSupport {

    private MyConverters converters = new MyConverters();

    @Test
    public void testAdd() throws Exception {
        int before = context.getTypeConverterRegistry().size();

        context.getTypeConverterRegistry().addTypeConverters(converters);

        int after = context.getTypeConverterRegistry().size();
        int delta = after - before;
        assertEquals(2, delta, "There should be 2 more type converters");

        Country country = context.getTypeConverter().convertTo(Country.class, "en");
        assertNotNull(country);
        assertEquals("England", country.getName());

        String iso = context.getTypeConverter().convertTo(String.class, country);
        assertNotNull(iso);
        assertEquals("en", iso);
    }

    @Test
    public void testStringToPrimitiveTypes() throws Exception {
        assertEquals(Short.parseShort("1"), context.getTypeConverter().mandatoryConvertTo(short.class, "1"));
        assertEquals(Integer.parseInt("1"), context.getTypeConverter().mandatoryConvertTo(int.class, "1"));
        assertEquals(Long.parseLong("1"), context.getTypeConverter().mandatoryConvertTo(long.class, "1"));

        assertEquals(Float.parseFloat("1.1"), context.getTypeConverter().mandatoryConvertTo(float.class, "1.1"));
        assertEquals(Double.parseDouble("1.1"), context.getTypeConverter().mandatoryConvertTo(double.class, "1.1"));

        assertEquals('a', context.getTypeConverter().mandatoryConvertTo(char.class, "a"));
        assertEquals(Boolean.parseBoolean("true"), context.getTypeConverter().mandatoryConvertTo(boolean.class, "true"));
    }
}

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.zeppelin.resource;

import java.util.Collection;
import java.util.LinkedList;
import java.util.regex.Pattern;

/**
 * List of resources
 */
public class ResourceSet extends LinkedList<Resource> {

  public ResourceSet(Collection<Resource> resources) {
    super(resources);
  }

  public ResourceSet() {
    super();
  }

  public ResourceSet filterByNameRegex(String regex) {
    ResourceSet result = new ResourceSet();
    for (Resource r : this) {
      if (Pattern.matches(regex, r.getResourceId().getName())) {
        result.add(r);
      }
    }
    return result;
  }

  public ResourceSet filterByName(String name) {
    ResourceSet result = new ResourceSet();
    for (Resource r : this) {
      if (r.getResourceId().getName().equals(name)) {
        result.add(r);
      }
    }
    return result;
  }

  public ResourceSet filterByClassnameRegex(String regex) {
    ResourceSet result = new ResourceSet();
    for (Resource r : this) {
      if (Pattern.matches(regex, r.getClassName())) {
        result.add(r);
      }
    }
    return result;
  }

  public ResourceSet filterByClassname(String className) {
    ResourceSet result = new ResourceSet();
    for (Resource r : this) {
      if (r.getClassName().equals(className)) {
        result.add(r);
      }
    }
    return result;
  }
}

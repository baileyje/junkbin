/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2010, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.modules;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

/**
 * Module Specification.
 *
 * @author <a href="mailto:jbailey@redhat.com">John Bailey</a>
 * @author <a href="mailto:david.lloyd@redhat.com">David M. Lloyd</a>
 */
public final class ModuleSpec {
    private final List<DependencySpec> dependencies = new ArrayList<DependencySpec>();
    private final Set<Module.Flag> moduleFlags = EnumSet.noneOf(Module.Flag.class);

    private ModuleIdentifier moduleIdentifier;
    private String mainClass;
    private ModuleContentLoader loader;
    private AssertionSetting assertionSetting = AssertionSetting.INHERIT;

    public ModuleSpec(ModuleIdentifier moduleIdentifier) {
        this.moduleIdentifier = moduleIdentifier;
    }

    public ModuleIdentifier getIdentifier() {
        return moduleIdentifier;
    }

    public List<DependencySpec> getDependencies() {
        return dependencies;
    }

    void addDependency(final DependencySpec dependencySpec) {
        dependencies.add(dependencySpec);
    }

    public String getMainClass() {
        return mainClass;
    }

    public void setMainClass(final String mainClass) {
        this.mainClass = mainClass;
    }

    public ModuleContentLoader getContentLoader() {
        return loader;
    }

    public void setContentLoader(final ModuleContentLoader loader) {
        this.loader = loader;
    }

    public Set<Module.Flag> getModuleFlags() {
        return moduleFlags;
    }

    public AssertionSetting getAssertionSetting() {
        return assertionSetting;
    }

    public void setAssertionSetting(final AssertionSetting assertionSetting) {
        this.assertionSetting = assertionSetting;
    }
}

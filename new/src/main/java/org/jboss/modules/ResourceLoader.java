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

import java.io.IOException;
import java.util.Collection;

/**
 * @author <a href="mailto:david.lloyd@redhat.com">David M. Lloyd</a>
 */
public interface ResourceLoader {

    /**
     * Get the class specification for the given class name.  If no matching class is found, {@code null} is returned.
     *
     * @param name the name
     * @return the class specification, or {@code null} if the named class is not found
     * @throws IOException if an I/O error occurs
     */
    ClassSpec getClassSpec(String name) throws IOException;

    /**
     * Get the package specification for the given directory name.  Always returns a package specification; this
     * method cannot be used to test for the existence of a package.  A package spec should always be acquired from
     * the same resource loader which provided the class specification.
     *
     * @param name the directory name
     * @return the package specification
     * @throws IOException if an I/O error occurs
     */
    PackageSpec getPackageSpec(String name) throws IOException;

    /**
     * Get a resource with the given name.  If no such resource is available, {@code null} is returned.
     *
     * @param name the resource name
     * @return the resource, or {@code null} if it is not available
     */
    Resource getResource(String name);

    /**
     * Get the absolute physical filesystem path for a library with the given name.
     *
     * @param name the name
     * @return the path or {@code null} if the library is not present
     */
    String getLibrary(String name);

    /**
     * Get the collection of resource paths.  Called one time only when the resource loader is initialized.
     *
     * @return the resource paths
     */
    Collection<String> getPaths();
}
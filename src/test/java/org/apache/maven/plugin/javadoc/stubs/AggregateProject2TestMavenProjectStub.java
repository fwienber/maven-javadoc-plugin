package org.apache.maven.plugin.javadoc.stubs;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.factory.ArtifactFactory;
import org.apache.maven.artifact.resolver.filter.ArtifactFilter;
import org.apache.maven.model.Build;
import org.apache.maven.plugin.testing.stubs.MavenProjectStub;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.artifact.InvalidDependencyVersionException;

/**
 * @author <a href="mailto:oching@apache.org">Maria Odea Ching</a>
 * @version $Id$
 */
public class AggregateProject2TestMavenProjectStub
    extends MavenProjectStub
{
    private Build build;

    public AggregateProject2TestMavenProjectStub()
    {
        setGroupId( "org.apache.maven.plugins.maven-javadoc-plugin.unit" );
        setArtifactId( "aggregate-test-project2" );
        setVersion( "1.0-SNAPSHOT" );
        setPackaging( "jar" );
        setExecutionRoot( true );

        Artifact artifact = new JavadocPluginArtifactStub( getGroupId(), getArtifactId(), getVersion(), getPackaging() );
        artifact.setArtifactHandler( new DefaultArtifactHandlerStub() );
        setArtifact( artifact );

        build = new Build();
        build.setFinalName( "aggregate-test-project2" );
        build.setDirectory( super.getBasedir() + "/target/test/unit/aggregate-test/target" );

        String basedir = getBasedir().getAbsolutePath();
        List compileSourceRoots = new ArrayList();
        compileSourceRoots.add( basedir + "/aggregate/test/project2" );
        setCompileSourceRoots( compileSourceRoots );
    }

    /** {@inheritDoc} */
    public Build getBuild()
    {
        return build;
    }

    /** {@inheritDoc} */
    public void setBuild( Build build )
    {
        this.build = build;
    }

    /** {@inheritDoc} */
    public Set createArtifacts( ArtifactFactory artifactFactory, String string, ArtifactFilter artifactFilter )
        throws InvalidDependencyVersionException
    {
        return Collections.EMPTY_SET;
    }

    /** {@inheritDoc} */
    public File getBasedir()
    {
        return new File( super.getBasedir() + "/src/test/resources/unit/aggregate-test/project2" );
    }

    /** {@inheritDoc} */
    public MavenProject getExecutionProject()
    {
        return this;
    }
}

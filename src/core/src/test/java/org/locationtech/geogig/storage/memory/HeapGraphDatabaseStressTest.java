/*******************************************************************************
 * Copyright (c) 2014 Boundless and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Distribution License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/org/documents/edl-v10.html
 *******************************************************************************/
package org.locationtech.geogig.storage.memory;

import org.locationtech.geogig.api.TestPlatform;
import org.locationtech.geogig.storage.GraphDatabase;
import org.locationtech.geogig.storage.GraphDatabaseStressTest;

public class HeapGraphDatabaseStressTest extends GraphDatabaseStressTest {

    @Override
    protected GraphDatabase createDatabase(TestPlatform platform) {
        return new HeapGraphDatabase(platform);
    }

}

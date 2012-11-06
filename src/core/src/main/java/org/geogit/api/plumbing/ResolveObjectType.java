/* Copyright (c) 2011 TOPP - www.openplans.org. All rights reserved.
 * This code is licensed under the LGPL 2.1 license, available at the root
 * application directory.
 */

package org.geogit.api.plumbing;

import org.geogit.api.AbstractGeoGitOp;
import org.geogit.api.ObjectId;
import org.geogit.api.RevObject;
import org.geogit.api.RevObject.TYPE;
import org.geogit.storage.ObjectSerialisingFactory;
import org.geogit.storage.StagingDatabase;

import com.google.inject.Inject;

/**
 * Gets the object type of the object that matches the given {@link ObjectId}.
 */
public class ResolveObjectType extends AbstractGeoGitOp<RevObject.TYPE> {

    private StagingDatabase indexDb;

    private ObjectSerialisingFactory serialFactory;

    private ObjectId oid;

    /**
     * Constructs a new instance of {@code ResolveObjectType} using the specified parameters.
     * 
     * @param indexDb the staging database
     * @param serialFactory the serialization factory
     */
    @Inject
    public ResolveObjectType(StagingDatabase indexDb, ObjectSerialisingFactory serialFactory) {
        this.indexDb = indexDb;
        this.serialFactory = serialFactory;
    }

    /**
     * @param oid the {@link ObjectId object id} of the object to check
     * @return {@code this}
     */
    public ResolveObjectType setObjectId(ObjectId oid) {
        this.oid = oid;
        return this;
    }

    /**
     * Executes the command.
     * 
     * @return the type of the object specified by the object id.
     * @throws IllegalArgumentException if the object doesn't exist
     */
    @Override
    public TYPE call() throws IllegalArgumentException {
        Object o = indexDb.get(oid, serialFactory.createObjectTypeReader());
        if (o instanceof RevObject) {
            return ((RevObject) o).getType();
        }
        return (RevObject.TYPE) o;
    }
}

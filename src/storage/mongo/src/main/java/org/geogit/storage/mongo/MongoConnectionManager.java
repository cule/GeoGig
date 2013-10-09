/* Copyright (c) 2013 OpenPlans. All rights reserved.
 * This code is licensed under the BSD New License, available at the root
 * application directory.
 */
package org.geogit.storage.mongo;

import java.net.UnknownHostException;
import org.geogit.storage.ConnectionManager;
import com.mongodb.MongoClient;

public final class MongoConnectionManager extends
        ConnectionManager<MongoAddress, MongoClient> {
    @Override
    protected MongoClient connect(MongoAddress address) {
        try {
            return new MongoClient(address.getHost(), address.getPort());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void disconnect(MongoClient client) {
        client.close();
    }
}

/**
 * 
 */

package org.eclipselabs.emongo.example;

import org.eclipselabs.emongo.DatabaseLocator;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

/**
 * @author bhunt
 * 
 */
public class ExampleComponent
{
	private DatabaseLocator databaseLocator;

	public void activate()
	{
		DB database = databaseLocator.getDatabase("mongodb://localhost/example");
		DBCollection collection = database.getCollection("items");
		collection.drop();

		for (int i = 0; i < 10; i++)
			collection.insert(new BasicDBObject("x", i));

		DBCursor cursor = collection.find();

		while (cursor.hasNext())
			System.out.print(cursor.next().get("x") + " ");

		System.out.println();
	}

	public void bindDatabaseLocator(DatabaseLocator databaseLocator)
	{
		this.databaseLocator = databaseLocator;
	}
}

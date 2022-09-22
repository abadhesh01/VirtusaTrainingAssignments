package service;

import java.util.Collection;
import java.util.Iterator;

import error.CollectionsIsEmptyException;

public class ServiceImpl implements Service {
	
	
	public void insertIntegerObjectsIntoCollections(Collection<Integer> collections, int startValue, int endValue) throws NullPointerException, Exception
	{
		if(collections == null)
			throw new NullPointerException("Error: Reference pointing to null was passed! :(");
		
		for(/*No initialization required*/; startValue <= endValue; startValue ++)
		{
			collections.add(Integer.valueOf(startValue));
		}
	}
	
   
	public void printCollectionObject(Collection<Integer> collections) throws NullPointerException, CollectionsIsEmptyException, Exception
    {
		if(collections == null)
			throw new NullPointerException("Error: Reference of type pointing to null was passed! :(");
    	
    	if(collections.isEmpty())
    	    throw new CollectionsIsEmptyException(collections);
    	
    	System.out.println("OBJECT(" + collections.getClass().getName() + ") : " + collections);
    }
    
	
    public void removeEvenIntegerObjectsFromCollections(Collection<Integer> collections) throws NullPointerException, CollectionsIsEmptyException, Exception
    {
    	if(collections == null)
			throw new NullPointerException("Error: Reference pointing to null was passed! :(");
    	
    	if(collections.isEmpty())
    	    throw new CollectionsIsEmptyException(collections);
    	
    	Iterator<Integer> iterator = collections.iterator();
    	while(iterator.hasNext())
    	{
    	  Integer value = iterator.next();
    	  if(value.intValue() % 2 == 0)
    		  iterator.remove();
    	}
    }
    
}
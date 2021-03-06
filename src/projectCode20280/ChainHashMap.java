package projectCode20280;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * Map implementation using hash table with separate chaining.
 */

public class ChainHashMap<K, V> extends AbstractHashMap<K, V> {
	// a fixed capacity array of UnsortedTableMap that serve as buckets
	private UnsortedTableMap<K, V>[] table; // initialized within createTable

	/** Creates a hash table with capacity 11 and prime factor 109345121. */
	public ChainHashMap() {
		super();
	}

	/** Creates a hash table with given capacity and prime factor 109345121. */
	public ChainHashMap(int cap) {
		super(cap);
	}

	/** Creates a hash table with the given capacity and prime factor. */
	public ChainHashMap(int cap, int p) {
		super(cap, p);
	}

	/** Creates an empty table having length equal to current capacity. */
	@Override
	@SuppressWarnings({ "unchecked" })
	protected void createTable() {
		table = (UnsortedTableMap<K, V>[]) new UnsortedTableMap[capacity];
	}

	/**
	 * Returns value associated with key k in bucket with hash value h. If no such
	 * entry exists, returns null.
	 * 
	 * @param h the hash value of the relevant bucket
	 * @param k the key of interest
	 * @return associate value (or null, if no such entry)
	 */
	@Override
	protected V bucketGet(int h, K k) {
		UnsortedTableMap<K, V> bucket = table[h];
		
		if (bucket == null)
		{
			return null;
		}
		
		return bucket.get(k);
	}

	/**
	 * Associates key k with value v in bucket with hash value h, returning the
	 * previously associated value, if any.
	 * 
	 * @param h the hash value of the relevant bucket
	 * @param k the key of interest
	 * @param v the value to be associated
	 * @return previous value associated with k (or null, if no such entry)
	 */
	@Override
	protected V bucketPut(int h, K k, V v) {
		UnsortedTableMap<K, V> bucket = table[h];
		
		//if no bucket create it
		if (bucket == null)
		{
			bucket = new UnsortedTableMap<>();
			table[h] = bucket;
		}
		
		//keep track of size
		int oldSize = bucket.size();
		
		V temp = bucket.put(k, v);
		
		//size could be bigger now
		n += (bucket.size() - oldSize);
		
		return temp;
	}

	/**
	 * Removes entry having key k from bucket with hash value h, returning the
	 * previously associated value, if found.
	 * 
	 * @param h the hash value of the relevant bucket
	 * @param k the key of interest
	 * @return previous value associated with k (or null, if no such entry)
	 */
	@Override
	protected V bucketRemove(int h, K k) {
		UnsortedTableMap<K, V> bucket = table[h];
		
		if (bucket == null)
		{
			return null;
		}
		
		//keep track of size
		int oldSize = bucket.size();
		
		V temp = bucket.remove(k);
		
		n -= (oldSize - bucket.size());
		
		return temp;
	}

	/**
	 * Returns an iterable collection of all key-value entries of the map.
	 *
	 * @return iterable collection of the map's entries
	 */
	@Override
	public Iterable<Entry<K, V>> entrySet() {
		ArrayList<Entry<K, V>> items = new ArrayList<>();
		
		for (int i = 0; i < capacity; i++)
		{
			if (table[i] != null)
			{
				//for each element in the table, add it to a returnable iterable arraylist
				for (Entry<K, V> element : table[i].entrySet())
				{
					items.add(element);
				}
			}
		}
		
		return items;
	}
	
	public String toString()
	{
		return entrySet().toString();
	}
	
	public static void main(String[] args) {
		ChainHashMap<Integer, String> m = new ChainHashMap<Integer, String>();
		
		
		m.put(1, "One");
		m.put(10, "Ten");
		m.put(11, "Eleven");
		m.put(20, "Twenty");
		
		System.out.println("Initial Map: ");
		System.out.println("m: " + m + "\n");
		
		System.out.println("Remove Key = 11: ");
		m.remove(11);
		System.out.println("m: " + m + "\n");
		
		System.out.println("Insert <1, Won>: ");
		m.put(1, "Won");
		System.out.println("m: " + m + "\n");
		
		System.out.println("Get Key = 10: " + "\n" + m.get(10));
		
		System.out.print("\n");
		
		System.out.println("Insert <70, Seventy> and <73, Seventy Three>: ");
		m.put(70, "Seventy");
		m.put(73, "Seventy Three");
		System.out.println("m: " + m + "\n" + "Size currently: " + m.size() + "\n");
		
		System.out.println("Remove Key = 90: ");
		m.remove(90);
		System.out.println("m: " + m + "\n");
	}
}

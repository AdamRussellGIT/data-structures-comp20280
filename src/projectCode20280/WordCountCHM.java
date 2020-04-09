package projectCode20280;

import java.util.*;
import java.io.*;

//counts frequency of words in a txt file, and reports the top 10 words by frequency

public class WordCountCHM 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		ChainHashMap<String, Integer> chm = new ChainHashMap<String, Integer>();
		
		//set up
		File text = new File("C://Users//post2//Desktop//sample_text.txt");
		Scanner scanner = new Scanner(text).useDelimiter("[^a-zA-Z]+");
		
		while (scanner.hasNext())
		{
			String word = scanner.next().toLowerCase();
			Integer count = chm.get(word);
			
			if (count == null)
			{
				count = 0;
			}
			
			chm.put(word, 1 + count);
		}
		
		String[] words = new String[10];
		Integer[] counts = new Integer[10];
		
		for (int i = 0; i < 10; i++)
		{
			words[i] = "";
			counts[i] = 0;
		}
		
		for (Entry<String, Integer> entries : chm.entrySet())
		{
			for (int i = 0; i < 10; i++)
			{
				if (entries.getValue() > counts[i])
				{
					words[i] = entries.getKey();
					counts[i] = entries.getValue();
					break;
				}
			}
		}
		
		System.out.println("These are the top 10 words in the file:");
		System.out.println(words[0] + ": " + counts[0]);
		System.out.println(words[1] + ": " + counts[1]);
		System.out.println(words[2] + ": " + counts[2]);
		System.out.println(words[3] + ": " + counts[3]);
		System.out.println(words[4] + ": " + counts[4]);
		System.out.println(words[5] + ": " + counts[5]);
		System.out.println(words[6] + ": " + counts[6]);
		System.out.println(words[7] + ": " + counts[7]);
		System.out.println(words[8] + ": " + counts[8]);
		System.out.println(words[9] + ": " + counts[9]);
	}
}

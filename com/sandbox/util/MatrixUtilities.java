package com.sandbox.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MatrixUtilities {

	public void findHigherNumberOfRepeatedStrings(List<String> lst)
	{
		String[][] abc=new String[lst.size()][];
		Map<String, Integer> hm=new HashMap<String, Integer>();
		Iterator itr=lst.iterator();
		int count1=0;
		String maxStr="";
		while(itr.hasNext())
		{
			String key=(String)itr.next();
			Object val = hm.get(key);
			Integer count = Integer.sum(val==null ? 0:((Integer)val).intValue(), 1);
			hm.put(key, count);
			if(count1<count.intValue()) { count1=count.intValue(); maxStr=key;}
		}		
		
		System.out.println(maxStr + "occurs "+count1+" times");

	}

	public void findSqRtOfArray(int[] params)
	{
		int[] params1 = new int[params.length];
		for(int i=0;i<params.length;i++)
		{
			params1[i] = (int) Math.sqrt(params[i]);
			System.out.println(params1[i]+",");
		}
		
	}	
	
	public void sortIntegers(Integer[] params)
	{
		
		
		ArrayList<Integer> al = new ArrayList(); 

		for(int i=0;i<params.length;i++) 
		{
			al.add(params[i]);
			System.out.print(params[i] + ",");
		}	
		Collections.sort(al, new CompareInt1());
		
		System.out.println("Sorting now \n");
		
		for(int i=0;i<al.size();i++) 
		{
			System.out.print(al.get(i) + ",");
		}	
	}

	public boolean checkPalindrome(String abc)
	{
		StringBuffer sb=new StringBuffer();
		for(int i=abc.length();i>0;i--)
		{
			sb.append(abc.charAt(i-1));			
		}
		
		return abc.equals(sb.toString());
	}
	
    // Function to get slice of a primitive array in Java
    public int[] getSliceOfArray(int[] arr,
                                        int start, int end)
    {
 
        // Get the slice of the Array
        int[] slice = new int[end - start];
 
        // Copy elements of arr to slice
        for (int i = 0; i < slice.length; i++) {
            slice[i] = arr[start + i];
            System.out.print(slice[i]+",");
        }
        System.out.println("");
        // return the slice
        return slice;
    }	
	

}

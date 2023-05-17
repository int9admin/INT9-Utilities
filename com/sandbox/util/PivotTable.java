package com.sandbox.util;

import java.util.stream.IntStream;

/**
 * Implementation to find the minimum number from a sorted array of int's. 
 * The array need to be sorted but can be rotated for however many positions. 
 * 
 * Designed and developed using binary search logic
 * 
 * 
 * 
 * @author Balaji
 *
 */

public class PivotTable {
	public static void main(String[] args)
	{

		
//		int j=0;
//		int limit=100;
//		int[] afterPivot5=new int[limit];
//		for(int i=0;i<limit/2;i++)
//		{
//			afterPivot5[j++]=i%10;
//		}
		PivotTable abc=new PivotTable();
//		abc.printMinimumElementAndPosition(afterPivot5);
		
		int[] beforePivot = { 1,2,3,4,5,6,7};
		int[] afterPivot1 = { 5,6,7,1,2,3,4};
		int[] afterPivot2 = { 4,5,6,7,1,2,3};
		int[] afterPivot3 = { 6,7,1,2,3,4,5};
		int[] afterPivot4 = { 11,12,13,14,15,1,2,3,4,5,6,7,8,9,10};
		
		
		abc.printMinimumElementAndPosition(afterPivot4);
		abc.printMinimumElementAndPosition(afterPivot3);
		abc.printMinimumElementAndPosition(afterPivot2);
		abc.printMinimumElementAndPosition(afterPivot1);


	}
	
	public void printMinimumElementAndPosition(int[] arr)
	{
		int[] minValue;int position;
		
		System.out.println("**** Start ***");	
        IntStream.range(0, arr.length).forEach(k->System.out.print(arr[k]+","));
        minValue=this.binarySearch2( arr,0,arr[0]);
        position=minValue[1];

        System.out.println("\nMinimum value is "+ minValue[0] +" and the position is ->"+(Math.abs(position)+1));
        System.out.println("**** End ***\n\n");
	}
	
	public int[] binarySearch2(int[] list, int index, int firstElement) //int value, int[] list)
	{
		sout("\n*"); 
		int startIndex=index;
		int start =1;
		int end = list.length;		
		int middlePosition = (start + end) / 2; //mid = 3, 	
		sout("\nIndex ->" + index);
		
		int[] returnValue= {-1,-1};
		
		if(list.length==1) 
		{
			sout("only one element ->" + index);
			
			return new int[]{list[0],startIndex};
		}
		if(list.length==2)
		{
			sout("only two elements ->"+startIndex);
			return (list[0]>list[1] ? new int[] {list[1],index+1}:new int[] {list[0],startIndex});
		}
		
		if(list[middlePosition] > list[middlePosition-1] && list[middlePosition] > list[middlePosition+1])  //
		{
			sout("minimum on the right side: index->"+index+", index+middlepostion->"+(index+middlePosition) );
			returnValue=this.binarySearch2(this.getSliceOfArray(list, middlePosition, end), (index * (list[0]==firstElement ? -1:1))+middlePosition ,list[0]);
		}		
		else if (list[middlePosition] < list[middlePosition-1] && list[middlePosition] < list[middlePosition+1])
		{
			
			sout("minimum is the middle element: " + list[middlePosition] + "<" +list[middlePosition-1] + " && " + list[middlePosition] +"<"+ list[middlePosition+1] );
			return new int[] {list[middlePosition],index-middlePosition};
		}
		else
		{
			sout("minimum on the left side: index->"+index+ (index==0?",middleposition->"+middlePosition:",index-middlePosition->"+(index-middlePosition)));
			returnValue=this.binarySearch2(this.getSliceOfArray(list, 0, middlePosition),(index * (list[0]==firstElement? -1:1)), list[0]);
		}
		
		return returnValue;
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
            sout(slice[i]+",");
        }
        //System.out.println("");
        // return the slice
        return slice;
    }	
	
	public void sout(String abc)
	{
		//System.out.println(abc);
	}
}

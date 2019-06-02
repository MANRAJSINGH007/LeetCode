import java.util.*;
class Trip implements Comparable<Trip>{
    int x;
    int y;
    int distance;
    
    public int compareTo(Trip t)
    {
        return (this.distance-t.distance);
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        int n=points.length;
        if(n==0)
        {
            return new int[0][0];
        }
        Trip arr[]=new Trip[n];
        
        for(int i=0;i<n;i++)
        {
            arr[i]=new Trip();
            arr[i].x=points[i][0];
            arr[i].y=points[i][1];
            arr[i].distance=(int)(Math.pow(points[i][0],2)+Math.pow(points[i][1],2));
            
        }
        
        Arrays.sort(arr);
        int brr[][]=new int[k][2];
        for(int i=0;i<k;i++)
        {
            Trip obj=arr[i];
            brr[i][0]=obj.x;
            brr[i][1]=obj.y;
        }
        
        return brr;
    }
}

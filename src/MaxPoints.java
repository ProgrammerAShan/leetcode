import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.omg.CORBA.PUBLIC_MEMBER;

//Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
public class MaxPoints {
	
	
	
	 static class Point {
	     int x;
	     int y;
	     Point() { x = 0; y = 0; }
	     Point(int a, int b) { x = a; y = b; }
	 }
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	
		Point aPoint=new Point(3,10);
		Point bPoint=new Point(0,2);
		Point cPoint=new Point(0,2);
		Point dPoint=new Point(3,10);
		Point[] points={aPoint,bPoint,cPoint,dPoint};
		int result=maxPoints(points);
		System.out.println(Integer.toString(result));
		}
	
    
    public static int maxPoints(Point[] points)
    {
    int maxLine = 0;  
    
    if(points.length<=2)  
        return points.length;  

    for (int i=0; i<points.length-1; i++) {  
        int coincident = 0;  
        int h = 0; 
        int max=0;
        Map<Double, Integer> pointCounts=new HashMap<>();  
        
        for (int j=i+1; j<points.length; j++) {  
            double slope;  
            if (points[i].x==points[j].x && points[i].y==points[j].y) {  
                coincident++;//考虑重复元素，直接在每一条包含该点的直线上都加1  
                continue;  
            } else if (points[i].x == points[j].x) {  
                h++;//对于斜率不存在的情况，特殊处理  
                continue;  
            } else if (points[i].y == points[j].y) {  
                slope = 0.0; // double类型分正0与负0，在计算机内的表示不一样，故需要在此特别标明  
            } else {  
                slope = (double)(points[i].y-points[j].y) / (points[i].x-points[j].x);  
            }  
              
            if(pointCounts.containsKey(slope))
            {
            	int value=pointCounts.get(slope);
            	pointCounts.put(slope, value+1);
            	max=max>(value+1)?max:(value+1);
            }
            else  
                pointCounts.put(slope,1);  
                max=max>1?max:1;
        }  
        coincident++;//将索引为i的元素计算在内  
 //       h = h + coincident;//计算重复元素  
        if(max<h)
        	max=h;
        h=max+coincident;
        if(maxLine < h)  
            maxLine = h;  
    }  
    return maxLine;
    }

}

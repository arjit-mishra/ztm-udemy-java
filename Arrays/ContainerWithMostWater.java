class ContainerWithMostWater {
    public static void main(String[] args) {
      int[] height = {7,1,2,3,9};
      System.out.println("Brute force "+getArea(height));
      System.out.println("Optimized "+getAreaOptimized(height));
    }
  
    public static int getArea(int[] height){
  
      int maxArea = 0;
  
      for(int i=0; i<height.length; i++)
        for(int j=i+1; j<height.length; j++)
          maxArea = Math.max(maxArea,
                            Math.min(height[i], height[j]) * (j-i));
      return maxArea;
    }
  
      public static int getAreaOptimized(int[] height){
  
      int maxArea = 0;
      int i=0, j=height.length - 1;
      while(i<j){
          maxArea = Math.max(maxArea,
                            Math.min(height[i], height[j]) * (j-i));
          if(height[i] < height[j]) 
            i++ ;
          else
            j--;
      }
      return maxArea;
    }
    
  }

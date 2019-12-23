package testPackage;

import org.testng.annotations.Test;

public class testClass {

	@Test(priority=1)
	public void test() {
		
		System.out.println("hello world");
	}
	

    @Test(priority=2)
    public void arraySum() {
	int [] arr= {5,5,4,23,6};
	int sum=0;
	int i;
	
	for (i=0;i<arr.length;i++) {
		sum=sum+arr[i];
		}
	System.out.println("sum of array:"+sum);
		
	}
    
    @Test(priority=3)
    
    public void add() {
    int x=1;
    int y=3;
    int z;
    z= x+y;
    System.out.println("sum of no:"+ z);
    }
        
    }
    

package com.prac;

public class SherlockDecentNumber {

	public static void main(String[] args) {
		int n = 14;
		
		String ks=null;
        for(int j=n;j>=0;j--)
        {
            if(j%3==0 && (n-j)%5==0)
            {
                ks="";
                for(int k=0;k<j;k++)
                    ks+='5';
                for(int k=0;k<n-j;k++)
                    ks+='3';
                break;
            }
        }
        if(ks=="")
            System.out.println("-1\n");
        else
            System.out.println(ks);

		/*if (num < 3) {
			System.out.println("\n" + -1);
			System.exit(0);
		}

		int three=0;
		int five=0;
		
		while (num > 2) {

			if(num >= 3){
				num =num-3;
				three++;
			}
			
			if(num >= 5){
				num =num-5;
				five++;
			}
			
		}
		
		printBeast(5, 3 * three);
		printBeast(3, 5 * five);
*/
	}

	public static void printBeast(int valueToPrint, int time) {
		for (int i = 0; i < time; i++) {
			System.out.print(valueToPrint);
		}
	}

}

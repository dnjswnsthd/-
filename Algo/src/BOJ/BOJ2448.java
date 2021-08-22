package BOJ;

import java.util.*;

public class BOJ2448{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int i,k,j,z;
		String dp[] = new String[n+1];
		k=(int)(Math.log(n/3) / Math.log(2));
		dp[1] = "  *  ";
		dp[2] = " * * ";
		dp[3] = "*****";
		int height = 3;
		for(i=1; i<=k; i++)
		{
			for(j=1; j<=height; j++)
			{
				dp[height + j] = dp[j] + " " + dp[j];
				for(z=1; z<=height/3; z++)
					dp[j] = "   " +dp[j]+ "   ";
			}
			height*=2;
		}
			for(i=1; i<=n; i++)
				System.out.println(dp[i]);
	}
}
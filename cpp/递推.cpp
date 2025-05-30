#include<stdio.h>
#include<math.h>
#include<stdbool.h>
#define MAX  100

//最暴力的dfs --> 记忆化搜索 --> 递推(dp) 
//记忆化搜索=暴力dfs+记录答案
//递推的公式=dfs向下递归的公式  递推数组的初始值 = 递归的边界，递归的出口 

int n=0;
int f[MAX]={0};

int main()
{
	scanf("%d",&n);
	f[1]=1,f[2]=2;
	
	if(n==1||n==2){
		printf("%d",f[n]);
		return 0;
	}
	for(int i=3;i<=n;i++){
		f[i]=f[i-1]+f[i-2];		//这个递推公式就是dfs的转态转移公式,向下递归的公式 
		
	}

	printf("%d ",f[n]);
	return 0;
}

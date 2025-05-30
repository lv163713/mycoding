#include<stdio.h>
#include<math.h>
#include<stdbool.h>
#include<stdlib.h>
#include<string.h>
#define MAX  100010
int T=0,n=0;	//T表示有多少组数据，n表示一共有多少店铺
int stop[MAX]={0};
int money=0;	//记录拿到最多的钱 
int st[MAX]={0};	//记录哪家店铺选中了 

int f[MAX]={0};		//dp

int mem[MAX]={0};	//mem[i]存的是从第i个 店铺开始之后能获得的最大的金额 


//记忆化搜索优化，要是想执行记忆化搜索，dfs中的参数要尽可能的少，
//不应该把没有影响到边界的参数放进来，函数的参数一样，结果就一样，把这个存起来			 
//想要减枝，就是要把能减枝的参数给加进去 
int max(int a, int b) {
    return a > b ? a : b;
}

/*
void dfs(int x)//x表示店铺号 
{
	if(x>n){
		int sum=0;
		for(int i=1;i<=n;i++){
			if(st[i]){
				sum+=stop[i];
			}
		}
		if(sum>money){
			money=sum;
		}
		return ;
	}		
	st[x]=1;
	dfs(x+2);
	st[x]=0;
	dfs(x+1);
	st[x]=0;
}
*/
/*
int dfs(int x){
	if(mem[x])	return mem[x];

	int sum=0;
	if(x>n){
		sum=0;
	}
	else{
		sum = max(dfs(x+1),dfs(x+2)+stop[x]);
	}
	mem[x]=sum;
	return sum;
}*/

//dfs 记忆化搜索 倒序dp 正序dp 空间优化 
int main()
{
	scanf("%d",&T);
	while(T--){
		scanf("%d",&n);
		for(int j=1;j<=n;j++){
			scanf("%d",&stop[j]);
		}
		memset(f,0,sizeof(f));
		
		//dp动态规划
		/*
		for(int i=n;i>=1;i--){
			f[i]=max(f[i+1],f[i+2]+stop[i]);
		}
		printf("%d",f[1]);*/
		int newf=0,tmp1=0,tmp2=0; 
		for(int i=1;i<=n;i++){
			newf=max(tmp1,tmp2+stop[i]);
			tmp2=tmp1;
			tmp1=newf;
		}
		printf("%d",newf);
		
		
		/*memset(mem,0,sizeof(mem));
		money=dfs(1);
		printf("%d\n",money);*/
	}
	
	return 0;
}

#include<stdio.h>
#define N 100010

long long n,k,t,ans;
long long  s[N];	//用于存前缀和取模后的值
long long  arr[N];	//用于存同模出现的次数 

int main()
{
	scanf("%lld %lld",&n,&k);
	for(int i=1;i<=n;i++){
		scanf("%lld",&t);
		s[i]=(s[i-1]+t)%k; 
	}
	
	for(int i=0;i<=n;i++){
		ans+=arr[s[i]]++;
	} 
	printf("%lld",ans);	
	return 0;
}

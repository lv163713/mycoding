#include<stdio.h>
#define N 100010

long long n,k,t,ans;
long long  s[N];	//���ڴ�ǰ׺��ȡģ���ֵ
long long  arr[N];	//���ڴ�ͬģ���ֵĴ��� 

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

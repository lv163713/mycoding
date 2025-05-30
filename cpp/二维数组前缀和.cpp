#include<stdio.h>

int n=0,sum=0;
int a.b.c.d;
int arr[10010][10010];
int s[10010][10010];

int main()
{
	scanf("%d",&n);
	for(int i=1;i<n;i++){
		for(int j=1;j<n;j++){
			scanf("%d",&arr[i][j]);
			s[i][j]=arr[i][j]+s[i-1][j]+s[i][j-1]-s[i-1][j-1];
		}
	}	 
	scanf("%d %d %d %d",&a,&b,&c,&d);
	for(int i=a;i<b;i++){
		for(int j=c;j<d;j++){
			sum+=arr[i][j];
		}
	}
	printf("%d",sum);
	return 0;
} 

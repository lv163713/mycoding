#include<stdio.h>
#include<Windows.h>
long long a[100];

int main()
{
	
	int ans=0;
	for(;;){
		printf("%d\n",ans++);
		Sleep(2000);
		if(ans>3){
			break;
		}
	} 
	printf("%d",ans);
	return 0;
}

#include <stdio.h>



int main(){
	
	
	int T;
	scanf("%d",&T);
	
	int A,B;
    int i,k;
	int sum[T];
	
	for(i=0; i<T; i++){
		
		scanf("%d %d ",&A,&B);
	  
		sum[i]=A+B;
		
	   
	    
	}
	
	 for(k=0; k<T; k++){
		
	 printf("%d \n",sum[k]);
		
		
	}	
	
	
	return 0;
	
	
	
}
#include <iostream>


int main(){
    
    int n,i=0;
	std::string a;

	std::cin >> n;


    while (i<(n / 4)) {

		a += "long ";
		
		i++;

	}
	std::cout << a+"int" << std::endl;
    
    return 0;
}
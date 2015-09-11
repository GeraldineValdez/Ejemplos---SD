#include  <stdio.h>
#include  <sys/time.h> 

int main (int argc, char *argv[]) 
{
    double area,x;
    int i,n;
    area = 0.0;
    printf("n="); scanf("%d",&n);
    #pragma omp parallel for private(x) reduction(+:area)
    for (i=0;i<n;i++) 
    {     x=(i+0.5)/n; 
          area += 4.0/(1.0+x*x);
    }
    printf("pi = %lf\n", area/n);
    return 0; 
}

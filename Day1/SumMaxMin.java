public class SumMaxMin{

public static void main(String[] args){

int sum=0, max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;

for(int i=0;i<args.length;i++){
int val=Integer.parseInt(args[i]);
sum+=val;
if(val < min)
	min=val;
if(val > max)
	max=val;

}

System.out.println("Sum ="+sum);
System.out.println("Max ="+max);
System.out.println("Min ="+min);



}

}
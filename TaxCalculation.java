public class TaxCalculation{

public static void main(String[] args){

long price=Integer.parseInt(args[1]);
int tax=0;

switch(args[0]){

case "KA":
	tax=10;
break;

case "TN":
	tax=20;
break;

case "KL":
	tax=30;
break;

case "PN":
	tax=40;
break;

case "HP":
	tax=33;
break;
default: tax=5;

}

price+=(price*10/100);

System.out.println("State ="+args[0]);
System.out.println("Total price ="+price);

}

}
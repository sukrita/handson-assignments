public class Result{

public static void main(String[] args){

int marks=Integer.parseInt(args[0]);
String status="Fail";

if(marks >= 70)
	status="First Class Distinction";
else if(marks >= 60)
	status="First Class";
else if(marks >= 50)
	status="Second Class";
else if(marks >= 35)
	status="Pass";
else
	status="Fail";

System.out.println(status);

}

}
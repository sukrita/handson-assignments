class Address{
String state, city;
int pin;

Address(String state, String city, int pin){

this.state = state;
this.city = city;
this.pin = pin;


}

void display(){
System.out.println("Address: "+ state+" "+city+" "+pin);
System.out.println("--------------------------------------------");

}

}
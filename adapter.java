public class Volt
{
 private int volts;

 public Volt( int v )
 {
 this.volts = v;
 }

 public int getVolts()
 {
 return volts;
 }

 public void setVolts( int volts )
 {
 this.volts = volts;
 }
}
public class ElectricSocket
{
 public Volt getVolt()
 {
 return new Volt(120);
 }
}
public interface ITarget
{
 public Volt get9Volt();
}
public class MobilePhoneCharger implements ITarget
{

 private ElectricSocket electricSocket = new ElectricSocket();

 @Override
 public Volt get9Volt()
 {
 Volt volt = electricSocket.getVolt();
 System.out.println("From ElectricSocket MobilePhoneCharger got :" +volt.getVolts() + "v");
 Volt convertedVolt=convertVolt(volt,13);
 System.out.println("\nMobilePhoneCharger converterd "+volt.getVolts()+"v to "+convertedVolt.getVolts()+"v\n");
 return convertedVolt;
 }
 
 private Volt convertVolt(Volt v, int i)
  {
         return new Volt(v.getVolts()/i);
 }

}
public class MobilePhone
{

 public static void main(String args[])
 {
 new MobilePhone().chargeMe();
 }
 
 public void chargeMe()
 {
 ITarget target = new MobilePhoneCharger();
 Volt volt=target.get9Volt();
 System.out.println("Mobile phone is charging using : "+volt.getVolts() + "v");
 }
}
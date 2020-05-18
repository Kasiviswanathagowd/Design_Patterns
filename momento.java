public class LedTV
{
 private String  size;
 private String  price;
 private boolean usbSupport;

 public LedTV( String size, String price, boolean usbSupport )
 {
 super();
 this.size = size;
 this.price = price;
 this.usbSupport = usbSupport;
 }

 public String getSize()
 {
 return size;
 }

 public void setSize( String size )
 {
 this.size = size;
 }

 public String getPrice()
 {
 return price;
 }

 public void setPrice( String price )
 {
 this.price = price;
 }

 public boolean isUsbSupport()
 {
 return usbSupport;
 }

 public void setUsbSupport( boolean usbSupport )
 {
 this.usbSupport = usbSupport;
 }

 @Override
 public String toString()
 {
 return "LedTV [size=" + size + ", price=" + price + ", usbSupport=" + usbSupport + "]";
 }

}

public class Memento
{
 private LedTV ledTV;

 public Memento( LedTV ledTV )
 {
 super();
 this.ledTV = ledTV;
 }

 public LedTV getLedTV()
 {
 return ledTV;
 }

 public void setLedTV( LedTV ledTV )
 {
 this.ledTV = ledTV;
 }

 @Override
        public String toString()
        {
         return "Memento [ledTV=" + ledTV + "]";
        }

 
 
}
import java.util.ArrayList;
import java.util.List;
public class Caretaker
{
 private List<Memento> ledTvList = new ArrayList<Memento>();

 public void addMemento( Memento m )
 {
 ledTvList.add(m);
 System.out.println("LED TV's snapshots Maintained by CareTaker :" + ledTvList);
 }

 public Memento getMemento( int index )
 {
 return ledTvList.get(index);
 }
}
public class Originator
{
 LedTV ledTV;

 public LedTV getLedTV()
 {
 return ledTV;
 }

 public void setLedTV( LedTV ledTV )
 {
 this.ledTV = ledTV;
 }

 public Memento createMemento()
 {
 return new Memento(ledTV);
 }

 public void setMemento( Memento memento )
 {
 ledTV = memento.getLedTV();
 }

 @Override
        public String toString()
        {
         return "Originator [ledTV=" + ledTV + "]";
        }

 
 
}

public class MementoClient
{

 public static void main( String[] args )
 {
 Originator originator = new Originator();
 originator.setLedTV(new LedTV("42 inch", "60000Rs", false));

 Caretaker caretaker = new Caretaker();
 caretaker.addMemento(originator.createMemento());

 originator.setLedTV(new LedTV("46 inch", "80000Rs", true));
 caretaker.addMemento(originator.createMemento());

 originator.setLedTV(new LedTV("50 inch", "100000Rs", true));
 
 System.out.println("\nOrignator current state : " + originator);

 System.out.println("\nOriginator restoring to 42 inch LED TV...");

 originator.setMemento(caretaker.getMemento(0));

 System.out.println("\nOrignator current state : " + originator);

 }

}
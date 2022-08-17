package p08.polymorphism4;

public class HankookTIre extends Tire{
	
	public HankookTIre(String location, int maxRatation) {
		super(location, maxRatation);
	}
	
	@Override
	 public boolean roll() {
		 ++ accumulatedRotation;
		 
		 if(accumulatedRotation < maxRotation) {
			 System.out.println(location + " HankookTire 수명: "
					 	+ (maxRotation - accumulatedRotation) + "회");
			 return true;
		 }else {
			 System.out.println("***"+location +" Tire 펑크 ***");
			 return false;
		 }
	 }
}

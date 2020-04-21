
public class Camera {
	private double x,y;
	private Handler handler;
	public Camera(double x, double y,Handler handler) {
		this.x=x;
		this.y=y;
		this.handler=handler;
		
	}
	
	public void getTick(GameObject object) {
		x+=((object.getX()-x)-1000/2)*0.05;
		y+=((object.getY()-y)-563/2)*0.05;
		if(x<0) {
			x=0;
		}
		if(x>1054) {
			x=1054;
		}
		if(y<0) {
			y=0;
		}
		
		if(y>=686) {
			y=686;
		}
	}
	
	public void tick() {
		for(GameObject obj:handler.getList()) {
			if(obj.id.equals(ID.Player)) {
				this.getTick(obj);
			}
		}
	}
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		
		return this.y;
	}
}

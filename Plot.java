public class Plot {
    private int x;
    private int y;
    private int width;
    private int depth;

    public Plot() {
        this.x = 0;
        this.y = 0;
        this.width = 1;
        this.depth = 1;
    }
// constructor with coordinates as parameters
    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    public Plot(Plot other) {
    	 this(other.x, other.y, other.width, other.depth);
    } 
  

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public boolean overlaps(Plot plot) {
		if (((x >= plot.x && x <= (plot.x + plot.width)) && (y >= plot.y && y <= (plot.y + plot.depth))) ||
		        ((x + width >= plot.x && x + width <= (plot.x + plot.width)) && (y >= plot.y && y <= (plot.y + plot.depth))) ||
		        ((x >= plot.x && x <= (plot.x + plot.width)) && (y + depth >= plot.y && y + depth <= (plot.y + plot.depth))) ||
		        ((x + width >= plot.x && x + width <= (plot.x + plot.width)) && (y + depth >= plot.y && y + depth <= (plot.y + plot.depth)))) {
		        return true;
		    } else if (((plot.x >= x && plot.x <= (x + width)) && (plot.y >= y && plot.y <= (y + depth))) ||
		               ((plot.x + plot.width >= x && plot.x + plot.width <= (x + width)) && (plot.y >= y && plot.y <= (y + depth))) ||
		               ((plot.x >= x && plot.x <= (x + width)) && (plot.y + plot.depth >= y && plot.y + plot.depth <= (y + depth))) ||
		               ((plot.x + plot.width >= x && plot.x + plot.width <= (x + width)) && (plot.y + plot.depth >= y && plot.y + plot.depth <= (y + depth)))) {
		        return true;
		    }
		    return false;
	}

	public boolean encompasses(Plot plot) {
	    if ((plot.x >= x && plot.x <= (x + width)) &&
	        (plot.y >= y && plot.y <= (y + depth)) &&
	        ((plot.x + plot.width) >= x && (plot.x + plot.width) <= (x + width)) &&
	        ((plot.y + plot.depth) >= y && (plot.y + plot.depth) <= (y + depth))) {
	        return true;
	    }
	    return false;
	}	

	@Override
	public String toString() {
	    return x + "," + y + "," + width + "," + depth;
	}
	
}




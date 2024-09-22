// Name: Niki Zheng
// ID number: B00932128
public class Exercise2 {
    //instance variables
    private int xpos, ypos, width, height;
    //constructors
    // why do we need two Exercise2(){}
    public Exercise2() {}
    public Exercise2(int xpos, int ypos, int width, int height) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.width = width;
        this.height = height;
    }

    //setters and getters
    public void setX(int xpos){this.xpos=xpos;}
    public void setY(int ypos){this.ypos=ypos;}
    public void setWidth(int width){this.width=width;}
    public void setHeight(int height){this.height=height;}
    public int getX(){return xpos;}
    public int getY(){return ypos;}
    public int getWidth(){return width;}
    public int getHeight(){return height;}
    //other methods: moveTo changes xpos and ypos and resize changes
//width and height
    public void moveTo(int xpos, int ypos){this.xpos=xpos; this.ypos=ypos;}
    public void resize(int width, int height){this.width=width; this.height=height;}
    // toString method that returns the rectangle's details in the format
//(xpos, ypos, width, height)
    public String toString() {
        return "(" + xpos + ", " + ypos + ", " + width + ", " + height + ")";
    }
    //contains method: returns true if a point (px, py) is contained within this rectangle
//contains also returns true if the point touches the rectangle
    public boolean contains(int px, int py)
    {
        return (px>=xpos && px<=xpos+width && py>=ypos && py<= ypos+height);
    }
    //contains method: returns true if another rectangle r is contained within this rectangle
//returns true if the rectangle touches the boundaries
//it uses the point contains method
    public boolean contains(Exercise2 r)
    {
        return(this.contains(r.getX(),r.getY())&&
                this.contains(r.getX() + r.getWidth(), r.getY()+r.getHeight()));
    }

    // add if touches
    public boolean touches(int px, int py) {
        // modify if contains to check if the point is on the upper and lower boundaries of the rectangle
        boolean onTopOrBottom = (px >= xpos && px <= xpos + width) && (py == ypos || py == ypos + height);

        // Check if the point is on the left and right boundaries of the rectangle
        boolean onLeftOrRight = (py >= ypos && py <= ypos + height) && (px == xpos || px == xpos + width);

        // check if on boundaries
        if (onTopOrBottom || onLeftOrRight) {
            return true;
        } else {
            return false;
        }
    }
    public boolean touches(Exercise2 r) {
        // Check that the four corners of r are in contact with the boundaries of the current rectangle.
        boolean topLeftTouches = this.touches(r.getX(), r.getY());

        boolean topRightTouches = this.touches(r.getX() + r.getWidth(), r.getY());

        boolean bottomLeftTouches = this.touches(r.getX(), r.getY() + r.getHeight());

        boolean bottomRightTouches = this.touches(r.getX() + r.getWidth(), r.getY() + r.getHeight());
        //determine
        if (topLeftTouches == true) {
            return true;
        } else if (topRightTouches) {
            return true;
        } else if (bottomLeftTouches) {
            return true;
        } else if (bottomRightTouches) {
            return true;
        } else {
            return false;
        }
    }
    public boolean overlaps(int px, int py) {
        // TODO: check if inside but do i need =?
        return (px > xpos && px < xpos + width && py > ypos && py < ypos + height);
    }
    public boolean overlaps(Exercise2 r) {
        // modify if contains to ccheck four points
        boolean topLeftOverlaps = this.overlaps(r.getX(), r.getY());
        boolean topRightOverlaps = this.overlaps(r.getX() + r.getWidth(), r.getY());
        boolean bottomLeftOverlaps = this.overlaps(r.getX(), r.getY() + r.getHeight());
        boolean bottomRightOverlaps = this.overlaps(r.getX() + r.getWidth(), r.getY() + r.getHeight());
        //determine
        if (topLeftOverlaps == true || topRightOverlaps == true || bottomLeftOverlaps == true ||bottomRightOverlaps == true) {
            return true;
        } else {
            return false;
        }
    }

}

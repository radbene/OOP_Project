package agh.ics.oop.model;

public abstract class Globe implements WorldMap {
    // FIXME: This class should be abstract
    private Vector2d lowerLeft, upperRight; // 0,0 to size.x, size.y

    public Move nextPosition(Move mv) {
        Vector2d newPos = mv.getPosition().add(mv.getOrientation());
        MapDirection newDir = mv.getDirection();
        if(newPos.getY() < 0) {
            return new Move(new Vector2d(newPos.getX(), 0), newDir.opposite());
        }
        if(newPos.getY() > upperRight.getY()) {
            return new Move(new Vector2d(newPos.getX(), upperRight.getY()), newDir.opposite());
        }
        if(newPos.getX() < 0) {
            return new Move(new Vector2d(upperRight.getX(), newPos.getY()), newDir);
        }
        if(newPos.getX() > upperRight.getX()) {
            return new Move(new Vector2d(0, newPos.getY()), newDir);
        }
        return new Move(newPos, newDir);
    }
}

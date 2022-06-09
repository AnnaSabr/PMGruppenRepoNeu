package desktop;

public abstract class Quest extends Entity {

    Point position;

    boolean accepted = false;

    String questTask;

    String questReward;

    /**
     * A object that can be controlled by the <code>EntityController
     * </code>.
     *
     * @param painter Painter that draws this object
     * @param batch   Batch to draw on
     */
    public Quest(Painter painter, SpriteBatch batch) {
        super(painter, batch);
    }

    @Override
    public Point getPosition() {
        return position;
    }

    public void setLevel(Level currentLevel) {
    }


}

package game.asteroids;

import org.joml.Vector2f;
import org.joml.Vector3f;
import game.asteroids.entities.*;
import game.AsteroidsGame;

public class FiringBehaviours{
  public static Behavior getNormalBulletBehaviour(){
    return (Behavior)(new normalBulletBehaviour());
  }

  public static class normalBulletBehaviour extends Behavior{
    public void execute(){
      PlayerBullet pb = new PlayerBullet(AsteroidsGame.getGame().getPlayer(), new Vector3f(location, 0.0f), target);
      AsteroidsGame.getGame().addEntity(pb);
    }
  }

  public static class spawnAsteroidBehaviour extends Behavior{
    public void execute(){
      AsteroidsGame.getGame().addEntity(
        AsteroidFactory.createLargeAsteroidWithinBounds(AsteroidsGame.GAME_BOUNDS_MIN_X,
                                                        AsteroidsGame.GAME_BOUNDS_MIN_Y,
                                                        AsteroidsGame.GAME_BOUNDS_MAX_X,
                                                        AsteroidsGame.GAME_BOUNDS_MAX_Y)
      );
    }
  }
}
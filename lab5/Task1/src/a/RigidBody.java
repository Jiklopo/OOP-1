package a;

public interface RigidBody {
	void collide(Object o);
	void onCollision();
	void move(Vector v);
}

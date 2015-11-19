package sirs.model;

public class GarbageTruck {
	private Long id;
	private String type;
	private float capacity;
	private float weight;
	
	public void setId(Long id) { this.id = id; }
	public void setType(String type) { this.type = type; }
	public void setCapacity(float capacity) { this.capacity = capacity; }
	public void setWeight(float weight) { this.weight = weight; }
	
	public Long getId() { return id; }
	public String getType() { return type; }
	public float getCapacity() { return capacity; }
	public float getWeight() { return weight; }
}

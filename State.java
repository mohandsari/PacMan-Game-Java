package prototype;

public enum State {
	Normal(0), Invisible(5000), Super(5000);
	@SuppressWarnings("unused")
	private int time;
	
	State(int time) {
		this.time = time;
	}
}

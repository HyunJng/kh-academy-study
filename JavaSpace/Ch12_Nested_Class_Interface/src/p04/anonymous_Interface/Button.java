package p04.anonymous_Interface;

public class Button {
	OnClickListener listener;	// onClick을 구현한 자식 인스턴스를 받아옴.
	
	public void setListener(OnClickListener listener) {
		this.listener = listener;
	}

	void touch() {
		listener.onClick();
	}
	
	interface OnClickListener{
		void onClick();
	}
}

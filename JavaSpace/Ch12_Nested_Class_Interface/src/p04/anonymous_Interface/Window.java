package p04.anonymous_Interface;

public class Window {
	Button btn1 = new Button();
	Button btn2 = new Button();

	// Interface의 익명객체
	Button.OnClickListener listener = new Button.OnClickListener() {
		@Override
		public void onClick() {
			System.out.println("전화를 겁니다.");

		}
	};

	public Window() {
		btn1.setListener(listener);

		btn2.setListener(new Button.OnClickListener() {

			@Override
			public void onClick() {
				System.out.println("메세지를 보냅니다.");
			}
		});
	}

}

package dto;

//Java Bean : form tag에서 입력된 value를 하나의 class로 관리한다. 
// Web application model관점에서는 DTO(Data Transfer Object) 혹은 VO(Value Object)라고 부름
public class Book {
	private String id;
	private String title;
	private String publisher;
	private int price;
	
	// default constructor
	public Book() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}

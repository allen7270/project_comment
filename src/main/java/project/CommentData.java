package project;

public class CommentData {
	private String url, comment;
	public CommentData(String url, String comment) {
		this.url= url;
		this.comment= comment;
	}
	public CommentData() {
	}
	public String getComment() {
		return comment;
	}
	public String getUrl() {
		return url;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}

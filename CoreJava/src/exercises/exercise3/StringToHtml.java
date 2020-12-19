package exercises.exercise3;

public class StringToHtml {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		sb.append("<!DOCTYPE html>\n");
		sb.append("<html>\n");
		sb.append("<head>\n");
		sb.append("<meta content=\"text/html; charset=UTF-8\">\n");
		sb.append("<title>$title</title>\n");
		sb.append("</head>\n");
		sb.append("<body>\n$body</body>\n");
		sb.append("</html>");
		String template = sb.toString();
		
		System.out.println(constructHtml(template, "Tiger 1", "https://www.scalemates.com/products/img/8/5/8/129858-10911-pristine.jpg"));

	}

	private static String constructHtml(String template, String title, String imgUrl) {
		StringBuilder body = new StringBuilder();
		body.append("<div style=\"text-align:center;\">\n");
		body.append("<h1>" + title + "</h1>\n<hr>\n");
		body.append("<img src=\"" + imgUrl + "\">\n");
		body.append("</div>\n");

		String result = template.replace("$title", title).replace("$body", body.toString());

		return result;
	}
}

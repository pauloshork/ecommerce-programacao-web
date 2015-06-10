package main.java.br.ufla.ecommerce.views;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class BasePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public BasePage(final PageParameters parameters) {
		super(parameters);
		
		add(new BookmarkablePageLink("header", Header.class));
		add(new BookmarkablePageLink("footer", Footer.class));
		
    }
}

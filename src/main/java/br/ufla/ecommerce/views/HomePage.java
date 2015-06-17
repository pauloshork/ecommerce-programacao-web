package br.ufla.ecommerce.views;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import br.ufla.ecommerce.models.*;

public class HomePage extends BasePage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);
    }
	
	@Override
	public void initialize() {
		super.initialize();
		
		Produto prod = new Produto();
		prod.setNome("Produto de teste");
		prod.setPreco(123.45f);
		prod.setDescricao("Destrição do produto de teste");
		prod.setQuantidadeEstoque(5);
		
		Panel p = new DisplayProdutoPanel("produto-teste", Model.of(prod));
		
		add(p);
	}
}

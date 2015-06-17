package br.ufla.ecommerce.views;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

public class DisplayProdutoPanel extends Panel {

	private static final long serialVersionUID = 1L;

	public DisplayProdutoPanel(String id, IModel<?> model) {
		super(id, model);
		Label nome_prod = new Label("nome-prod", PropertyModel.of(getDefaultModelObject(), "nome"));
		Label preco_prod = new Label("preco-prod", PropertyModel.of(getDefaultModelObject(), "preco"));
		Label desc_prod = new Label("desc-prod", PropertyModel.of(getDefaultModelObject(), "descricao"));
		
		add(nome_prod);
		add(preco_prod);
		add(desc_prod);
	}

}
